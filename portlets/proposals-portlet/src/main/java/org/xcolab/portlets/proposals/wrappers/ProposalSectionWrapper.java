package org.xcolab.portlets.proposals.wrappers;

import com.ext.portlet.PlanSectionTypeKeys;
import com.ext.portlet.model.FocusArea;
import com.ext.portlet.model.OntologyTerm;
import com.ext.portlet.model.PlanSectionDefinition;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.ProposalAttribute;
import com.ext.portlet.service.ContestTypeLocalServiceUtil;
import com.ext.portlet.service.FocusAreaLocalServiceUtil;
import com.ext.portlet.service.OntologyTermLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.xcolab.enums.Plurality;
import org.xcolab.utils.HtmlUtil;
import org.xcolab.utils.IdListUtil;
import org.xcolab.utils.LinkUtils;

import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProposalSectionWrapper {

    private final static Log _log = LogFactoryUtil.getLog(ProposalSectionWrapper.class);

    private final PlanSectionDefinition definition;
    private final ProposalWrapper wrappedProposal;

    public ProposalSectionWrapper(PlanSectionDefinition definition, ProposalWrapper wrappedProposal) {
        this.definition = definition;
        this.wrappedProposal = wrappedProposal;
    }

    public String getTitle() {
        return definition.getTitle();
    }

    public String getContent() throws PortalException, SystemException {
        ProposalAttribute attr = getSectionAttribute();

        if (attr == null) {
            return null;
        }
        return attr.getStringValue().trim();
    }

    public String getContentFormatted() throws SystemException, PortalException, URISyntaxException {
        String content = getContent();
        if (content == null) {
            //default text if available
            return (definition!=null && !StringUtils.isEmpty(definition.getDefaultText())) ? definition.getDefaultText() : null;
        }
        Document contentDocument = Jsoup.parse(content.trim());
        contentDocument = HtmlUtil.addNoFollowToLinkTagsInDocument(contentDocument);

        for (Element aTagElements : contentDocument.select("a")) {
        	String curURL = aTagElements.attr("href");
        	final String[] youtubeAddresses = {"http://youtu.be", "https://youtu.be", "http://www.youtube.com",
        			"https://www.youtube.com", "http://youtube.com", "https://youtube.com"};
        	boolean isYoutube = false;
        	for (String youtubePrefix: youtubeAddresses) {
        		if (curURL.startsWith(youtubePrefix)) {
        			isYoutube = true;
        			break;
        		}
        	}
        	if (!isYoutube) {
        		continue;
        	}
        	if (!(aTagElements.hasClass("utube") || aTagElements.text().toLowerCase().startsWith("embed") || aTagElements.text().equalsIgnoreCase("v"))) {
        		// only links with "embed" text or "utube" class should be replaced by an iframe
        		continue;
        	}
        	String videoId = null;
        	if (curURL.indexOf("?") > 0 && curURL.indexOf("v=") > 0) {
        		// legacy url support
                List<NameValuePair> params = URLEncodedUtils.parse(curURL.substring(curURL.indexOf("?") + 1), Charset.defaultCharset());
                for (NameValuePair nvp : params) {
                    if (nvp.getName().equals("v")) {
                    	videoId = nvp.getValue();
                    }
                }
        	} else {
        		final Pattern videoIdPattern = Pattern.compile("\\/([\\p{Alnum}\\-_]{11})");
        		Matcher m = videoIdPattern.matcher(curURL);
        		if (m.find()) {
        			videoId = m.group(1);
        		}
        	}
        	if (videoId != null) {

                aTagElements.after("<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe><br/>");
                aTagElements.remove();
        	}
        }

        // Regex pattern originated from
        // http://stackoverflow.com/questions/1806017/extracting-urls-from-a-text-document-using-java-regular-expressions
        Pattern pattern = Pattern.compile(
                "\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" +
                        "(((\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov" +
                        "|mil|biz|info|mobi|name|aero|jobs|museum" +
                        "|travel|[a-z]{2})))|localhost)(:[\\d]{1,5})?" +
                        "(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?" +
                        "((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" +
                        "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)" +
                        "(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" +
                        "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*" +
                        "(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b");


        for (Element pTagElements : contentDocument.select("p")) {
            // Separate the <p> tags by the space character and process potential URLs
            String html = pTagElements.html();

            // Eliminates weird &nbsp; ASCII val 160 characters
            String text = pTagElements.text().replaceAll("[\\u00A0]", " ");
            String[] words = text.split("\\s");
            for (int i = 0; i < words.length; i++) {
                final String word = words[i];
                final Matcher matcher = pattern.matcher(word);

                // If a match is found create a new <a> tag
                if (matcher.find()) {
                    final String link = word.substring(matcher.start(), matcher.end());
                    final Proposal linkedProposal = LinkUtils.getProposalFromLinkUrl(link);

                    String elementName;
                    if (linkedProposal != null) {
                        elementName = new ProposalWrapper(linkedProposal).getName();
                    } else {
                        elementName = link;
                    }

                    String newLinkElementWithNoFollow = HtmlUtil.createLink(link, elementName);
                    // Replace exactly this word in the HTML code with leading and trailing spaces
                    if (words.length == 1) { // In this case there are no leading and trailing spaces in the html code
                        if (!html.contains("<")) {
                            html = html.replaceFirst(Pattern.quote(word), newLinkElementWithNoFollow);
                        }
                    } else if (i == 0) {
                        html = html.replaceFirst(Pattern.quote(word) + "(\\s|&nbsp;)", newLinkElementWithNoFollow);
                    } else if (i == words.length - 1) {
                        html = html.replaceFirst("(\\s|&nbsp;)" + Pattern.quote(word), newLinkElementWithNoFollow);
                    } else {
                        html = html.replaceFirst("(\\s|&nbsp;)" + Pattern.quote(word) + "(\\s|&nbsp;)", newLinkElementWithNoFollow);
                    }
                }
            }

            // Rebuild the whole value string of the <p> tag and exchange the old one
            pTagElements.after("<p>"+html+"</p>");
            pTagElements.remove();
        }

        return contentDocument.select("body").html();
    }

    public PlanSectionTypeKeys getType() {
        if (StringUtils.isBlank(definition.getType())) {
            return PlanSectionTypeKeys.TEXT;
        }
        return PlanSectionTypeKeys.valueOf(definition.getType());
    }

    public Long getSectionDefinitionId() {
        return definition.getId();
    }

    public boolean isLocked() {
        return definition.getLocked();
    }

    public int getCharacterLimit() {
        return definition.getCharacterLimit();
    }

    public String getHelpText() {
        return definition.getHelpText();
    }

    public OntologyTerm getNumericValueAsOntologyTerm() throws SystemException, PortalException {
        ProposalAttribute attr = getSectionAttribute();
        if (attr == null || attr.getNumericValue() <= 0) {
            return null;
        }
        return OntologyTermLocalServiceUtil.getOntologyTerm(attr.getNumericValue());
    }

    public ProposalWrapper getNumericValueAsProposal() throws SystemException, PortalException {
        ProposalAttribute attr = getSectionAttribute();
        if (attr == null || attr.getNumericValue() <= 0) {
            return null;
        }
        return new ProposalWrapper(ProposalLocalServiceUtil.getProposal(attr.getNumericValue()));
    }

    public ProposalWrapper[] getStringValueAsProposalArray() throws SystemException, PortalException {
        ProposalAttribute attr = getSectionAttribute();
        if (attr == null || attr.getStringValue() == null || attr.getStringValue().equals("")) {
            return null;
        }

        String[] props = attr.getStringValue().split(",");
        ProposalWrapper[] ret = new ProposalWrapper[props.length];
        for (int i = 0; i < props.length; i++) {
            try {
                ret[i] = new ProposalWrapper(ProposalLocalServiceUtil.getProposal(Long.parseLong(props[i])));
            } catch (NumberFormatException e) {
                _log.error(String.format("Could not parse proposalId %s as a number", props[i]));
            } catch (SystemException | PortalException e) {
                _log.error(String.format("Could not retrieve proposal with id %s", props[i]), e);
            }
        }
        return ret;
    }

    public long getNumericValue() throws SystemException, PortalException {
        ProposalAttribute attr = getSectionAttribute();
        if (attr == null) {
            return 0;
        }
        return attr.getNumericValue();
    }

    public String getStringValue() throws SystemException, PortalException {
        ProposalAttribute attr = getSectionAttribute();
        if (attr == null) {
            return "";
        }
        return attr.getStringValue();
    }

    public List<OntologyTerm> getFocusAreaTerms() throws PortalException, SystemException {
        if (definition.getFocusAreaId() <= 0) {
            return null;
        }

        FocusArea area = FocusAreaLocalServiceUtil.getFocusArea(definition.getFocusAreaId());

        return FocusAreaLocalServiceUtil.getTerms(area);
    }

    public List<String> getOptionsForDropdownMenu() {
        return Arrays.asList(definition.getAllowedValues().split(";"));
    }

    public List<Long> getAllowedContestTypeIds() {
        return IdListUtil.getIdsFromString(definition.getAllowedContestTypeIds());
    }

    public String getProposalNames() {
        return ContestTypeLocalServiceUtil.getProposalNames(getAllowedContestTypeIds(), Plurality.SINGULAR.name(), "or");
    }

    public String getProposalNamesPlural() {
        return ContestTypeLocalServiceUtil.getProposalNames(getAllowedContestTypeIds(), Plurality.PLURAL.name(), "and");
    }

    public String getContestNames() {
        return ContestTypeLocalServiceUtil.getContestNames(getAllowedContestTypeIds(), Plurality.SINGULAR.name(), "or");
    }

    public String getContestNamesPlural() {
        return ContestTypeLocalServiceUtil.getContestNames(getAllowedContestTypeIds(), Plurality.PLURAL.name(), "or");
    }

    private ProposalAttribute getSectionAttribute() throws SystemException, PortalException {
        return this.wrappedProposal.getProposalAttributeHelper().getAttributeOrNull("SECTION", definition.getId());
    }
}

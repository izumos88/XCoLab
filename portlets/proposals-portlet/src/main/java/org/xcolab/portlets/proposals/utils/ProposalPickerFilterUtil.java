package org.xcolab.portlets.proposals.utils;

import java.util.*;

import com.ext.portlet.model.ActivitySubscription;
import com.ext.portlet.model.Contest;
import com.ext.portlet.model.PlanSectionDefinition;
import com.ext.portlet.model.ProposalSupporter;
import com.ext.portlet.service.ActivitySubscriptionLocalServiceUtil;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.PlanSectionDefinitionLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.ext.portlet.service.ProposalSupporterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import org.apache.commons.lang3.tuple.Pair;

import com.ext.portlet.model.Proposal;
import org.xcolab.portlets.proposals.wrappers.ContestWrapper;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;

/**
 * Created with IntelliJ IDEA.
 * User: patrickhiesel
 * Date: 04/12/13
 * Time: 10:25
 */
public class ProposalPickerFilterUtil {

    public static final String CONTEST_FILTER_REASON_FOCUS_AREA = "FOCUS_AREA";
    public static final String CONTEST_FILTER_REASON_TIER = "TIER";

    private static Log _log = LogFactoryUtil.getLog(ProposalPickerFilterUtil.class);

    /**
     * Parse filter from frontend parameter and filter the contents of the proposals parameter
     * @param filterKey the filter key passed as parameter from the frontend
     * @param proposals A list of Proposals paired with their date
     */
    public static void filterByParameter(String filterKey, List<Pair<Proposal, Date>> proposals) {
        if (filterKey != null && filterKey.equalsIgnoreCase("WINNERSONLY")) {
            ProposalPickerFilter.WINNERSONLY.filter(proposals);
        } else {
            ProposalPickerFilter.ACCEPTALL.filter(proposals);
        }
    }

    /**
     *  Retrieves a list of all contests matching the section's filters.
     *  If desired, the removed contests will be stored in the removedContests object together with a fitler reason.
     *
     * @param sectionId the section id of the proposal picker's caller
     * @param request the associated request
     * @param proposalsContext the associated proposal context
     * @param removedContests all removed contests are added to this Map together with a reason
     * @return A List of contests together with their creation date
     * @throws SystemException
     * @throws PortalException
     */
    public static List<Pair<ContestWrapper, Date>> getFilteredContests(
            long sectionId, ResourceRequest request, ProposalsContext proposalsContext,
            Map<Long, String> removedContests)
            throws SystemException, PortalException {

        List<Pair<ContestWrapper, Date>> contests = new ArrayList<>();

        for (Contest c: ContestLocalServiceUtil.getContests(0, Integer.MAX_VALUE)) {
            contests.add(Pair.of(new ContestWrapper(c),
                    c.getCreated() == null ? new Date(0) : c.getCreated()));
        }

        PlanSectionDefinition planSectionDefinition = PlanSectionDefinitionLocalServiceUtil.getPlanSectionDefinition(sectionId);

        final long sectionFocusAreaId = planSectionDefinition.getFocusAreaId();
        final long contestFocusAreaId;
        if (request != null) {
            Contest contest = proposalsContext.getContest(request);
            contestFocusAreaId = contest.getFocusAreaId();
        } else {
            contestFocusAreaId = 0;
        }
        _log.debug(String.format("%d contests before filtering", contests.size()));
        Set<Long> focusAreaRemovedContests = ProposalPickerFilter.SECTION_DEF_FOCUS_AREA_FILTER.filterContests(contests,
                Pair.of(sectionFocusAreaId, contestFocusAreaId));
        _log.debug(String.format("%d contests left after filtering for focus areas %d and %d",
                contests.size(), sectionFocusAreaId, contestFocusAreaId));
        final long filterTier = planSectionDefinition.getTier();
        Set<Long> tierRemovedContests = ProposalPickerFilter.CONTEST_TIER.filterContests(contests, filterTier);
        _log.debug(String.format("%d contests left after filtering for tier %d", contests.size(), filterTier));

        if (removedContests != null) {
            for (Long contestId : focusAreaRemovedContests) {
                removedContests.put(contestId, CONTEST_FILTER_REASON_FOCUS_AREA);
            }
            for (Long contestId : tierRemovedContests) {
                removedContests.put(contestId, CONTEST_FILTER_REASON_TIER);
            }
        }

        return contests;
    }

    public static List<Pair<Proposal, Date>> getFilteredSubscribedSupportingProposalsForUser(
            long userId, String filterKey, long sectionId, PortletRequest request, ProposalsContext proposalsContext)
            throws SystemException, PortalException {
        List<Pair<Proposal, Date>> proposals = getFilteredSubscribedProposalsForUser(
                userId, filterKey, sectionId, request, proposalsContext);

        Set<Long> includedProposals = new HashSet<>();
        for (Pair<Proposal, Date> entry : proposals) {
            includedProposals.add(entry.getLeft().getProposalId());
        }
        for (Pair<Proposal, Date> entry : getFilteredSupportingProposalsForUser(
                userId, filterKey, sectionId, request, proposalsContext)) {
            if (includedProposals.contains(entry.getLeft().getProposalId()))
                continue;
            proposals.add(entry);
        }

        return proposals;
    }

    public static List<Pair<Proposal, Date>> getFilteredSubscribedProposalsForUser(
            long userId, String filterKey, long sectionId, PortletRequest request, ProposalsContext proposalsContext)
            throws SystemException, PortalException {
        List<Pair<Proposal, Date>> proposals = new ArrayList<>();
        List<ActivitySubscription> activitySubscriptions = ActivitySubscriptionLocalServiceUtil
                .findByUser(userId);
        for (ActivitySubscription as : activitySubscriptions) {
            if (as.getClassNameId() == ClassNameLocalServiceUtil
                    .getClassNameId(Proposal.class)) {
                proposals.add(Pair.of(
                        ProposalLocalServiceUtil.getProposal(as.getClassPK()),
                        as.getCreateDate()));
            }
        }

        filterProposals(proposals, filterKey, sectionId, request, proposalsContext);

        return proposals;
    }

    public static List<Pair<Proposal, Date>> getFilteredSupportingProposalsForUser(
            long userId, String filterKey, long sectionId, PortletRequest request, ProposalsContext proposalsContext)
            throws SystemException, PortalException {
        List<Pair<Proposal, Date>> proposals = new ArrayList<>();
        for (ProposalSupporter ps : ProposalSupporterLocalServiceUtil
                .getProposals(userId)) {
            proposals.add(Pair.of(
                    ProposalLocalServiceUtil.getProposal(ps.getProposalId()),
                    ps.getCreateDate()));
        }

        filterProposals(proposals, filterKey, sectionId, request, proposalsContext);

        return proposals;
    }

    public static List<Pair<Proposal, Date>> getFilteredAllProposals(
            String filterKey, long sectionId, Long contestPK, PortletRequest request, ProposalsContext proposalsContext)
            throws SystemException, PortalException {
        List<Pair<Proposal, Date>> proposals = new ArrayList<>();
        List<Proposal> proposalsRaw;
        if (contestPK > 0) {
            proposalsRaw = ProposalLocalServiceUtil
                    .getProposalsInContest(contestPK);
        } else {
            proposalsRaw = ProposalLocalServiceUtil.getProposals(0,
                    Integer.MAX_VALUE);
        }
        for (Proposal p : proposalsRaw) {
            proposals.add(Pair.of(p, new Date(0)));
        }

        filterProposals(proposals, filterKey, sectionId, request, proposalsContext);

        return proposals;
    }

    public static void filterProposals(List<Pair<Proposal, Date>> proposals,
                                       String filterKey, long sectionId, PortletRequest request, ProposalsContext proposalsContext)
            throws SystemException, PortalException {
        filterByParameter(filterKey, proposals);

        PlanSectionDefinition planSectionDefinition = PlanSectionDefinitionLocalServiceUtil.getPlanSectionDefinition(sectionId);

        final long sectionFocusAreaId = planSectionDefinition.getFocusAreaId();
        final long contestFocusAreaId;
        if (request != null) {
            Contest contest = proposalsContext.getContest(request);
            contestFocusAreaId = contest.getFocusAreaId();
        } else {
            contestFocusAreaId = 0;
        }
        ProposalPickerFilter.SECTION_DEF_FOCUS_AREA_FILTER.filter(proposals,
                Pair.of(sectionFocusAreaId, contestFocusAreaId));

        ProposalPickerFilter.CONTEST_TIER.filter(proposals, planSectionDefinition.getTier());
    }
}
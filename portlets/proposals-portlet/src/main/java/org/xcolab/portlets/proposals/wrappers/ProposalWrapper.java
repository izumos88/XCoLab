package org.xcolab.portlets.proposals.wrappers;

import com.ext.portlet.JudgingSystemActions;
import com.ext.portlet.ProposalAttributeKeys;
import com.ext.portlet.ProposalContestPhaseAttributeKeys;
import com.ext.portlet.model.Contest;
import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.DiscussionCategoryGroup;
import com.ext.portlet.model.PlanSectionDefinition;
import com.ext.portlet.model.PlanTemplate;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.Proposal2Phase;
import com.ext.portlet.model.ProposalAttribute;
import com.ext.portlet.model.ProposalContestPhaseAttribute;
import com.ext.portlet.model.ProposalRating;
import com.ext.portlet.model.ProposalVersion;
import com.ext.portlet.models.CollaboratoriumModelingService;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.ContestPhaseLocalServiceUtil;
import com.ext.portlet.service.DiscussionCategoryGroupLocalServiceUtil;
import com.ext.portlet.service.PlanTemplateLocalServiceUtil;
import com.ext.portlet.service.Proposal2PhaseLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.ext.portlet.service.ProposalRatingLocalServiceUtil;
import com.ext.portlet.service.ProposalVersionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.MembershipRequest;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import edu.mit.cci.roma.client.Scenario;
import edu.mit.cci.roma.client.Simulation;
import org.apache.commons.lang3.StringUtils;
import org.xcolab.enums.ContestPhasePromoteType;
import org.xcolab.portlets.proposals.utils.GenericJudgingStatus;
import org.xcolab.helpers.ProposalAttributeHelper;
import org.xcolab.helpers.ProposalContestPhaseAttributeHelper;
import org.xcolab.wrappers.BaseProposalWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProposalWrapper extends BaseProposalWrapper {

    private static final Log _log = LogFactoryUtil.getLog(ProposalWrapper.class);

    protected static final Long LONG_DEFAULT_VAL = -1L;
    protected static final String STRING_DEFAULT_VAL = "";

    protected ProposalRatingsWrapper proposalRatings;
    private RibbonWrapper ribbonWrapper;
    private ProposalWrapper baseProposal;
    private List<ProposalTeamMemberWrapper> members;
    private List<ProposalSectionWrapper> sections;
    private List<MembershipRequestWrapper> membershipRequests;

    public ProposalWrapper(Proposal proposal) {
        this(proposal, proposal.getCurrentVersion());
    }

    public ProposalWrapper(Proposal proposal, int version) {
        super(proposal, version, null, null, null);
    }

    public ProposalWrapper(Proposal proposal, ContestPhase contestPhase, Proposal2Phase proposal2Phase) {
        super(proposal, proposal.getCurrentVersion(), null, contestPhase, proposal2Phase);
    }

    public ProposalWrapper(ProposalWrapper proposalWrapper) {
        super(proposalWrapper.getWrapped(),
                proposalWrapper.getCurrentVersion(),
                proposalWrapper.getContest(),
                proposalWrapper.contestPhase,
                proposalWrapper.proposal2Phase);
    }

    @Override
    public long getProposalId() {
        return proposal.getProposalId();
    }

    @Override
    public Date getCreateDate() {
        return proposal.getCreateDate();
    }

    @Override
    public void setCreateDate(Date createDate) {
        proposal.setCreateDate(createDate);
    }

    @Override
    public int getCurrentVersion() {
        return proposal.getCurrentVersion();
    }

    @Override
    public void setCurrentVersion(int currentVersion) {
        proposal.setCurrentVersion(currentVersion);
    }

    @Override
    public long getAuthorId() {
        return proposal.getAuthorId();
    }

    @Override
    public void setAuthorId(long authorId) {
        proposal.setAuthorId(authorId);
    }

    @Override
    public boolean getVisible() {
        return proposal.getVisible();
    }

    @Override
    public boolean isVisibleInPhase() throws PortalException, SystemException {
    	ProposalContestPhaseAttribute visibleInPhase = proposalContestPhaseAttributeHelper.getAttributeOrNull(ProposalContestPhaseAttributeKeys.VISIBLE, 0);
        return proposal.isVisible() && (visibleInPhase == null || visibleInPhase.getNumericValue() > 0); 
    }

    @Override
    public long getDiscussionId() {
        return proposal.getDiscussionId();
    }

    @Override
    public void setDiscussionId(long discussionId) {
        proposal.setDiscussionId(discussionId);
    }

    @Override
    public long getJudgeDiscussionId() {
        return proposal.getJudgeDiscussionId();
    }

    @Override
    public void setJudgeDiscussionId(long judgeDiscussionId) {
        proposal.setJudgeDiscussionId(judgeDiscussionId);
    }

    @Override
    public long getResultsDiscussionId() {
        return proposal.getResultsDiscussionId();
    }

    @Override
    public void setResultsDiscussionId(long resultsDiscussionId) {
        proposal.setResultsDiscussionId(resultsDiscussionId);
    }

    @Override
    public long getFellowDiscussionId() throws PortalException, SystemException {
        final long fellowDiscussionId = proposal.getFellowDiscussionId();
        if (fellowDiscussionId == 0) {
            DiscussionCategoryGroup discussionCategoryGroup = DiscussionCategoryGroupLocalServiceUtil.createDiscussionCategoryGroup(proposal.getProposalId() + "_fellowReview");
            return discussionCategoryGroup.getId();
        }
        return fellowDiscussionId;
    }

    @Override
    public long getAdvisorDiscussionId() {
        return proposal.getAdvisorDiscussionId();
    }

    @Override
    public void setAdvisorDiscussionId(long advisorDiscussionId) {
        proposal.setAdvisorDiscussionId(advisorDiscussionId);
    }

    public long getGroupId() {
        return proposal.getGroupId();
    }

    public void setGroupId(long groupId) {
        proposal.setGroupId(groupId);
    }

    public void setCachedModel(boolean cachedModel) {
        proposal.setCachedModel(cachedModel);
    }

    public ExpandoBridge getExpandoBridge() {
        return proposal.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        proposal.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public String getPitch() throws PortalException, SystemException {
        return proposalAttributeHelper.getAttributeValueString(ProposalAttributeKeys.PITCH, "");
    }

    @Override
    public String getName() throws PortalException, SystemException {
        return proposalAttributeHelper.getAttributeValueString(ProposalAttributeKeys.NAME, "");
    }

    @Override
    public String getDescription() throws SystemException, PortalException {
        return proposalAttributeHelper.getAttributeValueString(ProposalAttributeKeys.DESCRIPTION, "");
    }

    public boolean isFeatured() {
        return getRibbonWrapper().getRibbon() > 0;
    }

    public JudgingSystemActions.AdvanceDecision getJudgeDecision() {
        long judgingDecision = proposalContestPhaseAttributeHelper.getAttributeLongValue(ProposalContestPhaseAttributeKeys.JUDGE_DECISION, 0, LONG_DEFAULT_VAL);
        return JudgingSystemActions.AdvanceDecision.fromInt((int) judgingDecision);
    }

    public JudgingSystemActions.FellowAction getFellowAction() {
        Long action = proposalContestPhaseAttributeHelper.getAttributeLongValue(ProposalContestPhaseAttributeKeys.FELLOW_ACTION, 0, LONG_DEFAULT_VAL);
        return JudgingSystemActions.FellowAction.fromInt(action.intValue());
    }

    public String getFellowActionComment() {
        return proposalContestPhaseAttributeHelper.getAttributeStringValue(ProposalContestPhaseAttributeKeys.FELLOW_ACTION_COMMENT, 0, STRING_DEFAULT_VAL);
    }

    public String getProposalReview() {
        return proposalContestPhaseAttributeHelper.getAttributeStringValue(ProposalContestPhaseAttributeKeys.PROPOSAL_REVIEW, 0, STRING_DEFAULT_VAL);
    }

    public List<Long> getSelectedJudges() throws SystemException, PortalException {
        List<Long> selectedJudges = new ArrayList<>();

        // All judges are selected when screening is disabled
        if (!contestPhase.getFellowScreeningActive()) {
            for (User judge : ContestLocalServiceUtil.getJudgesForContest(contest)) {
                selectedJudges.add(judge.getUserId());
            }
        } else {
            String s = proposalContestPhaseAttributeHelper.getAttributeStringValue(ProposalContestPhaseAttributeKeys.SELECTED_JUDGES, 0, STRING_DEFAULT_VAL);
            if (s.isEmpty()) {
                return selectedJudges;
            }
            for (String element : s.split(";")) {
                selectedJudges.add(Long.parseLong(element));
            }
        }

        return selectedJudges;
    }

    public List<User> getSelectedJudgeUsers() throws SystemException, PortalException {
        List<User> selectedJudges = new ArrayList<>();

        // All judges are selected when screening is disabled
        if (!contestPhase.getFellowScreeningActive()) {
            for (User judge : ContestLocalServiceUtil.getJudgesForContest(contest)) {
                selectedJudges.add(judge);
            }
        } else {
            String s = proposalContestPhaseAttributeHelper.getAttributeStringValue(ProposalContestPhaseAttributeKeys.SELECTED_JUDGES, 0, STRING_DEFAULT_VAL);
            if (s.isEmpty()) {
                return selectedJudges;
            }
            for (String element : s.split(";")) {
                selectedJudges.add(UserLocalServiceUtil.getUser(Long.parseLong(element)));
            }
        }
        return selectedJudges;
    }

    public boolean isUserAmongSelectedJudge(User user) throws PortalException, SystemException {
        if (!getFellowScreeningNecessary()) {
            return isUserAmongJudges(user);
        }

        for (Long userId : getSelectedJudges()) {
            if (userId == user.getUserId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isUserAmongFellows(User userInQuestion) throws SystemException, PortalException {
        for (User fellow : ContestLocalServiceUtil.getFellowsForContest(contest)) {
            if (fellow.getUserId() == userInQuestion.getUserId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isUserAmongJudges(User userInQuestion) throws SystemException, PortalException {
        for (User judge : ContestLocalServiceUtil.getJudgesForContest(contest)) {
            if (judge.getUserId() == userInQuestion.getUserId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isJudgingContestPhase() {
        return ContestPhasePromoteType.getPromoteType(contestPhase.getContestPhaseAutopromote()) == ContestPhasePromoteType.PROMOTE_JUDGED;
    }

    @Override
    public String getTeam() throws PortalException, SystemException {
        return proposalAttributeHelper.getAttributeValueString(ProposalAttributeKeys.TEAM, "");
    }

    @Override
    public User getAuthor() throws PortalException, SystemException {
        return UserLocalServiceUtil.getUser(proposal.getAuthorId());
    }

    @Override
    public long getSupportersCount() throws PortalException, SystemException {
        return ProposalLocalServiceUtil.getSupportersCount(proposal.getProposalId());
    }

    @Override
    public long getCommentsCount() throws PortalException, SystemException {
        if (proposal.getProposalId() > 0) {
            return ProposalLocalServiceUtil.getCommentsCount(proposal.getProposalId());
        }
        return 0;
    }

    @Override
    public long getFellowReviewCommentsCount() throws PortalException, SystemException {
        if (proposal.getProposalId() > 0) {
            return ProposalLocalServiceUtil.getFellowReviewCommentsCount(proposal.getProposalId());
        }
        return 0;
    }

    @Override
    public long getEvaluationCommentsCount() throws PortalException, SystemException {
        return 0;
    }

    @Override
    public Date getLastModifiedDate() {
        return proposal.getUpdatedDate();
    }

    @Override
    public Date getLastModifiedDateForContestPhase() throws PortalException, SystemException {
        if (proposal2Phase.getVersionTo() == -1) {
            return getLastModifiedDate();
        }
        return ProposalVersionLocalServiceUtil.getByProposalIdVersion(proposal.getProposalId(), version).getCreateDate();
    }

    @Override
    public boolean isOpen() throws PortalException, SystemException {
        return proposal.getProposalId() > 0 && ProposalLocalServiceUtil.isOpen(proposal.getProposalId());
    }

    public long getVotesCount() throws SystemException, PortalException {
        if (proposal.getProposalId() > 0) {
            long votingPhasePK = new ContestWrapper(contest).getVotingPhasePK();
            return ProposalLocalServiceUtil.getVotesCount(proposal.getProposalId(), votingPhasePK);
        }
        return 0;
    }

    @Override
    public long getImageId() throws PortalException, SystemException {
        return proposalAttributeHelper.getAttributeValueLong(ProposalAttributeKeys.IMAGE_ID, 0L, 0);
    }

    @Override
    public String getProposalURL() {
        return String.format("/web/guest/plans/-/plans/contestId/%s/planId/%s", contest.getContestPK(), proposal.getProposalId());
    }

    public List<ProposalSectionWrapper> getSections() throws PortalException, SystemException {
        if (sections == null) {
            sections = new ArrayList<>();
            if (contest != null) {
                PlanTemplate planTemplate = ContestLocalServiceUtil.getPlanTemplate(contest);
                if (planTemplate != null) {
                    for (PlanSectionDefinition psd : PlanTemplateLocalServiceUtil.getSections(planTemplate)) {
                        sections.add(new ProposalSectionWrapper(psd, proposal, version, this));
                    }
                }
            }
        }
        return sections;
    }

    public List<ProposalTeamMemberWrapper> getMembers() throws PortalException, SystemException {
        if (members == null) {
            members = new ArrayList<>();
            for (User user : ProposalLocalServiceUtil.getMembers(proposal.getProposalId())) {
                members.add(new ProposalTeamMemberWrapper(proposal, user));
            }
        }
        return members;
    }

    @Override
    public List<User> getSupporters() throws PortalException, SystemException {
        return ProposalLocalServiceUtil.getSupporters(proposal.getProposalId());
    }

    protected boolean getFellowScreeningNecessary() {
        return contestPhase.getFellowScreeningActive();
    }

    @Override
    public String getAuthorName() throws PortalException, SystemException {
        String authorName = getTeam();
        if (StringUtils.isBlank(authorName)) {
            authorName = getAuthor().getScreenName();
        }
        return authorName;
    }

    @Override
    public Contest getContest() {
        return contest;
    }
    
    public List<MembershipRequestWrapper> getMembershipRequests() {
        if (this.membershipRequests == null) {
            membershipRequests = new ArrayList<>();
            try {
                for (MembershipRequest m : ProposalLocalServiceUtil.getMembershipRequests(proposal.getProposalId())) {
                    membershipRequests.add(new MembershipRequestWrapper(m));
                }
            } catch (SystemException | PortalException e) {
                _log.warn(String.format("Could not retrieve membership requests for proposal %d", proposal.getProposalId()));
            }
        }
        return this.membershipRequests;
    }

    public Long getModelId() throws PortalException, SystemException {
        Long modelId = 0L;
        try {
            modelId = ContestLocalServiceUtil.getDefaultModelId(contest.getContestPK());
        } catch (PortalException | SystemException ignored) { }
        return modelId;
    }

    public void setScenarioId(Long scenarioId, Long modelId, Long userId) throws PortalException, SystemException {
        ProposalLocalServiceUtil.setAttribute(userId, proposal.getProposalId(), ProposalAttributeKeys.SCENARIO_ID, modelId, scenarioId);
    }

    public Long getScenarioId() throws PortalException, SystemException {
        ProposalAttribute attr = proposalAttributeHelper.getLatestAttributeOrNull(ProposalAttributeKeys.SCENARIO_ID);
	    if (attr == null) {
            return 0L;
        }
        return attr.getNumericValue();
    }

    public Map<Long,List<ProposalWrapper>> getSubProposalPerModel() throws PortalException, SystemException {
        Map<Long,List<ProposalWrapper>> subProposalPerModel = new HashMap<>();
        List<Proposal> subProposals =  ProposalLocalServiceUtil.getContestIntegrationRelevantSubproposals(proposal.getProposalId());

        for(Proposal subProposal : subProposals){
            ProposalWrapper subProposalWrapper = new ProposalWrapper(subProposal);
            Long modelId = subProposalWrapper.getModelIdForStoredScenario();
            if(!subProposalPerModel.containsKey(modelId)){
                subProposalPerModel.put(modelId, Arrays.asList(subProposalWrapper));
            } else {
                subProposalPerModel.get(modelId).add(subProposalWrapper);
            }
        }
        return subProposalPerModel;
    }

    public Scenario getScenario() throws IOException, SystemException{
        return getScenarioByProposalId(proposal.getProposalId());
    }

    public Scenario getScenarioByProposalId(Long proposalId) throws IOException, SystemException{
        return CollaboratoriumModelingService.repository().getScenario(proposalId);
    }

    private static Long getModelIdForScenarioId(Long scenarioId) throws SystemException{
        Long modelId;

        try {
            Scenario scenario = CollaboratoriumModelingService.repository().getScenario(scenarioId);
            Simulation simulation = scenario.getSimulation();
            modelId = simulation.getId();
        }
        catch (IOException e) {
            modelId = 0L;
        }

        return modelId;
    }

    public List<Scenario> getSubProposalScenarios() throws SystemException, PortalException, IOException{
        List<Scenario> subProposalScenarios = new ArrayList<>();
        List<Proposal> subProposals =  ProposalLocalServiceUtil.getContestIntegrationRelevantSubproposals(proposal.getProposalId());
        for(Proposal subProposal : subProposals) {
            Scenario scenarioForSubProposal = getScenarioByProposalId(subProposal.getProposalId());
            subProposalScenarios.add(scenarioForSubProposal);
        }
        return subProposalScenarios;
    }

    private Long getModelIdForStoredScenario() throws SystemException{
        return getModelIdForScenarioId(proposal.getProposalId());
    }

    public List<Long> getSubProposalScenarioIds() throws PortalException, SystemException {
        List<Long> subProposalScenarioIds = new ArrayList<>();
        Map<Long,List<ProposalWrapper>> subProposalPerModel = getSubProposalPerModel();

        if(!subProposalPerModel.isEmpty()){
            for(Long modelId : subProposalPerModel.keySet()){
                List<ProposalWrapper> proposalWrappers = subProposalPerModel.get(modelId);
                for(ProposalWrapper proposalWrapper : proposalWrappers){
                    subProposalScenarioIds.add(proposalWrapper.getScenarioId());
                }
            }
        }

        return subProposalScenarioIds;
    }

    /**
     * Determine if fellows are done with proposal
     */
    public GenericJudgingStatus getScreeningStatus() {
        switch (getFellowAction()) {
            case INCOMPLETE: case OFFTOPIC: case NOT_ADVANCE_OTHER:
                return GenericJudgingStatus.STATUS_REJECTED;
            case PASS_TO_JUDGES:
                return GenericJudgingStatus.STATUS_ACCEPTED;
            default:
                return GenericJudgingStatus.STATUS_UNKNOWN;
        }
    }

    /**
     * Determine if judges are done with proposal
     *
     */
    public GenericJudgingStatus getJudgeStatus() {
        try {
            if (getFellowAction() == JudgingSystemActions.FellowAction.INCOMPLETE || getFellowAction() == JudgingSystemActions.FellowAction.OFFTOPIC || getFellowAction() == JudgingSystemActions.FellowAction.NOT_ADVANCE_OTHER) {
                return GenericJudgingStatus.STATUS_REJECTED;
            }
            if (!getSelectedJudges().isEmpty() && getAllJudgesReviewFinished()) {
                return GenericJudgingStatus.STATUS_ACCEPTED;
            }
        } catch (SystemException | PortalException e) {
            e.printStackTrace();
        }
        return GenericJudgingStatus.STATUS_UNKNOWN;
    }

    /**
     * Determines whether the screening/advance decision of the proposal is done
     */
    public GenericJudgingStatus getOverallStatus() {
        if (getJudgeDecision() == JudgingSystemActions.AdvanceDecision.MOVE_ON && Validator.isNotNull(getProposalReview())) {
            return GenericJudgingStatus.STATUS_ACCEPTED;
        }
        if (getJudgeDecision() == JudgingSystemActions.AdvanceDecision.DONT_MOVE_ON && Validator.isNotNull(getProposalReview()) ||
                getScreeningStatus() == GenericJudgingStatus.STATUS_REJECTED) {
            return GenericJudgingStatus.STATUS_REJECTED;
        }

        return GenericJudgingStatus.STATUS_UNKNOWN;
    }

    @Override
    public boolean getIsLatestVersion() {
        return getCurrentVersion() == version;
    }

    @Override
    public Contest getWasMovedToContest() {
        try{
            Contest c = Proposal2PhaseLocalServiceUtil.getCurrentContestForProposal(proposal.getProposalId());
            if (c.getContestPK() != contest.getContestPK()) {
                return c;
            }
            return null;
        } catch (PortalException e) { return null; }
        catch (SystemException e) { return null; }
    }

    @Override
    public ProposalVersion getSelectedVersion() {
        try {
            for (ProposalVersion pv : ProposalVersionLocalServiceUtil.getByProposalId(proposal.getProposalId(), 0, Integer.MAX_VALUE)) {
                if (pv.getVersion() == version) {
                    return pv;
                }
            }
        } catch (SystemException e) {
            return null;
        }
        return null;
    }

    public User getUserForSelectedVersion() {
        try {
            return UserLocalServiceUtil.getUser(getSelectedVersion().getAuthorId());
        } catch (SystemException | PortalException e) {
            return null;
        }
    }

    public boolean getAllJudgesReviewFinished() throws SystemException, PortalException {
        if (!getSelectedJudges().isEmpty()) {
            for (long userId : getSelectedJudges()) {
                List<ProposalRating> proposalRatings = ProposalRatingLocalServiceUtil.getJudgeRatingsForProposalAndUser(
                        userId,
                        this.proposal.getProposalId(),
                        this.contestPhase.getContestPhasePK());
                ProposalRatingsWrapper wrapper = new ProposalRatingsWrapper(userId, proposalRatings);
                if (!wrapper.isReviewComplete()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getJudgeReviewFinishedStatusUserId(Long userId) throws SystemException, PortalException {

        List<ProposalRating> proposalRatings = ProposalRatingLocalServiceUtil.getJudgeRatingsForProposalAndUser(
                userId,
                this.proposal.getProposalId(),
                this.contestPhase.getContestPhasePK());
        ProposalRatingsWrapper wrapper = new ProposalRatingsWrapper(userId, proposalRatings);
        return wrapper.isReviewComplete();

    }

    @Override
    public ProposalAttributeHelper getProposalAttributeHelper() {
        return proposalAttributeHelper;
    }

	@Override
    public int getVersion() {
		return version;
	}
	
	public ProposalWrapper getBaseProposal() throws PortalException, SystemException {
		if (baseProposal == null) {
			long baseProposalId = proposalAttributeHelper.getAttributeValueLong(ProposalAttributeKeys.BASE_PROPOSAL_ID, 0);
			long baseProposalContestId = proposalAttributeHelper.getAttributeValueLong(ProposalAttributeKeys.BASE_PROPOSAL_CONTEST_ID, 0);
			if (baseProposalId > 0 && baseProposalContestId > 0) {
				Proposal p = ProposalLocalServiceUtil.getProposal(baseProposalId);
				Contest c = ContestLocalServiceUtil.getContest(baseProposalContestId);
				baseProposal = new ProposalWrapper(p);
			}
		}
		return baseProposal;
	}
	
	@Override
    public long getContestPK() {
		return contest.getContestPK();
	}

    @Override
    public Proposal getWrapped() {
        return proposal;
    }

    public List<ProposalRatingWrapper> getRatings() throws SystemException, PortalException {
        if (this.proposalRatings == null) {
            return new ArrayList<>();
        }
        return this.proposalRatings.getRatings();
    }

    public String getRatingComment() throws SystemException, PortalException {
        if (this.proposalRatings == null) {
            return "";
        }
        return this.proposalRatings.getComment();
    }

    @Override
    public ContestPhase getContestPhase() {
        return contestPhase;
    }

    public RibbonWrapper getRibbonWrapper() {
        if (ribbonWrapper == null) {
            ribbonWrapper = new RibbonWrapper(this);
        }
        return ribbonWrapper;
    }
}

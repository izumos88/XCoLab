package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Contest. This utility wraps
 * {@link com.ext.portlet.service.impl.ContestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContestLocalService
 * @see com.ext.portlet.service.base.ContestLocalServiceBaseImpl
 * @see com.ext.portlet.service.impl.ContestLocalServiceImpl
 * @generated
 */
public class ContestLocalServiceUtil {
    private static ContestLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.ContestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the contest to the database. Also notifies the appropriate model listeners.
    *
    * @param contest the contest
    * @return the contest that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.Contest addContest(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addContest(contest);
    }

    /**
    * Creates a new contest with the primary key. Does not add the contest to the database.
    *
    * @param ContestPK the primary key for the new contest
    * @return the new contest
    */
    public static com.ext.portlet.model.Contest createContest(long ContestPK) {
        return getService().createContest(ContestPK);
    }

    /**
    * Deletes the contest with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ContestPK the primary key of the contest
    * @return the contest that was removed
    * @throws PortalException if a contest with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.Contest deleteContest(long ContestPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContest(ContestPK);
    }

    /**
    * Deletes the contest from the database. Also notifies the appropriate model listeners.
    *
    * @param contest the contest
    * @return the contest that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.Contest deleteContest(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContest(contest);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.ext.portlet.model.Contest fetchContest(long ContestPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchContest(ContestPK);
    }

    /**
    * Returns the contest with the primary key.
    *
    * @param ContestPK the primary key of the contest
    * @return the contest
    * @throws PortalException if a contest with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.Contest getContest(long ContestPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContest(ContestPK);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the contests.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contests
    * @param end the upper bound of the range of contests (not inclusive)
    * @return the range of contests
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.Contest> getContests(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContests(start, end);
    }

    /**
    * Returns the number of contests.
    *
    * @return the number of contests
    * @throws SystemException if a system exception occurred
    */
    public static int getContestsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestsCount();
    }

    /**
    * Updates the contest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contest the contest
    * @return the contest that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.Contest updateContest(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateContest(contest);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.ext.portlet.model.Contest getContestByActiveFlag(
        boolean contestActive)
        throws com.ext.portlet.NoSuchContestException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestByActiveFlag(contestActive);
    }

    public static com.ext.portlet.model.Contest createNewContest(
        java.lang.Long userId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().createNewContest(userId, name);
    }

    public static void updateContestGroupsAndDiscussions()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().updateContestGroupsAndDiscussions();
    }

    public static java.util.List<com.ext.portlet.model.Contest> getByContestUrlName(
        java.lang.String contestUrlName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getByContestUrlName(contestUrlName);
    }

    public static java.util.List<com.ext.portlet.model.Contest> findByContestYear(
        long contestYear)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByContestYear(contestYear);
    }

    public static com.ext.portlet.model.Contest getByContestUrlNameContestYear(
        java.lang.String contestUrlName, long year)
        throws com.ext.portlet.NoSuchContestException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getByContestUrlNameContestYear(contestUrlName, year);
    }

    public static java.util.List<com.ext.portlet.model.Contest> findByActive(
        boolean active)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByActive(active);
    }

    public static java.util.List<com.ext.portlet.model.Contest> findByActiveFeatured(
        boolean active, boolean featured)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByActiveFeatured(active, featured);
    }

    public static java.util.List<com.ext.portlet.model.Contest> findByActiveFlag(
        boolean active, int flag)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByActiveFlag(active, flag);
    }

    /**
    * Methods from ContestImpl *
    */
    public static java.util.List<com.ext.portlet.model.ContestPhase> getAllPhases(
        com.ext.portlet.model.Contest contest) {
        return getService().getAllPhases(contest);
    }

    public static java.util.List<com.ext.portlet.model.ContestPhase> getVisiblePhases(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getVisiblePhases(contest);
    }

    public static java.util.List<com.ext.portlet.model.ContestPhase> getActivePhases(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getActivePhases(contest);
    }

    public static com.ext.portlet.model.ContestPhase getActivePhase(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getActivePhase(contest);
    }

    public static com.ext.portlet.model.ContestPhase getActiveOrLastPhase(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getActiveOrLastPhase(contest);
    }

    public static boolean isActive(com.ext.portlet.model.Contest contest) {
        return getService().isActive(contest);
    }

    public static void store(com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().store(contest);
    }

    public static com.ext.portlet.model.PlanTemplate getPlanTemplate(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanTemplate(contest);
    }

    public static com.ext.portlet.model.FocusArea getFocusArea(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getFocusArea(contest);
    }

    public static com.liferay.portal.model.Image getLogo(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLogo(contest);
    }

    public static com.liferay.portal.model.Image getSponsorLogo(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSponsorLogo(contest);
    }

    public static java.lang.String getLogoPath(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLogoPath(contest);
    }

    public static java.lang.String getSponsorLogoPath(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSponsorLogoPath(contest);
    }

    public static long getProposalsCount(com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getProposalsCount(contest);
    }

    public static com.ext.portlet.model.DiscussionCategoryGroup getDiscussionCategoryGroup(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDiscussionCategoryGroup(contest);
    }

    public static long getTotalCommentsCount(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getTotalCommentsCount(contest);
    }

    public static long getCommentsCount(com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCommentsCount(contest);
    }

    public static long getProposalsCommentsCount(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getProposalsCommentsCount(contest);
    }

    public static long getVotesCount(com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getVotesCount(contest);
    }

    public static long getTotalComments(com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getTotalComments(contest);
    }

    public static java.util.List<com.ext.portlet.model.ContestTeamMember> getTeamMembers(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTeamMembers(contest);
    }

    public static com.ext.portlet.model.ContestTeamMemberRole getRoleForMember(
        com.ext.portlet.model.ContestTeamMember contestTeamMember)
        throws com.liferay.portal.NoSuchModelException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoleForMember(contestTeamMember);
    }

    /**
    * <p>Returns true if user is subscribed to a contest, false otherwise</p>
    *
    * @param contestPK id of a contest
    * @param userId    id of a user
    * @return true if user is subscribed to a contest, false otherwise
    * @throws PortalException in case of LR error
    * @throws SystemException in case of LR error
    */
    public static boolean isSubscribed(long contestPK, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().isSubscribed(contestPK, userId);
    }

    /**
    * <p>Subscribes user to contest</p>
    *
    * @param contestPK id of a contest
    * @param userId    id of a user
    * @throws PortalException in case of LR error
    * @throws SystemException in case of LR error
    */
    public static void subscribe(long contestPK, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().subscribe(contestPK, userId);
    }

    /**
    * <p>Subscribes user to contest</p>
    *
    * @param contestPK id of a contest
    * @param userId    id of a user
    * @throws PortalException in case of LR error
    * @throws SystemException in case of LR error
    */
    public static void unsubscribe(long contestPK, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().unsubscribe(contestPK, userId);
    }

    public static java.util.List<java.lang.Long> getModelIds(long contestPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getModelIds(contestPK);
    }

    public static java.util.Map<java.lang.Long, java.lang.String> getModelIdsAndNames(
        long contestPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getModelIdsAndNames(contestPK);
    }

    public static java.lang.Long getDefaultModelId(long contestPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDefaultModelId(contestPK);
    }

    public static java.util.List<com.ext.portlet.model.Contest> getContestsByActivePrivate(
        boolean contestActive, boolean contestPrivate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getContestsByActivePrivate(contestActive, contestPrivate);
    }

    public static java.util.List<com.ext.portlet.model.Contest> getContestsByActivePrivateType(
        boolean contestActive, boolean contestPrivate, long contestTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getContestsByActivePrivateType(contestActive,
            contestPrivate, contestTypeId);
    }

    public static java.util.List<com.ext.portlet.model.Contest> getContestsMatchingOntologyTerms(
        java.util.List<com.ext.portlet.model.OntologyTerm> ontologyTerms)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestsMatchingOntologyTerms(ontologyTerms);
    }

    /**
    * Returns all contests matching the specified contest tier.
    * Returns all contests in the case of ContestTier.NONE
    *
    * @param contestTierType   The specified contest tier
    * @return A list of all Contests matching the specified contest tier
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.ext.portlet.model.Contest> getContestsMatchingTier(
        long contestTierType)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestsMatchingTier(contestTierType);
    }

    public static java.util.List<com.ext.portlet.model.Contest> getContestsMatchingTierInType(
        long contestTierType, long contestTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getContestsMatchingTierInType(contestTierType, contestTypeId);
    }

    /**
    * Returns all contests matching the specified contest tier and ontology terms.
    * Returns all contests in the case of ContestTier.NONE
    *
    * @param contestTierType   The specified contest tier
    * @return A list of all Contests matching the specified contest tier
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.ext.portlet.model.Contest> getContestsMatchingOntologyTermsAndTier(
        java.util.List<com.ext.portlet.model.OntologyTerm> ontologyTerms,
        long contestTierType)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getContestsMatchingOntologyTermsAndTier(ontologyTerms,
            contestTierType);
    }

    /**
    * This method transfers users' supports for proposals in the passed contest to a vote. If a user has only supported
    * one proposal within the passed contest, the support is automatically transferred to a vote and the user is notified
    * about this action. If the user supports more than one proposal in the passed contest, a message is sent to the user
    * which the user to vote for his/her favourite proposal of the list of supported proposals
    *
    * @param contest               The contest object
    * @param serviceContext        The service contest containing the portal base URL
    * @throws SystemException
    * @throws PortalException
    */
    public static void transferSupportsToVote(
        com.ext.portlet.model.Contest contest,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().transferSupportsToVote(contest, serviceContext);
    }

    /**
    * This method generates a CSV string of all judge Reviews of all previous contestPhases of a contest.
    * By using the currentPhase parameter, the output is filtered to only include proposals that are in
    * currentPhase.
    *
    * @param contest           The contest for which the review should be created
    * @param currentPhase      The currently active ContestPhase which should be used for proposal filtering
    * @param serviceContext    A serviceContext which must include the Portal's base URL
    * @throws SystemException
    * @throws PortalException
    */
    public static java.lang.String getProposalJudgeReviewCsv(
        com.ext.portlet.model.Contest contest,
        com.ext.portlet.model.ContestPhase currentPhase,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getProposalJudgeReviewCsv(contest, currentPhase,
            serviceContext);
    }

    public static java.util.List<com.liferay.portal.model.User> getAdvisorsForContest(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAdvisorsForContest(contest);
    }

    public static java.util.List<com.liferay.portal.model.User> getJudgesForContest(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getJudgesForContest(contest);
    }

    public static java.util.List<com.liferay.portal.model.User> getFellowsForContest(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getFellowsForContest(contest);
    }

    public static java.util.List<com.liferay.portal.model.User> getContestManagersForContest(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestManagersForContest(contest);
    }

    public static java.lang.String getContestLinkUrl(long contestId) {
        return getService().getContestLinkUrl(contestId);
    }

    /**
    * Returns the URL link address for the passed contest
    *
    * @param contest   The contest object
    * @return Contest URL as String
    */
    public static java.lang.String getContestLinkUrl(
        com.ext.portlet.model.Contest contest) {
        return getService().getContestLinkUrl(contest);
    }

    public static boolean hasContestEnded(long contestPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().hasContestEnded(contestPK);
    }

    public static boolean hasContestEnded(com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().hasContestEnded(contest);
    }

    public static com.ext.portlet.model.Proposal getWinnerProposal(
        long contestPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getWinnerProposal(contestPK);
    }

    public static java.lang.Integer getPointsAccessibleForActivePhaseOfContest(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPointsAccessibleForActivePhaseOfContest(contest);
    }

    public static com.ext.portlet.model.ImpactTemplateSeries getContestImpactTemplateSeries(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestImpactTemplateSeries(contest);
    }

    public static java.util.List<com.ext.portlet.model.ImpactIteration> getContestImpactIterations(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestImpactIterations(contest);
    }

    public static com.ext.portlet.model.ImpactTemplateFocusAreaList getContestImpactFocusAreaList(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestImpactFocusAreaList(contest);
    }

    public static java.util.List<com.ext.portlet.model.ImpactTemplateMaxFocusArea> getContestImpactFocusAreas(
        com.ext.portlet.model.Contest contest)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestImpactFocusAreas(contest);
    }

    public static java.util.List<com.ext.portlet.model.Contest> getContestsByContestType(
        java.lang.Long contestTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestsByContestType(contestTypeId);
    }

    public static java.util.List<com.ext.portlet.model.Contest> getContestsByContestTypeIds(
        java.util.List<java.lang.Long> contestTypeIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestsByContestTypeIds(contestTypeIds);
    }

    public static int countContestsByContestType(java.lang.Long contestTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countContestsByContestType(contestTypeId);
    }

    public static java.util.List<com.ext.portlet.model.Contest> getContestsByTierLevelAndOntologyTermIds(
        java.lang.Long contestTier,
        java.util.List<java.lang.Long> focusAreaOntologyTermIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getContestsByTierLevelAndOntologyTermIds(contestTier,
            focusAreaOntologyTermIds);
    }

    public static java.util.List<com.ext.portlet.model.Contest> getContestsByContestScheduleId(
        java.lang.Long contestScheduleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestsByContestScheduleId(contestScheduleId);
    }

    public static java.util.List<com.ext.portlet.model.Contest> getContestsByPlanTemplateId(
        java.lang.Long planTemplateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContestsByPlanTemplateId(planTemplateId);
    }

    public static java.util.List<com.ext.portlet.model.Contest> getSubContestsByOntologySpaceId(
        com.ext.portlet.model.Contest contest, java.lang.Long ontologySpaceId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getSubContestsByOntologySpaceId(contest, ontologySpaceId);
    }

    /**
    * This method adds a year suffix to already completed contests. It iterates over all completed contests
    * and automatically adds the year of the completed contest phase as a suffix to the Contest's ShortName, if necessary
    */
    public static void addContestYearSuffixToCompletedContests()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().addContestYearSuffixToCompletedContests();
    }

    /**
    * Returns a list of contests that have Proposal points enabled (column 'points' and 'defaultParentPointType' set),
    * while optionally ignoring contests which are marked as inactive
    *
    * @param ignoreInactiveContests    A flag indicating whether the method should include inactive contests or not
    * @return A list of contests mathing the criteria
    */
    public static java.util.List<com.ext.portlet.model.Contest> getPointsEnabledContests(
        boolean ignoreInactiveContests)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPointsEnabledContests(ignoreInactiveContests);
    }

    /**
    * This method adds a year suffix to the passed contest. By passing the flag checkForCompleted, the method will only
    * add the suffix for contests which latest contest phase is of type COMPLETED
    * It automatically adds the year of the completed contest phase as a suffix to the Contest's ShortName, if necessary
    *
    * @param contest               The contest that should get a year suffix
    * @param checkForCompleted     Indicates whether contests that are not in a COMPLETED active contest phase should be ignored
    */
    public static void addContestYearSuffixToContest(
        com.ext.portlet.model.Contest contest, boolean checkForCompleted) {
        getService().addContestYearSuffixToContest(contest, checkForCompleted);
    }

    public static java.lang.String generateContestUrlName(
        com.ext.portlet.model.Contest contest) {
        return getService().generateContestUrlName(contest);
    }

    public static void clearService() {
        _service = null;
    }

    public static ContestLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ContestLocalService.class.getName());

            if (invokableLocalService instanceof ContestLocalService) {
                _service = (ContestLocalService) invokableLocalService;
            } else {
                _service = new ContestLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ContestLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ContestLocalService service) {
    }
}

package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Plan2ProposalLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Plan2ProposalLocalService
 * @generated
 */
public class Plan2ProposalLocalServiceWrapper
    implements Plan2ProposalLocalService,
        ServiceWrapper<Plan2ProposalLocalService> {
    private Plan2ProposalLocalService _plan2ProposalLocalService;

    public Plan2ProposalLocalServiceWrapper(
        Plan2ProposalLocalService plan2ProposalLocalService) {
        _plan2ProposalLocalService = plan2ProposalLocalService;
    }

    /**
    * Adds the plan2 proposal to the database. Also notifies the appropriate model listeners.
    *
    * @param plan2Proposal the plan2 proposal
    * @return the plan2 proposal that was added
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.Plan2Proposal addPlan2Proposal(
        com.ext.portlet.model.Plan2Proposal plan2Proposal)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.addPlan2Proposal(plan2Proposal);
    }

    /**
    * Creates a new plan2 proposal with the primary key. Does not add the plan2 proposal to the database.
    *
    * @param planId the primary key for the new plan2 proposal
    * @return the new plan2 proposal
    */
    public com.ext.portlet.model.Plan2Proposal createPlan2Proposal(long planId) {
        return _plan2ProposalLocalService.createPlan2Proposal(planId);
    }

    /**
    * Deletes the plan2 proposal with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planId the primary key of the plan2 proposal
    * @throws PortalException if a plan2 proposal with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deletePlan2Proposal(long planId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _plan2ProposalLocalService.deletePlan2Proposal(planId);
    }

    /**
    * Deletes the plan2 proposal from the database. Also notifies the appropriate model listeners.
    *
    * @param plan2Proposal the plan2 proposal
    * @throws SystemException if a system exception occurred
    */
    public void deletePlan2Proposal(
        com.ext.portlet.model.Plan2Proposal plan2Proposal)
        throws com.liferay.portal.kernel.exception.SystemException {
        _plan2ProposalLocalService.deletePlan2Proposal(plan2Proposal);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.ext.portlet.model.Plan2Proposal fetchPlan2Proposal(long planId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.fetchPlan2Proposal(planId);
    }

    /**
    * Returns the plan2 proposal with the primary key.
    *
    * @param planId the primary key of the plan2 proposal
    * @return the plan2 proposal
    * @throws PortalException if a plan2 proposal with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.Plan2Proposal getPlan2Proposal(long planId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.getPlan2Proposal(planId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the plan2 proposals.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of plan2 proposals
    * @param end the upper bound of the range of plan2 proposals (not inclusive)
    * @return the range of plan2 proposals
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.Plan2Proposal> getPlan2Proposals(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.getPlan2Proposals(start, end);
    }

    /**
    * Returns the number of plan2 proposals.
    *
    * @return the number of plan2 proposals
    * @throws SystemException if a system exception occurred
    */
    public int getPlan2ProposalsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.getPlan2ProposalsCount();
    }

    /**
    * Updates the plan2 proposal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param plan2Proposal the plan2 proposal
    * @return the plan2 proposal that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.Plan2Proposal updatePlan2Proposal(
        com.ext.portlet.model.Plan2Proposal plan2Proposal)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.updatePlan2Proposal(plan2Proposal);
    }

    /**
    * Updates the plan2 proposal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param plan2Proposal the plan2 proposal
    * @param merge whether to merge the plan2 proposal with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the plan2 proposal that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.Plan2Proposal updatePlan2Proposal(
        com.ext.portlet.model.Plan2Proposal plan2Proposal, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _plan2ProposalLocalService.updatePlan2Proposal(plan2Proposal,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _plan2ProposalLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _plan2ProposalLocalService.setBeanIdentifier(beanIdentifier);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public Plan2ProposalLocalService getWrappedPlan2ProposalLocalService() {
        return _plan2ProposalLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedPlan2ProposalLocalService(
        Plan2ProposalLocalService plan2ProposalLocalService) {
        _plan2ProposalLocalService = plan2ProposalLocalService;
    }

    public Plan2ProposalLocalService getWrappedService() {
        return _plan2ProposalLocalService;
    }

    public void setWrappedService(
        Plan2ProposalLocalService plan2ProposalLocalService) {
        _plan2ProposalLocalService = plan2ProposalLocalService;
    }
}
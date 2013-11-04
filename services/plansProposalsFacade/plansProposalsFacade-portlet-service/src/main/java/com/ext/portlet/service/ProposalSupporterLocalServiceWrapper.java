package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ProposalSupporterLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ProposalSupporterLocalService
 * @generated
 */
public class ProposalSupporterLocalServiceWrapper
    implements ProposalSupporterLocalService,
        ServiceWrapper<ProposalSupporterLocalService> {
    private ProposalSupporterLocalService _proposalSupporterLocalService;

    public ProposalSupporterLocalServiceWrapper(
        ProposalSupporterLocalService proposalSupporterLocalService) {
        _proposalSupporterLocalService = proposalSupporterLocalService;
    }

    /**
    * Adds the proposal supporter to the database. Also notifies the appropriate model listeners.
    *
    * @param proposalSupporter the proposal supporter
    * @return the proposal supporter that was added
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalSupporter addProposalSupporter(
        com.ext.portlet.model.ProposalSupporter proposalSupporter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposalSupporterLocalService.addProposalSupporter(proposalSupporter);
    }

    /**
    * Creates a new proposal supporter with the primary key. Does not add the proposal supporter to the database.
    *
    * @param proposalSupporterPK the primary key for the new proposal supporter
    * @return the new proposal supporter
    */
    public com.ext.portlet.model.ProposalSupporter createProposalSupporter(
        com.ext.portlet.service.persistence.ProposalSupporterPK proposalSupporterPK) {
        return _proposalSupporterLocalService.createProposalSupporter(proposalSupporterPK);
    }

    /**
    * Deletes the proposal supporter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param proposalSupporterPK the primary key of the proposal supporter
    * @throws PortalException if a proposal supporter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteProposalSupporter(
        com.ext.portlet.service.persistence.ProposalSupporterPK proposalSupporterPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _proposalSupporterLocalService.deleteProposalSupporter(proposalSupporterPK);
    }

    /**
    * Deletes the proposal supporter from the database. Also notifies the appropriate model listeners.
    *
    * @param proposalSupporter the proposal supporter
    * @throws SystemException if a system exception occurred
    */
    public void deleteProposalSupporter(
        com.ext.portlet.model.ProposalSupporter proposalSupporter)
        throws com.liferay.portal.kernel.exception.SystemException {
        _proposalSupporterLocalService.deleteProposalSupporter(proposalSupporter);
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
        return _proposalSupporterLocalService.dynamicQuery(dynamicQuery);
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
        return _proposalSupporterLocalService.dynamicQuery(dynamicQuery, start,
            end);
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
        return _proposalSupporterLocalService.dynamicQuery(dynamicQuery, start,
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
        return _proposalSupporterLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.ext.portlet.model.ProposalSupporter fetchProposalSupporter(
        com.ext.portlet.service.persistence.ProposalSupporterPK proposalSupporterPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposalSupporterLocalService.fetchProposalSupporter(proposalSupporterPK);
    }

    /**
    * Returns the proposal supporter with the primary key.
    *
    * @param proposalSupporterPK the primary key of the proposal supporter
    * @return the proposal supporter
    * @throws PortalException if a proposal supporter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalSupporter getProposalSupporter(
        com.ext.portlet.service.persistence.ProposalSupporterPK proposalSupporterPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _proposalSupporterLocalService.getProposalSupporter(proposalSupporterPK);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _proposalSupporterLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the proposal supporters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of proposal supporters
    * @param end the upper bound of the range of proposal supporters (not inclusive)
    * @return the range of proposal supporters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalSupporter> getProposalSupporters(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposalSupporterLocalService.getProposalSupporters(start, end);
    }

    /**
    * Returns the number of proposal supporters.
    *
    * @return the number of proposal supporters
    * @throws SystemException if a system exception occurred
    */
    public int getProposalSupportersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposalSupporterLocalService.getProposalSupportersCount();
    }

    /**
    * Updates the proposal supporter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param proposalSupporter the proposal supporter
    * @return the proposal supporter that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalSupporter updateProposalSupporter(
        com.ext.portlet.model.ProposalSupporter proposalSupporter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposalSupporterLocalService.updateProposalSupporter(proposalSupporter);
    }

    /**
    * Updates the proposal supporter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param proposalSupporter the proposal supporter
    * @param merge whether to merge the proposal supporter with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the proposal supporter that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalSupporter updateProposalSupporter(
        com.ext.portlet.model.ProposalSupporter proposalSupporter, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _proposalSupporterLocalService.updateProposalSupporter(proposalSupporter,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _proposalSupporterLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _proposalSupporterLocalService.setBeanIdentifier(beanIdentifier);
    }

    public com.ext.portlet.model.ProposalSupporter create(long proposalID,
        long userID) {
        return _proposalSupporterLocalService.create(proposalID, userID);
    }

    public java.util.List<com.ext.portlet.model.ProposalSupporter> getProposals(
        long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _proposalSupporterLocalService.getProposals(userId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ProposalSupporterLocalService getWrappedProposalSupporterLocalService() {
        return _proposalSupporterLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedProposalSupporterLocalService(
        ProposalSupporterLocalService proposalSupporterLocalService) {
        _proposalSupporterLocalService = proposalSupporterLocalService;
    }

    public ProposalSupporterLocalService getWrappedService() {
        return _proposalSupporterLocalService;
    }

    public void setWrappedService(
        ProposalSupporterLocalService proposalSupporterLocalService) {
        _proposalSupporterLocalService = proposalSupporterLocalService;
    }
}
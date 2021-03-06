package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SpamReportLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpamReportLocalService
 * @generated
 */
public class SpamReportLocalServiceWrapper implements SpamReportLocalService,
    ServiceWrapper<SpamReportLocalService> {
    private SpamReportLocalService _spamReportLocalService;

    public SpamReportLocalServiceWrapper(
        SpamReportLocalService spamReportLocalService) {
        _spamReportLocalService = spamReportLocalService;
    }

    /**
    * Adds the spam report to the database. Also notifies the appropriate model listeners.
    *
    * @param spamReport the spam report
    * @return the spam report that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.SpamReport addSpamReport(
        com.ext.portlet.model.SpamReport spamReport)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.addSpamReport(spamReport);
    }

    /**
    * Creates a new spam report with the primary key. Does not add the spam report to the database.
    *
    * @param id_ the primary key for the new spam report
    * @return the new spam report
    */
    @Override
    public com.ext.portlet.model.SpamReport createSpamReport(long id_) {
        return _spamReportLocalService.createSpamReport(id_);
    }

    /**
    * Deletes the spam report with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_ the primary key of the spam report
    * @return the spam report that was removed
    * @throws PortalException if a spam report with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.SpamReport deleteSpamReport(long id_)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.deleteSpamReport(id_);
    }

    /**
    * Deletes the spam report from the database. Also notifies the appropriate model listeners.
    *
    * @param spamReport the spam report
    * @return the spam report that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.SpamReport deleteSpamReport(
        com.ext.portlet.model.SpamReport spamReport)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.deleteSpamReport(spamReport);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _spamReportLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.SpamReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.SpamReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.ext.portlet.model.SpamReport fetchSpamReport(long id_)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.fetchSpamReport(id_);
    }

    /**
    * Returns the spam report with the primary key.
    *
    * @param id_ the primary key of the spam report
    * @return the spam report
    * @throws PortalException if a spam report with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.SpamReport getSpamReport(long id_)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.getSpamReport(id_);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the spam reports.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.SpamReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of spam reports
    * @param end the upper bound of the range of spam reports (not inclusive)
    * @return the range of spam reports
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.ext.portlet.model.SpamReport> getSpamReports(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.getSpamReports(start, end);
    }

    /**
    * Returns the number of spam reports.
    *
    * @return the number of spam reports
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getSpamReportsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.getSpamReportsCount();
    }

    /**
    * Updates the spam report in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param spamReport the spam report
    * @return the spam report that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.SpamReport updateSpamReport(
        com.ext.portlet.model.SpamReport spamReport)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.updateSpamReport(spamReport);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _spamReportLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _spamReportLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _spamReportLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.ext.portlet.model.SpamReport create()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.create();
    }

    @Override
    public com.ext.portlet.model.SpamReport create(long discussionMessageId,
        long spamUserId, long reporterUserId, boolean isAdminReport)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.create(discussionMessageId, spamUserId,
            reporterUserId, isAdminReport);
    }

    @Override
    public java.util.List<com.ext.portlet.model.SpamReport> getBySpamUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.getBySpamUserId(userId);
    }

    @Override
    public java.util.List<com.ext.portlet.model.SpamReport> getByDiscussionMessageId(
        long discussionMessageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.getByDiscussionMessageId(discussionMessageId);
    }

    @Override
    public java.util.List<com.ext.portlet.model.SpamReport> getByReporterUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.getByReporterUserId(userId);
    }

    @Override
    public boolean hasReporterUserIdDiscussionMessageId(long userId,
        long discussionMessageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.hasReporterUserIdDiscussionMessageId(userId,
            discussionMessageId);
    }

    @Override
    public com.ext.portlet.model.SpamReport getByReporterUserIdDiscussionMessageId(
        long userId, long discussionMessageId)
        throws com.ext.portlet.NoSuchSpamReportException,
            com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.getByReporterUserIdDiscussionMessageId(userId,
            discussionMessageId);
    }

    @Override
    public java.util.List<com.ext.portlet.model.SpamReport> getBySpamUserIdDiscussionMessageId(
        long userId, long discussionMessageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _spamReportLocalService.getBySpamUserIdDiscussionMessageId(userId,
            discussionMessageId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SpamReportLocalService getWrappedSpamReportLocalService() {
        return _spamReportLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSpamReportLocalService(
        SpamReportLocalService spamReportLocalService) {
        _spamReportLocalService = spamReportLocalService;
    }

    @Override
    public SpamReportLocalService getWrappedService() {
        return _spamReportLocalService;
    }

    @Override
    public void setWrappedService(SpamReportLocalService spamReportLocalService) {
        _spamReportLocalService = spamReportLocalService;
    }
}

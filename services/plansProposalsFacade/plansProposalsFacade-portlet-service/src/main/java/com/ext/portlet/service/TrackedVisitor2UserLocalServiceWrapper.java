package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrackedVisitor2UserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrackedVisitor2UserLocalService
 * @generated
 */
public class TrackedVisitor2UserLocalServiceWrapper
    implements TrackedVisitor2UserLocalService,
        ServiceWrapper<TrackedVisitor2UserLocalService> {
    private TrackedVisitor2UserLocalService _trackedVisitor2UserLocalService;

    public TrackedVisitor2UserLocalServiceWrapper(
        TrackedVisitor2UserLocalService trackedVisitor2UserLocalService) {
        _trackedVisitor2UserLocalService = trackedVisitor2UserLocalService;
    }

    /**
    * Adds the tracked visitor2 user to the database. Also notifies the appropriate model listeners.
    *
    * @param trackedVisitor2User the tracked visitor2 user
    * @return the tracked visitor2 user that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.TrackedVisitor2User addTrackedVisitor2User(
        com.ext.portlet.model.TrackedVisitor2User trackedVisitor2User)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.addTrackedVisitor2User(trackedVisitor2User);
    }

    /**
    * Creates a new tracked visitor2 user with the primary key. Does not add the tracked visitor2 user to the database.
    *
    * @param id the primary key for the new tracked visitor2 user
    * @return the new tracked visitor2 user
    */
    @Override
    public com.ext.portlet.model.TrackedVisitor2User createTrackedVisitor2User(
        long id) {
        return _trackedVisitor2UserLocalService.createTrackedVisitor2User(id);
    }

    /**
    * Deletes the tracked visitor2 user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the tracked visitor2 user
    * @return the tracked visitor2 user that was removed
    * @throws PortalException if a tracked visitor2 user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.TrackedVisitor2User deleteTrackedVisitor2User(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.deleteTrackedVisitor2User(id);
    }

    /**
    * Deletes the tracked visitor2 user from the database. Also notifies the appropriate model listeners.
    *
    * @param trackedVisitor2User the tracked visitor2 user
    * @return the tracked visitor2 user that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.TrackedVisitor2User deleteTrackedVisitor2User(
        com.ext.portlet.model.TrackedVisitor2User trackedVisitor2User)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.deleteTrackedVisitor2User(trackedVisitor2User);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _trackedVisitor2UserLocalService.dynamicQuery();
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
        return _trackedVisitor2UserLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.TrackedVisitor2UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _trackedVisitor2UserLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.TrackedVisitor2UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _trackedVisitor2UserLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _trackedVisitor2UserLocalService.dynamicQueryCount(dynamicQuery);
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
        return _trackedVisitor2UserLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.ext.portlet.model.TrackedVisitor2User fetchTrackedVisitor2User(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.fetchTrackedVisitor2User(id);
    }

    /**
    * Returns the tracked visitor2 user with the primary key.
    *
    * @param id the primary key of the tracked visitor2 user
    * @return the tracked visitor2 user
    * @throws PortalException if a tracked visitor2 user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.TrackedVisitor2User getTrackedVisitor2User(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.getTrackedVisitor2User(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the tracked visitor2 users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.TrackedVisitor2UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of tracked visitor2 users
    * @param end the upper bound of the range of tracked visitor2 users (not inclusive)
    * @return the range of tracked visitor2 users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.ext.portlet.model.TrackedVisitor2User> getTrackedVisitor2Users(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.getTrackedVisitor2Users(start,
            end);
    }

    /**
    * Returns the number of tracked visitor2 users.
    *
    * @return the number of tracked visitor2 users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getTrackedVisitor2UsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.getTrackedVisitor2UsersCount();
    }

    /**
    * Updates the tracked visitor2 user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param trackedVisitor2User the tracked visitor2 user
    * @return the tracked visitor2 user that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.TrackedVisitor2User updateTrackedVisitor2User(
        com.ext.portlet.model.TrackedVisitor2User trackedVisitor2User)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.updateTrackedVisitor2User(trackedVisitor2User);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _trackedVisitor2UserLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _trackedVisitor2UserLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _trackedVisitor2UserLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.lang.String findUuidForUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.findUuidForUserId(userId);
    }

    @Override
    public com.ext.portlet.model.TrackedVisitor2User addIfNotExists(
        java.lang.String uuid, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackedVisitor2UserLocalService.addIfNotExists(uuid, userId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TrackedVisitor2UserLocalService getWrappedTrackedVisitor2UserLocalService() {
        return _trackedVisitor2UserLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTrackedVisitor2UserLocalService(
        TrackedVisitor2UserLocalService trackedVisitor2UserLocalService) {
        _trackedVisitor2UserLocalService = trackedVisitor2UserLocalService;
    }

    @Override
    public TrackedVisitor2UserLocalService getWrappedService() {
        return _trackedVisitor2UserLocalService;
    }

    @Override
    public void setWrappedService(
        TrackedVisitor2UserLocalService trackedVisitor2UserLocalService) {
        _trackedVisitor2UserLocalService = trackedVisitor2UserLocalService;
    }
}

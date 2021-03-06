package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImpactDefaultSeriesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImpactDefaultSeriesLocalService
 * @generated
 */
public class ImpactDefaultSeriesLocalServiceWrapper
    implements ImpactDefaultSeriesLocalService,
        ServiceWrapper<ImpactDefaultSeriesLocalService> {
    private ImpactDefaultSeriesLocalService _impactDefaultSeriesLocalService;

    public ImpactDefaultSeriesLocalServiceWrapper(
        ImpactDefaultSeriesLocalService impactDefaultSeriesLocalService) {
        _impactDefaultSeriesLocalService = impactDefaultSeriesLocalService;
    }

    /**
    * Adds the impact default series to the database. Also notifies the appropriate model listeners.
    *
    * @param impactDefaultSeries the impact default series
    * @return the impact default series that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.ImpactDefaultSeries addImpactDefaultSeries(
        com.ext.portlet.model.ImpactDefaultSeries impactDefaultSeries)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.addImpactDefaultSeries(impactDefaultSeries);
    }

    /**
    * Creates a new impact default series with the primary key. Does not add the impact default series to the database.
    *
    * @param impactDefaultSeriesPK the primary key for the new impact default series
    * @return the new impact default series
    */
    @Override
    public com.ext.portlet.model.ImpactDefaultSeries createImpactDefaultSeries(
        com.ext.portlet.service.persistence.ImpactDefaultSeriesPK impactDefaultSeriesPK) {
        return _impactDefaultSeriesLocalService.createImpactDefaultSeries(impactDefaultSeriesPK);
    }

    /**
    * Deletes the impact default series with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param impactDefaultSeriesPK the primary key of the impact default series
    * @return the impact default series that was removed
    * @throws PortalException if a impact default series with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.ImpactDefaultSeries deleteImpactDefaultSeries(
        com.ext.portlet.service.persistence.ImpactDefaultSeriesPK impactDefaultSeriesPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.deleteImpactDefaultSeries(impactDefaultSeriesPK);
    }

    /**
    * Deletes the impact default series from the database. Also notifies the appropriate model listeners.
    *
    * @param impactDefaultSeries the impact default series
    * @return the impact default series that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.ImpactDefaultSeries deleteImpactDefaultSeries(
        com.ext.portlet.model.ImpactDefaultSeries impactDefaultSeries)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.deleteImpactDefaultSeries(impactDefaultSeries);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _impactDefaultSeriesLocalService.dynamicQuery();
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
        return _impactDefaultSeriesLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ImpactDefaultSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _impactDefaultSeriesLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ImpactDefaultSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _impactDefaultSeriesLocalService.dynamicQuery(dynamicQuery,
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
        return _impactDefaultSeriesLocalService.dynamicQueryCount(dynamicQuery);
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
        return _impactDefaultSeriesLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.ext.portlet.model.ImpactDefaultSeries fetchImpactDefaultSeries(
        com.ext.portlet.service.persistence.ImpactDefaultSeriesPK impactDefaultSeriesPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.fetchImpactDefaultSeries(impactDefaultSeriesPK);
    }

    /**
    * Returns the impact default series with the primary key.
    *
    * @param impactDefaultSeriesPK the primary key of the impact default series
    * @return the impact default series
    * @throws PortalException if a impact default series with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.ImpactDefaultSeries getImpactDefaultSeries(
        com.ext.portlet.service.persistence.ImpactDefaultSeriesPK impactDefaultSeriesPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.getImpactDefaultSeries(impactDefaultSeriesPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the impact default serieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ImpactDefaultSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of impact default serieses
    * @param end the upper bound of the range of impact default serieses (not inclusive)
    * @return the range of impact default serieses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.ext.portlet.model.ImpactDefaultSeries> getImpactDefaultSerieses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.getImpactDefaultSerieses(start,
            end);
    }

    /**
    * Returns the number of impact default serieses.
    *
    * @return the number of impact default serieses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getImpactDefaultSeriesesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.getImpactDefaultSeriesesCount();
    }

    /**
    * Updates the impact default series in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param impactDefaultSeries the impact default series
    * @return the impact default series that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.ImpactDefaultSeries updateImpactDefaultSeries(
        com.ext.portlet.model.ImpactDefaultSeries impactDefaultSeries)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.updateImpactDefaultSeries(impactDefaultSeries);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _impactDefaultSeriesLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _impactDefaultSeriesLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _impactDefaultSeriesLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.ext.portlet.model.ImpactDefaultSeries> getAllImpactDefaultSeriesWithFocusArea(
        com.ext.portlet.model.FocusArea focusArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.getAllImpactDefaultSeriesWithFocusArea(focusArea);
    }

    @Override
    public com.ext.portlet.model.ImpactDefaultSeries getImpactDefaultSeriesWithFocusAreaAndName(
        com.ext.portlet.model.FocusArea focusArea, java.lang.String name)
        throws com.ext.portlet.NoSuchImpactDefaultSeriesException,
            com.liferay.portal.kernel.exception.SystemException {
        return _impactDefaultSeriesLocalService.getImpactDefaultSeriesWithFocusAreaAndName(focusArea,
            name);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ImpactDefaultSeriesLocalService getWrappedImpactDefaultSeriesLocalService() {
        return _impactDefaultSeriesLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedImpactDefaultSeriesLocalService(
        ImpactDefaultSeriesLocalService impactDefaultSeriesLocalService) {
        _impactDefaultSeriesLocalService = impactDefaultSeriesLocalService;
    }

    @Override
    public ImpactDefaultSeriesLocalService getWrappedService() {
        return _impactDefaultSeriesLocalService;
    }

    @Override
    public void setWrappedService(
        ImpactDefaultSeriesLocalService impactDefaultSeriesLocalService) {
        _impactDefaultSeriesLocalService = impactDefaultSeriesLocalService;
    }
}

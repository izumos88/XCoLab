package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the messaging redirect link local service. This utility wraps {@link com.ext.portlet.service.impl.MessagingRedirectLinkLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingRedirectLinkLocalService
 * @see com.ext.portlet.service.base.MessagingRedirectLinkLocalServiceBaseImpl
 * @see com.ext.portlet.service.impl.MessagingRedirectLinkLocalServiceImpl
 * @generated
 */
public class MessagingRedirectLinkLocalServiceUtil {
    private static MessagingRedirectLinkLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.MessagingRedirectLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the messaging redirect link to the database. Also notifies the appropriate model listeners.
    *
    * @param messagingRedirectLink the messaging redirect link
    * @return the messaging redirect link that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.MessagingRedirectLink addMessagingRedirectLink(
        com.ext.portlet.model.MessagingRedirectLink messagingRedirectLink)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addMessagingRedirectLink(messagingRedirectLink);
    }

    /**
    * Creates a new messaging redirect link with the primary key. Does not add the messaging redirect link to the database.
    *
    * @param redirectId the primary key for the new messaging redirect link
    * @return the new messaging redirect link
    */
    public static com.ext.portlet.model.MessagingRedirectLink createMessagingRedirectLink(
        long redirectId) {
        return getService().createMessagingRedirectLink(redirectId);
    }

    /**
    * Deletes the messaging redirect link with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param redirectId the primary key of the messaging redirect link
    * @throws PortalException if a messaging redirect link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static void deleteMessagingRedirectLink(long redirectId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteMessagingRedirectLink(redirectId);
    }

    /**
    * Deletes the messaging redirect link from the database. Also notifies the appropriate model listeners.
    *
    * @param messagingRedirectLink the messaging redirect link
    * @throws SystemException if a system exception occurred
    */
    public static void deleteMessagingRedirectLink(
        com.ext.portlet.model.MessagingRedirectLink messagingRedirectLink)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteMessagingRedirectLink(messagingRedirectLink);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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

    public static com.ext.portlet.model.MessagingRedirectLink fetchMessagingRedirectLink(
        long redirectId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchMessagingRedirectLink(redirectId);
    }

    /**
    * Returns the messaging redirect link with the primary key.
    *
    * @param redirectId the primary key of the messaging redirect link
    * @return the messaging redirect link
    * @throws PortalException if a messaging redirect link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.MessagingRedirectLink getMessagingRedirectLink(
        long redirectId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getMessagingRedirectLink(redirectId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the messaging redirect links.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of messaging redirect links
    * @param end the upper bound of the range of messaging redirect links (not inclusive)
    * @return the range of messaging redirect links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.MessagingRedirectLink> getMessagingRedirectLinks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMessagingRedirectLinks(start, end);
    }

    /**
    * Returns the number of messaging redirect links.
    *
    * @return the number of messaging redirect links
    * @throws SystemException if a system exception occurred
    */
    public static int getMessagingRedirectLinksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMessagingRedirectLinksCount();
    }

    /**
    * Updates the messaging redirect link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param messagingRedirectLink the messaging redirect link
    * @return the messaging redirect link that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.MessagingRedirectLink updateMessagingRedirectLink(
        com.ext.portlet.model.MessagingRedirectLink messagingRedirectLink)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateMessagingRedirectLink(messagingRedirectLink);
    }

    /**
    * Updates the messaging redirect link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param messagingRedirectLink the messaging redirect link
    * @param merge whether to merge the messaging redirect link with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the messaging redirect link that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.MessagingRedirectLink updateMessagingRedirectLink(
        com.ext.portlet.model.MessagingRedirectLink messagingRedirectLink,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateMessagingRedirectLink(messagingRedirectLink, merge);
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

    public static void clearService() {
        _service = null;
    }

    public static MessagingRedirectLinkLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MessagingRedirectLinkLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    MessagingRedirectLinkLocalService.class.getName(),
                    portletClassLoader);

            _service = new MessagingRedirectLinkLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(MessagingRedirectLinkLocalServiceUtil.class,
                "_service");
            MethodCache.remove(MessagingRedirectLinkLocalService.class);
        }

        return _service;
    }

    public void setService(MessagingRedirectLinkLocalService service) {
        MethodCache.remove(MessagingRedirectLinkLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(MessagingRedirectLinkLocalServiceUtil.class,
            "_service");
        MethodCache.remove(MessagingRedirectLinkLocalService.class);
    }
}
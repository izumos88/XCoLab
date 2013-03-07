package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the messaging ignored recipients remote service. This utility wraps {@link com.ext.portlet.service.impl.MessagingIgnoredRecipientsServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingIgnoredRecipientsService
 * @see com.ext.portlet.service.base.MessagingIgnoredRecipientsServiceBaseImpl
 * @see com.ext.portlet.service.impl.MessagingIgnoredRecipientsServiceImpl
 * @generated
 */
public class MessagingIgnoredRecipientsServiceUtil {
    private static MessagingIgnoredRecipientsService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.MessagingIgnoredRecipientsServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */
    public static void clearService() {
        _service = null;
    }

    public static MessagingIgnoredRecipientsService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MessagingIgnoredRecipientsService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    MessagingIgnoredRecipientsService.class.getName(),
                    portletClassLoader);

            _service = new MessagingIgnoredRecipientsServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(MessagingIgnoredRecipientsServiceUtil.class,
                "_service");
            MethodCache.remove(MessagingIgnoredRecipientsService.class);
        }

        return _service;
    }

    public void setService(MessagingIgnoredRecipientsService service) {
        MethodCache.remove(MessagingIgnoredRecipientsService.class);

        _service = service;

        ReferenceRegistry.registerReference(MessagingIgnoredRecipientsServiceUtil.class,
            "_service");
        MethodCache.remove(MessagingIgnoredRecipientsService.class);
    }
}
package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the proposal supporter remote service. This utility wraps {@link com.ext.portlet.service.impl.ProposalSupporterServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalSupporterService
 * @see com.ext.portlet.service.base.ProposalSupporterServiceBaseImpl
 * @see com.ext.portlet.service.impl.ProposalSupporterServiceImpl
 * @generated
 */
public class ProposalSupporterServiceUtil {
    private static ProposalSupporterService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.ProposalSupporterServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */
    public static void clearService() {
        _service = null;
    }

    public static ProposalSupporterService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ProposalSupporterService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    ProposalSupporterService.class.getName(), portletClassLoader);

            _service = new ProposalSupporterServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(ProposalSupporterServiceUtil.class,
                "_service");
            MethodCache.remove(ProposalSupporterService.class);
        }

        return _service;
    }

    public void setService(ProposalSupporterService service) {
        MethodCache.remove(ProposalSupporterService.class);

        _service = service;

        ReferenceRegistry.registerReference(ProposalSupporterServiceUtil.class,
            "_service");
        MethodCache.remove(ProposalSupporterService.class);
    }
}
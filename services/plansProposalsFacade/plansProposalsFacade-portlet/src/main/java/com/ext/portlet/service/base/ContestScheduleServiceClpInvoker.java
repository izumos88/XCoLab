package com.ext.portlet.service.base;

import com.ext.portlet.service.ContestScheduleServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContestScheduleServiceClpInvoker {
    private String _methodName642;
    private String[] _methodParameterTypes642;
    private String _methodName643;
    private String[] _methodParameterTypes643;

    public ContestScheduleServiceClpInvoker() {
        _methodName642 = "getBeanIdentifier";

        _methodParameterTypes642 = new String[] {  };

        _methodName643 = "setBeanIdentifier";

        _methodParameterTypes643 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName642.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes642, parameterTypes)) {
            return ContestScheduleServiceUtil.getBeanIdentifier();
        }

        if (_methodName643.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes643, parameterTypes)) {
            ContestScheduleServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}

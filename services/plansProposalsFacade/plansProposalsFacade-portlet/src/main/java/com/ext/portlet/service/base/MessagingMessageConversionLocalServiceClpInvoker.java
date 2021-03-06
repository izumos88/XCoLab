package com.ext.portlet.service.base;

import com.ext.portlet.service.MessagingMessageConversionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MessagingMessageConversionLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName518;
    private String[] _methodParameterTypes518;
    private String _methodName519;
    private String[] _methodParameterTypes519;
    private String _methodName524;
    private String[] _methodParameterTypes524;
    private String _methodName525;
    private String[] _methodParameterTypes525;
    private String _methodName526;
    private String[] _methodParameterTypes526;
    private String _methodName527;
    private String[] _methodParameterTypes527;
    private String _methodName528;
    private String[] _methodParameterTypes528;

    public MessagingMessageConversionLocalServiceClpInvoker() {
        _methodName0 = "addMessagingMessageConversion";

        _methodParameterTypes0 = new String[] {
                "com.ext.portlet.model.MessagingMessageConversion"
            };

        _methodName1 = "createMessagingMessageConversion";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteMessagingMessageConversion";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteMessagingMessageConversion";

        _methodParameterTypes3 = new String[] {
                "com.ext.portlet.model.MessagingMessageConversion"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchMessagingMessageConversion";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getMessagingMessageConversion";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getMessagingMessageConversions";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getMessagingMessageConversionsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateMessagingMessageConversion";

        _methodParameterTypes15 = new String[] {
                "com.ext.portlet.model.MessagingMessageConversion"
            };

        _methodName518 = "getBeanIdentifier";

        _methodParameterTypes518 = new String[] {  };

        _methodName519 = "setBeanIdentifier";

        _methodParameterTypes519 = new String[] { "java.lang.String" };

        _methodName524 = "countByType";

        _methodParameterTypes524 = new String[] {
                "java.lang.Long",
                "com.ext.portlet.model.MessagingMessageConversionType"
            };

        _methodName525 = "countByType";

        _methodParameterTypes525 = new String[] {
                "java.lang.Long", "java.lang.String"
            };

        _methodName526 = "addConversion";

        _methodParameterTypes526 = new String[] {
                "java.lang.Long", "java.lang.String", "java.lang.String",
                "java.lang.Object", "java.lang.Object"
            };

        _methodName527 = "countConversionsByIP";

        _methodParameterTypes527 = new String[] {
                "java.lang.Long", "java.lang.String"
            };

        _methodName528 = "countConversionsByRecipient";

        _methodParameterTypes528 = new String[] {
                "java.lang.Long", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.addMessagingMessageConversion((com.ext.portlet.model.MessagingMessageConversion) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.createMessagingMessageConversion(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.deleteMessagingMessageConversion(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.deleteMessagingMessageConversion((com.ext.portlet.model.MessagingMessageConversion) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.fetchMessagingMessageConversion(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.getMessagingMessageConversion(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.getMessagingMessageConversions(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.getMessagingMessageConversionsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.updateMessagingMessageConversion((com.ext.portlet.model.MessagingMessageConversion) arguments[0]);
        }

        if (_methodName518.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes518, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName519.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes519, parameterTypes)) {
            MessagingMessageConversionLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName524.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes524, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.countByType((java.lang.Long) arguments[0],
                (com.ext.portlet.model.MessagingMessageConversionType) arguments[1]);
        }

        if (_methodName525.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes525, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.countByType((java.lang.Long) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName526.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes526, parameterTypes)) {
            MessagingMessageConversionLocalServiceUtil.addConversion((java.lang.Long) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.Object) arguments[3], (java.lang.Object) arguments[4]);

            return null;
        }

        if (_methodName527.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes527, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.countConversionsByIP((java.lang.Long) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName528.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes528, parameterTypes)) {
            return MessagingMessageConversionLocalServiceUtil.countConversionsByRecipient((java.lang.Long) arguments[0],
                (java.lang.String) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}

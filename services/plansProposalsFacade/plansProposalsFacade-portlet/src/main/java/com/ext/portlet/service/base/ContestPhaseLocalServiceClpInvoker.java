package com.ext.portlet.service.base;

import com.ext.portlet.service.ContestPhaseLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContestPhaseLocalServiceClpInvoker {
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
    private String _methodName529;
    private String[] _methodParameterTypes529;
    private String _methodName530;
    private String[] _methodParameterTypes530;
    private String _methodName531;
    private String[] _methodParameterTypes531;
    private String _methodName532;
    private String[] _methodParameterTypes532;
    private String _methodName533;
    private String[] _methodParameterTypes533;
    private String _methodName534;
    private String[] _methodParameterTypes534;
    private String _methodName535;
    private String[] _methodParameterTypes535;
    private String _methodName536;
    private String[] _methodParameterTypes536;
    private String _methodName537;
    private String[] _methodParameterTypes537;
    private String _methodName538;
    private String[] _methodParameterTypes538;
    private String _methodName539;
    private String[] _methodParameterTypes539;
    private String _methodName540;
    private String[] _methodParameterTypes540;
    private String _methodName541;
    private String[] _methodParameterTypes541;
    private String _methodName542;
    private String[] _methodParameterTypes542;
    private String _methodName543;
    private String[] _methodParameterTypes543;
    private String _methodName544;
    private String[] _methodParameterTypes544;
    private String _methodName545;
    private String[] _methodParameterTypes545;

    public ContestPhaseLocalServiceClpInvoker() {
        _methodName0 = "addContestPhase";

        _methodParameterTypes0 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName1 = "createContestPhase";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteContestPhase";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteContestPhase";

        _methodParameterTypes3 = new String[] {
                "com.ext.portlet.model.ContestPhase"
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

        _methodName10 = "fetchContestPhase";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getContestPhase";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getContestPhases";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getContestPhasesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateContestPhase";

        _methodParameterTypes15 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName518 = "getBeanIdentifier";

        _methodParameterTypes518 = new String[] {  };

        _methodName519 = "setBeanIdentifier";

        _methodParameterTypes519 = new String[] { "java.lang.String" };

        _methodName524 = "overrideClock";

        _methodParameterTypes524 = new String[] { "org.xcolab.utils.Clock" };

        _methodName525 = "getContestStatus";

        _methodParameterTypes525 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName526 = "getContestStatusStr";

        _methodParameterTypes526 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName527 = "getPhaseColumns";

        _methodParameterTypes527 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName528 = "getPhaseColumnsRaw";

        _methodParameterTypes528 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName529 = "getPreviousPhases";

        _methodParameterTypes529 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName530 = "getNextContestPhase";

        _methodParameterTypes530 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName531 = "getPhaseActive";

        _methodParameterTypes531 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName532 = "getPhasesForContest";

        _methodParameterTypes532 = new String[] { "com.ext.portlet.model.Contest" };

        _methodName533 = "getPhasesForContest";

        _methodParameterTypes533 = new String[] { "long" };

        _methodName534 = "getPhasesForContestScheduleId";

        _methodParameterTypes534 = new String[] { "long" };

        _methodName535 = "getPhasesForContestScheduleIdAndContest";

        _methodParameterTypes535 = new String[] { "long", "long" };

        _methodName536 = "getPhasesForContestScheduleIdAndPhaseType";

        _methodParameterTypes536 = new String[] { "long", "long" };

        _methodName537 = "getActivePhaseForContest";

        _methodParameterTypes537 = new String[] { "com.ext.portlet.model.Contest" };

        _methodName538 = "getContest";

        _methodParameterTypes538 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName539 = "getName";

        _methodParameterTypes539 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName540 = "promoteProposal";

        _methodParameterTypes540 = new String[] { "long", "long", "long" };

        _methodName541 = "autoPromoteProposals";

        _methodParameterTypes541 = new String[] {  };

        _methodName542 = "createFromContestPhase";

        _methodParameterTypes542 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName543 = "forcePromotionOfProposalInPhase";

        _methodParameterTypes543 = new String[] {
                "com.ext.portlet.model.Proposal",
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName544 = "getNumberOfProposalsForJudge";

        _methodParameterTypes544 = new String[] {
                "com.liferay.portal.model.User",
                "com.ext.portlet.model.ContestPhase"
            };

        _methodName545 = "getContestPhaseLinkUrl";

        _methodParameterTypes545 = new String[] {
                "com.ext.portlet.model.ContestPhase"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.addContestPhase((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.createContestPhase(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.deleteContestPhase(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.deleteContestPhase((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.fetchContestPhase(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getContestPhase(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getContestPhases(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getContestPhasesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.updateContestPhase((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName518.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes518, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName519.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes519, parameterTypes)) {
            ContestPhaseLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName524.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes524, parameterTypes)) {
            ContestPhaseLocalServiceUtil.overrideClock((org.xcolab.utils.Clock) arguments[0]);

            return null;
        }

        if (_methodName525.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes525, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getContestStatus((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName526.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes526, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getContestStatusStr((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName527.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes527, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getPhaseColumns((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName528.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes528, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getPhaseColumnsRaw((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName529.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes529, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getPreviousPhases((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName530.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes530, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getNextContestPhase((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName531.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes531, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getPhaseActive((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName532.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes532, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getPhasesForContest((com.ext.portlet.model.Contest) arguments[0]);
        }

        if (_methodName533.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes533, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getPhasesForContest(((Long) arguments[0]).longValue());
        }

        if (_methodName534.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes534, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getPhasesForContestScheduleId(((Long) arguments[0]).longValue());
        }

        if (_methodName535.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes535, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getPhasesForContestScheduleIdAndContest(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName536.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes536, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getPhasesForContestScheduleIdAndPhaseType(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName537.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes537, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getActivePhaseForContest((com.ext.portlet.model.Contest) arguments[0]);
        }

        if (_methodName538.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes538, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getContest((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName539.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes539, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getName((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName540.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes540, parameterTypes)) {
            ContestPhaseLocalServiceUtil.promoteProposal(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue());

            return null;
        }

        if (_methodName541.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes541, parameterTypes)) {
            ContestPhaseLocalServiceUtil.autoPromoteProposals();

            return null;
        }

        if (_methodName542.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes542, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.createFromContestPhase((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        if (_methodName543.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes543, parameterTypes)) {
            ContestPhaseLocalServiceUtil.forcePromotionOfProposalInPhase((com.ext.portlet.model.Proposal) arguments[0],
                (com.ext.portlet.model.ContestPhase) arguments[1]);

            return null;
        }

        if (_methodName544.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes544, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getNumberOfProposalsForJudge((com.liferay.portal.model.User) arguments[0],
                (com.ext.portlet.model.ContestPhase) arguments[1]);
        }

        if (_methodName545.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes545, parameterTypes)) {
            return ContestPhaseLocalServiceUtil.getContestPhaseLinkUrl((com.ext.portlet.model.ContestPhase) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}

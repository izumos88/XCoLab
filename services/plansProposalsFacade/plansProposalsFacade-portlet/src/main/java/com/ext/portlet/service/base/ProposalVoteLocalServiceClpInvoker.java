package com.ext.portlet.service.base;

import com.ext.portlet.service.ProposalVoteLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProposalVoteLocalServiceClpInvoker {
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

    public ProposalVoteLocalServiceClpInvoker() {
        _methodName0 = "addProposalVote";

        _methodParameterTypes0 = new String[] {
                "com.ext.portlet.model.ProposalVote"
            };

        _methodName1 = "createProposalVote";

        _methodParameterTypes1 = new String[] {
                "com.ext.portlet.service.persistence.ProposalVotePK"
            };

        _methodName2 = "deleteProposalVote";

        _methodParameterTypes2 = new String[] {
                "com.ext.portlet.service.persistence.ProposalVotePK"
            };

        _methodName3 = "deleteProposalVote";

        _methodParameterTypes3 = new String[] {
                "com.ext.portlet.model.ProposalVote"
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

        _methodName10 = "fetchProposalVote";

        _methodParameterTypes10 = new String[] {
                "com.ext.portlet.service.persistence.ProposalVotePK"
            };

        _methodName11 = "getProposalVote";

        _methodParameterTypes11 = new String[] {
                "com.ext.portlet.service.persistence.ProposalVotePK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getProposalVotes";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getProposalVotesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateProposalVote";

        _methodParameterTypes15 = new String[] {
                "com.ext.portlet.model.ProposalVote"
            };

        _methodName518 = "getBeanIdentifier";

        _methodParameterTypes518 = new String[] {  };

        _methodName519 = "setBeanIdentifier";

        _methodParameterTypes519 = new String[] { "java.lang.String" };

        _methodName524 = "create";

        _methodParameterTypes524 = new String[] { "long", "long" };

        _methodName525 = "findByProposalIdContestPhaseIdUserId";

        _methodParameterTypes525 = new String[] { "long", "long" };

        _methodName526 = "hasUserVoted";

        _methodParameterTypes526 = new String[] { "long", "long" };

        _methodName527 = "findByProposalIdUserId";

        _methodParameterTypes527 = new String[] { "long", "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.addProposalVote((com.ext.portlet.model.ProposalVote) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.createProposalVote((com.ext.portlet.service.persistence.ProposalVotePK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.deleteProposalVote((com.ext.portlet.service.persistence.ProposalVotePK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.deleteProposalVote((com.ext.portlet.model.ProposalVote) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.fetchProposalVote((com.ext.portlet.service.persistence.ProposalVotePK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.getProposalVote((com.ext.portlet.service.persistence.ProposalVotePK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.getProposalVotes(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.getProposalVotesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.updateProposalVote((com.ext.portlet.model.ProposalVote) arguments[0]);
        }

        if (_methodName518.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes518, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName519.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes519, parameterTypes)) {
            ProposalVoteLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName524.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes524, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.create(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName525.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes525, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.findByProposalIdContestPhaseIdUserId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName526.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes526, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.hasUserVoted(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName527.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes527, parameterTypes)) {
            return ProposalVoteLocalServiceUtil.findByProposalIdUserId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}

package org.xcolab.portlets.proposals.wrappers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.xcolab.portlets.proposals.utils.ProposalsContext;

import javax.portlet.PortletRequest;

public interface ProposalTabActivityCountAlgorithm {
    int getActivityCount(ProposalsContext context, PortletRequest request);
    
    public static ProposalTabActivityCountAlgorithm alwaysZero = new ProposalTabActivityCountAlgorithm() {
        
        @Override
        public int getActivityCount(ProposalsContext context, PortletRequest request) {
            return 0;
        }
    };


    public static ProposalTabActivityCountAlgorithm evaluationCommentsCount = new ProposalTabActivityCountAlgorithm() {

        @Override
        public int getActivityCount(ProposalsContext context, PortletRequest request) {
            try {
                return (int) context.getProposalWrapped(request).getEvaluationCommentsCount();
            } catch (PortalException e) {
                _log.error("can't get comments count for a proposal", e);
            } catch (SystemException e) {
                _log.error("can't get comments count for a proposal", e);
            }
            return 0;
        }
        private Log _log = LogFactoryUtil.getLog(ProposalTabActivityCountAlgorithm.class);
    };

    public static ProposalTabActivityCountAlgorithm fellowReviewCommentsCount = new ProposalTabActivityCountAlgorithm() {

        @Override
        public int getActivityCount(ProposalsContext context, PortletRequest request) {
            try {
                return (int) context.getProposalWrapped(request).getFellowReviewCommentsCount();
            } catch (PortalException e) {
                _log.error("can't get comments count for a proposal", e);
            } catch (SystemException e) {
                _log.error("can't get comments count for a proposal", e);
            }
            return 0;
        }
        private Log _log = LogFactoryUtil.getLog(ProposalTabActivityCountAlgorithm.class);
    };


    public static ProposalTabActivityCountAlgorithm commentsCount = new ProposalTabActivityCountAlgorithm() {
        
        @Override
        public int getActivityCount(ProposalsContext context, PortletRequest request) {
            try {
                return (int) context.getProposalWrapped(request).getCommentsCount();
            } catch (PortalException e) {
                _log.error("can't get comments count for a proposal", e);
            } catch (SystemException e) {
                _log.error("can't get comments count for a proposal", e);
            }
            return 0;
        }
        private Log _log = LogFactoryUtil.getLog(ProposalTabActivityCountAlgorithm.class);
    };
    
    public static ProposalTabActivityCountAlgorithm membersCount = new ProposalTabActivityCountAlgorithm() {
        
        @Override
        public int getActivityCount(ProposalsContext context, PortletRequest request) {
            try {
                return (int) context.getProposalWrapped(request).getMembers().size();
            } catch (PortalException e) {
                _log.error("can't get comments count for a proposal", e);
            } catch (SystemException e) {
                _log.error("can't get comments count for a proposal", e);
            }
            return 0;
        }
        private Log _log = LogFactoryUtil.getLog(ProposalTabActivityCountAlgorithm.class);
    };
}

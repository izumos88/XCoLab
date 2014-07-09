package org.xcolab.services.tasks;

import com.ext.portlet.service.ContestPhaseLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

/**
 * This scheduler automatically invokes the automatic promotion of proposals from the last contest phase
 * of all contests to the next active contest phase. Promotion of proposals is either done automatically for all
 * proposals of the last active contest phase or based on judging decisions, depending on the
 * {@link com.ext.portlet.model.ContestPhase#getContestPhaseAutopromote()} attribute.
 *
 * Created by kmang on 27/05/14.
 */
public class ProposalContestPhaseAutopromoteTask implements MessageListener {

    private Log _log = LogFactoryUtil.getLog(ProposalContestPhaseAutopromoteTask.class);

    @Override
    public void receive(Message message) throws MessageListenerException {
        try {
            ContestPhaseLocalServiceUtil.autoPromoteProposals();
        } catch (PortalException | SystemException e) {
            _log.error("Error while promoting proposals in contest phases", e);
        }
    }
}
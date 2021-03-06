package org.xcolab.portlets.proposals.view.action;

import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xcolab.portlets.proposals.exceptions.ProposalsAuthorizationException;
import org.xcolab.portlets.proposals.utils.ProposalsContext;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;

@Controller
@RequestMapping("view")
public class SubscribeProposalActionController {

    @Autowired
    private ProposalsContext proposalsContext;
    
    @RequestMapping(params = {"action=subscribeProposal"})
    public void handleAction(ActionRequest request, Model model, ActionResponse response)
            throws PortalException, SystemException, ProposalsAuthorizationException, IOException {
        
        if (proposalsContext.getPermissions(request).getCanSubscribeProposal()) {
            long proposalId = proposalsContext.getProposal(request).getProposalId();
            long userId = proposalsContext.getUser(request).getUserId();
            if (ProposalLocalServiceUtil.isSubscribed(proposalId, userId)) {
                ProposalLocalServiceUtil.unsubscribe(proposalId, userId);
            }
            else {
                ProposalLocalServiceUtil.subscribe(proposalId, userId);
            }
            response.sendRedirect(ProposalLocalServiceUtil.getProposalLinkUrl(proposalId));
        }
        else {
            throw new ProposalsAuthorizationException("User isn't allowed to subscribe proposal");
        }
    }

}

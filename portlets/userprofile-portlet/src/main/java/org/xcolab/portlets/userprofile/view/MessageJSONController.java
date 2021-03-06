package org.xcolab.portlets.userprofile.view;

import com.ext.portlet.messaging.MessageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import org.xcolab.client.members.exceptions.MemberNotFoundException;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.portlets.userprofile.beans.MessageBean;
import org.xcolab.portlets.userprofile.utils.JSONHelper;
import org.xcolab.client.members.MembersClient;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Created by Thomas on 1/12/2015.
 */
@Controller
@RequestMapping("view")
public class MessageJSONController extends JSONHelper {

    private final static Log _log = LogFactoryUtil.getLog(MessageJSONController.class);
    private final static String LIMIT_SUCCEEDED_EXCEPTION = "LIMIT_SUCCEEDED";
    private MessageBean messageBean;
    private User userSender;

    @Autowired
    private SmartValidator validator;

    public MessageJSONController() {
    }

    @InitBinder("messageBean")
    public void initMessageBeanBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @ResourceMapping(value = "submitSendMessageForm2")
    void handleSubmitSendMessageFormAJAXReques2() {
        System.out.println("userIdRecipient");
    }

    @ResourceMapping("submitSendMessageForm")
    public
    @ResponseBody
    void handleSubmitSendMessageFormAJAXRequest(
            ResourceRequest request, ResourceResponse response,
            @ModelAttribute MessageBean messageBean, BindingResult result,
            @RequestParam("userIdRecipient") Long userIdRecipient) {

        if (!result.hasErrors()) {
            try {
                User userSender = com.liferay.portal.util.PortalUtil.getUser(request);
                userSender.getPassword();
                User recipientUser = UserLocalServiceUtil.getUser(userIdRecipient);
                sendMessage(messageBean, userSender, recipientUser);
                this.writeSuccessResultResponseJSON(true, response);
            } catch (Exception e) {
                String exceptionMessage = e.getMessage();
                if (exceptionMessage.equals(LIMIT_SUCCEEDED_EXCEPTION)) {
                    this.writeErrorResultResponseJSON(LIMIT_SUCCEEDED_EXCEPTION, response);
                } else {
                    this.writeSuccessResultResponseJSON(false, response);
                }
            }
        } else {
            this.writeSuccessResultResponseJSON(false, response);
        }

    }

    private void sendMessage(MessageBean messageBean, User userSender, User userRecipient) throws Exception {
        init(messageBean, userSender, userRecipient);
        sendMessageToRecipientsInMessageBean();
    }

    private void init(MessageBean messageBean, User userSender, User userRecipient)
            throws MemberNotFoundException {
        if (userSender != null && messageBean != null && userRecipient != null) {
            this.userSender = userSender;
            this.messageBean = messageBean;
            messageBean.addRecipientUser(MembersClient.getMember(userRecipient.getUserId()));
        }
    }

    private void sendMessageToRecipientsInMessageBean() throws Exception {
        List<Long> recipients = new ArrayList<>();
        for (Member recipient : messageBean.getTo()) {
            recipients.add(recipient.getId_());
        }
        boolean sendSuccess = MessageUtil.checkLimitAndSendMessage(
                messageBean.getMessageSubject(), messageBean.getMessageText(), userSender, recipients);

        if (!sendSuccess) {
            throw new Exception(LIMIT_SUCCEEDED_EXCEPTION);
        }
    }

}

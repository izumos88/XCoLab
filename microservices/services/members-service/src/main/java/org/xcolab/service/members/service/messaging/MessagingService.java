package org.xcolab.service.members.service.messaging;

import org.xcolab.service.members.domain.messaging.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

    @Autowired
    private MessageDao messageDao;

    //TODO: combine into sendMessage method
    public void createMessage(long messageId, long senderId, long repliesToId, String subject, String content) {
        messageDao.createMessage(messageId, senderId, repliesToId, subject, content);
    }
    public void createRecipient(long messageRecipientStatusId, long messageId, long recipientId) {
        messageDao.createMessageRecipient(messageRecipientStatusId, messageId, recipientId);
    }
}

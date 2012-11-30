package com.ext.portlet.messaging.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Message service. Represents a row in the &quot;Messaging_Message&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.messaging.model.impl.MessageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.messaging.model.impl.MessageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Message
 * @see com.ext.portlet.messaging.model.impl.MessageImpl
 * @see com.ext.portlet.messaging.model.impl.MessageModelImpl
 * @generated
 */
public interface MessageModel extends BaseModel<Message> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a message model instance should use the {@link Message} interface instead.
     */

    /**
     * Returns the primary key of this message.
     *
     * @return the primary key of this message
     */
    public Long getPrimaryKey();

    /**
     * Sets the primary key of this message.
     *
     * @param primaryKey the primary key of this message
     */
    public void setPrimaryKey(Long primaryKey);

    /**
     * Returns the message ID of this message.
     *
     * @return the message ID of this message
     */
    public Long getMessageId();

    /**
     * Sets the message ID of this message.
     *
     * @param messageId the message ID of this message
     */
    public void setMessageId(Long messageId);

    /**
     * Returns the from ID of this message.
     *
     * @return the from ID of this message
     */
    public Long getFromId();

    /**
     * Sets the from ID of this message.
     *
     * @param fromId the from ID of this message
     */
    public void setFromId(Long fromId);

    /**
     * Returns the replies to of this message.
     *
     * @return the replies to of this message
     */
    public Long getRepliesTo();

    /**
     * Sets the replies to of this message.
     *
     * @param repliesTo the replies to of this message
     */
    public void setRepliesTo(Long repliesTo);

    /**
     * Returns the create date of this message.
     *
     * @return the create date of this message
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this message.
     *
     * @param createDate the create date of this message
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the subject of this message.
     *
     * @return the subject of this message
     */
    @AutoEscape
    public String getSubject();

    /**
     * Sets the subject of this message.
     *
     * @param subject the subject of this message
     */
    public void setSubject(String subject);

    /**
     * Returns the content of this message.
     *
     * @return the content of this message
     */
    @AutoEscape
    public String getContent();

    /**
     * Sets the content of this message.
     *
     * @param content the content of this message
     */
    public void setContent(String content);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(Message message);

    public int hashCode();

    public CacheModel<Message> toCacheModel();

    public Message toEscapedModel();

    public String toString();

    public String toXmlString();
}

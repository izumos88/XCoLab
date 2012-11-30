package com.ext.portlet.messaging.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the MessageRecipientStatus service. Represents a row in the &quot;Messaging_MessageRecipientStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.messaging.model.impl.MessageRecipientStatusModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.messaging.model.impl.MessageRecipientStatusImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageRecipientStatus
 * @see com.ext.portlet.messaging.model.impl.MessageRecipientStatusImpl
 * @see com.ext.portlet.messaging.model.impl.MessageRecipientStatusModelImpl
 * @generated
 */
public interface MessageRecipientStatusModel extends BaseModel<MessageRecipientStatus> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a message recipient status model instance should use the {@link MessageRecipientStatus} interface instead.
     */

    /**
     * Returns the primary key of this message recipient status.
     *
     * @return the primary key of this message recipient status
     */
    public Long getPrimaryKey();

    /**
     * Sets the primary key of this message recipient status.
     *
     * @param primaryKey the primary key of this message recipient status
     */
    public void setPrimaryKey(Long primaryKey);

    /**
     * Returns the message recipient ID of this message recipient status.
     *
     * @return the message recipient ID of this message recipient status
     */
    public Long getMessageRecipientId();

    /**
     * Sets the message recipient ID of this message recipient status.
     *
     * @param messageRecipientId the message recipient ID of this message recipient status
     */
    public void setMessageRecipientId(Long messageRecipientId);

    /**
     * Returns the message ID of this message recipient status.
     *
     * @return the message ID of this message recipient status
     */
    public Long getMessageId();

    /**
     * Sets the message ID of this message recipient status.
     *
     * @param messageId the message ID of this message recipient status
     */
    public void setMessageId(Long messageId);

    /**
     * Returns the user ID of this message recipient status.
     *
     * @return the user ID of this message recipient status
     */
    public Long getUserId();

    /**
     * Sets the user ID of this message recipient status.
     *
     * @param userId the user ID of this message recipient status
     */
    public void setUserId(Long userId);

    /**
     * Returns the opened of this message recipient status.
     *
     * @return the opened of this message recipient status
     */
    public Boolean getOpened();

    /**
     * Sets the opened of this message recipient status.
     *
     * @param opened the opened of this message recipient status
     */
    public void setOpened(Boolean opened);

    /**
     * Returns the archived of this message recipient status.
     *
     * @return the archived of this message recipient status
     */
    public Boolean getArchived();

    /**
     * Sets the archived of this message recipient status.
     *
     * @param archived the archived of this message recipient status
     */
    public void setArchived(Boolean archived);

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

    public int compareTo(MessageRecipientStatus messageRecipientStatus);

    public int hashCode();

    public CacheModel<MessageRecipientStatus> toCacheModel();

    public MessageRecipientStatus toEscapedModel();

    public String toString();

    public String toXmlString();
}

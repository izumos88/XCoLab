package com.ext.portlet.messaging.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the MessagingUserPreferences service. Represents a row in the &quot;Messaging_MessagingUserPreferences&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.messaging.model.impl.MessagingUserPreferencesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.messaging.model.impl.MessagingUserPreferencesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingUserPreferences
 * @see com.ext.portlet.messaging.model.impl.MessagingUserPreferencesImpl
 * @see com.ext.portlet.messaging.model.impl.MessagingUserPreferencesModelImpl
 * @generated
 */
public interface MessagingUserPreferencesModel extends BaseModel<MessagingUserPreferences> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a messaging user preferences model instance should use the {@link MessagingUserPreferences} interface instead.
     */

    /**
     * Returns the primary key of this messaging user preferences.
     *
     * @return the primary key of this messaging user preferences
     */
    public Long getPrimaryKey();

    /**
     * Sets the primary key of this messaging user preferences.
     *
     * @param primaryKey the primary key of this messaging user preferences
     */
    public void setPrimaryKey(Long primaryKey);

    /**
     * Returns the messaging preferences ID of this messaging user preferences.
     *
     * @return the messaging preferences ID of this messaging user preferences
     */
    public Long getMessagingPreferencesId();

    /**
     * Sets the messaging preferences ID of this messaging user preferences.
     *
     * @param messagingPreferencesId the messaging preferences ID of this messaging user preferences
     */
    public void setMessagingPreferencesId(Long messagingPreferencesId);

    /**
     * Returns the user ID of this messaging user preferences.
     *
     * @return the user ID of this messaging user preferences
     */
    public Long getUserId();

    /**
     * Sets the user ID of this messaging user preferences.
     *
     * @param userId the user ID of this messaging user preferences
     */
    public void setUserId(Long userId);

    /**
     * Returns the email on send of this messaging user preferences.
     *
     * @return the email on send of this messaging user preferences
     */
    public Boolean getEmailOnSend();

    /**
     * Sets the email on send of this messaging user preferences.
     *
     * @param emailOnSend the email on send of this messaging user preferences
     */
    public void setEmailOnSend(Boolean emailOnSend);

    /**
     * Returns the email on receipt of this messaging user preferences.
     *
     * @return the email on receipt of this messaging user preferences
     */
    public Boolean getEmailOnReceipt();

    /**
     * Sets the email on receipt of this messaging user preferences.
     *
     * @param emailOnReceipt the email on receipt of this messaging user preferences
     */
    public void setEmailOnReceipt(Boolean emailOnReceipt);

    /**
     * Returns the email on activity of this messaging user preferences.
     *
     * @return the email on activity of this messaging user preferences
     */
    public Boolean getEmailOnActivity();

    /**
     * Sets the email on activity of this messaging user preferences.
     *
     * @param emailOnActivity the email on activity of this messaging user preferences
     */
    public void setEmailOnActivity(Boolean emailOnActivity);

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

    public int compareTo(MessagingUserPreferences messagingUserPreferences);

    public int hashCode();

    public CacheModel<MessagingUserPreferences> toCacheModel();

    public MessagingUserPreferences toEscapedModel();

    public String toString();

    public String toXmlString();
}

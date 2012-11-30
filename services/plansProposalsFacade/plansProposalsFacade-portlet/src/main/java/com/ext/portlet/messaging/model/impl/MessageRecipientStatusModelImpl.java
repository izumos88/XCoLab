package com.ext.portlet.messaging.model.impl;

import com.ext.portlet.messaging.model.MessageRecipientStatus;
import com.ext.portlet.messaging.model.MessageRecipientStatusModel;
import com.ext.portlet.messaging.model.MessageRecipientStatusSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the MessageRecipientStatus service. Represents a row in the &quot;Messaging_MessageRecipientStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.messaging.model.MessageRecipientStatusModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MessageRecipientStatusImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageRecipientStatusImpl
 * @see com.ext.portlet.messaging.model.MessageRecipientStatus
 * @see com.ext.portlet.messaging.model.MessageRecipientStatusModel
 * @generated
 */
@JSON(strict = true)
public class MessageRecipientStatusModelImpl extends BaseModelImpl<MessageRecipientStatus>
    implements MessageRecipientStatusModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a message recipient status model instance should use the {@link com.ext.portlet.messaging.model.MessageRecipientStatus} interface instead.
     */
    public static final String TABLE_NAME = "Messaging_MessageRecipientStatus";
    public static final Object[][] TABLE_COLUMNS = {
            { "messageRecipientId", Types.BIGINT },
            { "messageId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "opened", Types.BOOLEAN },
            { "archived", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table Messaging_MessageRecipientStatus (messageRecipientId LONG not null primary key,messageId LONG,userId LONG,opened BOOLEAN,archived BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table Messaging_MessageRecipientStatus";
    public static final String ORDER_BY_JPQL = " ORDER BY messageRecipientStatus.messageId DESC";
    public static final String ORDER_BY_SQL = " ORDER BY Messaging_MessageRecipientStatus.messageId DESC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.messaging.model.MessageRecipientStatus"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.messaging.model.MessageRecipientStatus"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.messaging.model.MessageRecipientStatus"),
            true);
    public static long ARCHIVED_COLUMN_BITMASK = 1L;
    public static long MESSAGEID_COLUMN_BITMASK = 2L;
    public static long USERID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.messaging.model.MessageRecipientStatus"));
    private static ClassLoader _classLoader = MessageRecipientStatus.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            MessageRecipientStatus.class
        };
    private Long _messageRecipientId;
    private Long _messageId;
    private Long _originalMessageId;
    private boolean _setOriginalMessageId;
    private Long _userId;
    private Long _originalUserId;
    private boolean _setOriginalUserId;
    private Boolean _opened;
    private Boolean _archived;
    private Boolean _originalArchived;
    private boolean _setOriginalArchived;
    private long _columnBitmask;
    private MessageRecipientStatus _escapedModelProxy;

    public MessageRecipientStatusModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static MessageRecipientStatus toModel(
        MessageRecipientStatusSoap soapModel) {
        MessageRecipientStatus model = new MessageRecipientStatusImpl();

        model.setMessageRecipientId(soapModel.getMessageRecipientId());
        model.setMessageId(soapModel.getMessageId());
        model.setUserId(soapModel.getUserId());
        model.setOpened(soapModel.getOpened());
        model.setArchived(soapModel.getArchived());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<MessageRecipientStatus> toModels(
        MessageRecipientStatusSoap[] soapModels) {
        List<MessageRecipientStatus> models = new ArrayList<MessageRecipientStatus>(soapModels.length);

        for (MessageRecipientStatusSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public Long getPrimaryKey() {
        return _messageRecipientId;
    }

    public void setPrimaryKey(Long primaryKey) {
        setMessageRecipientId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_messageRecipientId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return MessageRecipientStatus.class;
    }

    public String getModelClassName() {
        return MessageRecipientStatus.class.getName();
    }

    @JSON
    public Long getMessageRecipientId() {
        return _messageRecipientId;
    }

    public void setMessageRecipientId(Long messageRecipientId) {
        _messageRecipientId = messageRecipientId;
    }

    @JSON
    public Long getMessageId() {
        return _messageId;
    }

    public void setMessageId(Long messageId) {
        _columnBitmask = -1L;

        if (!_setOriginalMessageId) {
            _setOriginalMessageId = true;

            _originalMessageId = _messageId;
        }

        _messageId = messageId;
    }

    public Long getOriginalMessageId() {
        return _originalMessageId;
    }

    @JSON
    public Long getUserId() {
        return _userId;
    }

    public void setUserId(Long userId) {
        _columnBitmask |= USERID_COLUMN_BITMASK;

        if (!_setOriginalUserId) {
            _setOriginalUserId = true;

            _originalUserId = _userId;
        }

        _userId = userId;
    }

    public Long getOriginalUserId() {
        return _originalUserId;
    }

    @JSON
    public Boolean getOpened() {
        return _opened;
    }

    public void setOpened(Boolean opened) {
        _opened = opened;
    }

    @JSON
    public Boolean getArchived() {
        return _archived;
    }

    public void setArchived(Boolean archived) {
        _columnBitmask |= ARCHIVED_COLUMN_BITMASK;

        if (!_setOriginalArchived) {
            _setOriginalArchived = true;

            _originalArchived = _archived;
        }

        _archived = archived;
    }

    public Boolean getOriginalArchived() {
        return _originalArchived;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public MessageRecipientStatus toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (MessageRecipientStatus) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        MessageRecipientStatusImpl messageRecipientStatusImpl = new MessageRecipientStatusImpl();

        messageRecipientStatusImpl.setMessageRecipientId(getMessageRecipientId());
        messageRecipientStatusImpl.setMessageId(getMessageId());
        messageRecipientStatusImpl.setUserId(getUserId());
        messageRecipientStatusImpl.setOpened(getOpened());
        messageRecipientStatusImpl.setArchived(getArchived());

        messageRecipientStatusImpl.resetOriginalValues();

        return messageRecipientStatusImpl;
    }

    public int compareTo(MessageRecipientStatus messageRecipientStatus) {
        int value = 0;

        if (getMessageId() < messageRecipientStatus.getMessageId()) {
            value = -1;
        } else if (getMessageId() > messageRecipientStatus.getMessageId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        MessageRecipientStatus messageRecipientStatus = null;

        try {
            messageRecipientStatus = (MessageRecipientStatus) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        Long primaryKey = messageRecipientStatus.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public void resetOriginalValues() {
        MessageRecipientStatusModelImpl messageRecipientStatusModelImpl = this;

        messageRecipientStatusModelImpl._originalMessageId = messageRecipientStatusModelImpl._messageId;

        messageRecipientStatusModelImpl._setOriginalMessageId = false;

        messageRecipientStatusModelImpl._originalUserId = messageRecipientStatusModelImpl._userId;

        messageRecipientStatusModelImpl._setOriginalUserId = false;

        messageRecipientStatusModelImpl._originalArchived = messageRecipientStatusModelImpl._archived;

        messageRecipientStatusModelImpl._setOriginalArchived = false;

        messageRecipientStatusModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<MessageRecipientStatus> toCacheModel() {
        MessageRecipientStatusCacheModel messageRecipientStatusCacheModel = new MessageRecipientStatusCacheModel();

        messageRecipientStatusCacheModel.messageRecipientId = getMessageRecipientId();

        messageRecipientStatusCacheModel.messageId = getMessageId();

        messageRecipientStatusCacheModel.userId = getUserId();

        messageRecipientStatusCacheModel.opened = getOpened();

        messageRecipientStatusCacheModel.archived = getArchived();

        return messageRecipientStatusCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{messageRecipientId=");
        sb.append(getMessageRecipientId());
        sb.append(", messageId=");
        sb.append(getMessageId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", opened=");
        sb.append(getOpened());
        sb.append(", archived=");
        sb.append(getArchived());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.messaging.model.MessageRecipientStatus");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>messageRecipientId</column-name><column-value><![CDATA[");
        sb.append(getMessageRecipientId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageId</column-name><column-value><![CDATA[");
        sb.append(getMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>opened</column-name><column-value><![CDATA[");
        sb.append(getOpened());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>archived</column-name><column-value><![CDATA[");
        sb.append(getArchived());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

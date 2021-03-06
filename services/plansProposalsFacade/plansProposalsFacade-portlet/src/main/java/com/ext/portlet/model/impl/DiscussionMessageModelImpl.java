package com.ext.portlet.model.impl;

import com.ext.portlet.model.DiscussionMessage;
import com.ext.portlet.model.DiscussionMessageModel;
import com.ext.portlet.model.DiscussionMessageSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the DiscussionMessage service. Represents a row in the &quot;xcolab_DiscussionMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.DiscussionMessageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DiscussionMessageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DiscussionMessageImpl
 * @see com.ext.portlet.model.DiscussionMessage
 * @see com.ext.portlet.model.DiscussionMessageModel
 * @generated
 */
@JSON(strict = true)
public class DiscussionMessageModelImpl extends BaseModelImpl<DiscussionMessage>
    implements DiscussionMessageModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a discussion message model instance should use the {@link com.ext.portlet.model.DiscussionMessage} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_DiscussionMessage";
    public static final Object[][] TABLE_COLUMNS = {
            { "pk", Types.BIGINT },
            { "messageId", Types.BIGINT },
            { "subject", Types.VARCHAR },
            { "body", Types.CLOB },
            { "threadId", Types.BIGINT },
            { "categoryId", Types.BIGINT },
            { "categoryGroupId", Types.BIGINT },
            { "authorId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP },
            { "version", Types.BIGINT },
            { "deleted", Types.TIMESTAMP },
            { "responsesCount", Types.INTEGER },
            { "lastActivityDate", Types.TIMESTAMP },
            { "lastActivityAuthorId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_DiscussionMessage (pk LONG not null primary key,messageId LONG,subject VARCHAR(1024) null,body TEXT null,threadId LONG,categoryId LONG,categoryGroupId LONG,authorId LONG,createDate DATE null,version LONG,deleted DATE null,responsesCount INTEGER,lastActivityDate DATE null,lastActivityAuthorId LONG)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_DiscussionMessage";
    public static final String ORDER_BY_JPQL = " ORDER BY discussionMessage.createDate DESC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_DiscussionMessage.createDate DESC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.DiscussionMessage"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.DiscussionMessage"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.DiscussionMessage"),
            true);
    public static long AUTHORID_COLUMN_BITMASK = 1L;
    public static long BODY_COLUMN_BITMASK = 2L;
    public static long CATEGORYGROUPID_COLUMN_BITMASK = 4L;
    public static long CATEGORYID_COLUMN_BITMASK = 8L;
    public static long MESSAGEID_COLUMN_BITMASK = 16L;
    public static long SUBJECT_COLUMN_BITMASK = 32L;
    public static long THREADID_COLUMN_BITMASK = 64L;
    public static long CREATEDATE_COLUMN_BITMASK = 128L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.DiscussionMessage"));
    private static ClassLoader _classLoader = DiscussionMessage.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            DiscussionMessage.class
        };
    private long _pk;
    private long _messageId;
    private long _originalMessageId;
    private boolean _setOriginalMessageId;
    private String _subject;
    private String _originalSubject;
    private String _body;
    private String _originalBody;
    private long _threadId;
    private long _originalThreadId;
    private boolean _setOriginalThreadId;
    private long _categoryId;
    private long _originalCategoryId;
    private boolean _setOriginalCategoryId;
    private long _categoryGroupId;
    private long _originalCategoryGroupId;
    private boolean _setOriginalCategoryGroupId;
    private long _authorId;
    private long _originalAuthorId;
    private boolean _setOriginalAuthorId;
    private Date _createDate;
    private long _version;
    private Date _deleted;
    private int _responsesCount;
    private Date _lastActivityDate;
    private long _lastActivityAuthorId;
    private long _columnBitmask;
    private DiscussionMessage _escapedModel;

    public DiscussionMessageModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static DiscussionMessage toModel(DiscussionMessageSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        DiscussionMessage model = new DiscussionMessageImpl();

        model.setPk(soapModel.getPk());
        model.setMessageId(soapModel.getMessageId());
        model.setSubject(soapModel.getSubject());
        model.setBody(soapModel.getBody());
        model.setThreadId(soapModel.getThreadId());
        model.setCategoryId(soapModel.getCategoryId());
        model.setCategoryGroupId(soapModel.getCategoryGroupId());
        model.setAuthorId(soapModel.getAuthorId());
        model.setCreateDate(soapModel.getCreateDate());
        model.setVersion(soapModel.getVersion());
        model.setDeleted(soapModel.getDeleted());
        model.setResponsesCount(soapModel.getResponsesCount());
        model.setLastActivityDate(soapModel.getLastActivityDate());
        model.setLastActivityAuthorId(soapModel.getLastActivityAuthorId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<DiscussionMessage> toModels(
        DiscussionMessageSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<DiscussionMessage> models = new ArrayList<DiscussionMessage>(soapModels.length);

        for (DiscussionMessageSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _pk;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setPk(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _pk;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return DiscussionMessage.class;
    }

    @Override
    public String getModelClassName() {
        return DiscussionMessage.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("pk", getPk());
        attributes.put("messageId", getMessageId());
        attributes.put("subject", getSubject());
        attributes.put("body", getBody());
        attributes.put("threadId", getThreadId());
        attributes.put("categoryId", getCategoryId());
        attributes.put("categoryGroupId", getCategoryGroupId());
        attributes.put("authorId", getAuthorId());
        attributes.put("createDate", getCreateDate());
        attributes.put("version", getVersion());
        attributes.put("deleted", getDeleted());
        attributes.put("responsesCount", getResponsesCount());
        attributes.put("lastActivityDate", getLastActivityDate());
        attributes.put("lastActivityAuthorId", getLastActivityAuthorId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long pk = (Long) attributes.get("pk");

        if (pk != null) {
            setPk(pk);
        }

        Long messageId = (Long) attributes.get("messageId");

        if (messageId != null) {
            setMessageId(messageId);
        }

        String subject = (String) attributes.get("subject");

        if (subject != null) {
            setSubject(subject);
        }

        String body = (String) attributes.get("body");

        if (body != null) {
            setBody(body);
        }

        Long threadId = (Long) attributes.get("threadId");

        if (threadId != null) {
            setThreadId(threadId);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        Long categoryGroupId = (Long) attributes.get("categoryGroupId");

        if (categoryGroupId != null) {
            setCategoryGroupId(categoryGroupId);
        }

        Long authorId = (Long) attributes.get("authorId");

        if (authorId != null) {
            setAuthorId(authorId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Long version = (Long) attributes.get("version");

        if (version != null) {
            setVersion(version);
        }

        Date deleted = (Date) attributes.get("deleted");

        if (deleted != null) {
            setDeleted(deleted);
        }

        Integer responsesCount = (Integer) attributes.get("responsesCount");

        if (responsesCount != null) {
            setResponsesCount(responsesCount);
        }

        Date lastActivityDate = (Date) attributes.get("lastActivityDate");

        if (lastActivityDate != null) {
            setLastActivityDate(lastActivityDate);
        }

        Long lastActivityAuthorId = (Long) attributes.get(
                "lastActivityAuthorId");

        if (lastActivityAuthorId != null) {
            setLastActivityAuthorId(lastActivityAuthorId);
        }
    }

    @JSON
    @Override
    public long getPk() {
        return _pk;
    }

    @Override
    public void setPk(long pk) {
        _pk = pk;
    }

    @JSON
    @Override
    public long getMessageId() {
        return _messageId;
    }

    @Override
    public void setMessageId(long messageId) {
        _columnBitmask |= MESSAGEID_COLUMN_BITMASK;

        if (!_setOriginalMessageId) {
            _setOriginalMessageId = true;

            _originalMessageId = _messageId;
        }

        _messageId = messageId;
    }

    public long getOriginalMessageId() {
        return _originalMessageId;
    }

    @JSON
    @Override
    public String getSubject() {
        if (_subject == null) {
            return StringPool.BLANK;
        } else {
            return _subject;
        }
    }

    @Override
    public void setSubject(String subject) {
        _columnBitmask |= SUBJECT_COLUMN_BITMASK;

        if (_originalSubject == null) {
            _originalSubject = _subject;
        }

        _subject = subject;
    }

    public String getOriginalSubject() {
        return GetterUtil.getString(_originalSubject);
    }

    @JSON
    @Override
    public String getBody() {
        if (_body == null) {
            return StringPool.BLANK;
        } else {
            return _body;
        }
    }

    @Override
    public void setBody(String body) {
        _columnBitmask |= BODY_COLUMN_BITMASK;

        if (_originalBody == null) {
            _originalBody = _body;
        }

        _body = body;
    }

    public String getOriginalBody() {
        return GetterUtil.getString(_originalBody);
    }

    @JSON
    @Override
    public long getThreadId() {
        return _threadId;
    }

    @Override
    public void setThreadId(long threadId) {
        _columnBitmask |= THREADID_COLUMN_BITMASK;

        if (!_setOriginalThreadId) {
            _setOriginalThreadId = true;

            _originalThreadId = _threadId;
        }

        _threadId = threadId;
    }

    public long getOriginalThreadId() {
        return _originalThreadId;
    }

    @JSON
    @Override
    public long getCategoryId() {
        return _categoryId;
    }

    @Override
    public void setCategoryId(long categoryId) {
        _columnBitmask |= CATEGORYID_COLUMN_BITMASK;

        if (!_setOriginalCategoryId) {
            _setOriginalCategoryId = true;

            _originalCategoryId = _categoryId;
        }

        _categoryId = categoryId;
    }

    public long getOriginalCategoryId() {
        return _originalCategoryId;
    }

    @JSON
    @Override
    public long getCategoryGroupId() {
        return _categoryGroupId;
    }

    @Override
    public void setCategoryGroupId(long categoryGroupId) {
        _columnBitmask |= CATEGORYGROUPID_COLUMN_BITMASK;

        if (!_setOriginalCategoryGroupId) {
            _setOriginalCategoryGroupId = true;

            _originalCategoryGroupId = _categoryGroupId;
        }

        _categoryGroupId = categoryGroupId;
    }

    public long getOriginalCategoryGroupId() {
        return _originalCategoryGroupId;
    }

    @JSON
    @Override
    public long getAuthorId() {
        return _authorId;
    }

    @Override
    public void setAuthorId(long authorId) {
        _columnBitmask |= AUTHORID_COLUMN_BITMASK;

        if (!_setOriginalAuthorId) {
            _setOriginalAuthorId = true;

            _originalAuthorId = _authorId;
        }

        _authorId = authorId;
    }

    public long getOriginalAuthorId() {
        return _originalAuthorId;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _columnBitmask = -1L;

        _createDate = createDate;
    }

    @JSON
    @Override
    public long getVersion() {
        return _version;
    }

    @Override
    public void setVersion(long version) {
        _version = version;
    }

    @JSON
    @Override
    public Date getDeleted() {
        return _deleted;
    }

    @Override
    public void setDeleted(Date deleted) {
        _deleted = deleted;
    }

    @JSON
    @Override
    public int getResponsesCount() {
        return _responsesCount;
    }

    @Override
    public void setResponsesCount(int responsesCount) {
        _responsesCount = responsesCount;
    }

    @JSON
    @Override
    public Date getLastActivityDate() {
        return _lastActivityDate;
    }

    @Override
    public void setLastActivityDate(Date lastActivityDate) {
        _lastActivityDate = lastActivityDate;
    }

    @JSON
    @Override
    public long getLastActivityAuthorId() {
        return _lastActivityAuthorId;
    }

    @Override
    public void setLastActivityAuthorId(long lastActivityAuthorId) {
        _lastActivityAuthorId = lastActivityAuthorId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            DiscussionMessage.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public DiscussionMessage toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (DiscussionMessage) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        DiscussionMessageImpl discussionMessageImpl = new DiscussionMessageImpl();

        discussionMessageImpl.setPk(getPk());
        discussionMessageImpl.setMessageId(getMessageId());
        discussionMessageImpl.setSubject(getSubject());
        discussionMessageImpl.setBody(getBody());
        discussionMessageImpl.setThreadId(getThreadId());
        discussionMessageImpl.setCategoryId(getCategoryId());
        discussionMessageImpl.setCategoryGroupId(getCategoryGroupId());
        discussionMessageImpl.setAuthorId(getAuthorId());
        discussionMessageImpl.setCreateDate(getCreateDate());
        discussionMessageImpl.setVersion(getVersion());
        discussionMessageImpl.setDeleted(getDeleted());
        discussionMessageImpl.setResponsesCount(getResponsesCount());
        discussionMessageImpl.setLastActivityDate(getLastActivityDate());
        discussionMessageImpl.setLastActivityAuthorId(getLastActivityAuthorId());

        discussionMessageImpl.resetOriginalValues();

        return discussionMessageImpl;
    }

    @Override
    public int compareTo(DiscussionMessage discussionMessage) {
        int value = 0;

        value = DateUtil.compareTo(getCreateDate(),
                discussionMessage.getCreateDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DiscussionMessage)) {
            return false;
        }

        DiscussionMessage discussionMessage = (DiscussionMessage) obj;

        long primaryKey = discussionMessage.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        DiscussionMessageModelImpl discussionMessageModelImpl = this;

        discussionMessageModelImpl._originalMessageId = discussionMessageModelImpl._messageId;

        discussionMessageModelImpl._setOriginalMessageId = false;

        discussionMessageModelImpl._originalSubject = discussionMessageModelImpl._subject;

        discussionMessageModelImpl._originalBody = discussionMessageModelImpl._body;

        discussionMessageModelImpl._originalThreadId = discussionMessageModelImpl._threadId;

        discussionMessageModelImpl._setOriginalThreadId = false;

        discussionMessageModelImpl._originalCategoryId = discussionMessageModelImpl._categoryId;

        discussionMessageModelImpl._setOriginalCategoryId = false;

        discussionMessageModelImpl._originalCategoryGroupId = discussionMessageModelImpl._categoryGroupId;

        discussionMessageModelImpl._setOriginalCategoryGroupId = false;

        discussionMessageModelImpl._originalAuthorId = discussionMessageModelImpl._authorId;

        discussionMessageModelImpl._setOriginalAuthorId = false;

        discussionMessageModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<DiscussionMessage> toCacheModel() {
        DiscussionMessageCacheModel discussionMessageCacheModel = new DiscussionMessageCacheModel();

        discussionMessageCacheModel.pk = getPk();

        discussionMessageCacheModel.messageId = getMessageId();

        discussionMessageCacheModel.subject = getSubject();

        String subject = discussionMessageCacheModel.subject;

        if ((subject != null) && (subject.length() == 0)) {
            discussionMessageCacheModel.subject = null;
        }

        discussionMessageCacheModel.body = getBody();

        String body = discussionMessageCacheModel.body;

        if ((body != null) && (body.length() == 0)) {
            discussionMessageCacheModel.body = null;
        }

        discussionMessageCacheModel.threadId = getThreadId();

        discussionMessageCacheModel.categoryId = getCategoryId();

        discussionMessageCacheModel.categoryGroupId = getCategoryGroupId();

        discussionMessageCacheModel.authorId = getAuthorId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            discussionMessageCacheModel.createDate = createDate.getTime();
        } else {
            discussionMessageCacheModel.createDate = Long.MIN_VALUE;
        }

        discussionMessageCacheModel.version = getVersion();

        Date deleted = getDeleted();

        if (deleted != null) {
            discussionMessageCacheModel.deleted = deleted.getTime();
        } else {
            discussionMessageCacheModel.deleted = Long.MIN_VALUE;
        }

        discussionMessageCacheModel.responsesCount = getResponsesCount();

        Date lastActivityDate = getLastActivityDate();

        if (lastActivityDate != null) {
            discussionMessageCacheModel.lastActivityDate = lastActivityDate.getTime();
        } else {
            discussionMessageCacheModel.lastActivityDate = Long.MIN_VALUE;
        }

        discussionMessageCacheModel.lastActivityAuthorId = getLastActivityAuthorId();

        return discussionMessageCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{pk=");
        sb.append(getPk());
        sb.append(", messageId=");
        sb.append(getMessageId());
        sb.append(", subject=");
        sb.append(getSubject());
        sb.append(", body=");
        sb.append(getBody());
        sb.append(", threadId=");
        sb.append(getThreadId());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append(", categoryGroupId=");
        sb.append(getCategoryGroupId());
        sb.append(", authorId=");
        sb.append(getAuthorId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", version=");
        sb.append(getVersion());
        sb.append(", deleted=");
        sb.append(getDeleted());
        sb.append(", responsesCount=");
        sb.append(getResponsesCount());
        sb.append(", lastActivityDate=");
        sb.append(getLastActivityDate());
        sb.append(", lastActivityAuthorId=");
        sb.append(getLastActivityAuthorId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.DiscussionMessage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>pk</column-name><column-value><![CDATA[");
        sb.append(getPk());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageId</column-name><column-value><![CDATA[");
        sb.append(getMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subject</column-name><column-value><![CDATA[");
        sb.append(getSubject());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>body</column-name><column-value><![CDATA[");
        sb.append(getBody());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>threadId</column-name><column-value><![CDATA[");
        sb.append(getThreadId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryGroupId</column-name><column-value><![CDATA[");
        sb.append(getCategoryGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorId</column-name><column-value><![CDATA[");
        sb.append(getAuthorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version</column-name><column-value><![CDATA[");
        sb.append(getVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>deleted</column-name><column-value><![CDATA[");
        sb.append(getDeleted());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>responsesCount</column-name><column-value><![CDATA[");
        sb.append(getResponsesCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastActivityDate</column-name><column-value><![CDATA[");
        sb.append(getLastActivityDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastActivityAuthorId</column-name><column-value><![CDATA[");
        sb.append(getLastActivityAuthorId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

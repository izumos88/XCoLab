package com.ext.portlet.model.impl;

import com.ext.portlet.model.ProposalSupporter;
import com.ext.portlet.model.ProposalSupporterModel;
import com.ext.portlet.model.ProposalSupporterSoap;
import com.ext.portlet.service.persistence.ProposalSupporterPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ProposalSupporter service. Represents a row in the &quot;xcolab_ProposalSupporter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ProposalSupporterModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProposalSupporterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalSupporterImpl
 * @see com.ext.portlet.model.ProposalSupporter
 * @see com.ext.portlet.model.ProposalSupporterModel
 * @generated
 */
@JSON(strict = true)
public class ProposalSupporterModelImpl extends BaseModelImpl<ProposalSupporter>
    implements ProposalSupporterModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a proposal supporter model instance should use the {@link com.ext.portlet.model.ProposalSupporter} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ProposalSupporter";
    public static final Object[][] TABLE_COLUMNS = {
            { "proposalId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ProposalSupporter (proposalId LONG not null,userId LONG not null,createDate DATE null,primary key (proposalId, userId))";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ProposalSupporter";
    public static final String ORDER_BY_JPQL = " ORDER BY proposalSupporter.id.proposalId ASC, proposalSupporter.id.userId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_ProposalSupporter.proposalId ASC, xcolab_ProposalSupporter.userId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ProposalSupporter"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ProposalSupporter"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.ProposalSupporter"),
            true);
    public static long PROPOSALID_COLUMN_BITMASK = 1L;
    public static long USERID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ProposalSupporter"));
    private static ClassLoader _classLoader = ProposalSupporter.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ProposalSupporter.class
        };
    private long _proposalId;
    private long _originalProposalId;
    private boolean _setOriginalProposalId;
    private long _userId;
    private String _userUuid;
    private long _originalUserId;
    private boolean _setOriginalUserId;
    private Date _createDate;
    private long _columnBitmask;
    private ProposalSupporter _escapedModel;

    public ProposalSupporterModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ProposalSupporter toModel(ProposalSupporterSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ProposalSupporter model = new ProposalSupporterImpl();

        model.setProposalId(soapModel.getProposalId());
        model.setUserId(soapModel.getUserId());
        model.setCreateDate(soapModel.getCreateDate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ProposalSupporter> toModels(
        ProposalSupporterSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ProposalSupporter> models = new ArrayList<ProposalSupporter>(soapModels.length);

        for (ProposalSupporterSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public ProposalSupporterPK getPrimaryKey() {
        return new ProposalSupporterPK(_proposalId, _userId);
    }

    @Override
    public void setPrimaryKey(ProposalSupporterPK primaryKey) {
        setProposalId(primaryKey.proposalId);
        setUserId(primaryKey.userId);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new ProposalSupporterPK(_proposalId, _userId);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((ProposalSupporterPK) primaryKeyObj);
    }

    @Override
    public Class<?> getModelClass() {
        return ProposalSupporter.class;
    }

    @Override
    public String getModelClassName() {
        return ProposalSupporter.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("proposalId", getProposalId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long proposalId = (Long) attributes.get("proposalId");

        if (proposalId != null) {
            setProposalId(proposalId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }
    }

    @JSON
    @Override
    public long getProposalId() {
        return _proposalId;
    }

    @Override
    public void setProposalId(long proposalId) {
        _columnBitmask |= PROPOSALID_COLUMN_BITMASK;

        if (!_setOriginalProposalId) {
            _setOriginalProposalId = true;

            _originalProposalId = _proposalId;
        }

        _proposalId = proposalId;
    }

    public long getOriginalProposalId() {
        return _originalProposalId;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _columnBitmask |= USERID_COLUMN_BITMASK;

        if (!_setOriginalUserId) {
            _setOriginalUserId = true;

            _originalUserId = _userId;
        }

        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public long getOriginalUserId() {
        return _originalUserId;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ProposalSupporter toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ProposalSupporter) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ProposalSupporterImpl proposalSupporterImpl = new ProposalSupporterImpl();

        proposalSupporterImpl.setProposalId(getProposalId());
        proposalSupporterImpl.setUserId(getUserId());
        proposalSupporterImpl.setCreateDate(getCreateDate());

        proposalSupporterImpl.resetOriginalValues();

        return proposalSupporterImpl;
    }

    @Override
    public int compareTo(ProposalSupporter proposalSupporter) {
        ProposalSupporterPK primaryKey = proposalSupporter.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProposalSupporter)) {
            return false;
        }

        ProposalSupporter proposalSupporter = (ProposalSupporter) obj;

        ProposalSupporterPK primaryKey = proposalSupporter.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
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
        ProposalSupporterModelImpl proposalSupporterModelImpl = this;

        proposalSupporterModelImpl._originalProposalId = proposalSupporterModelImpl._proposalId;

        proposalSupporterModelImpl._setOriginalProposalId = false;

        proposalSupporterModelImpl._originalUserId = proposalSupporterModelImpl._userId;

        proposalSupporterModelImpl._setOriginalUserId = false;

        proposalSupporterModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ProposalSupporter> toCacheModel() {
        ProposalSupporterCacheModel proposalSupporterCacheModel = new ProposalSupporterCacheModel();

        proposalSupporterCacheModel.proposalId = getProposalId();

        proposalSupporterCacheModel.userId = getUserId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            proposalSupporterCacheModel.createDate = createDate.getTime();
        } else {
            proposalSupporterCacheModel.createDate = Long.MIN_VALUE;
        }

        return proposalSupporterCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{proposalId=");
        sb.append(getProposalId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ProposalSupporter");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>proposalId</column-name><column-value><![CDATA[");
        sb.append(getProposalId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

package com.ext.portlet.model.impl;

import com.ext.portlet.model.ProposalRatingType;
import com.ext.portlet.model.ProposalRatingTypeModel;
import com.ext.portlet.model.ProposalRatingTypeSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ProposalRatingType service. Represents a row in the &quot;xcolab_ProposalRatingType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ProposalRatingTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProposalRatingTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalRatingTypeImpl
 * @see com.ext.portlet.model.ProposalRatingType
 * @see com.ext.portlet.model.ProposalRatingTypeModel
 * @generated
 */
@JSON(strict = true)
public class ProposalRatingTypeModelImpl extends BaseModelImpl<ProposalRatingType>
    implements ProposalRatingTypeModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a proposal rating type model instance should use the {@link com.ext.portlet.model.ProposalRatingType} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ProposalRatingType";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "label", Types.VARCHAR },
            { "judgeType", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ProposalRatingType (id_ LONG not null primary key,label VARCHAR(75) null,judgeType INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ProposalRatingType";
    public static final String ORDER_BY_JPQL = " ORDER BY proposalRatingType.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_ProposalRatingType.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ProposalRatingType"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ProposalRatingType"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ProposalRatingType"));
    private static ClassLoader _classLoader = ProposalRatingType.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ProposalRatingType.class
        };
    private long _id;
    private String _label;
    private int _judgeType;
    private ProposalRatingType _escapedModel;

    public ProposalRatingTypeModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ProposalRatingType toModel(ProposalRatingTypeSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ProposalRatingType model = new ProposalRatingTypeImpl();

        model.setId(soapModel.getId());
        model.setLabel(soapModel.getLabel());
        model.setJudgeType(soapModel.getJudgeType());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ProposalRatingType> toModels(
        ProposalRatingTypeSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ProposalRatingType> models = new ArrayList<ProposalRatingType>(soapModels.length);

        for (ProposalRatingTypeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return ProposalRatingType.class;
    }

    @Override
    public String getModelClassName() {
        return ProposalRatingType.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("label", getLabel());
        attributes.put("judgeType", getJudgeType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String label = (String) attributes.get("label");

        if (label != null) {
            setLabel(label);
        }

        Integer judgeType = (Integer) attributes.get("judgeType");

        if (judgeType != null) {
            setJudgeType(judgeType);
        }
    }

    @JSON
    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;
    }

    @JSON
    @Override
    public String getLabel() {
        if (_label == null) {
            return StringPool.BLANK;
        } else {
            return _label;
        }
    }

    @Override
    public void setLabel(String label) {
        _label = label;
    }

    @JSON
    @Override
    public int getJudgeType() {
        return _judgeType;
    }

    @Override
    public void setJudgeType(int judgeType) {
        _judgeType = judgeType;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            ProposalRatingType.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ProposalRatingType toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ProposalRatingType) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ProposalRatingTypeImpl proposalRatingTypeImpl = new ProposalRatingTypeImpl();

        proposalRatingTypeImpl.setId(getId());
        proposalRatingTypeImpl.setLabel(getLabel());
        proposalRatingTypeImpl.setJudgeType(getJudgeType());

        proposalRatingTypeImpl.resetOriginalValues();

        return proposalRatingTypeImpl;
    }

    @Override
    public int compareTo(ProposalRatingType proposalRatingType) {
        long primaryKey = proposalRatingType.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProposalRatingType)) {
            return false;
        }

        ProposalRatingType proposalRatingType = (ProposalRatingType) obj;

        long primaryKey = proposalRatingType.getPrimaryKey();

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
    }

    @Override
    public CacheModel<ProposalRatingType> toCacheModel() {
        ProposalRatingTypeCacheModel proposalRatingTypeCacheModel = new ProposalRatingTypeCacheModel();

        proposalRatingTypeCacheModel.id = getId();

        proposalRatingTypeCacheModel.label = getLabel();

        String label = proposalRatingTypeCacheModel.label;

        if ((label != null) && (label.length() == 0)) {
            proposalRatingTypeCacheModel.label = null;
        }

        proposalRatingTypeCacheModel.judgeType = getJudgeType();

        return proposalRatingTypeCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", label=");
        sb.append(getLabel());
        sb.append(", judgeType=");
        sb.append(getJudgeType());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ProposalRatingType");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>label</column-name><column-value><![CDATA[");
        sb.append(getLabel());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>judgeType</column-name><column-value><![CDATA[");
        sb.append(getJudgeType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
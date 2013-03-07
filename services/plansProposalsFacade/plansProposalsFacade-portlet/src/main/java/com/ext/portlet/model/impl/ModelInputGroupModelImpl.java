package com.ext.portlet.model.impl;

import com.ext.portlet.model.ModelInputGroup;
import com.ext.portlet.model.ModelInputGroupModel;
import com.ext.portlet.model.ModelInputGroupSoap;

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
import java.util.List;

/**
 * The base model implementation for the ModelInputGroup service. Represents a row in the &quot;xcolab_ModelInputGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ModelInputGroupModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ModelInputGroupImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelInputGroupImpl
 * @see com.ext.portlet.model.ModelInputGroup
 * @see com.ext.portlet.model.ModelInputGroupModel
 * @generated
 */
@JSON(strict = true)
public class ModelInputGroupModelImpl extends BaseModelImpl<ModelInputGroup>
    implements ModelInputGroupModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a model input group model instance should use the {@link com.ext.portlet.model.ModelInputGroup} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ModelInputGroup";
    public static final Object[][] TABLE_COLUMNS = {
            { "modelInputGroupPK", Types.BIGINT },
            { "modelId", Types.BIGINT },
            { "nameAndDescriptionMetaDataId", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "displayItemOrder", Types.INTEGER },
            { "groupType", Types.VARCHAR },
            { "parentGroupPK", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ModelInputGroup (modelInputGroupPK LONG not null primary key,modelId LONG,nameAndDescriptionMetaDataId LONG,name VARCHAR(1024) null,description TEXT null,displayItemOrder INTEGER,groupType VARCHAR(256) null,parentGroupPK LONG)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ModelInputGroup";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ModelInputGroup"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ModelInputGroup"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.ModelInputGroup"),
            true);
    public static long MODELID_COLUMN_BITMASK = 1L;
    public static long PARENTGROUPPK_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ModelInputGroup"));
    private static ClassLoader _classLoader = ModelInputGroup.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            ModelInputGroup.class
        };
    private long _modelInputGroupPK;
    private long _modelId;
    private long _originalModelId;
    private boolean _setOriginalModelId;
    private long _nameAndDescriptionMetaDataId;
    private String _name;
    private String _description;
    private int _displayItemOrder;
    private String _groupType;
    private long _parentGroupPK;
    private long _originalParentGroupPK;
    private boolean _setOriginalParentGroupPK;
    private transient ExpandoBridge _expandoBridge;
    private long _columnBitmask;
    private ModelInputGroup _escapedModelProxy;

    public ModelInputGroupModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ModelInputGroup toModel(ModelInputGroupSoap soapModel) {
        ModelInputGroup model = new ModelInputGroupImpl();

        model.setModelInputGroupPK(soapModel.getModelInputGroupPK());
        model.setModelId(soapModel.getModelId());
        model.setNameAndDescriptionMetaDataId(soapModel.getNameAndDescriptionMetaDataId());
        model.setName(soapModel.getName());
        model.setDescription(soapModel.getDescription());
        model.setDisplayItemOrder(soapModel.getDisplayItemOrder());
        model.setGroupType(soapModel.getGroupType());
        model.setParentGroupPK(soapModel.getParentGroupPK());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ModelInputGroup> toModels(
        ModelInputGroupSoap[] soapModels) {
        List<ModelInputGroup> models = new ArrayList<ModelInputGroup>(soapModels.length);

        for (ModelInputGroupSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _modelInputGroupPK;
    }

    public void setPrimaryKey(long primaryKey) {
        setModelInputGroupPK(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_modelInputGroupPK);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return ModelInputGroup.class;
    }

    public String getModelClassName() {
        return ModelInputGroup.class.getName();
    }

    @JSON
    public long getModelInputGroupPK() {
        return _modelInputGroupPK;
    }

    public void setModelInputGroupPK(long modelInputGroupPK) {
        _modelInputGroupPK = modelInputGroupPK;
    }

    @JSON
    public long getModelId() {
        return _modelId;
    }

    public void setModelId(long modelId) {
        _columnBitmask |= MODELID_COLUMN_BITMASK;

        if (!_setOriginalModelId) {
            _setOriginalModelId = true;

            _originalModelId = _modelId;
        }

        _modelId = modelId;
    }

    public long getOriginalModelId() {
        return _originalModelId;
    }

    @JSON
    public long getNameAndDescriptionMetaDataId() {
        return _nameAndDescriptionMetaDataId;
    }

    public void setNameAndDescriptionMetaDataId(
        long nameAndDescriptionMetaDataId) {
        _nameAndDescriptionMetaDataId = nameAndDescriptionMetaDataId;
    }

    @JSON
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    public void setName(String name) {
        _name = name;
    }

    @JSON
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    public int getDisplayItemOrder() {
        return _displayItemOrder;
    }

    public void setDisplayItemOrder(int displayItemOrder) {
        _displayItemOrder = displayItemOrder;
    }

    @JSON
    public String getGroupType() {
        if (_groupType == null) {
            return StringPool.BLANK;
        } else {
            return _groupType;
        }
    }

    public void setGroupType(String groupType) {
        _groupType = groupType;
    }

    @JSON
    public long getParentGroupPK() {
        return _parentGroupPK;
    }

    public void setParentGroupPK(long parentGroupPK) {
        _columnBitmask |= PARENTGROUPPK_COLUMN_BITMASK;

        if (!_setOriginalParentGroupPK) {
            _setOriginalParentGroupPK = true;

            _originalParentGroupPK = _parentGroupPK;
        }

        _parentGroupPK = parentGroupPK;
    }

    public long getOriginalParentGroupPK() {
        return _originalParentGroupPK;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ModelInputGroup toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (ModelInputGroup) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
                    ModelInputGroup.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    @Override
    public Object clone() {
        ModelInputGroupImpl modelInputGroupImpl = new ModelInputGroupImpl();

        modelInputGroupImpl.setModelInputGroupPK(getModelInputGroupPK());
        modelInputGroupImpl.setModelId(getModelId());
        modelInputGroupImpl.setNameAndDescriptionMetaDataId(getNameAndDescriptionMetaDataId());
        modelInputGroupImpl.setName(getName());
        modelInputGroupImpl.setDescription(getDescription());
        modelInputGroupImpl.setDisplayItemOrder(getDisplayItemOrder());
        modelInputGroupImpl.setGroupType(getGroupType());
        modelInputGroupImpl.setParentGroupPK(getParentGroupPK());

        modelInputGroupImpl.resetOriginalValues();

        return modelInputGroupImpl;
    }

    public int compareTo(ModelInputGroup modelInputGroup) {
        long primaryKey = modelInputGroup.getPrimaryKey();

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
        if (obj == null) {
            return false;
        }

        ModelInputGroup modelInputGroup = null;

        try {
            modelInputGroup = (ModelInputGroup) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = modelInputGroup.getPrimaryKey();

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
        ModelInputGroupModelImpl modelInputGroupModelImpl = this;

        modelInputGroupModelImpl._originalModelId = modelInputGroupModelImpl._modelId;

        modelInputGroupModelImpl._setOriginalModelId = false;

        modelInputGroupModelImpl._originalParentGroupPK = modelInputGroupModelImpl._parentGroupPK;

        modelInputGroupModelImpl._setOriginalParentGroupPK = false;

        modelInputGroupModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ModelInputGroup> toCacheModel() {
        ModelInputGroupCacheModel modelInputGroupCacheModel = new ModelInputGroupCacheModel();

        modelInputGroupCacheModel.modelInputGroupPK = getModelInputGroupPK();

        modelInputGroupCacheModel.modelId = getModelId();

        modelInputGroupCacheModel.nameAndDescriptionMetaDataId = getNameAndDescriptionMetaDataId();

        modelInputGroupCacheModel.name = getName();

        String name = modelInputGroupCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            modelInputGroupCacheModel.name = null;
        }

        modelInputGroupCacheModel.description = getDescription();

        String description = modelInputGroupCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            modelInputGroupCacheModel.description = null;
        }

        modelInputGroupCacheModel.displayItemOrder = getDisplayItemOrder();

        modelInputGroupCacheModel.groupType = getGroupType();

        String groupType = modelInputGroupCacheModel.groupType;

        if ((groupType != null) && (groupType.length() == 0)) {
            modelInputGroupCacheModel.groupType = null;
        }

        modelInputGroupCacheModel.parentGroupPK = getParentGroupPK();

        return modelInputGroupCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{modelInputGroupPK=");
        sb.append(getModelInputGroupPK());
        sb.append(", modelId=");
        sb.append(getModelId());
        sb.append(", nameAndDescriptionMetaDataId=");
        sb.append(getNameAndDescriptionMetaDataId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", displayItemOrder=");
        sb.append(getDisplayItemOrder());
        sb.append(", groupType=");
        sb.append(getGroupType());
        sb.append(", parentGroupPK=");
        sb.append(getParentGroupPK());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ModelInputGroup");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>modelInputGroupPK</column-name><column-value><![CDATA[");
        sb.append(getModelInputGroupPK());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelId</column-name><column-value><![CDATA[");
        sb.append(getModelId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>nameAndDescriptionMetaDataId</column-name><column-value><![CDATA[");
        sb.append(getNameAndDescriptionMetaDataId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>displayItemOrder</column-name><column-value><![CDATA[");
        sb.append(getDisplayItemOrder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupType</column-name><column-value><![CDATA[");
        sb.append(getGroupType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentGroupPK</column-name><column-value><![CDATA[");
        sb.append(getParentGroupPK());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
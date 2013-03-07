package com.ext.portlet.model.impl;

import com.ext.portlet.model.ModelOutputChartOrder;
import com.ext.portlet.model.ModelOutputChartOrderModel;
import com.ext.portlet.model.ModelOutputChartOrderSoap;

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
 * The base model implementation for the ModelOutputChartOrder service. Represents a row in the &quot;xcolab_ModelOutputChartOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ModelOutputChartOrderModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ModelOutputChartOrderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelOutputChartOrderImpl
 * @see com.ext.portlet.model.ModelOutputChartOrder
 * @see com.ext.portlet.model.ModelOutputChartOrderModel
 * @generated
 */
@JSON(strict = true)
public class ModelOutputChartOrderModelImpl extends BaseModelImpl<ModelOutputChartOrder>
    implements ModelOutputChartOrderModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a model output chart order model instance should use the {@link com.ext.portlet.model.ModelOutputChartOrder} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ModelOutputChartOrder";
    public static final Object[][] TABLE_COLUMNS = {
            { "modelOutputChartOrderPK", Types.BIGINT },
            { "modelId", Types.BIGINT },
            { "modelOutputLabel", Types.VARCHAR },
            { "modelOutputChartOrder", Types.INTEGER },
            { "modelIndexRangePolicy", Types.VARCHAR },
            { "modelIndexRangeMessage", Types.VARCHAR },
            { "modelIndexErrorPolicy", Types.VARCHAR },
            { "modelIndexErrorMessage", Types.VARCHAR },
            { "modelChartIsVisible", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ModelOutputChartOrder (modelOutputChartOrderPK LONG not null primary key,modelId LONG,modelOutputLabel VARCHAR(1024) null,modelOutputChartOrder INTEGER,modelIndexRangePolicy VARCHAR(2048) null,modelIndexRangeMessage VARCHAR(2048) null,modelIndexErrorPolicy VARCHAR(2048) null,modelIndexErrorMessage VARCHAR(2048) null,modelChartIsVisible BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ModelOutputChartOrder";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ModelOutputChartOrder"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ModelOutputChartOrder"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.ModelOutputChartOrder"),
            true);
    public static long MODELID_COLUMN_BITMASK = 1L;
    public static long MODELOUTPUTLABEL_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ModelOutputChartOrder"));
    private static ClassLoader _classLoader = ModelOutputChartOrder.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            ModelOutputChartOrder.class
        };
    private long _modelOutputChartOrderPK;
    private long _modelId;
    private long _originalModelId;
    private boolean _setOriginalModelId;
    private String _modelOutputLabel;
    private String _originalModelOutputLabel;
    private int _modelOutputChartOrder;
    private String _modelIndexRangePolicy;
    private String _modelIndexRangeMessage;
    private String _modelIndexErrorPolicy;
    private String _modelIndexErrorMessage;
    private boolean _modelChartIsVisible;
    private transient ExpandoBridge _expandoBridge;
    private long _columnBitmask;
    private ModelOutputChartOrder _escapedModelProxy;

    public ModelOutputChartOrderModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ModelOutputChartOrder toModel(
        ModelOutputChartOrderSoap soapModel) {
        ModelOutputChartOrder model = new ModelOutputChartOrderImpl();

        model.setModelOutputChartOrderPK(soapModel.getModelOutputChartOrderPK());
        model.setModelId(soapModel.getModelId());
        model.setModelOutputLabel(soapModel.getModelOutputLabel());
        model.setModelOutputChartOrder(soapModel.getModelOutputChartOrder());
        model.setModelIndexRangePolicy(soapModel.getModelIndexRangePolicy());
        model.setModelIndexRangeMessage(soapModel.getModelIndexRangeMessage());
        model.setModelIndexErrorPolicy(soapModel.getModelIndexErrorPolicy());
        model.setModelIndexErrorMessage(soapModel.getModelIndexErrorMessage());
        model.setModelChartIsVisible(soapModel.getModelChartIsVisible());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ModelOutputChartOrder> toModels(
        ModelOutputChartOrderSoap[] soapModels) {
        List<ModelOutputChartOrder> models = new ArrayList<ModelOutputChartOrder>(soapModels.length);

        for (ModelOutputChartOrderSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _modelOutputChartOrderPK;
    }

    public void setPrimaryKey(long primaryKey) {
        setModelOutputChartOrderPK(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_modelOutputChartOrderPK);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return ModelOutputChartOrder.class;
    }

    public String getModelClassName() {
        return ModelOutputChartOrder.class.getName();
    }

    @JSON
    public long getModelOutputChartOrderPK() {
        return _modelOutputChartOrderPK;
    }

    public void setModelOutputChartOrderPK(long modelOutputChartOrderPK) {
        _modelOutputChartOrderPK = modelOutputChartOrderPK;
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
    public String getModelOutputLabel() {
        if (_modelOutputLabel == null) {
            return StringPool.BLANK;
        } else {
            return _modelOutputLabel;
        }
    }

    public void setModelOutputLabel(String modelOutputLabel) {
        _columnBitmask |= MODELOUTPUTLABEL_COLUMN_BITMASK;

        if (_originalModelOutputLabel == null) {
            _originalModelOutputLabel = _modelOutputLabel;
        }

        _modelOutputLabel = modelOutputLabel;
    }

    public String getOriginalModelOutputLabel() {
        return GetterUtil.getString(_originalModelOutputLabel);
    }

    @JSON
    public int getModelOutputChartOrder() {
        return _modelOutputChartOrder;
    }

    public void setModelOutputChartOrder(int modelOutputChartOrder) {
        _modelOutputChartOrder = modelOutputChartOrder;
    }

    @JSON
    public String getModelIndexRangePolicy() {
        if (_modelIndexRangePolicy == null) {
            return StringPool.BLANK;
        } else {
            return _modelIndexRangePolicy;
        }
    }

    public void setModelIndexRangePolicy(String modelIndexRangePolicy) {
        _modelIndexRangePolicy = modelIndexRangePolicy;
    }

    @JSON
    public String getModelIndexRangeMessage() {
        if (_modelIndexRangeMessage == null) {
            return StringPool.BLANK;
        } else {
            return _modelIndexRangeMessage;
        }
    }

    public void setModelIndexRangeMessage(String modelIndexRangeMessage) {
        _modelIndexRangeMessage = modelIndexRangeMessage;
    }

    @JSON
    public String getModelIndexErrorPolicy() {
        if (_modelIndexErrorPolicy == null) {
            return StringPool.BLANK;
        } else {
            return _modelIndexErrorPolicy;
        }
    }

    public void setModelIndexErrorPolicy(String modelIndexErrorPolicy) {
        _modelIndexErrorPolicy = modelIndexErrorPolicy;
    }

    @JSON
    public String getModelIndexErrorMessage() {
        if (_modelIndexErrorMessage == null) {
            return StringPool.BLANK;
        } else {
            return _modelIndexErrorMessage;
        }
    }

    public void setModelIndexErrorMessage(String modelIndexErrorMessage) {
        _modelIndexErrorMessage = modelIndexErrorMessage;
    }

    @JSON
    public boolean getModelChartIsVisible() {
        return _modelChartIsVisible;
    }

    public boolean isModelChartIsVisible() {
        return _modelChartIsVisible;
    }

    public void setModelChartIsVisible(boolean modelChartIsVisible) {
        _modelChartIsVisible = modelChartIsVisible;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ModelOutputChartOrder toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (ModelOutputChartOrder) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
                    ModelOutputChartOrder.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    @Override
    public Object clone() {
        ModelOutputChartOrderImpl modelOutputChartOrderImpl = new ModelOutputChartOrderImpl();

        modelOutputChartOrderImpl.setModelOutputChartOrderPK(getModelOutputChartOrderPK());
        modelOutputChartOrderImpl.setModelId(getModelId());
        modelOutputChartOrderImpl.setModelOutputLabel(getModelOutputLabel());
        modelOutputChartOrderImpl.setModelOutputChartOrder(getModelOutputChartOrder());
        modelOutputChartOrderImpl.setModelIndexRangePolicy(getModelIndexRangePolicy());
        modelOutputChartOrderImpl.setModelIndexRangeMessage(getModelIndexRangeMessage());
        modelOutputChartOrderImpl.setModelIndexErrorPolicy(getModelIndexErrorPolicy());
        modelOutputChartOrderImpl.setModelIndexErrorMessage(getModelIndexErrorMessage());
        modelOutputChartOrderImpl.setModelChartIsVisible(getModelChartIsVisible());

        modelOutputChartOrderImpl.resetOriginalValues();

        return modelOutputChartOrderImpl;
    }

    public int compareTo(ModelOutputChartOrder modelOutputChartOrder) {
        long primaryKey = modelOutputChartOrder.getPrimaryKey();

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

        ModelOutputChartOrder modelOutputChartOrder = null;

        try {
            modelOutputChartOrder = (ModelOutputChartOrder) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = modelOutputChartOrder.getPrimaryKey();

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
        ModelOutputChartOrderModelImpl modelOutputChartOrderModelImpl = this;

        modelOutputChartOrderModelImpl._originalModelId = modelOutputChartOrderModelImpl._modelId;

        modelOutputChartOrderModelImpl._setOriginalModelId = false;

        modelOutputChartOrderModelImpl._originalModelOutputLabel = modelOutputChartOrderModelImpl._modelOutputLabel;

        modelOutputChartOrderModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ModelOutputChartOrder> toCacheModel() {
        ModelOutputChartOrderCacheModel modelOutputChartOrderCacheModel = new ModelOutputChartOrderCacheModel();

        modelOutputChartOrderCacheModel.modelOutputChartOrderPK = getModelOutputChartOrderPK();

        modelOutputChartOrderCacheModel.modelId = getModelId();

        modelOutputChartOrderCacheModel.modelOutputLabel = getModelOutputLabel();

        String modelOutputLabel = modelOutputChartOrderCacheModel.modelOutputLabel;

        if ((modelOutputLabel != null) && (modelOutputLabel.length() == 0)) {
            modelOutputChartOrderCacheModel.modelOutputLabel = null;
        }

        modelOutputChartOrderCacheModel.modelOutputChartOrder = getModelOutputChartOrder();

        modelOutputChartOrderCacheModel.modelIndexRangePolicy = getModelIndexRangePolicy();

        String modelIndexRangePolicy = modelOutputChartOrderCacheModel.modelIndexRangePolicy;

        if ((modelIndexRangePolicy != null) &&
                (modelIndexRangePolicy.length() == 0)) {
            modelOutputChartOrderCacheModel.modelIndexRangePolicy = null;
        }

        modelOutputChartOrderCacheModel.modelIndexRangeMessage = getModelIndexRangeMessage();

        String modelIndexRangeMessage = modelOutputChartOrderCacheModel.modelIndexRangeMessage;

        if ((modelIndexRangeMessage != null) &&
                (modelIndexRangeMessage.length() == 0)) {
            modelOutputChartOrderCacheModel.modelIndexRangeMessage = null;
        }

        modelOutputChartOrderCacheModel.modelIndexErrorPolicy = getModelIndexErrorPolicy();

        String modelIndexErrorPolicy = modelOutputChartOrderCacheModel.modelIndexErrorPolicy;

        if ((modelIndexErrorPolicy != null) &&
                (modelIndexErrorPolicy.length() == 0)) {
            modelOutputChartOrderCacheModel.modelIndexErrorPolicy = null;
        }

        modelOutputChartOrderCacheModel.modelIndexErrorMessage = getModelIndexErrorMessage();

        String modelIndexErrorMessage = modelOutputChartOrderCacheModel.modelIndexErrorMessage;

        if ((modelIndexErrorMessage != null) &&
                (modelIndexErrorMessage.length() == 0)) {
            modelOutputChartOrderCacheModel.modelIndexErrorMessage = null;
        }

        modelOutputChartOrderCacheModel.modelChartIsVisible = getModelChartIsVisible();

        return modelOutputChartOrderCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{modelOutputChartOrderPK=");
        sb.append(getModelOutputChartOrderPK());
        sb.append(", modelId=");
        sb.append(getModelId());
        sb.append(", modelOutputLabel=");
        sb.append(getModelOutputLabel());
        sb.append(", modelOutputChartOrder=");
        sb.append(getModelOutputChartOrder());
        sb.append(", modelIndexRangePolicy=");
        sb.append(getModelIndexRangePolicy());
        sb.append(", modelIndexRangeMessage=");
        sb.append(getModelIndexRangeMessage());
        sb.append(", modelIndexErrorPolicy=");
        sb.append(getModelIndexErrorPolicy());
        sb.append(", modelIndexErrorMessage=");
        sb.append(getModelIndexErrorMessage());
        sb.append(", modelChartIsVisible=");
        sb.append(getModelChartIsVisible());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ModelOutputChartOrder");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>modelOutputChartOrderPK</column-name><column-value><![CDATA[");
        sb.append(getModelOutputChartOrderPK());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelId</column-name><column-value><![CDATA[");
        sb.append(getModelId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelOutputLabel</column-name><column-value><![CDATA[");
        sb.append(getModelOutputLabel());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelOutputChartOrder</column-name><column-value><![CDATA[");
        sb.append(getModelOutputChartOrder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelIndexRangePolicy</column-name><column-value><![CDATA[");
        sb.append(getModelIndexRangePolicy());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelIndexRangeMessage</column-name><column-value><![CDATA[");
        sb.append(getModelIndexRangeMessage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelIndexErrorPolicy</column-name><column-value><![CDATA[");
        sb.append(getModelIndexErrorPolicy());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelIndexErrorMessage</column-name><column-value><![CDATA[");
        sb.append(getModelIndexErrorMessage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modelChartIsVisible</column-name><column-value><![CDATA[");
        sb.append(getModelChartIsVisible());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
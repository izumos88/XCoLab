package com.ext.portlet.model.impl;

import com.ext.portlet.model.ProposalContestPhaseAttributeType;
import com.ext.portlet.model.ProposalContestPhaseAttributeTypeModel;
import com.ext.portlet.model.ProposalContestPhaseAttributeTypeSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the ProposalContestPhaseAttributeType service. Represents a row in the &quot;xcolab_ProposalContestPhaseAttributeType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.ProposalContestPhaseAttributeTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProposalContestPhaseAttributeTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalContestPhaseAttributeTypeImpl
 * @see com.ext.portlet.model.ProposalContestPhaseAttributeType
 * @see com.ext.portlet.model.ProposalContestPhaseAttributeTypeModel
 * @generated
 */
@JSON(strict = true)
public class ProposalContestPhaseAttributeTypeModelImpl extends BaseModelImpl<ProposalContestPhaseAttributeType>
    implements ProposalContestPhaseAttributeTypeModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a proposal contest phase attribute type model instance should use the {@link com.ext.portlet.model.ProposalContestPhaseAttributeType} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_ProposalContestPhaseAttributeType";
    public static final Object[][] TABLE_COLUMNS = {
            { "name", Types.VARCHAR },
            { "copyOnPromote", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_ProposalContestPhaseAttributeType (name VARCHAR(75) not null primary key,copyOnPromote BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_ProposalContestPhaseAttributeType";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.ProposalContestPhaseAttributeType"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.ProposalContestPhaseAttributeType"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.ProposalContestPhaseAttributeType"));
    private static ClassLoader _classLoader = ProposalContestPhaseAttributeType.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            ProposalContestPhaseAttributeType.class
        };
    private String _name;
    private boolean _copyOnPromote;
    private ProposalContestPhaseAttributeType _escapedModelProxy;

    public ProposalContestPhaseAttributeTypeModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ProposalContestPhaseAttributeType toModel(
        ProposalContestPhaseAttributeTypeSoap soapModel) {
        ProposalContestPhaseAttributeType model = new ProposalContestPhaseAttributeTypeImpl();

        model.setName(soapModel.getName());
        model.setCopyOnPromote(soapModel.getCopyOnPromote());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ProposalContestPhaseAttributeType> toModels(
        ProposalContestPhaseAttributeTypeSoap[] soapModels) {
        List<ProposalContestPhaseAttributeType> models = new ArrayList<ProposalContestPhaseAttributeType>(soapModels.length);

        for (ProposalContestPhaseAttributeTypeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _name;
    }

    public void setPrimaryKey(String primaryKey) {
        setName(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return _name;
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
    }

    public Class<?> getModelClass() {
        return ProposalContestPhaseAttributeType.class;
    }

    public String getModelClassName() {
        return ProposalContestPhaseAttributeType.class.getName();
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
    public boolean getCopyOnPromote() {
        return _copyOnPromote;
    }

    public boolean isCopyOnPromote() {
        return _copyOnPromote;
    }

    public void setCopyOnPromote(boolean copyOnPromote) {
        _copyOnPromote = copyOnPromote;
    }

    @Override
    public ProposalContestPhaseAttributeType toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (ProposalContestPhaseAttributeType) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        ProposalContestPhaseAttributeTypeImpl proposalContestPhaseAttributeTypeImpl =
            new ProposalContestPhaseAttributeTypeImpl();

        proposalContestPhaseAttributeTypeImpl.setName(getName());
        proposalContestPhaseAttributeTypeImpl.setCopyOnPromote(getCopyOnPromote());

        proposalContestPhaseAttributeTypeImpl.resetOriginalValues();

        return proposalContestPhaseAttributeTypeImpl;
    }

    public int compareTo(
        ProposalContestPhaseAttributeType proposalContestPhaseAttributeType) {
        String primaryKey = proposalContestPhaseAttributeType.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ProposalContestPhaseAttributeType proposalContestPhaseAttributeType = null;

        try {
            proposalContestPhaseAttributeType = (ProposalContestPhaseAttributeType) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String primaryKey = proposalContestPhaseAttributeType.getPrimaryKey();

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
    }

    @Override
    public CacheModel<ProposalContestPhaseAttributeType> toCacheModel() {
        ProposalContestPhaseAttributeTypeCacheModel proposalContestPhaseAttributeTypeCacheModel =
            new ProposalContestPhaseAttributeTypeCacheModel();

        proposalContestPhaseAttributeTypeCacheModel.name = getName();

        String name = proposalContestPhaseAttributeTypeCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            proposalContestPhaseAttributeTypeCacheModel.name = null;
        }

        proposalContestPhaseAttributeTypeCacheModel.copyOnPromote = getCopyOnPromote();

        return proposalContestPhaseAttributeTypeCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{name=");
        sb.append(getName());
        sb.append(", copyOnPromote=");
        sb.append(getCopyOnPromote());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.ProposalContestPhaseAttributeType");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>copyOnPromote</column-name><column-value><![CDATA[");
        sb.append(getCopyOnPromote());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
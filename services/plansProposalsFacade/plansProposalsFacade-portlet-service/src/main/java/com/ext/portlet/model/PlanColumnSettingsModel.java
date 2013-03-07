package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the PlanColumnSettings service. Represents a row in the &quot;xcolab_PlanColumnSettings&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.PlanColumnSettingsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.PlanColumnSettingsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanColumnSettings
 * @see com.ext.portlet.model.impl.PlanColumnSettingsImpl
 * @see com.ext.portlet.model.impl.PlanColumnSettingsModelImpl
 * @generated
 */
public interface PlanColumnSettingsModel extends BaseModel<PlanColumnSettings> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a plan column settings model instance should use the {@link PlanColumnSettings} interface instead.
     */

    /**
     * Returns the primary key of this plan column settings.
     *
     * @return the primary key of this plan column settings
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this plan column settings.
     *
     * @param primaryKey the primary key of this plan column settings
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the plan column settings ID of this plan column settings.
     *
     * @return the plan column settings ID of this plan column settings
     */
    public long getPlanColumnSettingsId();

    /**
     * Sets the plan column settings ID of this plan column settings.
     *
     * @param planColumnSettingsId the plan column settings ID of this plan column settings
     */
    public void setPlanColumnSettingsId(long planColumnSettingsId);

    /**
     * Returns the column name of this plan column settings.
     *
     * @return the column name of this plan column settings
     */
    @AutoEscape
    public String getColumnName();

    /**
     * Sets the column name of this plan column settings.
     *
     * @param columnName the column name of this plan column settings
     */
    public void setColumnName(String columnName);

    /**
     * Returns the plan user settings ID of this plan column settings.
     *
     * @return the plan user settings ID of this plan column settings
     */
    public long getPlanUserSettingsId();

    /**
     * Sets the plan user settings ID of this plan column settings.
     *
     * @param planUserSettingsId the plan user settings ID of this plan column settings
     */
    public void setPlanUserSettingsId(long planUserSettingsId);

    /**
     * Returns the visible of this plan column settings.
     *
     * @return the visible of this plan column settings
     */
    public boolean getVisible();

    /**
     * Returns <code>true</code> if this plan column settings is visible.
     *
     * @return <code>true</code> if this plan column settings is visible; <code>false</code> otherwise
     */
    public boolean isVisible();

    /**
     * Sets whether this plan column settings is visible.
     *
     * @param visible the visible of this plan column settings
     */
    public void setVisible(boolean visible);

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

    public int compareTo(PlanColumnSettings planColumnSettings);

    public int hashCode();

    public CacheModel<PlanColumnSettings> toCacheModel();

    public PlanColumnSettings toEscapedModel();

    public String toString();

    public String toXmlString();
}
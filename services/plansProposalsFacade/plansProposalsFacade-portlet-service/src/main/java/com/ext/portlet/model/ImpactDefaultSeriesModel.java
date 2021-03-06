package com.ext.portlet.model;

import com.ext.portlet.service.persistence.ImpactDefaultSeriesPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ImpactDefaultSeries service. Represents a row in the &quot;xcolab_ImpactDefaultSeries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ImpactDefaultSeriesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ImpactDefaultSeriesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImpactDefaultSeries
 * @see com.ext.portlet.model.impl.ImpactDefaultSeriesImpl
 * @see com.ext.portlet.model.impl.ImpactDefaultSeriesModelImpl
 * @generated
 */
public interface ImpactDefaultSeriesModel extends BaseModel<ImpactDefaultSeries> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a impact default series model instance should use the {@link ImpactDefaultSeries} interface instead.
     */

    /**
     * Returns the primary key of this impact default series.
     *
     * @return the primary key of this impact default series
     */
    public ImpactDefaultSeriesPK getPrimaryKey();

    /**
     * Sets the primary key of this impact default series.
     *
     * @param primaryKey the primary key of this impact default series
     */
    public void setPrimaryKey(ImpactDefaultSeriesPK primaryKey);

    /**
     * Returns the series ID of this impact default series.
     *
     * @return the series ID of this impact default series
     */
    public long getSeriesId();

    /**
     * Sets the series ID of this impact default series.
     *
     * @param seriesId the series ID of this impact default series
     */
    public void setSeriesId(long seriesId);

    /**
     * Returns the name of this impact default series.
     *
     * @return the name of this impact default series
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this impact default series.
     *
     * @param name the name of this impact default series
     */
    public void setName(String name);

    /**
     * Returns the description of this impact default series.
     *
     * @return the description of this impact default series
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this impact default series.
     *
     * @param description the description of this impact default series
     */
    public void setDescription(String description);

    /**
     * Returns the focus area ID of this impact default series.
     *
     * @return the focus area ID of this impact default series
     */
    public long getFocusAreaId();

    /**
     * Sets the focus area ID of this impact default series.
     *
     * @param focusAreaId the focus area ID of this impact default series
     */
    public void setFocusAreaId(long focusAreaId);

    /**
     * Returns the visible of this impact default series.
     *
     * @return the visible of this impact default series
     */
    public boolean getVisible();

    /**
     * Returns <code>true</code> if this impact default series is visible.
     *
     * @return <code>true</code> if this impact default series is visible; <code>false</code> otherwise
     */
    public boolean isVisible();

    /**
     * Sets whether this impact default series is visible.
     *
     * @param visible the visible of this impact default series
     */
    public void setVisible(boolean visible);

    /**
     * Returns the editable of this impact default series.
     *
     * @return the editable of this impact default series
     */
    public boolean getEditable();

    /**
     * Returns <code>true</code> if this impact default series is editable.
     *
     * @return <code>true</code> if this impact default series is editable; <code>false</code> otherwise
     */
    public boolean isEditable();

    /**
     * Sets whether this impact default series is editable.
     *
     * @param editable the editable of this impact default series
     */
    public void setEditable(boolean editable);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(
        com.ext.portlet.model.ImpactDefaultSeries impactDefaultSeries);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.ImpactDefaultSeries> toCacheModel();

    @Override
    public com.ext.portlet.model.ImpactDefaultSeries toEscapedModel();

    @Override
    public com.ext.portlet.model.ImpactDefaultSeries toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

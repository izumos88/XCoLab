package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PlanSection service. Represents a row in the &quot;xcolab_PlanSection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.PlanSectionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.PlanSectionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanSection
 * @see com.ext.portlet.model.impl.PlanSectionImpl
 * @see com.ext.portlet.model.impl.PlanSectionModelImpl
 * @generated
 */
public interface PlanSectionModel extends BaseModel<PlanSection> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a plan section model instance should use the {@link PlanSection} interface instead.
     */

    /**
     * Returns the primary key of this plan section.
     *
     * @return the primary key of this plan section
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this plan section.
     *
     * @param primaryKey the primary key of this plan section
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this plan section.
     *
     * @return the ID of this plan section
     */
    public long getId();

    /**
     * Sets the ID of this plan section.
     *
     * @param id the ID of this plan section
     */
    public void setId(long id);

    /**
     * Returns the plan section definition ID of this plan section.
     *
     * @return the plan section definition ID of this plan section
     */
    public long getPlanSectionDefinitionId();

    /**
     * Sets the plan section definition ID of this plan section.
     *
     * @param planSectionDefinitionId the plan section definition ID of this plan section
     */
    public void setPlanSectionDefinitionId(long planSectionDefinitionId);

    /**
     * Returns the plan ID of this plan section.
     *
     * @return the plan ID of this plan section
     */
    public long getPlanId();

    /**
     * Sets the plan ID of this plan section.
     *
     * @param planId the plan ID of this plan section
     */
    public void setPlanId(long planId);

    /**
     * Returns the content of this plan section.
     *
     * @return the content of this plan section
     */
    @AutoEscape
    public String getContent();

    /**
     * Sets the content of this plan section.
     *
     * @param content the content of this plan section
     */
    public void setContent(String content);

    /**
     * Returns the numeric value of this plan section.
     *
     * @return the numeric value of this plan section
     */
    public long getNumericValue();

    /**
     * Sets the numeric value of this plan section.
     *
     * @param numericValue the numeric value of this plan section
     */
    public void setNumericValue(long numericValue);

    /**
     * Returns the created of this plan section.
     *
     * @return the created of this plan section
     */
    public Date getCreated();

    /**
     * Sets the created of this plan section.
     *
     * @param created the created of this plan section
     */
    public void setCreated(Date created);

    /**
     * Returns the version of this plan section.
     *
     * @return the version of this plan section
     */
    public long getVersion();

    /**
     * Sets the version of this plan section.
     *
     * @param version the version of this plan section
     */
    public void setVersion(long version);

    /**
     * Returns the plan version of this plan section.
     *
     * @return the plan version of this plan section
     */
    public long getPlanVersion();

    /**
     * Sets the plan version of this plan section.
     *
     * @param planVersion the plan version of this plan section
     */
    public void setPlanVersion(long planVersion);

    /**
     * Returns the update author ID of this plan section.
     *
     * @return the update author ID of this plan section
     */
    public long getUpdateAuthorId();

    /**
     * Sets the update author ID of this plan section.
     *
     * @param updateAuthorId the update author ID of this plan section
     */
    public void setUpdateAuthorId(long updateAuthorId);

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
    public int compareTo(com.ext.portlet.model.PlanSection planSection);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.PlanSection> toCacheModel();

    @Override
    public com.ext.portlet.model.PlanSection toEscapedModel();

    @Override
    public com.ext.portlet.model.PlanSection toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

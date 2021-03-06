package com.ext.portlet.model;

import com.ext.portlet.service.persistence.ImpactIterationPK;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ImpactIteration service. Represents a row in the &quot;xcolab_ImpactIteration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ImpactIterationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ImpactIterationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImpactIteration
 * @see com.ext.portlet.model.impl.ImpactIterationImpl
 * @see com.ext.portlet.model.impl.ImpactIterationModelImpl
 * @generated
 */
public interface ImpactIterationModel extends BaseModel<ImpactIteration> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a impact iteration model instance should use the {@link ImpactIteration} interface instead.
     */

    /**
     * Returns the primary key of this impact iteration.
     *
     * @return the primary key of this impact iteration
     */
    public ImpactIterationPK getPrimaryKey();

    /**
     * Sets the primary key of this impact iteration.
     *
     * @param primaryKey the primary key of this impact iteration
     */
    public void setPrimaryKey(ImpactIterationPK primaryKey);

    /**
     * Returns the iteration ID of this impact iteration.
     *
     * @return the iteration ID of this impact iteration
     */
    public long getIterationId();

    /**
     * Sets the iteration ID of this impact iteration.
     *
     * @param iterationId the iteration ID of this impact iteration
     */
    public void setIterationId(long iterationId);

    /**
     * Returns the year of this impact iteration.
     *
     * @return the year of this impact iteration
     */
    public int getYear();

    /**
     * Sets the year of this impact iteration.
     *
     * @param year the year of this impact iteration
     */
    public void setYear(int year);

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
    public int compareTo(com.ext.portlet.model.ImpactIteration impactIteration);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.ImpactIteration> toCacheModel();

    @Override
    public com.ext.portlet.model.ImpactIteration toEscapedModel();

    @Override
    public com.ext.portlet.model.ImpactIteration toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

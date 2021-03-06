package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ModelOutputItem service. Represents a row in the &quot;xcolab_ModelOutputItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ModelOutputItemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ModelOutputItemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelOutputItem
 * @see com.ext.portlet.model.impl.ModelOutputItemImpl
 * @see com.ext.portlet.model.impl.ModelOutputItemModelImpl
 * @generated
 */
public interface ModelOutputItemModel extends BaseModel<ModelOutputItem> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a model output item model instance should use the {@link ModelOutputItem} interface instead.
     */

    /**
     * Returns the primary key of this model output item.
     *
     * @return the primary key of this model output item
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this model output item.
     *
     * @param primaryKey the primary key of this model output item
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the model output item modifier p k of this model output item.
     *
     * @return the model output item modifier p k of this model output item
     */
    public long getModelOutputItemModifierPK();

    /**
     * Sets the model output item modifier p k of this model output item.
     *
     * @param modelOutputItemModifierPK the model output item modifier p k of this model output item
     */
    public void setModelOutputItemModifierPK(long modelOutputItemModifierPK);

    /**
     * Returns the model ID of this model output item.
     *
     * @return the model ID of this model output item
     */
    public long getModelId();

    /**
     * Sets the model ID of this model output item.
     *
     * @param modelId the model ID of this model output item
     */
    public void setModelId(long modelId);

    /**
     * Returns the model output item ID of this model output item.
     *
     * @return the model output item ID of this model output item
     */
    public long getModelOutputItemId();

    /**
     * Sets the model output item ID of this model output item.
     *
     * @param modelOutputItemId the model output item ID of this model output item
     */
    public void setModelOutputItemId(long modelOutputItemId);

    /**
     * Returns the model output item order of this model output item.
     *
     * @return the model output item order of this model output item
     */
    public int getModelOutputItemOrder();

    /**
     * Sets the model output item order of this model output item.
     *
     * @param modelOutputItemOrder the model output item order of this model output item
     */
    public void setModelOutputItemOrder(int modelOutputItemOrder);

    /**
     * Returns the model item range policy of this model output item.
     *
     * @return the model item range policy of this model output item
     */
    @AutoEscape
    public String getModelItemRangePolicy();

    /**
     * Sets the model item range policy of this model output item.
     *
     * @param modelItemRangePolicy the model item range policy of this model output item
     */
    public void setModelItemRangePolicy(String modelItemRangePolicy);

    /**
     * Returns the model item range message of this model output item.
     *
     * @return the model item range message of this model output item
     */
    @AutoEscape
    public String getModelItemRangeMessage();

    /**
     * Sets the model item range message of this model output item.
     *
     * @param modelItemRangeMessage the model item range message of this model output item
     */
    public void setModelItemRangeMessage(String modelItemRangeMessage);

    /**
     * Returns the model item error policy of this model output item.
     *
     * @return the model item error policy of this model output item
     */
    @AutoEscape
    public String getModelItemErrorPolicy();

    /**
     * Sets the model item error policy of this model output item.
     *
     * @param modelItemErrorPolicy the model item error policy of this model output item
     */
    public void setModelItemErrorPolicy(String modelItemErrorPolicy);

    /**
     * Returns the model item error message of this model output item.
     *
     * @return the model item error message of this model output item
     */
    @AutoEscape
    public String getModelItemErrorMessage();

    /**
     * Sets the model item error message of this model output item.
     *
     * @param modelItemErrorMessage the model item error message of this model output item
     */
    public void setModelItemErrorMessage(String modelItemErrorMessage);

    /**
     * Returns the model item label format of this model output item.
     *
     * @return the model item label format of this model output item
     */
    @AutoEscape
    public String getModelItemLabelFormat();

    /**
     * Sets the model item label format of this model output item.
     *
     * @param modelItemLabelFormat the model item label format of this model output item
     */
    public void setModelItemLabelFormat(String modelItemLabelFormat);

    /**
     * Returns the model item is visible of this model output item.
     *
     * @return the model item is visible of this model output item
     */
    public boolean getModelItemIsVisible();

    /**
     * Returns <code>true</code> if this model output item is model item is visible.
     *
     * @return <code>true</code> if this model output item is model item is visible; <code>false</code> otherwise
     */
    public boolean isModelItemIsVisible();

    /**
     * Sets whether this model output item is model item is visible.
     *
     * @param modelItemIsVisible the model item is visible of this model output item
     */
    public void setModelItemIsVisible(boolean modelItemIsVisible);

    /**
     * Returns the item type of this model output item.
     *
     * @return the item type of this model output item
     */
    @AutoEscape
    public String getItemType();

    /**
     * Sets the item type of this model output item.
     *
     * @param itemType the item type of this model output item
     */
    public void setItemType(String itemType);

    /**
     * Returns the related output item of this model output item.
     *
     * @return the related output item of this model output item
     */
    public long getRelatedOutputItem();

    /**
     * Sets the related output item of this model output item.
     *
     * @param relatedOutputItem the related output item of this model output item
     */
    public void setRelatedOutputItem(long relatedOutputItem);

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
    public int compareTo(com.ext.portlet.model.ModelOutputItem modelOutputItem);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.ModelOutputItem> toCacheModel();

    @Override
    public com.ext.portlet.model.ModelOutputItem toEscapedModel();

    @Override
    public com.ext.portlet.model.ModelOutputItem toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

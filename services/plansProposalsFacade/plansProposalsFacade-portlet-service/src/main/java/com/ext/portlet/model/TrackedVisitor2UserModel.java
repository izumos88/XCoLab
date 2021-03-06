package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TrackedVisitor2User service. Represents a row in the &quot;xcolab_TrackedVisitor2User&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.TrackedVisitor2UserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.TrackedVisitor2UserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrackedVisitor2User
 * @see com.ext.portlet.model.impl.TrackedVisitor2UserImpl
 * @see com.ext.portlet.model.impl.TrackedVisitor2UserModelImpl
 * @generated
 */
public interface TrackedVisitor2UserModel extends BaseModel<TrackedVisitor2User> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a tracked visitor2 user model instance should use the {@link TrackedVisitor2User} interface instead.
     */

    /**
     * Returns the primary key of this tracked visitor2 user.
     *
     * @return the primary key of this tracked visitor2 user
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this tracked visitor2 user.
     *
     * @param primaryKey the primary key of this tracked visitor2 user
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this tracked visitor2 user.
     *
     * @return the ID of this tracked visitor2 user
     */
    public long getId();

    /**
     * Sets the ID of this tracked visitor2 user.
     *
     * @param id the ID of this tracked visitor2 user
     */
    public void setId(long id);

    /**
     * Returns the uuid of this tracked visitor2 user.
     *
     * @return the uuid of this tracked visitor2 user
     */
    @AutoEscape
    public String getUuid();

    /**
     * Sets the uuid of this tracked visitor2 user.
     *
     * @param uuid the uuid of this tracked visitor2 user
     */
    public void setUuid(String uuid);

    /**
     * Returns the user ID of this tracked visitor2 user.
     *
     * @return the user ID of this tracked visitor2 user
     */
    public long getUserId();

    /**
     * Sets the user ID of this tracked visitor2 user.
     *
     * @param userId the user ID of this tracked visitor2 user
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this tracked visitor2 user.
     *
     * @return the user uuid of this tracked visitor2 user
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this tracked visitor2 user.
     *
     * @param userUuid the user uuid of this tracked visitor2 user
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the create date of this tracked visitor2 user.
     *
     * @return the create date of this tracked visitor2 user
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this tracked visitor2 user.
     *
     * @param createDate the create date of this tracked visitor2 user
     */
    public void setCreateDate(Date createDate);

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
        com.ext.portlet.model.TrackedVisitor2User trackedVisitor2User);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.TrackedVisitor2User> toCacheModel();

    @Override
    public com.ext.portlet.model.TrackedVisitor2User toEscapedModel();

    @Override
    public com.ext.portlet.model.TrackedVisitor2User toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

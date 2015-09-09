package com.ext.portlet.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Proposal service. Represents a row in the &quot;xcolab_Proposal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ProposalModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ProposalImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Proposal
 * @see com.ext.portlet.model.impl.ProposalImpl
 * @see com.ext.portlet.model.impl.ProposalModelImpl
 * @generated
 */
public interface ProposalModel extends BaseModel<Proposal> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a proposal model instance should use the {@link Proposal} interface instead.
     */

    /**
     * Returns the primary key of this proposal.
     *
     * @return the primary key of this proposal
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this proposal.
     *
     * @param primaryKey the primary key of this proposal
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the proposal ID of this proposal.
     *
     * @return the proposal ID of this proposal
     */
    public long getProposalId();

    /**
     * Sets the proposal ID of this proposal.
     *
     * @param proposalId the proposal ID of this proposal
     */
    public void setProposalId(long proposalId);

    /**
     * Returns the create date of this proposal.
     *
     * @return the create date of this proposal
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this proposal.
     *
     * @param createDate the create date of this proposal
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the updated date of this proposal.
     *
     * @return the updated date of this proposal
     */
    public Date getUpdatedDate();

    /**
     * Sets the updated date of this proposal.
     *
     * @param updatedDate the updated date of this proposal
     */
    public void setUpdatedDate(Date updatedDate);

    /**
     * Returns the current version of this proposal.
     *
     * @return the current version of this proposal
     */
    public int getCurrentVersion();

    /**
     * Sets the current version of this proposal.
     *
     * @param currentVersion the current version of this proposal
     */
    public void setCurrentVersion(int currentVersion);

    /**
     * Returns the author ID of this proposal.
     *
     * @return the author ID of this proposal
     */
    public long getAuthorId();

    /**
     * Sets the author ID of this proposal.
     *
     * @param authorId the author ID of this proposal
     */
    public void setAuthorId(long authorId);

    /**
     * Returns the visible of this proposal.
     *
     * @return the visible of this proposal
     */
    public boolean getVisible();

    /**
     * Returns <code>true</code> if this proposal is visible.
     *
     * @return <code>true</code> if this proposal is visible; <code>false</code> otherwise
     */
    public boolean isVisible();

    /**
     * Sets whether this proposal is visible.
     *
     * @param visible the visible of this proposal
     */
    public void setVisible(boolean visible);

    /**
     * Returns the discussion ID of this proposal.
     *
     * @return the discussion ID of this proposal
     */
    public long getDiscussionId();

    /**
     * Sets the discussion ID of this proposal.
     *
     * @param discussionId the discussion ID of this proposal
     */
    public void setDiscussionId(long discussionId);

    /**
     * Returns the results discussion ID of this proposal.
     *
     * @return the results discussion ID of this proposal
     */
    public long getResultsDiscussionId();

    /**
     * Sets the results discussion ID of this proposal.
     *
     * @param resultsDiscussionId the results discussion ID of this proposal
     */
    public void setResultsDiscussionId(long resultsDiscussionId);

    /**
     * Returns the judge discussion ID of this proposal.
     *
     * @return the judge discussion ID of this proposal
     */
    public long getJudgeDiscussionId();

    /**
     * Sets the judge discussion ID of this proposal.
     *
     * @param judgeDiscussionId the judge discussion ID of this proposal
     */
    public void setJudgeDiscussionId(long judgeDiscussionId);

    /**
     * Returns the fellow discussion ID of this proposal.
     *
     * @return the fellow discussion ID of this proposal
     */
    public long getFellowDiscussionId();

    /**
     * Sets the fellow discussion ID of this proposal.
     *
     * @param fellowDiscussionId the fellow discussion ID of this proposal
     */
    public void setFellowDiscussionId(long fellowDiscussionId);

    /**
     * Returns the advisor discussion ID of this proposal.
     *
     * @return the advisor discussion ID of this proposal
     */
    public long getAdvisorDiscussionId();

    /**
     * Sets the advisor discussion ID of this proposal.
     *
     * @param advisorDiscussionId the advisor discussion ID of this proposal
     */
    public void setAdvisorDiscussionId(long advisorDiscussionId);

    /**
     * Returns the group ID of this proposal.
     *
     * @return the group ID of this proposal
     */
    public long getGroupId();

    /**
     * Sets the group ID of this proposal.
     *
     * @param groupId the group ID of this proposal
     */
    public void setGroupId(long groupId);

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
    public int compareTo(com.ext.portlet.model.Proposal proposal);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.Proposal> toCacheModel();

    @Override
    public com.ext.portlet.model.Proposal toEscapedModel();

    @Override
    public com.ext.portlet.model.Proposal toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

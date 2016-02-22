package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Contest service. Represents a row in the &quot;xcolab_Contest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ContestModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ContestImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contest
 * @see com.ext.portlet.model.impl.ContestImpl
 * @see com.ext.portlet.model.impl.ContestModelImpl
 * @generated
 */
public interface ContestModel extends BaseModel<Contest> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a contest model instance should use the {@link Contest} interface instead.
     */

    /**
     * Returns the primary key of this contest.
     *
     * @return the primary key of this contest
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this contest.
     *
     * @param primaryKey the primary key of this contest
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the contest p k of this contest.
     *
     * @return the contest p k of this contest
     */
    public long getContestPK();

    /**
     * Sets the contest p k of this contest.
     *
     * @param ContestPK the contest p k of this contest
     */
    public void setContestPK(long ContestPK);

    /**
     * Returns the contest type ID of this contest.
     *
     * @return the contest type ID of this contest
     */
    public long getContestTypeId();

    /**
     * Sets the contest type ID of this contest.
     *
     * @param contestTypeId the contest type ID of this contest
     */
    public void setContestTypeId(long contestTypeId);

    /**
     * Returns the contest name of this contest.
     *
     * @return the contest name of this contest
     */
    @AutoEscape
    public String getContestName();

    /**
     * Sets the contest name of this contest.
     *
     * @param ContestName the contest name of this contest
     */
    public void setContestName(String ContestName);

    /**
     * Returns the contest short name of this contest.
     *
     * @return the contest short name of this contest
     */
    @AutoEscape
    public String getContestShortName();

    /**
     * Sets the contest short name of this contest.
     *
     * @param ContestShortName the contest short name of this contest
     */
    public void setContestShortName(String ContestShortName);

    /**
     * Returns the contest url name of this contest.
     *
     * @return the contest url name of this contest
     */
    @AutoEscape
    public String getContestUrlName();

    /**
     * Sets the contest url name of this contest.
     *
     * @param ContestUrlName the contest url name of this contest
     */
    public void setContestUrlName(String ContestUrlName);

    /**
     * Returns the contest year of this contest.
     *
     * @return the contest year of this contest
     */
    public long getContestYear();

    /**
     * Sets the contest year of this contest.
     *
     * @param ContestYear the contest year of this contest
     */
    public void setContestYear(long ContestYear);

    /**
     * Returns the contest description of this contest.
     *
     * @return the contest description of this contest
     */
    @AutoEscape
    public String getContestDescription();

    /**
     * Sets the contest description of this contest.
     *
     * @param ContestDescription the contest description of this contest
     */
    public void setContestDescription(String ContestDescription);

    /**
     * Returns the contest model description of this contest.
     *
     * @return the contest model description of this contest
     */
    @AutoEscape
    public String getContestModelDescription();

    /**
     * Sets the contest model description of this contest.
     *
     * @param ContestModelDescription the contest model description of this contest
     */
    public void setContestModelDescription(String ContestModelDescription);

    /**
     * Returns the contest positions description of this contest.
     *
     * @return the contest positions description of this contest
     */
    @AutoEscape
    public String getContestPositionsDescription();

    /**
     * Sets the contest positions description of this contest.
     *
     * @param ContestPositionsDescription the contest positions description of this contest
     */
    public void setContestPositionsDescription(
        String ContestPositionsDescription);

    /**
     * Returns the created of this contest.
     *
     * @return the created of this contest
     */
    public Date getCreated();

    /**
     * Sets the created of this contest.
     *
     * @param created the created of this contest
     */
    public void setCreated(Date created);

    /**
     * Returns the updated of this contest.
     *
     * @return the updated of this contest
     */
    public Date getUpdated();

    /**
     * Sets the updated of this contest.
     *
     * @param updated the updated of this contest
     */
    public void setUpdated(Date updated);

    /**
     * Returns the author ID of this contest.
     *
     * @return the author ID of this contest
     */
    public long getAuthorId();

    /**
     * Sets the author ID of this contest.
     *
     * @param authorId the author ID of this contest
     */
    public void setAuthorId(long authorId);

    /**
     * Returns the contest active of this contest.
     *
     * @return the contest active of this contest
     */
    public boolean getContestActive();

    /**
     * Returns <code>true</code> if this contest is contest active.
     *
     * @return <code>true</code> if this contest is contest active; <code>false</code> otherwise
     */
    public boolean isContestActive();

    /**
     * Sets whether this contest is contest active.
     *
     * @param contestActive the contest active of this contest
     */
    public void setContestActive(boolean contestActive);

    /**
     * Returns the plan template ID of this contest.
     *
     * @return the plan template ID of this contest
     */
    public long getPlanTemplateId();

    /**
     * Sets the plan template ID of this contest.
     *
     * @param planTemplateId the plan template ID of this contest
     */
    public void setPlanTemplateId(long planTemplateId);

    /**
     * Returns the contest schedule ID of this contest.
     *
     * @return the contest schedule ID of this contest
     */
    public long getContestScheduleId();

    /**
     * Sets the contest schedule ID of this contest.
     *
     * @param contestScheduleId the contest schedule ID of this contest
     */
    public void setContestScheduleId(long contestScheduleId);

    /**
     * Returns the proposal creation template string of this contest.
     *
     * @return the proposal creation template string of this contest
     */
    @AutoEscape
    public String getProposalCreationTemplateString();

    /**
     * Sets the proposal creation template string of this contest.
     *
     * @param proposalCreationTemplateString the proposal creation template string of this contest
     */
    public void setProposalCreationTemplateString(
        String proposalCreationTemplateString);

    /**
     * Returns the vote template string of this contest.
     *
     * @return the vote template string of this contest
     */
    @AutoEscape
    public String getVoteTemplateString();

    /**
     * Sets the vote template string of this contest.
     *
     * @param voteTemplateString the vote template string of this contest
     */
    public void setVoteTemplateString(String voteTemplateString);

    /**
     * Returns the proposal vote template string of this contest.
     *
     * @return the proposal vote template string of this contest
     */
    @AutoEscape
    public String getProposalVoteTemplateString();

    /**
     * Sets the proposal vote template string of this contest.
     *
     * @param proposalVoteTemplateString the proposal vote template string of this contest
     */
    public void setProposalVoteTemplateString(String proposalVoteTemplateString);

    /**
     * Returns the proposal vote confirmation template string of this contest.
     *
     * @return the proposal vote confirmation template string of this contest
     */
    @AutoEscape
    public String getProposalVoteConfirmationTemplateString();

    /**
     * Sets the proposal vote confirmation template string of this contest.
     *
     * @param proposalVoteConfirmationTemplateString the proposal vote confirmation template string of this contest
     */
    public void setProposalVoteConfirmationTemplateString(
        String proposalVoteConfirmationTemplateString);

    /**
     * Returns the vote question template string of this contest.
     *
     * @return the vote question template string of this contest
     */
    @AutoEscape
    public String getVoteQuestionTemplateString();

    /**
     * Sets the vote question template string of this contest.
     *
     * @param voteQuestionTemplateString the vote question template string of this contest
     */
    public void setVoteQuestionTemplateString(String voteQuestionTemplateString);

    /**
     * Returns the focus area ID of this contest.
     *
     * @return the focus area ID of this contest
     */
    public long getFocusAreaId();

    /**
     * Sets the focus area ID of this contest.
     *
     * @param focusAreaId the focus area ID of this contest
     */
    public void setFocusAreaId(long focusAreaId);

    /**
     * Returns the contest tier of this contest.
     *
     * @return the contest tier of this contest
     */
    public long getContestTier();

    /**
     * Sets the contest tier of this contest.
     *
     * @param contestTier the contest tier of this contest
     */
    public void setContestTier(long contestTier);

    /**
     * Returns the contest logo ID of this contest.
     *
     * @return the contest logo ID of this contest
     */
    public long getContestLogoId();

    /**
     * Sets the contest logo ID of this contest.
     *
     * @param contestLogoId the contest logo ID of this contest
     */
    public void setContestLogoId(long contestLogoId);

    /**
     * Returns the featured of this contest.
     *
     * @return the featured of this contest
     */
    public boolean getFeatured();

    /**
     * Returns <code>true</code> if this contest is featured.
     *
     * @return <code>true</code> if this contest is featured; <code>false</code> otherwise
     */
    public boolean isFeatured();

    /**
     * Sets whether this contest is featured.
     *
     * @param featured the featured of this contest
     */
    public void setFeatured(boolean featured);

    /**
     * Returns the plans open by default of this contest.
     *
     * @return the plans open by default of this contest
     */
    public boolean getPlansOpenByDefault();

    /**
     * Returns <code>true</code> if this contest is plans open by default.
     *
     * @return <code>true</code> if this contest is plans open by default; <code>false</code> otherwise
     */
    public boolean isPlansOpenByDefault();

    /**
     * Sets whether this contest is plans open by default.
     *
     * @param plansOpenByDefault the plans open by default of this contest
     */
    public void setPlansOpenByDefault(boolean plansOpenByDefault);

    /**
     * Returns the sponsor logo ID of this contest.
     *
     * @return the sponsor logo ID of this contest
     */
    public long getSponsorLogoId();

    /**
     * Sets the sponsor logo ID of this contest.
     *
     * @param sponsorLogoId the sponsor logo ID of this contest
     */
    public void setSponsorLogoId(long sponsorLogoId);

    /**
     * Returns the sponsor text of this contest.
     *
     * @return the sponsor text of this contest
     */
    @AutoEscape
    public String getSponsorText();

    /**
     * Sets the sponsor text of this contest.
     *
     * @param sponsorText the sponsor text of this contest
     */
    public void setSponsorText(String sponsorText);

    /**
     * Returns the sponsor link of this contest.
     *
     * @return the sponsor link of this contest
     */
    @AutoEscape
    public String getSponsorLink();

    /**
     * Sets the sponsor link of this contest.
     *
     * @param sponsorLink the sponsor link of this contest
     */
    public void setSponsorLink(String sponsorLink);

    /**
     * Returns the flag of this contest.
     *
     * @return the flag of this contest
     */
    public int getFlag();

    /**
     * Sets the flag of this contest.
     *
     * @param flag the flag of this contest
     */
    public void setFlag(int flag);

    /**
     * Returns the flag text of this contest.
     *
     * @return the flag text of this contest
     */
    @AutoEscape
    public String getFlagText();

    /**
     * Sets the flag text of this contest.
     *
     * @param flagText the flag text of this contest
     */
    public void setFlagText(String flagText);

    /**
     * Returns the flag tooltip of this contest.
     *
     * @return the flag tooltip of this contest
     */
    @AutoEscape
    public String getFlagTooltip();

    /**
     * Sets the flag tooltip of this contest.
     *
     * @param flagTooltip the flag tooltip of this contest
     */
    public void setFlagTooltip(String flagTooltip);

    /**
     * Returns the group ID of this contest.
     *
     * @return the group ID of this contest
     */
    public long getGroupId();

    /**
     * Sets the group ID of this contest.
     *
     * @param groupId the group ID of this contest
     */
    public void setGroupId(long groupId);

    /**
     * Returns the discussion group ID of this contest.
     *
     * @return the discussion group ID of this contest
     */
    public long getDiscussionGroupId();

    /**
     * Sets the discussion group ID of this contest.
     *
     * @param discussionGroupId the discussion group ID of this contest
     */
    public void setDiscussionGroupId(long discussionGroupId);

    /**
     * Returns the fellow discussion group ID of this contest.
     *
     * @return the fellow discussion group ID of this contest
     */
    public long getFellowDiscussionGroupId();

    /**
     * Sets the fellow discussion group ID of this contest.
     *
     * @param fellowDiscussionGroupId the fellow discussion group ID of this contest
     */
    public void setFellowDiscussionGroupId(long fellowDiscussionGroupId);

    /**
     * Returns the weight of this contest.
     *
     * @return the weight of this contest
     */
    public int getWeight();

    /**
     * Sets the weight of this contest.
     *
     * @param weight the weight of this contest
     */
    public void setWeight(int weight);

    /**
     * Returns the resources url of this contest.
     *
     * @return the resources url of this contest
     */
    @AutoEscape
    public String getResourcesUrl();

    /**
     * Sets the resources url of this contest.
     *
     * @param resourcesUrl the resources url of this contest
     */
    public void setResourcesUrl(String resourcesUrl);

    /**
     * Returns the contest private of this contest.
     *
     * @return the contest private of this contest
     */
    public boolean getContestPrivate();

    /**
     * Returns <code>true</code> if this contest is contest private.
     *
     * @return <code>true</code> if this contest is contest private; <code>false</code> otherwise
     */
    public boolean isContestPrivate();

    /**
     * Sets whether this contest is contest private.
     *
     * @param contestPrivate the contest private of this contest
     */
    public void setContestPrivate(boolean contestPrivate);

    /**
     * Returns the use permissions of this contest.
     *
     * @return the use permissions of this contest
     */
    public boolean getUsePermissions();

    /**
     * Returns <code>true</code> if this contest is use permissions.
     *
     * @return <code>true</code> if this contest is use permissions; <code>false</code> otherwise
     */
    public boolean isUsePermissions();

    /**
     * Sets whether this contest is use permissions.
     *
     * @param usePermissions the use permissions of this contest
     */
    public void setUsePermissions(boolean usePermissions);

    /**
     * Returns the contest creation status of this contest.
     *
     * @return the contest creation status of this contest
     */
    @AutoEscape
    public String getContestCreationStatus();

    /**
     * Sets the contest creation status of this contest.
     *
     * @param contestCreationStatus the contest creation status of this contest
     */
    public void setContestCreationStatus(String contestCreationStatus);

    /**
     * Returns the default model ID of this contest.
     *
     * @return the default model ID of this contest
     */
    public long getDefaultModelId();

    /**
     * Sets the default model ID of this contest.
     *
     * @param defaultModelId the default model ID of this contest
     */
    public void setDefaultModelId(long defaultModelId);

    /**
     * Returns the other models of this contest.
     *
     * @return the other models of this contest
     */
    @AutoEscape
    public String getOtherModels();

    /**
     * Sets the other models of this contest.
     *
     * @param otherModels the other models of this contest
     */
    public void setOtherModels(String otherModels);

    /**
     * Returns the default model settings of this contest.
     *
     * @return the default model settings of this contest
     */
    @AutoEscape
    public String getDefaultModelSettings();

    /**
     * Sets the default model settings of this contest.
     *
     * @param defaultModelSettings the default model settings of this contest
     */
    public void setDefaultModelSettings(String defaultModelSettings);

    /**
     * Returns the points of this contest.
     *
     * @return the points of this contest
     */
    public double getPoints();

    /**
     * Sets the points of this contest.
     *
     * @param points the points of this contest
     */
    public void setPoints(double points);

    /**
     * Returns the default parent point type of this contest.
     *
     * @return the default parent point type of this contest
     */
    public long getDefaultParentPointType();

    /**
     * Sets the default parent point type of this contest.
     *
     * @param defaultParentPointType the default parent point type of this contest
     */
    public void setDefaultParentPointType(long defaultParentPointType);

    /**
     * Returns the point distribution strategy of this contest.
     *
     * @return the point distribution strategy of this contest
     */
    @AutoEscape
    public String getPointDistributionStrategy();

    /**
     * Sets the point distribution strategy of this contest.
     *
     * @param pointDistributionStrategy the point distribution strategy of this contest
     */
    public void setPointDistributionStrategy(String pointDistributionStrategy);

    /**
     * Returns the email template url of this contest.
     *
     * @return the email template url of this contest
     */
    @AutoEscape
    public String getEmailTemplateUrl();

    /**
     * Sets the email template url of this contest.
     *
     * @param emailTemplateUrl the email template url of this contest
     */
    public void setEmailTemplateUrl(String emailTemplateUrl);

    /**
     * Returns the show_in_tile_view of this contest.
     *
     * @return the show_in_tile_view of this contest
     */
    public boolean getShow_in_tile_view();

    /**
     * Returns <code>true</code> if this contest is show_in_tile_view.
     *
     * @return <code>true</code> if this contest is show_in_tile_view; <code>false</code> otherwise
     */
    public boolean isShow_in_tile_view();

    /**
     * Sets whether this contest is show_in_tile_view.
     *
     * @param show_in_tile_view the show_in_tile_view of this contest
     */
    public void setShow_in_tile_view(boolean show_in_tile_view);

    /**
     * Returns the show_in_list_view of this contest.
     *
     * @return the show_in_list_view of this contest
     */
    public boolean getShow_in_list_view();

    /**
     * Returns <code>true</code> if this contest is show_in_list_view.
     *
     * @return <code>true</code> if this contest is show_in_list_view; <code>false</code> otherwise
     */
    public boolean isShow_in_list_view();

    /**
     * Sets whether this contest is show_in_list_view.
     *
     * @param show_in_list_view the show_in_list_view of this contest
     */
    public void setShow_in_list_view(boolean show_in_list_view);

    /**
     * Returns the show_in_outline_view of this contest.
     *
     * @return the show_in_outline_view of this contest
     */
    public boolean getShow_in_outline_view();

    /**
     * Returns <code>true</code> if this contest is show_in_outline_view.
     *
     * @return <code>true</code> if this contest is show_in_outline_view; <code>false</code> otherwise
     */
    public boolean isShow_in_outline_view();

    /**
     * Sets whether this contest is show_in_outline_view.
     *
     * @param show_in_outline_view the show_in_outline_view of this contest
     */
    public void setShow_in_outline_view(boolean show_in_outline_view);

    /**
     * Returns the hide ribbons of this contest.
     *
     * @return the hide ribbons of this contest
     */
    public boolean getHideRibbons();

    /**
     * Returns <code>true</code> if this contest is hide ribbons.
     *
     * @return <code>true</code> if this contest is hide ribbons; <code>false</code> otherwise
     */
    public boolean isHideRibbons();

    /**
     * Sets whether this contest is hide ribbons.
     *
     * @param hideRibbons the hide ribbons of this contest
     */
    public void setHideRibbons(boolean hideRibbons);

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
    public int compareTo(com.ext.portlet.model.Contest contest);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.ext.portlet.model.Contest> toCacheModel();

    @Override
    public com.ext.portlet.model.Contest toEscapedModel();

    @Override
    public com.ext.portlet.model.Contest toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

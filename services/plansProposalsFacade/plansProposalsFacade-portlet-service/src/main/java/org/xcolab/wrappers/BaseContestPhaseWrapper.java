package org.xcolab.wrappers;

import com.ext.portlet.NoSuchContestPhaseException;
import com.ext.portlet.NoSuchProposalContestPhaseAttributeException;
import com.ext.portlet.ProposalContestPhaseAttributeKeys;
import com.ext.portlet.contests.ContestStatus;
import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.ContestPhaseType;
import com.ext.portlet.model.ProposalContestPhaseAttribute;
import com.ext.portlet.service.ContestPhaseLocalServiceUtil;
import com.ext.portlet.service.ContestPhaseTypeLocalServiceUtil;
import com.ext.portlet.service.ProposalContestPhaseAttributeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import org.apache.commons.lang.StringUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by johannes on 10/27/15.
 * A wrapper class for contest phases to be shared across portlets.
 * More specific wrappers should inherit from this one.
 */
public class BaseContestPhaseWrapper {
    protected final ContestPhase contestPhase;
    protected ContestStatus status;

    public BaseContestPhaseWrapper(long contestPhaseId) throws SystemException, PortalException {
        this(ContestPhaseLocalServiceUtil.getContestPhase(contestPhaseId));
    }

    public BaseContestPhaseWrapper(ContestPhase contestPhase) {
        if (contestPhase == null){
            throw new IllegalArgumentException("Contest phase must not be null.");
        }
        this.contestPhase = contestPhase;
    }

    public long getContestPhasePK() {
        return contestPhase.getContestPhasePK();
    }

    public void setContestPhasePK(long ContestPhasePK) {
        contestPhase.setContestPhasePK(ContestPhasePK);
    }

    public long getContestPK() {
        return contestPhase.getContestPK();
    }

    public void setContestPK(long ContestPK) {
        contestPhase.setContestPK(ContestPK);
    }

    public ContestPhaseType getContestPhaseTypeObject() throws SystemException {
        return ContestPhaseTypeLocalServiceUtil.fetchContestPhaseType(this.getContestPhaseType());
    }

    public long getContestPhaseType() {
        return contestPhase.getContestPhaseType();
    }

    public void setContestPhaseType(long ContestPhaseType) {
        contestPhase.setContestPhaseType(ContestPhaseType);
    }

    public String getContestPhaseAutopromote() {
        return contestPhase.getContestPhaseAutopromote();
    }

    public void setContestPhaseAutopromote(String contestPhaseAutopromote) {
        contestPhase.setContestPhaseAutopromote(contestPhaseAutopromote);
    }

    public String getContestPhaseDescriptionOverride() {
        return contestPhase.getContestPhaseDescriptionOverride();
    }

    public void setContestPhaseDescriptionOverride(String ContestPhaseDescriptionOverride) {
        contestPhase.setContestPhaseDescriptionOverride(ContestPhaseDescriptionOverride);
    }

    public Date getPhaseStartDate() {
        return contestPhase.getPhaseStartDate();
    }

    public Date getPhaseEndDate() {
        return contestPhase.getPhaseEndDate();
    }

    public Date getPhaseReferenceDate() {
        return (contestPhase.getPhaseEndDate() == null) ? contestPhase.getPhaseStartDate() : contestPhase.getPhaseEndDate();
    }

    public String getPhaseReferenceYear() {
        Date referenceDate = getPhaseReferenceDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(referenceDate);

        return ""+cal.get(Calendar.YEAR);
    }

    public Date getCreated() {
        return contestPhase.getCreated();
    }

    public void setCreated(Date created) {
        contestPhase.setCreated(created);
    }

    public long getAuthorId() {
        return contestPhase.getAuthorId();
    }

    public void setAuthorId(long authorId) {
        contestPhase.setAuthorId(authorId);
    }

    public ContestStatus getStatus() throws PortalException, SystemException {
        if (status == null) {
            String statusStr = ContestPhaseLocalServiceUtil.getContestStatusStr(contestPhase);
            if (statusStr != null) {
                status = ContestStatus.valueOf(statusStr);
            }
        }
        return status;
    }

    public boolean getCanVote() throws PortalException, SystemException {
        return (getStatus() != null) && getStatus().isCanVote();
    }

    public boolean getCanEdit() throws PortalException, SystemException {
        return (getStatus() != null) && getStatus().isCanEdit();
    }

    public boolean isActive() {
        return ContestPhaseLocalServiceUtil.getPhaseActive(contestPhase);
    }

    public long getMillisecondsTillEnd() {
        return (contestPhase.getPhaseEndDate() != null) ? (contestPhase.getPhaseEndDate().getTime() - System.currentTimeMillis()) : -1;
    }

    public String getName() throws PortalException, SystemException {
        return ContestPhaseLocalServiceUtil.getName(contestPhase);
    }

    public boolean isEnded() {
        Date now = new Date();
        return (contestPhase.getPhaseEndDate() != null) && contestPhase.getPhaseEndDate().before(now);
    }

    public boolean isAlreadyStarted() {
        Date now = new Date();
        return contestPhase.getPhaseStartDate().before(now);
    }

    public Boolean getProposalVisibility(long proposalId) {
        try {
            ProposalContestPhaseAttribute attr = ProposalContestPhaseAttributeLocalServiceUtil.getProposalContestPhaseAttribute(proposalId, contestPhase.getContestPhasePK(), ProposalContestPhaseAttributeKeys.VISIBLE);
            return attr.getNumericValue() == 1;
        } catch (SystemException | NoSuchProposalContestPhaseAttributeException e) {
            return true;
        }
    }

    public boolean setProposalVisibility(long proposalId, boolean visible) {
        try {
            ProposalContestPhaseAttributeLocalServiceUtil.setProposalContestPhaseAttribute(proposalId, contestPhase.getContestPhasePK(), ProposalContestPhaseAttributeKeys.VISIBLE, visible ? 1 : 0);
            return true;
        } catch (SystemException e) {
            return false;
        }
    }

    public String getPhaseStatusDescription() throws PortalException, SystemException {
        String descriptionOverride = contestPhase.getContestPhaseDescriptionOverride();
        if (StringUtils.isBlank(descriptionOverride)) {
            try {
                return ContestPhaseTypeLocalServiceUtil.getContestPhaseType(contestPhase.getContestPhaseType()).getDescription();
            } catch (NoSuchContestPhaseException e) {
                // ignore
            }
            return null;
        }
        return descriptionOverride;
    }

    public boolean getFellowScreeningActive(){
        return contestPhase.getFellowScreeningActive();
    }

    public ContestPhase getWrapped() {
        return contestPhase;
    }

    public String getContestPhaseUrl() throws SystemException {
        return ContestPhaseLocalServiceUtil.getContestPhaseLinkUrl(contestPhase);
    }
}

package org.xcolab.utils.judging;

import com.ext.portlet.model.ProposalRating;
import com.ext.portlet.model.ProposalRatingType;
import com.ext.portlet.model.ProposalRatingValue;
import com.ext.portlet.service.ProposalRatingTypeLocalServiceUtil;
import com.ext.portlet.service.ProposalRatingValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * Created by Manuel Thurner
 */
public class ProposalRatingWrapper {
    private ProposalRating proposalRating;


    public ProposalRatingWrapper(ProposalRating proposalRating) {
        this.proposalRating = proposalRating;
    }


    public ProposalRatingWrapper() {

    }

    public String getRatingValueName() {
        ProposalRatingValue ratingValue = this.getRatingValue();
        if (ratingValue != null) {
            return ratingValue.getName();
        } else {
            return "";
        }
    }

    public String getRatingTypeLabel() {
        ProposalRatingType ratingType = this.getRatingType();
        if (ratingType != null) {
            return ratingType.getLabel();
        } else {
            return "";
        }
    }
    public Long getRatingTypeId() {
        ProposalRatingType ratingType = this.getRatingType();
        if (ratingType != null) {
            return ratingType.getId();
        } else {
            return null;
        }
    }

    public ProposalRatingType getRatingType()  {
        ProposalRatingValue ratingValue = this.getRatingValue();
        try {
            if (ratingValue != null) {
                ProposalRatingType ratingType = ProposalRatingTypeLocalServiceUtil.fetchProposalRatingType(ratingValue.getRatingTypeId());
                return ratingType;
            }
        } catch (SystemException e) {
        }
        return null;
    }

    public ProposalRatingValue getRatingValue()  {
        try {
            ProposalRatingValue ratingValue = ProposalRatingValueLocalServiceUtil.fetchProposalRatingValue(this.proposalRating.getRatingValueId());
            return ratingValue;
        } catch (SystemException e) {
            return null;
        }
    }

    public User getUser()  {
        try {
            User u = UserLocalServiceUtil.fetchUser(this.proposalRating.getUserId());
            return u;
        } catch (SystemException e) {
            return null;
        }
    }

    public ProposalRating unwrap() {
        return proposalRating;
    }

    public void setRatingValueId(Long id) {
        this.proposalRating.setRatingValueId(id);
    }
}

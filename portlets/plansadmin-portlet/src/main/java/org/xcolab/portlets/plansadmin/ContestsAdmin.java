package org.xcolab.portlets.plansadmin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.portlet.PortletRequest;

import com.ext.portlet.model.Points;
import com.liferay.portal.kernel.exception.PortalException;

import com.liferay.portal.service.ServiceContext;
import org.xcolab.portlets.plansadmin.wrappers.ContestWrapper;

import com.ext.portlet.model.Contest;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.PointsLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class ContestsAdmin {
    private ContestWrapper editedContest;

    public List<Points> getMaterializedPoints() {
        return materializedPoints;
    }

    public void setMaterializedPoints(List<Points> materializedPoints) {
        this.materializedPoints = materializedPoints;
    }

    private List<Points> materializedPoints;
    
    public List<ContestWrapper> getContests() throws SystemException, PortalException {
        List<ContestWrapper> ret = new ArrayList<ContestWrapper>();
        
        for (Contest contest: ContestLocalServiceUtil.getContests(0, Integer.MAX_VALUE)) {
            ret.add(new ContestWrapper(contest));
        }
        
        return ret;
    }
    
    public void editContestActionListener(ActionEvent e) {
        editedContest = (ContestWrapper) e.getComponent().getAttributes().get("contest");
    }
    
    public String addContest() throws Exception {
        editedContest = new ContestWrapper(ContestLocalServiceUtil.createNewContest(10144L, "created contest"));
        return "editContest";
    }
    
    public String editContest() {
        return "editContest";
    }
    

    public String calculatePoints() throws PortalException, SystemException {
        Contest contest = editedContest.getContest();
        PointsLocalServiceUtil.distributePoints(contest.getContestPK());
        return null;
    }

    public String pointsPreview() throws PortalException, SystemException {
        Contest contest = editedContest.getContest();
        this.materializedPoints = PointsLocalServiceUtil.previewMaterializedPoints(contest.getContestPK());

        return "pointsPreview";
    }

    public String sendSupport2VotesEmail() throws PortalException, SystemException {
        Contest contest = editedContest.getContest();

        PortletRequest request = (PortletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setPortalURL(String.format("%s://%s%s", request.getScheme(), request.getServerName(),
                request.getServerPort() != 80 ? ":" + request.getServerPort() : ""));

        ContestLocalServiceUtil.transferSupportsToVote(contest, serviceContext);

        return null;
    }

    public void setEditedContest(ContestWrapper editedContest) {
        this.editedContest = editedContest;
    }

    public ContestWrapper getEditedContest() {
        return editedContest;
    }

}

<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
          xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
          xmlns:collab="http://climatecolab.org/tags/collab_1.0"
          xmlns:fn="http://java.sun.com/jsp/jstl/functions"
          xmlns:form="http://www.springframework.org/tags/form"
          xmlns:portlet="http://java.sun.com/portlet_2_0" version="2.0">

  <jsp:directive.include file="./init.jspx" />


  <div id="bread" class="pro">
    <a href="/web/guest/community">Community</a> <img
          src="/climatecolab-theme/images/arrow.gif" width="8" height="8" /> <a
          href="/web/guest/members">Members</a> <img
          src="/climatecolab-theme/images/arrow.gif" width="8" height="8" /> <a
          href="/web/guest/member/-/member/userId/${currentUser.userId}">${currentUser.userBean.screenName}</a>
    <img src="/climatecolab-theme/images/arrow.gif" width="8" height="8" />Subscriptions
  </div>

<!--
  <div id="content">

    <div class="main_long">
      <ice:form>
        <h1>Subscribed activities</h1>

        <ice:dataTable var="activity" value="${userBean.subscribedActivities}" id="activitiesTable" styleClass="colab" rowClasses='nt,t' rows="50">
          <ice:column style="width: 585px">
            <f:facet name="header">Activity</f:facet>
            <ice:outputText value="${activity.body}" escape="false" />
          </ice:column>

          <ice:column style="width: 140px">
            <f:facet name="header">Date</f:facet>
            <ice:outputText value="${activity.createdDate}">
              <f:convertDateTime pattern="MM/dd/yy hh:mm a" locale="en_US" timeZone="America/New_York"/>
            </ice:outputText>

          </ice:column>

        </ice:dataTable>
        <ice:panelGroup styleClass="pager">
          <table style="float: right;">
            <tr>

              <td>
                <ice:dataPaginator for="activitiesTable" rowsCountVar="rowsCount" displayedRowsCountVar="displayedRowsCountVar"
                                   firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex" pageCountVar="pageCount"
                                   pageIndexVar="pageIndex" >
                  <ice:outputFormat value="Page {0} of {1}" styleClass="page" escape="false">
                    <f:param value="${pageIndex}" />
                    <f:param value="${pageCount}" />
                  </ice:outputFormat>
                </ice:dataPaginator>
              </td>
              <td class="paginatorControls">
                <ice:dataPaginator rendered="true" for="activitiesTable" paginator="${true}" paginatorMaxPages="${5}" styleClass="comm_controls" style="display: inline;">
                  <f:facet name="first" rendered="true">
                    <ice:panelGroup >First</ice:panelGroup>
                  </f:facet>
                  <f:facet name="last" rendered="true">
                    <ice:panelGroup styleClass="">Last</ice:panelGroup>
                  </f:facet>
                  <f:facet name="previous" rendered="true">
                    <ice:panelGroup styleClass="pagerPrev">&lt; Prev</ice:panelGroup>
                  </f:facet>
                  <f:facet name="next">
                    <ice:panelGroup styleClass="">Next &gt;</ice:panelGroup>
                  </f:facet>
                </ice:dataPaginator>
              </td>
            </tr>
          </table>
          <div class="clear"></div>


        </ice:panelGroup>
      </ice:form>
    </div>
    <ice:panelGroup rendered="${userprofileBean.viewingOwnProfile}" styleClass="right_col3">

      <div class="blue-button">
        <a href="./#{currentUser.userId}/page/subscriptionsManage">MANAGE</a>
      </div>

    </ice:panelGroup>

    <div class="clearfix"></div>

  </div> -->


</jsp:root>
<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
          xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:fn="http://java.sun.com/jsp/jstl/functions"
          xmlns:form="http://www.springframework.org/tags/form"
          xmlns:proposalsPortlet="urn:jsptagdir:/WEB-INF/tags/proposalsPortlet"
          xmlns:portlet="http://java.sun.com/portlet_2_0" version="2.0"
          xmlns:collab="http://climatecolab.org/tags/collab_1.0">

    <jsp:directive.include file="./init_proposal.jspx"/>

    <script type="text/javascript" src="/html/js/editor/ckeditor_old/ckeditor.js" ><!-- --></script>
    <jsp:directive.include file="./proposalDetails/header.jspx" />

    <!--ProposalSectionsTabController-->
    <jsp:useBean id="updateProposalSectionsBean" scope="request" type="org.xcolab.portlets.proposals.requests.UpdateProposalDetailsBean"/>
    <c:if test="${move}">
        <jsp:useBean id="baseProposal" scope="request" type="org.xcolab.portlets.proposals.wrappers.ProposalWrapper"/>
        <jsp:useBean id="baseContest" scope="request" type="org.xcolab.portlets.proposals.wrappers.ContestWrapper"/>
    </c:if>

    <style>
        td em {
            background: #000; border-radius: 5px; font-style: normal;
            box-shadow: 0 0 2px #000;
        }
    </style>


<div id="content">
<div class="prop-left">

    <c:choose>
        <c:when test="${proposal.proposalId > 0 }">
            <portlet:actionURL var="updateProposalSectionsURL">
                <portlet:param name="action_forwardToPage" value="proposalDetails" />
                <portlet:param name="action_errorForwardToPage" value="proposalDetails" />
                <portlet:param name="contestId" value="${contest.contestPK }" />
                <portlet:param name="planId" value="${proposal.proposalId }" />
                <portlet:param name="action" value="updateProposalDetails" />
            </portlet:actionURL>
        </c:when>
        <c:otherwise>
            <portlet:actionURL var="updateProposalSectionsURL">
                <portlet:param name="action_forwardToPage" value="proposalDetails" />
                <portlet:param name="action_errorForwardToPage" value="createProposal" />
                <portlet:param name="contestId" value="${contest.contestPK }" />
                <portlet:param name="action" value="updateProposalDetails" />
            </portlet:actionURL>
        </c:otherwise>
    </c:choose>

    <div class="headline addprop">
        <c:choose>
            <c:when test="${move }">
                <p>
                    You're about to move a ${contestType.proposalName}
                    <collab:proposalLink proposal="${baseProposal}" escape="true" />
                    from ${contestType.contestName}
                    <collab:contestLink contest="${baseContest}" />
                    to ${contestType.contestName}
                    <collab:contestLink contest="${contest}" />.
                </p>
            </c:when>
            <c:when test="${not empty baseProposal}">
                <p>
                    You're about to create a ${contestType.proposalName} that will be based on
                    <collab:proposalLink proposal="${baseProposal}" escape="true" />.
                </p>
            </c:when>
        </c:choose>
        <p>
            Please complete your ${contestType.proposalName} based on the template below.
            If you have input on the template, please send it in a <a href="/web/guest/feedback" target="_blank">feedback message</a>.
            To save your ${contestType.proposalName}, you must agree to the <a href="/web/guest/resources/-/wiki/Main/Contest+Rules" target="_blank">Contest rules</a>
            and <a href="/web/guest/resources/-/wiki/Main/Terms+of+use" target="_blank">Terms of use</a>.
            <br/>Please note that you may be automatically logged out of your account after
            30 minutes. Please save all ${contestType.proposalName} content offline before clicking
            PUBLISH or else it may be lost.
        </p>
    </div> <!-- /headline -->


    <form action="/fileUpload" method="post" enctype="multipart/form-data" target="_fileUploadFrame" id="fileUploadForm">
        <input type="file" name="file" id="fileUploadInput" />
    </form>


    <form:form action="${updateProposalSectionsURL }" commandName="updateProposalSectionsBean" modelAttribute="updateProposalSectionsBean"  cssClass="addpropform" id="editForm">
        <form:hidden path="baseProposalId" />
        <form:hidden path="baseProposalContestId" />
        <form:hidden path="move" />
        <form:hidden path="hideOnMove" />
        <form:hidden path="moveFromContestPhaseId" />
        <form:hidden path="moveToContestPhaseId" />

        <div class="addpropbox q1">
            <label>
                <strong>Title</strong>
                <a class="helpTrigger" href="javascript:;"><img src="${themeDisplay.pathThemeImages}/icon-addprop-question.png" width="15" height="15" /></a><br />
                80 characters
            </label>
            <div class="addprophelp">Give your ${contestType.proposalName} a title. It's the first thing most people will see, so you'll want to make it descriptive and engaging.</div>
            <div class="addpropInputContainer">
                <form:input path="name" id="proposalName" />
                <form:errors path="name" cssClass="alert alert-error" />
                <div class="clearfix"><!--  --></div>

                <div class="clearfix"><!-- --></div>
                <div class="inputLimitContainer"><span class="limit_characterCount"><!--  --></span>/&#160;<span class="limit_charactersMax">80</span> characters</div>
            </div>
        </div>

        <div class="addpropbox blue q2">
            <label>
                <span><strong>Team name</strong><br />
                <em>optional</em></span>
                <a class="helpTrigger" href="javascript:;"><img src="${themeDisplay.pathThemeImages}/icon-addprop-question.png" width="15" height="15" /></a><br />
                20 characters
            </label>
            <div class="addprophelp">If you'd like to have your ${contestType.proposalName} appear under a team name, insert it here. Otherwise, the ${contestType.proposalName} will appear under the user name of its owner.</div>
            <div class="addpropInputContainer">
                <form:input path="team" id="proposalTeam" />
                <form:errors path="team" />

                <div class="clearfix"><!-- --></div>
                <div class="inputLimitContainer"><span class="limit_characterCount"><!--  --></span>/&#160;<span class="limit_charactersMax">20</span> characters</div>
            </div>
        </div>
        <div class="notation">Note: If you enter a team name, it will replace the ${contestType.proposalName} owner's name in the Author field.</div>

        <div class="addpropbox blue">
            <label>
                <span><strong>${contestType.proposalName} image</strong><br />
                <em>optional</em></span>
            </label>

            <div class="upload proposalImageUpload">
                <div class="uploadbox" id="proposalImage">
                    <c:choose>
                        <c:when test='${proposal.imageId > 0}'>
                            <c:set var="imageUrl" value="/image/proposal?img_id=${proposal.imageId}" />
                        </c:when>
                        <c:otherwise>
                            <c:set var="imageUrl" value="${themeDisplay.pathThemeImages}/proposal_default.png" />
                        </c:otherwise>
                    </c:choose>
                    <img src="${imageUrl }" width="52" height="52" alt="${proposal.name}" id="proposalImageImg"/>
                    <form:input path="imageId" cssStyle="display: none;" id="proposalImageId" />
                </div>

                <div id="uploadWidget"><!--  --></div>
                <div class="clear"><!--  --></div>
            </div>
        </div>

        <div class="addpropbox q3">
            <label>
                <strong>Pitch</strong>
                <a href="javascript:;" class="helpTrigger"><img src="${themeDisplay.pathThemeImages}/icon-addprop-question.png" width="15" height="15" /></a><br />
                140 characters
            </label>
            <div class="addprophelp">Insert a tweet-length (140 character) message that conveys the key idea behind your ${contestType.proposalName}.</div>
            <div class="addpropInputContainer">
                <form:textarea path="pitch" id="proposalPitchInput" cssClass="proposalPitchInput" />
                <form:errors path="pitch" />
                <div class="clearfix"><!-- --></div>
                <div class="inputLimitContainer">
                    <span class="limit_characterCount"><!--  --></span>/&#160;<span class="limit_charactersMax">140</span> characters
                </div>
            </div>

            <script>
                jQuery("textarea#proposalPitchInput").keydown(function(e) {
                    var TABKEY = 9;
                    if(e.keyCode == TABKEY) {
                        this.value += "    ";
                        if(e.preventDefault) {
                            e.preventDefault();
                        }
                        return false;
                    }
                });
            </script>
        </div>

        <!-- legacy for old proposals-->
        <c:if test="${fn:length(proposal.description) gt 0}">
            <div class="addpropbox q3">
                <label>
                    <strong>Description</strong>
                    <a href="javascript:;" class="helpTrigger"><img src="${themeDisplay.pathThemeImages}/icon-addprop-question.png" width="15" height="15" /></a><br />
                </label>

                <div class="addpropInputContainer">
                    <form:textarea cssClass="rte"  cols="54" rows="7" path="description" />
                </div>
            </div>
        </c:if>

        <c:forEach var="section" items="${proposal.sections }">
            <c:if test="${not section.locked }">
                <div class="addpropbox q3 ${section.type}" data-section-id="${section.sectionDefinitionId }">
                    <proposalsPortlet:proposalSectionEdit section="${section }" showCopySectionContentButton="${hasNotMappedSections and not empty baseProposal }"/>
                </div>
            </c:if>
        </c:forEach>
    </form:form>


</div>
<jsp:directive.include file="./proposalDetails/proposalSummary.jspx" />


<div id="acceptTosPopup" style="position: fixed; width: 100%; height: 100%; top: 0; left: 0; z-index: 100; display: none;">
    <div class="popup-wrap p1" id="acceptTosPopup">
        <div class="popup">
            <h4>By saving your ${contestType.proposalName} you are entering the Climate CoLab ${contestType.contestName} and agree to the&#160;
                <a href="/web/guest/resources/-/wiki/Main/Terms+of+use" target="_blank">Terms of Use</a>
                &#160;and ${contestType.contestName} Rules.</h4>

            <h5>${fn:toUpperCase(contestType.contestName)} RULES:</h5>
            <div class="terms">
                    ${preferences.termsOfService}
            </div>
            <div class="btns">
                <a class="primary-button cp1-1" href="javascript:;" id="tosAccepted">ACCEPT</a>
                <a class="grey-button cp1-2" href="javascript:;" id="closeAcceptTos">DO NOT Accept</a>
            </div>
        </div>
    </div>
</div>

<div id="invalidFieldsPopupContainer" style="position: fixed; width: 100%; height: 100%; top: 0; left: 0; z-index: 100; display: none; ">
    <div class="popup-wrap p1" id="invalidFieldsPopup">
        <div class="popup">
            <h4>The following sections have too many characters:</h4>
            <ul id="invalidFieldsList"><!--  --></ul>
            <div class="btns">
                <a class="primary-button cp1-1" href="javascript:;" onclick="jQuery('#invalidFieldsPopupContainer').fadeOut('fast')">CLOSE</a>
            </div>
        </div>
    </div>
</div>

<div class="admin-overlay-wrap">
    <div class="admin-overlay">
        <div class="inner">
            <div class="admin-left">
                <p>
                    <c:choose>
                        <c:when test="${proposal.currentVersion le 1}">
                            You are currently editing a new ${contestType.proposalName}
                        </c:when>
                        <c:otherwise>
                            You are editing a ${contestType.proposalName}
                        </c:otherwise>
                    </c:choose>
                    <br />
                    <c:if test="${not empty proposal.name }">"${proposal.name}"</c:if>
                </p>
                <a class="primary-button" href="#" id="saveChangesButton">SAVE and PUBLISH changes</a>
                <c:choose>
                    <c:when test="${proposal.currentVersion > 0 }">
                        <collab:proposalLink proposal="${proposal}" cssClass="grey-button"
                                             linkId="discardChangesButton" text="DISCARD changes" />
                    </c:when>
                    <c:otherwise>
                        <!--  proposal creation, return to contest proposals page on discard -->
                        <collab:contestLink contest="${contest}" cssClass="grey-button"
                                            linkId="discardChangesButton" text="DISCARD changes" />
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="admin-right">
                <p>&#160;</p>
            </div>
        </div>
    </div>
</div>

</div>

<iframe name="_fileUploadFrame" id="fileUploadFrame" class="hidden" style="display: none;"><!-- comment --></iframe>

	<jsp:directive.include file="./proposalDetails/proposalPicker_widget.jspx" />

    <script type="text/javascript">
        var submitTimer;

        jQuery("#fileUploadInput").change(function() {
            jQuery("#fileUploadForm").submit();
            jQuery("#proposalImage").block({message: "", css: {"font-size":"12px", margin: "0px", padding: 0}});
        });
        jQuery("#fileUploadFrame").load(
                function() {
                    try {
                        var response = eval("("	+ jQuery(this).contents().text() + ")");

                        jQuery("#proposalImageImg").attr("src", "/image/proposal?img_id=" + response.imageId);
                        jQuery("#proposalImage").unblock();
                        jQuery("#proposalImageId").val(response.imageId);
                    }
                    catch (e) {
                    }
                }
        );

        function updateUploadBtnOffset() {
            var container = jQuery("#uploadWidget");
            var containerOffset = container.offset();

            jQuery("#fileUploadInput").offset(containerOffset);

        }

        function showAcceptTosPopup() {
            jQuery("#acceptTosPopup").fadeIn("fast");
        }

        function closeAcceptTosPopup() {
            jQuery("#acceptTosPopup").fadeOut("fast");
            enableButtons();
        }

        function tosAcceptedSave() {
            jQuery("#acceptTosPopup").fadeOut("fast");
            disableButtons(true);
            saveIfValid();
        }

        function saveIfValid() {
            disableButtons();
            if (validatePlanEditForm()) {
                disableDirtyCheck();
                jQuery("#editForm").submit();
            }
        }

        jQuery(function() {
            updateUploadBtnOffset();
            $(window).resize(updateUploadBtnOffset);

            jQuery("#saveChangesButton").click(function() {
                if (${proposal.proposalId > 0}) {
                    disableButtons(true);
                    saveIfValid();
                }
                else {
                    disableButtons(false);
                    showAcceptTosPopup();
                }
            });

            jQuery("#closeAcceptTos").click(closeAcceptTosPopup);
            jQuery("#tosAccepted").click(tosAcceptedSave);

            enableDirtyCheck();
        });

        function enableButtons() {
            jQuery("#saveChangesButton,#discardChangesButton").removeClass("disabled");
        }
        
        function disableButtons(withTimeout) {
            var buttons = jQuery("#saveChangesButton,#discardChangesButton");
            buttons.addClass("disabled");

            if (withTimeout) {
                setTimeout(function () {
                    buttons.removeClass("disabled");
                }, 5000);
            }
        }
    </script>
<div id="copyProposalContainer" style="display: none;">
    <div class="popup-wrap p1" id="copyProposalPopup">
        <div class="popup">
            <div class="closepopuplogin">
                <a href="javascript:;" onclick="jQuery('#copyProposalContainer').hide()">
                    <img src="${themeDisplay.pathThemeImages}/help_close.png" width="20" height="20" alt="X"/>
                </a>
            </div>

            <h4>Choose section from base ${contestType.proposalName}, which content you want to copy</h4>
            <div class="lrContentPlaceholder lfr-column " id="copyProposalPopupContent">
                <div id="copyProposalContests"><!--  --></div>
                <center>
                    <a class="primary-button" href="javascript:;" onclick="$('#copyProposalContainer').hide();">Cancel</a>
                </center>
            </div>
        </div>
    </div>
    <script>
        var currentProposal = {
            	proposalId: ${proposal.proposalId},
            	version: ${proposal.version}
        	}
        <c:if test="${not empty baseProposal}">
        	var baseProposal = {
            	proposalId: ${baseProposal.proposalId},
            	version: ${baseProposal.version}
        	}
        </c:if>
        <c:if test="${not empty baseContest}">
        	var baseContest = {
            	contestPK: ${baseContest.contestPK}
        	}
        </c:if>

    </script>
    
</div>


</jsp:root>

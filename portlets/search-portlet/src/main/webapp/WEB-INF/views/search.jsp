<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
          xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:collab="http://climatecolab.org/tags/collab_1.0"
          xmlns:portlet="http://java.sun.com/portlet_2_0" version="2.0">

    <portlet:defineObjects />

    <jsp:useBean id="searchBean" type="org.xcolab.portlets.search.SearchBean" scope="request"/>

    <h1>Search
        <c:if test="${not empty searchBean.searchPhrase}">
            Results for ${searchBean.searchPhrase}
        </c:if>
    </h1>

    <div class="searchFormContainer">
        <input value="${searchBean.searchPhrase}" class="searchPhrase" id="searchPhrase"/>
        <a class="primary-button" href="javascript:;"
           onclick="window.location = '/web/guest/search/-/search/for/' + encodeURI($('#searchPhrase').val())">Search</a>
    </div>

    <div id="main" class="searchresults">

        <c:if test="${searchBean.data.rowCount == 0 and not empty searchBean.searchPhrase}">
            <p>Nothing has been found.</p>
        </c:if>
        <div class="searchTable">
            <c:forEach var="item" items="${searchBean.items}" varStatus="loopStatus">
                <div class="result ${loopStatus.index % 2 == 0 ? 'blu' : ''}">
                    <div class="result_title">
                        <a href="${item.url}">${item.title}</a>
                    </div>
                    <div class="result_locale">
                        ${item.itemType.printName}
                    </div>
                    <div class="clear"><!-- --></div>
                    <p>${item.content}</p>
                </div>

            </c:forEach>
        </div>
    </div>

    <div class="right_col">
        <div class="comm_list">
            Show results for:
            <ul>
                <li class="${searchBean.selectedItemType == null ? 'c' : ''}">
                    <portlet:renderURL var="fullSiteUrl">
                        <portlet:param name="action" value="searchLocation" />
                        <portlet:param name="searchPhrase" value="${searchBean.searchPhrase}" />
                        <portlet:param name="searchLocation" value="FULL_SITE" />
                    </portlet:renderURL>
                    <a href="${fullSiteUrl}">Full Site</a>
                </li>
                <c:forEach var="itemType" items="${searchBean.itemTypes}">
                    <li class="${searchBean.selectedItemType == itemType ? 'c' : ''}">
                        <portlet:renderURL var="locationUrl">
                            <portlet:param name="action" value="searchLocation" />
                            <portlet:param name="searchPhrase" value="${searchBean.searchPhrase}" />
                            <portlet:param name="searchLocation" value="${itemType.name}" />
                        </portlet:renderURL>
                        <a href="${locationUrl}">${itemType.printName}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

</jsp:root>

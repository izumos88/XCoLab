package org.xcolab.portlets.users;

import com.ext.portlet.service.MemberCategoryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import org.apache.commons.lang3.StringUtils;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import org.xcolab.client.admin.enums.ConfigurationAttributeKey;
import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.commons.beans.SortFilterPage;
import org.xcolab.portlets.users.utils.MemberItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

@Controller
@RequestMapping("view")
public class MembersController {

    private static final int USERS_PER_PAGE = 20;

    private static final int AUTOCOMPLETE_MAX_USERS = 15;

    @RequestMapping
    public String showUsers(PortletRequest request, PortletResponse response, SortFilterPage sortFilterPage,
                            @RequestParam(value = "page", required = false) Long pageParam,
                            @RequestParam(value = "memberCategory", required = false) String memberCategoryParam,
                            Model model)
            throws SystemException, PortalException {
        int page = 1;
        if (pageParam != null) {
            page = pageParam.intValue();
        }

        int startPage = 1;
        if (page - 5 > 0) {
            startPage = page - 5;
        }

        int firstUser = 0;
        if (page > 1) {
            firstUser = (page - 1) * USERS_PER_PAGE;
        }

        int endUser = firstUser + USERS_PER_PAGE;


        String filterParam = request.getParameter("filter");
        if (filterParam != null) {
            sortFilterPage.setFilter(filterParam);
        }

        List<MemberItem> users = new ArrayList<>();

        if (StringUtils.isEmpty(sortFilterPage.getSortColumn())) {
            sortFilterPage.setSortColumn("POINTS");
            sortFilterPage.setSortAscending(false);
        }

        List<Member> dbUsersMicro = MembersClient.listMembers(
                "Judge".equalsIgnoreCase(memberCategoryParam) ? "Judges" : memberCategoryParam,
                filterParam, sortFilterPage.getSortColumn(), sortFilterPage.isSortAscending(),
                firstUser, endUser);

        for (Member user : dbUsersMicro) {
            MemberItem memberItem = new MemberItem(user, memberCategoryParam);
            users.add(memberItem);
        }

        int usersCount = MembersClient.countMembers(memberCategoryParam, filterParam);
        int pagesCount = (int) Math.ceil(usersCount / (double) USERS_PER_PAGE);
        int endPage = pagesCount;
        if (startPage + 10 < pagesCount) {
            endPage = startPage + 10;
        }

        model.addAttribute("pageNumber", page);
        model.addAttribute("pagesCount", pagesCount);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("sortFilterPage", sortFilterPage);
        model.addAttribute("users", users);
        model.addAttribute("usersCount", usersCount);
        model.addAttribute("memberCategory", memberCategoryParam);
        model.addAttribute("memberCategories", MemberCategoryLocalServiceUtil
                .getVisibleMemberCategories());

        model.addAttribute("colabName", ConfigurationAttributeKey.COLAB_NAME.getStringValue());
        model.addAttribute("colabShortName", ConfigurationAttributeKey.COLAB_SHORT_NAME.getStringValue());
        return "users";
    }

    @ResourceMapping("getUsersByPartialName")
    public void getUsersByPartialName(ResourceRequest request, ResourceResponse response,
            @RequestParam String partialName)
            throws IOException {
        final JSONArray jsonMembers = JSONFactoryUtil.createJSONArray();
        final List<Member> members = MembersClient
                .findMembersMatching(partialName, AUTOCOMPLETE_MAX_USERS);
        for (Member member : members) {
            final JSONObject jsonMember = JSONFactoryUtil.createJSONObject();
            jsonMember.put("userId", member.getId_());
            jsonMember.put("screenName", member.getScreenName());
            jsonMember.put("firstName", member.getFirstName());
            jsonMember.put("lastName", member.getLastName());
            jsonMembers.put(jsonMember);
        }
        response.getPortletOutputStream().write(jsonMembers.toString().getBytes());
    }
}
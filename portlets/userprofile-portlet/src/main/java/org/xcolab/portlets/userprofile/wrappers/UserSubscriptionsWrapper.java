package org.xcolab.portlets.userprofile.wrappers;

import com.ext.portlet.Activity.SubscriptionType;
import com.ext.portlet.model.ActivitySubscription;
import com.ext.portlet.service.ActivitySubscriptionLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import org.xcolab.client.members.pojo.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserSubscriptionsWrapper implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Member user;
    private List<ActivitySubscriptionWrapper> subscriptions;
    private SubscriptionType typeFilter;

    public UserSubscriptionsWrapper() {
    }

    public UserSubscriptionsWrapper(Member user) throws SystemException {
        this.user = user;
        getSubscriptions();
    }

    public List<ActivitySubscriptionWrapper> getSubscriptions() {
        if (subscriptions == null) {
            try {
                subscriptions = new ArrayList<>();

                for (ActivitySubscription subscription : ActivitySubscriptionLocalServiceUtil
                        .findByUser(user.getId_())) {

                    if (typeFilter == null || typeFilter == SubscriptionType.getSubscriptionType(subscription)) {
                        subscriptions.add(new ActivitySubscriptionWrapper(subscription));
                    }
                }
            } catch (SystemException e) {
                System.out.println("Could not get activity subscriptions");
            }
        }
        return subscriptions;
    }

    public void setFilterType(String filterType) {
        if (filterType.equals("null")) {
            typeFilter = null;
        } else {
            typeFilter = SubscriptionType.valueOf(filterType);
        }
        subscriptions = null;
        getSubscriptions();
    }

    public int getSubscriptionsCount() {
        return getSubscriptions().size();
    }

    public SubscriptionType getTypeFilter() {
        return typeFilter;
    }

    public String getTypeFilterName() {
        return typeFilter != null ? typeFilter.name() : null;
    }
}

package com.ext.portlet.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.ext.portlet.Activity.ActivitySubscriptionNameGeneratorServiceUtil;
import com.ext.portlet.Activity.SubscriptionType;
import com.ext.portlet.messaging.MessageUtil;
import com.ext.portlet.model.ActivitySubscription;
import com.ext.portlet.service.ActivitySubscriptionLocalServiceUtil;
import com.ext.portlet.service.base.ActivitySubscriptionLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityFeedEntry;
import com.liferay.portlet.social.service.SocialActivityInterpreterLocalServiceUtil;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

/**
 * The implementation of the activity subscription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.service.ActivitySubscriptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.service.base.ActivitySubscriptionLocalServiceBaseImpl
 * @see com.ext.portlet.service.ActivitySubscriptionLocalServiceUtil
 */
public class ActivitySubscriptionLocalServiceImpl
    extends ActivitySubscriptionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ext.portlet.service.ActivitySubscriptionLocalServiceUtil} to access the activity subscription local service.
     */
    
    private Date lastEmailNotification = new Date();
    private final static String PROPERTY_CREATE_DATE = "createDate";

    private final static Log _log = LogFactoryUtil.getLog(ActivitySubscriptionLocalServiceImpl.class);
    private final static long DEFAULT_COMPANY_ID = 10112L;
    

    public List<ActivitySubscription>  getActivitySubscriptions(Class clasz, Long classPK, Integer type, String extraData)
            throws PortalException, SystemException {
        return activitySubscriptionPersistence.findByClassNameIdClassPKTypeExtraData(PortalUtil.getClassNameId(clasz), classPK, type, extraData);
    }
    
    public List<ActivitySubscription> findByUser(Long userId) throws SystemException {
        return activitySubscriptionPersistence.findByreceiverId(userId);
    }

    public boolean isSubscribed(Long userId, Long classNameId, Long classPK, Integer type, String extraData)
            throws PortalException, SystemException {
        List<ActivitySubscription> ret = activitySubscriptionPersistence.findByClassNameIdClassPKTypeExtraDataReceiverId(classNameId, classPK,
                type, extraData, userId);
        return ret != null && !ret.isEmpty(); 
    }
    
    public boolean isSubscribed(Long userId, Class clasz, Long classPK, Integer type, String extraData)
    throws PortalException, SystemException {
        return isSubscribed(userId, PortalUtil.getClassNameId(clasz), classPK, type, extraData);
    }
    
    public void deleteSubscription(Long userId, Long classNameId, Long classPK, Integer type, String extraData) throws SystemException {
        List<ActivitySubscription> subscriptions = 
            activitySubscriptionPersistence.findByClassNameIdClassPKTypeExtraDataReceiverId(classNameId, classPK, type, extraData, userId);
        for (ActivitySubscription subscription: subscriptions) {
            delete(subscription);
        }
        
    }
    
    public void deleteSubscription(Long userId, Class clasz, Long classPK, Integer type, String extraData) throws SystemException {
        deleteSubscription(userId, PortalUtil.getClassNameId(clasz), classPK, type, extraData);
    }

    public void addSubscription(Long classNameId, Long classPK, Integer type, String extraData, Long userId)
            throws PortalException, SystemException {

        if (activitySubscriptionPersistence.findByClassNameIdClassPKTypeExtraDataReceiverId(classNameId, classPK, type,
                extraData, userId).size() > 0) {
            // subscription exists, do nothing
            return;
        }

        Long pk = CounterLocalServiceUtil.increment(ActivitySubscription.class.getName());
        ActivitySubscription subscription = ActivitySubscriptionLocalServiceUtil.createActivitySubscription(pk);

        subscription.setClassNameId(classNameId);
        subscription.setClassPK(classPK);
        subscription.setType(type);
        subscription.setExtraData(extraData);
        subscription.setReceiverId(userId);

        subscription.setModifiedDate(new Date());
        subscription.setCreateDate(new Date());

        store(subscription);
    }

    public void addSubscription(Class clasz, Long classPK, Integer type, String extraData, Long userId)
            throws PortalException, SystemException {
        Long classNameId = ClassNameLocalServiceUtil.getClassNameId(clasz);
        addSubscription(classNameId, classPK, type, extraData, userId);
    }


    public List<SocialActivity> getActivities(Long userId, int start, int count) throws SystemException {
        List<ActivitySubscription> subscriptions = null;
        // for now no activity selection is made, TODO
        subscriptions = activitySubscriptionPersistence.findByreceiverId(userId);

        if (subscriptions.size() == 0) {
            return new ArrayList<SocialActivity>();
        }

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(SocialActivity.class);
        Criterion crit = null;
        
        for (ActivitySubscription sub : subscriptions) {
            //Map<String, Number> criterion = new HashMap<String, Number>();
            Criterion criterion = RestrictionsFactoryUtil.eq("classNameId", sub.getClassNameId());
            if (sub.getClassPK() <= 0) {
                RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("classPk", sub.getClassPK()));
            }
            if (sub.getType() >= 0) {
                RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("type", sub.getType()));
            }
            
            if (sub.getExtraData() != null && sub.getExtraData().length() > 0) {
                criterion = RestrictionsFactoryUtil.and(criterion,
                        RestrictionsFactoryUtil.ilike("extraData", sub.getExtraData() + "%"));
            }

            if (crit == null) {
                crit = criterion;
            } else {
                crit = RestrictionsFactoryUtil.or(crit, criterion);
            }
        }
        query.add(crit).addOrder(OrderFactoryUtil.desc("createDate"));

        List<SocialActivity> activities = new ArrayList<SocialActivity>();
        List<Object> queryResults = SocialActivityLocalServiceUtil.dynamicQuery(query, start, start + count - 1);

        for (Object activity : queryResults) {
            activities.add((SocialActivity) activity);
        }

        return activities;

    }

    
    

    public void store(ActivitySubscription activitySubscription) throws SystemException {
        if (activitySubscription.isNew()) {
            ActivitySubscriptionLocalServiceUtil.addActivitySubscription(activitySubscription);
        }
        else {
            ActivitySubscriptionLocalServiceUtil.updateActivitySubscription(activitySubscription);
        }
    }

    
    public String getName(ActivitySubscription activitySubscription) {
        return ActivitySubscriptionNameGeneratorServiceUtil.getName(activitySubscription);
    }
    
    public SubscriptionType getSubscriptionType(ActivitySubscription activitySubscription) {
        return SubscriptionType.getSubscriptionType(activitySubscription);
    }
    
    
    public void delete(ActivitySubscription activitySubscription) throws SystemException {
        ActivitySubscriptionLocalServiceUtil.deleteActivitySubscription(activitySubscription);
    }
    
    
    
    public void sendEmailNotifications() throws SystemException, PortalException {
        synchronized (lastEmailNotification) {
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialActivity.class);
            Criterion criterionCreateDate = RestrictionsFactoryUtil.gt(PROPERTY_CREATE_DATE, lastEmailNotification.getTime());

            dynamicQuery.add(criterionCreateDate);
            List<Object> result = SocialActivityLocalServiceUtil.dynamicQuery(dynamicQuery);
            
            
            for (Object activityObj: result) {
                SocialActivity activity = (SocialActivity) activityObj;
                sendNotifications(activity);
            }
            lastEmailNotification = new Date();
        }
    }
    
    private final String MESSAGE_FOOTER_TEMPLATE = "<br /><br />\n<hr /><br />\n"
            + "To configure your notification preferences, visit your <a href=\"USER_PROFILE_LINK\">profile</a> page";

    private final String USER_PROFILE_LINK_PLACEHOLDER = "USER_PROFILE_LINK";

    private final String USER_PROFILE_LINK_TEMPLATE = "http://climatecolab.org/web/guest/member/-/member/userId/USER_ID";

    private final String USER_ID_PLACEHOLDER = "USER_ID";
    
    private void sendNotifications(SocialActivity activity) throws SystemException, PortalException {
        try {
            DynamicQuery query = DynamicQueryFactoryUtil.forClass(ActivitySubscription.class);
            Criterion criterionClassNameId = RestrictionsFactoryUtil.eq("classNameId", activity.getClassNameId());
            Criterion criterionClassPK = RestrictionsFactoryUtil.eq("classPK", activity.getClassPK());
            query.add(RestrictionsFactoryUtil.and(criterionClassNameId, criterionClassPK));
            ThemeDisplay td = new ThemeDisplay();
            td.setCompany(CompanyLocalServiceUtil.getCompany(DEFAULT_COMPANY_ID));

            SocialActivityFeedEntry entry = SocialActivityInterpreterLocalServiceUtil.interpret(activity, td);
            if (entry == null) {
                return;
            }
            try {
                InternetAddress fromEmail = new InternetAddress("no-reply@climatecolab.org");

                String subject = getMailSubject(entry);
                String messageTemplate = getMailBody(entry) + MESSAGE_FOOTER_TEMPLATE;

                messageTemplate = messageTemplate.replaceAll("\"/web/guest", "\"http://climatecolab.org/web/guest")
                        .replaceAll("'/web/guest", "'http://climatecolab.org/web/guest").replaceAll("\n", "\n<br />");
                Set<User> receipients = new HashSet<User>();

                for (Object subscriptionObj : ActivitySubscriptionLocalServiceUtil.dynamicQuery(query)) {
                    ActivitySubscription subscription = (ActivitySubscription) subscriptionObj;

                    if (subscription.getReceiverId() == activity.getUserId()) {
                        continue;
                    }
                    receipients.add(UserLocalServiceUtil.getUser(subscription.getReceiverId()));
                }
                for (User receipient : receipients) {

                    if (MessageUtil.getMessagingPreferences(receipient.getUserId()).getEmailOnActivity()) {
                        InternetAddress toEmail = new InternetAddress(receipient.getEmailAddress());
                        String message = messageTemplate
                                .replace(USER_PROFILE_LINK_PLACEHOLDER, getUserLink(receipient));
                        MailEngine.send(fromEmail, toEmail, subject, message, true);
                    }

                }
            } catch (MailEngineException e) {
                _log.error("Can't send email message");
                _log.debug("Can't send email message", e);
            } catch (AddressException e) {
                _log.error("Can't send email message");
                _log.debug("Can't send email message", e);
            }
        } catch (Throwable e) {
            _log.error("Can't send email motifications to users");
            _log.debug("Can't send email message", e);
        }

    }
    private String getMailBody(SocialActivityFeedEntry entry) {
        try {
            return (String) entry.getClass().getMethod("getMailBody").invoke(entry);
        } catch (NoSuchMethodException e) {
            // ignore
        } catch (IllegalArgumentException e) {
            _log.error(e);
        } catch (SecurityException e) {
            _log.error(e);
        } catch (IllegalAccessException e) {
            _log.error(e);
        } catch (InvocationTargetException e) {
            _log.error(e);
        }
        if (entry.getBody() != null) {
            return entry.getBody();
        }
        return entry.getTitle();

    }

    private String getMailSubject(SocialActivityFeedEntry entry) {
        try {
            return (String) entry.getClass().getMethod("getMailSubject").invoke(entry);
        } catch (NoSuchMethodException e) {
            // ignore
        } catch (IllegalArgumentException e) {
            _log.error(e);
        } catch (SecurityException e) {
            _log.error(e);
        } catch (IllegalAccessException e) {
            _log.error(e);
        } catch (InvocationTargetException e) {
            _log.error(e);
        }
        if (entry.getTitle() != null) {
            return entry.getTitle();
        }

        return entry.getBody();
    }

    private String getUserLink(User user) {
        return USER_PROFILE_LINK_TEMPLATE.replaceAll(USER_ID_PLACEHOLDER, String.valueOf(user.getUserId()));
    }

}
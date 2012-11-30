package com.ext.portlet.messaging.service.base;

import com.ext.portlet.messaging.model.MessagingUserPreferences;
import com.ext.portlet.messaging.service.MessageLocalService;
import com.ext.portlet.messaging.service.MessageRecipientStatusLocalService;
import com.ext.portlet.messaging.service.MessageRecipientStatusService;
import com.ext.portlet.messaging.service.MessageService;
import com.ext.portlet.messaging.service.MessagingUserPreferencesLocalService;
import com.ext.portlet.messaging.service.MessagingUserPreferencesService;
import com.ext.portlet.messaging.service.persistence.MessagePersistence;
import com.ext.portlet.messaging.service.persistence.MessageRecipientStatusPersistence;
import com.ext.portlet.messaging.service.persistence.MessagingUserPreferencesPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the messaging user preferences local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ext.portlet.messaging.service.impl.MessagingUserPreferencesLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.messaging.service.impl.MessagingUserPreferencesLocalServiceImpl
 * @see com.ext.portlet.messaging.service.MessagingUserPreferencesLocalServiceUtil
 * @generated
 */
public abstract class MessagingUserPreferencesLocalServiceBaseImpl
    implements MessagingUserPreferencesLocalService, IdentifiableBean {
    private static Log _log = LogFactoryUtil.getLog(MessagingUserPreferencesLocalServiceBaseImpl.class);
    @BeanReference(type = MessageLocalService.class)
    protected MessageLocalService messageLocalService;
    @BeanReference(type = MessageService.class)
    protected MessageService messageService;
    @BeanReference(type = MessagePersistence.class)
    protected MessagePersistence messagePersistence;
    @BeanReference(type = MessageRecipientStatusLocalService.class)
    protected MessageRecipientStatusLocalService messageRecipientStatusLocalService;
    @BeanReference(type = MessageRecipientStatusService.class)
    protected MessageRecipientStatusService messageRecipientStatusService;
    @BeanReference(type = MessageRecipientStatusPersistence.class)
    protected MessageRecipientStatusPersistence messageRecipientStatusPersistence;
    @BeanReference(type = MessagingUserPreferencesLocalService.class)
    protected MessagingUserPreferencesLocalService messagingUserPreferencesLocalService;
    @BeanReference(type = MessagingUserPreferencesService.class)
    protected MessagingUserPreferencesService messagingUserPreferencesService;
    @BeanReference(type = MessagingUserPreferencesPersistence.class)
    protected MessagingUserPreferencesPersistence messagingUserPreferencesPersistence;
    @BeanReference(type = CounterLocalService.class)
    protected CounterLocalService counterLocalService;
    @BeanReference(type = ResourceLocalService.class)
    protected ResourceLocalService resourceLocalService;
    @BeanReference(type = ResourceService.class)
    protected ResourceService resourceService;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserLocalService.class)
    protected UserLocalService userLocalService;
    @BeanReference(type = UserService.class)
    protected UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.ext.portlet.messaging.service.MessagingUserPreferencesLocalServiceUtil} to access the messaging user preferences local service.
     */

    /**
     * Adds the messaging user preferences to the database. Also notifies the appropriate model listeners.
     *
     * @param messagingUserPreferences the messaging user preferences
     * @return the messaging user preferences that was added
     * @throws SystemException if a system exception occurred
     */
    public MessagingUserPreferences addMessagingUserPreferences(
        MessagingUserPreferences messagingUserPreferences)
        throws SystemException {
        messagingUserPreferences.setNew(true);

        messagingUserPreferences = messagingUserPreferencesPersistence.update(messagingUserPreferences,
                false);

        Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

        if (indexer != null) {
            try {
                indexer.reindex(messagingUserPreferences);
            } catch (SearchException se) {
                if (_log.isWarnEnabled()) {
                    _log.warn(se, se);
                }
            }
        }

        return messagingUserPreferences;
    }

    /**
     * Creates a new messaging user preferences with the primary key. Does not add the messaging user preferences to the database.
     *
     * @param messagingPreferencesId the primary key for the new messaging user preferences
     * @return the new messaging user preferences
     */
    public MessagingUserPreferences createMessagingUserPreferences(
        Long messagingPreferencesId) {
        return messagingUserPreferencesPersistence.create(messagingPreferencesId);
    }

    /**
     * Deletes the messaging user preferences with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param messagingPreferencesId the primary key of the messaging user preferences
     * @throws PortalException if a messaging user preferences with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public void deleteMessagingUserPreferences(Long messagingPreferencesId)
        throws PortalException, SystemException {
        MessagingUserPreferences messagingUserPreferences = messagingUserPreferencesPersistence.remove(messagingPreferencesId);

        Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

        if (indexer != null) {
            try {
                indexer.delete(messagingUserPreferences);
            } catch (SearchException se) {
                if (_log.isWarnEnabled()) {
                    _log.warn(se, se);
                }
            }
        }
    }

    /**
     * Deletes the messaging user preferences from the database. Also notifies the appropriate model listeners.
     *
     * @param messagingUserPreferences the messaging user preferences
     * @throws SystemException if a system exception occurred
     */
    public void deleteMessagingUserPreferences(
        MessagingUserPreferences messagingUserPreferences)
        throws SystemException {
        messagingUserPreferencesPersistence.remove(messagingUserPreferences);

        Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

        if (indexer != null) {
            try {
                indexer.delete(messagingUserPreferences);
            } catch (SearchException se) {
                if (_log.isWarnEnabled()) {
                    _log.warn(se, se);
                }
            }
        }
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return messagingUserPreferencesPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return messagingUserPreferencesPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return messagingUserPreferencesPersistence.findWithDynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return messagingUserPreferencesPersistence.countWithDynamicQuery(dynamicQuery);
    }

    public MessagingUserPreferences fetchMessagingUserPreferences(
        Long messagingPreferencesId) throws SystemException {
        return messagingUserPreferencesPersistence.fetchByPrimaryKey(messagingPreferencesId);
    }

    /**
     * Returns the messaging user preferences with the primary key.
     *
     * @param messagingPreferencesId the primary key of the messaging user preferences
     * @return the messaging user preferences
     * @throws PortalException if a messaging user preferences with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public MessagingUserPreferences getMessagingUserPreferences(
        Long messagingPreferencesId) throws PortalException, SystemException {
        return messagingUserPreferencesPersistence.findByPrimaryKey(messagingPreferencesId);
    }

    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return messagingUserPreferencesPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the messaging user preferenceses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of messaging user preferenceses
     * @param end the upper bound of the range of messaging user preferenceses (not inclusive)
     * @return the range of messaging user preferenceses
     * @throws SystemException if a system exception occurred
     */
    public List<MessagingUserPreferences> getMessagingUserPreferenceses(
        int start, int end) throws SystemException {
        return messagingUserPreferencesPersistence.findAll(start, end);
    }

    /**
     * Returns the number of messaging user preferenceses.
     *
     * @return the number of messaging user preferenceses
     * @throws SystemException if a system exception occurred
     */
    public int getMessagingUserPreferencesesCount() throws SystemException {
        return messagingUserPreferencesPersistence.countAll();
    }

    /**
     * Updates the messaging user preferences in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param messagingUserPreferences the messaging user preferences
     * @return the messaging user preferences that was updated
     * @throws SystemException if a system exception occurred
     */
    public MessagingUserPreferences updateMessagingUserPreferences(
        MessagingUserPreferences messagingUserPreferences)
        throws SystemException {
        return updateMessagingUserPreferences(messagingUserPreferences, true);
    }

    /**
     * Updates the messaging user preferences in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param messagingUserPreferences the messaging user preferences
     * @param merge whether to merge the messaging user preferences with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
     * @return the messaging user preferences that was updated
     * @throws SystemException if a system exception occurred
     */
    public MessagingUserPreferences updateMessagingUserPreferences(
        MessagingUserPreferences messagingUserPreferences, boolean merge)
        throws SystemException {
        messagingUserPreferences.setNew(false);

        messagingUserPreferences = messagingUserPreferencesPersistence.update(messagingUserPreferences,
                merge);

        Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

        if (indexer != null) {
            try {
                indexer.reindex(messagingUserPreferences);
            } catch (SearchException se) {
                if (_log.isWarnEnabled()) {
                    _log.warn(se, se);
                }
            }
        }

        return messagingUserPreferences;
    }

    /**
     * Returns the message local service.
     *
     * @return the message local service
     */
    public MessageLocalService getMessageLocalService() {
        return messageLocalService;
    }

    /**
     * Sets the message local service.
     *
     * @param messageLocalService the message local service
     */
    public void setMessageLocalService(MessageLocalService messageLocalService) {
        this.messageLocalService = messageLocalService;
    }

    /**
     * Returns the message remote service.
     *
     * @return the message remote service
     */
    public MessageService getMessageService() {
        return messageService;
    }

    /**
     * Sets the message remote service.
     *
     * @param messageService the message remote service
     */
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Returns the message persistence.
     *
     * @return the message persistence
     */
    public MessagePersistence getMessagePersistence() {
        return messagePersistence;
    }

    /**
     * Sets the message persistence.
     *
     * @param messagePersistence the message persistence
     */
    public void setMessagePersistence(MessagePersistence messagePersistence) {
        this.messagePersistence = messagePersistence;
    }

    /**
     * Returns the message recipient status local service.
     *
     * @return the message recipient status local service
     */
    public MessageRecipientStatusLocalService getMessageRecipientStatusLocalService() {
        return messageRecipientStatusLocalService;
    }

    /**
     * Sets the message recipient status local service.
     *
     * @param messageRecipientStatusLocalService the message recipient status local service
     */
    public void setMessageRecipientStatusLocalService(
        MessageRecipientStatusLocalService messageRecipientStatusLocalService) {
        this.messageRecipientStatusLocalService = messageRecipientStatusLocalService;
    }

    /**
     * Returns the message recipient status remote service.
     *
     * @return the message recipient status remote service
     */
    public MessageRecipientStatusService getMessageRecipientStatusService() {
        return messageRecipientStatusService;
    }

    /**
     * Sets the message recipient status remote service.
     *
     * @param messageRecipientStatusService the message recipient status remote service
     */
    public void setMessageRecipientStatusService(
        MessageRecipientStatusService messageRecipientStatusService) {
        this.messageRecipientStatusService = messageRecipientStatusService;
    }

    /**
     * Returns the message recipient status persistence.
     *
     * @return the message recipient status persistence
     */
    public MessageRecipientStatusPersistence getMessageRecipientStatusPersistence() {
        return messageRecipientStatusPersistence;
    }

    /**
     * Sets the message recipient status persistence.
     *
     * @param messageRecipientStatusPersistence the message recipient status persistence
     */
    public void setMessageRecipientStatusPersistence(
        MessageRecipientStatusPersistence messageRecipientStatusPersistence) {
        this.messageRecipientStatusPersistence = messageRecipientStatusPersistence;
    }

    /**
     * Returns the messaging user preferences local service.
     *
     * @return the messaging user preferences local service
     */
    public MessagingUserPreferencesLocalService getMessagingUserPreferencesLocalService() {
        return messagingUserPreferencesLocalService;
    }

    /**
     * Sets the messaging user preferences local service.
     *
     * @param messagingUserPreferencesLocalService the messaging user preferences local service
     */
    public void setMessagingUserPreferencesLocalService(
        MessagingUserPreferencesLocalService messagingUserPreferencesLocalService) {
        this.messagingUserPreferencesLocalService = messagingUserPreferencesLocalService;
    }

    /**
     * Returns the messaging user preferences remote service.
     *
     * @return the messaging user preferences remote service
     */
    public MessagingUserPreferencesService getMessagingUserPreferencesService() {
        return messagingUserPreferencesService;
    }

    /**
     * Sets the messaging user preferences remote service.
     *
     * @param messagingUserPreferencesService the messaging user preferences remote service
     */
    public void setMessagingUserPreferencesService(
        MessagingUserPreferencesService messagingUserPreferencesService) {
        this.messagingUserPreferencesService = messagingUserPreferencesService;
    }

    /**
     * Returns the messaging user preferences persistence.
     *
     * @return the messaging user preferences persistence
     */
    public MessagingUserPreferencesPersistence getMessagingUserPreferencesPersistence() {
        return messagingUserPreferencesPersistence;
    }

    /**
     * Sets the messaging user preferences persistence.
     *
     * @param messagingUserPreferencesPersistence the messaging user preferences persistence
     */
    public void setMessagingUserPreferencesPersistence(
        MessagingUserPreferencesPersistence messagingUserPreferencesPersistence) {
        this.messagingUserPreferencesPersistence = messagingUserPreferencesPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the resource remote service.
     *
     * @return the resource remote service
     */
    public ResourceService getResourceService() {
        return resourceService;
    }

    /**
     * Sets the resource remote service.
     *
     * @param resourceService the resource remote service
     */
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * Returns the resource persistence.
     *
     * @return the resource persistence
     */
    public ResourcePersistence getResourcePersistence() {
        return resourcePersistence;
    }

    /**
     * Sets the resource persistence.
     *
     * @param resourcePersistence the resource persistence
     */
    public void setResourcePersistence(ResourcePersistence resourcePersistence) {
        this.resourcePersistence = resourcePersistence;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        PersistedModelLocalServiceRegistryUtil.register("com.ext.portlet.messaging.model.MessagingUserPreferences",
            messagingUserPreferencesLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.ext.portlet.messaging.model.MessagingUserPreferences");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    protected Class<?> getModelClass() {
        return MessagingUserPreferences.class;
    }

    protected String getModelClassName() {
        return MessagingUserPreferences.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = messagingUserPreferencesPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}

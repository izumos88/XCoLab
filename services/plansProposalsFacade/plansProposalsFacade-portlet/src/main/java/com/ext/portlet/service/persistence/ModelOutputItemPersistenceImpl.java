package com.ext.portlet.service.persistence;

import com.ext.portlet.NoSuchModelOutputItemException;
import com.ext.portlet.model.ModelOutputItem;
import com.ext.portlet.model.impl.ModelOutputItemImpl;
import com.ext.portlet.model.impl.ModelOutputItemModelImpl;
import com.ext.portlet.service.persistence.ModelOutputItemPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the model output item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelOutputItemPersistence
 * @see ModelOutputItemUtil
 * @generated
 */
public class ModelOutputItemPersistenceImpl extends BasePersistenceImpl<ModelOutputItem>
    implements ModelOutputItemPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ModelOutputItemUtil} to access the model output item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ModelOutputItemImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelOutputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelOutputItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelOutputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelOutputItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelOutputItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_MODELOUTPUTID = new FinderPath(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelOutputItemModelImpl.FINDER_CACHE_ENABLED,
            ModelOutputItemImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByModelOutputId", new String[] { Long.class.getName() },
            ModelOutputItemModelImpl.MODELOUTPUTITEMID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MODELOUTPUTID = new FinderPath(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelOutputItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModelOutputId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_MODELOUTPUTID_MODELOUTPUTITEMID_2 =
        "modelOutputItem.modelOutputItemId = ?";
    private static final String _SQL_SELECT_MODELOUTPUTITEM = "SELECT modelOutputItem FROM ModelOutputItem modelOutputItem";
    private static final String _SQL_SELECT_MODELOUTPUTITEM_WHERE = "SELECT modelOutputItem FROM ModelOutputItem modelOutputItem WHERE ";
    private static final String _SQL_COUNT_MODELOUTPUTITEM = "SELECT COUNT(modelOutputItem) FROM ModelOutputItem modelOutputItem";
    private static final String _SQL_COUNT_MODELOUTPUTITEM_WHERE = "SELECT COUNT(modelOutputItem) FROM ModelOutputItem modelOutputItem WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "modelOutputItem.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ModelOutputItem exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ModelOutputItem exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ModelOutputItemPersistenceImpl.class);
    private static ModelOutputItem _nullModelOutputItem = new ModelOutputItemImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ModelOutputItem> toCacheModel() {
                return _nullModelOutputItemCacheModel;
            }
        };

    private static CacheModel<ModelOutputItem> _nullModelOutputItemCacheModel = new CacheModel<ModelOutputItem>() {
            @Override
            public ModelOutputItem toEntityModel() {
                return _nullModelOutputItem;
            }
        };

    public ModelOutputItemPersistenceImpl() {
        setModelClass(ModelOutputItem.class);
    }

    /**
     * Returns the model output item where modelOutputItemId = &#63; or throws a {@link com.ext.portlet.NoSuchModelOutputItemException} if it could not be found.
     *
     * @param modelOutputItemId the model output item ID
     * @return the matching model output item
     * @throws com.ext.portlet.NoSuchModelOutputItemException if a matching model output item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelOutputItem findByModelOutputId(long modelOutputItemId)
        throws NoSuchModelOutputItemException, SystemException {
        ModelOutputItem modelOutputItem = fetchByModelOutputId(modelOutputItemId);

        if (modelOutputItem == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("modelOutputItemId=");
            msg.append(modelOutputItemId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchModelOutputItemException(msg.toString());
        }

        return modelOutputItem;
    }

    /**
     * Returns the model output item where modelOutputItemId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param modelOutputItemId the model output item ID
     * @return the matching model output item, or <code>null</code> if a matching model output item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelOutputItem fetchByModelOutputId(long modelOutputItemId)
        throws SystemException {
        return fetchByModelOutputId(modelOutputItemId, true);
    }

    /**
     * Returns the model output item where modelOutputItemId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param modelOutputItemId the model output item ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching model output item, or <code>null</code> if a matching model output item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelOutputItem fetchByModelOutputId(long modelOutputItemId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { modelOutputItemId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MODELOUTPUTID,
                    finderArgs, this);
        }

        if (result instanceof ModelOutputItem) {
            ModelOutputItem modelOutputItem = (ModelOutputItem) result;

            if ((modelOutputItemId != modelOutputItem.getModelOutputItemId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_MODELOUTPUTITEM_WHERE);

            query.append(_FINDER_COLUMN_MODELOUTPUTID_MODELOUTPUTITEMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(modelOutputItemId);

                List<ModelOutputItem> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELOUTPUTID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "ModelOutputItemPersistenceImpl.fetchByModelOutputId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    ModelOutputItem modelOutputItem = list.get(0);

                    result = modelOutputItem;

                    cacheResult(modelOutputItem);

                    if ((modelOutputItem.getModelOutputItemId() != modelOutputItemId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELOUTPUTID,
                            finderArgs, modelOutputItem);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODELOUTPUTID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ModelOutputItem) result;
        }
    }

    /**
     * Removes the model output item where modelOutputItemId = &#63; from the database.
     *
     * @param modelOutputItemId the model output item ID
     * @return the model output item that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelOutputItem removeByModelOutputId(long modelOutputItemId)
        throws NoSuchModelOutputItemException, SystemException {
        ModelOutputItem modelOutputItem = findByModelOutputId(modelOutputItemId);

        return remove(modelOutputItem);
    }

    /**
     * Returns the number of model output items where modelOutputItemId = &#63;.
     *
     * @param modelOutputItemId the model output item ID
     * @return the number of matching model output items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByModelOutputId(long modelOutputItemId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MODELOUTPUTID;

        Object[] finderArgs = new Object[] { modelOutputItemId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MODELOUTPUTITEM_WHERE);

            query.append(_FINDER_COLUMN_MODELOUTPUTID_MODELOUTPUTITEMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(modelOutputItemId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the model output item in the entity cache if it is enabled.
     *
     * @param modelOutputItem the model output item
     */
    @Override
    public void cacheResult(ModelOutputItem modelOutputItem) {
        EntityCacheUtil.putResult(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelOutputItemImpl.class, modelOutputItem.getPrimaryKey(),
            modelOutputItem);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELOUTPUTID,
            new Object[] { modelOutputItem.getModelOutputItemId() },
            modelOutputItem);

        modelOutputItem.resetOriginalValues();
    }

    /**
     * Caches the model output items in the entity cache if it is enabled.
     *
     * @param modelOutputItems the model output items
     */
    @Override
    public void cacheResult(List<ModelOutputItem> modelOutputItems) {
        for (ModelOutputItem modelOutputItem : modelOutputItems) {
            if (EntityCacheUtil.getResult(
                        ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
                        ModelOutputItemImpl.class,
                        modelOutputItem.getPrimaryKey()) == null) {
                cacheResult(modelOutputItem);
            } else {
                modelOutputItem.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all model output items.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ModelOutputItemImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ModelOutputItemImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the model output item.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ModelOutputItem modelOutputItem) {
        EntityCacheUtil.removeResult(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelOutputItemImpl.class, modelOutputItem.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(modelOutputItem);
    }

    @Override
    public void clearCache(List<ModelOutputItem> modelOutputItems) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ModelOutputItem modelOutputItem : modelOutputItems) {
            EntityCacheUtil.removeResult(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
                ModelOutputItemImpl.class, modelOutputItem.getPrimaryKey());

            clearUniqueFindersCache(modelOutputItem);
        }
    }

    protected void cacheUniqueFindersCache(ModelOutputItem modelOutputItem) {
        if (modelOutputItem.isNew()) {
            Object[] args = new Object[] { modelOutputItem.getModelOutputItemId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODELOUTPUTID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELOUTPUTID, args,
                modelOutputItem);
        } else {
            ModelOutputItemModelImpl modelOutputItemModelImpl = (ModelOutputItemModelImpl) modelOutputItem;

            if ((modelOutputItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_MODELOUTPUTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        modelOutputItem.getModelOutputItemId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODELOUTPUTID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODELOUTPUTID,
                    args, modelOutputItem);
            }
        }
    }

    protected void clearUniqueFindersCache(ModelOutputItem modelOutputItem) {
        ModelOutputItemModelImpl modelOutputItemModelImpl = (ModelOutputItemModelImpl) modelOutputItem;

        Object[] args = new Object[] { modelOutputItem.getModelOutputItemId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODELOUTPUTID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODELOUTPUTID, args);

        if ((modelOutputItemModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_MODELOUTPUTID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    modelOutputItemModelImpl.getOriginalModelOutputItemId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODELOUTPUTID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODELOUTPUTID,
                args);
        }
    }

    /**
     * Creates a new model output item with the primary key. Does not add the model output item to the database.
     *
     * @param modelOutputItemModifierPK the primary key for the new model output item
     * @return the new model output item
     */
    @Override
    public ModelOutputItem create(long modelOutputItemModifierPK) {
        ModelOutputItem modelOutputItem = new ModelOutputItemImpl();

        modelOutputItem.setNew(true);
        modelOutputItem.setPrimaryKey(modelOutputItemModifierPK);

        return modelOutputItem;
    }

    /**
     * Removes the model output item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param modelOutputItemModifierPK the primary key of the model output item
     * @return the model output item that was removed
     * @throws com.ext.portlet.NoSuchModelOutputItemException if a model output item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelOutputItem remove(long modelOutputItemModifierPK)
        throws NoSuchModelOutputItemException, SystemException {
        return remove((Serializable) modelOutputItemModifierPK);
    }

    /**
     * Removes the model output item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the model output item
     * @return the model output item that was removed
     * @throws com.ext.portlet.NoSuchModelOutputItemException if a model output item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelOutputItem remove(Serializable primaryKey)
        throws NoSuchModelOutputItemException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ModelOutputItem modelOutputItem = (ModelOutputItem) session.get(ModelOutputItemImpl.class,
                    primaryKey);

            if (modelOutputItem == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchModelOutputItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(modelOutputItem);
        } catch (NoSuchModelOutputItemException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ModelOutputItem removeImpl(ModelOutputItem modelOutputItem)
        throws SystemException {
        modelOutputItem = toUnwrappedModel(modelOutputItem);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(modelOutputItem)) {
                modelOutputItem = (ModelOutputItem) session.get(ModelOutputItemImpl.class,
                        modelOutputItem.getPrimaryKeyObj());
            }

            if (modelOutputItem != null) {
                session.delete(modelOutputItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (modelOutputItem != null) {
            clearCache(modelOutputItem);
        }

        return modelOutputItem;
    }

    @Override
    public ModelOutputItem updateImpl(
        com.ext.portlet.model.ModelOutputItem modelOutputItem)
        throws SystemException {
        modelOutputItem = toUnwrappedModel(modelOutputItem);

        boolean isNew = modelOutputItem.isNew();

        Session session = null;

        try {
            session = openSession();

            if (modelOutputItem.isNew()) {
                session.save(modelOutputItem);

                modelOutputItem.setNew(false);
            } else {
                session.merge(modelOutputItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ModelOutputItemModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
            ModelOutputItemImpl.class, modelOutputItem.getPrimaryKey(),
            modelOutputItem);

        clearUniqueFindersCache(modelOutputItem);
        cacheUniqueFindersCache(modelOutputItem);

        return modelOutputItem;
    }

    protected ModelOutputItem toUnwrappedModel(ModelOutputItem modelOutputItem) {
        if (modelOutputItem instanceof ModelOutputItemImpl) {
            return modelOutputItem;
        }

        ModelOutputItemImpl modelOutputItemImpl = new ModelOutputItemImpl();

        modelOutputItemImpl.setNew(modelOutputItem.isNew());
        modelOutputItemImpl.setPrimaryKey(modelOutputItem.getPrimaryKey());

        modelOutputItemImpl.setModelOutputItemModifierPK(modelOutputItem.getModelOutputItemModifierPK());
        modelOutputItemImpl.setModelId(modelOutputItem.getModelId());
        modelOutputItemImpl.setModelOutputItemId(modelOutputItem.getModelOutputItemId());
        modelOutputItemImpl.setModelOutputItemOrder(modelOutputItem.getModelOutputItemOrder());
        modelOutputItemImpl.setModelItemRangePolicy(modelOutputItem.getModelItemRangePolicy());
        modelOutputItemImpl.setModelItemRangeMessage(modelOutputItem.getModelItemRangeMessage());
        modelOutputItemImpl.setModelItemErrorPolicy(modelOutputItem.getModelItemErrorPolicy());
        modelOutputItemImpl.setModelItemErrorMessage(modelOutputItem.getModelItemErrorMessage());
        modelOutputItemImpl.setModelItemLabelFormat(modelOutputItem.getModelItemLabelFormat());
        modelOutputItemImpl.setModelItemIsVisible(modelOutputItem.isModelItemIsVisible());
        modelOutputItemImpl.setItemType(modelOutputItem.getItemType());
        modelOutputItemImpl.setRelatedOutputItem(modelOutputItem.getRelatedOutputItem());

        return modelOutputItemImpl;
    }

    /**
     * Returns the model output item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the model output item
     * @return the model output item
     * @throws com.ext.portlet.NoSuchModelOutputItemException if a model output item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelOutputItem findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelOutputItemException, SystemException {
        ModelOutputItem modelOutputItem = fetchByPrimaryKey(primaryKey);

        if (modelOutputItem == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchModelOutputItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return modelOutputItem;
    }

    /**
     * Returns the model output item with the primary key or throws a {@link com.ext.portlet.NoSuchModelOutputItemException} if it could not be found.
     *
     * @param modelOutputItemModifierPK the primary key of the model output item
     * @return the model output item
     * @throws com.ext.portlet.NoSuchModelOutputItemException if a model output item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelOutputItem findByPrimaryKey(long modelOutputItemModifierPK)
        throws NoSuchModelOutputItemException, SystemException {
        return findByPrimaryKey((Serializable) modelOutputItemModifierPK);
    }

    /**
     * Returns the model output item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the model output item
     * @return the model output item, or <code>null</code> if a model output item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelOutputItem fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ModelOutputItem modelOutputItem = (ModelOutputItem) EntityCacheUtil.getResult(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
                ModelOutputItemImpl.class, primaryKey);

        if (modelOutputItem == _nullModelOutputItem) {
            return null;
        }

        if (modelOutputItem == null) {
            Session session = null;

            try {
                session = openSession();

                modelOutputItem = (ModelOutputItem) session.get(ModelOutputItemImpl.class,
                        primaryKey);

                if (modelOutputItem != null) {
                    cacheResult(modelOutputItem);
                } else {
                    EntityCacheUtil.putResult(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
                        ModelOutputItemImpl.class, primaryKey,
                        _nullModelOutputItem);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ModelOutputItemModelImpl.ENTITY_CACHE_ENABLED,
                    ModelOutputItemImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return modelOutputItem;
    }

    /**
     * Returns the model output item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param modelOutputItemModifierPK the primary key of the model output item
     * @return the model output item, or <code>null</code> if a model output item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ModelOutputItem fetchByPrimaryKey(long modelOutputItemModifierPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) modelOutputItemModifierPK);
    }

    /**
     * Returns all the model output items.
     *
     * @return the model output items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelOutputItem> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the model output items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelOutputItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of model output items
     * @param end the upper bound of the range of model output items (not inclusive)
     * @return the range of model output items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelOutputItem> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the model output items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ModelOutputItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of model output items
     * @param end the upper bound of the range of model output items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of model output items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ModelOutputItem> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<ModelOutputItem> list = (List<ModelOutputItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MODELOUTPUTITEM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MODELOUTPUTITEM;

                if (pagination) {
                    sql = sql.concat(ModelOutputItemModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ModelOutputItem>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ModelOutputItem>(list);
                } else {
                    list = (List<ModelOutputItem>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the model output items from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ModelOutputItem modelOutputItem : findAll()) {
            remove(modelOutputItem);
        }
    }

    /**
     * Returns the number of model output items.
     *
     * @return the number of model output items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_MODELOUTPUTITEM);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the model output item persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.ext.portlet.model.ModelOutputItem")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ModelOutputItem>> listenersList = new ArrayList<ModelListener<ModelOutputItem>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ModelOutputItem>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ModelOutputItemImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

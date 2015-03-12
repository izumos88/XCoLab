package com.ext.portlet.service.persistence;

import com.ext.portlet.NoSuchImpactDefaultSeriesDataException;
import com.ext.portlet.model.ImpactDefaultSeriesData;
import com.ext.portlet.model.impl.ImpactDefaultSeriesDataImpl;
import com.ext.portlet.model.impl.ImpactDefaultSeriesDataModelImpl;
import com.ext.portlet.service.persistence.ImpactDefaultSeriesDataPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the impact default series data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImpactDefaultSeriesDataPersistence
 * @see ImpactDefaultSeriesDataUtil
 * @generated
 */
public class ImpactDefaultSeriesDataPersistenceImpl extends BasePersistenceImpl<ImpactDefaultSeriesData>
    implements ImpactDefaultSeriesDataPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ImpactDefaultSeriesDataUtil} to access the impact default series data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ImpactDefaultSeriesDataImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
            ImpactDefaultSeriesDataModelImpl.FINDER_CACHE_ENABLED,
            ImpactDefaultSeriesDataImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
            ImpactDefaultSeriesDataModelImpl.FINDER_CACHE_ENABLED,
            ImpactDefaultSeriesDataImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
            ImpactDefaultSeriesDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_IMPACTDEFAULTSERIESDATA = "SELECT impactDefaultSeriesData FROM ImpactDefaultSeriesData impactDefaultSeriesData";
    private static final String _SQL_COUNT_IMPACTDEFAULTSERIESDATA = "SELECT COUNT(impactDefaultSeriesData) FROM ImpactDefaultSeriesData impactDefaultSeriesData";
    private static final String _ORDER_BY_ENTITY_ALIAS = "impactDefaultSeriesData.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ImpactDefaultSeriesData exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ImpactDefaultSeriesDataPersistenceImpl.class);
    private static ImpactDefaultSeriesData _nullImpactDefaultSeriesData = new ImpactDefaultSeriesDataImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ImpactDefaultSeriesData> toCacheModel() {
                return _nullImpactDefaultSeriesDataCacheModel;
            }
        };

    private static CacheModel<ImpactDefaultSeriesData> _nullImpactDefaultSeriesDataCacheModel =
        new CacheModel<ImpactDefaultSeriesData>() {
            @Override
            public ImpactDefaultSeriesData toEntityModel() {
                return _nullImpactDefaultSeriesData;
            }
        };

    public ImpactDefaultSeriesDataPersistenceImpl() {
        setModelClass(ImpactDefaultSeriesData.class);
    }

    /**
     * Caches the impact default series data in the entity cache if it is enabled.
     *
     * @param impactDefaultSeriesData the impact default series data
     */
    @Override
    public void cacheResult(ImpactDefaultSeriesData impactDefaultSeriesData) {
        EntityCacheUtil.putResult(ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
            ImpactDefaultSeriesDataImpl.class,
            impactDefaultSeriesData.getPrimaryKey(), impactDefaultSeriesData);

        impactDefaultSeriesData.resetOriginalValues();
    }

    /**
     * Caches the impact default series datas in the entity cache if it is enabled.
     *
     * @param impactDefaultSeriesDatas the impact default series datas
     */
    @Override
    public void cacheResult(
        List<ImpactDefaultSeriesData> impactDefaultSeriesDatas) {
        for (ImpactDefaultSeriesData impactDefaultSeriesData : impactDefaultSeriesDatas) {
            if (EntityCacheUtil.getResult(
                        ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
                        ImpactDefaultSeriesDataImpl.class,
                        impactDefaultSeriesData.getPrimaryKey()) == null) {
                cacheResult(impactDefaultSeriesData);
            } else {
                impactDefaultSeriesData.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all impact default series datas.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ImpactDefaultSeriesDataImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ImpactDefaultSeriesDataImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the impact default series data.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ImpactDefaultSeriesData impactDefaultSeriesData) {
        EntityCacheUtil.removeResult(ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
            ImpactDefaultSeriesDataImpl.class,
            impactDefaultSeriesData.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<ImpactDefaultSeriesData> impactDefaultSeriesDatas) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ImpactDefaultSeriesData impactDefaultSeriesData : impactDefaultSeriesDatas) {
            EntityCacheUtil.removeResult(ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
                ImpactDefaultSeriesDataImpl.class,
                impactDefaultSeriesData.getPrimaryKey());
        }
    }

    /**
     * Creates a new impact default series data with the primary key. Does not add the impact default series data to the database.
     *
     * @param impactDefaultSeriesDataPK the primary key for the new impact default series data
     * @return the new impact default series data
     */
    @Override
    public ImpactDefaultSeriesData create(
        ImpactDefaultSeriesDataPK impactDefaultSeriesDataPK) {
        ImpactDefaultSeriesData impactDefaultSeriesData = new ImpactDefaultSeriesDataImpl();

        impactDefaultSeriesData.setNew(true);
        impactDefaultSeriesData.setPrimaryKey(impactDefaultSeriesDataPK);

        return impactDefaultSeriesData;
    }

    /**
     * Removes the impact default series data with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param impactDefaultSeriesDataPK the primary key of the impact default series data
     * @return the impact default series data that was removed
     * @throws com.ext.portlet.NoSuchImpactDefaultSeriesDataException if a impact default series data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ImpactDefaultSeriesData remove(
        ImpactDefaultSeriesDataPK impactDefaultSeriesDataPK)
        throws NoSuchImpactDefaultSeriesDataException, SystemException {
        return remove((Serializable) impactDefaultSeriesDataPK);
    }

    /**
     * Removes the impact default series data with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the impact default series data
     * @return the impact default series data that was removed
     * @throws com.ext.portlet.NoSuchImpactDefaultSeriesDataException if a impact default series data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ImpactDefaultSeriesData remove(Serializable primaryKey)
        throws NoSuchImpactDefaultSeriesDataException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ImpactDefaultSeriesData impactDefaultSeriesData = (ImpactDefaultSeriesData) session.get(ImpactDefaultSeriesDataImpl.class,
                    primaryKey);

            if (impactDefaultSeriesData == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchImpactDefaultSeriesDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(impactDefaultSeriesData);
        } catch (NoSuchImpactDefaultSeriesDataException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ImpactDefaultSeriesData removeImpl(
        ImpactDefaultSeriesData impactDefaultSeriesData)
        throws SystemException {
        impactDefaultSeriesData = toUnwrappedModel(impactDefaultSeriesData);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(impactDefaultSeriesData)) {
                impactDefaultSeriesData = (ImpactDefaultSeriesData) session.get(ImpactDefaultSeriesDataImpl.class,
                        impactDefaultSeriesData.getPrimaryKeyObj());
            }

            if (impactDefaultSeriesData != null) {
                session.delete(impactDefaultSeriesData);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (impactDefaultSeriesData != null) {
            clearCache(impactDefaultSeriesData);
        }

        return impactDefaultSeriesData;
    }

    @Override
    public ImpactDefaultSeriesData updateImpl(
        com.ext.portlet.model.ImpactDefaultSeriesData impactDefaultSeriesData)
        throws SystemException {
        impactDefaultSeriesData = toUnwrappedModel(impactDefaultSeriesData);

        boolean isNew = impactDefaultSeriesData.isNew();

        Session session = null;

        try {
            session = openSession();

            if (impactDefaultSeriesData.isNew()) {
                session.save(impactDefaultSeriesData);

                impactDefaultSeriesData.setNew(false);
            } else {
                session.merge(impactDefaultSeriesData);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
            ImpactDefaultSeriesDataImpl.class,
            impactDefaultSeriesData.getPrimaryKey(), impactDefaultSeriesData);

        return impactDefaultSeriesData;
    }

    protected ImpactDefaultSeriesData toUnwrappedModel(
        ImpactDefaultSeriesData impactDefaultSeriesData) {
        if (impactDefaultSeriesData instanceof ImpactDefaultSeriesDataImpl) {
            return impactDefaultSeriesData;
        }

        ImpactDefaultSeriesDataImpl impactDefaultSeriesDataImpl = new ImpactDefaultSeriesDataImpl();

        impactDefaultSeriesDataImpl.setNew(impactDefaultSeriesData.isNew());
        impactDefaultSeriesDataImpl.setPrimaryKey(impactDefaultSeriesData.getPrimaryKey());

        impactDefaultSeriesDataImpl.setSeriesId(impactDefaultSeriesData.getSeriesId());
        impactDefaultSeriesDataImpl.setYear(impactDefaultSeriesData.getYear());
        impactDefaultSeriesDataImpl.setValue(impactDefaultSeriesData.getValue());

        return impactDefaultSeriesDataImpl;
    }

    /**
     * Returns the impact default series data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the impact default series data
     * @return the impact default series data
     * @throws com.ext.portlet.NoSuchImpactDefaultSeriesDataException if a impact default series data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ImpactDefaultSeriesData findByPrimaryKey(Serializable primaryKey)
        throws NoSuchImpactDefaultSeriesDataException, SystemException {
        ImpactDefaultSeriesData impactDefaultSeriesData = fetchByPrimaryKey(primaryKey);

        if (impactDefaultSeriesData == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchImpactDefaultSeriesDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return impactDefaultSeriesData;
    }

    /**
     * Returns the impact default series data with the primary key or throws a {@link com.ext.portlet.NoSuchImpactDefaultSeriesDataException} if it could not be found.
     *
     * @param impactDefaultSeriesDataPK the primary key of the impact default series data
     * @return the impact default series data
     * @throws com.ext.portlet.NoSuchImpactDefaultSeriesDataException if a impact default series data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ImpactDefaultSeriesData findByPrimaryKey(
        ImpactDefaultSeriesDataPK impactDefaultSeriesDataPK)
        throws NoSuchImpactDefaultSeriesDataException, SystemException {
        return findByPrimaryKey((Serializable) impactDefaultSeriesDataPK);
    }

    /**
     * Returns the impact default series data with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the impact default series data
     * @return the impact default series data, or <code>null</code> if a impact default series data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ImpactDefaultSeriesData fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ImpactDefaultSeriesData impactDefaultSeriesData = (ImpactDefaultSeriesData) EntityCacheUtil.getResult(ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
                ImpactDefaultSeriesDataImpl.class, primaryKey);

        if (impactDefaultSeriesData == _nullImpactDefaultSeriesData) {
            return null;
        }

        if (impactDefaultSeriesData == null) {
            Session session = null;

            try {
                session = openSession();

                impactDefaultSeriesData = (ImpactDefaultSeriesData) session.get(ImpactDefaultSeriesDataImpl.class,
                        primaryKey);

                if (impactDefaultSeriesData != null) {
                    cacheResult(impactDefaultSeriesData);
                } else {
                    EntityCacheUtil.putResult(ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
                        ImpactDefaultSeriesDataImpl.class, primaryKey,
                        _nullImpactDefaultSeriesData);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ImpactDefaultSeriesDataModelImpl.ENTITY_CACHE_ENABLED,
                    ImpactDefaultSeriesDataImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return impactDefaultSeriesData;
    }

    /**
     * Returns the impact default series data with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param impactDefaultSeriesDataPK the primary key of the impact default series data
     * @return the impact default series data, or <code>null</code> if a impact default series data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ImpactDefaultSeriesData fetchByPrimaryKey(
        ImpactDefaultSeriesDataPK impactDefaultSeriesDataPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) impactDefaultSeriesDataPK);
    }

    /**
     * Returns all the impact default series datas.
     *
     * @return the impact default series datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ImpactDefaultSeriesData> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the impact default series datas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ImpactDefaultSeriesDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of impact default series datas
     * @param end the upper bound of the range of impact default series datas (not inclusive)
     * @return the range of impact default series datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ImpactDefaultSeriesData> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the impact default series datas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ImpactDefaultSeriesDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of impact default series datas
     * @param end the upper bound of the range of impact default series datas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of impact default series datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ImpactDefaultSeriesData> findAll(int start, int end,
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

        List<ImpactDefaultSeriesData> list = (List<ImpactDefaultSeriesData>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_IMPACTDEFAULTSERIESDATA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_IMPACTDEFAULTSERIESDATA;

                if (pagination) {
                    sql = sql.concat(ImpactDefaultSeriesDataModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ImpactDefaultSeriesData>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ImpactDefaultSeriesData>(list);
                } else {
                    list = (List<ImpactDefaultSeriesData>) QueryUtil.list(q,
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
     * Removes all the impact default series datas from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ImpactDefaultSeriesData impactDefaultSeriesData : findAll()) {
            remove(impactDefaultSeriesData);
        }
    }

    /**
     * Returns the number of impact default series datas.
     *
     * @return the number of impact default series datas
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

                Query q = session.createQuery(_SQL_COUNT_IMPACTDEFAULTSERIESDATA);

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
     * Initializes the impact default series data persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.ext.portlet.model.ImpactDefaultSeriesData")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ImpactDefaultSeriesData>> listenersList = new ArrayList<ModelListener<ImpactDefaultSeriesData>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ImpactDefaultSeriesData>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ImpactDefaultSeriesDataImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

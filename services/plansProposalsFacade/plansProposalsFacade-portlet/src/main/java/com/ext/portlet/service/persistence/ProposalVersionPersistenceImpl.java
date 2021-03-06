package com.ext.portlet.service.persistence;

import com.ext.portlet.NoSuchProposalVersionException;
import com.ext.portlet.model.ProposalVersion;
import com.ext.portlet.model.impl.ProposalVersionImpl;
import com.ext.portlet.model.impl.ProposalVersionModelImpl;
import com.ext.portlet.service.persistence.ProposalVersionPersistence;

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
 * The persistence implementation for the proposal version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalVersionPersistence
 * @see ProposalVersionUtil
 * @generated
 */
public class ProposalVersionPersistenceImpl extends BasePersistenceImpl<ProposalVersion>
    implements ProposalVersionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ProposalVersionUtil} to access the proposal version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ProposalVersionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
            ProposalVersionModelImpl.FINDER_CACHE_ENABLED,
            ProposalVersionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
            ProposalVersionModelImpl.FINDER_CACHE_ENABLED,
            ProposalVersionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
            ProposalVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSALID =
        new FinderPath(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
            ProposalVersionModelImpl.FINDER_CACHE_ENABLED,
            ProposalVersionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByProposalId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID =
        new FinderPath(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
            ProposalVersionModelImpl.FINDER_CACHE_ENABLED,
            ProposalVersionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProposalId",
            new String[] { Long.class.getName() },
            ProposalVersionModelImpl.PROPOSALID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PROPOSALID = new FinderPath(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
            ProposalVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProposalId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PROPOSALID_PROPOSALID_2 = "proposalVersion.id.proposalId = ?";
    private static final String _SQL_SELECT_PROPOSALVERSION = "SELECT proposalVersion FROM ProposalVersion proposalVersion";
    private static final String _SQL_SELECT_PROPOSALVERSION_WHERE = "SELECT proposalVersion FROM ProposalVersion proposalVersion WHERE ";
    private static final String _SQL_COUNT_PROPOSALVERSION = "SELECT COUNT(proposalVersion) FROM ProposalVersion proposalVersion";
    private static final String _SQL_COUNT_PROPOSALVERSION_WHERE = "SELECT COUNT(proposalVersion) FROM ProposalVersion proposalVersion WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "proposalVersion.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProposalVersion exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProposalVersion exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ProposalVersionPersistenceImpl.class);
    private static ProposalVersion _nullProposalVersion = new ProposalVersionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ProposalVersion> toCacheModel() {
                return _nullProposalVersionCacheModel;
            }
        };

    private static CacheModel<ProposalVersion> _nullProposalVersionCacheModel = new CacheModel<ProposalVersion>() {
            @Override
            public ProposalVersion toEntityModel() {
                return _nullProposalVersion;
            }
        };

    public ProposalVersionPersistenceImpl() {
        setModelClass(ProposalVersion.class);
    }

    /**
     * Returns all the proposal versions where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @return the matching proposal versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ProposalVersion> findByProposalId(long proposalId)
        throws SystemException {
        return findByProposalId(proposalId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the proposal versions where proposalId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param proposalId the proposal ID
     * @param start the lower bound of the range of proposal versions
     * @param end the upper bound of the range of proposal versions (not inclusive)
     * @return the range of matching proposal versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ProposalVersion> findByProposalId(long proposalId, int start,
        int end) throws SystemException {
        return findByProposalId(proposalId, start, end, null);
    }

    /**
     * Returns an ordered range of all the proposal versions where proposalId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param proposalId the proposal ID
     * @param start the lower bound of the range of proposal versions
     * @param end the upper bound of the range of proposal versions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching proposal versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ProposalVersion> findByProposalId(long proposalId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID;
            finderArgs = new Object[] { proposalId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSALID;
            finderArgs = new Object[] { proposalId, start, end, orderByComparator };
        }

        List<ProposalVersion> list = (List<ProposalVersion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ProposalVersion proposalVersion : list) {
                if ((proposalId != proposalVersion.getProposalId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PROPOSALVERSION_WHERE);

            query.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ProposalVersionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(proposalId);

                if (!pagination) {
                    list = (List<ProposalVersion>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ProposalVersion>(list);
                } else {
                    list = (List<ProposalVersion>) QueryUtil.list(q,
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
     * Returns the first proposal version in the ordered set where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposal version
     * @throws com.ext.portlet.NoSuchProposalVersionException if a matching proposal version could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion findByProposalId_First(long proposalId,
        OrderByComparator orderByComparator)
        throws NoSuchProposalVersionException, SystemException {
        ProposalVersion proposalVersion = fetchByProposalId_First(proposalId,
                orderByComparator);

        if (proposalVersion != null) {
            return proposalVersion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("proposalId=");
        msg.append(proposalId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProposalVersionException(msg.toString());
    }

    /**
     * Returns the first proposal version in the ordered set where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposal version, or <code>null</code> if a matching proposal version could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion fetchByProposalId_First(long proposalId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ProposalVersion> list = findByProposalId(proposalId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last proposal version in the ordered set where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposal version
     * @throws com.ext.portlet.NoSuchProposalVersionException if a matching proposal version could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion findByProposalId_Last(long proposalId,
        OrderByComparator orderByComparator)
        throws NoSuchProposalVersionException, SystemException {
        ProposalVersion proposalVersion = fetchByProposalId_Last(proposalId,
                orderByComparator);

        if (proposalVersion != null) {
            return proposalVersion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("proposalId=");
        msg.append(proposalId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProposalVersionException(msg.toString());
    }

    /**
     * Returns the last proposal version in the ordered set where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposal version, or <code>null</code> if a matching proposal version could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion fetchByProposalId_Last(long proposalId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByProposalId(proposalId);

        if (count == 0) {
            return null;
        }

        List<ProposalVersion> list = findByProposalId(proposalId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the proposal versions before and after the current proposal version in the ordered set where proposalId = &#63;.
     *
     * @param proposalVersionPK the primary key of the current proposal version
     * @param proposalId the proposal ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next proposal version
     * @throws com.ext.portlet.NoSuchProposalVersionException if a proposal version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion[] findByProposalId_PrevAndNext(
        ProposalVersionPK proposalVersionPK, long proposalId,
        OrderByComparator orderByComparator)
        throws NoSuchProposalVersionException, SystemException {
        ProposalVersion proposalVersion = findByPrimaryKey(proposalVersionPK);

        Session session = null;

        try {
            session = openSession();

            ProposalVersion[] array = new ProposalVersionImpl[3];

            array[0] = getByProposalId_PrevAndNext(session, proposalVersion,
                    proposalId, orderByComparator, true);

            array[1] = proposalVersion;

            array[2] = getByProposalId_PrevAndNext(session, proposalVersion,
                    proposalId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ProposalVersion getByProposalId_PrevAndNext(Session session,
        ProposalVersion proposalVersion, long proposalId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PROPOSALVERSION_WHERE);

        query.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ProposalVersionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(proposalId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(proposalVersion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ProposalVersion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the proposal versions where proposalId = &#63; from the database.
     *
     * @param proposalId the proposal ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByProposalId(long proposalId) throws SystemException {
        for (ProposalVersion proposalVersion : findByProposalId(proposalId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(proposalVersion);
        }
    }

    /**
     * Returns the number of proposal versions where proposalId = &#63;.
     *
     * @param proposalId the proposal ID
     * @return the number of matching proposal versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByProposalId(long proposalId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PROPOSALID;

        Object[] finderArgs = new Object[] { proposalId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PROPOSALVERSION_WHERE);

            query.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(proposalId);

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
     * Caches the proposal version in the entity cache if it is enabled.
     *
     * @param proposalVersion the proposal version
     */
    @Override
    public void cacheResult(ProposalVersion proposalVersion) {
        EntityCacheUtil.putResult(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
            ProposalVersionImpl.class, proposalVersion.getPrimaryKey(),
            proposalVersion);

        proposalVersion.resetOriginalValues();
    }

    /**
     * Caches the proposal versions in the entity cache if it is enabled.
     *
     * @param proposalVersions the proposal versions
     */
    @Override
    public void cacheResult(List<ProposalVersion> proposalVersions) {
        for (ProposalVersion proposalVersion : proposalVersions) {
            if (EntityCacheUtil.getResult(
                        ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
                        ProposalVersionImpl.class,
                        proposalVersion.getPrimaryKey()) == null) {
                cacheResult(proposalVersion);
            } else {
                proposalVersion.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all proposal versions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ProposalVersionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ProposalVersionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the proposal version.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ProposalVersion proposalVersion) {
        EntityCacheUtil.removeResult(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
            ProposalVersionImpl.class, proposalVersion.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ProposalVersion> proposalVersions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ProposalVersion proposalVersion : proposalVersions) {
            EntityCacheUtil.removeResult(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
                ProposalVersionImpl.class, proposalVersion.getPrimaryKey());
        }
    }

    /**
     * Creates a new proposal version with the primary key. Does not add the proposal version to the database.
     *
     * @param proposalVersionPK the primary key for the new proposal version
     * @return the new proposal version
     */
    @Override
    public ProposalVersion create(ProposalVersionPK proposalVersionPK) {
        ProposalVersion proposalVersion = new ProposalVersionImpl();

        proposalVersion.setNew(true);
        proposalVersion.setPrimaryKey(proposalVersionPK);

        return proposalVersion;
    }

    /**
     * Removes the proposal version with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param proposalVersionPK the primary key of the proposal version
     * @return the proposal version that was removed
     * @throws com.ext.portlet.NoSuchProposalVersionException if a proposal version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion remove(ProposalVersionPK proposalVersionPK)
        throws NoSuchProposalVersionException, SystemException {
        return remove((Serializable) proposalVersionPK);
    }

    /**
     * Removes the proposal version with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the proposal version
     * @return the proposal version that was removed
     * @throws com.ext.portlet.NoSuchProposalVersionException if a proposal version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion remove(Serializable primaryKey)
        throws NoSuchProposalVersionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ProposalVersion proposalVersion = (ProposalVersion) session.get(ProposalVersionImpl.class,
                    primaryKey);

            if (proposalVersion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchProposalVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(proposalVersion);
        } catch (NoSuchProposalVersionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ProposalVersion removeImpl(ProposalVersion proposalVersion)
        throws SystemException {
        proposalVersion = toUnwrappedModel(proposalVersion);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(proposalVersion)) {
                proposalVersion = (ProposalVersion) session.get(ProposalVersionImpl.class,
                        proposalVersion.getPrimaryKeyObj());
            }

            if (proposalVersion != null) {
                session.delete(proposalVersion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (proposalVersion != null) {
            clearCache(proposalVersion);
        }

        return proposalVersion;
    }

    @Override
    public ProposalVersion updateImpl(
        com.ext.portlet.model.ProposalVersion proposalVersion)
        throws SystemException {
        proposalVersion = toUnwrappedModel(proposalVersion);

        boolean isNew = proposalVersion.isNew();

        ProposalVersionModelImpl proposalVersionModelImpl = (ProposalVersionModelImpl) proposalVersion;

        Session session = null;

        try {
            session = openSession();

            if (proposalVersion.isNew()) {
                session.save(proposalVersion);

                proposalVersion.setNew(false);
            } else {
                session.merge(proposalVersion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ProposalVersionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((proposalVersionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        proposalVersionModelImpl.getOriginalProposalId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSALID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID,
                    args);

                args = new Object[] { proposalVersionModelImpl.getProposalId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSALID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
            ProposalVersionImpl.class, proposalVersion.getPrimaryKey(),
            proposalVersion);

        return proposalVersion;
    }

    protected ProposalVersion toUnwrappedModel(ProposalVersion proposalVersion) {
        if (proposalVersion instanceof ProposalVersionImpl) {
            return proposalVersion;
        }

        ProposalVersionImpl proposalVersionImpl = new ProposalVersionImpl();

        proposalVersionImpl.setNew(proposalVersion.isNew());
        proposalVersionImpl.setPrimaryKey(proposalVersion.getPrimaryKey());

        proposalVersionImpl.setProposalId(proposalVersion.getProposalId());
        proposalVersionImpl.setVersion(proposalVersion.getVersion());
        proposalVersionImpl.setAuthorId(proposalVersion.getAuthorId());
        proposalVersionImpl.setCreateDate(proposalVersion.getCreateDate());
        proposalVersionImpl.setUpdateType(proposalVersion.getUpdateType());
        proposalVersionImpl.setUpdateAdditionalId(proposalVersion.getUpdateAdditionalId());

        return proposalVersionImpl;
    }

    /**
     * Returns the proposal version with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the proposal version
     * @return the proposal version
     * @throws com.ext.portlet.NoSuchProposalVersionException if a proposal version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion findByPrimaryKey(Serializable primaryKey)
        throws NoSuchProposalVersionException, SystemException {
        ProposalVersion proposalVersion = fetchByPrimaryKey(primaryKey);

        if (proposalVersion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchProposalVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return proposalVersion;
    }

    /**
     * Returns the proposal version with the primary key or throws a {@link com.ext.portlet.NoSuchProposalVersionException} if it could not be found.
     *
     * @param proposalVersionPK the primary key of the proposal version
     * @return the proposal version
     * @throws com.ext.portlet.NoSuchProposalVersionException if a proposal version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion findByPrimaryKey(ProposalVersionPK proposalVersionPK)
        throws NoSuchProposalVersionException, SystemException {
        return findByPrimaryKey((Serializable) proposalVersionPK);
    }

    /**
     * Returns the proposal version with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the proposal version
     * @return the proposal version, or <code>null</code> if a proposal version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ProposalVersion proposalVersion = (ProposalVersion) EntityCacheUtil.getResult(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
                ProposalVersionImpl.class, primaryKey);

        if (proposalVersion == _nullProposalVersion) {
            return null;
        }

        if (proposalVersion == null) {
            Session session = null;

            try {
                session = openSession();

                proposalVersion = (ProposalVersion) session.get(ProposalVersionImpl.class,
                        primaryKey);

                if (proposalVersion != null) {
                    cacheResult(proposalVersion);
                } else {
                    EntityCacheUtil.putResult(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
                        ProposalVersionImpl.class, primaryKey,
                        _nullProposalVersion);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ProposalVersionModelImpl.ENTITY_CACHE_ENABLED,
                    ProposalVersionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return proposalVersion;
    }

    /**
     * Returns the proposal version with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param proposalVersionPK the primary key of the proposal version
     * @return the proposal version, or <code>null</code> if a proposal version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ProposalVersion fetchByPrimaryKey(
        ProposalVersionPK proposalVersionPK) throws SystemException {
        return fetchByPrimaryKey((Serializable) proposalVersionPK);
    }

    /**
     * Returns all the proposal versions.
     *
     * @return the proposal versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ProposalVersion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the proposal versions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of proposal versions
     * @param end the upper bound of the range of proposal versions (not inclusive)
     * @return the range of proposal versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ProposalVersion> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the proposal versions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of proposal versions
     * @param end the upper bound of the range of proposal versions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of proposal versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ProposalVersion> findAll(int start, int end,
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

        List<ProposalVersion> list = (List<ProposalVersion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PROPOSALVERSION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PROPOSALVERSION;

                if (pagination) {
                    sql = sql.concat(ProposalVersionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ProposalVersion>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ProposalVersion>(list);
                } else {
                    list = (List<ProposalVersion>) QueryUtil.list(q,
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
     * Removes all the proposal versions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ProposalVersion proposalVersion : findAll()) {
            remove(proposalVersion);
        }
    }

    /**
     * Returns the number of proposal versions.
     *
     * @return the number of proposal versions
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

                Query q = session.createQuery(_SQL_COUNT_PROPOSALVERSION);

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
     * Initializes the proposal version persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.ext.portlet.model.ProposalVersion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ProposalVersion>> listenersList = new ArrayList<ModelListener<ProposalVersion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ProposalVersion>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ProposalVersionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

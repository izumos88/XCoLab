package com.ext.portlet.service.persistence;

import com.ext.portlet.NoSuchActivitySubscriptionException;
import com.ext.portlet.model.ActivitySubscription;
import com.ext.portlet.model.impl.ActivitySubscriptionImpl;
import com.ext.portlet.model.impl.ActivitySubscriptionModelImpl;
import com.ext.portlet.service.persistence.ActivitySubscriptionPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the activity subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivitySubscriptionPersistence
 * @see ActivitySubscriptionUtil
 * @generated
 */
public class ActivitySubscriptionPersistenceImpl extends BasePersistenceImpl<ActivitySubscription>
    implements ActivitySubscriptionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ActivitySubscriptionUtil} to access the activity subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ActivitySubscriptionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByreceiverId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByreceiverId",
            new String[] { Long.class.getName() },
            ActivitySubscriptionModelImpl.RECEIVERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVERID = new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByreceiverId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_RECEIVERID_RECEIVERID_2 = "activitySubscription.receiverId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPK =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassNameIdClassPK",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPK =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByClassNameIdClassPK",
            new String[] { Long.class.getName(), Long.class.getName() },
            ActivitySubscriptionModelImpl.CLASSNAMEID_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.CLASSPK_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPK = new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByClassNameIdClassPK",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPK_CLASSNAMEID_2 = "activitySubscription.classNameId = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPK_CLASSPK_2 = "activitySubscription.classPK = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKRECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByClassNameIdClassPKReceiverId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKRECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByClassNameIdClassPKReceiverId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            },
            ActivitySubscriptionModelImpl.CLASSNAMEID_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.CLASSPK_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.RECEIVERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKRECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByClassNameIdClassPKReceiverId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            });
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_CLASSNAMEID_2 =
        "activitySubscription.classNameId = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_CLASSPK_2 =
        "activitySubscription.classPK = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_RECEIVERID_2 =
        "activitySubscription.receiverId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByClassNameIdClassPKTypeReceiverId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByClassNameIdClassPKTypeReceiverId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(), Long.class.getName()
            },
            ActivitySubscriptionModelImpl.CLASSNAMEID_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.CLASSPK_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.TYPE_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.RECEIVERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByClassNameIdClassPKTypeReceiverId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(), Long.class.getName()
            });
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_CLASSNAMEID_2 =
        "activitySubscription.classNameId = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_CLASSPK_2 =
        "activitySubscription.classPK = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_TYPE_2 =
        "activitySubscription.type = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_RECEIVERID_2 =
        "activitySubscription.receiverId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByClassNameIdClassPKTypeExtraDataReceiverId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(), String.class.getName(),
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByClassNameIdClassPKTypeExtraDataReceiverId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(), String.class.getName(),
                Long.class.getName()
            },
            ActivitySubscriptionModelImpl.CLASSNAMEID_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.CLASSPK_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.TYPE_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.EXTRADATA_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.RECEIVERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByClassNameIdClassPKTypeExtraDataReceiverId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(), String.class.getName(),
                Long.class.getName()
            });
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_CLASSNAMEID_2 =
        "activitySubscription.classNameId = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_CLASSPK_2 =
        "activitySubscription.classPK = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_TYPE_2 =
        "activitySubscription.type = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_1 =
        "activitySubscription.extraData IS NULL AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_2 =
        "activitySubscription.extraData = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_3 =
        "(activitySubscription.extraData IS NULL OR activitySubscription.extraData = '') AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_RECEIVERID_2 =
        "activitySubscription.receiverId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByClassNameIdClassPKTypeExtraData",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByClassNameIdClassPKTypeExtraData",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(), String.class.getName()
            },
            ActivitySubscriptionModelImpl.CLASSNAMEID_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.CLASSPK_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.TYPE_COLUMN_BITMASK |
            ActivitySubscriptionModelImpl.EXTRADATA_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA =
        new FinderPath(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByClassNameIdClassPKTypeExtraData",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(), String.class.getName()
            });
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_CLASSNAMEID_2 =
        "activitySubscription.classNameId = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_CLASSPK_2 =
        "activitySubscription.classPK = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_TYPE_2 =
        "activitySubscription.type = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_1 =
        "activitySubscription.extraData IS NULL";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_2 =
        "activitySubscription.extraData = ?";
    private static final String _FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_3 =
        "(activitySubscription.extraData IS NULL OR activitySubscription.extraData = '')";
    private static final String _SQL_SELECT_ACTIVITYSUBSCRIPTION = "SELECT activitySubscription FROM ActivitySubscription activitySubscription";
    private static final String _SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE = "SELECT activitySubscription FROM ActivitySubscription activitySubscription WHERE ";
    private static final String _SQL_COUNT_ACTIVITYSUBSCRIPTION = "SELECT COUNT(activitySubscription) FROM ActivitySubscription activitySubscription";
    private static final String _SQL_COUNT_ACTIVITYSUBSCRIPTION_WHERE = "SELECT COUNT(activitySubscription) FROM ActivitySubscription activitySubscription WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "activitySubscription.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ActivitySubscription exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ActivitySubscription exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ActivitySubscriptionPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "type"
            });
    private static ActivitySubscription _nullActivitySubscription = new ActivitySubscriptionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ActivitySubscription> toCacheModel() {
                return _nullActivitySubscriptionCacheModel;
            }
        };

    private static CacheModel<ActivitySubscription> _nullActivitySubscriptionCacheModel =
        new CacheModel<ActivitySubscription>() {
            @Override
            public ActivitySubscription toEntityModel() {
                return _nullActivitySubscription;
            }
        };

    public ActivitySubscriptionPersistenceImpl() {
        setModelClass(ActivitySubscription.class);
    }

    /**
     * Returns all the activity subscriptions where receiverId = &#63;.
     *
     * @param receiverId the receiver ID
     * @return the matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByreceiverId(long receiverId)
        throws SystemException {
        return findByreceiverId(receiverId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the activity subscriptions where receiverId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param receiverId the receiver ID
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @return the range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByreceiverId(long receiverId,
        int start, int end) throws SystemException {
        return findByreceiverId(receiverId, start, end, null);
    }

    /**
     * Returns an ordered range of all the activity subscriptions where receiverId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param receiverId the receiver ID
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByreceiverId(long receiverId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIVERID;
            finderArgs = new Object[] { receiverId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIVERID;
            finderArgs = new Object[] { receiverId, start, end, orderByComparator };
        }

        List<ActivitySubscription> list = (List<ActivitySubscription>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActivitySubscription activitySubscription : list) {
                if ((receiverId != activitySubscription.getReceiverId())) {
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

            query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_RECEIVERID_RECEIVERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiverId);

                if (!pagination) {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActivitySubscription>(list);
                } else {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
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
     * Returns the first activity subscription in the ordered set where receiverId = &#63;.
     *
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByreceiverId_First(long receiverId,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByreceiverId_First(receiverId,
                orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("receiverId=");
        msg.append(receiverId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the first activity subscription in the ordered set where receiverId = &#63;.
     *
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByreceiverId_First(long receiverId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ActivitySubscription> list = findByreceiverId(receiverId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last activity subscription in the ordered set where receiverId = &#63;.
     *
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByreceiverId_Last(long receiverId,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByreceiverId_Last(receiverId,
                orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("receiverId=");
        msg.append(receiverId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the last activity subscription in the ordered set where receiverId = &#63;.
     *
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByreceiverId_Last(long receiverId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByreceiverId(receiverId);

        if (count == 0) {
            return null;
        }

        List<ActivitySubscription> list = findByreceiverId(receiverId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the activity subscriptions before and after the current activity subscription in the ordered set where receiverId = &#63;.
     *
     * @param pk the primary key of the current activity subscription
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription[] findByreceiverId_PrevAndNext(long pk,
        long receiverId, OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = findByPrimaryKey(pk);

        Session session = null;

        try {
            session = openSession();

            ActivitySubscription[] array = new ActivitySubscriptionImpl[3];

            array[0] = getByreceiverId_PrevAndNext(session,
                    activitySubscription, receiverId, orderByComparator, true);

            array[1] = activitySubscription;

            array[2] = getByreceiverId_PrevAndNext(session,
                    activitySubscription, receiverId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActivitySubscription getByreceiverId_PrevAndNext(
        Session session, ActivitySubscription activitySubscription,
        long receiverId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

        query.append(_FINDER_COLUMN_RECEIVERID_RECEIVERID_2);

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
            query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(receiverId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(activitySubscription);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActivitySubscription> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the activity subscriptions where receiverId = &#63; from the database.
     *
     * @param receiverId the receiver ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByreceiverId(long receiverId) throws SystemException {
        for (ActivitySubscription activitySubscription : findByreceiverId(
                receiverId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(activitySubscription);
        }
    }

    /**
     * Returns the number of activity subscriptions where receiverId = &#63;.
     *
     * @param receiverId the receiver ID
     * @return the number of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByreceiverId(long receiverId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_RECEIVERID;

        Object[] finderArgs = new Object[] { receiverId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_RECEIVERID_RECEIVERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiverId);

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
     * Returns all the activity subscriptions where classNameId = &#63; and classPK = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @return the matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPK(
        long classNameId, long classPK) throws SystemException {
        return findByClassNameIdClassPK(classNameId, classPK,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the activity subscriptions where classNameId = &#63; and classPK = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @return the range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPK(
        long classNameId, long classPK, int start, int end)
        throws SystemException {
        return findByClassNameIdClassPK(classNameId, classPK, start, end, null);
    }

    /**
     * Returns an ordered range of all the activity subscriptions where classNameId = &#63; and classPK = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPK(
        long classNameId, long classPK, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPK;
            finderArgs = new Object[] { classNameId, classPK };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPK;
            finderArgs = new Object[] {
                    classNameId, classPK,
                    
                    start, end, orderByComparator
                };
        }

        List<ActivitySubscription> list = (List<ActivitySubscription>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActivitySubscription activitySubscription : list) {
                if ((classNameId != activitySubscription.getClassNameId()) ||
                        (classPK != activitySubscription.getClassPK())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPK_CLASSNAMEID_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPK_CLASSPK_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                if (!pagination) {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActivitySubscription>(list);
                } else {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
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
     * Returns the first activity subscription in the ordered set where classNameId = &#63; and classPK = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByClassNameIdClassPK_First(
        long classNameId, long classPK, OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByClassNameIdClassPK_First(classNameId,
                classPK, orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("classNameId=");
        msg.append(classNameId);

        msg.append(", classPK=");
        msg.append(classPK);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the first activity subscription in the ordered set where classNameId = &#63; and classPK = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByClassNameIdClassPK_First(
        long classNameId, long classPK, OrderByComparator orderByComparator)
        throws SystemException {
        List<ActivitySubscription> list = findByClassNameIdClassPK(classNameId,
                classPK, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last activity subscription in the ordered set where classNameId = &#63; and classPK = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByClassNameIdClassPK_Last(
        long classNameId, long classPK, OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByClassNameIdClassPK_Last(classNameId,
                classPK, orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("classNameId=");
        msg.append(classNameId);

        msg.append(", classPK=");
        msg.append(classPK);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the last activity subscription in the ordered set where classNameId = &#63; and classPK = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByClassNameIdClassPK_Last(
        long classNameId, long classPK, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByClassNameIdClassPK(classNameId, classPK);

        if (count == 0) {
            return null;
        }

        List<ActivitySubscription> list = findByClassNameIdClassPK(classNameId,
                classPK, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the activity subscriptions before and after the current activity subscription in the ordered set where classNameId = &#63; and classPK = &#63;.
     *
     * @param pk the primary key of the current activity subscription
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription[] findByClassNameIdClassPK_PrevAndNext(
        long pk, long classNameId, long classPK,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = findByPrimaryKey(pk);

        Session session = null;

        try {
            session = openSession();

            ActivitySubscription[] array = new ActivitySubscriptionImpl[3];

            array[0] = getByClassNameIdClassPK_PrevAndNext(session,
                    activitySubscription, classNameId, classPK,
                    orderByComparator, true);

            array[1] = activitySubscription;

            array[2] = getByClassNameIdClassPK_PrevAndNext(session,
                    activitySubscription, classNameId, classPK,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActivitySubscription getByClassNameIdClassPK_PrevAndNext(
        Session session, ActivitySubscription activitySubscription,
        long classNameId, long classPK, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPK_CLASSNAMEID_2);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPK_CLASSPK_2);

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
            query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(classNameId);

        qPos.add(classPK);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(activitySubscription);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActivitySubscription> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the activity subscriptions where classNameId = &#63; and classPK = &#63; from the database.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByClassNameIdClassPK(long classNameId, long classPK)
        throws SystemException {
        for (ActivitySubscription activitySubscription : findByClassNameIdClassPK(
                classNameId, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(activitySubscription);
        }
    }

    /**
     * Returns the number of activity subscriptions where classNameId = &#63; and classPK = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @return the number of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByClassNameIdClassPK(long classNameId, long classPK)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPK;

        Object[] finderArgs = new Object[] { classNameId, classPK };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPK_CLASSNAMEID_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPK_CLASSPK_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

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
     * Returns all the activity subscriptions where classNameId = &#63; and classPK = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param receiverId the receiver ID
     * @return the matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKReceiverId(
        long classNameId, long classPK, long receiverId)
        throws SystemException {
        return findByClassNameIdClassPKReceiverId(classNameId, classPK,
            receiverId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the activity subscriptions where classNameId = &#63; and classPK = &#63; and receiverId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param receiverId the receiver ID
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @return the range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKReceiverId(
        long classNameId, long classPK, long receiverId, int start, int end)
        throws SystemException {
        return findByClassNameIdClassPKReceiverId(classNameId, classPK,
            receiverId, start, end, null);
    }

    /**
     * Returns an ordered range of all the activity subscriptions where classNameId = &#63; and classPK = &#63; and receiverId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param receiverId the receiver ID
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKReceiverId(
        long classNameId, long classPK, long receiverId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKRECEIVERID;
            finderArgs = new Object[] { classNameId, classPK, receiverId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKRECEIVERID;
            finderArgs = new Object[] {
                    classNameId, classPK, receiverId,
                    
                    start, end, orderByComparator
                };
        }

        List<ActivitySubscription> list = (List<ActivitySubscription>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActivitySubscription activitySubscription : list) {
                if ((classNameId != activitySubscription.getClassNameId()) ||
                        (classPK != activitySubscription.getClassPK()) ||
                        (receiverId != activitySubscription.getReceiverId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_CLASSNAMEID_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_CLASSPK_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_RECEIVERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                qPos.add(receiverId);

                if (!pagination) {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActivitySubscription>(list);
                } else {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
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
     * Returns the first activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByClassNameIdClassPKReceiverId_First(
        long classNameId, long classPK, long receiverId,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByClassNameIdClassPKReceiverId_First(classNameId,
                classPK, receiverId, orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("classNameId=");
        msg.append(classNameId);

        msg.append(", classPK=");
        msg.append(classPK);

        msg.append(", receiverId=");
        msg.append(receiverId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the first activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByClassNameIdClassPKReceiverId_First(
        long classNameId, long classPK, long receiverId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ActivitySubscription> list = findByClassNameIdClassPKReceiverId(classNameId,
                classPK, receiverId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByClassNameIdClassPKReceiverId_Last(
        long classNameId, long classPK, long receiverId,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByClassNameIdClassPKReceiverId_Last(classNameId,
                classPK, receiverId, orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("classNameId=");
        msg.append(classNameId);

        msg.append(", classPK=");
        msg.append(classPK);

        msg.append(", receiverId=");
        msg.append(receiverId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the last activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByClassNameIdClassPKReceiverId_Last(
        long classNameId, long classPK, long receiverId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByClassNameIdClassPKReceiverId(classNameId, classPK,
                receiverId);

        if (count == 0) {
            return null;
        }

        List<ActivitySubscription> list = findByClassNameIdClassPKReceiverId(classNameId,
                classPK, receiverId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the activity subscriptions before and after the current activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and receiverId = &#63;.
     *
     * @param pk the primary key of the current activity subscription
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription[] findByClassNameIdClassPKReceiverId_PrevAndNext(
        long pk, long classNameId, long classPK, long receiverId,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = findByPrimaryKey(pk);

        Session session = null;

        try {
            session = openSession();

            ActivitySubscription[] array = new ActivitySubscriptionImpl[3];

            array[0] = getByClassNameIdClassPKReceiverId_PrevAndNext(session,
                    activitySubscription, classNameId, classPK, receiverId,
                    orderByComparator, true);

            array[1] = activitySubscription;

            array[2] = getByClassNameIdClassPKReceiverId_PrevAndNext(session,
                    activitySubscription, classNameId, classPK, receiverId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActivitySubscription getByClassNameIdClassPKReceiverId_PrevAndNext(
        Session session, ActivitySubscription activitySubscription,
        long classNameId, long classPK, long receiverId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_CLASSNAMEID_2);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_CLASSPK_2);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_RECEIVERID_2);

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
            query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(classNameId);

        qPos.add(classPK);

        qPos.add(receiverId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(activitySubscription);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActivitySubscription> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the activity subscriptions where classNameId = &#63; and classPK = &#63; and receiverId = &#63; from the database.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param receiverId the receiver ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByClassNameIdClassPKReceiverId(long classNameId,
        long classPK, long receiverId) throws SystemException {
        for (ActivitySubscription activitySubscription : findByClassNameIdClassPKReceiverId(
                classNameId, classPK, receiverId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(activitySubscription);
        }
    }

    /**
     * Returns the number of activity subscriptions where classNameId = &#63; and classPK = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param receiverId the receiver ID
     * @return the number of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByClassNameIdClassPKReceiverId(long classNameId,
        long classPK, long receiverId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKRECEIVERID;

        Object[] finderArgs = new Object[] { classNameId, classPK, receiverId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_CLASSNAMEID_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_CLASSPK_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKRECEIVERID_RECEIVERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                qPos.add(receiverId);

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
     * Returns all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param receiverId the receiver ID
     * @return the matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKTypeReceiverId(
        long classNameId, long classPK, int type, long receiverId)
        throws SystemException {
        return findByClassNameIdClassPKTypeReceiverId(classNameId, classPK,
            type, receiverId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param receiverId the receiver ID
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @return the range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKTypeReceiverId(
        long classNameId, long classPK, int type, long receiverId, int start,
        int end) throws SystemException {
        return findByClassNameIdClassPKTypeReceiverId(classNameId, classPK,
            type, receiverId, start, end, null);
    }

    /**
     * Returns an ordered range of all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param receiverId the receiver ID
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKTypeReceiverId(
        long classNameId, long classPK, int type, long receiverId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID;
            finderArgs = new Object[] { classNameId, classPK, type, receiverId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID;
            finderArgs = new Object[] {
                    classNameId, classPK, type, receiverId,
                    
                    start, end, orderByComparator
                };
        }

        List<ActivitySubscription> list = (List<ActivitySubscription>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActivitySubscription activitySubscription : list) {
                if ((classNameId != activitySubscription.getClassNameId()) ||
                        (classPK != activitySubscription.getClassPK()) ||
                        (type != activitySubscription.getType()) ||
                        (receiverId != activitySubscription.getReceiverId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(6 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(6);
            }

            query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_CLASSNAMEID_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_CLASSPK_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_TYPE_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_RECEIVERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                qPos.add(type);

                qPos.add(receiverId);

                if (!pagination) {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActivitySubscription>(list);
                } else {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
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
     * Returns the first activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByClassNameIdClassPKTypeReceiverId_First(
        long classNameId, long classPK, int type, long receiverId,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByClassNameIdClassPKTypeReceiverId_First(classNameId,
                classPK, type, receiverId, orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("classNameId=");
        msg.append(classNameId);

        msg.append(", classPK=");
        msg.append(classPK);

        msg.append(", type=");
        msg.append(type);

        msg.append(", receiverId=");
        msg.append(receiverId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the first activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByClassNameIdClassPKTypeReceiverId_First(
        long classNameId, long classPK, int type, long receiverId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ActivitySubscription> list = findByClassNameIdClassPKTypeReceiverId(classNameId,
                classPK, type, receiverId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByClassNameIdClassPKTypeReceiverId_Last(
        long classNameId, long classPK, int type, long receiverId,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByClassNameIdClassPKTypeReceiverId_Last(classNameId,
                classPK, type, receiverId, orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("classNameId=");
        msg.append(classNameId);

        msg.append(", classPK=");
        msg.append(classPK);

        msg.append(", type=");
        msg.append(type);

        msg.append(", receiverId=");
        msg.append(receiverId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the last activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByClassNameIdClassPKTypeReceiverId_Last(
        long classNameId, long classPK, int type, long receiverId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByClassNameIdClassPKTypeReceiverId(classNameId,
                classPK, type, receiverId);

        if (count == 0) {
            return null;
        }

        List<ActivitySubscription> list = findByClassNameIdClassPKTypeReceiverId(classNameId,
                classPK, type, receiverId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the activity subscriptions before and after the current activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverId = &#63;.
     *
     * @param pk the primary key of the current activity subscription
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription[] findByClassNameIdClassPKTypeReceiverId_PrevAndNext(
        long pk, long classNameId, long classPK, int type, long receiverId,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = findByPrimaryKey(pk);

        Session session = null;

        try {
            session = openSession();

            ActivitySubscription[] array = new ActivitySubscriptionImpl[3];

            array[0] = getByClassNameIdClassPKTypeReceiverId_PrevAndNext(session,
                    activitySubscription, classNameId, classPK, type,
                    receiverId, orderByComparator, true);

            array[1] = activitySubscription;

            array[2] = getByClassNameIdClassPKTypeReceiverId_PrevAndNext(session,
                    activitySubscription, classNameId, classPK, type,
                    receiverId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActivitySubscription getByClassNameIdClassPKTypeReceiverId_PrevAndNext(
        Session session, ActivitySubscription activitySubscription,
        long classNameId, long classPK, int type, long receiverId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_CLASSNAMEID_2);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_CLASSPK_2);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_TYPE_2);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_RECEIVERID_2);

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
            query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(classNameId);

        qPos.add(classPK);

        qPos.add(type);

        qPos.add(receiverId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(activitySubscription);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActivitySubscription> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverId = &#63; from the database.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param receiverId the receiver ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByClassNameIdClassPKTypeReceiverId(long classNameId,
        long classPK, int type, long receiverId) throws SystemException {
        for (ActivitySubscription activitySubscription : findByClassNameIdClassPKTypeReceiverId(
                classNameId, classPK, type, receiverId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(activitySubscription);
        }
    }

    /**
     * Returns the number of activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param receiverId the receiver ID
     * @return the number of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByClassNameIdClassPKTypeReceiverId(long classNameId,
        long classPK, int type, long receiverId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID;

        Object[] finderArgs = new Object[] {
                classNameId, classPK, type, receiverId
            };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_COUNT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_CLASSNAMEID_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_CLASSPK_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_TYPE_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPERECEIVERID_RECEIVERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                qPos.add(type);

                qPos.add(receiverId);

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
     * Returns all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param receiverId the receiver ID
     * @return the matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKTypeExtraDataReceiverId(
        long classNameId, long classPK, int type, String extraData,
        long receiverId) throws SystemException {
        return findByClassNameIdClassPKTypeExtraDataReceiverId(classNameId,
            classPK, type, extraData, receiverId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; and receiverId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param receiverId the receiver ID
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @return the range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKTypeExtraDataReceiverId(
        long classNameId, long classPK, int type, String extraData,
        long receiverId, int start, int end) throws SystemException {
        return findByClassNameIdClassPKTypeExtraDataReceiverId(classNameId,
            classPK, type, extraData, receiverId, start, end, null);
    }

    /**
     * Returns an ordered range of all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; and receiverId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param receiverId the receiver ID
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKTypeExtraDataReceiverId(
        long classNameId, long classPK, int type, String extraData,
        long receiverId, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID;
            finderArgs = new Object[] {
                    classNameId, classPK, type, extraData, receiverId
                };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID;
            finderArgs = new Object[] {
                    classNameId, classPK, type, extraData, receiverId,
                    
                    start, end, orderByComparator
                };
        }

        List<ActivitySubscription> list = (List<ActivitySubscription>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActivitySubscription activitySubscription : list) {
                if ((classNameId != activitySubscription.getClassNameId()) ||
                        (classPK != activitySubscription.getClassPK()) ||
                        (type != activitySubscription.getType()) ||
                        !Validator.equals(extraData,
                            activitySubscription.getExtraData()) ||
                        (receiverId != activitySubscription.getReceiverId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(7 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(7);
            }

            query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_CLASSNAMEID_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_CLASSPK_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_TYPE_2);

            boolean bindExtraData = false;

            if (extraData == null) {
                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_1);
            } else if (extraData.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_3);
            } else {
                bindExtraData = true;

                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_2);
            }

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_RECEIVERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                qPos.add(type);

                if (bindExtraData) {
                    qPos.add(extraData);
                }

                qPos.add(receiverId);

                if (!pagination) {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActivitySubscription>(list);
                } else {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
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
     * Returns the first activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByClassNameIdClassPKTypeExtraDataReceiverId_First(
        long classNameId, long classPK, int type, String extraData,
        long receiverId, OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByClassNameIdClassPKTypeExtraDataReceiverId_First(classNameId,
                classPK, type, extraData, receiverId, orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(12);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("classNameId=");
        msg.append(classNameId);

        msg.append(", classPK=");
        msg.append(classPK);

        msg.append(", type=");
        msg.append(type);

        msg.append(", extraData=");
        msg.append(extraData);

        msg.append(", receiverId=");
        msg.append(receiverId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the first activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByClassNameIdClassPKTypeExtraDataReceiverId_First(
        long classNameId, long classPK, int type, String extraData,
        long receiverId, OrderByComparator orderByComparator)
        throws SystemException {
        List<ActivitySubscription> list = findByClassNameIdClassPKTypeExtraDataReceiverId(classNameId,
                classPK, type, extraData, receiverId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByClassNameIdClassPKTypeExtraDataReceiverId_Last(
        long classNameId, long classPK, int type, String extraData,
        long receiverId, OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByClassNameIdClassPKTypeExtraDataReceiverId_Last(classNameId,
                classPK, type, extraData, receiverId, orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(12);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("classNameId=");
        msg.append(classNameId);

        msg.append(", classPK=");
        msg.append(classPK);

        msg.append(", type=");
        msg.append(type);

        msg.append(", extraData=");
        msg.append(extraData);

        msg.append(", receiverId=");
        msg.append(receiverId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the last activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByClassNameIdClassPKTypeExtraDataReceiverId_Last(
        long classNameId, long classPK, int type, String extraData,
        long receiverId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByClassNameIdClassPKTypeExtraDataReceiverId(classNameId,
                classPK, type, extraData, receiverId);

        if (count == 0) {
            return null;
        }

        List<ActivitySubscription> list = findByClassNameIdClassPKTypeExtraDataReceiverId(classNameId,
                classPK, type, extraData, receiverId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the activity subscriptions before and after the current activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; and receiverId = &#63;.
     *
     * @param pk the primary key of the current activity subscription
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param receiverId the receiver ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription[] findByClassNameIdClassPKTypeExtraDataReceiverId_PrevAndNext(
        long pk, long classNameId, long classPK, int type, String extraData,
        long receiverId, OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = findByPrimaryKey(pk);

        Session session = null;

        try {
            session = openSession();

            ActivitySubscription[] array = new ActivitySubscriptionImpl[3];

            array[0] = getByClassNameIdClassPKTypeExtraDataReceiverId_PrevAndNext(session,
                    activitySubscription, classNameId, classPK, type,
                    extraData, receiverId, orderByComparator, true);

            array[1] = activitySubscription;

            array[2] = getByClassNameIdClassPKTypeExtraDataReceiverId_PrevAndNext(session,
                    activitySubscription, classNameId, classPK, type,
                    extraData, receiverId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActivitySubscription getByClassNameIdClassPKTypeExtraDataReceiverId_PrevAndNext(
        Session session, ActivitySubscription activitySubscription,
        long classNameId, long classPK, int type, String extraData,
        long receiverId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_CLASSNAMEID_2);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_CLASSPK_2);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_TYPE_2);

        boolean bindExtraData = false;

        if (extraData == null) {
            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_1);
        } else if (extraData.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_3);
        } else {
            bindExtraData = true;

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_2);
        }

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_RECEIVERID_2);

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
            query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(classNameId);

        qPos.add(classPK);

        qPos.add(type);

        if (bindExtraData) {
            qPos.add(extraData);
        }

        qPos.add(receiverId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(activitySubscription);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActivitySubscription> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; and receiverId = &#63; from the database.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param receiverId the receiver ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByClassNameIdClassPKTypeExtraDataReceiverId(
        long classNameId, long classPK, int type, String extraData,
        long receiverId) throws SystemException {
        for (ActivitySubscription activitySubscription : findByClassNameIdClassPKTypeExtraDataReceiverId(
                classNameId, classPK, type, extraData, receiverId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(activitySubscription);
        }
    }

    /**
     * Returns the number of activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; and receiverId = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param receiverId the receiver ID
     * @return the number of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByClassNameIdClassPKTypeExtraDataReceiverId(
        long classNameId, long classPK, int type, String extraData,
        long receiverId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID;

        Object[] finderArgs = new Object[] {
                classNameId, classPK, type, extraData, receiverId
            };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(6);

            query.append(_SQL_COUNT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_CLASSNAMEID_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_CLASSPK_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_TYPE_2);

            boolean bindExtraData = false;

            if (extraData == null) {
                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_1);
            } else if (extraData.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_3);
            } else {
                bindExtraData = true;

                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_EXTRADATA_2);
            }

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID_RECEIVERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                qPos.add(type);

                if (bindExtraData) {
                    qPos.add(extraData);
                }

                qPos.add(receiverId);

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
     * Returns all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @return the matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKTypeExtraData(
        long classNameId, long classPK, int type, String extraData)
        throws SystemException {
        return findByClassNameIdClassPKTypeExtraData(classNameId, classPK,
            type, extraData, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @return the range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKTypeExtraData(
        long classNameId, long classPK, int type, String extraData, int start,
        int end) throws SystemException {
        return findByClassNameIdClassPKTypeExtraData(classNameId, classPK,
            type, extraData, start, end, null);
    }

    /**
     * Returns an ordered range of all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findByClassNameIdClassPKTypeExtraData(
        long classNameId, long classPK, int type, String extraData, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA;
            finderArgs = new Object[] { classNameId, classPK, type, extraData };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA;
            finderArgs = new Object[] {
                    classNameId, classPK, type, extraData,
                    
                    start, end, orderByComparator
                };
        }

        List<ActivitySubscription> list = (List<ActivitySubscription>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActivitySubscription activitySubscription : list) {
                if ((classNameId != activitySubscription.getClassNameId()) ||
                        (classPK != activitySubscription.getClassPK()) ||
                        (type != activitySubscription.getType()) ||
                        !Validator.equals(extraData,
                            activitySubscription.getExtraData())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(6 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(6);
            }

            query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_CLASSNAMEID_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_CLASSPK_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_TYPE_2);

            boolean bindExtraData = false;

            if (extraData == null) {
                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_1);
            } else if (extraData.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_3);
            } else {
                bindExtraData = true;

                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                qPos.add(type);

                if (bindExtraData) {
                    qPos.add(extraData);
                }

                if (!pagination) {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActivitySubscription>(list);
                } else {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
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
     * Returns the first activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByClassNameIdClassPKTypeExtraData_First(
        long classNameId, long classPK, int type, String extraData,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByClassNameIdClassPKTypeExtraData_First(classNameId,
                classPK, type, extraData, orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("classNameId=");
        msg.append(classNameId);

        msg.append(", classPK=");
        msg.append(classPK);

        msg.append(", type=");
        msg.append(type);

        msg.append(", extraData=");
        msg.append(extraData);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the first activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByClassNameIdClassPKTypeExtraData_First(
        long classNameId, long classPK, int type, String extraData,
        OrderByComparator orderByComparator) throws SystemException {
        List<ActivitySubscription> list = findByClassNameIdClassPKTypeExtraData(classNameId,
                classPK, type, extraData, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByClassNameIdClassPKTypeExtraData_Last(
        long classNameId, long classPK, int type, String extraData,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByClassNameIdClassPKTypeExtraData_Last(classNameId,
                classPK, type, extraData, orderByComparator);

        if (activitySubscription != null) {
            return activitySubscription;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("classNameId=");
        msg.append(classNameId);

        msg.append(", classPK=");
        msg.append(classPK);

        msg.append(", type=");
        msg.append(type);

        msg.append(", extraData=");
        msg.append(extraData);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActivitySubscriptionException(msg.toString());
    }

    /**
     * Returns the last activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching activity subscription, or <code>null</code> if a matching activity subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByClassNameIdClassPKTypeExtraData_Last(
        long classNameId, long classPK, int type, String extraData,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByClassNameIdClassPKTypeExtraData(classNameId,
                classPK, type, extraData);

        if (count == 0) {
            return null;
        }

        List<ActivitySubscription> list = findByClassNameIdClassPKTypeExtraData(classNameId,
                classPK, type, extraData, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the activity subscriptions before and after the current activity subscription in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63;.
     *
     * @param pk the primary key of the current activity subscription
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription[] findByClassNameIdClassPKTypeExtraData_PrevAndNext(
        long pk, long classNameId, long classPK, int type, String extraData,
        OrderByComparator orderByComparator)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = findByPrimaryKey(pk);

        Session session = null;

        try {
            session = openSession();

            ActivitySubscription[] array = new ActivitySubscriptionImpl[3];

            array[0] = getByClassNameIdClassPKTypeExtraData_PrevAndNext(session,
                    activitySubscription, classNameId, classPK, type,
                    extraData, orderByComparator, true);

            array[1] = activitySubscription;

            array[2] = getByClassNameIdClassPKTypeExtraData_PrevAndNext(session,
                    activitySubscription, classNameId, classPK, type,
                    extraData, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActivitySubscription getByClassNameIdClassPKTypeExtraData_PrevAndNext(
        Session session, ActivitySubscription activitySubscription,
        long classNameId, long classPK, int type, String extraData,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION_WHERE);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_CLASSNAMEID_2);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_CLASSPK_2);

        query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_TYPE_2);

        boolean bindExtraData = false;

        if (extraData == null) {
            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_1);
        } else if (extraData.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_3);
        } else {
            bindExtraData = true;

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_2);
        }

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
            query.append(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(classNameId);

        qPos.add(classPK);

        qPos.add(type);

        if (bindExtraData) {
            qPos.add(extraData);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(activitySubscription);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActivitySubscription> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63; from the database.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByClassNameIdClassPKTypeExtraData(long classNameId,
        long classPK, int type, String extraData) throws SystemException {
        for (ActivitySubscription activitySubscription : findByClassNameIdClassPKTypeExtraData(
                classNameId, classPK, type, extraData, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(activitySubscription);
        }
    }

    /**
     * Returns the number of activity subscriptions where classNameId = &#63; and classPK = &#63; and type = &#63; and extraData = &#63;.
     *
     * @param classNameId the class name ID
     * @param classPK the class p k
     * @param type the type
     * @param extraData the extra data
     * @return the number of matching activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByClassNameIdClassPKTypeExtraData(long classNameId,
        long classPK, int type, String extraData) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA;

        Object[] finderArgs = new Object[] { classNameId, classPK, type, extraData };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_COUNT_ACTIVITYSUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_CLASSNAMEID_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_CLASSPK_2);

            query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_TYPE_2);

            boolean bindExtraData = false;

            if (extraData == null) {
                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_1);
            } else if (extraData.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_3);
            } else {
                bindExtraData = true;

                query.append(_FINDER_COLUMN_CLASSNAMEIDCLASSPKTYPEEXTRADATA_EXTRADATA_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                qPos.add(type);

                if (bindExtraData) {
                    qPos.add(extraData);
                }

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
     * Caches the activity subscription in the entity cache if it is enabled.
     *
     * @param activitySubscription the activity subscription
     */
    @Override
    public void cacheResult(ActivitySubscription activitySubscription) {
        EntityCacheUtil.putResult(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            activitySubscription.getPrimaryKey(), activitySubscription);

        activitySubscription.resetOriginalValues();
    }

    /**
     * Caches the activity subscriptions in the entity cache if it is enabled.
     *
     * @param activitySubscriptions the activity subscriptions
     */
    @Override
    public void cacheResult(List<ActivitySubscription> activitySubscriptions) {
        for (ActivitySubscription activitySubscription : activitySubscriptions) {
            if (EntityCacheUtil.getResult(
                        ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
                        ActivitySubscriptionImpl.class,
                        activitySubscription.getPrimaryKey()) == null) {
                cacheResult(activitySubscription);
            } else {
                activitySubscription.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all activity subscriptions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ActivitySubscriptionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ActivitySubscriptionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the activity subscription.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ActivitySubscription activitySubscription) {
        EntityCacheUtil.removeResult(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionImpl.class, activitySubscription.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ActivitySubscription> activitySubscriptions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ActivitySubscription activitySubscription : activitySubscriptions) {
            EntityCacheUtil.removeResult(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
                ActivitySubscriptionImpl.class,
                activitySubscription.getPrimaryKey());
        }
    }

    /**
     * Creates a new activity subscription with the primary key. Does not add the activity subscription to the database.
     *
     * @param pk the primary key for the new activity subscription
     * @return the new activity subscription
     */
    @Override
    public ActivitySubscription create(long pk) {
        ActivitySubscription activitySubscription = new ActivitySubscriptionImpl();

        activitySubscription.setNew(true);
        activitySubscription.setPrimaryKey(pk);

        return activitySubscription;
    }

    /**
     * Removes the activity subscription with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param pk the primary key of the activity subscription
     * @return the activity subscription that was removed
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription remove(long pk)
        throws NoSuchActivitySubscriptionException, SystemException {
        return remove((Serializable) pk);
    }

    /**
     * Removes the activity subscription with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the activity subscription
     * @return the activity subscription that was removed
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription remove(Serializable primaryKey)
        throws NoSuchActivitySubscriptionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ActivitySubscription activitySubscription = (ActivitySubscription) session.get(ActivitySubscriptionImpl.class,
                    primaryKey);

            if (activitySubscription == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchActivitySubscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(activitySubscription);
        } catch (NoSuchActivitySubscriptionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ActivitySubscription removeImpl(
        ActivitySubscription activitySubscription) throws SystemException {
        activitySubscription = toUnwrappedModel(activitySubscription);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(activitySubscription)) {
                activitySubscription = (ActivitySubscription) session.get(ActivitySubscriptionImpl.class,
                        activitySubscription.getPrimaryKeyObj());
            }

            if (activitySubscription != null) {
                session.delete(activitySubscription);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (activitySubscription != null) {
            clearCache(activitySubscription);
        }

        return activitySubscription;
    }

    @Override
    public ActivitySubscription updateImpl(
        com.ext.portlet.model.ActivitySubscription activitySubscription)
        throws SystemException {
        activitySubscription = toUnwrappedModel(activitySubscription);

        boolean isNew = activitySubscription.isNew();

        ActivitySubscriptionModelImpl activitySubscriptionModelImpl = (ActivitySubscriptionModelImpl) activitySubscription;

        Session session = null;

        try {
            session = openSession();

            if (activitySubscription.isNew()) {
                session.save(activitySubscription);

                activitySubscription.setNew(false);
            } else {
                session.merge(activitySubscription);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ActivitySubscriptionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((activitySubscriptionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIVERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        activitySubscriptionModelImpl.getOriginalReceiverId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIVERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIVERID,
                    args);

                args = new Object[] {
                        activitySubscriptionModelImpl.getReceiverId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIVERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIVERID,
                    args);
            }

            if ((activitySubscriptionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPK.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        activitySubscriptionModelImpl.getOriginalClassNameId(),
                        activitySubscriptionModelImpl.getOriginalClassPK()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPK,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPK,
                    args);

                args = new Object[] {
                        activitySubscriptionModelImpl.getClassNameId(),
                        activitySubscriptionModelImpl.getClassPK()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPK,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPK,
                    args);
            }

            if ((activitySubscriptionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKRECEIVERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        activitySubscriptionModelImpl.getOriginalClassNameId(),
                        activitySubscriptionModelImpl.getOriginalClassPK(),
                        activitySubscriptionModelImpl.getOriginalReceiverId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKRECEIVERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKRECEIVERID,
                    args);

                args = new Object[] {
                        activitySubscriptionModelImpl.getClassNameId(),
                        activitySubscriptionModelImpl.getClassPK(),
                        activitySubscriptionModelImpl.getReceiverId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKRECEIVERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKRECEIVERID,
                    args);
            }

            if ((activitySubscriptionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        activitySubscriptionModelImpl.getOriginalClassNameId(),
                        activitySubscriptionModelImpl.getOriginalClassPK(),
                        activitySubscriptionModelImpl.getOriginalType(),
                        activitySubscriptionModelImpl.getOriginalReceiverId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID,
                    args);

                args = new Object[] {
                        activitySubscriptionModelImpl.getClassNameId(),
                        activitySubscriptionModelImpl.getClassPK(),
                        activitySubscriptionModelImpl.getType(),
                        activitySubscriptionModelImpl.getReceiverId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPERECEIVERID,
                    args);
            }

            if ((activitySubscriptionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        activitySubscriptionModelImpl.getOriginalClassNameId(),
                        activitySubscriptionModelImpl.getOriginalClassPK(),
                        activitySubscriptionModelImpl.getOriginalType(),
                        activitySubscriptionModelImpl.getOriginalExtraData(),
                        activitySubscriptionModelImpl.getOriginalReceiverId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID,
                    args);

                args = new Object[] {
                        activitySubscriptionModelImpl.getClassNameId(),
                        activitySubscriptionModelImpl.getClassPK(),
                        activitySubscriptionModelImpl.getType(),
                        activitySubscriptionModelImpl.getExtraData(),
                        activitySubscriptionModelImpl.getReceiverId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATARECEIVERID,
                    args);
            }

            if ((activitySubscriptionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        activitySubscriptionModelImpl.getOriginalClassNameId(),
                        activitySubscriptionModelImpl.getOriginalClassPK(),
                        activitySubscriptionModelImpl.getOriginalType(),
                        activitySubscriptionModelImpl.getOriginalExtraData()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA,
                    args);

                args = new Object[] {
                        activitySubscriptionModelImpl.getClassNameId(),
                        activitySubscriptionModelImpl.getClassPK(),
                        activitySubscriptionModelImpl.getType(),
                        activitySubscriptionModelImpl.getExtraData()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEIDCLASSPKTYPEEXTRADATA,
                    args);
            }
        }

        EntityCacheUtil.putResult(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            ActivitySubscriptionImpl.class,
            activitySubscription.getPrimaryKey(), activitySubscription);

        return activitySubscription;
    }

    protected ActivitySubscription toUnwrappedModel(
        ActivitySubscription activitySubscription) {
        if (activitySubscription instanceof ActivitySubscriptionImpl) {
            return activitySubscription;
        }

        ActivitySubscriptionImpl activitySubscriptionImpl = new ActivitySubscriptionImpl();

        activitySubscriptionImpl.setNew(activitySubscription.isNew());
        activitySubscriptionImpl.setPrimaryKey(activitySubscription.getPrimaryKey());

        activitySubscriptionImpl.setPk(activitySubscription.getPk());
        activitySubscriptionImpl.setClassNameId(activitySubscription.getClassNameId());
        activitySubscriptionImpl.setClassPK(activitySubscription.getClassPK());
        activitySubscriptionImpl.setType(activitySubscription.getType());
        activitySubscriptionImpl.setAutomaticSubscriptionCounter(activitySubscription.getAutomaticSubscriptionCounter());
        activitySubscriptionImpl.setExtraData(activitySubscription.getExtraData());
        activitySubscriptionImpl.setReceiverId(activitySubscription.getReceiverId());
        activitySubscriptionImpl.setCreateDate(activitySubscription.getCreateDate());
        activitySubscriptionImpl.setModifiedDate(activitySubscription.getModifiedDate());

        return activitySubscriptionImpl;
    }

    /**
     * Returns the activity subscription with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the activity subscription
     * @return the activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByPrimaryKey(Serializable primaryKey)
        throws NoSuchActivitySubscriptionException, SystemException {
        ActivitySubscription activitySubscription = fetchByPrimaryKey(primaryKey);

        if (activitySubscription == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchActivitySubscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return activitySubscription;
    }

    /**
     * Returns the activity subscription with the primary key or throws a {@link com.ext.portlet.NoSuchActivitySubscriptionException} if it could not be found.
     *
     * @param pk the primary key of the activity subscription
     * @return the activity subscription
     * @throws com.ext.portlet.NoSuchActivitySubscriptionException if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription findByPrimaryKey(long pk)
        throws NoSuchActivitySubscriptionException, SystemException {
        return findByPrimaryKey((Serializable) pk);
    }

    /**
     * Returns the activity subscription with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the activity subscription
     * @return the activity subscription, or <code>null</code> if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ActivitySubscription activitySubscription = (ActivitySubscription) EntityCacheUtil.getResult(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
                ActivitySubscriptionImpl.class, primaryKey);

        if (activitySubscription == _nullActivitySubscription) {
            return null;
        }

        if (activitySubscription == null) {
            Session session = null;

            try {
                session = openSession();

                activitySubscription = (ActivitySubscription) session.get(ActivitySubscriptionImpl.class,
                        primaryKey);

                if (activitySubscription != null) {
                    cacheResult(activitySubscription);
                } else {
                    EntityCacheUtil.putResult(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
                        ActivitySubscriptionImpl.class, primaryKey,
                        _nullActivitySubscription);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ActivitySubscriptionModelImpl.ENTITY_CACHE_ENABLED,
                    ActivitySubscriptionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return activitySubscription;
    }

    /**
     * Returns the activity subscription with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param pk the primary key of the activity subscription
     * @return the activity subscription, or <code>null</code> if a activity subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActivitySubscription fetchByPrimaryKey(long pk)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) pk);
    }

    /**
     * Returns all the activity subscriptions.
     *
     * @return the activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the activity subscriptions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @return the range of activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the activity subscriptions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ActivitySubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of activity subscriptions
     * @param end the upper bound of the range of activity subscriptions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of activity subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActivitySubscription> findAll(int start, int end,
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

        List<ActivitySubscription> list = (List<ActivitySubscription>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ACTIVITYSUBSCRIPTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ACTIVITYSUBSCRIPTION;

                if (pagination) {
                    sql = sql.concat(ActivitySubscriptionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActivitySubscription>(list);
                } else {
                    list = (List<ActivitySubscription>) QueryUtil.list(q,
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
     * Removes all the activity subscriptions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ActivitySubscription activitySubscription : findAll()) {
            remove(activitySubscription);
        }
    }

    /**
     * Returns the number of activity subscriptions.
     *
     * @return the number of activity subscriptions
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

                Query q = session.createQuery(_SQL_COUNT_ACTIVITYSUBSCRIPTION);

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

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the activity subscription persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.ext.portlet.model.ActivitySubscription")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ActivitySubscription>> listenersList = new ArrayList<ModelListener<ActivitySubscription>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ActivitySubscription>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ActivitySubscriptionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

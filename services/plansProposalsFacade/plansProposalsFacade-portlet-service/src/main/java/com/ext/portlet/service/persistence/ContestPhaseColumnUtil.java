package com.ext.portlet.service.persistence;

import com.ext.portlet.model.ContestPhaseColumn;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contest phase column service. This utility wraps {@link ContestPhaseColumnPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestPhaseColumnPersistence
 * @see ContestPhaseColumnPersistenceImpl
 * @generated
 */
public class ContestPhaseColumnUtil {
    private static ContestPhaseColumnPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(ContestPhaseColumn contestPhaseColumn) {
        getPersistence().clearCache(contestPhaseColumn);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<ContestPhaseColumn> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ContestPhaseColumn> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ContestPhaseColumn> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ContestPhaseColumn update(
        ContestPhaseColumn contestPhaseColumn) throws SystemException {
        return getPersistence().update(contestPhaseColumn);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ContestPhaseColumn update(
        ContestPhaseColumn contestPhaseColumn, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(contestPhaseColumn, serviceContext);
    }

    /**
    * Returns all the contest phase columns where ContestPhasePK = &#63;.
    *
    * @param ContestPhasePK the contest phase p k
    * @return the matching contest phase columns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestPhaseColumn> findByContestPhasePK(
        long ContestPhasePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByContestPhasePK(ContestPhasePK);
    }

    /**
    * Returns a range of all the contest phase columns where ContestPhasePK = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestPhaseColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param ContestPhasePK the contest phase p k
    * @param start the lower bound of the range of contest phase columns
    * @param end the upper bound of the range of contest phase columns (not inclusive)
    * @return the range of matching contest phase columns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestPhaseColumn> findByContestPhasePK(
        long ContestPhasePK, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByContestPhasePK(ContestPhasePK, start, end);
    }

    /**
    * Returns an ordered range of all the contest phase columns where ContestPhasePK = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestPhaseColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param ContestPhasePK the contest phase p k
    * @param start the lower bound of the range of contest phase columns
    * @param end the upper bound of the range of contest phase columns (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contest phase columns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestPhaseColumn> findByContestPhasePK(
        long ContestPhasePK, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContestPhasePK(ContestPhasePK, start, end,
            orderByComparator);
    }

    /**
    * Returns the first contest phase column in the ordered set where ContestPhasePK = &#63;.
    *
    * @param ContestPhasePK the contest phase p k
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contest phase column
    * @throws com.ext.portlet.NoSuchContestPhaseColumnException if a matching contest phase column could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestPhaseColumn findByContestPhasePK_First(
        long ContestPhasePK,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchContestPhaseColumnException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContestPhasePK_First(ContestPhasePK, orderByComparator);
    }

    /**
    * Returns the first contest phase column in the ordered set where ContestPhasePK = &#63;.
    *
    * @param ContestPhasePK the contest phase p k
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contest phase column, or <code>null</code> if a matching contest phase column could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestPhaseColumn fetchByContestPhasePK_First(
        long ContestPhasePK,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContestPhasePK_First(ContestPhasePK,
            orderByComparator);
    }

    /**
    * Returns the last contest phase column in the ordered set where ContestPhasePK = &#63;.
    *
    * @param ContestPhasePK the contest phase p k
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contest phase column
    * @throws com.ext.portlet.NoSuchContestPhaseColumnException if a matching contest phase column could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestPhaseColumn findByContestPhasePK_Last(
        long ContestPhasePK,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchContestPhaseColumnException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContestPhasePK_Last(ContestPhasePK, orderByComparator);
    }

    /**
    * Returns the last contest phase column in the ordered set where ContestPhasePK = &#63;.
    *
    * @param ContestPhasePK the contest phase p k
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contest phase column, or <code>null</code> if a matching contest phase column could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestPhaseColumn fetchByContestPhasePK_Last(
        long ContestPhasePK,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContestPhasePK_Last(ContestPhasePK, orderByComparator);
    }

    /**
    * Returns the contest phase columns before and after the current contest phase column in the ordered set where ContestPhasePK = &#63;.
    *
    * @param id the primary key of the current contest phase column
    * @param ContestPhasePK the contest phase p k
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contest phase column
    * @throws com.ext.portlet.NoSuchContestPhaseColumnException if a contest phase column with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestPhaseColumn[] findByContestPhasePK_PrevAndNext(
        long id, long ContestPhasePK,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchContestPhaseColumnException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContestPhasePK_PrevAndNext(id, ContestPhasePK,
            orderByComparator);
    }

    /**
    * Removes all the contest phase columns where ContestPhasePK = &#63; from the database.
    *
    * @param ContestPhasePK the contest phase p k
    * @throws SystemException if a system exception occurred
    */
    public static void removeByContestPhasePK(long ContestPhasePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByContestPhasePK(ContestPhasePK);
    }

    /**
    * Returns the number of contest phase columns where ContestPhasePK = &#63;.
    *
    * @param ContestPhasePK the contest phase p k
    * @return the number of matching contest phase columns
    * @throws SystemException if a system exception occurred
    */
    public static int countByContestPhasePK(long ContestPhasePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByContestPhasePK(ContestPhasePK);
    }

    /**
    * Caches the contest phase column in the entity cache if it is enabled.
    *
    * @param contestPhaseColumn the contest phase column
    */
    public static void cacheResult(
        com.ext.portlet.model.ContestPhaseColumn contestPhaseColumn) {
        getPersistence().cacheResult(contestPhaseColumn);
    }

    /**
    * Caches the contest phase columns in the entity cache if it is enabled.
    *
    * @param contestPhaseColumns the contest phase columns
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.ContestPhaseColumn> contestPhaseColumns) {
        getPersistence().cacheResult(contestPhaseColumns);
    }

    /**
    * Creates a new contest phase column with the primary key. Does not add the contest phase column to the database.
    *
    * @param id the primary key for the new contest phase column
    * @return the new contest phase column
    */
    public static com.ext.portlet.model.ContestPhaseColumn create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the contest phase column with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the contest phase column
    * @return the contest phase column that was removed
    * @throws com.ext.portlet.NoSuchContestPhaseColumnException if a contest phase column with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestPhaseColumn remove(long id)
        throws com.ext.portlet.NoSuchContestPhaseColumnException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.ext.portlet.model.ContestPhaseColumn updateImpl(
        com.ext.portlet.model.ContestPhaseColumn contestPhaseColumn)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(contestPhaseColumn);
    }

    /**
    * Returns the contest phase column with the primary key or throws a {@link com.ext.portlet.NoSuchContestPhaseColumnException} if it could not be found.
    *
    * @param id the primary key of the contest phase column
    * @return the contest phase column
    * @throws com.ext.portlet.NoSuchContestPhaseColumnException if a contest phase column with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestPhaseColumn findByPrimaryKey(
        long id)
        throws com.ext.portlet.NoSuchContestPhaseColumnException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the contest phase column with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the contest phase column
    * @return the contest phase column, or <code>null</code> if a contest phase column with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.ContestPhaseColumn fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the contest phase columns.
    *
    * @return the contest phase columns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestPhaseColumn> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the contest phase columns.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestPhaseColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contest phase columns
    * @param end the upper bound of the range of contest phase columns (not inclusive)
    * @return the range of contest phase columns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestPhaseColumn> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the contest phase columns.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ContestPhaseColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contest phase columns
    * @param end the upper bound of the range of contest phase columns (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of contest phase columns
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.ContestPhaseColumn> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the contest phase columns from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of contest phase columns.
    *
    * @return the number of contest phase columns
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ContestPhaseColumnPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ContestPhaseColumnPersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    ContestPhaseColumnPersistence.class.getName());

            ReferenceRegistry.registerReference(ContestPhaseColumnUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ContestPhaseColumnPersistence persistence) {
    }
}

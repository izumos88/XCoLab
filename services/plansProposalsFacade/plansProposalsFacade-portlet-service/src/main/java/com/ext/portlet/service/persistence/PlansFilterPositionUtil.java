package com.ext.portlet.service.persistence;

import com.ext.portlet.model.PlansFilterPosition;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the plans filter position service. This utility wraps {@link PlansFilterPositionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlansFilterPositionPersistence
 * @see PlansFilterPositionPersistenceImpl
 * @generated
 */
public class PlansFilterPositionUtil {
    private static PlansFilterPositionPersistence _persistence;

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
    public static void clearCache(PlansFilterPosition plansFilterPosition) {
        getPersistence().clearCache(plansFilterPosition);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<PlansFilterPosition> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<PlansFilterPosition> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<PlansFilterPosition> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static PlansFilterPosition update(
        PlansFilterPosition plansFilterPosition, boolean merge)
        throws SystemException {
        return getPersistence().update(plansFilterPosition, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static PlansFilterPosition update(
        PlansFilterPosition plansFilterPosition, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(plansFilterPosition, merge, serviceContext);
    }

    /**
    * Caches the plans filter position in the entity cache if it is enabled.
    *
    * @param plansFilterPosition the plans filter position
    */
    public static void cacheResult(
        com.ext.portlet.model.PlansFilterPosition plansFilterPosition) {
        getPersistence().cacheResult(plansFilterPosition);
    }

    /**
    * Caches the plans filter positions in the entity cache if it is enabled.
    *
    * @param plansFilterPositions the plans filter positions
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.PlansFilterPosition> plansFilterPositions) {
        getPersistence().cacheResult(plansFilterPositions);
    }

    /**
    * Creates a new plans filter position with the primary key. Does not add the plans filter position to the database.
    *
    * @param plansFilterPositionPK the primary key for the new plans filter position
    * @return the new plans filter position
    */
    public static com.ext.portlet.model.PlansFilterPosition create(
        PlansFilterPositionPK plansFilterPositionPK) {
        return getPersistence().create(plansFilterPositionPK);
    }

    /**
    * Removes the plans filter position with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param plansFilterPositionPK the primary key of the plans filter position
    * @return the plans filter position that was removed
    * @throws com.ext.portlet.NoSuchPlansFilterPositionException if a plans filter position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansFilterPosition remove(
        PlansFilterPositionPK plansFilterPositionPK)
        throws com.ext.portlet.NoSuchPlansFilterPositionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(plansFilterPositionPK);
    }

    public static com.ext.portlet.model.PlansFilterPosition updateImpl(
        com.ext.portlet.model.PlansFilterPosition plansFilterPosition,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(plansFilterPosition, merge);
    }

    /**
    * Returns the plans filter position with the primary key or throws a {@link com.ext.portlet.NoSuchPlansFilterPositionException} if it could not be found.
    *
    * @param plansFilterPositionPK the primary key of the plans filter position
    * @return the plans filter position
    * @throws com.ext.portlet.NoSuchPlansFilterPositionException if a plans filter position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansFilterPosition findByPrimaryKey(
        PlansFilterPositionPK plansFilterPositionPK)
        throws com.ext.portlet.NoSuchPlansFilterPositionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(plansFilterPositionPK);
    }

    /**
    * Returns the plans filter position with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param plansFilterPositionPK the primary key of the plans filter position
    * @return the plans filter position, or <code>null</code> if a plans filter position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansFilterPosition fetchByPrimaryKey(
        PlansFilterPositionPK plansFilterPositionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(plansFilterPositionPK);
    }

    /**
    * Returns all the plans filter positions where userId = &#63; and planTypeId = &#63;.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @return the matching plans filter positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlansFilterPosition> findByUserIdPlanTypeId(
        long userId, long planTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserIdPlanTypeId(userId, planTypeId);
    }

    /**
    * Returns a range of all the plans filter positions where userId = &#63; and planTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @param start the lower bound of the range of plans filter positions
    * @param end the upper bound of the range of plans filter positions (not inclusive)
    * @return the range of matching plans filter positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlansFilterPosition> findByUserIdPlanTypeId(
        long userId, long planTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdPlanTypeId(userId, planTypeId, start, end);
    }

    /**
    * Returns an ordered range of all the plans filter positions where userId = &#63; and planTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @param start the lower bound of the range of plans filter positions
    * @param end the upper bound of the range of plans filter positions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching plans filter positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlansFilterPosition> findByUserIdPlanTypeId(
        long userId, long planTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdPlanTypeId(userId, planTypeId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first plans filter position in the ordered set where userId = &#63; and planTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching plans filter position
    * @throws com.ext.portlet.NoSuchPlansFilterPositionException if a matching plans filter position could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansFilterPosition findByUserIdPlanTypeId_First(
        long userId, long planTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlansFilterPositionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdPlanTypeId_First(userId, planTypeId,
            orderByComparator);
    }

    /**
    * Returns the last plans filter position in the ordered set where userId = &#63; and planTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching plans filter position
    * @throws com.ext.portlet.NoSuchPlansFilterPositionException if a matching plans filter position could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansFilterPosition findByUserIdPlanTypeId_Last(
        long userId, long planTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlansFilterPositionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdPlanTypeId_Last(userId, planTypeId,
            orderByComparator);
    }

    /**
    * Returns the plans filter positions before and after the current plans filter position in the ordered set where userId = &#63; and planTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param plansFilterPositionPK the primary key of the current plans filter position
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next plans filter position
    * @throws com.ext.portlet.NoSuchPlansFilterPositionException if a plans filter position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansFilterPosition[] findByUserIdPlanTypeId_PrevAndNext(
        PlansFilterPositionPK plansFilterPositionPK, long userId,
        long planTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlansFilterPositionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdPlanTypeId_PrevAndNext(plansFilterPositionPK,
            userId, planTypeId, orderByComparator);
    }

    /**
    * Returns all the plans filter positions.
    *
    * @return the plans filter positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlansFilterPosition> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the plans filter positions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of plans filter positions
    * @param end the upper bound of the range of plans filter positions (not inclusive)
    * @return the range of plans filter positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlansFilterPosition> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the plans filter positions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of plans filter positions
    * @param end the upper bound of the range of plans filter positions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of plans filter positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlansFilterPosition> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the plans filter positions where userId = &#63; and planTypeId = &#63; from the database.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserIdPlanTypeId(long userId, long planTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserIdPlanTypeId(userId, planTypeId);
    }

    /**
    * Removes all the plans filter positions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of plans filter positions where userId = &#63; and planTypeId = &#63;.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @return the number of matching plans filter positions
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserIdPlanTypeId(long userId, long planTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserIdPlanTypeId(userId, planTypeId);
    }

    /**
    * Returns the number of plans filter positions.
    *
    * @return the number of plans filter positions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PlansFilterPositionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PlansFilterPositionPersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    PlansFilterPositionPersistence.class.getName());

            ReferenceRegistry.registerReference(PlansFilterPositionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(PlansFilterPositionPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(PlansFilterPositionUtil.class,
            "_persistence");
    }
}
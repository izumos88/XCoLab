package com.ext.portlet.service.persistence;

import com.ext.portlet.model.OntologySpace;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the ontology space service. This utility wraps {@link OntologySpacePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OntologySpacePersistence
 * @see OntologySpacePersistenceImpl
 * @generated
 */
public class OntologySpaceUtil {
    private static OntologySpacePersistence _persistence;

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
    public static void clearCache(OntologySpace ontologySpace) {
        getPersistence().clearCache(ontologySpace);
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
    public static List<OntologySpace> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<OntologySpace> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<OntologySpace> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static OntologySpace update(OntologySpace ontologySpace)
        throws SystemException {
        return getPersistence().update(ontologySpace);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static OntologySpace update(OntologySpace ontologySpace,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(ontologySpace, serviceContext);
    }

    /**
    * Returns the ontology space where name = &#63; or throws a {@link com.ext.portlet.NoSuchOntologySpaceException} if it could not be found.
    *
    * @param name the name
    * @return the matching ontology space
    * @throws com.ext.portlet.NoSuchOntologySpaceException if a matching ontology space could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.OntologySpace findByName(
        java.lang.String name)
        throws com.ext.portlet.NoSuchOntologySpaceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByName(name);
    }

    /**
    * Returns the ontology space where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching ontology space, or <code>null</code> if a matching ontology space could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.OntologySpace fetchByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(name);
    }

    /**
    * Returns the ontology space where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching ontology space, or <code>null</code> if a matching ontology space could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.OntologySpace fetchByName(
        java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(name, retrieveFromCache);
    }

    /**
    * Removes the ontology space where name = &#63; from the database.
    *
    * @param name the name
    * @return the ontology space that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.OntologySpace removeByName(
        java.lang.String name)
        throws com.ext.portlet.NoSuchOntologySpaceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByName(name);
    }

    /**
    * Returns the number of ontology spaces where name = &#63;.
    *
    * @param name the name
    * @return the number of matching ontology spaces
    * @throws SystemException if a system exception occurred
    */
    public static int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByName(name);
    }

    /**
    * Caches the ontology space in the entity cache if it is enabled.
    *
    * @param ontologySpace the ontology space
    */
    public static void cacheResult(
        com.ext.portlet.model.OntologySpace ontologySpace) {
        getPersistence().cacheResult(ontologySpace);
    }

    /**
    * Caches the ontology spaces in the entity cache if it is enabled.
    *
    * @param ontologySpaces the ontology spaces
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.OntologySpace> ontologySpaces) {
        getPersistence().cacheResult(ontologySpaces);
    }

    /**
    * Creates a new ontology space with the primary key. Does not add the ontology space to the database.
    *
    * @param id the primary key for the new ontology space
    * @return the new ontology space
    */
    public static com.ext.portlet.model.OntologySpace create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the ontology space with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the ontology space
    * @return the ontology space that was removed
    * @throws com.ext.portlet.NoSuchOntologySpaceException if a ontology space with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.OntologySpace remove(long id)
        throws com.ext.portlet.NoSuchOntologySpaceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.ext.portlet.model.OntologySpace updateImpl(
        com.ext.portlet.model.OntologySpace ontologySpace)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(ontologySpace);
    }

    /**
    * Returns the ontology space with the primary key or throws a {@link com.ext.portlet.NoSuchOntologySpaceException} if it could not be found.
    *
    * @param id the primary key of the ontology space
    * @return the ontology space
    * @throws com.ext.portlet.NoSuchOntologySpaceException if a ontology space with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.OntologySpace findByPrimaryKey(long id)
        throws com.ext.portlet.NoSuchOntologySpaceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the ontology space with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the ontology space
    * @return the ontology space, or <code>null</code> if a ontology space with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.OntologySpace fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the ontology spaces.
    *
    * @return the ontology spaces
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.OntologySpace> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the ontology spaces.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.OntologySpaceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of ontology spaces
    * @param end the upper bound of the range of ontology spaces (not inclusive)
    * @return the range of ontology spaces
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.OntologySpace> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the ontology spaces.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.OntologySpaceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of ontology spaces
    * @param end the upper bound of the range of ontology spaces (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of ontology spaces
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.OntologySpace> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the ontology spaces from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of ontology spaces.
    *
    * @return the number of ontology spaces
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static OntologySpacePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (OntologySpacePersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    OntologySpacePersistence.class.getName());

            ReferenceRegistry.registerReference(OntologySpaceUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(OntologySpacePersistence persistence) {
    }
}

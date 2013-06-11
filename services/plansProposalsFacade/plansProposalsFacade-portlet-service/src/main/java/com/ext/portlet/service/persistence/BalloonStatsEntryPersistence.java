package com.ext.portlet.service.persistence;

import com.ext.portlet.model.BalloonStatsEntry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the balloon stats entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BalloonStatsEntryPersistenceImpl
 * @see BalloonStatsEntryUtil
 * @generated
 */
public interface BalloonStatsEntryPersistence extends BasePersistence<BalloonStatsEntry> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BalloonStatsEntryUtil} to access the balloon stats entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the balloon stats entry in the entity cache if it is enabled.
    *
    * @param balloonStatsEntry the balloon stats entry
    */
    public void cacheResult(
        com.ext.portlet.model.BalloonStatsEntry balloonStatsEntry);

    /**
    * Caches the balloon stats entries in the entity cache if it is enabled.
    *
    * @param balloonStatsEntries the balloon stats entries
    */
    public void cacheResult(
        java.util.List<com.ext.portlet.model.BalloonStatsEntry> balloonStatsEntries);

    /**
    * Creates a new balloon stats entry with the primary key. Does not add the balloon stats entry to the database.
    *
    * @param id the primary key for the new balloon stats entry
    * @return the new balloon stats entry
    */
    public com.ext.portlet.model.BalloonStatsEntry create(long id);

    /**
    * Removes the balloon stats entry with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the balloon stats entry
    * @return the balloon stats entry that was removed
    * @throws com.ext.portlet.NoSuchBalloonStatsEntryException if a balloon stats entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.BalloonStatsEntry remove(long id)
        throws com.ext.portlet.NoSuchBalloonStatsEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.ext.portlet.model.BalloonStatsEntry updateImpl(
        com.ext.portlet.model.BalloonStatsEntry balloonStatsEntry, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the balloon stats entry with the primary key or throws a {@link com.ext.portlet.NoSuchBalloonStatsEntryException} if it could not be found.
    *
    * @param id the primary key of the balloon stats entry
    * @return the balloon stats entry
    * @throws com.ext.portlet.NoSuchBalloonStatsEntryException if a balloon stats entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.BalloonStatsEntry findByPrimaryKey(long id)
        throws com.ext.portlet.NoSuchBalloonStatsEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the balloon stats entry with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the balloon stats entry
    * @return the balloon stats entry, or <code>null</code> if a balloon stats entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.BalloonStatsEntry fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the balloon stats entries.
    *
    * @return the balloon stats entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.BalloonStatsEntry> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the balloon stats entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of balloon stats entries
    * @param end the upper bound of the range of balloon stats entries (not inclusive)
    * @return the range of balloon stats entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.BalloonStatsEntry> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the balloon stats entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of balloon stats entries
    * @param end the upper bound of the range of balloon stats entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of balloon stats entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.BalloonStatsEntry> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the balloon stats entries from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of balloon stats entries.
    *
    * @return the number of balloon stats entries
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
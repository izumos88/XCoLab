package com.ext.portlet.service.persistence;

import com.ext.portlet.model.ProposalReference;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the proposal reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalReferencePersistenceImpl
 * @see ProposalReferenceUtil
 * @generated
 */
public interface ProposalReferencePersistence extends BasePersistence<ProposalReference> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ProposalReferenceUtil} to access the proposal reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the proposal references where proposalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @return the matching proposal references
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalReference> findByProposalId(
        long proposalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the proposal references where proposalId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param proposalId the proposal ID
    * @param start the lower bound of the range of proposal references
    * @param end the upper bound of the range of proposal references (not inclusive)
    * @return the range of matching proposal references
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalReference> findByProposalId(
        long proposalId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the proposal references where proposalId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param proposalId the proposal ID
    * @param start the lower bound of the range of proposal references
    * @param end the upper bound of the range of proposal references (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching proposal references
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalReference> findByProposalId(
        long proposalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposal reference in the ordered set where proposalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposal reference
    * @throws com.ext.portlet.NoSuchProposalReferenceException if a matching proposal reference could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference findByProposalId_First(
        long proposalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalReferenceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposal reference in the ordered set where proposalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposal reference, or <code>null</code> if a matching proposal reference could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference fetchByProposalId_First(
        long proposalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposal reference in the ordered set where proposalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposal reference
    * @throws com.ext.portlet.NoSuchProposalReferenceException if a matching proposal reference could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference findByProposalId_Last(
        long proposalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalReferenceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposal reference in the ordered set where proposalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposal reference, or <code>null</code> if a matching proposal reference could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference fetchByProposalId_Last(
        long proposalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal references before and after the current proposal reference in the ordered set where proposalId = &#63;.
    *
    * @param proposalReferencePK the primary key of the current proposal reference
    * @param proposalId the proposal ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next proposal reference
    * @throws com.ext.portlet.NoSuchProposalReferenceException if a proposal reference with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference[] findByProposalId_PrevAndNext(
        ProposalReferencePK proposalReferencePK, long proposalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalReferenceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the proposal references where proposalId = &#63; from the database.
    *
    * @param proposalId the proposal ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByProposalId(long proposalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of proposal references where proposalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @return the number of matching proposal references
    * @throws SystemException if a system exception occurred
    */
    public int countByProposalId(long proposalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the proposal references where subProposalId = &#63;.
    *
    * @param subProposalId the sub proposal ID
    * @return the matching proposal references
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalReference> findBySubProposalId(
        long subProposalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the proposal references where subProposalId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param subProposalId the sub proposal ID
    * @param start the lower bound of the range of proposal references
    * @param end the upper bound of the range of proposal references (not inclusive)
    * @return the range of matching proposal references
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalReference> findBySubProposalId(
        long subProposalId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the proposal references where subProposalId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param subProposalId the sub proposal ID
    * @param start the lower bound of the range of proposal references
    * @param end the upper bound of the range of proposal references (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching proposal references
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalReference> findBySubProposalId(
        long subProposalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposal reference in the ordered set where subProposalId = &#63;.
    *
    * @param subProposalId the sub proposal ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposal reference
    * @throws com.ext.portlet.NoSuchProposalReferenceException if a matching proposal reference could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference findBySubProposalId_First(
        long subProposalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalReferenceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposal reference in the ordered set where subProposalId = &#63;.
    *
    * @param subProposalId the sub proposal ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposal reference, or <code>null</code> if a matching proposal reference could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference fetchBySubProposalId_First(
        long subProposalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposal reference in the ordered set where subProposalId = &#63;.
    *
    * @param subProposalId the sub proposal ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposal reference
    * @throws com.ext.portlet.NoSuchProposalReferenceException if a matching proposal reference could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference findBySubProposalId_Last(
        long subProposalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalReferenceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposal reference in the ordered set where subProposalId = &#63;.
    *
    * @param subProposalId the sub proposal ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposal reference, or <code>null</code> if a matching proposal reference could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference fetchBySubProposalId_Last(
        long subProposalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal references before and after the current proposal reference in the ordered set where subProposalId = &#63;.
    *
    * @param proposalReferencePK the primary key of the current proposal reference
    * @param subProposalId the sub proposal ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next proposal reference
    * @throws com.ext.portlet.NoSuchProposalReferenceException if a proposal reference with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference[] findBySubProposalId_PrevAndNext(
        ProposalReferencePK proposalReferencePK, long subProposalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalReferenceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the proposal references where subProposalId = &#63; from the database.
    *
    * @param subProposalId the sub proposal ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBySubProposalId(long subProposalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of proposal references where subProposalId = &#63;.
    *
    * @param subProposalId the sub proposal ID
    * @return the number of matching proposal references
    * @throws SystemException if a system exception occurred
    */
    public int countBySubProposalId(long subProposalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the proposal reference in the entity cache if it is enabled.
    *
    * @param proposalReference the proposal reference
    */
    public void cacheResult(
        com.ext.portlet.model.ProposalReference proposalReference);

    /**
    * Caches the proposal references in the entity cache if it is enabled.
    *
    * @param proposalReferences the proposal references
    */
    public void cacheResult(
        java.util.List<com.ext.portlet.model.ProposalReference> proposalReferences);

    /**
    * Creates a new proposal reference with the primary key. Does not add the proposal reference to the database.
    *
    * @param proposalReferencePK the primary key for the new proposal reference
    * @return the new proposal reference
    */
    public com.ext.portlet.model.ProposalReference create(
        ProposalReferencePK proposalReferencePK);

    /**
    * Removes the proposal reference with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param proposalReferencePK the primary key of the proposal reference
    * @return the proposal reference that was removed
    * @throws com.ext.portlet.NoSuchProposalReferenceException if a proposal reference with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference remove(
        ProposalReferencePK proposalReferencePK)
        throws com.ext.portlet.NoSuchProposalReferenceException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.ext.portlet.model.ProposalReference updateImpl(
        com.ext.portlet.model.ProposalReference proposalReference)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal reference with the primary key or throws a {@link com.ext.portlet.NoSuchProposalReferenceException} if it could not be found.
    *
    * @param proposalReferencePK the primary key of the proposal reference
    * @return the proposal reference
    * @throws com.ext.portlet.NoSuchProposalReferenceException if a proposal reference with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference findByPrimaryKey(
        ProposalReferencePK proposalReferencePK)
        throws com.ext.portlet.NoSuchProposalReferenceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal reference with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param proposalReferencePK the primary key of the proposal reference
    * @return the proposal reference, or <code>null</code> if a proposal reference with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalReference fetchByPrimaryKey(
        ProposalReferencePK proposalReferencePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the proposal references.
    *
    * @return the proposal references
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalReference> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the proposal references.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of proposal references
    * @param end the upper bound of the range of proposal references (not inclusive)
    * @return the range of proposal references
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalReference> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the proposal references.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of proposal references
    * @param end the upper bound of the range of proposal references (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of proposal references
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalReference> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the proposal references from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of proposal references.
    *
    * @return the number of proposal references
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

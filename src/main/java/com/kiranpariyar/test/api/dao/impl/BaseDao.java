package com.kiranpariyar.test.api.dao.impl;

import com.kiranpariyar.test.api.dao.CrudDao;
import com.kiranpariyar.test.api.exception.DataAccessException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class BaseDao<T, Pk> implements CrudDao<T, Pk> {

    @Inject
    protected EntityManager em;

    protected Class<T> entityClass;

    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lftechnology.remittance.dao.CrudDao#save(java.lang.Object)
     */
    @Override
    public T save(T entity) {
        try {
            em.persist(entity);
            em.flush();
            em.refresh(entity);
        } catch (PersistenceException persistenceException) {
            throw new DataAccessException(persistenceException.getMessage());
        }
        return entity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lftechnology.remittance.dao.CrudDao#update(java.lang.Object)
     */
    @Override
    public T update(T entity) {
        try {
            entity = em.merge(entity);
            em.flush();
            em.refresh(entity);
        } catch (PersistenceException persistenceException) {
            throw new DataAccessException(persistenceException.getMessage());
        }
        return entity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lftechnology.remittance.dao.CrudDao#remove(java.lang.Object)
     */
    @Override
    public void remove(T entity) {
        try {
            em.remove(entity);
            em.flush();
        } catch (PersistenceException persistenceException) {
            throw new DataAccessException(persistenceException.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lftechnology.remittance.dao.CrudDao#removeById(java.lang.Object)
     */
    @Override
    public void removeById(Pk id) {
        try {
            T entity = em.getReference(entityClass, id);
            em.remove(entity);
            em.flush();
        } catch (PersistenceException persistenceException) {
            throw new DataAccessException(persistenceException.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lftechnology.remittance.dao.CrudDao#findById(java.lang.Object)
     */
    @Override
    public T findById(Pk id) {
        return em.find(entityClass, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lftechnology.remittance.dao.CrudDao#findByFilter()
     */
    @Override
    public List<T> findByFilter() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> from = criteriaQuery.from(entityClass);
        CriteriaQuery<T> select = criteriaQuery.select(from);
        TypedQuery<T> typedQuery = em.createQuery(select);
        return typedQuery.getResultList();
    }

}

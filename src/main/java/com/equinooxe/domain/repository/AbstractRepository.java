
/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of Equinooxe Project
 */
package com.equinooxe.domain.repository;

/**
 *
 * @author mboullouz
 */
import com.equinooxe.domain.utils.HibernateUtil;
import com.equinooxe.domain.viewmodels.SimpleResponseObjectWrapper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Generic and common operations to all repositories
 *
 * @author mboullouz
 * @param <T> Entity type
 */
public abstract class AbstractRepository<T> implements Repository<T> {

    private Class<T> entityClass;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public EntityManager getEntityManager() {
        return HibernateUtil.getEntityManager();
    }

    /**
     *
     * @param entity
     * @throws DatabaseOperationGenericException
     */
    @Override
    public void create(T entity) throws WebApplicationException {
        if (!getEntityManager().getTransaction().isActive()) {
            getEntityManager().getTransaction().begin();
        }
        getEntityManager().persist(entity);
        try {
            /**
             * We may flush there as well
             */
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new WebApplicationException(
                    " Db Error! " + e.getMessage(),
                    Response.status(Response.Status.BAD_REQUEST)
                    .entity(new SimpleResponseObjectWrapper("Can't save the new record! " + e.getMessage(), 0)).build());
        }

    }

    @Override
    public void edit(T entity) {
        if (!getEntityManager().getTransaction().isActive()) {
            getEntityManager().getTransaction().begin();
        }
        getEntityManager().merge(entity);
        try {
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new WebApplicationException(" Db Error! " + e.getMessage(),
                    Response.status(Response.Status.BAD_REQUEST)
                    .entity(new SimpleResponseObjectWrapper("Can't edit the record! " + e.getMessage(), 0)).build());
        }
    }

    @Override
    public void remove(T entity) {
        if (!getEntityManager().getTransaction().isActive()) {
            getEntityManager().getTransaction().begin();
        }
        getEntityManager().remove(getEntityManager().merge(entity));
        try {
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new WebApplicationException(" Db Error! " + e.getMessage(),
                    Response.status(Response.Status.BAD_REQUEST)
                    .entity(new SimpleResponseObjectWrapper("Can't delete the record! " + e.getMessage(), 0)).build());
        }
    }

    @Override
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(criteriaQuery);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return (List<T>) q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = criteriaQuery.from(entityClass);
        criteriaQuery.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(criteriaQuery);
        return ((Long) q.getSingleResult()).intValue();
    }

}

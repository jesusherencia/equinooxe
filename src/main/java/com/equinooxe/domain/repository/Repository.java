package com.equinooxe.domain.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;

public interface Repository<T> {
 
    EntityManager getEntityManager();
    public void create(T entity) throws WebApplicationException;
    public void edit(T entity);
    public void remove(T entity);
    public T find(Object id);
    public List<T> findAll();
}

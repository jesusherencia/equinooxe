package com.equinooxe.domain.repository;

import java.util.List;
import javax.persistence.EntityManager;

public interface Repository<T> {
 
    EntityManager getEntityManager();
    public void create(T entity);
    public void edit(T entity);
    public void remove(T entity);
    public T find(Object id);
    public List<T> findAll();
}

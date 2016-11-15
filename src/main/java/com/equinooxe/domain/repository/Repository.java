package com.equinooxe.domain.repository;

import com.equinooxe.domain.viewmodels.DeleteOperationResult;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;

public interface Repository<T> {

    EntityManager getEntityManager();

    T create(T entity) throws WebApplicationException;

    T edit(T entity);

    DeleteOperationResult remove(T entity);

    /**
     * Remove list of entities using a Hard or Soft removign stragey
     *
     * @param ids of entities to remove
     * @param hardRemove remove strategy
     * @return
     */
    DeleteOperationResult remove(Long[] ids, boolean hardRemove);

    T find(Object id);

    List<T> findAll();

    List<T> findAllNotMarkedDelete();

    List<T> findAllNotMarkedArchive();
    
    List<T> findBy(Map<String,Object> criterias);
}

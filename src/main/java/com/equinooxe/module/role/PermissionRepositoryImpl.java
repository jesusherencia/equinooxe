/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.repository.AbstractRepository;
import javax.persistence.EntityManager;

/**
 *
 * @author mboullouz
 */
public class PermissionRepositoryImpl extends AbstractRepository<Permission>{

    private EntityManager entityManager;

    public PermissionRepositoryImpl() {
        super(Permission.class);
        entityManager = getEntityManager();

    }
     
}

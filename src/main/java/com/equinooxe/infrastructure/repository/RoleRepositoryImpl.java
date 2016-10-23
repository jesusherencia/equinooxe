/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.infrastructure.repository;

import com.equinooxe.domain.Role;
import com.equinooxe.domain.repository.AbstractRepository;
import com.equinooxe.domain.repository.RoleRepository;
import javax.persistence.EntityManager;

/**
 *
 * @author mboullouz
 */
public class RoleRepositoryImpl extends AbstractRepository<Role> implements RoleRepository{

    private EntityManager entityManager;

    public RoleRepositoryImpl() {
        super(Role.class);
        entityManager = getEntityManager();

    }
    
}

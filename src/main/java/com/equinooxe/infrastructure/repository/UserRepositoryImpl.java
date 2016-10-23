/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;


import com.equinooxe.domain.Permission;
import com.equinooxe.domain.User;
import com.equinooxe.domain.repository.AbstractRepository;
import com.equinooxe.domain.repository.DatabaseOperationGenericException;
import com.equinooxe.domain.repository.UserRepository;
import com.equinooxe.domain.utils.PasswordGeneratorUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;

public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    private EntityManager entityManager;

    public UserRepositoryImpl() {
        super(User.class);
        entityManager = getEntityManager();

    }

    @Override
    public User findUserByEmail(String email) {
        return (User) entityManager.createQuery("Select u From User as u Where u.email= :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public User findUserByUsername(String username) throws DatabaseOperationGenericException {
        User user = null;
        try {
            user = (User) entityManager.createQuery("Select u From User as u Where u.username= :username")
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new DatabaseOperationGenericException("No single result. " + e.getMessage());
        }
        return user;
    }

    @Override
    public User createBasicUser(String email, String username, String password) {
        User user = new User();
        String[] hashAndSalt= PasswordGeneratorUtil.getSaltAndPasswordFor(password);
        user.setPassword(hashAndSalt[0]);
        user.setSalt(hashAndSalt[1]);
        user.setEmail(email);
        user.setUsername(username);
        try {
            create(user);
        } catch (DatabaseOperationGenericException ex) {
            Logger.getLogger(UserRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
   
    @Override
    public List<Permission> getAllByRoleName(String roleName) {
        List<Permission> permissions;
        permissions = entityManager.createQuery(
                " SELECT P FROM Permission as P, Role as R, RolePermission as RP"
                + " WHERE RP.role.id = R.id AND RP.permission.id=P.id AND R.name= :roleName ")
                .setParameter("roleName", roleName).getResultList();
        return permissions;
    }

}

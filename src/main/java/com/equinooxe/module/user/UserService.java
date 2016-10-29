/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.module.user;

import java.util.List;

import com.equinooxe.domain.User;
import java.util.Set;

/**
 *
 * @author ABCD-user
 */
public interface UserService {

    User getAuthentificatedUser();

    /**
     * 
     * @param email
     * @return 
     */
    User getUserByEmail(String email);
    
    /**
     * 
     * @param email
     * @param username
     * @param password
     * @return User
     */
    User registerBasicUser(String email, String username, String password);
    
    /**
     * Prepare registration for the client by populating an object with
     * required information to add a new registration
     * @return UserRegistrationVM
     */
    UserRegistrationViewModel prepareRegistrationViewModel();

    /**
     *
     * @param email
     * @param username
     * @param password
     * @param registrationType
     * @param rolesIds
     * @return
     */
    User register(String email, String username, String password, String registrationType, Set<Integer> rolesIds);
    
    /**
     * Call regisistration with params gathered in a pojo
     * @param userRegistrationVM
     * @return 
     */
    User register(UserRegistrationViewModel userRegistrationVM);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();

}

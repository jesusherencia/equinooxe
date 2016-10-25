/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.module.user;

import java.util.List;

import com.equinooxe.domain.User;
import com.equinooxe.module.user.UserRegistrationViewModel;

/**
 *
 * @author ABCD-user
 */
public interface UserService {

    User getAuthentificatedUser();

    User getUserByEmail(String email);

    User registerBasicUser(String email, String username, String password);

    /**
     *
     * @param email
     * @param username
     * @param password
     * @param registrationType
     * @param rolesIds
     * @return
     */
    User register(String email, String username, String password, String registrationType, Long[] rolesIds);
    
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

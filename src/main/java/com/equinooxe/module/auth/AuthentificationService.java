/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.module.auth;

import com.equinooxe.module.user.BasicUserAuthViewModel;

/**
 * BasicUserAuthViewModel: is an object used to login, it's a commodities to simplify
 serilization/deserialization as it's a simple POJO
 *
 * @author Mohamed
 */
public interface AuthentificationService {

    /**
     * Login using Apache Shiro framework a username (String) is added to the
     * Session so that it can be easily retrieved in the serialization
     * @param userAuthDto
     * @return
     */
    boolean login(BasicUserAuthViewModel userAuthDto);

    /**
     * Allow logout from the API Shiro remembers the authentificated user for
     * some amount of time @see shiro.ini
     */
    void logout();

    /**
     * Check if a user is auth by providing its credentials
     *
     * @param userAuthDto
     * @return
     */
    boolean checkUserAuth(BasicUserAuthViewModel userAuthDto);

    /**
     * Check user auth by email
     *
     * @param userEmail
     * @return
     */
    boolean checkUserAuthByEmail(String userEmail);

    String getUsernameOfCurrentUser();
}

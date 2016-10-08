/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;

import com.equinooxe.domain.User;
import com.equinooxe.infrastructure.repository.UserRepositoryImpl;
import com.equinooxe.service.UserService;

/**
 *
 * @author ABCD-user
 */
public class UserServiceImpl implements UserService {

    UserRepositoryImpl userRepository;

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public User getAuthentificatedUser() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            throw new UnauthenticatedException("Not currently authentificated");
        }
        return getUserByEmail(currentUser.getPrincipal().toString());
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User register(String email, String username, String password) {
        return userRepository.createUser(email, username, password);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findRange(int[] range) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int count() {   
        return 0;
    }
}

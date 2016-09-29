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
import com.equinooxe.domain.repository.UserRepository;
import com.equinooxe.infrastructure.repository.UserJpaRepository;
import com.equinooxe.service.UserService;

/**
 *
 * @author ABCD-user
 */
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	
    public UserServiceImpl() {
        userRepository = new UserJpaRepository();
    }

	public User getAuthentificatedUser() {
		Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            throw new UnauthenticatedException("Aucun utilisateur n'est authentifi� ");
        }
        return getUserByEmail(currentUser.getPrincipal().toString());
	}

	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	public User register(String email, String username, String password) {
		return userRepository.createUser(email, username, password);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findRange(int[] range) {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}

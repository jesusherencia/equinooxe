/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.service;

 
import java.util.List;

import com.equinooxe.domain.User;

/**
 *
 * @author ABCD-user
 */
public interface UserService {
    
    User getAuthentificatedUser();
    
    User getUserByEmail(String email);
    
    User register(String email,String username,String password);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();

 
   
    
}

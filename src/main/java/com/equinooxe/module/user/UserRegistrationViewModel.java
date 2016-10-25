/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.user;

/**
 *
 * @author mboullouz
 */
public class UserRegistrationViewModel {
    public String username;
    public String email;
    public String password;
    public String registrationType="BASIC";
    public Long[] roleIds= new Long[10];
}

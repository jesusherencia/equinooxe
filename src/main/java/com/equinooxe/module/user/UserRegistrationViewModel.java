/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.user;

import com.equinooxe.domain.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mboullouz
 */
public class UserRegistrationViewModel {
    public String username;
    public String email;
    public String password;
    public String registrationType="BASIC";
    public Set<Integer> roleIds= new HashSet<>();
    
    public List<Role> roles = new ArrayList<>();
}

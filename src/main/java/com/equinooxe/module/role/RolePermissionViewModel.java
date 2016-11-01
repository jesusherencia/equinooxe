/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.Role;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mboullouz
 */
public class RolePermissionViewModel {
    /**
     * Comes from the forms
     */
    public Set<String> newRoleNames = new HashSet<>();
    public Set<String> newPermissionNames = new HashSet<>();
    
    /**
     * Already existing roles and permissions
     */
    public Set<Role> roleEntities = new HashSet<>();
    public Set<Permission> permissionEntities = new HashSet<>();
}

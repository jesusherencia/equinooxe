/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mboullouz
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolePermissionViewModel {

    /**
     * Comes from the forms
     */
    private Set<Role> newRoles = new HashSet<>();

    private Set<Permission> newPermissions = new HashSet<>();

    /**
     * Already existing roles and permissions
     */
    private Set<Role> roleEntities = new HashSet<>();

    private Set<Permission> permissionEntities = new HashSet<>();

    public Set<Role> getNewRoles() {
        return newRoles;
    }

    public void setNewRoles(Set<Role> newRoles) {
        this.newRoles = newRoles;
    }

    public Set<Permission> getNewPermissions() {
        return newPermissions;
    }

    public void setNewPermissions(Set<Permission> newPermissions) {
        this.newPermissions = newPermissions;
    }

    public Set<Role> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(Set<Role> roleEntities) {
        this.roleEntities = roleEntities;
    }

    public Set<Permission> getPermissionEntities() {
        return permissionEntities;
    }

    public void setPermissionEntities(Set<Permission> permissionEntities) {
        this.permissionEntities = permissionEntities;
    }

}

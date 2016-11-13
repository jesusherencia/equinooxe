/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private List<Role> newRoles = new ArrayList<>();

    private List<Permission> newPermissions = new ArrayList<>();

    /**
     * Already existing roles and permissions
     */
    private List<Role> roleEntities = new ArrayList<>();

    private List<Permission> permissionEntities = new ArrayList<>();

    public List<Role> getNewRoles() {
        return newRoles;
    }

    public void setNewRoles(List<Role> newRoles) {
        this.newRoles = newRoles;
    }

    public List<Permission> getNewPermissions() {
        return newPermissions;
    }

    public void setNewPermissions(List<Permission> newPermissions) {
        this.newPermissions = newPermissions;
    }

    public List<Role> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(List<Role> roleEntities) {
        this.roleEntities = roleEntities;
    }

    public List<Permission> getPermissionEntities() {
        return permissionEntities;
    }

    public void setPermissionEntities(List<Permission> permissionEntities) {
        this.permissionEntities = permissionEntities;
    }
 
 
}

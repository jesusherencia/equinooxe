/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

import com.equinooxe.domain.viewmodels.SimpleDeleteObjectViewModel;

/**
 *
 * @author mboullouz
 */
public class RolePermissionDeleteViewModel {

    private SimpleDeleteObjectViewModel permissions;
    private SimpleDeleteObjectViewModel roles;

    public SimpleDeleteObjectViewModel getPermissions() {
        return permissions;
    }

    public void setPermissions(SimpleDeleteObjectViewModel permissions) {
        this.permissions = permissions;
    }

    public SimpleDeleteObjectViewModel getRoles() {
        return roles;
    }

    public void setRoles(SimpleDeleteObjectViewModel roles) {
        this.roles = roles;
    }

}

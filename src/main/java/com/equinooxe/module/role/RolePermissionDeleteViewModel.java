/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

import com.equinooxe.domain.viewmodels.SimpleDeleteViewModel;

/**
 *
 * @author mboullouz
 */
public class RolePermissionDeleteViewModel {

    private SimpleDeleteViewModel permissions;
    private SimpleDeleteViewModel roles;

    public SimpleDeleteViewModel getPermissions() {
        return permissions;
    }

    public void setPermissions(SimpleDeleteViewModel permissions) {
        this.permissions = permissions;
    }

    public SimpleDeleteViewModel getRoles() {
        return roles;
    }

    public void setRoles(SimpleDeleteViewModel roles) {
        this.roles = roles;
    }

}

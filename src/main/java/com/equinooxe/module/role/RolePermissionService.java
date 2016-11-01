/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

/**
 *
 * @author mboullouz
 */
public interface RolePermissionService {
    /**
     * Save roles and permissions from names 
     * @param rolePermissionVM RolePermissionViewModel
     * @return RolePermissionViewModel
     */
    RolePermissionViewModel save(RolePermissionViewModel rolePermissionVM);
    
    /**
     * Construct a RolePermissionViewModel from existing data
     * @return RolePermissionViewModel
     */
    RolePermissionViewModel prepare();
    
    
}

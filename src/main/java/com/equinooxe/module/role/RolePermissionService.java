/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

import com.equinooxe.domain.viewmodels.DeleteOperationResult;
import java.util.List;

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

    /**
     * Delte and collect some informations about the operation to give 
     * a feed back to client
     * @param vm
     * @return
     */
    List<DeleteOperationResult> delete(RolePermissionDeleteViewModel vm);
    
    
}

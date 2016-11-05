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
public class RolePermissionServiceImpl implements RolePermissionService {

    private RoleRepositoryImpl roleRepository = new RoleRepositoryImpl();
    private PermissionRepositoryImpl permissionRepository = new PermissionRepositoryImpl();

    @Override
    public RolePermissionViewModel save(RolePermissionViewModel rolePermissionVM) {
        Set<Role> roles = new HashSet<>();
        Set<Permission> permissions = new HashSet<>();
        if (rolePermissionVM.newRoles != null) {
            rolePermissionVM.newRoles.stream().forEach(roleVM -> {
                Role r = new Role(roleVM.getName());
               
                roles.add(r);
            });
        }
        roles.stream().forEach(role -> {
            roleRepository.create(role);
        });

        if (rolePermissionVM.newPermissions != null) {
            rolePermissionVM.newPermissions.stream().forEach(permissionVM -> {
                Permission permission = new Permission(permissionVM.getName());
                permissions.add(permission);
            });
        }
        roles.stream().forEach(role -> {
            roleRepository.create(role);
        });
        permissions.stream().forEach(permission -> {
            permissionRepository.create(permission);
        });

        rolePermissionVM.roleEntities = roles;
        rolePermissionVM.permissionEntities = permissions;

        return rolePermissionVM;
    }

    @Override
    public RolePermissionViewModel prepare() {
        RolePermissionViewModel vm = new RolePermissionViewModel();
        vm.roleEntities =   new HashSet( roleRepository.findAll());
        vm.permissionEntities =  new HashSet(  permissionRepository.findAll());
        return vm;
    }

}

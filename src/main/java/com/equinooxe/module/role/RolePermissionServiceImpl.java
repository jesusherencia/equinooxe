/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.Role;
import com.equinooxe.domain.viewmodels.DeleteOperationResult;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mboullouz
 */
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RoleRepositoryImpl roleRepository = new RoleRepositoryImpl();
    private final PermissionRepositoryImpl permissionRepository = new PermissionRepositoryImpl();

    @Override
    public RolePermissionViewModel save(RolePermissionViewModel rolePermissionVM) {
        List<Role> roles = new ArrayList<>();
        List<Permission> permissions = new ArrayList<>();
        if (rolePermissionVM.getNewRoles() != null) {
            rolePermissionVM.getNewRoles().stream().forEach(roleVM -> {
                Role r = new Role(roleVM.getName());
                roles.add(r);
            });
        }
        roles.stream().forEach(role -> {
            roleRepository.create(role);
        });

        if (rolePermissionVM.getNewPermissions() != null) {
            rolePermissionVM.getNewPermissions().stream().forEach(permissionVM -> {
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

        rolePermissionVM.setRoleEntities(roles);
        rolePermissionVM.setPermissionEntities(permissions);

        return rolePermissionVM;
    }

    @Override
    public RolePermissionViewModel prepare() {
        RolePermissionViewModel vm = new RolePermissionViewModel();
        vm.setRoleEntities( roleRepository.findAll() );
        vm.setPermissionEntities( permissionRepository.findAll());
        return vm;
    }

    @Override
    public List<DeleteOperationResult> delete(RolePermissionDeleteViewModel vm) {
        List<DeleteOperationResult> rsList = new ArrayList<>();
        rsList.add(roleRepository.remove(vm.getRoles().ids, vm.getRoles().hard));
        rsList.add(permissionRepository.remove(vm.getPermissions().ids, vm.getPermissions().hard));
        return rsList;
    }

}

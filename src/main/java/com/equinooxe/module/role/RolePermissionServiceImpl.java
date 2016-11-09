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

    private final RoleRepositoryImpl roleRepository = new RoleRepositoryImpl();
    private final PermissionRepositoryImpl permissionRepository = new PermissionRepositoryImpl();

    @Override
    public RolePermissionViewModel save(RolePermissionViewModel rolePermissionVM) {
        Set<Role> roles = new HashSet<>();
        Set<Permission> permissions = new HashSet<>();
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
        vm.setRoleEntities( new HashSet( roleRepository.findAll()));
        vm.setPermissionEntities(new HashSet(  permissionRepository.findAll()));
        return vm;
    }

    @Override
    public Object delete(RolePermissionDeleteViewModel vm) {
        for(Long id : vm.getRoles().ids){
            Role role = roleRepository.find(id);
           if(vm.getRoles().hard) {
               roleRepository.remove(roleRepository.find(id));
           }else {
               role.setIsDeleted(true);
           }
        }
        
        for(Long id : vm.getPermissions().ids){
            Permission permission= permissionRepository.find(id);
           if(vm.getPermissions().hard) {
               permissionRepository.remove(permissionRepository.find(id));
           }else {
               permission.setIsDeleted(true);
           }
        }
        
        roleRepository.getEntityManager().getTransaction().commit();
        
        return true;
    }

}

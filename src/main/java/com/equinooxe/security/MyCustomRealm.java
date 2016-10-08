/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */

package com.equinooxe.security;

 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.jdbc.JdbcRealm;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.User;
import com.equinooxe.domain.UserRole;
import com.equinooxe.infrastructure.repository.UserRepositoryImpl;

public class MyCustomRealm extends JdbcRealm {
    
    /* @todo We should simplify this mush more */
    UserRepositoryImpl userRepository;
	
    public MyCustomRealm() {
        userRepository =  new UserRepositoryImpl();
    }
     
    public User getUserByEmail(String email) {
    	return userRepository.findUserByEmail(email);
    }
    public User getUserByUsername(String username) {
    	return userRepository.findUserByUsername(username);
    }
    public List<Permission> getAllByRoleName(String roleName) {
    	return userRepository.getAllByRoleName(roleName);
    }
    
    @Override
    protected Set<String> getRoleNamesForUser(Connection conn, String username) throws SQLException {
        Set<String> roleNames = new LinkedHashSet<>();
        User user= getUserByEmail(username);
        Collection<UserRole> roles =user.getUserRoles();
        for(UserRole userRole:roles){
            roleNames.add(userRole.getRole().getName());
        }
        return roleNames;
    }
    
    @Override
    protected Set<String> getPermissions(Connection conn, String username, Collection<String> roleNames) throws SQLException {
        Set<String> permissionNames = new LinkedHashSet<>();
        for(String roleName:roleNames){
            List<Permission> permissionEntities = getAllByRoleName(roleName);
            for(Permission permissionEntity: permissionEntities){
                permissionNames.add(permissionEntity.getName());
            }
        }
        return permissionNames; 
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        // identify account to log to
        UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
        final String username = userPassToken.getUsername();

        if (username == null) {
            System.out.println("Username is null.");
            return null;
        }

        // read password hash and salt from db
        try {
            final User user =  getUserByUsername(username);
            if (user == null) {
                System.out.println("No account found for user [" + username + "]");
                return null;
            }
            // return salted credentials
            SaltedAuthenticationInfo info = new MySaltedAuthentificationInfo(
                    username, user.getPassword(), user.getSalt());
            return info;
        } catch(Exception e) {
        	e.printStackTrace();
        	return null;
        } finally {
            
        }

    }
 
     
}

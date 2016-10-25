/*
 * Copyright mohamedboullouz@gmail.com 
 * This file is part of equinooxe Project
 */
package com.equinooxe.module.user;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.ManagerUser;
import com.equinooxe.domain.Role;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;

import com.equinooxe.domain.User;
import com.equinooxe.domain.UserRole;
import com.equinooxe.domain.repository.AbstractRepository;
import com.equinooxe.domain.repository.DatabaseOperationGenericException;
import com.equinooxe.domain.utils.PasswordGeneratorUtil;
import com.equinooxe.domain.viewmodels.RegistrationType;
import com.equinooxe.module.user.UserRegistrationViewModel;
import com.equinooxe.infrastructure.repository.RoleRepositoryImpl;
import com.equinooxe.module.user.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mboullouz
 */
public class UserServiceImpl implements UserService {
    
    UserRepositoryImpl userRepository;
    
    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }
    
    @Override
    public User getAuthentificatedUser() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            throw new UnauthenticatedException("Not currently authentificated");
        }
        return getUserByEmail(currentUser.getPrincipal().toString());
    }
    
    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
    
    @Override
    public User registerBasicUser(String email, String username, String password) {
        return userRepository.createBasicUser(email, username, password);
    }
    
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    @Override
    public List<User> findRange(int[] range) {
        return userRepository.findRange(range);
    }
    
    @Override
    public int count() {
        return userRepository.count();
    }
    
    @Override
    public User register(UserRegistrationViewModel userRegistrationVM) {
        return this.register(
                userRegistrationVM.email,
                userRegistrationVM.username, 
                userRegistrationVM.password, 
                userRegistrationVM.registrationType, 
                userRegistrationVM.roleIds);
    }
    
    @Override
    public User register(String email, String username, String password, String registrationType, Long[] rolesIds) {
        Collection<UserRole> roles = new ArrayList<>();
        AbstractRepository<Role> roleRepo = new RoleRepositoryImpl();
        User user;
        for (Long id : rolesIds) {
            UserRole userRole = new UserRole();
            userRole.setRole(roleRepo.find(id));
            roles.add(userRole);
        }
        if (registrationType.equals(RegistrationType.AGENT.toString())) {
            // Register as agent
            user = new AgentUser();
        } else if (registrationType.equals(RegistrationType.MANAGER.toString())) {
            // Register a manager
            user = new ManagerUser();
        } else {
            //basic user to handle later in the workflow
            user = new User();
        }
        user.setUserRoles(roles);
        String[] hashAndSalt = PasswordGeneratorUtil.getSaltAndPasswordFor(password);
        user.setPassword(hashAndSalt[0]);
        user.setSalt(hashAndSalt[1]);
        user.setEmail(email);
        user.setUsername(username);
        try {
            userRepository.create(user);
        } catch (DatabaseOperationGenericException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
}

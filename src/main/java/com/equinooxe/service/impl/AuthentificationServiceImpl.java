/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.service.impl;


import com.equinooxe.module.user.BasicUserAuthDto;
import com.equinooxe.service.AuthentificationService;
import java.util.Arrays;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
 

/**
 *
 * @author Mohamed
 */
public class AuthentificationServiceImpl implements AuthentificationService{
    
    private  Subject currentUser = SecurityUtils.getSubject();

    public AuthentificationServiceImpl() {
    }
    
    @Override
    public void logout(){
        currentUser.logout();
    }
    
    @Override
    public boolean login(BasicUserAuthDto uAuthObject) {        
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(uAuthObject.getUsername(), uAuthObject.getPassword(), uAuthObject.isRememberMe());
            token.setRememberMe(uAuthObject.isRememberMe());
            try {
                currentUser.login(token);
                currentUser.getSession().setAttribute("username", token.getPrincipal());               
                return true;
            } catch (UnknownAccountException uae) {                
                System.out.println("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                System.out.println("Password for account " + token.getPrincipal()
                        + " was incorrect! \n\t Given: " + Arrays.toString(token.getPassword()));
            } catch (LockedAccountException lae) {
                System.out.println("The account for username " + token.getPrincipal() + " is locked.  "
                        + "Please contact your administrator to unlock it.");
            }
        } else {
            System.out.println("Auth success!");
            return true; // already logged in
        }
        return false;
    }

    @Override
    public boolean checkUserAuth(BasicUserAuthDto uAuthObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean checkUserAuthByEmail(String userEmail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getUsernameOfCurrentUser() {
        return currentUser.getPrincipal().toString();
    }
    
}

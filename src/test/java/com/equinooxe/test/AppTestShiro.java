package com.equinooxe.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppTestShiro {

    private static final transient Logger log = LoggerFactory.getLogger(AppTestShiro.class);

    public static void main(String[] args) {
        log.info("My First Apache Shiro Application");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("admin", "admin");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                // print their identifying principal (in this case, a username):
                log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  "
                        + "Please contact your administrator to unlock it.");
            } catch (AuthenticationException ae) {
                // unexpected condition - error?
                log.info("Error");
            }
        }
    }
}

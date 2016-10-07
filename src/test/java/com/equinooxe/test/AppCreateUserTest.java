package com.equinooxe.test;

import com.equinooxe.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.equinooxe.domain.repository.UserRepository;
import com.equinooxe.infrastructure.repository.UserJpaRepository;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppCreateUserTest {

    private static final transient Logger log = LoggerFactory.getLogger(AppCreateUserTest.class);
    UserRepository userRepository = new UserJpaRepository();
    String email = "a@a.com";

    @Test
    public void addUserViaJpaRepositoryTest() {
        log.info("My First Apache Shiro Application");
        //userRepository.createUser(email, "admin", "admin");
        User u = userRepository.findUserByEmail(email);
       // assertEquals(email,u.getEmail());
        User b = null;
        try {
            b = userRepository.findUserByEmail(email);
        } catch (Exception e) {
          
             System.out.println("b is null!");
        }
        assertEquals(null, b);

    }
//    
//    @Test
//    public void removeUserTest() {
//        User u = userRepository.findUserByEmail(email);
//        userRepository.remove(u);
//        User b = null;
//        try {
//            b = userRepository.findUserByEmail(email);
//        } catch (Exception e) {
//        }
//        assertEquals(null, b);
//    }

    @After
    public void tearDownClass() {
        System.out.println("Do some cleaning!");
    }
}

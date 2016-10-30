/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.domain.listener;

import com.equinooxe.domain.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 *
 * @author mboullouz
 */
public class UserEntityListener {

    private static final Logger log = java.util.logging.Logger.getLogger(UserEntityListener.class.getName());

    @PrePersist
    void onPrePersist(Object o) {
        User u = (User) o;
        log.log(Level.INFO, "{0} onPrePersist", " E:" + u.getEmail());
    }

    @PostPersist
    void onPostPersist(Object o) {
           log(o,"onPostPersist");
    }

    @PostLoad
    void onPostLoad(Object o) {
         log(o,"onPostLoad");
    }

    @PreUpdate
    void onPreUpdate(Object o) {
          log(o,"onPreUpdate");
    }

    @PostUpdate
    void onPostUpdate(Object o) {
          log(o,"onPostUpdate");
    }

    @PreRemove
    void onPreRemove(Object o) {
          log(o,"onPreRemove");
    }

    @PostRemove
    void onPostRemove(Object o) {
          log(o,"onPostRemove");
    }

    private void log(Object o,String op) {
        User u = (User) o;
        log.log(Level.INFO, "{0} ",op+ "Id: " + u.getId() + " E:" + u.getEmail());
    }
}

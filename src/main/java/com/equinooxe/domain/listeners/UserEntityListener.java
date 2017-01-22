/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.domain.listeners;

import com.equinooxe.domain.Notification;
import com.equinooxe.domain.User;
import com.equinooxe.repository.NotificationRepository;
import com.equinooxe.repository.UserRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
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

	@PrePersist
	void onPrePersist(Object o) {
	}
		 

	@PostPersist
	void onPostPersist(Object obj) {
		User user = (User) obj;
	}

	@PostLoad
	void onPostLoad(Object o) {
	}

	@PreUpdate
	void onPreUpdate(Object obj) {
		User user = (User) obj;
		 
	}

	@PostUpdate
	void onPostUpdate(Object obj) {
	
	}
	@PreRemove
	void onPreRemove(Object o) {
	}

	@PostRemove
	void onPostRemove(Object o) {
	}

	 
}

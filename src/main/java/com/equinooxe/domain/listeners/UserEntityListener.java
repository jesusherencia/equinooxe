/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.domain.listeners;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.equinooxe.domain.User;


/**
 * TODO remove and use AOP instead!
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

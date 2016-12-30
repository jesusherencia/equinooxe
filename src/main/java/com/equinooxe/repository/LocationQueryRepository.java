/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.Location;
import com.equinooxe.domain.QLocation;

/**
 * @author mboullouz
 *
 */
@Component
public class LocationQueryRepository extends AbstractQueryRespository<QLocation,Location> {
	@Autowired
	public LocationQueryRepository(EntityManager entityManager) {
		super(entityManager,QLocation.location);
	}
}

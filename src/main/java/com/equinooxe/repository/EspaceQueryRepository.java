/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.Espace;
import com.equinooxe.domain.QEspace;

/**
 * @author mboullouz
 *
 */
@Component
public class EspaceQueryRepository extends AbstractQueryRespository<QEspace,Espace> {
	@Autowired
	public EspaceQueryRepository(EntityManager entityManager) {
		super(entityManager,QEspace.espace);
	}
}

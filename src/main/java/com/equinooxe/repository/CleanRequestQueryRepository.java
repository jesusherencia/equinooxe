package com.equinooxe.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.CleanRequest;
import com.equinooxe.domain.QCleanRequest;

/**
 * 
 * @author mboullouz
 *
 */
@Component
public class CleanRequestQueryRepository extends AbstractQueryRespository<QCleanRequest, CleanRequest> {
	@Autowired
	public CleanRequestQueryRepository(EntityManager em ) {
		super(em, QCleanRequest.cleanRequest);
	}
 
}
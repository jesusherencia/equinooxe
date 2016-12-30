package com.equinooxe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.equinooxe.domain.AbstractAuditingEntity;
import com.equinooxe.domain.User;
import com.equinooxe.service.util.EqLogger;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.Predicate;


public abstract class AbstractQueryRespository<QE extends EntityPathBase<E >,E extends AbstractAuditingEntity> {
	protected QE qEntity;
	protected JPAQueryFactory queryFactory;
	protected EntityManager entityManager;
 
	public AbstractQueryRespository(EntityManager em, QE qEntity){
		EqLogger.set(AbstractQueryRespository.class);
		EqLogger.info(" AbstractQueryRespository ctor called! ");
		this.qEntity = qEntity;
		this.entityManager= em;
		queryFactory = new JPAQueryFactory(entityManager);
	}
	
	public List<E> getAll() { 
		return  queryFactory.selectFrom(qEntity).fetch();
	}
 
}

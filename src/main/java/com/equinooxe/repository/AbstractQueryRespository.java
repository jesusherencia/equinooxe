package com.equinooxe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.equinooxe.domain.AbstractAuditingEntity;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * 
 * @author mboullouz
 *
 * @param <QE> extends EntityPathBase<E>
 * @param <E>  extends AbstractAuditingEntity
 */
public abstract class AbstractQueryRespository<QE extends EntityPathBase<E>,E extends AbstractAuditingEntity> {
	protected QE qEntity;
	protected JPAQueryFactory queryFactory;
	protected EntityManager entityManager;
 
	public AbstractQueryRespository(EntityManager em, QE qEntity){
		this.qEntity = qEntity;
		this.entityManager= em;
		queryFactory = new JPAQueryFactory(entityManager);
	}
	
	public List<E> getAll() { 
		return  queryFactory.selectFrom(qEntity).fetch();
	}
 
}

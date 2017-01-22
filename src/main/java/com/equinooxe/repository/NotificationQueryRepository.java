package com.equinooxe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.equinooxe.domain.Notification;
import com.equinooxe.domain.QNotification;
import com.equinooxe.service.util.EqLogger;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class NotificationQueryRepository {
	protected QNotification qNotification= QNotification.notification;
	protected JPAQueryFactory queryFactory;
	protected EntityManager entityManager;
 
	@Autowired
	public NotificationQueryRepository(EntityManager entityManager) {
		EqLogger.set(AbstractQueryRespository.class);
		EqLogger.info(" AbstractQueryRespository ctor called! ");
		this.entityManager=  entityManager;
		queryFactory = new JPAQueryFactory(entityManager);
	}
	
	public List<Notification> getAll() { 
		return  queryFactory.selectFrom(qNotification).fetch();
	}
	public List<Notification>  getByUserId(Long userId) {
		return queryFactory.select(qNotification).where(qNotification.user.id.eq(userId)).fetch();
	}
}

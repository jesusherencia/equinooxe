package com.equinooxe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.Notification;
import com.equinooxe.domain.QNotification;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Component
public class NotificationQueryRepository {
	protected QNotification qNotification= QNotification.notification;
	protected JPAQueryFactory queryFactory;
	protected EntityManager entityManager;
 
	@Autowired
	public NotificationQueryRepository(EntityManager entityManager) {
		this.entityManager=  entityManager;
		queryFactory = new JPAQueryFactory(entityManager);
	}
	
	public List<Notification> getAll() { 
		return  queryFactory.selectFrom(qNotification).fetch();
	}
	public List<Notification>  getByUserId(Long userId) {
		return queryFactory.selectFrom(qNotification).where(qNotification.user.id.eq(userId)).fetch();
	}
	public List<Notification>  getByLogin(String login) {
		return queryFactory.selectFrom(qNotification).where(qNotification.user.login.eq(login)).fetch();
	}
}

package com.equinooxe.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.equinooxe.domain.QAuthority;
import com.equinooxe.domain.QUser;
import com.equinooxe.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Component
public class UserQueryRepository {
	@Inject
	EntityManager entityManager;
	
	QUser qUser;
	JPAQueryFactory queryFactory;
 
	
	public JPAQueryFactory getQueryFactory(){
		qUser = QUser.user;
		queryFactory = new JPAQueryFactory(entityManager);
		return queryFactory;
	}

	public User getOneById(Long id) {
		qUser = QUser.user;
		queryFactory = new JPAQueryFactory(entityManager);
		User u = getQueryFactory().selectFrom(qUser).where(qUser.id.eq(id)).fetchOne();
		return u;
	}
	
	public List<User> getAll(){
		qUser = QUser.user;
		queryFactory = new JPAQueryFactory(entityManager);
		return   getQueryFactory().selectFrom(qUser).innerJoin(qUser.authorities).fetch();
	}
}

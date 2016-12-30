package com.equinooxe.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.QUser;
import com.equinooxe.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Component
public class UserQueryRepository {
	 
	QUser qUser;
	JPAQueryFactory queryFactory;
	
	@Autowired
	public UserQueryRepository(EntityManager entityManager){
		qUser = QUser.user;
		queryFactory = new JPAQueryFactory(entityManager);
	}
	 
     

	public User getOneById(Long id) {
		User u = queryFactory.selectFrom(qUser).where(qUser.id.eq(id)).fetchOne();
		return u;
	}
	
	public List<User> getAll(){
		return   queryFactory.selectFrom(qUser).innerJoin(qUser.authorities).fetch();
	}
}

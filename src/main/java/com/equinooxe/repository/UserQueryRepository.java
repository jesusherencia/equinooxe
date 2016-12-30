package com.equinooxe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.QUser;
import com.equinooxe.domain.User;

/**
 * 
 * @author mboullouz
 *
 */
@Component
public class UserQueryRepository extends AbstractQueryRespository<QUser,User> {

	@Autowired
	public UserQueryRepository(EntityManager entityManager) {
		super(entityManager,QUser.user);
	}

	public User getOneById(Long id) {
		User u = queryFactory.selectFrom(qEntity).where(qEntity.id.eq(id)).fetchOne();
		return u;
	}
	
	@Override
	public List<User> getAll() {
		return queryFactory.selectFrom(qEntity).innerJoin(qEntity.authorities).fetch();
	}
}

package com.equinooxe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.ManagerUser;
import com.equinooxe.domain.QManagerUser;

/**
 * 
 * @author mboullouz
 *
 */
@Component
public class ManagerUserQueryRepository extends AbstractQueryRespository<QManagerUser,ManagerUser> {

	@Autowired
	public ManagerUserQueryRepository(EntityManager entityManager) {
		super(entityManager,QManagerUser.managerUser);
	}

	public ManagerUser getOneById(Long id) {
		ManagerUser u = queryFactory.selectFrom(qEntity).where(qEntity.id.eq(id)).fetchOne();
		return u;
	}
	
	@Override
	public List<ManagerUser> getAll() {
		return queryFactory.selectFrom(qEntity).innerJoin(qEntity.authorities).fetch();
	}
}

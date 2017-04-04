package com.equinooxe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.QAgentUser;

/**
 * 
 * @author mboullouz
 *
 */
@Component
public class AgentUserQueryRepository extends AbstractQueryRespository<QAgentUser,AgentUser> {

	@Autowired
	public AgentUserQueryRepository(EntityManager entityManager) {
		super(entityManager,QAgentUser.agentUser);
	}

	public AgentUser getOneById(Long id) {
		return queryFactory.selectFrom(qEntity).where(qEntity.id.eq(id)).fetchOne();
	}
	
	@Override
	public List<AgentUser> getAll() {
		return queryFactory.selectFrom(qEntity).innerJoin(qEntity.authorities).fetch();
	}
}

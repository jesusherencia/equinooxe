package com.equinooxe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.CleanRequest;
import com.equinooxe.domain.ManagerUser;
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

	public List<CleanRequest> getByManager(ManagerUser managerUser) {
		return  queryFactory.selectFrom(qEntity).where(qEntity.manager.eq(managerUser)).fetch();
	}

	public List<CleanRequest> getByAgent(AgentUser agentUser) {
		return  queryFactory.selectFrom(qEntity).where(qEntity.agent.eq(agentUser)).fetch();
	}
 
}

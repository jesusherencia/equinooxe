package com.equinooxe.module.taches;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.QTacheDefinition;
import com.equinooxe.repository.AbstractQueryRespository;

/**
 * 
 * @author mboullouz
 *
 */
@Component
public class TacheDefinitionQueryRepository extends AbstractQueryRespository<QTacheDefinition,TacheDefinitionEntity> {

	@Autowired
	public TacheDefinitionQueryRepository(EntityManager entityManager) {
		super(entityManager,QTacheDefinition.tacheDefinition);
	}

	public TacheDefinitionEntity getOneById(Long id) {
		TacheDefinitionEntity td = queryFactory.selectFrom(qEntity).where(qEntity.id.eq(id)).fetchOne();
		return td;
	}
	
	@Override
	public List<TacheDefinitionEntity> getAll() {
		return queryFactory.selectFrom(qEntity).fetch();
	}
}

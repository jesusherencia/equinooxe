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
public class TacheDefinitionQueryRepository extends AbstractQueryRespository<QTacheDefinition, TacheDefinitionEntity> {

	@Autowired
	public TacheDefinitionQueryRepository(EntityManager entityManager) {
		super(entityManager, QTacheDefinition.tacheDefinition);
	}

	public TacheDefinitionEntity getOneById(Long id) {
		return queryFactory.selectFrom(qEntity).where(qEntity.id.eq(id)).fetchOne();
	}

	@Override
	public List<TacheDefinitionEntity> getAll() {
		return queryFactory.selectFrom(qEntity).fetch();
	}

	public TacheDefinitionEntity getOneByNom(String nom) {
		return queryFactory.selectFrom(qEntity).where(qEntity.nom.eq(nom)).fetchOne();

	}
}

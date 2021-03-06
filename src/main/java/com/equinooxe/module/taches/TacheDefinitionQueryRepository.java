package com.equinooxe.module.taches;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.QTacheDefinition;
import com.equinooxe.domain.TacheDefinition;
import com.equinooxe.repository.AbstractQueryRespository;

/**
 * 
 * @author mboullouz
 *
 */
@Component
public class TacheDefinitionQueryRepository extends AbstractQueryRespository<QTacheDefinition, TacheDefinition> {

	@Autowired
	public TacheDefinitionQueryRepository(EntityManager entityManager) {
		super(entityManager, QTacheDefinition.tacheDefinition);
	}

	public TacheDefinition getOneById(Long id) {
		return queryFactory.selectFrom(qEntity).where(qEntity.id.eq(id)).fetchOne();
	}

	@Override
	public List<TacheDefinition> getAll() {
		return queryFactory.selectFrom(qEntity).fetch();
	}

	public TacheDefinition getOneByNom(String nom) {
		return queryFactory.selectFrom(qEntity).where(qEntity.nom.eq(nom)).fetchOne();

	}
}

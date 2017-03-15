/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.taches;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author mboullouz
 *
 */
public interface TacheDefinitionRepository
		extends JpaRepository<TacheDefinitionEntity, Long>, JpaSpecificationExecutor<TacheDefinitionEntity> {
	Optional<TacheDefinitionEntity> findOneByNom(String nom);

	@SuppressWarnings("unchecked")
	@Override
	TacheDefinitionEntity saveAndFlush(TacheDefinitionEntity td);
}

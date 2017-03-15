/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.equinooxe.domain.TacheDefinition;

/**
 * @author mboullouz
 *
 */
public interface TacheDefinitionRepository
		extends JpaRepository<TacheDefinition, Long>, JpaSpecificationExecutor<TacheDefinition> {
	Optional<TacheDefinition> findOneByNom(String nom);

	@SuppressWarnings("unchecked")
	@Override
	TacheDefinition saveAndFlush(TacheDefinition td);
}

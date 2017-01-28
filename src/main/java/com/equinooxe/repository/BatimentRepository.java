/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.equinooxe.domain.Batiment;

/**
 * @author mboullouz
 *
 */
public interface BatimentRepository extends JpaRepository<Batiment, Long> , JpaSpecificationExecutor<Batiment> {
	Optional<Batiment> findOneByNom(String nom);
}

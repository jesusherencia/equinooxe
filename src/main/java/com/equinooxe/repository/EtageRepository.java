/** Copyright (C) 2017 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.equinooxe.domain.Batiment;
import com.equinooxe.domain.Etage;

/**
 * @author mboullouz
 *
 */
public interface EtageRepository extends JpaRepository<Etage, Long> , JpaSpecificationExecutor<Etage> {
	Optional<Etage> findOneByNom(String nom);
	List<Etage> findByBatiment(Batiment batiment);
}
 

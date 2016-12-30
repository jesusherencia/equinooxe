/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.equinooxe.domain.Espace;

/**
 * @author mboullouz
 *
 */
public interface EspaceRepository extends JpaRepository<Espace, Long> , JpaSpecificationExecutor<Espace> {

}

/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equinooxe.domain.Location;

/**
 * @author mboullouz
 *
 */
public interface LocationRepository extends JpaRepository<Location, Long> {

}

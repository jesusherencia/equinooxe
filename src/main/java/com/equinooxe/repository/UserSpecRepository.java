package com.equinooxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.equinooxe.domain.User;

public interface UserSpecRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    
}

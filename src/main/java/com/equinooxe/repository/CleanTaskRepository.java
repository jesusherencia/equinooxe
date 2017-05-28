package com.equinooxe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.CleanRequest;
import com.equinooxe.domain.CleanTask;
import com.equinooxe.domain.ManagerUser;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface CleanTaskRepository extends JpaRepository<CleanTask, Long> {

   
    @SuppressWarnings("unchecked")
	@Override
	CleanTask saveAndFlush(CleanTask cleanTask);
    
    @Override
    void delete(CleanTask cleanTask);

}

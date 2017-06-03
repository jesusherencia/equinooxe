package com.equinooxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equinooxe.domain.CleanTask;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface CleanTaskRepository extends JpaRepository<CleanTask, Long> {
    
	
	CleanTask findOneByName(String name);
   
    @SuppressWarnings("unchecked")
	@Override
	CleanTask saveAndFlush(CleanTask cleanTask);
    
    @Override
    void delete(CleanTask cleanTask);

}

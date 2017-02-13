package com.equinooxe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.CleanRequest;
import com.equinooxe.domain.ManagerUser;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface CleanRequestRepository extends JpaRepository<CleanRequest, Long> {

    Optional<CleanRequest> findOneByManager(ManagerUser manager);
    Optional<CleanRequest> findOneByAgent(AgentUser agent);

    List<CleanRequest> findAllByManager(ManagerUser manager);
    List<CleanRequest> findAllByAgent(AgentUser agent);
   
    @SuppressWarnings("unchecked")
	@Override
	CleanRequest saveAndFlush(CleanRequest u);
    
    @Override
    void delete(CleanRequest t);

}

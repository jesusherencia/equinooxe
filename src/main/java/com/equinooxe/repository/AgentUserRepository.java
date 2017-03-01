package com.equinooxe.repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.ManagerUser;

/**
 * Spring Data JPA repository for the ManagerUser entity.
 */
public interface AgentUserRepository extends JpaRepository<AgentUser, Long> {

    Optional<AgentUser> findOneByActivationKey(String activationKey);

    List<AgentUser> findAllByActivatedIsFalseAndCreatedDateBefore(ZonedDateTime dateTime);

    Optional<AgentUser> findOneByResetKey(String resetKey);

    Optional<AgentUser> findOneByEmail(String email);

    Optional<AgentUser> findOneByLogin(String login);

    @Query(value      = "select distinct user from AgentUser user left join fetch user.authorities",
           countQuery = "select count(user) from AgentUser user")
    Page<ManagerUser> findAllWithAuthorities(Pageable pageable);
   
    @SuppressWarnings("unchecked")
	@Override
	AgentUser saveAndFlush(AgentUser u);
    
    @Override
    void delete(AgentUser t);

}

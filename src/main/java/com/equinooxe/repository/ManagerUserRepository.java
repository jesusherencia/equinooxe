package com.equinooxe.repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.equinooxe.domain.ManagerUser;

/**
 * Spring Data JPA repository for the ManagerUser entity.
 */
public interface ManagerUserRepository extends JpaRepository<ManagerUser, Long> {

    Optional<ManagerUser> findOneByActivationKey(String activationKey);

    List<ManagerUser> findAllByActivatedIsFalseAndCreatedDateBefore(ZonedDateTime dateTime);

    Optional<ManagerUser> findOneByResetKey(String resetKey);

    Optional<ManagerUser> findOneByEmail(String email);

    Optional<ManagerUser> findOneByLogin(String login);

    @Query(value      = "select distinct user from ManagerUser user left join fetch user.authorities",
           countQuery = "select count(user) from ManagerUser user")
    Page<ManagerUser> findAllWithAuthorities(Pageable pageable);
   
    @SuppressWarnings("unchecked")
	@Override
	ManagerUser saveAndFlush(ManagerUser u);
    
    @Override
    void delete(ManagerUser t);

}

/*
 */
package com.equinooxe.infrastructure.repository;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.User;
import com.equinooxe.domain.repository.Repository;
import java.util.List;

/**
 *
 * @author mboullouz
 */
public interface UserRepository extends Repository<User> {
      User findUserByEmail(String email);
      User findUserByUsername(String username);
      User createUser(String email, String username, String password);
      List<Permission> getAllByRoleName(String roleName) ;
}

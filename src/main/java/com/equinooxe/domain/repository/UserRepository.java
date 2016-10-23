package com.equinooxe.domain.repository;
 
import java.util.List;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.User;

public interface UserRepository extends Repository<User> {

    public User findUserByEmail(String email);

    public User findUserByUsername(String username) throws DatabaseOperationGenericException;

    public User createBasicUser(String email, String username, String password);
 
    public List<Permission> getAllByRoleName(String roleName);
}

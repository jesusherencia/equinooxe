package com.equinooxe.module.user;
 
import java.util.List;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.User;
 
import com.equinooxe.domain.repository.Repository;
import javax.ws.rs.WebApplicationException;

public interface UserRepository extends Repository<User> {

    public User findUserByEmail(String email);

    public User findUserByUsername(String username) throws WebApplicationException;

    public User createBasicUser(String email, String username, String password);
 
    public List<Permission> getAllByRoleName(String roleName);
}

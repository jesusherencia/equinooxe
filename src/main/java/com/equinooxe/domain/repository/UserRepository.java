package com.equinooxe.domain.repository;

import java.util.List;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.User;
import com.equinooxe.domain.shared.Repository;

public interface UserRepository extends Repository<User> {

	public User findByEmail(String email);
	
	public User findByUsername(String username);
	
	public User createUser(String email, String username, String password);
	
	public List<Permission> getAllByRoleName(String roleName);
}

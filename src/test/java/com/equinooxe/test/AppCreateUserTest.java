package com.equinooxe.test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.equinooxe.domain.repository.UserRepository;
import com.equinooxe.infrastructure.repository.UserJpaRepository;
import org.junit.Test;

public class AppCreateUserTest {

	private static final transient Logger log = LoggerFactory.getLogger(AppCreateUserTest.class);
        
        @Test
	public void main() {
		log.info("My First Apache Shiro Application");
		UserRepository userRepository = new UserJpaRepository();
		userRepository.createUser("a@a.com", "admin", "admin");
	}
}

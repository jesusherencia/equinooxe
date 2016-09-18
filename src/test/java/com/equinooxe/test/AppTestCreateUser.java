package com.equinooxe.test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.equinooxe.domain.repository.UserRepository;
import com.equinooxe.infrastructure.repository.UserJpaRepository;

public class AppTestCreateUser {

	private static final transient Logger log = LoggerFactory.getLogger(AppTestCreateUser.class);

	public static void main(String[] args) {
		log.info("My First Apache Shiro Application");
		UserRepository userRepository = new UserJpaRepository();
		userRepository.createUser("b@b.com", "test", "test");
	}
}

package com.equinooxe.module.user;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.equinooxe.repository.UserRepository;

@Component
public class AddUserValidator implements Validator {
	@Inject
	private UserRepository userRepository;
	 
	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserForm userForm = (UserForm) target;
		if (userRepository.findOneByLogin(userForm.getLogin().toLowerCase()).isPresent()) {
			errors.rejectValue("login", "login.deja.utilise");
		}
		if (userRepository.findOneByEmail(userForm.getEmail()).isPresent()) {
			errors.rejectValue("email", "email.deja.utilise");
		}
	}

}
 
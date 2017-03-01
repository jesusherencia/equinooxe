package com.equinooxe.module.user;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.equinooxe.domain.User;
import com.equinooxe.repository.UserRepository;

@Component
public class AddManagerValidator implements Validator {
	@Inject
	private UserRepository userRepository;
	 
	@Override
	public boolean supports(Class<?> clazz) {
		return ManagerUserForm.class.isAssignableFrom(clazz);
	}

	@Override
	/**
	 * TODO take care of the case when of edit
	 */
	public void validate(Object target, Errors errors) {
		ManagerUserForm managerUserForm = (ManagerUserForm) target;
		if(managerUserForm.getId()==null && (managerUserForm.getPassword()==null||managerUserForm.getPassword().length()<4)){
			errors.rejectValue("password", "password.obligatoire");
		}
		Optional<User> optUser=userRepository.findOneByLogin(managerUserForm.getLogin().toLowerCase());
		if (optUser.isPresent() && optUser.get().getId()!=managerUserForm.getId() ) {
			errors.rejectValue("login", "login.deja.utilise");
		}
		optUser=userRepository.findOneByEmail(managerUserForm.getEmail());
		if (optUser.isPresent() && optUser.get().getId()!=managerUserForm.getId()) {
			errors.rejectValue("email", "email.deja.utilise");
		}
	}

}
 
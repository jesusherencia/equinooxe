package com.equinooxe.module.taches;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.equinooxe.module.user.AgentUserForm;

@Component
public class TacheDefinitionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AgentUserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TacheDefinitionFormModel form = (TacheDefinitionFormModel) target;
		errors.rejectValue("login", "login.deja.utilise");

	}
}

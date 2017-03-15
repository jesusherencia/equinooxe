package com.equinooxe.module.taches;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.equinooxe.domain.TacheDefinition;
import com.equinooxe.module.user.AgentUserForm;

@Component
public class TacheDefinitionValidator implements Validator {
	@Inject
	TacheDefinitionQueryRepository tacheDefinitionQueryRep;

	@Override
	public boolean supports(Class<?> clazz) {
		return AgentUserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TacheDefinitionFormModel form = (TacheDefinitionFormModel) target;
		TacheDefinition td = tacheDefinitionQueryRep.getOneByNom(form.getNom());
		if (td != null) {
			errors.reject("valeur.existe.pour.champs", new String[] { form.getNom(), "Nom" }, "nom");
		}

	}
}

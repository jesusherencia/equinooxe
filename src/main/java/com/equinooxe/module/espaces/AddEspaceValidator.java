package com.equinooxe.module.espaces;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.equinooxe.repository.EspaceRepository;

public class AddEspaceValidator implements Validator  {
	@Inject
	EspaceRepository espaceRepository;
	@Override
	public void validate(Object target, Errors errors) {
		EspaceFormModel espaceFormModel = (EspaceFormModel) target;
		if (espaceFormModel.getId() > 0) { /* edit case */
			
		} else {
			espaceRepository.findOneByNom(espaceFormModel.getNom()).ifPresent(b -> {
				errors.reject("valeur.existe.pour.champs", new String[] { espaceFormModel.getNom(), "Nom" }, "nom");
			});
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return EspaceFormModel.class.isAssignableFrom(clazz);
	}
}

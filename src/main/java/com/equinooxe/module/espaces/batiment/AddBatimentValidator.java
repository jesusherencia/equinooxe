/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces.batiment;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.equinooxe.repository.BatimentRepository;

/**
 * @author mboullouz
 *
 */
@Component
public class AddBatimentValidator implements Validator {
	@Inject
	BatimentRepository batimentRepository;

	@Override
	public void validate(Object target, Errors errors) {
		BatimentFormModel batimentFormModel = (BatimentFormModel) target;
		if (batimentFormModel.getId() > 0) { /* edit case */
			
		} else {
			batimentRepository.findOneByNom(batimentFormModel.getNom()).ifPresent(b -> {
				errors.reject("valeur.existe.pour.champs", new String[] { batimentFormModel.getNom(), "Nom" }, "nom");
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
		return BatimentFormModel.class.isAssignableFrom(clazz);
	}

}

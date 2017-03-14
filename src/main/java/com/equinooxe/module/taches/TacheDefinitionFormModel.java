package com.equinooxe.module.taches;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.equinooxe.module.common.BaseFormModel;

public class TacheDefinitionFormModel extends BaseFormModel {

	@NotNull
	@Size(min = 2, max = 60)
	private String nom;
	private String description;

	public String getNom() {
		return nom;
	}
	
	public TacheDefinitionFormModel() {
	}

	public TacheDefinitionFormModel(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

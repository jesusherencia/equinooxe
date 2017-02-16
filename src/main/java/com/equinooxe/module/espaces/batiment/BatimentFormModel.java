/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces.batiment;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.equinooxe.domain.Batiment;
import com.equinooxe.module.common.BaseFormModel;

/**
 * @author mboullouz
 *
 */
public class BatimentFormModel extends BaseFormModel {
  
    @NotNull
	@Size(min = 2, max = 60)
    private String nom;
    private String adresse;
    private String description;
    /**
	 * 
	 */
	public BatimentFormModel() {
	}
	public BatimentFormModel(Batiment batiment) {
		 id= batiment.getId();
		 nom= batiment.getNom();
		 adresse= batiment.getAdresse();
		 description= batiment.getDescription();
	}
	 
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	 
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}

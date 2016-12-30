/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces;

import com.equinooxe.domain.Batiment;

/**
 * @author mboullouz
 *
 */
public class BatimentFormModel {
    private Long id;
    private String nom;
    private String adresse;
    /**
	 * 
	 */
	public BatimentFormModel() {
	}
	public BatimentFormModel(Batiment batiment) {
		 id= batiment.getId();
		 nom= batiment.getNom();
		 adresse= batiment.getAdresse();
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

/** Copyright (C) 2017 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.equinooxe.domain.Batiment;
import com.equinooxe.domain.Etage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author mboullouz
 *
 */
public class EtageFormModel {
	private Long id = new Long(-1);
	@NotNull
	@Size(min = 2, max = 60)
	private String nom;
	private String description;
	private Batiment batiment;
	private Long batimentId;

	public EtageFormModel() {
	}

	public EtageFormModel(Etage etage) {
		this.id = etage.getId();
		this.nom = etage.getNom();
		this.description = etage.getDescription();
		this.batiment = etage.getBatiment();
		this.batimentId = this.batiment.getId();
	}

	public EtageFormModel(Batiment batiment) {
		this.batiment = batiment;
		this.batimentId = this.batiment.getId();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the batimentId
	 */
	public Long getBatimentId() {
		return batimentId;
	}

	/**
	 * @param batimentId
	 *            the batimentId to set
	 */
	public void setBatimentId(Long batimentId) {
		this.batimentId = batimentId;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the batiment
	 */
	public Batiment getBatiment() {
		return batiment;
	}

	/**
	 * @param batiment
	 *            the batiment to set
	 */
	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "{ id:" + id + " }";
		try {
			jsonInString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonInString;
	}

}

/** Copyright (C) 2017 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.equinooxe.domain.Espace;
import com.equinooxe.domain.Etage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author mboullouz
 *
 */
public class EspaceFormModel {
	private Long id = new Long(-1);
	@NotNull
	@Size(min = 2, max = 60)
	private String nom;
	private String numero;
	private String description;
	private Etage etage;
	private Long etageId;

	public EspaceFormModel() {
	}

	public EspaceFormModel(Espace etage) {
		this.id = etage.getId();
		this.numero= etage.getNumero();
		this.nom = etage.getNom();
		this.description = etage.getDescription();
		this.etage = etage.getEtage();
		this.etageId = this.etage.getId();
	}

	public EspaceFormModel(Etage etage) {
		this.etage = etage;
		this.etageId = this.etage.getId();
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the batimentId
	 */
	public Long getEtageId() {
		return etageId;
	}

	/**
	 * @param batimentId
	 *            the batimentId to set
	 */
	public void setEtageId(Long batimentId) {
		this.etageId = batimentId;
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
	public Etage getEtage() {
		return etage;
	}

	/**
	 * @param etage
	 *            the batiment to set
	 */
	public void setEtage(Etage etage) {
		this.etage = etage;
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

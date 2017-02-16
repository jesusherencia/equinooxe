/** Copyright (C) 2017 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces.etage;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.equinooxe.domain.Batiment;
import com.equinooxe.domain.Etage;
import com.equinooxe.module.common.BaseFormModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author mboullouz
 *
 */
public class EtageFormModel  extends BaseFormModel{
 
	@NotNull
	@Size(min = 2, max = 60)
	private String nom;
	private String description;
	private Batiment batiment;
	private Long batimentId;
	private List<Batiment> availableBatiments = new ArrayList<>();
	private Long[] batiments = new Long[999];

	public EtageFormModel() {
	}

	public EtageFormModel(Etage etage) {
		this.init(etage);
	}
	
	public EtageFormModel(Etage etage, List<Batiment> availableBatiments ) {
		this.init(etage);
		this.initBatiment(availableBatiments);
		
	}
	
	public EtageFormModel(List<Batiment> availableBatiments ) {
		this.initBatiment(availableBatiments);
	}
	
	public List<Batiment> getAvailableBatiments() {
		return availableBatiments;
	}

	public void setAvailableBatiments(List<Batiment> availableBatiments) {
		this.availableBatiments = availableBatiments;
	}

	public Long[] getBatiments() {
		return batiments;
	}

	public void setBatiments(Long[] batiments) {
		this.batiments = batiments;
	}

	private void initBatiment(List<Batiment> availableBatiments){
		this.availableBatiments=availableBatiments; 
		int c=0;
		for(Batiment b: this.availableBatiments){
			this.batiments[c]= b.getId();
			c++;
		}
	}
	
	private void init(Etage etage){
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

}

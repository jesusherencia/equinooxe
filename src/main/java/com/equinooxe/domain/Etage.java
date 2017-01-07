/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author mohamed
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Etage extends AbstractAuditingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(unique = true)
	private String nom;

	@Column(unique = false, columnDefinition = "TEXT")
	private String description;

	@ManyToOne
	private Batiment batiment;

	@OneToMany(mappedBy = "etage", targetEntity = Espace.class)
	@Fetch(FetchMode.JOIN)
	private Collection<Espace> espaces;

	public Etage() {
		super();
	}

	public Etage(String nom, String desc, Batiment batiment) {
		this.update(nom, desc, batiment);
	}

	public void update(String nom, String desc, Batiment batiment) {
		this.nom = nom;
		this.description = desc;
		this.batiment = batiment;
	}

	public Collection<Espace> getEspaces() {
		return espaces;
	}

	public void setEspaces(Collection<Espace> espaces) {
		this.espaces = espaces;
	}

	public String getNom() {
		return nom;
	}

	public Batiment getBatiment() {
		return batiment;
	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	public void setNom(String name) {
		this.nom = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Etage)) {
			return false;
		}
		Etage other = (Etage) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
 

}

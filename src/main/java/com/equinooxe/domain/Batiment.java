/*
 * Copyright (C) 2015 <mohamedboullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * OperativeUnite is a kind of building/site
 *
 * @author mohamed
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Batiment extends AbstractAuditingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    @Column(unique = true)
    private String nom;

    @Column(unique = false)
    private String adresse;

    @Column(unique = false, columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "batiment", targetEntity = Etage.class)
    @Fetch(FetchMode.JOIN)
    private Collection<Etage> etages;

    public Batiment() {
        super();
    }

    public Batiment(String nom,String adresse, String desc) {
        super();
        this.update(nom, adresse, desc);
    }
    
    public void update(String nom,String adresse, String desc) {
    	this.nom = nom;
        this.adresse=adresse;
        this.description=desc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String name) {
        this.nom = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adress) {
        this.adresse = adress;
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

    public Collection<Etage> getEtages() {
        return etages;
    }

    public void setEtages(Collection<Etage> etages) {
        this.etages = etages;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Batiment)) {
            return false;
        }
        Batiment other = (Batiment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{ id:" + id + " }";
    }

}

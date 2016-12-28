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

/**
 * OperativeUnite is a kind of building/site
 *
 * @author mohamed
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class OperativeUnit extends AbstractAuditingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    @Column(unique = true)
    private String name;

    @Column(unique = false)
    private String adress;

    @Column(unique = false, columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "operativeUnit", targetEntity = LocationGroup.class)
    private Collection<LocationGroup> locationGroups;

    public OperativeUnit() {
        super();
    }

    public OperativeUnit(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public Collection<LocationGroup> getLocationGroups() {
        return locationGroups;
    }

    public void setLocationGroups(Collection<LocationGroup> locationGroups) {
        this.locationGroups = locationGroups;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OperativeUnit)) {
            return false;
        }
        OperativeUnit other = (OperativeUnit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OperativeUnit[ id=" + id + " ]";
    }

}

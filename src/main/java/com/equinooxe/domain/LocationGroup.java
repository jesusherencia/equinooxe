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

/**
 *
 * @author mohamed
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class LocationGroup extends AbstractAuditingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    @Column(unique = true)
    private String name;

    @Column(unique = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private OperativeUnit operativeUnit;

    @OneToMany(mappedBy = "locationGroup", targetEntity = Location.class)
    private Collection<Location> locations;

    public LocationGroup() {
        super();
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public OperativeUnit getOperativeUnit() {
        return operativeUnit;
    }

    public void setOperativeUnit(OperativeUnit operativeUnit) {
        this.operativeUnit = operativeUnit;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof LocationGroup)) {
            return false;
        }
        LocationGroup other = (LocationGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appnh.infra.model.Groupement[ id=" + id + " ]";
    }

}

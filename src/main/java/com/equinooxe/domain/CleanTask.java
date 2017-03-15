/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.equinooxe.module.taches.TacheDefinitionEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author mohamed
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class CleanTask extends AbstractAuditingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(unique = true)
    private String name;

    @Column(unique = false, columnDefinition = "TEXT")
    private String description;

    @Column()
    private boolean done;

    @ManyToOne
    private CleanRequest cleanRequest;

    @ManyToOne
    private TacheDefinitionEntity tacheDefinition;

    public CleanTask() {
        super();
    }

    public String getName() {
        return name;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public CleanRequest getCleanRequest() {
        return cleanRequest;
    }

    public void setCleanRequest(CleanRequest cleanRequest) {
        this.cleanRequest = cleanRequest;
    }

    public TacheDefinitionEntity getTacheDefinition() {
        return tacheDefinition;
    }

    public void setTacheDefinition(TacheDefinitionEntity tacheDefinition) {
        this.tacheDefinition = tacheDefinition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CleanTask)) {
            return false;
        }
        CleanTask other = (CleanTask) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}

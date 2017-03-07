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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author mboullouz
 */
@Entity
@DiscriminatorValue("AGENT")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class AgentUser extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@OneToMany(mappedBy = "agent", targetEntity = CleanRequest.class)
	@Fetch(FetchMode.JOIN)
    private Collection<CleanRequest> cleanRequests;

    public Collection<CleanRequest> getCleanRequests() {
        return cleanRequests;
    }

    public void setCleanRequests(Collection<CleanRequest> cleanRequests) {
        this.cleanRequests = cleanRequests;
    }

}

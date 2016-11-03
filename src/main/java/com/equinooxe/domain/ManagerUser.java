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

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author mboullouz
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ManagerUser extends User implements Serializable {
     
    @OneToMany(mappedBy = "manager", targetEntity = CleanRequest.class)
    private Collection<CleanRequest> cleanRequests;
    
    public ManagerUser(){
        super();
    }
    
    public ManagerUser(Collection<CleanRequest> cleanRequests){
        super();
        this.cleanRequests=cleanRequests;
    }

    public Collection<CleanRequest> getCleanRequests() {
        return cleanRequests;
    }

    public void setCleanRequests(Collection<CleanRequest> cleanRequests) {
        this.cleanRequests = cleanRequests;
    }
 
    @Override
    public String toString() {
        return "ManagerUser[ id=" + id + " ]";
    }
    
}

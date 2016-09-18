/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author mboullouz
 */
@Entity
public class ManagerUser extends User implements Serializable {
     
    @OneToMany(mappedBy = "manager", targetEntity = CleanRequest.class)
    private Collection<CleanRequest> cleanRequests;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManagerUser)) {
            return false;
        }
        ManagerUser other = (ManagerUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appnh.models.ManagerUser[ id=" + id + " ]";
    }
    
}

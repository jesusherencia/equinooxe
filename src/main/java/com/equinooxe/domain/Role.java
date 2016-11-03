/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mohamed
 */
@Entity
@Table()
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Role extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "role", targetEntity = UserRole.class)
    private Collection<UserRole> userRoles;

    @OneToMany(mappedBy = "role", targetEntity = RolePermission.class)
    private Collection<RolePermission> rolePermissions;

    public Role() {
        super();
    }

    public Role(String name) {
        super();
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public Collection<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Collection<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Collection<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Role[ id=" + id + " ]";
    }

}

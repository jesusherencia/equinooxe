/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class RolesPermission extends BaseEntity {

    @Column
    private String permission;

    @Column
    private String roleName;

    public RolesPermission() {
        super();
    }

    public String getPermission() {
        return permission;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

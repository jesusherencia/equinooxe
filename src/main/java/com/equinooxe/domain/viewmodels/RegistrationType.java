/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.domain.viewmodels;

/**
 *
 * @author mboullouz
 */
public enum RegistrationType {
    BASIC("BASIC"),
    AGENT("AGENT"),
    MANAGER("MANAGER");
    private String type="BASIC";
    RegistrationType(String type) {
        this.type=type;
    }
    
    @Override
    public String toString(){
        return this.type;
    }
    
    
}

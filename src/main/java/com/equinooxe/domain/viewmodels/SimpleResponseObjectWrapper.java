/*
 */
package com.equinooxe.domain.viewmodels;

/**
 * Webclient need a Json object
 * @author mboullouz
 */
public class SimpleResponseObjectWrapper {
    public String message="";
    public int code = 0;
    
    public SimpleResponseObjectWrapper(String message, int code){
        this.message = message;
        this.code=code;
    }
}

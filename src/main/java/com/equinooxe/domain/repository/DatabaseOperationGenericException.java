/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equinooxe.domain.repository;

import javax.ws.rs.WebApplicationException;

/**
 * Gather All DB exception so that we can map to a specific status and message
 * to send back to the api client
 * @author mboullouz
 */
public class DatabaseOperationGenericException extends WebApplicationException{
    public DatabaseOperationGenericException(String message){
        super(message);
    }
    public DatabaseOperationGenericException(String message, Throwable cause) {
        super(message, cause);
    }
     public DatabaseOperationGenericException() {
        super();
    }
     public DatabaseOperationGenericException(Throwable cause) {
		super(cause);
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equinooxe.resource;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.TransactionException;

/**
 *
 * @author mboullouz
 */
public class DatabaseOperationExeptionMapper implements ExceptionMapper<TransactionException> {

    @Override
    public Response toResponse(TransactionException e) {
          return Response.status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equinooxe.resource;

import com.equinooxe.domain.repository.DatabaseOperationGenericException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @deprecated  should be removed 
 * @author mboullouz
 */
@Provider
public class DatabaseOperationExeptionMapper implements ExceptionMapper<DatabaseOperationGenericException> {

    @Override
    public Response toResponse(DatabaseOperationGenericException e) {
          return Response.status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
}

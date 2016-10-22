/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.resource;

/**
 *
 * @author Mohamed
 */
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;

/**
 *
 * Customize shiro exception response
 */
@Provider
public class AutorizationGenericExceptionMapper implements ExceptionMapper<ShiroException> {

    @Override
    public Response toResponse(final ShiroException ex) {
        return Response.status(ex instanceof UnauthenticatedException || ex instanceof UnauthenticatedException ? Response.Status.UNAUTHORIZED : Response.Status.FORBIDDEN)
                .entity(ex.getMessage())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
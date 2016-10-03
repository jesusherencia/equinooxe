/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.resource.user;

 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mohamed
 */
@Path("/auth")
public class AuthResource {


    private UserAuth userAuth = new UserAuthImpl();

    public AuthResource() {
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(BasicAuthDto uAuthObject) {
        if (userAuth.login(uAuthObject)) {
            return Response.status(Response.Status.OK).entity("OK").build();
        }
        return Response.status(Response.Status.FORBIDDEN).entity("BadCredentials").build();
    }

    @Path("/logout")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        userAuth.logout();
        return Response.status(Response.Status.OK).entity("Logout success").build();
    }
 
    public boolean checkUserAuth(BasicAuthDto uAuthObject) {
        throw new UnsupportedOperationException("Not supported yet.");  
    }

    public boolean checkUserAuthByEmail(String userEmail) {
        throw new UnsupportedOperationException("Not supported yet.");  
    }
}

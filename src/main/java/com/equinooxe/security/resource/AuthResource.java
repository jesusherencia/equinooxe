/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.security.resource;

import com.equinooxe.domain.User;
import com.equinooxe.domain.viewmodels.SimpleResponseObjectWrapper;
import com.equinooxe.module.user.UserRegistrationViewModel;
import com.equinooxe.service.AuthentificationService;
import com.equinooxe.module.user.BasicUserAuthDto;
import com.equinooxe.module.user.UserService;
import com.equinooxe.service.impl.AuthentificationServiceImpl;
import com.equinooxe.module.user.UserServiceImpl;

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

    private AuthentificationService userAuth = new AuthentificationServiceImpl();
    private UserService userService = new UserServiceImpl();

    public AuthResource() {
    }

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(UserRegistrationViewModel userResiftrationVM) {
        return Response
                .status(Response.Status.OK)
                .entity(userService.register(
                                userResiftrationVM.username,
                                userResiftrationVM.email,
                                userResiftrationVM.password,
                                userResiftrationVM.registrationType,
                                userResiftrationVM.roleIds)
                )
                .build();
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(BasicUserAuthDto uAuthObject) {
        if (userAuth.login(uAuthObject)) {
            User user = userService.getAuthentificatedUser();
            return Response.status(Response.Status.OK).entity(user).build();
        }
        return Response.status(Response.Status.FORBIDDEN).entity(new SimpleResponseObjectWrapper("BadCredentials", 0)).build();
    }

    @Path("/logout")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        userAuth.logout();
        return Response.status(Response.Status.OK)
                .entity(new SimpleResponseObjectWrapper("Logout success", 1)).build();
    }

    @Path("/ping")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response pingPublic() {
        return Response.status(Response.Status.OK).entity("Public area acces is OK").build();
    }

    public boolean checkUserAuth(BasicUserAuthDto uAuthObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean checkUserAuthByEmail(String userEmail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

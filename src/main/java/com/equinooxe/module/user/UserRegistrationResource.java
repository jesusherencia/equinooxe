/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.user;

import com.equinooxe.domain.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.shiro.authz.annotation.RequiresAuthentication;

/**
 *
 * @author mboullouz
 */
@Path("/secure/register")
@RequiresAuthentication
public class UserRegistrationResource {

    private UserService userService = new UserServiceImpl();
    
    
    @Path("/")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response  get(){
        UserRegistrationViewModel userRegistationVM= userService.prepareRegistrationViewModel();
        return Response.status(Response.Status.OK).entity(userRegistationVM).build();
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response  save(UserRegistrationViewModel userRegistrationVM){
        User user = userService.register(userRegistrationVM);
        return Response.status(Response.Status.OK).entity(user).build();
    }
          
}

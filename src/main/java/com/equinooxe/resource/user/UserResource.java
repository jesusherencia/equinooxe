/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.resource.user;

import com.equinooxe.domain.User;
import com.equinooxe.service.UserService;
import com.equinooxe.service.impl.UserServiceImpl;
import java.lang.reflect.Field;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.Column;

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
 * @author mohamed
 */
@Path("/secure/user")
@RequiresAuthentication
public class UserResource {

    private UserService userService = new UserServiceImpl();
   
    @Path("/describe")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response describe(){       
        List<String> strFields= new ArrayList<>();
        for (Field field : User.class.getDeclaredFields()) {
            String str= field.getAnnotation(Column.class)+" " +field.getType()+" "+field.getName();
            str=str.replace("java.lang.", "")
                   .replace("@javax.persistence.", "");
            strFields.add(str);
        }
        return Response.status(Response.Status.OK).entity(strFields).build();
    }

    @Path("/all")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<User> users = userService.findAll();
        return Response.status(Response.Status.OK).entity(users).build();
    }

    @Path("/current")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurrentUser() {
        return Response.status(Response.Status.OK).entity(userService.getAuthentificatedUser()).build();
    }

   

}

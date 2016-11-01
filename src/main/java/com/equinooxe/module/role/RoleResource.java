/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

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
@Path("/secure/rolepermission")
@RequiresAuthentication
public class RoleResource {

    RolePermissionService rolePermissionService = new RolePermissionServiceImpl();

    @Path("/")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        RolePermissionViewModel vm = rolePermissionService.prepare();
        return Response.status(Response.Status.OK)
                .entity(vm)
                .build();
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(RolePermissionViewModel vm) {
        return Response
                .status(Response.Status.OK)
                .entity(
                        rolePermissionService.save(vm)
                ).build();
    }
}

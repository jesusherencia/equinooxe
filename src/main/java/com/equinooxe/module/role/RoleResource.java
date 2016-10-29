/* Copyright (C) 2015  mohamedboullouz@gmail.com 
 * This file is part of Equinooxe Project
 */
package com.equinooxe.module.role;

import com.equinooxe.domain.Role;
import com.equinooxe.domain.User;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.shiro.authz.annotation.RequiresAuthentication;

/**
 *
 * @author mboullouz
 */
@Path("/secure/role")
@RequiresAuthentication
public class RoleResource {
    
    @Path("/all")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        RoleRepository roleRepository = new RoleRepositoryImpl();
        List<Role> roles = roleRepository.findAll();
        return Response.status(Response.Status.OK).entity(roles).build();
    }
}

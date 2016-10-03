/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.resource.user;

import com.equinooxe.domain.User;
import com.equinooxe.service.UserService;
import com.equinooxe.service.impl.UserServiceImpl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mohamed
 */

@Path("/user")
public class UserResource {

	private UserService userService = new UserServiceImpl();

	@Path("/all")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<User> users =  userService.findAll(); 
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

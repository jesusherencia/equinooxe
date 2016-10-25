/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.test;

import com.equinooxe.module.user.BasicUserAuthDto;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Mohamed
 */
public class AuthJUnitTest {

    static String BASE_URI_AUTH;
    static Client client;

    @Test
    public void logInWithUsernameAsEmailAndPasswordTest() {
        WebTarget target = client.target(BASE_URI_AUTH + "/login");
        BasicUserAuthDto u = new BasicUserAuthDto("m@m.com", "med", true);
        Entity<BasicUserAuthDto> userEntity = Entity.entity(u, MediaType.APPLICATION_JSON);
        Response response = target.request().post(userEntity);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("OK", response.readEntity(String.class));

    }

    @Before
    public void setUpClass() {
        BASE_URI_AUTH = "http://localhost:8080/equinooxe/ws/auth";
        client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
    }

    @After
    public void tearDownClass() {
        System.out.println("after !");
    }
}

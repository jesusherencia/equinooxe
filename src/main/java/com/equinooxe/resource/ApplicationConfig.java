/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.resource;
 
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Application;
import org.secnod.shiro.jersey.AuthInjectionBinder;
import org.secnod.shiro.jersey.AuthorizationFilterFeature;
import org.secnod.shiro.jersey.SubjectFactory;

/**
 *
 * @author ABCD-user
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    private static final Logger log = java.util.logging.Logger.getLogger(ApplicationConfig.class.getName());

    /**
     * This is how the Jersey - Jackson serialize the object returned as
     * Response Object
     *
     * @return a Set
     */
    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new HashSet<>();
        /**
         * Register Hibernate module with Jackson mapper
         * @see http://wiki.fasterxml.com/JacksonHowToCustomSerializers
         * @see https://github.com/FasterXML/jackson-datatype-hibernate
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate5Module());
        log.log(Level.INFO, "Enabling custom Jackson JSON provider and register Hibernate5Module ");
        JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(DeserializationFeature.WRAP_EXCEPTIONS, true);
        jacksonJsonProvider.setMapper(mapper);
        set.add(jacksonJsonProvider);
        
        set.add(new AuthorizationFilterFeature());
        set.add(new SubjectFactory());
        set.add(new AuthInjectionBinder());
       
        return set;
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> map = new HashMap<>();
        //May not be needed
        //log.log(Level.INFO, "Disabling MOXy JSON provider: see ApplicationConfig::getPropriesties()");
        //map.put("jersey.config.disableMoxyJson.server", true);
        return map;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(AppCustomBasicAuthenticationFilter.class);/* @see the class doc */
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     *
     * @warning Netbean IDE rewrites this methods autmatically
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.equinooxe.module.auth.AuthResource.class);
        resources.add(com.equinooxe.module.user.UserResource.class);
        resources.add(com.equinooxe.resource.AppCustomBasicAuthenticationFilter.class);
        resources.add(com.equinooxe.resource.AutorizationGenericExceptionMapper.class);
        resources.add(com.equinooxe.resource.CORSResponseFilter.class);
        resources.add(com.equinooxe.resource.DatabaseOperationExeptionMapper.class);
    }

}

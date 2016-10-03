/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.resource.user;
 
 

/**
 * BasicAuthDto: is an object used to login, it's a commodities to simplify 
 * serilization/deserialization as it's a simple POJO
 * @author Mohamed
 */
public interface UserAuth {
  /**
   * Login using Apache Shiro frameowork
   * a username (String) is added to the Session so that it can be easly retrieved 
   * in the serialization
   * @param uAuthObject
   * @return 
   */
  boolean  login(BasicAuthDto uAuthObject);
  
  void logout();
  
  /**
   * Check if a user is auth by providing its credentials
   * @param uAuthObject
   * @return 
   */
  boolean  checkUserAuth(BasicAuthDto uAuthObject);
  
  /**
   * Check user auth by email
   * @param userEmail
   * @return 
   */
  boolean  checkUserAuthByEmail(String userEmail);
  
 String getUsernameOfCurrentUser();
}

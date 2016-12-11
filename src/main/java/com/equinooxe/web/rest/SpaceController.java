/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equinooxe.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.domain.User;
import com.equinooxe.repository.UserRepository;
import java.util.List; 
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;

/**
 *
 * @author mboullouz 
 */
@Controller
public class SpaceController {
	@Inject
    private UserRepository userRepository;
	@PersistenceContext 
	private EntityManager em;
	@RequestMapping(value = "/web/spaces")
	public ModelAndView index(@RequestParam(value = "id") Optional<String> id) { 
		ModelAndView mav = new ModelAndView("/users/espaces");
		List<User> managedUserVMs= userRepository.findAll();
		mav.addObject("users",managedUserVMs); 
		mav.addObject("id",id.orElse("Id not present!"));  
		User u = em.find(User.class, new Long(1));
		mav.addObject("user",u);  
		return mav;
	}
}

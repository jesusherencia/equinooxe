/** Copyright (C) 2017 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.domain.Espace;
import com.equinooxe.repository.EspaceRepository;
import com.equinooxe.security.AuthoritiesConstants;

@Controller
@Secured(AuthoritiesConstants.USER)
public class EspaceController {
	@Inject
	EspaceRepository espaceRepository;
	
	@GetMapping("/espaces/espace/list")
	public ModelAndView list(){
		List<Espace>  espaces = new ArrayList<>();
		return new ModelAndView("espaces/espace/list").addObject("espaces", espaces);
		
	}
}

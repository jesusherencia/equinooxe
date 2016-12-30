/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.equinooxe.domain.Batiment;
import com.equinooxe.repository.BatimentRepository;
import com.equinooxe.security.AuthoritiesConstants;

/**
 * @author mboullouz
 *
 */
@Controller
@Secured(AuthoritiesConstants.USER)
public class BatimentController {
	@Inject
	BatimentService batimentService;

	@Inject
	BatimentRepository batimentRepository;

	@GetMapping("/espaces/batiment/list")
	public ModelAndView list(RedirectAttributes redirectAttributes) {
		List<Batiment> batiments = batimentRepository.findAll();
		return new ModelAndView("/espaces/batiment/list").addObject("batiments", batiments);
	}
}

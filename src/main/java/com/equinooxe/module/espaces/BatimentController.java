/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces;

import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@Autowired
	AddBatimentValidator addBatimentValidator;

	@GetMapping(EspacesConsts.URL_BATIMENT_LIST)
	public ModelAndView list(RedirectAttributes redirectAttributes) {
		List<Batiment> batiments = batimentRepository.findAll();
		return new ModelAndView(EspacesConsts.VIEW_BATIMENT_LIST).addObject("batiments", batiments);
	}

	@GetMapping(EspacesConsts.URL_BATIMENT_NEW)
	public String showForm(BatimentFormModel batimentFormModel, Model uiModel) {
		return EspacesConsts.VIEW_BATIMENT_NEW;
	}

	@PostMapping(EspacesConsts.URL_BATIMENT_SAVE)
	public String save(@Valid BatimentFormModel batimentFormModel, BindingResult bindingResult) {
		addBatimentValidator.validate(batimentFormModel, bindingResult);
		if (bindingResult.hasErrors()) {
			return EspacesConsts.VIEW_BATIMENT_NEW;
		}
		Batiment batiment = new Batiment();
		batiment.setAdresse(batimentFormModel.getAdresse());
		batiment.setNom(batimentFormModel.getNom());
		batiment=batimentRepository.saveAndFlush(batiment);

		return "redirect:" + EspacesConsts.URL_BATIMENT_SHOW + batiment.getId();
	}

	@GetMapping(EspacesConsts.URL_BATIMENT_SHOW_ID)
	public ModelAndView showForm(@PathVariable Long id) {
		return new ModelAndView(EspacesConsts.VIEW_BATIMENT_SHOW)
				   .addObject("batiment", batimentRepository.findOne(id));

	}
}

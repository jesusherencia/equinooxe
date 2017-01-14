/** Copyright (C) 2017 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.domain.Batiment;
import com.equinooxe.domain.Etage;
import com.equinooxe.repository.BatimentRepository;
import com.equinooxe.repository.EtageRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.service.util.EqLogger;

/**
 * @author mboullouz
 *
 */
@Controller
@Secured(AuthoritiesConstants.USER)
public class EtageController {
	@Inject
	BatimentRepository batimentRepository;

	@Inject
	EtageRepository etageRepository;

	/**
	 * Add an Etage to Batiment
	 * 
	 * @param id
	 * @param batimentFormModel
	 * @return new ModelAndView
	 */
	@GetMapping("/espaces/batiment/{batimentId}/etage/new")
	public ModelAndView showForm(@PathVariable Long batimentId, EtageFormModel etageFormModel) {
		return new ModelAndView("espaces/etage/form").addObject("etageFormModel",
				new EtageFormModel(batimentRepository.findOne(batimentId)));
	}

	@GetMapping("/espaces/etage/edit/{id}")
	public ModelAndView editForm(@PathVariable Long id, EtageFormModel etageFormModel) {
		return new ModelAndView("espaces/etage/form").addObject("etageFormModel",
				new EtageFormModel(etageRepository.findOne(id)));
	}

	@GetMapping("/espaces/etage/show/{id}")
	public ModelAndView show(@PathVariable Long id) {
		return new ModelAndView("espaces/etage/show").addObject("etage", etageRepository.findOne(id));
	}

	@PostMapping("/espaces/etage/save")
	public String save(@Valid EtageFormModel etageFormModel, BindingResult bindingResult, Model uiModel) {
		Batiment batiment = null;
		Etage etage = null;
		EqLogger.set(EtageController.class);
		EqLogger.info(etageFormModel.toString());
		if (bindingResult.hasErrors()) {
			EqLogger.info("Etage not valide");
			return "espaces/etage/form";
		}
		if (etageFormModel.getId() > 0) {
			etage = etageRepository.findOne(etageFormModel.getId());
			etage.setNom(etageFormModel.getNom());
			etage.setDescription(etageFormModel.getDescription());
			etageRepository.saveAndFlush(etage);
			return "redirect:/espaces/etage/show/"+ etage.getId();
		} else {
			batiment = batimentRepository.findOne(etageFormModel.getBatimentId());/* batiment will be null on submit */
			etage = new Etage(etageFormModel.getNom(), etageFormModel.getDescription(), batiment);
			EqLogger.info(etage.toString());
			etage = etageRepository.saveAndFlush(etage);
		}
		uiModel.addAttribute("batiment", etageFormModel.getBatiment());
		return "redirect:" + EspacesConsts.URL_BATIMENT_SHOW + etage.getBatiment().getId();
	}

	@GetMapping("/espaces/etage/list")
	public ModelAndView list(
			@RequestParam(value = "batimentId", defaultValue = "-1", required = false) Long batimentId) {
		List<Etage> etages = new ArrayList<>();
		if (batimentId > 0) {
			Batiment b = batimentRepository.findOne(batimentId);
			etages = etageRepository.findByBatiment(b);
		} else {
			etages = etageRepository.findAll();
		}
		return new ModelAndView("espaces/etage/list").addObject("etages", etages);
	
	}

	@PostMapping("/espaces/etage/remove")
	public String remove(@Valid RemoveFormModel removeFormModel, BindingResult bindingResult, Model uiModel) {
		EqLogger.info(" Remove data: " + removeFormModel.toString());
		if (removeFormModel.getId() > 0) {
			Etage e = etageRepository.findOne(removeFormModel.getId());
			EqLogger.info("Remove Entity: " + e.toString());
			etageRepository.delete(e);
		}

		return "redirect:" + removeFormModel.getRedirectTo();
	}

}

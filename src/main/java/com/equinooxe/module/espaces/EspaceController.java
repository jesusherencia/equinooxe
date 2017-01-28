/** Copyright (C) 2017 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.domain.Espace;
import com.equinooxe.domain.Etage;
import com.equinooxe.repository.EspaceRepository;
import com.equinooxe.repository.EtageRepository;
import com.equinooxe.security.AuthoritiesConstants;

@Controller
@Secured(AuthoritiesConstants.USER)
public class EspaceController {
	@Inject
	EspaceRepository espaceRepository;

	@Inject
	EtageRepository etageRepository;

	@GetMapping("/espaces/espace/list")
	public ModelAndView list() {
		List<Espace> espaces = espaceRepository.findAll();
		return new ModelAndView("espaces/espace/list").addObject("espaces", espaces);
	}

	@GetMapping("/espaces/etage/{etageId}/espace/new")
	public ModelAndView showForm(@PathVariable Long etageId, EspaceFormModel espaceFormModel) {
		return new ModelAndView("espaces/espace/form").addObject("espaceFormModel",
				new EspaceFormModel(etageRepository.findOne(etageId)));
	}

	@PostMapping("/espaces/espace/save")
	public String save(EspaceFormModel espaceFormModel, BindingResult bindingResult, Model uiModel) {
		Etage etage = null;
		Espace espace = null;
		if (bindingResult.hasErrors()) {
			return "espaces/etage/form";
		}
		if (espaceFormModel.getId() > 0) {
			espace = espaceRepository.findOne(espaceFormModel.getId());
			espace.setNom(espaceFormModel.getNom());
			espace.setNumero(espaceFormModel.getNumero());
			espace.setDescription(espaceFormModel.getDescription());
			espaceRepository.saveAndFlush(espace);
			return "redirect:/espaces/espace/show/" + espace.getId();
		} else {
			etage = etageRepository.findOne(espaceFormModel
					.getEtageId());/* batiment will be null on submit */
			espace = new Espace(espaceFormModel.getNom(),espaceFormModel.getNumero(), espaceFormModel.getDescription(), etage);
			espace = espaceRepository.saveAndFlush(espace);
		}
		uiModel.addAttribute("etage", espaceFormModel.getEtage());
		return "redirect:/espaces/etage/show/" + etage.getId();
	}
}

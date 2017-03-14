package com.equinooxe.module.taches;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.equinooxe.domain.TacheDefinition;
import com.google.common.collect.ImmutableList;

@Controller
public class TacheDefinitionController {
	@Autowired
	TacheDefinitionValidator addTacheDefinitionValidator;
	
	@GetMapping("/tache/definition/list")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView("tache/definition/list");
		mv.addObject("tacheDefinitions", ImmutableList.of());
		return mv;
	}
	
	@GetMapping("/tache/definition/new")
	public String showForm(TacheDefinitionFormModel tacheDefinitionForm, Model uiModel) {
		return "tache/definition/form";
	}
	
	@PostMapping("/tache/definition/save")
	public String save(@Valid TacheDefinitionFormModel tacheDefinitionForm, BindingResult bindingResult, Model uiModel,
			RedirectAttributes redirectAttributes) {
		addTacheDefinitionValidator.validate(tacheDefinitionForm, bindingResult);
		TacheDefinition tacheDef=null;
		if (bindingResult.hasErrors()) {
			return "tache/definition/form";
		}
		 
		redirectAttributes.addAttribute("id", tacheDef.getId());
		return "redirect:/user/manager/show/?id=" + tacheDef.getId();
	}
}

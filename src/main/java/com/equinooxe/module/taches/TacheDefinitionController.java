package com.equinooxe.module.taches;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.equinooxe.domain.TacheDefinition;
import com.google.common.collect.ImmutableList;

@Controller
public class TacheDefinitionController {
	@Autowired
	TacheDefinitionValidator addTacheDefinitionValidator;
	@Inject
	TacheDefinitionService tacheDefinitionService;
	@Inject
	TacheDefinitionQueryRepository tacheDefinitionQueryRep;

	@GetMapping("/tache/definition/list")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView("tache/definition/list");
		mv.addObject("tacheDefinitions", ImmutableList.of());
		return mv;
	}

	@GetMapping("/tache/definition/new")
	public String showForm(TacheDefinitionFormModel tacheDefinitionFormModel, Model uiModel) {
		return "tache/definition/form";
	}

	@PostMapping("/tache/definition/save")
	public String save(@Valid TacheDefinitionFormModel tacheDefinitionFormModel, BindingResult bindingResult,
			Model uiModel, RedirectAttributes redirectAttributes) {
		addTacheDefinitionValidator.validate(tacheDefinitionFormModel, bindingResult);

		if (bindingResult.hasErrors()) {
			return "tache/definition/form";
		}
		TacheDefinition tacheDefEntity = null;
		if (tacheDefinitionFormModel.getId() != null && tacheDefinitionFormModel.getId() > 0) {
			tacheDefEntity = tacheDefinitionService.update(tacheDefinitionFormModel.getId(),
					tacheDefinitionFormModel.getNom(), tacheDefinitionFormModel.getDescription());
		} else {
			tacheDefEntity = tacheDefinitionService.addNew(tacheDefinitionFormModel.getNom(),
					tacheDefinitionFormModel.getDescription());

		}
		return "redirect:/tache/definition/show/" + tacheDefEntity.getId();
	}
	
	@GetMapping("/tache/definition/show/{id}")
	public ModelAndView show(@PathVariable(value = "id", required = true) Long id){
		
		return new ModelAndView("tache/definition/show")
				.addObject("tacheDefinition",tacheDefinitionQueryRep.getOneById(id) );
	}
	@GetMapping("/tache/definition/edit/{id}")
	public String edit(@PathVariable(value = "id", required = true) Long id, Model uiModel) {
		uiModel.addAttribute("tacheDefinitionFormModel", new TacheDefinitionFormModel(tacheDefinitionQueryRep.getOneById(id)));
		return "tache/definition/form";
	}
}

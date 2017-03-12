package com.equinooxe.module.taches;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TacheDefinitionController {
	@GetMapping("/tache/list")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView("tache/list");
		
		return mv;
	}
}

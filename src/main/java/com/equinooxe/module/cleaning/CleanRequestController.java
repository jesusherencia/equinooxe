package com.equinooxe.module.cleaning;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.repository.CleanRequestQueryRepository;

@Controller
public class CleanRequestController {
	@Inject
	CleanRequestQueryRepository cleanRequestQueryRepository;

	@GetMapping("/cleaning/request/list")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView("cleaning/request/list");
		mv.addObject("cleanRequests",cleanRequestQueryRepository.getAll());
		return mv;
	}
}

package com.equinooxe.module.cleaning;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.domain.ManagerUser;
import com.equinooxe.repository.CleanRequestQueryRepository;
import com.equinooxe.repository.ManagerUserQueryRepository;

@Controller
public class CleanRequestController {
	@Inject
	CleanRequestQueryRepository cleanRequestQueryRepository;
	
	@Inject
	ManagerUserQueryRepository managerUserQueryRep;

	@GetMapping("/cleaning/request/list")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView("cleaning/request/list");
		mv.addObject("cleanRequests",cleanRequestQueryRepository.getAll());
		return mv;
	}
	@GetMapping("/cleaning/list/per/user/{id}")
	public ModelAndView getListPerUser( @PathVariable Long id) {
		ModelAndView mv    = new ModelAndView("cleaning/request/list");
		ManagerUser  mUser =  managerUserQueryRep.getOneById(id);
		mv.addObject("cleanRequests",cleanRequestQueryRepository.getByManager(mUser))
		  .addObject("manager", mUser);
		return mv;
	}
	
}

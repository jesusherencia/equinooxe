package com.equinooxe.module.cleaning;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.Espace;
import com.equinooxe.domain.ManagerUser;
import com.equinooxe.repository.AgentUserQueryRepository;
import com.equinooxe.repository.CleanRequestQueryRepository;
import com.equinooxe.repository.EspaceQueryRepository;
import com.equinooxe.repository.ManagerUserQueryRepository;

@Controller
public class CleanRequestController {
	@Inject
	CleanRequestQueryRepository cleanRequestQueryRepository;

	@Inject
	ManagerUserQueryRepository managerUserQueryRep;

	@Inject
	AgentUserQueryRepository agentUserQueryRep;

	@Inject
	EspaceQueryRepository espaceQueryRep;

	@GetMapping("/cleaning/request/list")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView("cleaning/request/list");
		mv.addObject("cleanRequests", cleanRequestQueryRepository.getAll());
		return mv;
	}

	@GetMapping("/cleaning/request/new")
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView("cleaning/request/form");
		List<AgentUser> availableAgents = agentUserQueryRep.getAll();
		List<Espace> availableEspace = espaceQueryRep.getAll();
		CleanRequestFormModel cleanRequestFormModel = new CleanRequestFormModel(availableAgents, availableEspace);
		mv.addObject("cleanRequestFormModel", cleanRequestFormModel);
		return mv;
	}

	@GetMapping("/cleaning/list/per/manager/{id}")
	public ModelAndView getListPerUser(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("cleaning/request/list");
		ManagerUser mUser = managerUserQueryRep.getOneById(id);
		mv.addObject("cleanRequests", cleanRequestQueryRepository.getByManager(mUser)).addObject("manager", mUser);
		return mv;
	}

	@GetMapping("/cleaning/list/per/agent/{id}")
	public ModelAndView getListPerAgent(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("cleaning/request/list");
		AgentUser aUser = agentUserQueryRep.getOneById(id);
		mv.addObject("cleanRequests", cleanRequestQueryRepository.getByAgent(aUser));
		mv.addObject("agent", aUser);
		return mv;
	}

}

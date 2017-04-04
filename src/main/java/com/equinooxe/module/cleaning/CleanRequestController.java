package com.equinooxe.module.cleaning;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.CleanRequest;
import com.equinooxe.domain.Espace;
import com.equinooxe.domain.ManagerUser;
import com.equinooxe.domain.util.EqUtils;
import com.equinooxe.repository.AgentUserQueryRepository;
import com.equinooxe.repository.CleanRequestQueryRepository;
import com.equinooxe.repository.CleanRequestRepository;
import com.equinooxe.repository.EspaceQueryRepository;
import com.equinooxe.repository.EspaceRepository;
import com.equinooxe.repository.EtageRepository;
import com.equinooxe.repository.ManagerUserQueryRepository;
import com.equinooxe.security.SecurityUtils;

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

	@Inject
	EspaceRepository espaceRepository;

	@Inject
	EtageRepository etageRepository;

	@Inject
	CleanRequestRepository cleanRequestRepo;
	@Inject
	ManagerUserQueryRepository managerQueryRep;
	
	@GetMapping("/cleaning/request/list")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView("cleaning/request/list");
		mv.addObject("cleanRequests", cleanRequestQueryRepository.getAll());
		return mv;
	}

	@GetMapping("/cleaning/request/new")
	public ModelAndView showForm(CleanRequestFormModel cleanRequestFormModel) {
		ModelAndView mv = new ModelAndView("cleaning/request/form");
		List<AgentUser> availableAgents = agentUserQueryRep.getAll();
		List<Espace> availableEspaces = espaceQueryRep.getAll();
		cleanRequestFormModel.setAvailableAgents(availableAgents);
		cleanRequestFormModel.setAvailableEspaces(availableEspaces);
		mv.addObject("cleanRequestFormModel", cleanRequestFormModel);
		return mv;
	}

	@PostMapping("/cleaning/request/save")
	public String save(CleanRequestFormModel cleanRequestFormModel, BindingResult bindingResult, Model uiModel) throws Exception {
		if (bindingResult.hasErrors()) {
			return "/cleaning/request/new";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		Espace espace = espaceRepository.findOne(cleanRequestFormModel.getEspaceId());
		AgentUser agent = agentUserQueryRep.getOneById(cleanRequestFormModel.getAgentId());
		CleanRequest cleanRequest = null;
		if (cleanRequestFormModel.getId() > 0) {
			cleanRequest = cleanRequestQueryRepository.getOneById(cleanRequestFormModel.getId());
		} else {
			cleanRequest = new CleanRequest();
		}

		cleanRequest.setAgent(agent);
		cleanRequest.setEspace(espace);
		cleanRequest.setInstructions(cleanRequestFormModel.getInstructions());
		cleanRequest.setDeadlineDate(LocalDateTime.parse(cleanRequestFormModel.getDeadlineDateStr(), formatter));
		cleanRequest.setStartAt(LocalDateTime.parse(cleanRequestFormModel.getStartAtStr(), formatter));
		ManagerUser um = managerQueryRep.getCurrent();
		if(um==null){
		  throw new Exception(" User not found "+ SecurityUtils.getCurrentUserLogin());
		}
		cleanRequest.setManager(um);
		cleanRequest= cleanRequestRepo.saveAndFlush(cleanRequest);
		
		uiModel.addAttribute("cleanRequest", cleanRequest);
		return "redirect:/cleaning/request/show/" + cleanRequest.getId();
	}

	@GetMapping("/cleaning/request/show/{id}")
	public ModelAndView show(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("cleaning/request/show");
		CleanRequest cleanRequest = cleanRequestQueryRepository.getOneById(id);
		mv.addObject("cleanRequest", cleanRequest);
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

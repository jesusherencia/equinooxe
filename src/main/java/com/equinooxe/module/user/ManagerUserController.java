package com.equinooxe.module.user;

import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
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

import com.equinooxe.domain.Authority;
import com.equinooxe.domain.CleanRequest;
import com.equinooxe.domain.ManagerUser;
import com.equinooxe.repository.AuthorityRepository;
import com.equinooxe.repository.CleanRequestQueryRepository;
import com.equinooxe.repository.CleanRequestRepository;
import com.equinooxe.repository.ManagerUserQueryRepository;
import com.equinooxe.repository.ManagerUserRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.google.common.collect.ImmutableList;

import javassist.tools.web.BadHttpRequest;

@Controller
@Secured(AuthoritiesConstants.USER)
public class ManagerUserController {

	@Inject
	AuthorityRepository authorityRepo;

	@Inject
	private ManagerUserService managerUserService;

	@Inject
	private ManagerUserRepository managerUserRepo;

	@Inject
	private CleanRequestQueryRepository cleanRequestQueryRep;

	@Inject
	private CleanRequestRepository cleanRequestRepo;

	@Inject
	EntityManager entityManager;

	@Autowired
	AddManagerValidator addManagerValidator;

	@Autowired
	ManagerUserQueryRepository managerUserQueryRepo;

	@GetMapping("/user/manager/new")
	public String showForm(ManagerUserForm managerUserForm, Model uiModel) {
		managerUserForm.setAvailableAutorities(new HashSet<Authority>(authorityRepo.findAll()));
		return "user/manager/form";
	}

	@GetMapping("/user/manager/edit/{id}")
	public String editForm(@PathVariable(value = "id", required = true) Long id, ManagerUserForm managerUserForm,
			Model uiModel, RedirectAttributes redirectAttributes) throws BadHttpRequest {
		ManagerUser u = managerUserQueryRepo.getOneById(id);
		managerUserForm = new ManagerUserForm(u, new HashSet<Authority>(authorityRepo.findAll()));
		uiModel.addAttribute("managerUserForm", managerUserForm);
		return "user/manager/form";
	}

	@PostMapping("/user/manager/save")
	public String save(@Valid ManagerUserForm managerUserForm, BindingResult bindingResult, Model uiModel,
			RedirectAttributes redirectAttributes) {
		addManagerValidator.validate(managerUserForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "user/manager/form";
		}
		ManagerUser user;
		if (managerUserForm.getId() != null) {
			user = managerUserService.updateUserFrom(managerUserForm);
		} else {
			user = managerUserService.createManagerUser(managerUserForm.getLogin(), managerUserForm.getPassword(),
					managerUserForm.getFirstName(), managerUserForm.getLastName(),
					managerUserForm.getEmail().toLowerCase(), "fr", true);
		}
		redirectAttributes.addAttribute("id", user.getId());
		return "redirect:/user/manager/show/?id=" + user.getId();
	}

	@GetMapping("/user/manager/show/{id}")
	public String show(@PathVariable(value = "id", required = true) Long id, Model uiModel,
			RedirectAttributes redirectAttributes) {
		ManagerUser user = managerUserQueryRepo.getOneById(id);
		List<CleanRequest> cleanReq = cleanRequestQueryRep.getByManager(user);
		uiModel.addAttribute("user", user).addAttribute("cleanRequests", cleanReq);
		return "user/manager/show";
	}

	@GetMapping("/user/manager/delete/{id}")
	public String delete(@PathVariable(value = "id", required = true) Long id, Model uiModel,
			RedirectAttributes redirectAttributes) {
		ManagerUser u = managerUserQueryRepo.getOneById(id);
		u.setDeleted(true);
		managerUserRepo.saveAndFlush(u);
		return "redirect:/user/manager/show/" + u.getId();
	}

	@GetMapping("/user/manager/delete-hard/{id}")
	public String deleteHard(@PathVariable(value = "id", required = true) Long id, Model uiModel,
			RedirectAttributes redirectAttributes) {
		ManagerUser u = managerUserQueryRepo.getOneById(id);
		List<CleanRequest> cleanReq = cleanRequestQueryRep.getByManager(u);
		cleanReq.stream().forEach(cr -> {
			cr.setManager(null);
			cleanRequestRepo.saveAndFlush(cr);
		});

		managerUserRepo.delete(ImmutableList.of(u));
		return "redirect:/user/manager/list";
	}

	@GetMapping("/user/manager/list")
	public ModelAndView list(Model uiModel, RedirectAttributes redirectAttributes) {
		List<ManagerUser> users = managerUserRepo.findAll();
		ModelAndView mv = new ModelAndView("user/manager/list").addObject("users", users);
		return mv;
	}

}

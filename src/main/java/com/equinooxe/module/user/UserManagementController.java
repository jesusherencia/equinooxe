package com.equinooxe.module.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.equinooxe.domain.QManagerUtilisateur;
import com.equinooxe.domain.QUser;
import com.equinooxe.domain.User;
import com.equinooxe.repository.UserQueryRepository;
import com.equinooxe.repository.UserRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.service.UserService;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.ui.Model;

@Controller
@Secured(AuthoritiesConstants.USER)
public class UserManagementController {

	@Inject
	private UserRepository userRepository;

	@Inject
	private UserService userService;

	@Inject
	EntityManager entityManager;

	@Autowired
	AddUserValidator addUserValidator;

	@Autowired
	UserQueryRepository userQueryRepo;

	@GetMapping("/user/new")
	public String showForm(@RequestParam(value = "id", required = false) Long id, UserForm userForm, Model uiModel) {
		if (id != null && id > 0) {
			User u = userQueryRepo.getOneById(id);
			userForm = new UserForm(u);
			uiModel.addAttribute("userForm",userForm);
		}
		return "/user/form";
	}

	@PostMapping("/user/save")
	public String save(@Valid UserForm userForm, BindingResult bindingResult, Model uiModel,
			RedirectAttributes redirectAttributes) {
		addUserValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/user/form";
		}
		User user;
		if (userForm.getId() != null) {
			user = userService.updateUser(userForm.getFirstName(), userForm.getLastName(),
					userForm.getEmail().toLowerCase(), "fr").get();
		} else {
			user = userService.createUser(userForm.getLogin(), userForm.getPassword(), userForm.getFirstName(),
					userForm.getLastName(), userForm.getEmail().toLowerCase(), "fr");
		}

		redirectAttributes.addAttribute("id", user.getId());
		return "redirect:/user/show";
	}

	@GetMapping("/user/show")
	public String show(@RequestParam(value = "id", required = true) Long id, Model uiModel,
			RedirectAttributes redirectAttributes) {
		User u = userQueryRepo.getOneById(id);
		uiModel.addAttribute("user", u);
		return "/user/show";
	}

}

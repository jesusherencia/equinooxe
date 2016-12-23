package com.equinooxe.module.user;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.equinooxe.config.ThymeleafConfiguration;
import com.equinooxe.domain.User;
import com.equinooxe.repository.UserQueryRepository;
import com.equinooxe.repository.UserRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.service.UserService;

@Controller
@Secured(AuthoritiesConstants.USER)
public class UserManagementController {
	private final Logger log = LoggerFactory.getLogger(ThymeleafConfiguration.class);
	@Inject
	private UserService userService;

	@Inject
	private UserRepository userRepository;

	@Inject
	EntityManager entityManager;

	@Autowired
	AddUserValidator addUserValidator;

	@Autowired
	UserQueryRepository userQueryRepo;

	@GetMapping("/user/new")
	public String showForm(UserForm userForm, Model uiModel) {
		return "/user/form";
	}

	@GetMapping("/user/edit")
	public String editForm(@RequestParam(value = "id", required = true) Long id, UserForm userForm, Model uiModel,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("flashMessage", "editer .utilisateur.existant");
		User u = userQueryRepo.getOneById(id);
		userForm = new UserForm(u);
		uiModel.addAttribute("userForm", userForm);
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
		redirectAttributes.addFlashAttribute("flashMessage", "operation.effectuee.avec.succes");
		return "redirect:/user/show";
	}

	@GetMapping("/user/show")
	public String show(@RequestParam(value = "id", required = true) Long id, Model uiModel,
			RedirectAttributes redirectAttributes) {
		User u = userQueryRepo.getOneById(id);
		uiModel.addAttribute("user", u);
		return "/user/show";
	}

	@GetMapping("/user/list")
	public String list(@RequestParam(value = "filter", required = false) String filter, Model uiModel,
			RedirectAttributes redirectAttributes) {
		List<User> users = userQueryRepo.getAll() /*userRepository.findAll();*/ ;
		uiModel.addAttribute("users", users);
		return "/user/list";
	}

}

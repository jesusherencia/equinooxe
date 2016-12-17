package com.equinooxe.module.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.domain.User;
import com.equinooxe.repository.UserRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.service.UserService;
import org.springframework.ui.Model;

@Controller
@Secured(AuthoritiesConstants.USER)
public class UserManagementController {

	@Inject
	private UserRepository userRepository;

	@Inject
	private UserService userService;

	@GetMapping("/user/new")
	public String showForm(UserForm userForm) {
		return "/user/form";
	}

	@PostMapping("/user/new")
	public ModelAndView checkPersonInfo(@Valid UserForm userForm, BindingResult bindingResult, Model uiModel) {
		
		if (bindingResult.hasErrors()) {
			 return new ModelAndView("/user/form").addObject("erreurs","");
		}
		Map<String, String> errors= userFormErrors(userForm);
		if(errors.size()>0){
			 return new ModelAndView("/user/form").addObject("erreurs",errors);
		}

		User user = userService.createUser(userForm.getLogin(), userForm.getPassword(), userForm.getFirstName(),
				userForm.getLastName(), userForm.getEmail().toLowerCase(), "fr");
		return new ModelAndView("/user/show");
	}

	private Map<String, String> userFormErrors(UserForm userForm) {
		Map<String, String> errors = new HashMap<>();
		if (userRepository.findOneByLogin(userForm.getLogin().toLowerCase()).isPresent()) {
			errors.put("login", "Login déjà utilisé");
		}
		if (userRepository.findOneByEmail(userForm.getEmail()).isPresent()) {
			errors.put("email", "Email déjà utilisé");
		}

		return errors;
	}
}

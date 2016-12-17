package com.equinooxe.module.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

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

	@GetMapping("/user/new")
	public String showForm(UserForm userForm) {
		return "/user/form";
	}

	@PostMapping("/user/new")
	public String checkPersonInfo(@Valid UserForm userForm, BindingResult bindingResult,Model uiModel, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			 return  "/user/form";
		}
		Map<String, String> errors= userFormErrors(userForm);
		if(errors.size()>0){
			 uiModel.addAttribute("erreurs",errors);
			 return  "/user/form";
		}

		User user = userService.createUser(userForm.getLogin(), userForm.getPassword(), userForm.getFirstName(),
				userForm.getLastName(), userForm.getEmail().toLowerCase(), "fr");
		redirectAttributes.addAttribute("id", user.getId());
		return "redirect:/user/show";
	}
	
	@GetMapping("/user/show")
	public String show(@RequestParam(value="id", required=true) Long id, Model uiModel, RedirectAttributes redirectAttributes) {
		QUser qUser = QUser.user;
		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		User u = queryFactory.selectFrom(qUser).where(qUser.id.eq(id)).fetchOne();
		uiModel.addAttribute("user",u);
		return "/user/show";
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

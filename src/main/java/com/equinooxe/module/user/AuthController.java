package com.equinooxe.module.user;

import java.util.HashSet;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.domain.Authority;
import com.equinooxe.domain.QUser;
import com.equinooxe.domain.User;
import com.equinooxe.repository.AuthorityRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.service.util.EqLogger;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Controller
public class AuthController {
	@Inject
	EntityManager entityManager;
    
	@Inject
	AuthorityRepository authorityRepo;
	
	@Autowired
	AddManagerValidator addManagerValidator;

	@Inject
	ManagerUserService managerUserService;
	
	@GetMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		return new ModelAndView("login/form").addObject("newUser", new User());
	}

	@GetMapping("/register")
	public ModelAndView register(Model uiModel) {
		uiModel.addAttribute("errors", null);
		ManagerUserForm form = new ManagerUserForm(new HashSet<Authority>(authorityRepo.findAll()));
		return new ModelAndView("login/register").addObject("managerUserForm",form);
	}

	@PostMapping("/register")
	public String saveRegistration(@Validated ManagerUserForm managerUserForm, BindingResult bindingResult, Model uiModel) {
		addManagerValidator.validate(managerUserForm, bindingResult); 
		new EqLogger().json("Form errors! ", bindingResult.getAllErrors());
		if (bindingResult.hasErrors()) {
			return "login/register";
		}
		User user = managerUserService.createManagerUser(managerUserForm.getLogin(), managerUserForm.getPassword(),
				managerUserForm.getFirstName(), managerUserForm.getLastName(), managerUserForm.getEmail().toLowerCase(),
				"fr", true);
		uiModel.addAttribute("newUser", user);
		return  "login/form";
	}

	/**
	 * Reconnect the user: sync the session with the spring security session
	 * initialized by ajax login
	 * 
	 * @param request
	 * @return
	 */
	@Secured(AuthoritiesConstants.USER)
	@GetMapping("/reconnect")
	public String reconnect(HttpServletRequest request) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		UserDetails principal = (UserDetails) authentication.getPrincipal();
		if (principal == null || principal.getUsername() == null) {
			return "redirect:/";
		}
		QUser qUser = QUser.user;
		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		User u = queryFactory.selectFrom(qUser).where(qUser.login.eq(principal.getUsername())).fetchOne();
		request.getSession().setAttribute("user", u);
		return "redirect:/home";
	}

}

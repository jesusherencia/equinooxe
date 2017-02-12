package com.equinooxe.module.user;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.equinooxe.domain.User;
import com.equinooxe.repository.AuthorityRepository;
import com.equinooxe.repository.UserQueryRepository;
import com.equinooxe.repository.UserRepository;
import com.equinooxe.security.AuthoritiesConstants;

@Controller
@Secured(AuthoritiesConstants.USER)
public class UserManagementController {
	private final Logger log = LoggerFactory.getLogger(UserManagementController.class);

	@Inject
	private UserRepository userRepository;

	@Inject
	AuthorityRepository authorityRepo;

	@Inject
	EntityManager entityManager;

	@Autowired
	AddUserValidator addUserValidator;

	@Autowired
	UserQueryRepository userQueryRepo;

	@GetMapping("/user/show")
	public String show(@RequestParam(value = "id", required = true) Long id, Model uiModel,
			RedirectAttributes redirectAttributes) {
		User u = userQueryRepo.getOneById(id);
		uiModel.addAttribute("user", u);
		return "user/show";
	}

	@GetMapping("/user/list")
	public ModelAndView list(Model uiModel, RedirectAttributes redirectAttributes) {
		List<User> users = userRepository.findAll()  ;
		ModelAndView mv = new ModelAndView("user/list").addObject("users", users);
		return mv;
	}

}

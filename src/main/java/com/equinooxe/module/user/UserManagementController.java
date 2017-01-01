package com.equinooxe.module.user;

 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.equinooxe.config.ThymeleafConfiguration;
import com.equinooxe.domain.Authority;
import com.equinooxe.domain.User;
import com.equinooxe.repository.AuthorityRepository;
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
	AuthorityRepository authorityRepo;
	
	@Inject
	private UserRepository userRepo;

	@Inject
	EntityManager entityManager;

	@Autowired
	AddUserValidator addUserValidator;

	@Autowired
	UserQueryRepository userQueryRepo;

	@GetMapping("/user/new")
	public String showForm(UserForm userForm, Model uiModel) {
		userForm.setAvelaibleAutorities(new HashSet<Authority>(authorityRepo.findAll()));
		return "user/form";
	}

	@GetMapping("/user/edit")
	public String editForm(@RequestParam(value = "id", required = true) Long id, UserForm userForm, Model uiModel,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("flashMessage", "editer .utilisateur.existant");
		User u = userQueryRepo.getOneById(id);
		userForm = new UserForm(u, new HashSet<Authority>(authorityRepo.findAll()) );
		uiModel.addAttribute("userForm", userForm); 
		return "user/form";
	} 

	@PostMapping("/user/save")
	public String save(@Valid UserForm userForm, BindingResult bindingResult, Model uiModel,
			RedirectAttributes redirectAttributes) {
		addUserValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "user/form";
		}
		User user;
		log.info("\n============= U.ID: "+userForm.getId());
		if (userForm.getId() != null) {
			 user = userQueryRepo.getOneById(userForm.getId()); 
			 user.setFirstName(userForm.getFirstName());
			 user.setEmail(userForm.getEmail());
			 user.setLastName(userForm.getLastName());
			 user.setLogin(userForm.getLogin());
			 if(userForm.getPassword()!=null && userForm.getPassword().length()>=4){
				 user.setPassword(userForm.getPassword());
			 }
			 Set<Authority> selectedAut= new HashSet<>();
			 for(String authName : userForm.getAutorities()){ 
				 if(authName!=null && authName.length()>1){
					 selectedAut.add(authorityRepo.findOne(authName));
				 }
			 }
			 user.setAuthorities(selectedAut);
			 userRepo.saveAndFlush(user);
			 log.info("\n============= User {} updated ",user);
			
		} else {
			user = userService.createUser(userForm.getLogin(), userForm.getPassword(), userForm.getFirstName(),
					userForm.getLastName(), userForm.getEmail().toLowerCase(), "fr");
		}

		redirectAttributes.addAttribute("id", user.getId());
		redirectAttributes.addFlashAttribute("flashMessage", "operation.effectuee.avec.succes");
		return "redirect:/user/show/?id="+user.getId();
	}

	@GetMapping("/user/show")
	public String show(@RequestParam(value = "id", required = true) Long id, Model uiModel,
			RedirectAttributes redirectAttributes) {
		User u = userQueryRepo.getOneById(id);
		uiModel.addAttribute("user", u);
		return "user/show";
	}

	@GetMapping("/user/list")
	public ModelAndView list(Model uiModel,
			RedirectAttributes redirectAttributes) {
		List<User> users = userQueryRepo.getAll() /*userRepository.findAll();*/ ;
		uiModel.addAttribute("users", users);
		ModelAndView mv= new ModelAndView("/user/list").addObject("users", users);
		 return mv;
	}

}

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

import com.equinooxe.domain.Authority;
import com.equinooxe.domain.ManagerUser;
import com.equinooxe.domain.User;
import com.equinooxe.repository.AuthorityRepository;
import com.equinooxe.repository.ManagerUserQueryRepository;
import com.equinooxe.repository.UserRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.service.UserService;

@Controller
@Secured(AuthoritiesConstants.USER)
public class ManagerUserController {
	private final Logger log = LoggerFactory.getLogger(ManagerUserController.class);
	@Inject
	private UserService userService;
	
	@Inject
	private UserRepository userRepository;
	
	@Inject
	AuthorityRepository authorityRepo;
	
	@Inject
	private UserRepository userRepo;

	@Inject
	EntityManager entityManager;

	@Autowired
	AddUserValidator addUserValidator;

	@Autowired
	ManagerUserQueryRepository managerUserQueryRepo;

	@GetMapping("/user/manager/new")
	public String showForm(ManagerUserForm managerUserForm, Model uiModel) {
		managerUserForm.setAvelaibleAutorities(new HashSet<Authority>(authorityRepo.findAll()));
		return "user/form";
	}

	@GetMapping("/user/manager/edit")
	public String editForm(@RequestParam(value = "id", required = true) Long id, ManagerUserForm managerUserForm, Model uiModel,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("flashMessage", "editer.utilisateur.existant");
		ManagerUser u = managerUserQueryRepo.getOneById(id);
		managerUserForm = new ManagerUserForm(u, new HashSet<Authority>(authorityRepo.findAll()) );
		uiModel.addAttribute("userForm", managerUserForm); 
		return "user/form";
	} 

	@PostMapping("/user/manager/save")
	public String save(@Valid ManagerUserForm managerUserForm, BindingResult bindingResult, Model uiModel,
			RedirectAttributes redirectAttributes) {
		addUserValidator.validate(managerUserForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "user/form";
		}
		ManagerUser user;
		if (managerUserForm.getId() != null) {
			 user  = managerUserQueryRepo.getOneById(managerUserForm.getId()); 
			 user.setFirstName(managerUserForm.getFirstName());
			 user.setEmail(managerUserForm.getEmail());
			 user.setLastName(managerUserForm.getLastName());
			 user.setLogin(managerUserForm.getLogin());
			 if(managerUserForm.getPassword()!=null && managerUserForm.getPassword().length()>=4){
				 user.setPassword(managerUserForm.getPassword());
			 }
			 Set<Authority> selectedAut= new HashSet<>();
			 for(String authName : managerUserForm.getAutorities()){ 
				 if(authName!=null && authName.length()>1){
					 selectedAut.add(authorityRepo.findOne(authName));
				 }
			 }
			 user.setAuthorities(selectedAut);
			 userRepo.saveAndFlush(user);
			 log.info("\n============= User {} updated ",user);
		} else {
		 user = userService.createManagerUser(managerUserForm.getLogin(), managerUserForm.getPassword(), managerUserForm.getFirstName(),
					managerUserForm.getLastName(), managerUserForm.getEmail().toLowerCase(), "fr");
		}
		redirectAttributes.addAttribute("id",user.getId());
		return "redirect:/user/show/?id="+user.getId();
	}

	@GetMapping("/user/manager/show")
	public String show(@RequestParam(value = "id", required = true) Long id, Model uiModel,
			RedirectAttributes redirectAttributes) {
		User u = managerUserQueryRepo.getOneById(id);
		uiModel.addAttribute("user", u);
		return "user/show";
	}

	@GetMapping("/user/manager/list")
	public ModelAndView list(Model uiModel,
			RedirectAttributes redirectAttributes) {
		List<User> users =userRepository.findAll()  /*userRepository.findAll(); userQueryRepo.getAll()*/ ;
		ModelAndView mv= new ModelAndView("user/list").addObject("users", users);
		 return mv;
	}

}

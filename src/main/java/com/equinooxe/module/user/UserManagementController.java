package com.equinooxe.module.user;

import javax.validation.Valid;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.equinooxe.security.AuthoritiesConstants;


@Controller
@Secured(AuthoritiesConstants.USER)
public class UserManagementController {
	@GetMapping("/user/new")
    public String showForm(UserForm userForm) {
        return "/user/form";
    }

    @PostMapping("/user/new")
    public String checkPersonInfo(@Valid UserForm userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/user/form";
        }

        return "redirect:/";
    }
}

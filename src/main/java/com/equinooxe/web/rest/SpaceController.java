/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equinooxe.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.equinooxe.domain.QUser;
import com.equinooxe.domain.User;
import com.equinooxe.repository.UserRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

/**
 *
 * @author mboullouz
 */
@Controller
public class SpaceController {
	@Inject
	private UserRepository userRepository;

	@Inject
	EntityManager entityManager;

	@RequestMapping(value = "/web/spaces")
	@Secured(AuthoritiesConstants.USER)
	public ModelAndView index(@RequestParam(value = "id") Optional<String> id) {
		ModelAndView modelView = new ModelAndView("/users/espaces");
		List<User> managedUserVMs = userRepository.findAll();
		modelView.addObject("users", managedUserVMs);
		modelView.addObject("id", id.orElse("Id not present!"));
		QUser qUser = QUser.user;
		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		User u = queryFactory.selectFrom(qUser).where(qUser.id.eq(new Long(1))).fetchOne();
		// User u = (User) userSpecRepository.findOne(UserSpecs.firstRecord());
		 

		modelView.addObject("user", u);
		return modelView;
	}
}

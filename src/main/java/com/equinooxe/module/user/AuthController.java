package com.equinooxe.module.user;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.equinooxe.domain.QUser;
import com.equinooxe.domain.User;
import com.equinooxe.security.AuthoritiesConstants;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Controller
@Secured(AuthoritiesConstants.USER)
public class AuthController {
	@Inject
	EntityManager entityManager;
	
	/**
	 * Reconnect the user: sync the session with the spring security session 
	 * initialized by ajax login
	 * @param request
	 * @return
	 */
	@GetMapping("/reconnect") 
	public String reconnect(HttpServletRequest request){
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		UserDetails principal = (UserDetails) authentication.getPrincipal();
		if(principal==null || principal.getUsername()==null){
			return "redirect:/";
		}
		QUser qUser = QUser.user;
		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		User u = queryFactory.selectFrom(qUser).where(qUser.login.eq(principal.getUsername())).fetchOne();
		request.getSession().setAttribute("user", u);
		return "redirect:/home";
	}
	 
	
}

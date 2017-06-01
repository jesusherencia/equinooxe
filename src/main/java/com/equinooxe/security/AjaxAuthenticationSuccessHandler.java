package com.equinooxe.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.equinooxe.config.WebConfigurer;
import com.equinooxe.domain.QUser;
import com.equinooxe.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * Spring Security success handler, specialized for Ajax requests.
 */
@Component
public class AjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);
	@Inject
	EntityManager entityManager;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		/** add the user to session */
		response.setStatus(HttpServletResponse.SC_OK);
 		addUserToSession(request);
 		response.sendRedirect("/home");
	}

	public void addUserToSession(HttpServletRequest request) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		UserDetails principal = (UserDetails) authentication.getPrincipal();
		QUser qUser = QUser.user;
		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		User u = queryFactory.selectFrom(qUser).where(qUser.login.eq(principal.getUsername())).fetchOne();
		request.getSession().setAttribute("user", u);
		log.debug("\n=======================\n "
				+ "=================  " + "User with login: " + u.getLogin()
			    + "  is registred in the session!" + "\n======================="
		         + "\n ==========================");
	}
}

package com.equinooxe.web.rest;

import com.equinooxe.config.Constants;
import com.codahale.metrics.annotation.Timed;
import com.equinooxe.domain.User;
import com.equinooxe.repository.UserRepository;
import com.equinooxe.repository.search.UserSearchRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.service.MailService;
import com.equinooxe.service.UserService;
import com.equinooxe.web.rest.vm.ManagedUserVM;
import com.equinooxe.web.rest.util.HeaderUtil;
import com.equinooxe.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing users.
 */
@RestController
@RequestMapping("/api")
public class SpaceResource {

	private final Logger log = LoggerFactory.getLogger(SpaceResource.class);

	@Inject
	private UserRepository userRepository;

	@Inject
	private MailService mailService;

	@Inject
	private UserService userService;

	@Inject
	private UserSearchRepository userSearchRepository;

	/**
	 * POST /users : Creates a new user.
	 * <p>
	 * Creates a new user if the login and email are not already used, and sends
	 * an mail with an activation link. The user needs to be activated on
	 * creation.
	 * </p>
	 *
	 * @param managedUserVM
	 *            the user to create
	 * @param request
	 *            the HTTP request
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new user, or with status 400 (Bad Request) if the login or email
	 *         is already in use
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@GetMapping("/spaces")
	@Timed
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<?> createUser() throws URISyntaxException {
		log.debug("REST request to save Space : {}", "");

		// Lowercase the user login before comparing with database
		return ResponseEntity.created(new URI("/api/spaces/"))
				.headers(HeaderUtil.createAlert("A user is created with identifier ", ""))
				.body(new String("Body should list spaces :"));
	}

	@PostMapping("/spaces")
	@Secured(AuthoritiesConstants.USER)
	public ResponseEntity<?> postSpace(@RequestBody SpaceDTO space) {
		log.debug("REST request space body : {}", space.name);
		
		return ResponseEntity.ok()
				.headers(HeaderUtil.createAlert("A user is created with identifier ", ""))
				.body(space);
	}
}

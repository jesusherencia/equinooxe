package com.equinooxe.web.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.equinooxe.domain.Location;
import com.equinooxe.domain.QLocation;
import com.equinooxe.security.AuthoritiesConstants;
import com.querydsl.jpa.impl.JPAQueryFactory;

@RestController
@RequestMapping("/api/location")
@Secured(AuthoritiesConstants.USER)
public class LocationResource {
	@Inject
	EntityManager entityManager;
	JPAQueryFactory queryFactory;

	@GetMapping("/all")
	@Timed
	public ResponseEntity<List<Location>> getAccount() {
		QLocation qLocation = QLocation.location;
	    queryFactory = new JPAQueryFactory(entityManager);
	    List<Location> locations = (List<Location>)queryFactory.selectFrom(qLocation).fetch();
	    return ResponseEntity.ok().body(locations);
	}
}

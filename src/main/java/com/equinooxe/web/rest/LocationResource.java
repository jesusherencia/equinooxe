package com.equinooxe.web.rest;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.equinooxe.domain.Espace;
import com.equinooxe.repository.EspaceQueryRepository;
import com.equinooxe.repository.EspaceRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.web.rest.util.HeaderUtil;

@RestController
@RequestMapping("/api/location")
@Secured(AuthoritiesConstants.USER)
public class LocationResource {
	@Inject
	EspaceQueryRepository locationQueryRepo;
	
	@Inject 
	EspaceRepository locationRepo;
	
	@GetMapping("/all")
	@Timed
	public ResponseEntity<List<Espace>> getAccount() {
	    List<Espace> espaces = locationRepo.findAll();
	    return ResponseEntity.ok().body(espaces);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Espace> getOne(@PathVariable Long id) {
		Espace espace = locationRepo.findOne(id);
		return ResponseEntity.ok().body(espace);
	}
	
    @PostMapping("/")
    @Timed
    public ResponseEntity<Espace> saveLocation(@Valid @RequestBody Espace espace) {
        return  ResponseEntity.ok().body(locationRepo.saveAndFlush(espace));
    }
    
    @PostMapping("/update")
    @Timed
    public ResponseEntity<Espace> updateLocation(@Valid @RequestBody Espace espace) {
        Espace existingLocation = locationRepo.findOne(espace.getId());
        if (existingLocation==null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("location-management", "locationNotExists", "Espace not exists")).body(null);
        }
        return  ResponseEntity.ok().body(locationRepo.saveAndFlush(espace));
    }
	
}

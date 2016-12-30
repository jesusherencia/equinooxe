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
import com.equinooxe.domain.Location;
import com.equinooxe.repository.LocationQueryRepository;
import com.equinooxe.repository.LocationRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.web.rest.util.HeaderUtil;

@RestController
@RequestMapping("/api/location")
@Secured(AuthoritiesConstants.USER)
public class LocationResource {
	@Inject
	LocationQueryRepository locationQueryRepo;
	
	@Inject 
	LocationRepository locationRepo;
	
	@GetMapping("/all")
	@Timed
	public ResponseEntity<List<Location>> getAccount() {
	    List<Location> locations = locationRepo.findAll();
	    return ResponseEntity.ok().body(locations);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Location> getOne(@PathVariable Long id) {
		Location location = locationRepo.findOne(id);
		return ResponseEntity.ok().body(location);
	}
	
    @PostMapping("/")
    @Timed
    public ResponseEntity<Location> saveLocation(@Valid @RequestBody Location location) {
        return  ResponseEntity.ok().body(locationRepo.saveAndFlush(location));
    }
    
    @PostMapping("/update")
    @Timed
    public ResponseEntity<Location> updateLocation(@Valid @RequestBody Location location) {
        Location existingLocation = locationRepo.findOne(location.getId());
        if (existingLocation==null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("location-management", "locationNotExists", "Location not exists")).body(null);
        }
        return  ResponseEntity.ok().body(locationRepo.saveAndFlush(location));
    }
	
}

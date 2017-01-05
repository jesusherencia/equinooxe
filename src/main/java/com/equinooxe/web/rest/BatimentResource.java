package com.equinooxe.web.rest;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.equinooxe.domain.Batiment;
import com.equinooxe.domain.Espace;
import com.equinooxe.repository.BatimentRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.service.util.EqLogger;
import com.equinooxe.web.rest.util.HeaderUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/batiment")
@Secured(AuthoritiesConstants.USER)
public class BatimentResource {
	 private final Logger log = LoggerFactory.getLogger(BatimentResource.class);
	@Inject
	BatimentRepository batimentRepository;
	 
	
	@GetMapping("/all")
	@Timed
	public ResponseEntity<List<Batiment>> getBatiments() { 
	    List<Batiment> batiments = batimentRepository.findAll();
	    return ResponseEntity.ok().body(batiments);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Batiment> getOne(@PathVariable  Long id) {
		log.info("\n==== ID : "+id+" vvvvv ");
		Batiment batiment = batimentRepository.findOne(id);
//		log.info("\n========= bat is: "+ batiment.toString());
//		String jsonInString=batiment.toString();
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//		  jsonInString = mapper.writeValueAsString(batiment);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();  
//		}
		return new ResponseEntity<>(batiment, HttpStatus.OK);
	}
	
    @PostMapping("/")
    @Timed
    public ResponseEntity<Batiment> saveLBatiment(@Valid @RequestBody Batiment batiment) {
        return  ResponseEntity.ok().body(batimentRepository.saveAndFlush(batiment));
    }
    
    @PostMapping("/update")
    @Timed
    public ResponseEntity<Batiment> updateBatiment(@Valid @RequestBody Batiment batiment) {
    	Batiment existingLocation = batimentRepository.findOne(batiment.getId());
        if (existingLocation==null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("location-management", "locationNotExists", "Batiment not exists")).body(null);
        }
        return  ResponseEntity.ok().body(batimentRepository.saveAndFlush(batiment));
    }
	
}

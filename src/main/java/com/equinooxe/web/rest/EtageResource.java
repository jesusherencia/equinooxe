package com.equinooxe.web.rest;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.equinooxe.domain.Etage;
import com.equinooxe.repository.EtageRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.web.rest.util.HeaderUtil;

@RestController
@RequestMapping("/api/etage")
@Secured(AuthoritiesConstants.USER)
public class EtageResource {
	private final Logger log = LoggerFactory.getLogger(EtageResource.class);
	@Inject
	EtageRepository etageRepository; 
	 
	
	@GetMapping("/all") 
	@Timed
	public ResponseEntity<List<Etage>> getEtages() { 
	    List<Etage> Etages = etageRepository.findAll();
	    return ResponseEntity.ok().body(Etages);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Etage> getOne(@PathVariable  Long id) {
		log.info("\n==== ID : "+id+" vvvvv ");
		Etage etage = etageRepository.findOne(id);
		return new ResponseEntity<>(etage, HttpStatus.OK);
	}
	
    @PostMapping("/")
    @Timed
    public ResponseEntity<Etage> saveLEtage(@Valid @RequestBody Etage etage) {
        return  ResponseEntity.ok().body(etageRepository.saveAndFlush(etage));
    }
    
    @PostMapping("/update")
    @Timed
    public ResponseEntity<Etage> updateEtage(@Valid @RequestBody Etage etage) {
    	Etage existingLocation = etageRepository.findOne(etage.getId());
        if (existingLocation==null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("location-management", "locationNotExists", "Etage not exists")).body(null);
        }
        return  ResponseEntity.ok().body(etageRepository.saveAndFlush(etage));
    }
	
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable  Long id) {
		log.info("\n==== to delete : "+id+" vvvvv ");
		Etage entity = etageRepository.findOne(id);
		log.info("\n ============= DELETE\n ===",entity.toString());
		etageRepository.delete(entity);
		return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
	}
}

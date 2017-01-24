package com.equinooxe.web.rest;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.equinooxe.domain.Notification;
import com.equinooxe.repository.NotificationQueryRepository;
import com.equinooxe.security.AuthoritiesConstants;
@RestController
@RequestMapping("/api/notification")
@Secured(AuthoritiesConstants.USER)
public class NotificationResource {
	 
		private final Logger log = LoggerFactory.getLogger(NotificationResource.class);
		@Inject
		NotificationQueryRepository notificationQueryRepository; 
		 
		
		@GetMapping("/all") 
		@Timed
		public ResponseEntity<List<Notification>> getEtages() { 
		    List<Notification> notifs = notificationQueryRepository.getAll();
		    return ResponseEntity.ok().body(notifs);
		}
}

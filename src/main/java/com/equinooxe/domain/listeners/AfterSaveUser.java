package com.equinooxe.domain.listeners;

import javax.inject.Inject;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.equinooxe.repository.NotificationRepository;
import com.equinooxe.service.util.EqLogger;

@Aspect
public class AfterSaveUser {
	static EqLogger log = new EqLogger(AfterSaveUser.class);
	@Inject
	NotificationRepository notifRepo;

	@AfterReturning(pointcut = "execution(* com.equinooxe.service.UserService.saveAndFlush(..))", returning = "retVal")
	public void doNotifyOnAnySave(Object retVal) {
		log.info(" UserService: ret -> " + retVal.toString());
	}
	
	@AfterReturning(pointcut = "execution(* com.equinooxe.repository.UserRepository.saveAndFlush(..))", returning = "retVal")
	public void doNotifyOnSaveAndFlush(Object retVal) {
		log.info(" UserRepository.saveAndFlush: ret -> " + retVal.toString());
	}

	@Before("execution(* com.equinooxe.module.user.UserManagementController.*(..))")
	public void doNotifyInCaseControllerInvocationMethod() {
		log.info(" doNotifyInCaseControllerInvocationMethod ..... ");
	}

}

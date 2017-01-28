package com.equinooxe.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.equinooxe.domain.util.EqUtils;

public class EqLogger {
	private Logger log;
	public static final String MESSAGE_PREFIX = "\n ===========\n";
	public static final String MESSAGE_SUFFIX = "\n ========== ";
 
	
	public EqLogger(){
		 log =LoggerFactory.getLogger(EqLogger.class);
	}
	
	public EqLogger(Class<?> clazz){
		 log =LoggerFactory.getLogger(clazz);
	}

	public  EqLogger set(Class<?> clazz) {
		log = LoggerFactory.getLogger(clazz);
		return this;
	}

	public  EqLogger info(String message) {
		log.info(MESSAGE_PREFIX + message + MESSAGE_SUFFIX);
		return this;
	}
	
	public  EqLogger json(String message, Object obj) {
		log.info(MESSAGE_PREFIX + message+ ":: \n "+EqUtils.json(obj) + MESSAGE_SUFFIX);
		return this;
	}
	
}

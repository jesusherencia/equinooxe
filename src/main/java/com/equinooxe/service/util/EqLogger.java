package com.equinooxe.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EqLogger {
	private static Logger log;
	public static final String MESSAGE_PREFIX = "\n ===========\n";
	public static final String MESSAGE_SUFFIX = "\n ========== ";
	private static EqLogger eqLog;

	public EqLogger(Logger pLog) {
		log = pLog;
	}

	public static EqLogger set(Class<?> clazz) {
		log = LoggerFactory.getLogger(clazz);
		return eqLog = new EqLogger(log);
	}

	public static EqLogger info(String message) {
		if (eqLog == null) {
			log = LoggerFactory.getLogger(EqLogger.class);
			eqLog = new EqLogger(log);
		}
		log.info(MESSAGE_PREFIX + message + MESSAGE_SUFFIX);
		return eqLog;
	}
}

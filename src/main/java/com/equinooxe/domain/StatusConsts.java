package com.equinooxe.domain;

import org.apache.commons.lang3.StringUtils;

public class StatusConsts {
	
	public static final String EN_ATTENTE = "EN_ATTENTE";
	public static final String EN_COURS = "EN_COURS";
	public static final String REPORTEE = "REPORTEE";
	public static final String FAIT = "FAIT";

	public static String toString(String status) {
		if (StringUtils.equals(status, FAIT)) {
			return "Fait";
		} else if (StringUtils.equals(status, EN_ATTENTE)) {
			return "En attente";
		} else if (StringUtils.equals(status, EN_COURS)) {
			return "En cours";
		} else if (StringUtils.equals(status, REPORTEE)) {
			return "Reportée";
		}
		return "Inconnu";
	}
	
	public static String toStatus(String str){
		if (StringUtils.containsIgnoreCase(str, FAIT)) {
			return FAIT;
		} else if (StringUtils.containsIgnoreCase(str, EN_ATTENTE)) {
			return EN_ATTENTE;
		} else if (StringUtils.containsIgnoreCase(str, EN_COURS)) {
			return EN_COURS;
		} else if (StringUtils.containsIgnoreCase(str, REPORTEE)) {
			return REPORTEE;
		}
		
		return EN_ATTENTE;
	}
}

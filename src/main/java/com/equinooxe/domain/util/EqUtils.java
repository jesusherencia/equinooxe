package com.equinooxe.domain.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * a "panoplie" of usefull helpers
 * @author mboullouz
 *
 */
public class EqUtils {
  
	public static String json(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
    	String jsonInString= " ******\n\n  WARNING: cant serialize !!! ";
    	try {
			 jsonInString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        return jsonInString;
	}
}

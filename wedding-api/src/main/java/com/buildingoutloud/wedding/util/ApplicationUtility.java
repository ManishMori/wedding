package com.buildingoutloud.wedding.util;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApplicationUtility {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationUtility.class);
	
	public static String objectToJson(Object object) {
		LOGGER.info("Called");
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			LOGGER.error(e.toString());
		}
		return "{}";
	}
}

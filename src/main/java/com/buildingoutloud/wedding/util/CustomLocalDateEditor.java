package com.buildingoutloud.wedding.util;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CustomLocalDateEditor extends PropertyEditorSupport {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomLocalDateEditor.class);
	private DateTimeFormatter formatter;
	
	public CustomLocalDateEditor(String pattern) {
		this.formatter = DateTimeFormatter.ofPattern(pattern);
	}
	
	@Override
	public void setAsText(String value) throws IllegalArgumentException {

		try {
			LocalDate date = LocalDate.parse(value, formatter);
			setValue(date);			
		}catch(DateTimeParseException e) {
			LOGGER.error(e.toString());
		}
	}

}

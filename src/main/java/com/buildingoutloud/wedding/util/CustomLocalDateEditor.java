package com.buildingoutloud.wedding.util;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class CustomLocalDateEditor extends PropertyEditorSupport {
	private DateTimeFormatter formatter;
	
	public CustomLocalDateEditor(String pattern) {
		this.formatter = DateTimeFormatter.ofPattern(pattern);
	}
	
	@Override
	public void setAsText(String value) throws IllegalArgumentException {

		LocalDate date = LocalDate.parse(value, formatter);
		setValue(date);
	}

}

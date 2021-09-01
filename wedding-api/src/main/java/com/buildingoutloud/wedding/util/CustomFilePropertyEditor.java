package com.buildingoutloud.wedding.util;

import java.beans.PropertyEditorSupport;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class CustomFilePropertyEditor extends PropertyEditorSupport  {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomFilePropertyEditor.class);
	
	@Override
	public void setValue(Object value) {
		
		if(value instanceof MultipartFile) {
			MultipartFile file = (MultipartFile) value;
			try {
				super.setValue(file.getBytes());
			} catch (IOException e) {
				LOGGER.error(e.toString());
				super.setValue(null);
			}
		}
		else {
			super.setValue(null);
		}
	}

	
}

package com.buildingoutloud.wedding.util;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class CustomFilePropertyEditor extends PropertyEditorSupport  {

	@Override
	public void setValue(Object value) {
		
		if(value instanceof MultipartFile) {
			MultipartFile file = (MultipartFile) value;
			try {
				super.setValue(file.getBytes());
			} catch (IOException e) {
				super.setValue(null);
				e.printStackTrace();
			}
		}
		else {
			super.setValue(null);
		}
	}

	
}

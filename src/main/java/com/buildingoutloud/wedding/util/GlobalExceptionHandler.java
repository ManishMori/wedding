package com.buildingoutloud.wedding.util;

import java.sql.SQLIntegrityConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.buildingoutloud.wedding.pojo.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> constraintViolation(Exception e){
		LOGGER.error(e.toString());
		ErrorResponse userResponse = new ErrorResponse();
		userResponse.setErrorMessage("One or more fields are missing/incorrect!");
		return new ResponseEntity<ErrorResponse>(userResponse, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> genericException(Exception e){
		LOGGER.error(e.toString());
		ErrorResponse userResponse = new ErrorResponse();
		userResponse.setErrorMessage("Unexpected error!");
		return new ResponseEntity<ErrorResponse>(userResponse, HttpStatus.OK);

	}
}

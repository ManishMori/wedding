package com.buildingoutloud.wedding.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.buildingoutloud.wedding.pojo.ErrorResponse;
import com.buildingoutloud.wedding.pojo.UserResponse;
import com.buildingoutloud.wedding.util.ApplicationUtility;

public class WeddingAppAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeddingAppAuthenticationFailureHandler.class);
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
	
		LOGGER.info("Enter");
		ErrorResponse errorResponse = new ErrorResponse();;
		errorResponse.setErrorMessage(exception.getMessage());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getOutputStream().print(ApplicationUtility.objectToJson(errorResponse));
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		LOGGER.info("Exit");

	}

}

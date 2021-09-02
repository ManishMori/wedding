package com.buildingoutloud.wedding.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.buildingoutloud.wedding.pojo.ErrorResponse;
import com.buildingoutloud.wedding.util.ApplicationUtility;

public class WeddingAppAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeddingAppAuthenticationEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage("You must login first.");
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getOutputStream().print(ApplicationUtility.objectToJson(errorResponse));
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}

}

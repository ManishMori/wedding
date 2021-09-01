package com.buildingoutloud.wedding.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.buildingoutloud.wedding.pojo.ErrorResponse;
import com.buildingoutloud.wedding.util.ApplicationUtility;

public class WeddingAppAccessDeniedHandler implements AccessDeniedHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeddingAppAccessDeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		LOGGER.info("Enter");
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage("Unauthorized request.");
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getOutputStream().print(ApplicationUtility.objectToJson(errorResponse));
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		LOGGER.info("Exit");
	}

}

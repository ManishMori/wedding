package com.buildingoutloud.wedding.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.buildingoutloud.wedding.pojo.ErrorResponse;
import com.buildingoutloud.wedding.util.ApplicationUtility;

public class WeddingAppLogoutSuccessHandler implements LogoutSuccessHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeddingAppLogoutSuccessHandler.class);
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		LOGGER.info("Enter");
		Map<String, String> logoutResponse = new HashMap<>();
		logoutResponse.put("message","Unauthorized request.");
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getOutputStream().print(ApplicationUtility.objectToJson(logoutResponse));
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		LOGGER.info("Exit");

	}

}

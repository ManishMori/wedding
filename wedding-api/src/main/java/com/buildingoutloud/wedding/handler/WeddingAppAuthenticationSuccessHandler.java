package com.buildingoutloud.wedding.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.buildingoutloud.wedding.entity.User;
import com.buildingoutloud.wedding.pojo.UserResponse;
import com.buildingoutloud.wedding.service.UserService;
import com.buildingoutloud.wedding.util.ApplicationUtility;

@Component
public class WeddingAppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeddingAppAuthenticationSuccessHandler.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		LOGGER.info("Enter");
		UserResponse userResponse = null;
		Object principle = authentication.getPrincipal();
		if(principle instanceof UserDetails) {
			userResponse = userService.generateUserResponse(userService.finaByEmail(((UserDetails) principle).getUsername()));	
			
		}
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getOutputStream().print(ApplicationUtility.objectToJson(userResponse));
		response.setStatus(HttpServletResponse.SC_OK);
		LOGGER.info("Exit");
	}

}

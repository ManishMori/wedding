package com.buildingoutloud.wedding.controller;

import java.time.LocalDate;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buildingoutloud.wedding.entity.User;
import com.buildingoutloud.wedding.pojo.UserResponse;
import com.buildingoutloud.wedding.service.UserService;
import com.buildingoutloud.wedding.util.CustomFilePropertyEditor;
import com.buildingoutloud.wedding.util.CustomLocalDateEditor;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "*")
	@PostMapping(path = "/registration", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> registration(@ModelAttribute("user") User user){

		LOGGER.info("Enter");
		UserResponse createdUser = userService.generateUserResponse(userService.registration(user));					
		
		return new ResponseEntity<Object>(createdUser, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/document/{documentName}/{userId}", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE,})
	public ResponseEntity<?> getDocument(@PathVariable("userId") Integer userId, @PathVariable("documentName") String documentName){
		
		LOGGER.info("Enter");
		byte[] document = userService.getDocument(userId, documentName);
		LOGGER.info("Exit");
		return new ResponseEntity<byte[]>(document, Objects.isNull(document) ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(LocalDate.class, new CustomLocalDateEditor("M/d/yy"));
		dataBinder.registerCustomEditor(byte[].class, new CustomFilePropertyEditor());
	}
}

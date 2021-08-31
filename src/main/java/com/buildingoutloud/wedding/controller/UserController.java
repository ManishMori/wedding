package com.buildingoutloud.wedding.controller;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buildingoutloud.wedding.entity.User;
import com.buildingoutloud.wedding.service.UserService;
import com.buildingoutloud.wedding.util.CustomFilePropertyEditor;
import com.buildingoutloud.wedding.util.CustomLocalDateEditor;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/registration", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public ResponseEntity<Object> registration(@ModelAttribute("user") User user){
		
		User createdUser = userService.registration(user);
		
		return new ResponseEntity<Object>(userService.generateUserResponse(createdUser), HttpStatus.OK);
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(LocalDate.class, new CustomLocalDateEditor("MM/dd/yyyy"));
		dataBinder.registerCustomEditor(byte[].class, new CustomFilePropertyEditor());
	}
}

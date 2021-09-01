package com.buildingoutloud.wedding.service.impl;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.buildingoutloud.wedding.entity.User;
import com.buildingoutloud.wedding.pojo.UserDetailsImpl;
import com.buildingoutloud.wedding.pojo.UserResponse;
import com.buildingoutloud.wedding.repository.UserRepository;
import com.buildingoutloud.wedding.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService, UserDetailsService {

	private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	protected UserServiceImpl() {
		super(User.class);
	}

	@Override
	public User registration(User user) {
		
		LOGGER.info("Enter");
		if(!Objects.isNull(user.getPartnerUserId())) {
			user.setPartnerUserId(findById(user.getPartnerUserId().getId()));
		}
		if(Objects.isNull(user.getFullName())) {
			user.setFullName(user.getFirstName()+" "+user.getLastName());
		}
		user.setActive(true);
		user.setContractGenerated(false);
		user.setDocumentsApproved(false);
		LOGGER.info("Exit");
		return save(user);
	}

	@Override
	public UserResponse generateUserResponse(User user) {
		LOGGER.info("Enter");
		UserResponse userResponse = new UserResponse();
		if(Objects.isNull(user)) {
			return null;
		}else {
			BeanUtils.copyProperties(user, userResponse);
		}
		userResponse.setId(String.valueOf(user.getId()));
		LOGGER.info("Exit");
		return userResponse;
	}

	@Override
	public User finaByEmail(String email) {
		return ((UserRepository) getRepository()).findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("Enter");
		User user = ((UserRepository) getRepository()).findByEmail(username);
		if(Objects.isNull(user)) {
			LOGGER.error("User not found");
			throw new UsernameNotFoundException("E-mail "+username+" is not registered.");
		}
		LOGGER.info("Exit");
		return new UserDetailsImpl(user);
	}

	@Override
	public byte[] getDocument(Integer userId, String documentName) {
		
		LOGGER.info("Enter");
		
		User user = findById(userId);
		byte[] document = null;
		if(!Objects.isNull(user)) {
			
			switch(documentName) {
			case "documentAadhar":
				document = user.getDocumentAadhar();
			break;
			case "documentMariagePicture":
				document = user.getDocumentMariagePicture();
			break;
			case "documentMarriageCertificate":
				document = user.getDocumentMarriageCertificate();
			break;
			}
		}
		LOGGER.info("Exit");
		return document;
	}
	
}

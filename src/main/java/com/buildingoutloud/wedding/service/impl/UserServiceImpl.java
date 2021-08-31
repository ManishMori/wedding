package com.buildingoutloud.wedding.service.impl;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.MultiValueMap;

import com.buildingoutloud.wedding.entity.User;
import com.buildingoutloud.wedding.pojo.UserResponse;
import com.buildingoutloud.wedding.repository.UserRepository;
import com.buildingoutloud.wedding.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	protected UserServiceImpl() {
		super(User.class);
	}

	@Override
	public User registration(User user) {
		
		if(!Objects.isNull(user.getPartnerUserId())) {
			user.setPartnerUserId(findById(user.getPartnerUserId().getId()));
		}
		if(Objects.isNull(user.getFullName())) {
			user.setFullName(user.getFirstName()+" "+user.getLastName());
		}
		user.setActive(true);
		user.setContractGenerated(false);
		user.setDocumentsApproved(false);
		return save(user);
	}

	@Override
	public UserResponse generateUserResponse(User user) {
		UserResponse userResponse = new UserResponse();
		if(Objects.isNull(user)) {
			userResponse.setError(true);
			userResponse.setErrorMessage("User registration failed, please try again!");
		}else {
			BeanUtils.copyProperties(user, userResponse);
		}
		userResponse.setId(String.valueOf(user.getId()));
		userResponse.setDocumentAadhar("data:image/jpeg;base64, "+ Base64Utils.encodeToString(user.getDocumentAadhar()));
		userResponse.setDocumentMariagePicture("data:image/jpeg;base64, "+ Base64Utils.encodeToString(user.getDocumentMariagePicture()));
		return userResponse;
	}

}

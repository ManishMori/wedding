package com.buildingoutloud.wedding.service.impl;

import org.springframework.stereotype.Service;

import com.buildingoutloud.wedding.entity.User;
import com.buildingoutloud.wedding.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

	protected UserServiceImpl() {
		super(User.class);
	}

	

}

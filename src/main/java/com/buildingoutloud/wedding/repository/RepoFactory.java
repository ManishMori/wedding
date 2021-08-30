package com.buildingoutloud.wedding.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.buildingoutloud.wedding.entity.User;

@Component
public class RepoFactory {

	@Autowired
	private UserRepository userRepository;
	
	public JpaRepository<?, ?> getRepository(Class<?> clazz){
		
		if(clazz != null && clazz.equals(User.class)) {
			return userRepository;
		}
		return null;
	}
}

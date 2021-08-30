package com.buildingoutloud.wedding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buildingoutloud.wedding.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

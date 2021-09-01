package com.buildingoutloud.wedding.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.buildingoutloud.wedding.repository.RepoFactory;
import com.buildingoutloud.wedding.service.BaseService;

@Service
public abstract class BaseServiceImpl<E, I> implements BaseService<E,I> {

	private Class<E> clazz;
	
	@Autowired
	private RepoFactory repoFactory;
	
	private JpaRepository<E, I> repository;
	
	protected BaseServiceImpl(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	@PostConstruct
	private void initializeRepository() {
		repository = (JpaRepository<E, I>) repoFactory.getRepository(clazz);
	}

	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Override
	public E findById(I id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public E save(E object) {
		return repository.save(object);
	}

	protected JpaRepository<E, I> getRepository() {
		return repository;
	}

	
	
	
}

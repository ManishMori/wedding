package com.buildingoutloud.wedding.service;

import java.util.List;

public interface BaseService<E,I> {

	List<E> findAll();
	
	E findById(I id);
	
	E save(E object);
}

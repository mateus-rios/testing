package com.rivers.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivers.testing.entity.Generic;
import com.rivers.testing.repository.GenericRepository;

@Service
public class GenericServiceImpl implements GenericService {

	@Autowired
	private GenericRepository genericRepository;
	
	public Generic getGenericByName(String name) {
		return genericRepository.findByName(name);
	}
	
}

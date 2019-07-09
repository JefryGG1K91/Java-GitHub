package com.stockhandler.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockhandler.model.RolEntity;
import com.stockhandler.repository.RolRepository;
import com.stockhandler.service.RolService;

@Service
public class RolServiceImplementation implements RolService {

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public List<RolEntity> getAllRol() {
		System.out.println("getAllRol()");
		return rolRepository.findAll();
	}

}

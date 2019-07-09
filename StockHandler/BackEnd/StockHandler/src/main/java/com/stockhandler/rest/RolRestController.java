package com.stockhandler.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockhandler.model.RolEntity;
import com.stockhandler.service.implementation.RolServiceImplementation;

@RestController
public class RolRestController {

	@Autowired
	private RolServiceImplementation implementation;
	
	@RequestMapping({"/hello"})
	public List<RolEntity> getAllRol(){
		return implementation.getAllRol();
	}
	
}

package com.stockhandle.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stockhandler.model.RolEntity;
import com.stockhandler.service.implementation.RolServiceImplementation;

@RestController
public class RolRestController {

	@Autowired
	private RolServiceImplementation serviceImplementation;

    @RequestMapping("/")
    @ResponseBody
	public String welcome() {
		System.out.println("welcome");
		return "Welcome to RestTemplate Example.";
	}

	 @RequestMapping(value = "/rol", //
	            method = RequestMethod.GET, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, //
	                    MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	public List<RolEntity> getAllRol() {
		System.out.println("------List Values: "+serviceImplementation.getAllRol().size());
		return serviceImplementation.getAllRol();
	}

}

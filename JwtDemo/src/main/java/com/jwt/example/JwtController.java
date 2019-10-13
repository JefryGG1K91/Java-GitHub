package com.jwt.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")
public class JwtController {

	@GetMapping("hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
	}
	
}

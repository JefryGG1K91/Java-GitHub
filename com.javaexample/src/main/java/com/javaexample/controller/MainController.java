package com.javaexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/xoxo")
public class MainController {

	@ResponseBody
	public String homePage() {
		String html = "Hello Motherfucker ******";
		
		return html;
	}
}

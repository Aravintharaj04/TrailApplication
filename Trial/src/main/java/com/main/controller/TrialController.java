package com.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrialController {
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcome() {
		return "Hello World";
	}
	

}

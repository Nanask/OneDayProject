package com.callor.score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String student() {
		
		return "student";
		
	}

}

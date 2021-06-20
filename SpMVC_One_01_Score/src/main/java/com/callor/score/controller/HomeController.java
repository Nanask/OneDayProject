package com.callor.score.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ListDTO;
import com.callor.score.service.ListService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	protected ListService listService;
	
	public HomeController(ListService listService) {
		// TODO Auto-generated constructor stub
		this.listService = listService; 
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<ListDTO> listDTO = listService.selectAll();
		
	 	model.addAttribute("LIST",listDTO);
	 	
	 	log.debug(listDTO.toString());
//	 	log.debug("test : {}", "test");
//	 	log.debug("test##########################################################");
		
		return "home";
	}
	
}

package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ListDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.service.ListService;
import com.callor.score.service.ScoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/scores")
public class ScoreController {
	public final ScoreService scService;
	public final ListService listService;
	
	public ScoreController(ScoreService scService, ListService listService) {
		// TODO Auto-generated constructor stub
		this.scService = scService;
		this.listService = listService;
	}

	
	@RequestMapping(value={"/",""}, method = RequestMethod.GET)
	public String score(Model model) {
		
		List<ScoreVO> scList = scService.selectAll();

		
		model.addAttribute("SC",scList);

		
		return "/scores";
	}
}

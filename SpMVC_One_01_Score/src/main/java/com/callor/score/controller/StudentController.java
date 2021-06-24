package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.score.model.ListDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.service.ListService;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/student")
public class StudentController {
	public final StudentService stService;
	public final ScoreService scService;
	public final ListService liService;
	
	
	public StudentController(StudentService stService, ScoreService scService, ListService liService) {
		// TODO Auto-generated constructor stub
		this.stService = stService;
		this.scService = scService;
		this.liService = liService;
		
//		System.out.println("test");
	}
	
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String student( Model model) {

		List<StudentVO> stList = stService.selectAll();
		
		model.addAttribute("ST",stList);
			
		return "student"; 
		
	}
	@RequestMapping(value="/stinsert",method=RequestMethod.GET)
	public String insert(@RequestParam("num") String num, Model model) {
		
		StudentVO studentVO = stService.findById(num);
		
		model.addAttribute("ST", studentVO);
		
		return "stinsert";
	}
	@RequestMapping(value="stinsert",method=RequestMethod.POST)
	public String insert() {
		
//		List<StudentVO> studentVO = stService.insert(null)
		return "redirect:/stlist";
	}
//	student/stlist
	@RequestMapping(value="/stlist",method=RequestMethod.GET)
	public String list(String num, Model model) {
		

		StudentVO studentVO = stService.findById(num);
		List<ScoreVO> scoreVO = scService.findByNum(num);
		ListDTO listDTO = liService.findById(num);
		
		model.addAttribute("ST", studentVO);
		model.addAttribute("SC", scoreVO);
		model.addAttribute("LIST",listDTO);
		
//		log.debug("scoreVO {}", scoreVO.toString());
		

		
		return "stlist";
	}
	

}

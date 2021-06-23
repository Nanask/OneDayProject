package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.service.ListService;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;
import com.mysql.cj.x.protobuf.MysqlxNotice.SessionStateChanged.Parameter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/student")
public class StudentController {
	public final StudentService stService;
	public final ScoreService scService;
	
	
	public StudentController(StudentService stService, ScoreService scService) {
		// TODO Auto-generated constructor stub
		this.stService = stService;
		this.scService = scService;
//		System.out.println("test");
	}
	
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String student( String num, Model model) {
		

		StudentVO studentVO = stService.findById(num);
		List<ScoreVO> scoreVO = scService.findByNum(num);
		
		model.addAttribute("ST", studentVO);
		model.addAttribute("SC", scoreVO);
		
//		log.debug("scoreVO {}", scoreVO.toString());
			
		return "/student"; 
		
	}
	@RequestMapping(value="/stinsert",method=RequestMethod.GET)
	public String insert(@RequestParam("num") String num, Model model) {
		
		StudentVO studentVO = stService.findById(num);
		
		model.addAttribute("ST", studentVO);
		
		return "/stinsert";
	}

//	student/stlist
	@RequestMapping(value="/stlist",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<StudentVO> stList = stService.selectAll();
		
		model.addAttribute("ST",stList);
		
		return "stlist";
	}
	

}

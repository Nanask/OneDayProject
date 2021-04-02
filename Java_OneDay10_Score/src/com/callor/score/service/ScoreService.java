package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreService {
	
	Scanner scan;
	List<ScoreVO> scoreList;
	
	public ScoreService() {
		// TODO Auto-generated constructor stub
		
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
		
	}
	

}

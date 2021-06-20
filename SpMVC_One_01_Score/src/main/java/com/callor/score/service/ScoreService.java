package com.callor.score.service;

import java.util.List;

import com.callor.score.model.ScoreVO;

public interface ScoreService {
	
	public List<ScoreVO> selectAll();
	public List<ScoreVO> findByNum(String sc_Stnum);
	public ScoreVO findById(String seq);

}

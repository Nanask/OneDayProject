package com.callor.score.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService{
	protected final ScoreDao scoreDao;

	public ScoreServiceImpl(ScoreDao scoreDao) {
		// TODO Auto-generated constructor stub
		this.scoreDao = scoreDao; 
	}
	@Override
	public List<ScoreVO> selectAll() {
		// TODO 전체성적조회

		return scoreDao.selectAll();
	}

	@Override
	public List<ScoreVO> findByNum(String sc_Stnum) {
		// TODO Auto-generated method stub
		return scoreDao.findByNum(sc_Stnum);
	}

	@Override
	public ScoreVO findById(String seq) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.callor.score.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.callor.score.controller.HomeController;
import com.callor.score.model.ListDTO;
import com.callor.score.service.ListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("ListService")
public class ListServiceImpl implements ListService{
	
	protected final JdbcTemplate jdbcTemplate;
	
	public ListServiceImpl(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<ListDTO> selectAll() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT 응시과목 subject, 이름 name, 전공 dept,"
				+ " 총점 total, 평균 avg, 학년 grade, 학번 num FROM view_성적관리 ";
		
		List<ListDTO> listDTO = 
				jdbcTemplate.query(sql, new BeanPropertyRowMapper<ListDTO>(ListDTO.class));
		
		log.debug("SELECT {}", listDTO.toString());
				
		return listDTO;
	}

}

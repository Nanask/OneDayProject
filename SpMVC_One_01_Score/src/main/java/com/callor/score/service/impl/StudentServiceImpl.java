package com.callor.score.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.callor.score.model.ListDTO;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentServiceImpl implements StudentService{
	
	protected final JdbcTemplate jdbcTemplate;
	
	public StudentServiceImpl(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<ListDTO> selectAll() {
		// TODO 전체 리스트 조회
		String sql = " SELECT FROM view_성적관리 ";
		List<ListDTO> listDTO = jdbcTemplate.query
				(sql, new BeanPropertyRowMapper<ListDTO>(ListDTO.class));
		
		log.debug("SELECT {}", listDTO.toString());
		
		return listDTO;
	}

}

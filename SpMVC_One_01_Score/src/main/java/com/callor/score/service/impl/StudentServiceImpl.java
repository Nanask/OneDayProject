package com.callor.score.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.callor.score.model.ListDTO;
import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("studentService")
public class StudentServiceImpl implements StudentService{
	
	protected final StudentDao studentDao;
	
	public StudentServiceImpl(StudentDao studentDao) {
		// TODO Auto-generated constructor stub
		
		this.studentDao = studentDao;
	}

	@Override
	public List<StudentVO> selectAll() {
		// TODO 학생 전체 리스트
		

		return studentDao.selectAll();
	}

	@Override
	public StudentVO findById(String st_num) {
		// TODO Auto-generated method stub
		
		
		return studentDao.findById(st_num);
	}

	@Override
	public List<StudentVO> findByName(String st_name) {
		// TODO Auto-generated method stub
		return studentDao.findByName(st_name);
	}

	@Override
	public int insert(StudentVO stVO) {
		// TODO Auto-generated method stub
		String st_num = studentDao.findByMaxCode();
//		log.debug("cpCode {} ", cpCode);
		
		if(st_num == null || st_num.equals("")) {
			
			st_num = String.format("2021%04d", 1);
		}
		stVO.setSt_num(st_num);
		studentDao.insert(stVO);
		
		return 0;
	}
	

	@Override
	public int update(StudentVO stVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String st_num) {
		// TODO Auto-generated method stub
		return 0;
	}



}

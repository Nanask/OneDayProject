package com.callor.score.service;

import java.util.List;

import com.callor.score.model.ListDTO;
import com.callor.score.model.StudentVO;

public interface StudentService {
	
	public List<StudentVO> selectAll();
	public StudentVO findById(String st_num);
	public List<StudentVO> findByName(String st_name);
	public int insert(StudentVO stVO);
	public int update(StudentVO stVO);
	public int delete(String st_num);
	
	


}

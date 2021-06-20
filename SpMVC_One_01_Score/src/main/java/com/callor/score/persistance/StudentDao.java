package com.callor.score.persistance;

import java.util.List;

import com.callor.score.model.StudentVO;

public interface StudentDao extends GenericDao<StudentVO, String>{
	

	public StudentVO findById(String st_num);
	public List<StudentVO> findByName(String st_name);
	public String findByMaxCode();

}

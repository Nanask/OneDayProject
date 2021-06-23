package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("studentDao")
@Service
public class StudentServiceImpl implements StudentDao {
	protected final JdbcTemplate jdbcTemplate;

	public StudentServiceImpl(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;

	}

	@Override
	public List<StudentVO> selectAll() {
		// TODO Auto-generated method stub

		String sql = " SELECT * FROM tbl_student ";
		List<StudentVO> stList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));

		return stList;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub

		String sql = " INSERT INTO tbl_student ";
		sql += " (st_num,st_name,st_dept,st_grade,st_tel,st_addr) ";
		sql += " VALUES (?,?,?,?,?,?) ";
		Object[] params = new Object[] { vo.getSt_num(), vo.getSt_name(), vo.getSt_dept(), vo.getSt_grade(),
				vo.getSt_tel(), vo.getSt_addr() };

		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		String sql = " UPDATE tbl_student SET ";
		sql += "st_name =?";
		sql += "st_dept =?";
		sql += "st_grade =?";
		sql += "st_tel =?";
		sql += "st_addr =? ";
		sql += " WHERE st_num = ? ";
		Object[] params = new Object[] { vo.getSt_num(), vo.getSt_name(), vo.getSt_dept(), vo.getSt_grade(),
				vo.getSt_tel(), vo.getSt_addr() };

		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int Delete(String pk) {
		// TODO Auto-generated method stub
		
		String sql = " DELETE FROM tbl_student ";
		sql += " WHERE st_num = ?";
		return jdbcTemplate.update(sql, pk);
	}

	@Override
	public StudentVO findById(String st_num) {
		// TODO Auto-generated method stub

		String sql = " SELECT * FROM tbl_student ";
		sql += " WHERE st_num = ? ";
		Object[] params = new Object[] { st_num };

//		StudentVO stVO = (StudentVO) jdbcTemplate.query
//				(sql, params, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));
		List<StudentVO> stVO = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));
		log.debug("stVO :", stVO.toString());
//		return stVO;
		return stVO.get(0);
	}

	@Override
	public List<StudentVO> findByName(String st_name) {
		// TODO Auto-generated method stub

		String sql = " SELECT * FROM tbl_sudent ";
		sql += " WHERE st_name = ? ";

		Object[] param = new Object[] { st_name };
		List<StudentVO> stList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));
		return stList;
	}

	@Override
	public String findByMaxCode() {
		// TODO Auto-generated method stub
		String sql = " SELECT MAX(st_num) FROM tbl_student ";
		String st_num = jdbcTemplate.queryForObject(sql, String.class);
		return st_num;
	}

}

package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.persistance.ScoreDao;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository("scoreDao")
@Service
public class ScoreServiceImpl implements ScoreDao{
	protected final JdbcTemplate jdbcTemplate;
	
	public ScoreServiceImpl(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate; 
	}

	@Override
	public List<ScoreVO> selectAll() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_score ";
		List<ScoreVO> scoreList = jdbcTemplate.query
				(sql, new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));
		
		
		return scoreList;
	}

	@Override
	public ScoreVO findById(String pk) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_seq = ? ";
		Object[] param = new Object[] {pk}; 
		ScoreVO scoreVO =(ScoreVO) jdbcTemplate.query
				(sql, param, new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));
		
		return scoreVO;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_score (sc_Stnum, sc_Subject, sc_Score) ";
		sql += " VALUES ( ?,?,?) ";
		Object[] params = new Object[] 
				{ vo.getSc_Stnum(),vo.getSc_Subject(),vo.getSc_Score() };
				
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		
		String sql = " UPDATE tbl_score SET ";
		sql += " sc_Stnum = ?";
		sql	+= "sc_Subject = ?";
		sql	+= "sc_Score = ? ";
		sql += " WHERE sc_Seq = ? ";
		Object[] params = new Object[] 
				{ vo.getSc_Stnum(),vo.getSc_Subject(),vo.getSc_Score(),vo.getSc_Seq() };
		
		
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int Delete(String pk) {
		// TODO Auto-generated method stub
		
		String sql = " DELETE FROM tbl_score ";
		sql += " WHERE sc_Seq = ? ";
		return jdbcTemplate.update(sql, pk);
	}

	@Override
	public ScoreVO findById(Long sc_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScoreVO> findByNum(String sc_Stnum) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_Stnum = ? ";
		Object[] params = new Object[] {sc_Stnum};
		List<ScoreVO> scVO  = jdbcTemplate.query
				(sql, params, new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));
		log.debug("scVO :", scVO.toString() );
		
//		ScoreVO scoreVO = (ScoreVO) jdbcTemplate.query
//				(sql, params, new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));		
		
		return scVO;
	}

}

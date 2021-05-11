package com.com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.model.FoodDTO;
import com.com.model.FoodVO;
import com.com.model.MyFoodDTO;
import com.com.persistence.DBContract;
import com.com.service.FoodService;

public class FoodServiceImpl implements FoodService {
	
	protected Connection dbConn;
	public FoodServiceImpl() {
		dbConn = DBContract.getDBConnection();
	}
	
	
	protected List<MyFoodDTO> select(PreparedStatement pStr) throws SQLException {
		List<MyFoodDTO> mfList
			= new ArrayList<MyFoodDTO>();
		//DB에게 sql을 보내고 그 결과를 resultSet에 담아달라
		ResultSet rStr = pStr.executeQuery();
		while(rStr.next()) {
			
			MyFoodDTO mfDTO = new MyFoodDTO();
			mfDTO.setMy_seq(rStr.getInt("순번"));
			mfDTO.setMy_date(rStr.getString("날짜"));
			mfDTO.setFd_fname(rStr.getString("식품명"));	
			mfDTO.setMy_eat(rStr.getInt("섭취량"));
			mfDTO.setFd_all(rStr.getInt("총내용량(g)"));
			mfDTO.setFd_energy(rStr.getInt("에너지(kcal)"));
			mfDTO.setFd_protein(rStr.getInt("단백질(g)"));
			mfDTO.setFd_fat(rStr.getInt("지방(g)"));
			mfDTO.setFd_car(rStr.getInt("탄수화물(g)"));
			mfDTO.setFd_sugars(rStr.getInt("총당류(g)"));
			System.out.println(mfDTO.toString());
			mfList.add(mfDTO);
		}
		return mfList;
	}

	@Override
	public List<MyFoodDTO> selectAll() {
		// TODO 전체조회
		
		String sql = " SELECT * FROM view_섭취리스트 ";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyFoodDTO> mfList = this.select(pStr);
			pStr.close();
			return mfList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public FoodDTO findById() {
		// TODO 이름으로 조회
		
		return null;
	}

	@Override
	public List<FoodDTO> findByGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyFoodDTO> findByDate(String date) {
		// TODO 날짜로 조회하기
		// DBMS에 조회를 하기 위한 명령문을 문자로 만든것
		String sql = " SELECT * FROM VIEW_섭취리스트 ";
		sql += " WHERE 날짜 = ? ";
		PreparedStatement pStr = null;
		System.out.println(date);
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, date);
			List<MyFoodDTO> mfList = this.select(pStr);
			pStr.close();
			return mfList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<FoodDTO> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(FoodVO foodVO) {
		// TODO 먹은 음식 추가
		String sql = " INSERT INTO tbl_MyFoods ";
		sql += " (my_seq, my_date, my_pdcode, my_eat) ";
		sql += " VALUES(seq_food_list.NEXTVAL, ?, ?, ? ) ";
		
		
		PreparedStatement pStr = null;
		
		//집에가서 다시보세요
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1,foodVO.getMy_date());
			pStr.setString(2,foodVO.getMy_pdCode());
			pStr.setInt(3,foodVO.getMy_eat());
			
			int result = pStr.executeUpdate();
			pStr.close();
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}

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
		ResultSet rStr = pStr.executeQuery();
		while(rStr.next()) {
			
			MyFoodDTO mfDTO = new MyFoodDTO();
			mfDTO.setMy_date(rStr.getString("날짜"));
			mfDTO.setFd_fname(rStr.getString("식품명"));	
			mfDTO.setMy_eat(rStr.getInt("섭취량"));
			mfDTO.setFd_all(rStr.getInt("총내용량(g)"));
			mfDTO.setFd_energy(rStr.getInt("에너지(kcal)"));
			mfDTO.setFd_protein(rStr.getInt("단백질(g)"));
			mfDTO.setFd_fat(rStr.getInt("지방(g)"));
			mfDTO.setFd_car(rStr.getInt("탄수화물(g)"));
			mfDTO.setFd_sugars(rStr.getInt("총당류(g)"));
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
			List<MyFoodDTO> mfDTO = this.select(pStr);
			pStr.close();
			return mfDTO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public FoodDTO findById() {
		// TODO Auto-generated method stub
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
		sql += " (my_sql, my_date, my_pdcode, my_eat) ";
		sql += " VALUES(seq_food_list.NEXTVAL, ?, ?, ?, ) ";
		
		PreparedStatement pStr = null;
		
		pStr = dbConn.prepareStatement(sql);
		pStr.setString(1, FoodVO.get);
		
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

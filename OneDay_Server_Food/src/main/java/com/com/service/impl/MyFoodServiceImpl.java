package com.com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.model.FoodDTO;
import com.com.persistence.DBContract;
import com.com.service.MyFoodService;

public class MyFoodServiceImpl implements MyFoodService{
	
	protected Connection dbConn;
	public MyFoodServiceImpl() {
		dbConn = DBContract.getDBConnection();
	}
	
	protected List<FoodDTO> select(PreparedStatement pStr) throws SQLException {
		List<FoodDTO> fList
			= new ArrayList<FoodDTO>();
		//DB에게 sql을 보내고 그 결과를 resultSet에 담아달라
		ResultSet rStr = pStr.executeQuery();
		while(rStr.next()) {
			
			FoodDTO fDTO = new FoodDTO();
			fDTO.setFd_tcode(rStr.getString("분류코드"));
			fDTO.setIt_group(rStr.getString("분류명"));	
			fDTO.setFd_pcode(rStr.getString("식품코드"));
			fDTO.setFd_fname(rStr.getString("식품명"));
			fDTO.setFd_fdate(rStr.getString("출시년도"));
			fDTO.setFd_ccode(rStr.getString("제조사코드"));
			fDTO.setCp_cname(rStr.getString("제조사명"));
			fDTO.setFd_one(rStr.getInt("1회제공량"));
			fDTO.setFd_all(rStr.getInt("총내용량(g)"));
			fDTO.setFd_energy(rStr.getInt("에너지(g)"));
			fDTO.setFd_protein(rStr.getInt("단백질(g)"));
			fDTO.setFd_fat(rStr.getInt("지방(g)"));
			fDTO.setFd_car(rStr.getInt("탄수화물(g)"));
			fDTO.setFd_sugars(rStr.getInt("총당류(g)"));
			
			System.out.println(fDTO.toString());
			fList.add(fDTO);
		}
		return fList;
	}

	@Override
	public List<FoodDTO> findByName(String fname) {
		// TODO 이름으로 찾기
		
		String sql = " SELECT * FROM VIEW_식품정보 ";
		sql += " WHERE 식품명 LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, fname);
			List<FoodDTO> fList = this.select(pStr);
			pStr.close();
			return fList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return null;
	}

}

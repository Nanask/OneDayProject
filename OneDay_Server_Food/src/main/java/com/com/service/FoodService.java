package com.com.service;

import java.util.List;

import com.com.model.FoodDTO;
import com.com.model.FoodVO;
import com.com.model.MyFoodDTO;

public interface FoodService {
	
	// 전체조회
	public List<MyFoodDTO> selectAll();
	
	// 상품코드로 정보조회
	public FoodDTO findById();
	
	// 분류명으로 정보조회
	public List<FoodDTO> findByGroup();
	
	// 날짜로 정보조회
	public List<MyFoodDTO> findByDate(String date);
	
	// 상품명으로 정보조회
	public List<FoodDTO> findByName();
	
	
	// 정보추가
	public int insert(FoodVO foodVO);
	
	// 
	public int update();
	
	// 삭제
	public int delete();
	
	
	
}

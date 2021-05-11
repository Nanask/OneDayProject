package com.com.service;

import java.util.List;

import com.com.model.FoodDTO;

public interface MyFoodService {
	
	public List<FoodDTO> findByName(String fname);

}

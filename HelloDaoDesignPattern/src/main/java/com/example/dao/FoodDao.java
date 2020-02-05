package com.example.dao;

import java.util.List;

import com.example.model.Food;

public interface FoodDao {
	
	// CRUD METHODS ONLY
	
	//CREATE 
	public int insertFood(Food food);
	//READ
	public List<Food> selectAllFood();
	public Food selectFoodById(int id);
	public Food selectFoodByName(String name);
	//UPDATE
	public int updateFood(Food food);
	//DELETE
	public int deleteFood(Food food);

}

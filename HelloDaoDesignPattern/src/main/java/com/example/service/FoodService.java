package com.example.service;

import java.util.List;

import com.example.model.Food;

public interface FoodService {
	
	public List<Food> getAllFood();
	public Food getFood(Food food);
	
	public void accountCreate(String user); // could be a user object
	
	public boolean checkUsernameAndPassword(String u, String p);
	public boolean login(String u, String p);
}

package com.example.model;

public class Food {
	private int food_id;
	private String food_name;
	private String food_recipe;
	
	/*
	 * no arg constructor
	 * all arg constructor
	 * getter and setters
	 * toString()
	 */
	public Food() {
		// TODO Auto-generated constructor stub
	}

	public Food(int food_id, String food_name, String food_recipe) {
		super();
		this.food_id = food_id;
		this.food_name = food_name;
		this.food_recipe = food_recipe;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getFood_recipe() {
		return food_recipe;
	}

	public void setFood_recipe(String food_recipe) {
		this.food_recipe = food_recipe;
	}

	@Override
	public String toString() {
		return "\nFood [food_id=" + food_id + ", food_name=" + food_name + ", food_recipe=" + food_recipe + "]";
	}
	
}


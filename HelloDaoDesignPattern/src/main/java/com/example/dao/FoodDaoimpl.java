package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Food;

public class FoodDaoimpl implements FoodDao {

	/*
	 * For ORACLE DBMS specifically the url patter is:
	 * 
	 * private static String url=
	 * "jdbc:oracle:thin:@[endpoint]:[port]:[database-name]";
	 * 
	 * for local dbms:
	 * "jdbc:oracle:thin:@localhost:1521:xe";
	 */
	private static String url= System.getenv("TRAINING_DB_URL");
	private static String username= System.getenv("TRAINING_DB_USERNAME");
	private static String password=System.getenv("TRAINING_DB_PASSWORD");
	
	@Override
	public int insertFood(Food food) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Food> selectAllFood() {
		List<Food> foods = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM food";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				foods.add(
						new Food(rs.getInt(1), rs.getString(2), rs.getString("recipe"))
				);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return foods;
	}

	@Override
	public Food selectFoodById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food selectFoodByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateFood(Food food) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFood(Food food) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.revature.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bank{
	
	private static String url= System.getenv("TRAINING_DB_URL");
	//
	private static String username = "bankUser";
	//private static String username= System.getenv("TRAINING_DB_USERNAME");
	private static String password=System.getenv("TRAINING_DB_PASSWORD");
	
	public AccountTab login2(String u, String p) {
		   AccountTab user = null;
		   try(Connection conn = DriverManager.getConnection(url, username, password)){
		      String sql = "SELECT * FROM userbank WHERE username = ? AND password = ?";
		      PreparedStatement ps = conn.prepareStatement(sql);
		      ps.setString(1, u);
		      ps.setString(2, p);
		      ResultSet rs = ps.executeQuery();
		      if(rs.next()){
		      user = new AccountTab(
		    		  rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getDouble(9), rs.getDouble(10)
		         );
		      }
		   }catch(SQLException e) {
		      e.printStackTrace();
		   }
		   return user;
		}

}

package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.model.EmployeeModel;
import com.revature.model.ExpenseModel;

public class ERS_Dao_Impl implements ERS_Dao {

	public static String url= System.getenv("TRAINING_DB_URL");
	private static String username = "ERS_DB";
	private static String password=System.getenv("TRAINING_DB_PASSWORD");
	
	
	static {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	@Override
	public List<EmployeeModel> allTheEmployees() {
		List<EmployeeModel> employees = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM ers_employee";
			System.out.println(url + username + password);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employees.add(
						new EmployeeModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6))
						);
			}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return employees;
		
	}

	@Override
	public List<ExpenseModel> getThoseExpenses() {
			List<ExpenseModel> expenses = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM ers_expenses";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				expenses.add(
						new ExpenseModel(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8))
						);
			}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return expenses;
		
	}

	@Override
	public EmployeeModel getEmployee(EmployeeModel empMod) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<EmployeeModel> getEmployee(String userName){
		List<EmployeeModel> employees = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM ers_employee WHERE ers_username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employees.add(
						new EmployeeModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6))
						);
			}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return employees;
		
	}
	
	public List<ExpenseModel> getExpense(int ticket_id){
List<ExpenseModel> expenses = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM ers_expenses WHERE ticket_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticket_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				expenses.add(
						new ExpenseModel(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8))
						);
			}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return expenses;
		
	}
	
	public void insertExp( int exp_type, double exp_amount, String exp_stat, String exp_desc,
			int exp_userID) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "INSERT INTO ers_expenses(exp_type, exp_amount, date_sub, date_res, exp_stat, exp_desc, exp_userID)"
					+ " VALUES( ?, ?, SYSTIMESTAMP, SYSTIMESTAMP, ?, ?, ?)";
			
			//int accKey;
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, exp_type);
			ps.setDouble(2, exp_amount);
			/*
			 * ps.setDate(3, date_sub); ps.setDate(4, date_res);
			 */
			ps.setString(3, exp_stat);
			ps.setString(4, exp_desc);
			ps.setInt(5, exp_userID);
			
			
		
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public ExpenseModel getExpense(ExpenseModel expMod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void empCreate(String empuser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void expCreate(String expuser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkIfReal(String u, String p) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public EmployeeModel login(String u, String p) {
			//boolean status = false;
			   EmployeeModel user = null;
			   try(Connection conn = DriverManager.getConnection(url, username, password)){
			      String sql = "SELECT * FROM ers_employee WHERE ers_username = ? AND ers_password = ?";
			      PreparedStatement ps = conn.prepareStatement(sql);
			      ps.setString(1, u);
			      ps.setString(2, p);
			      ResultSet rs = ps.executeQuery();
			      if(rs.next()){
			      user = new EmployeeModel(
			    		  rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)
			         );
			      }
			   }catch(SQLException e) {
			      e.printStackTrace();
			   }
			   return user;
			}
	}



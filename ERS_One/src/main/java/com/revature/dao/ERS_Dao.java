package com.revature.dao;

import java.util.List;

import com.revature.model.EmployeeModel;
import com.revature.model.ExpenseModel;

public interface ERS_Dao {
	public List<EmployeeModel> allTheEmployees();
	public List<ExpenseModel> getThoseExpenses();
	
	public EmployeeModel getEmployee(EmployeeModel empMod);
	public ExpenseModel getExpense(ExpenseModel expMod);
	
	public void empCreate (String empuser);
	public void expCreate (String expuser);
	
	public boolean checkIfReal (String u, String p);
	
	public EmployeeModel login(String u, String p);

}

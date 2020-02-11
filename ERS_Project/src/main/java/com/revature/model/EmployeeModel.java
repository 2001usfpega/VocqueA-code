package com.revature.model;

public class EmployeeModel {
	
	@Override
	public String toString() {
		return "EmployeeModel [user_id=" + user_id + ", ers_username=" + ers_username + ", ers_password=" + ers_password
				+ ", ers_firstname=" + ers_firstname + ", ers_lastname=" + ers_lastname + ", isAdmin=" + isAdmin + "]";
	}

	public int user_id;
	public String ers_username;
	public String ers_password;
	public String ers_firstname;
	public String ers_lastname;
	public int isAdmin;
	
	public EmployeeModel() {
		
	}

	public EmployeeModel(int user_id, String ers_username, String ers_password, String ers_firstname,
			String ers_lastname, int isAdmin) {
		super();
		this.user_id = user_id;
		this.ers_username = ers_username;
		this.ers_password = ers_password;
		this.ers_firstname = ers_firstname;
		this.ers_lastname = ers_lastname;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getErs_username() {
		return ers_username;
	}

	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}

	public String getErs_password() {
		return ers_password;
	}

	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}

	public String getErs_firstname() {
		return ers_firstname;
	}

	public void setErs_firstname(String ers_firstname) {
		this.ers_firstname = ers_firstname;
	}

	public String getErs_lastname() {
		return ers_lastname;
	}

	public void setErs_lastname(String ers_lastname) {
		this.ers_lastname = ers_lastname;
	}

	

}

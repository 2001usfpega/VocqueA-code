package com.revature.classes;

public class AccountTab {

	public int userid;
	public String firstname;
	public String lastname;
	public String username;
	public String password;
	public int isAdmin;
	public int accId;
	public String accType;
	public double balance;
	public double check;
	
	
	public AccountTab() {
		
	}
	public AccountTab(int userid, String firstname, String lastname, String username, String password, int isAdmin, int accId,
			String accType, double balance, double check) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.accId = accId;
		this.accType = accType;
		this.balance = balance;
		
		
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getCheck() {
		return check;
	}
	public void setCheck(double check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return "\nAccountTab [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + ", isAdmin=" + isAdmin + ", accId=" + accId + ", accType="
				+ accType + ", balance=" + balance + ", check=" + check + "]";
	}

}

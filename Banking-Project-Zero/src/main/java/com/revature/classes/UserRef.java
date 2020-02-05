package com.revature.classes;

public class UserRef {
	

	public int userId;
	public String firstName;
	public String lastName;
	public String password;
	public String address;
	public String city;
	public String state;
	public int zipcode;
	public int accountNumber;
	public int isAdmin;
	
//no arg constructor	
public UserRef() {
	
}

public UserRef(int userId, String firstName, String lastName, String password, String address, String city,
		String state, int zipcode, int accountNumber, int isAdmin) {
	super();
	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.address = address;
	this.city = city;
	this.state = state;
	this.zipcode = zipcode;
	this.accountNumber = accountNumber;
	this.isAdmin = isAdmin;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public int getZipcode() {
	return zipcode;
}

public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}

public int getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}

@Override
public String toString() {
	return "UserRef [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
			+ password + ", address=" + address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
			+ ", accountNumber=" + accountNumber + ", isAdmin=" + isAdmin + "]";
}

public int getIsAdmin() {
	return isAdmin;
}

public void setIsAdmin(int isAdmin) {
	this.isAdmin = isAdmin;
}


}

package com.revature.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.classes.AccountTab;
import com.revature.classes.UserRef;

public interface BankService {

	public List<AccountTab> getThoseAccounts();
	public List<UserRef> getthoseusers();

	public AccountTab getAccount(AccountTab actTab);
	public UserRef getUser(UserRef userRef);

	public void accountCreate(String user);

	public boolean checkUsernameAndPassword(String u, String p);

	public AccountTab login2(String u, String p);
}

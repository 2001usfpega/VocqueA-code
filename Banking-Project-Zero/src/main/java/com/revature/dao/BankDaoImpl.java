package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.classes.AccountTab;
import com.revature.classes.Bank;
import com.revature.classes.UserRef;
import com.revature.service.BankService;

public class BankDaoImpl implements BankService {
	
	public static int userid;
	public static String firstname;
	public static String lastname;
	public static String userName;
	public static String passWord;
	public static int isAdmin;
	public static int accId;
	public static String accType;
	public static double balance;
	public static double check;
	public static double tempNum;
	
	
	private static String url= System.getenv("TRAINING_DB_URL");
	//
	private static String username = "bankUser";
	//private static String username= System.getenv("TRAINING_DB_USERNAME");
	private static String password=System.getenv("TRAINING_DB_PASSWORD");
	


	public static void main(String [] args) {
		Scanner bankScan = new Scanner(System.in);
		System.out.println("Hello");
		BankDaoImpl bankDao = new BankDaoImpl();
		AccountTab acct = new AccountTab();
		Bank bs = new Bank();
		int userChoice;
		 String userInput;
		 boolean quit = false;
		 boolean whileStop = false;
		 
		/*
		 * accInt = bankScan.nextInt(); accAcc = bankScan.next(); accCheck =
		 * bankScan.nextDouble(); accSave = bankScan.nextDouble();
		  
		 */
		/* bankDao.updateAcc(); */
		/*
		 * bankDao.insertAcc("Morty", "Smith", "OneTrueMorty", "evilMorty", 0,
		 * "Checking", 765.32, 912.38 );
		 * 
		 * System.out.println(bankDao.getThoseAccounts());
		 */
		 System.out.println("Welcome to Not-A-Mafia-front!");
			System.out.println("Are you a returning user?");
			System.out.println(" Yes or No ");
			userInput = bankScan.next();
			do { 
				while (!whileStop) {
					if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
						System.out.println("Welcome back! How are you signing in today?");
						whileStop = true;
						System.out.println("\n1.User" + "\n2.Admin");
						//userChoice = bankScan.nextInt();
						userInput = bankScan.next();
						//Client Enters
						if(userInput.equals("User") || userInput.equals("user") || userInput.equals("1") || userInput.equals("1.")) {
							System.out.println("Hello User, let's get you signed in.");
							//String userName;
							//String passWord;
							//String fullName;
							System.out.println("Username:");
							userName = bankScan.next();
							System.out.println("Password:");
							passWord = bankScan.next();
							acct = bs.login2(userName, passWord);
							if(acct == null) {
								System.out.println("Invalid ID/password!");
							}else {
								
								System.out.println("Hello there, " + userName + ". How can I help you today?");
								System.out.println("1. Balance" + "\n2. Withdraw" + "\n3. Deposit" + "\n4. Close" + "\nInput 0 to exit.");
								userInput = bankScan.next();
								boolean oneStep = true;
								boolean userMenu = false;
								boolean amIfine = false;
								while(!userMenu) {
									if(!oneStep) {
										System.out.println("1. Balance" + "\n2. Withdraw" + "\n3. Deposit" + "\n4. Close"  + "\nInput 0 to exit.");
										userInput = bankScan.next();
									}
									
									switch(userInput) {
									
									case "1":
									case "1.":
									case "Balance":
									case "balance":
										System.out.println("Hello " + userName + " , here's your account information.");
										System.out.println(bankDao.personalLook(userName));
										System.out.println("Would you like to continue?" + "\nYes or No");
										userInput = bankScan.next();
										if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
											userMenu = false;
											oneStep = false;
										}
										else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
											System.out.println("Have a good day!");
											userMenu = true;
											quit = true;
										}
										break;
									case "2":
									case "2.":
									case "Withdraw":
									case "withdraw":
									
										while(!amIfine) {
											
											System.out.println("How much would you like to withdraw?");
											
											tempNum = bankScan.nextDouble();
											if(tempNum> acct.balance) {
												System.out.println("Sorry, you don not have enough in your account for this withdraw.");
												System.out.println("Would you like to continue?" + "\nYes or No");
												userInput = bankScan.next();
												amIfine = true;
												if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
													userMenu = false;
													oneStep = false;
													amIfine=false;
												}
												else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
													System.out.println("Have a good day!");
													userMenu = true;
													quit = true;
													amIfine = true;
												}
										}else {
											acct.balance -= tempNum;
											bankDao.updateAccBalance(acct.balance, userName);
											System.out.println(bankDao.personalLook(userName));
											amIfine =false;
											System.out.println("Would you like to continue?" + "\nYes or No");
											userInput = bankScan.next();
											if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
												userMenu = false;
												oneStep = false;
											}
											else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
												System.out.println("Have a good day!");
												userMenu = true;
												quit = true;
												amIfine = true;
											}
											break;
										}
									
										}
									case "3":
									case "3.":
									case "Deposit":
									case "deposit":	
											
											System.out.println("How much would you like to deposit?");
											
											tempNum = bankScan.nextDouble();
											
										
											acct.balance += tempNum;
											bankDao.updateAccBalance(acct.balance, userName);
											System.out.println(bankDao.personalLook(userName));
											
											System.out.println("Would you like to continue?" + "\nYes or No");
											userInput = bankScan.next();
											if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
												userMenu = false;
												oneStep = false;
												amIfine =false;
											}
											else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
												System.out.println("Have a good day!");
												userMenu = true;
												quit = true;
												amIfine = true;
											}
										
											break;
								
									case "4":
									case "4.":
									case "Close":
									case "close":
										int zero = 0;
										System.out.println("Would you like to close your account?");
										userInput = bankScan.next();
										if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
											userMenu = false;
											oneStep = false;
											if(acct.balance == 0) {
												bankDao.deleteAcc(userName);
											System.out.println("Farewell user.");
											userMenu = true;
											quit = true;
											amIfine = true;
										}else {
											System.out.println("You cannot close it at this time, you still have money in the account.");
											System.out.println("Would you like to continue?" + "\nYes or No");
											userInput = bankScan.next();
											if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
												userMenu = false;
												oneStep = false;
											}
											else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
												System.out.println("Have a good day!");
												userMenu = true;
												quit = true;
												amIfine = true;
											}
											break;
										}
										
										if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
											userMenu = false;
											oneStep = false;
										}
										else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
											System.out.println("Have a good day!");
											userMenu = true;
											quit = true;
											amIfine = true;
										}}
										break;
									case "0":

						                quit = true;
						                System.out.println("Goodbye!");
						                System.exit(0);
										break;
									default:
										System.out.println("I'm sorry, that is not a valid input. Please try again.");
										}
								
							}
						}
					
				}else if(userInput.equals("Admin") || userInput.equals("Admin") || userInput.equals("2") || userInput.equals("2.")) {
					System.out.println("Hello Admin, let's get you signed in.");
					//String userName;
					//String passWord;
					//String fullName;
					System.out.println("Username:");
					userName = bankScan.next();
					System.out.println("Password:");
					passWord = bankScan.next();
					if(acct == null) {
						System.out.println("Invalid ID/password!");
					}else  {
						 
							System.out.println("Hello Admin, how can I help you today?");
							System.out.println("1. Accounts" + "\n2. Add" + "\n3. Delete" +  "\nInput 0 to exit.");
							userInput = bankScan.next();
							boolean oneStep = true;
							boolean userMenu = false;
							while(!userMenu) {
								if(!oneStep) {
									System.out.println("1. Accounts" + "\n2. Add" + "\n3. Delete" +  "\nInput 0 to exit.");
									userInput = bankScan.next();
								}
								switch(userInput) {
								case "1":
								case "1.":
								case "Accounts":
								case "account":
									System.out.println("Admin, here is the current accounts: ");
									System.out.println(bankDao.getThoseAccounts());
									System.out.println("Would you like to continue?" + "\nYes or No");
									userInput = bankScan.next();
									if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
										userMenu = false;
										oneStep = false;
									}
									else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
										System.out.println("Have a good day!");
										userMenu = true;
										quit = true;
									}
									break;
								case "2":
								case "2.":
								case "Add":
								case "add":
									System.out.println("You would like to add a account?" + "\nThen I need more information." +
								"\nWhat is the first name?");
									String firtemp;
									firtemp = bankScan.nextLine();
									System.out.println("The last name?");
									String lastemp;
									lastemp = bankScan.nextLine();
									System.out.println("Very good. What would you like your username to be? ");
									String nicktemp;
									nicktemp = bankScan.nextLine();
									System.out.println("How about a password?");
									String passtemp;
									passtemp = bankScan.nextLine();
									System.out.println("Are they a Admin? 1 for yes, 0 for no.");
									int adtemp;
									adtemp = bankScan.nextInt();
									System.out.println("What is the Account type?");
									String acctemp;
									acctemp = bankScan.nextLine();
									System.out.println("And how much money will they be putting in their balance?");
									double baltemp;
									baltemp = bankScan.nextDouble();
									System.out.println("Very good! Let's create the account.");
									double checktemp = 500;
									bankDao.insertAcc(firtemp, lastemp, nicktemp, passtemp, adtemp, acctemp, baltemp, checktemp);
									System.out.println(bankDao.personalLook(nicktemp));
									System.out.println("Would you like to continue?" + "\nYes or No");
									userInput = bankScan.next();
									if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
										userMenu = false;
										oneStep = false;
									}
									else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
										System.out.println("Have a good day!");
										userMenu = true;
										quit = true;
									}
									break;
								case "3":
								case "3.":
								case "Delete":
								case "delete":
									System.out.println("Which account would you like to delete?");
									System.out.println(bankDao.getThoseAccounts());
									System.out.println("Type in the username of the account you wish gone.");
									userName = bankScan.next();
									bankDao.deleteAcc(userName);
									
									System.out.println("The account has been deleted, would you like to continue?" +"\nYes or No"); 
									userInput = bankScan.next();
									if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
										userMenu = false;
										oneStep = false;
									}
									else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
										System.out.println("Have a good day!");
										userMenu = true;
										quit = true;
									}
									break;
								
								case "0":

					                quit = true;
					                System.out.println("Goodbye!");
					                System.exit(0);
									break;
								default:
									System.out.println("I'm sorry, that is not a valid input. Please try again.");
									
									
									
								
						}
					
			}
	}
				}}else if(userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
					System.out.println("Welcome new user! Would you like to setup a account?");
					whileStop = true;
					System.out.println("Yes or No");
					userInput = bankScan.next();
					if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
						System.out.println("Wonderful! Let's begin.");
						System.out.println("What is your name?");
						String firtemp;
						firtemp = bankScan.nextLine();
						System.out.println("The last name?");
						String lastemp;
						lastemp = bankScan.nextLine();
						System.out.println("Very good. What would you like your username to be? ");
						String nicktemp;
						nicktemp = bankScan.nextLine();
						System.out.println("How about a password?");
						String passtemp;
						passtemp = bankScan.nextLine();
					
						int adtemp = 0;
						adtemp = bankScan.nextInt();
						System.out.println("What is the Account type?");
						String acctemp;
						acctemp = bankScan.nextLine();
						System.out.println("And how much money will they be putting in their balance?");
						double baltemp;
						baltemp = bankScan.nextDouble();
						System.out.println("Very good! Let's create the account.");
						double checktemp = 500;
						bankDao.insertAcc(firtemp, lastemp, nicktemp, passtemp, adtemp, acctemp, baltemp, checktemp);
					}
				}
				}
			}while (!quit);
	}
					

						
							
							
	
	@Override
	public List<AccountTab> getThoseAccounts() {
		List<AccountTab> accounts = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM userbank";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accounts.add(
						//new AccountTab()
						new AccountTab(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
								rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getDouble(9), rs.getDouble(10)
						));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public void insertAcc(String firstname, String lastname, String userName, String passWord, int isAdmin,
			String accType, double balance, double check) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "INSERT INTO userbank(first_name, last_name, username, password, isAdmin, acctype, balance, savings)"
					+ " VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";
			
			//int accKey;
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, userName);
			ps.setString(4, passWord);
			ps.setInt(5, isAdmin);
			
			ps.setString(6, accType);
			ps.setDouble(7, balance);
			ps.setDouble(8, check);
		
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<AccountTab> personalLook(String userName) {
		List<AccountTab> accounts = new ArrayList<>();
	try(Connection conn = DriverManager.getConnection(url, username, password)){
		String sql = "SELECT * FROM userbank WHERE username = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			accounts.add(
					//new AccountTab()
					new AccountTab(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getDouble(9), rs.getDouble(10)
					));
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return accounts;
}
		
	
	public static void updateAccBalance(double balance, String userName) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "UPDATE userbank SET balance = ? WHERE username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setString(2, userName);
			ps.executeUpdate();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateAccCheck(double check, int accnum) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "UPDATE userbank SET balance = ? WHERE accnum = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, check);
			ps.setInt(2, accnum);
			ps.executeUpdate();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	public static void deleteAcc(String userName) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "DELETE FROM userbank WHERE username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			
			ps.executeUpdate();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<UserRef> getthoseusers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AccountTab getAccount(AccountTab actTab) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserRef getUser(UserRef userRef) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void accountCreate(String user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean checkUsernameAndPassword(String u, String p) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public AccountTab login2(String u, String p) {
		// TODO Auto-generated method stub
		return null;
	}

}


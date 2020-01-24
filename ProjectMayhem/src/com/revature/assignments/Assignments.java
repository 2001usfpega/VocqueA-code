package com.revature.assignments;

public class Assignments {
	
	
	static float currancy = 3.50f;
	static float currentMoney = 1.35f;
	static double bigMoney = 450.98f;
	static double largerMoney = 90293.2921f;
	static String lochnessMonster = "Loch Ness Monster";
	static Float whatIWant;
	
	
	
	
public static void main(String[] args) {
	System.out.println("The " + lochnessMonster + " wants my dang " + currancy + " dollars!");
	bigMoney = currancy;
	//widening
	currentMoney = (float)largerMoney;
	//Narrowing
	System.out.println(bigMoney);
	System.out.println(currentMoney);
		
	}

}

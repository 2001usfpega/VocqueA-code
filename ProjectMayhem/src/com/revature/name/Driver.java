package com.revature.name;
import com.revature.bean.Person;
import com.revature.staticfun.FunWithStatic;

import java.sql.*; // * is a wild card
//import static java.util.*; 
public class Driver {
	

	//single line comment
	/* Multi 
	 * line
	 * comment 
	 * 
	 * 
	 * Naming Conventions
	 * Classes and Projects - Pascal casing ex. ProjectMayhem
	 * methods and variables - Camel casing ex. firstSecondThird
	 * package - all lower case, separated by periods
	 * constants - ALL_CAPS_LOLZ
	 */
	
	
	//Main method - serves as the entry point for an application
	public static void main(String [] args) {
		// public - access modifiers errbody can "see" it
		// static - belongs to the class, no object needed
		// void - doesn't return anything
		// main - name of method
		// String [] args - an array of strings called args
		int a = 3,b = 46;
		int c = a + b;
		
	//Sysout + Ctrl/Space
		
	System.out.println();
	System.out.println("I like to eat " + c + " tacos.");
	/*
	 * Members of a class - can diff forms
	 * Variables, Methods and Constructors
	 * Instance variables - property belongs to specific object
	 * Static variables - belong to class/all instances
	 * Instance Methods - behavior related to a specific object
	 * Static methods - relative to the entire class
	 * Constructors - instantiates the class using the keyword "new"
	 * 
	 */
	Person p = new Person();
	p.setName("Jim");
	System.out.println(p);
	Person q= new Person("BobPam", 81, 27);
	System.out.println(q  );
	
	FunWithStatic fws = new FunWithStatic();
	fws.nonStaticMethod();
	//FunWithStatic.staticmethod
	}
	
}

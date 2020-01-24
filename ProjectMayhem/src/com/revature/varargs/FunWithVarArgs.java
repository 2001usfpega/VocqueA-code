package com.revature.varargs;

public class FunWithVarArgs {
	/*
	 * Variable length arguments - varargs
	 * Method that will take a variable number of arguments
	 * Automates and hides the process of creating and saving
	 * the values into an array prior to invoking the method
	 * Can be of any type!
	 * must be the last argument
	 * 0 to many args
	 */
	
	public static void main(String[] args) {
		int [] a= {1,2,3,4,5,6,7,8};
		vaTest(10);
		vaTest(2,3,51,5,1,6,6,3,7,22,52,47);
		vaTest();
		vaTest(a);
	}
	
	public static void vaTest( int ... v) {
		System.out.println("number of args is "+ v.length+ " Contents.");
		for(int x:v ) {
			System.out.print(x + " ");
		}
		
		System.out.println();
		
	}

}

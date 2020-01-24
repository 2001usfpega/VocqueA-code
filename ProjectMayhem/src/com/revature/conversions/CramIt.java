package com.revature.conversions;

public class CramIt {
	static float f = 32.876f;
	
	static double d; 
	static float g;
	
	public static void main(String [] bettyWhite) {
		//Conversions
		//widening
		d = f;
		//Narrowing 
		g = (float)d; // ()'s is cast, cast has to have the data type that it's changing into.
		System.out.println(d);
		System.out.println(g);
		
		Object o;
		o= new String("YeeHaw");
		System.out.println(o);
		
	}

}

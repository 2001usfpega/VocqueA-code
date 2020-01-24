package com.revature.strangs;

public class FunWithStrings {
/*
 * Strings!
 * not char or Character
 * Not a primitive
 * Fully Qualified class name:java.lang.String
 * Sting literal is 0+ characters ex "" or String a="Roll Tide";
 * concatenate strings w/ + concat()
 * Strings are immutable
 * string pool - collection of unique String literals in heap memory
 * some strings are common and used in mult places within app
 * String s= "dog"; Compiler searches string pool for "dog:
 * if it exists, it will create a reference to it
 * if it does not exist, it will create a new string literal in the string pool
 * String a= "dog"; same reference as s
 * a= a+"house";
 * String API has utility methods
 * String- String Pool, Immutable, thread safe, fast
 * StringBuilder- No String pool, Mutable, not thread safe, fast
 * StringBuffer- No String pool, Mutable, thread safe, slow
 * 
 */
	public static void main(String[] args) {
		
		String s = "Roll Tide";
		System.out.println(s.hashCode());
		System.out.println(s);
		s = "woo";
		System.out.println(s);
		System.out.println(s.hashCode());
		String d = "Roll Tide";
		System.out.println(d.hashCode());
		System.out.println(d.charAt(3));
		String a = "Pega";
		String b=a;
		System.out.println(a==b);
		// TODO Auto-generated method stub

	}

}

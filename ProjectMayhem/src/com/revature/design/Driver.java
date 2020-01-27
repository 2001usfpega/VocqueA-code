package com.revature.design;

public class Driver {
	private static HondaFactory hf = new HondaFactory();
	public static void main(String[] args) {
		Car c1=hf.getCar("crv", 0, "matte grey", null);
		Car c2=hf.getCar("civic", 0, "green", null);
		Car c3=hf.getCar("potato", 0, "clear", null);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	
	}

}

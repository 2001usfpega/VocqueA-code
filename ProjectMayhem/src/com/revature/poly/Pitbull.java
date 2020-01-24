package com.revature.poly;

public class Pitbull extends Mammal {
	static int sv; // gets a default value
	public String str; // does get default value
	@Override
	public void eat() {
		System.out.println("I am a pitbull who is eating.");
		
		
			
		}
	public void eat1() {
		//method scope
		//does not get default value
		int a = 5;
		super.eat();
		System.out.println(a + sv);
		//Block Scope
		if(a==5) {
			int d =33;//does not get default value
			System.out.println("Roll Tide" + d);
		}
	}
	{
		//Block scope
		int a = 67; // does not get a default value
		System.out.println(a);
	}

}

package com.revature.javacore;
import java.util.ArrayList;
import java.util.Comparator;
//Used GeeksforGeeks as reference and tutorial help
public class CoreDriver {
	//Question One's Bubble sort Array
	static int [] bubbleArray = {1,0,5,6,3,2,3,7,9,8,4};
	
	static int factInt = 3;
	
	static int eveNum = 6;
	static int oddNum = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creates a object of the class to a shortcut
		CoreDriver bs = new CoreDriver();
		//uses the shortcut to call bubSort method
		bs.bubSort(bubbleArray);
		System.out.println("The Array has been sorted boooooi");
		bs.printMyBubbles(bubbleArray);
		System.out.println();
		bs.soundsLikeSpaghetti();
		System.out.println();
		bs.sdrowkacb();
		System.out.println("");
		System.out.println("This damn number: " + factInt + " factorial is " + bs.facts(factInt));
		System.out.println("");
		bs.oddEven(eveNum);
		bs.oddEven(oddNum);
		System.out.println(" ");
		
		ArrayList<PeopleWhoWorkForMoney> el = new ArrayList<PeoplWhoWorkForMoney>
		el.add(new PeopleWhoWorkForMoney(27, "Amanda", "GameDesign"));
		
		
	}
	
	//Bubble sort method (Q1)
	void bubSort(int [] bubAr) {
		// creates a shortcut, n, to match the length of the bubble array in the method.
		int n = bubAr.length;
		// creates a, b and bubTemp integers to be used for shortcuts in the loops and arrays
		int a,b, bubTemp = 0;
		//System.out.println(n); Testing code purposes
		//Goes through the array the first iteration
		for (a = 0; a < n -1; a++) 
			// Goes through a second iteration
			for ( b = 0; b < n - a - 1; b++) 
				//if compares the numbers next to each other
			if (bubAr[b] > bubAr[b+1]) {
			bubTemp = bubAr[b];
			
			bubAr[b] = bubAr[b + 1];
			bubAr[b + 1] = bubTemp;
			
			}
		
		//System.out.print(bubAr[a] + " "); Didn't work as planned, prints only 9.
		// Tested it a few times, but I was the only one in the group to make a shortcut to
		// array.length, might be the issue
			}
		
	
	//Bubble Sort Print Method (Q1)
	public void printMyBubbles(int [] bubAr) {
		//Creates a shortcut to Array length and int used in the for loop.
		int n = bubAr.length;
		int i;
		//Goes through the array using less than and increments, to print each number
		for(i = 0; i<n; ++i)
			System.out.print(bubAr[i] + " ");
		System.out.println();
	}
	// Fibonacci Q2
	static void soundsLikeSpaghetti() {
		// the first two numbers is always 0 and 1
		int prego1 = 0, meatballs2 = 1;
		// uses the w as a starting point
		int w = 0;
		System.out.println("Let the Fibonacci begin!");
		
		// Wendy's suggest of While instead of if, keeps checking until it hits the limit.
		while (w < 25) {
			System.out.print(prego1 + " ");
			//the equation to keep adding the two numbers together
			int pasta3 = prego1 + meatballs2;
			// Changes them to the next numbers in the array
			prego1 = meatballs2;
			meatballs2 = pasta3;
			w++;
		}
		
	}
	// Reverse string Q3
	static void sdrowkacb() {
		System.out.print("\nReverse a string!");
		String unoReverse = "You activated my trap card!";
		System.out.println("\n" + unoReverse);
		char[] reverseUno = unoReverse.toCharArray();
		//The for statement starts at the bottom of the array, and 
		for(int i = (reverseUno.length -1); i>=0; i --)
			System.out.print(reverseUno[i]);
		
	}
	
	 int facts(int n) {
//			int truth = 1, i;
//			for (i = 2; i<=n; i++)
//				truth *= i;
//			return truth;
		 // Tried this code first, but was having trouble,
		 //while I moved on the to next one, the problem was the number it was taking it was too
		 //large so it was having trouble printing
		 //Used the Ternary operators solution
		 return ( n == 1 || n == 0) ? 1 : n * facts(n -1);
		
		
	}
	 
	 void stringIndex() {
		 
	 }
	 
	 //Even and Odds Q6
	 public void oddEven(int num) {
		 System.out.println("Let's determine if this number is even or odd:");
		 if((num/2)* 2 == num)
			 System.out.println("This number is Even");
		 else 
			 System.out.println("This number is Odd");
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}



//Employee Q7
class PeopleWhoWorkForMoney{
	
	String name;
	String department;
	int age;
	
	public void Employee(int age, String name, String department )
	{
		this.age = age;
		this.name = name;
		this.department = department;
	}
	
	public String toString()
	{
		return this.age + " " + this.name + " " + this.department;
	}
	
	
}

abstract class Sortbyage implements Comparator<PeopleWhoWorkForMoney>
{
	
	public int compare(PeopleWhoWorkForMoney a, PeopleWhoWorkForMoney b) {
		return a.age - b.age;
	}
}

abstract class Sortbyname implements Comparator<PeopleWhoWorkForMoney>{
	public int compare(PeopleWhoWorkForMoney a, PeopleWhoWorkForMoney b)
	{
		return a.name.compareTo(b.name);
	}
}

abstract class Sortbyaddress implements Comparator<PeopleWhoWorkForMoney>{
	public int compare(PeopleWhoWorkForMoney a, PeopleWhoWorkForMoney b) {
		return a.name.compareTo(b.name);
	}
}
		

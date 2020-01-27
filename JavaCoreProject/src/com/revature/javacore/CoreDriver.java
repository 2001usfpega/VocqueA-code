package com.revature.javacore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.revature.samplesize.MakeItFloat;

import static com.revature.samplesize.MakeItFloat.*;

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
		mathIsFun mis = new mathIsFun();
		Scanner sc = new Scanner(System.in);
		//uses the shortcut to call bubSort method
		System.out.println("The array to be sorted is: 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4.");
		bs.bubSort(bubbleArray);
		System.out.println("The Array has been sorted boooooi");
		//Created a print method that brings in the array, and sorts it for console view
		bs.printMyBubbles(bubbleArray);
		System.out.println();
		// uses the object shortcut to call the soundsLikeSpaghetti method
		// Also known as the Fibonacci method
		CoreDriver.soundsLikeSpaghetti();
		System.out.println();
		// Calls Reverse String Method
		CoreDriver.sdrowkacb();
		System.out.println("");
		//calls the N Factorial method
		System.out.println("\nThis damn number: " + factInt + " factorial is " + bs.facts(factInt));
		System.out.println("");
		//String Index Method and Scanner is used.
		// Exception is called when number is picked out of the index. (Exc1)
		System.out.println("It's time for the String Index!" + "\nThe sentence to test is: Mama, we all go to hell!");
		System.out.println("\nPick a number between 2 and 25!");
		int index = sc.nextInt();
		System.out.println(index);
		bs.stringIndex(index);
		//Even or Odd method
		System.out.println("This next show on the list could be the odd one out: Even or Odd numbers!");
		System.out.println("\nThe number was: " + eveNum);
		bs.oddEven(eveNum);
		
		System.out.println("\nThe number was: " + oddNum);
		bs.oddEven(oddNum);
		
		System.out.println("\nNow try a number: ");
		int oddEvenNum = sc.nextInt();
		bs.oddEven(oddEvenNum);
		
		//Employee sorting lists
		System.out.println("\nEmployee sorting lists!");
		bs.EmployeeList();
		
		CoreDriver.tacocat();
		
		bs.primeList();
		
		
		System.out.println("\nTime to find the smallest number!");
		System.out.println("First number:");
		int firstOne = sc.nextInt();
		System.out.println("Second number:");
		int secondOne = sc.nextInt();
		bs.smallLarge(firstOne, secondOne);
		
		//(Q11) Take variables from another package
		System.out.println("\nI got these from another package: " + MakeItFloat.redBalloon + " and " + MakeItFloat.paperShip);
		
		bs.numTriangle();
		System.out.println(" ");
		bs.evenStevens();
		
		System.out.println(" ");
		System.out.println("Let's practice a switch statement:" + "\nType Math for a square root problem." + " Type Date for today's date." + " And type Split for a string split.");
		String conan = sc.next();
		bs.caseClosed(conan);
		System.out.println("It's time for some Math fun!" + "\nLet's have a number: ");
		double math01 = sc.nextDouble();
		System.out.println("Now a second number: ");
		double math02 = sc.nextDouble();
		mis.addition(math01, math02);
		mis.subtraction(math01, math02);
		mis.multiplication(math01, math02);
		mis.division(math01, math02);
		
		
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
				//Turns bubTemp's value to bubAr[b]'s value
			bubTemp = bubAr[b];
			//Then changes b to the next value in the array.
			bubAr[b] = bubAr[b + 1];
			//and changes the next value in the array to bubTemp's value,
			//Completing the switch. 
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
	// Fibonacci (Q2)
	static void soundsLikeSpaghetti() {
		// the first two numbers is always 0 and 1
		int prego1 = 0, meatballs2 = 1;
		// uses the w as a starting point
		int w = 0;
		System.out.println("Let the Fibonacci begin!");
		
		// Wendy's suggest of While instead of if, keeps checking until it hits the limit of
		// 25.
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
	// Reverse string (Q3)
	static void sdrowkacb() {
		System.out.print("\nReverse a string!");
		// Yu-gi-oh easteregg
		String unoReverse = "You activated my trap card!";
		System.out.println("\n" + unoReverse);
		char[] reverseUno = unoReverse.toCharArray();
		//The for statement starts at the bottom of the array, and prints out each letter
		// til it is equal to 0. It uses decrements to move up the letters in the sentence
		// one by one
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
		 //large so it was having trouble printing (Orginal number it tried was 77)
		 
		 //Used the Ternary operators solution
		 //uses the =='s to check if the value of is n is equal to the number
		 //uses the || or operator to check if any of the oprands is equal to non-zero
		 //then uses to the ? operator to do the boolean, if true it equals one, if false
		 //it does the equation of n times facts method with n - 1
		 return ( n == 1 || n == 0) ? 1 : n * facts(n -1);
		
		
	}
	 //String Index (Q5)
	 void stringIndex(int idx) {
		 
		 String str = new String ("Mama, we all go to hell.");
		// System.out.println("The sentence to test is: ");
		// System.out.println(str);
		
		 System.out.println(str.substring(0, idx - 1));
		 
		 
	 }
	 
	 //Even and Odds (Q6)
	 public void oddEven(int num) {
		 System.out.println("Let's determine if this number is even or odd:");
		 
		 if((num/2)* 2 == num)
			 System.out.println("This number is Even");
		 else 
			 System.out.println("This number is Odd");
		 
	 } 
	 
	 //EmployeeList (Q7)
	 
	 public void EmployeeList() {
		 
		 //Creates a new array list for the purpose of storing Employees and their values
		 ArrayList<PeopleWhoWorkForMoney> el = new ArrayList<PeopleWhoWorkForMoney>();
		 //Uses the constructor from the class PeopleWhoWorkForMoney to set the parameters,
		 //and allows us to instantiate new objects using the parameters and 
		 //values.
			el.add(new PeopleWhoWorkForMoney(27, "Amanda", "Game Design"));
			el.add(new PeopleWhoWorkForMoney(27, "Wendy", "Kinesology"));
			el.add(new PeopleWhoWorkForMoney(21, "Alia", "World Dominator"));
			
			System.out.println("Unsorted");
			//Prints out the list how it currently is
			for (int i = 0; i<el.size(); i++)
				System.out.println(el.get(i));
			
			//Uses the Collections sort feature, to use the class
			//previously made, Sortbyage, to sort the list to fit
			//in the new parameters 
			Collections.sort(el, new Sortbyage());
			
			System.out.println("\nSorted by age: ");
			for (int i = 0; i < el.size(); i++)
				System.out.println(el.get(i));
			
			Collections.sort(el, new Sortbyname());
			System.out.println("\nSorted by name: ");
			for ( int i = 0; i < el.size(); i++)
				System.out.println(el.get(i));
			
			Collections.sort(el, new Sortbydepartment());
			System.out.println("\nSorted by department: ");
			
			for(int i = 0; i < el.size(); i++)
				System.out.println(el.get(i));
		 
	 }
	 
	 // (Q8)
	 static void tacocat() {
		 //Created two empty ArrayLists, one that will store all strings used,
		 //and another to store all the palindrome strings.
		 ArrayList<String> unsortedList = new ArrayList<String>();
		 ArrayList<String> palinList = new ArrayList<String>();
		 ArrayList<String> noPalinList = new ArrayList<String>();
		 
		 unsortedList.add("karan");
		 unsortedList.add("madam");
		 unsortedList.add("tom");
		 unsortedList.add("civic");
		 unsortedList.add("radar");
		 unsortedList.add("jimmy");
		 unsortedList.add("kayak");
		 unsortedList.add("john");
		 unsortedList.add("refer");
		 unsortedList.add("billy");
		 unsortedList.add("did");
		 
		 System.out.println("Start of the array list!");
		 for (String unsort: unsortedList) {
			 System.out.println(unsort);
		 }
		 
		 for(int i = 0; i < unsortedList.size(); i++) {
			 String taco = unsortedList.get(i);
			 
			 String cat = new StringBuilder(taco).reverse().toString();
			 
			 if(taco.equals(cat)) {
				 palinList.add(taco);
			 }
			 else {
				 noPalinList.add(taco);
			 }
		 }
		 System.out.println("Palindromes list!");
		 
		 for (String i : palinList) {
			 System.out.print(i + " ");
		 }
		 
		 System.out.println("\nWhat was left over: ");
		 
		 for(String i : noPalinList) {
			 System.out.print(i + " ");
		 }
	
	
		 
	 }
	 //Q9 Print the primes
	 public static void primeList() {
		 int num = 0;
		 int maxPrime = 100;
		 Boolean amIPrime = true;
		 String primeFound = " ";
		 
		 for(int i = 1; i <= maxPrime; i++) {
			 amIPrime = CheckPrime(i);
			 if(amIPrime) {
				 primeFound = primeFound + i + " ";
			 }
		 }
		 System.out.println("\n\nPrime numbers found between one and one hundred are: ");
		 System.out.println(primeFound);
	 }
	 
	 public static boolean CheckPrime(int numCheck) {
		 int rem;
		 for (int i = 2; i <= numCheck / 2; i ++) {
			 rem = numCheck % i;
			 
			 if(rem == 0) {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 // (Q10) Find the minimum of two numbers
	 public static void smallLarge(int int1, int int2) {
		 int smallBoi;
		 
		 smallBoi = (int1 < int2) ? int1 : int2;
		 System.out.println("Smallest number between " + int1 + " and " + int2 + " is " + smallBoi);
		 
		 
	 }
	  //(Q12) Print even numbers using a enhanced loop
	 public static void evenStevens() {
		 
		 System.out.println("It's time to print some even numbers!" + "\nWe'll be using the array 1 through 100.");
		 int[] areYouEven = new int[101];
		 for(int i = 1; i <= 100; i ++) {
			 areYouEven[i] = i;
		 }
		 
		 boolean odd = true;
		 
		 for(int i : areYouEven) {
			 if(odd & i != 0) {
				 System.out.print(areYouEven[i] + " ");
			 }
			 odd = !odd;
		 }
	 }
	 
	 //(Q13) Print a triangle using loops
	 public static void numTriangle() {
		 int i, e, rows = 5;
		 int bill = 0;
		 
		 for(i = 0; i <= rows; ++i) {
			 for(e = 0; e< i; e++) {
				 System.out.print(bill);
				 
				 bill = 1 - bill;
			 }
		System.out.println();
	 }
	//(Q14) 	 
	
	 
}
	 public static void caseClosed(String tellMe) {
			
		 switch(tellMe) {
		 case "Math":
		 case "math":
			 System.out.println("Let's find the square root of 169!");
			 System.out.println(Math.sqrt(169));
			 break;
		 case "Date":
		 case "date":
			 LocalDate giveMeADate = LocalDate.now();
			 System.out.println("\nThe date is: " + giveMeADate);
			 break;
		 case "Split":
		 case "split":
			 String spitItUp = "I am learning Core Jave";
			 
			 String[] spitItDown = spitItUp.split(" ");
			 for (int i = 0; i < spitItDown.length; i++) {
				 System.out.println(spitItDown[i] + " ");
			 }
		 
		}

}

//Employee Q7
class PeopleWhoWorkForMoney{
	
	String name;
	String department;
	int age;
	
	/* Was missing a constructor, ends up I was missing the most important rule,
	 * name the constructor after the class.
	 * public PeopleWhoWorkForMoney(int i, String string, String string2) { // TODO
	 * Auto-generated constructor stub }
	 */

	//PeopleWhoWorkForMoney's actual constructor
	public PeopleWhoWorkForMoney(int age, String name, String department )
	{
		//Keywords setting the values to the current object
		this.age = age;
		this.name = name;
		this.department = department;
	}
	
	public String toString()
	{
		//returns the values as a string
		return this.age + " " + this.name + " " + this.department;
	}
	
	
}

//A class set up to sort the employees by age
// puts the Comparator in use in the class by implementing it
class Sortbyage implements Comparator<PeopleWhoWorkForMoney>
{
	//uses the compare() feature in the Comparator in the interface, 
	//to compare against the two objects(or more) used.
	public int compare(PeopleWhoWorkForMoney a, PeopleWhoWorkForMoney b) {
		//the return allows it to decide what exact value it's comparing against
		return a.age - b.age;
	}
}
// This continues for two more classes, but just exchanges the values to name...
class Sortbyname implements Comparator<PeopleWhoWorkForMoney>{
	public int compare(PeopleWhoWorkForMoney a, PeopleWhoWorkForMoney b)
	{
		return a.name.compareTo(b.name);
	}
}
//...and department
 class Sortbydepartment implements Comparator<PeopleWhoWorkForMoney>{
	public int compare(PeopleWhoWorkForMoney a, PeopleWhoWorkForMoney b) {
		return a.department.compareTo(b.department);
	}
}
}

//(Q15) Math Interface
class mathIsFun implements CoreInterface{
	
	@Override
	public double addition(double d, double e) {
		System.out.println((d+e));
		return d + e;
		
	}
	
	@Override
	public double subtraction(double d, double e) {
		System.out.println((d-e));
		return d - e;
	}
	
	@Override
	public double multiplication(double d, double e) {
		System.out.println((d*e));
		return d * e;
	}
	@Override
	public double division(double d, double e) {
		if( e == 0) {
			return 0;
		}
		System.out.println((d/e));
		return d / e;
	}
}
		

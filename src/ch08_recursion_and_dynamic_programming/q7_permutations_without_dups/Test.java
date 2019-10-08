package ch08_recursion_and_dynamic_programming.q7_permutations_without_dups;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		   
	     int[] numbers;  // An array for storing the input values.
	     int numCount;   // The number of numbers saved in the array.
	     int num;        // One of the numbers input by the user.
	     
	     numbers = new int[100];   // Space for 100 ints.
	     numCount = 0;             // No numbers have been saved yet.
	     
	     System.out.println("Enter up to 100 positive integers; enter 0 to end.");
	     Scanner in = new Scanner(System.in);
	     
	     while (true) {   // Get the numbers and put them in the array.
	        System.out.println("? ");
	        num = in.nextInt();
	        if (num <= 0)
	           break;
	        numbers[numCount] = num;
	        numCount++;
	     }
	     
	     in.close();
	     System.out.println("\nYour numbers in reverse order are:\n");
	     
	     for (int i = numCount - 1; i >= 0; i--) {
	         System.out.println(numbers[i] );
	     }
	     
	   } // end main();

}

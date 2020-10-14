/**
 * 
 */
package com.java.problems.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class DivideArray {

	static int pos = -1;
	static int currentTrue = 0, currentFalse = 0;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string with space separated 1 and 0 : ");
		String input = br.readLine();
		System.out.println("Enter the value of i and j");
		String[] str = br.readLine().split("\\s+");
		int i = Integer.parseInt(str[0]);
		int j = Integer.parseInt(str[1]);
		pos = divide(input, i, j);
		System.out.println("Initial Partition Position = " + pos);
		System.out.println("Enter the new position where update has to happen and the updated value : ");
		str = br.readLine().split("\\s+");
		int newPosition = Integer.parseInt(str[0]);
		String updatedValue = str[1];
		pos = update(input, i, newPosition, updatedValue, pos, j);
		System.out.println("Updated Partition Position = " + pos);
	}

	/*
	 * By looking at the pattern for dividing the array, it can be seen that the
	 * location at which it partitions, the number of True values on the LHS = No of
	 * False Values on the RHS Now, if we increase a True value on the LHS, the no
	 * of False value on the RHS also has to be incremented. So we return position
	 * obtained from dividing the array minus 1
	 * 
	 * If the no of False value is incremented on the LHS, the no of True values has
	 * to be incremented on the RHS or in other words, we have to decrement the no
	 * of False values on the RHS
	 * 
	 * So, for doing this we can just increment or decrement the position by 1,
	 * depending on the update vale Hence it will take o(1) ie. constant time.
	 * 
	 * Time Complexity = O(1) Space Complexity = O(1)
	 */
	private static int update(String input, int i, int newPosition, String b, int k, int j) {
		// TODO Auto-generated method stub
		if (newPosition >= i && newPosition <= j) {
			if (b.equalsIgnoreCase("1"))
				return pos - 1;
			else
				return pos + 1;
		}
		return k;
	}

	/*
	 * Divides the array from range i to j into 2 halves having partition at 'k'
	 * such that No of Trues in i to j = No of False in k+1 to j
	 * 
	 * Time Complexity = O(n) Space Complexity = O(1)
	 */
	private static int divide(String input, int i, int j) {
		// TODO Auto-generated method stub
		String[] arr = input.split(" ");
		int left = i - 1, right = j - 1;
		int noOfTrue = 0;
		for (int k = left; k <= right; k++) { // This loop is used to calculate the total no of True values in the given
												// range. The Time Complexity for the loop = O(n)
			if (arr[k].equalsIgnoreCase("1"))
				noOfTrue++;
		}
		if (noOfTrue == j - i + 1) // if the no of True values equals the number of elements between i and j, then
									// we return (i-1)
			return i - 1;
		else {
			int noOfFalse = (j - i + 1) - noOfTrue; // Get the no of False values in the given range by subtracting the
													// no of True values obtained earlier
			for (int k = left; k <= right; k++) { // Time complexity for the loop = O(n)
				if (arr[k].equalsIgnoreCase("1")) // Used for keeping track of the current no of True Values
					currentTrue++;
				else
					currentFalse++; // Used for keeping track of the current no of False Values
				if (currentTrue == noOfFalse - currentFalse) // if at the current position standing, divides the array(i
																// to j) in equal no of True Values from i to k and
																// False values from (k+1) to j, then consider this
																// position and break the loop
					return k + 1;
			}
		}
		return -1; // if it cannot be satisfied, then we return -1
	}

}

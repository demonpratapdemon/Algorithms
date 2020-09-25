/**
 * 
 */
package com.java.problems.miscellaneous;

/**
 * @author PRATAP
 *
 */
public class DivideArray {

	static int pos = -1;
	static int currentTrue = 0, currentFalse = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "False False False False False False False False";
		pos = divide(input, 1, 8);
		System.out.println("Initial Partition Position = " + pos);
		pos = update(input, 1, "True", pos);
		System.out.println("Updated Partition Position = " + pos);
	}

	private static int update(String input, int i, String b, int k) {
		// TODO Auto-generated method stub
		String arr[] = input.split(" ");
		if (arr[i - 1].equalsIgnoreCase(b))
			return pos;
		else {
			if (b.equalsIgnoreCase("TRUE"))
				return pos - 1;
			else
				return pos + 1;
		}
	}

	private static int divide(String input, int i, int j) {
		// TODO Auto-generated method stub
		String[] arr = input.split(" ");
		int left = i - 1, right = j - 1;
		int noOfTrue = 0;
		for (int k = left; k <= right; k++) {
			if (arr[k].equalsIgnoreCase("TRUE"))
				noOfTrue++;
		}
		if (noOfTrue == j - i + 1)
			return i - 1;
		else {
			int noOfFalse = (j - i + 1) - noOfTrue;
			for (int k = left; k <= right; k++) {
				if (arr[k].equalsIgnoreCase("TRUE"))
					currentTrue++;
				else
					currentFalse++;
				if (currentTrue == noOfFalse - currentFalse)
					return k + 1;
			}
		}
		return -1;
	}

}

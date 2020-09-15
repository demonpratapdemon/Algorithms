/**
 * 
 */
package com.java.problems.search;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.java.problems.util.Utility;

/**
 * @author PRATAP
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[] arr = Utility.readNumbers();
		System.out.println("Enter the item to be searched");
		boolean flag = binarySearch(arr, scanner.nextInt());
		System.out.println(flag);
		scanner.close();
	}

	public static boolean binarySearch(int[] newArr, int item) {

		Arrays.sort(newArr);
		int start = 0;
		int end = newArr.length - 1;
		int mid;
		if (item > newArr[end] || item < newArr[start])
			return false;
		while (start <= end) {
			mid = (start + end) / 2;
			if (newArr[mid] == item)
				return true;
			if (newArr[mid] < item)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}
}

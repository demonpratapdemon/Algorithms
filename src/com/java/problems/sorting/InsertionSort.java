/**
 * 
 */
package com.java.problems.sorting;

import java.io.IOException;

import com.java.problems.util.Utility;

/**
 * @author PRATAP
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] arr = Utility.readNumbers();
		arr = insertionSort(arr);
		Utility.printNumbers(arr);
	}

	private static int[] insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		int j, temp;
		for (int i = 1; i < arr.length; i++) {
			j = i - 1;
			temp = arr[i];
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j--];
			}
			arr[j + 1] = temp;
		}
		return arr;
	}

}

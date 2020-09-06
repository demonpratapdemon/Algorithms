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
public class BubbleSort {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] arr = Utility.readNumbers();
		arr = bubbleSort(arr);
		Utility.printNumbers(arr);
	}

	private static int[] bubbleSort(int[] arr) {
		// TODO Auto-generated method stub
		int swapped = 1, temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			swapped = 0;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swapped = 1;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (swapped == 0)
				break;
		}
		return arr;
	}

}

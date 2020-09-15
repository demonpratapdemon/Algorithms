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
public class SelectionSort {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] arr = Utility.readNumbers();
		arr = selectionSort(arr);
		Utility.printNumbers(arr);
	}

	private static int[] selectionSort(int[] arr) {
		// TODO Auto-generated method stub
		int max, temp, j;
		for (int i = 0; i < arr.length; i++) {
			j = 0;
			max = 0;
			for (; j < arr.length - i; j++) {
				if (arr[j] > arr[max])
					max = j;
			}
			if (max <= arr.length - 1) {
				temp = arr[max];
				arr[max] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
		return arr;
	}

}

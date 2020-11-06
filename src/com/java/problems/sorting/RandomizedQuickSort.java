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
public class RandomizedQuickSort {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] arr = Utility.readNumbers();
		arr = randomisedQuickSort(arr, 0, arr.length - 1);
		Utility.printNumbers(arr);
	}

	private static int[] randomisedQuickSort(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			Double p = Double.parseDouble(String.valueOf(Math.random() % (right - left + 1) + left));
			arr = swap(arr, left, p.intValue());
			int k = partition(arr, left, right);
			randomisedQuickSort(arr, left, k - 1);
			randomisedQuickSort(arr, k + 1, right);
		}
		return arr;
	}

	private static int partition(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int pivot = arr[left];
		int i = left + 1, j = right;
		while (i <= j) {
			while (i <= j && arr[i] <= pivot)
				i++;
			while (i <= j && arr[j] > pivot)
				j--;
			if (i < j) {
				arr = swap(arr, i, j);
				i++;
				j--;
			}
		}
		i--;
		arr[left] = arr[i];
		arr[i] = pivot;
		return i;
	}

	private static int[] swap(int[] arr, int left, int p) {
		// TODO Auto-generated method stub
		int temp = arr[left];
		arr[left] = arr[p];
		arr[p] = temp;
		return arr;
	}

}

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
public class MergeSort {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] arr = Utility.readNumbers();
		arr = mergeSort(arr, 0, arr.length - 1);
		Utility.printNumbers(arr);
	}

	private static int[] mergeSort(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, 0, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, right, mid);
		}
		return arr;
	}

	private static void merge(int[] arr, int left, int right, int mid) {
		// TODO Auto-generated method stub
		int[] b = new int[right - left + 1];
		int i = left, j = mid + 1;
		int p = 0;
		while (i <= mid && j <= right) {
			if (arr[i] > arr[j])
				b[p++] = arr[j++];
			else
				b[p++] = arr[i++];
		}
		while (i <= mid)
			b[p++] = arr[i++];
		while (j <= right)
			b[p++] = arr[j++];
		p = 0;
		for (int k = left; k <= right; k++) {
			arr[k] = b[p++];
		}
	}

}

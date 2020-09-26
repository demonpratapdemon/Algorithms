/**
 * 
 */
package com.java.problems.miscellaneous;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class KNearestNeighbours {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 9, 12, 13, 21, 26, 33, 43, 70, 73, 84, 100 };
		int X = 21;
		int k = 4;
		int[] kNeighbours = kNearestNeighbours(arr, X, k);
		StringBuilder sb = new StringBuilder();
		for (int i : kNeighbours)
			sb.append(i + " ");
		System.out.println(sb);
	}

	private static int[] kNearestNeighbours(int[] arr, int x, int k) {
		// TODO Auto-generated method stub
		int[] output = new int[k];
		int left, right;
		int pos = Arrays.binarySearch(arr, x);
		if (pos < 0) {
			pos = Math.abs(pos + 1);
			left = pos - 1;
			right = pos;
		} else {
			left = pos - 1;
			right = pos + 1;
		}
		if (right == arr.length) {
			return Arrays.copyOfRange(arr, arr.length - k, arr.length);
		}
		int p = 0;
		for (int i = 1; i <= k; i++) {
			if (left > -1 && Math.abs(x - arr[left]) < Math.abs(x - arr[right])) {
				output[p++] = arr[left];
				left--;
			} else if (right < arr.length) {
				output[p++] = arr[right];
				right++;
			}
		}
		Arrays.sort(output);
		return output;
	}

}

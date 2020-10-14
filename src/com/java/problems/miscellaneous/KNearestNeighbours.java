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
		int X = 3;
		int k = 4;
		kNearestNeighbours(arr, X, k);
	}

	private static void kNearestNeighbours(int[] arr, int x, int k) {
		// TODO Auto-generated method stub
		if (k > arr.length) {
			System.out.println("Enter proper value for k");
			return;
		}
		int left, right;
		int pos = Arrays.binarySearch(arr, x); // to find the location of the element to be searched
		StringBuilder sb = new StringBuilder();
		if (pos < 0) {
			pos = Math.abs(pos + 1); // if position is less than 0, then the element is not present in the array, but
										// if it had been there what index it should have occupied can be obtained
		}
		left = pos - 1; // keeping a left pointer from the position of the element
		right = pos; // keeping a right pointer to the position of the element
		if (right == arr.length) {
			left = pos - k - 1; // if right pointer points outside the array, then the element is not present and we can directly take the last 'k' elements of the array
		} else {
			for (int i = 1; i <= k; i++) {
				if (left > -1 && (right < arr.length && Math.abs(x - arr[left]) < Math.abs(x - arr[right]))) { // comparing left and right side with absolute value to get the nearest neighbour
					left--;
				} else if (right < arr.length) {
					right++;
				} else {
					left -= (k - i + 1); // this condition will be satisfied when the right pointer is pointing outside the array index and we need to get the nearest neighbours only from the left side
					break;
				}
			}
		}
		for (int i = left + 1; i <= right - 1; i++)
			sb.append(arr[i] + " "); // with the left and right pointer being obtained, we can fetch the k elements one by one in order.
		System.out.println(sb);
	}
}

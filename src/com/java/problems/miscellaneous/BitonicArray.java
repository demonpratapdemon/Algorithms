/**
 * 
 */
package com.java.problems.miscellaneous;

/**
 * @author PRATAP
 *
 */
public class BitonicArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 7, 19, 23, 56, 8, 3, 2, 1 };
		int pos = findBitonicPosition(arr);
		System.out.println(pos + 1);
	}

	private static int findBitonicPosition(int[] arr) {
		// TODO Auto-generated method stub
		int i = 0, j = arr.length - 1, mid, pos = 0;
		while (i <= j) {
			mid = (i + j) / 2;
			if (arr[mid] > arr[mid + 1] && arr[mid - 1] < arr[mid]) {
				pos = mid;
				break;
			} else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1])
				i = mid + 1;
			else if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
				j = mid - 1;
		}
		return pos;
	}

}

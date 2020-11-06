/**
 * 
 */
package com.java.problems.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.java.problems.heap.BinaryMinHeap;
import com.java.problems.util.Utility;

/**
 * @author PRATAP
 *
 */
public class HeapSort {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the numbers for sorting in space separated manner : ");
		String[] input = br.readLine().split("\\s+");
		ArrayList<Integer> heap = new ArrayList<Integer>();
		for (String s : input)
			heap.add(Integer.parseInt(s));
		BinaryMinHeap.buildHeap(heap);
		int[] arr = new int[heap.size()];
		int n = heap.size() - 1;
		for (int i = 0; i < heap.size(); i++) {
			arr[i] = BinaryMinHeap.deleteMin(heap, n--);
		}
		Utility.printNumbers(arr);
	}

}

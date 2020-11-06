/**
 * 
 */
package com.java.problems.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class Utility {

	public static int[] readNumbers() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the numbers separated by space");
		String[] numberList = br.readLine().split(" ");
		int[] arr = new int[numberList.length];
		for (int i = 0; i < numberList.length; i++) {
			arr[i] = Integer.parseInt(numberList[i]);
		}
		return arr;
	}

	public static void printNumbers(int[] arr) {
		System.out.print("The array is : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void printNumbers(ArrayList<Integer> heap) {
		// TODO Auto-generated method stub
		for (Integer i : heap)
			System.out.print(i + " ");
		System.out.println();
	}
}

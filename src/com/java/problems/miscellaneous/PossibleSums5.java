/**
 * 
 */
package com.java.problems.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author PRATAP
 *
 */
public class PossibleSums5 {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] input = br.readLine().split("\\s+");
			int p = 0;
			for (String in : input)
				arr[p++] = Integer.parseInt(in);
			int output = findDistinctSums(arr);
			System.out.println(output);
		}
	}

	private static int findDistinctSums(int[] arr) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int k : arr)
			sum += k;
		boolean[][] cache = new boolean[arr.length + 1][sum + 1];
		Set<Integer> set = new HashSet<Integer>();
		for (int row = 0; row <= arr.length; row++) {
			cache[row][0] = true;
		}
		set.add(0);
		for (int col = 1; col <= sum; col++) {
			cache[0][col] = false;
		}
		int exit = 0;
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
//				System.out.println(cache[i - 1][j]);
				cache[i][j] = cache[i - 1][j];
				if (j >= arr[i - 1]) {
//					System.out.println(cache[i - 1][j - arr[i - 1]]);
					cache[i][j] = cache[i][j] || cache[i - 1][j - arr[i - 1]];
				}
				if (cache[i][j])
					set.add(j);
				if (set.size() == sum + 1) {
					exit = 1;
					break;
				}
			}
			if (exit == 1)
				break;
		}
		return set.size();
	}

}

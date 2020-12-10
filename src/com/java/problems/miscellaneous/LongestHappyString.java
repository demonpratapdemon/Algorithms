/**
 * 
 */
package com.java.problems.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class LongestHappyString {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the no of a's, b's and c's : ");
		String[] input = br.readLine().split("\\s+");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		String output = solution(a, b, c);
		System.out.println(output);
	}

	public static String solution(int a, int b, int c) {
		String[][] arr = { { "a", String.valueOf(a) }, { "b", String.valueOf(b) }, { "c", String.valueOf(c) } };
		StringBuilder sb = new StringBuilder();
		char prev = 0;
		char prevPrev = 0;
		int maxIndex = -1;
		int currentFreq = 0, maxFreq = 0;
		while (true) {
			maxIndex = -1;
			currentFreq = maxFreq = 0;
			for (int i = 0; i < arr.length; i++) {
				currentFreq = Integer.parseInt(arr[i][1]);
				if (currentFreq > maxFreq) {
					if ((prev == prevPrev) && (prev == arr[i][0].charAt(0))) {
						continue;
					}
					maxFreq = currentFreq;
					maxIndex = i;
				}
			}
			if (maxIndex == -1)
				break;
			sb.append(arr[maxIndex][0]);
			prevPrev = prev;
			prev = arr[maxIndex][0].charAt(0);
			arr[maxIndex][1] = String.valueOf(Integer.parseInt(arr[maxIndex][1]) - 1);
		}
		return sb.toString();
	}

}

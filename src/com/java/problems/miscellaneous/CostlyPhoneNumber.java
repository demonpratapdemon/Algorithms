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
public class CostlyPhoneNumber {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int cost[] = new int[10];
		while (t-- > 0) {
			String[] costInput = br.readLine().split("\\s+");
			int p = 0;
			for (String digCost : costInput) {
				cost[p++] = Integer.parseInt(digCost);
			}
			int length = Integer.parseInt(br.readLine());
			String phone = br.readLine();
			boolean reduce = true;
			while (reduce) {
				reduce = false;
				for (int i = 0; i < cost.length; i++) {
					for (int j = 0; j < cost.length; j++) {
						int add = (i + j) % 10;
						int old = cost[add];
						cost[add] = Math.min(cost[add], cost[i] + cost[j]);
						if (old != cost[add])
							reduce = true;
					}
				}
			}
			int result = 0;
			for (int i = 0; i < length; i++) {
				int digit = Integer.parseInt(String.valueOf(phone.charAt(i)));
				result += cost[digit];
			}
			System.out.println(result);
		}
	}

}

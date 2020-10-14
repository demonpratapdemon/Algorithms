/**
 * 
 */
package com.java.problems.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author PRATAP
 *
 */
public class LongestCommonSubstring {

	static HashMap<Integer, LinkedList<Integer>> hashTable;
	static String commonSubstring = "";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter String 1 : ");
		String str1 = br.readLine();
		System.out.println("Enter String 2 : ");
		String str2 = br.readLine();
		binarySearch(str1, str2);
	}

	private static void binarySearch(String str1, String str2) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = Math.min(str1.length(), str2.length());
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (rollingHash(str1, str2, mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println("Length of the longest common substring = " + (left - 1));
		System.out.println("Longest common substring = " + commonSubstring);
	}

	private static boolean rollingHash(String str1, String str2, int m) {
		// TODO Auto-generated method stub
		boolean flag = false;
		hashTable = new HashMap<Integer, LinkedList<Integer>>();
		int p = 0, t = 0, b = 31; // p = for str2, t = for str1, b = base
		int power = 1;
		int q = (int) (1e9 + 9); // for modulus
		int i = 0;
		for (; i < m; i++) {
			t = (t * b + (str1.charAt(i) - 'a' + 1)) % q;
			p = (p * b + (str2.charAt(i) - 'a' + 1)) % q;
			power = (power * b) % q; // to keep the power for subtraction later
		}
		if (!hashTable.containsKey(t)) { // adding the first hash value to the has table
			LinkedList<Integer> ll = new LinkedList<Integer>();
			ll.addFirst(i - m);
			hashTable.put(t, ll);
		}
		int j = i;
		for (; i < str1.length(); i++) {
			t = (t * b + (str1.charAt(i) - 'a' + 1) - (str1.charAt(i - m) - 'a' + 1) * power) % q;
			if (!hashTable.containsKey(t)) { // adding the first hash value to the has table
				LinkedList<Integer> ll = new LinkedList<Integer>();
				ll.addFirst(i - m + 1);
				hashTable.put(t, ll);
			} else {
				hashTable.get(t).addFirst(i - m);
			}
		}
		// all substrings of str1 which are of length m has been hashed in the hash
		// table.
		while (j < str2.length() && !flag) {
			if (hashTable.containsKey(p)) {
				LinkedList<Integer> matchedHash = hashTable.get(p);
				getCommonSubString(str1, str2, matchedHash, m, j - m);
				flag = true;
				break;
			}
			p = (p * b + (str2.charAt(j) - 'a' + 1) - (str2.charAt(j - m) - 'a' + 1) * power) % q;
			j++;
		}
		if (hashTable.containsKey(p)) {
			LinkedList<Integer> matchedHash = hashTable.get(p);
			getCommonSubString(str1, str2, matchedHash, m, j - m);
			flag = true;
		}
		hashTable.clear();
		return flag;
	}

	private static void getCommonSubString(String str1, String str2, LinkedList<Integer> matchedHash, int m, int j) {
		// TODO Auto-generated method stub
		String s1, s2;
		if (matchedHash.size() == 1) {
			commonSubstring = str1.substring(matchedHash.getFirst(), matchedHash.getFirst() + m);
		} else {
			while (!matchedHash.isEmpty()) {
				s1 = str1.substring(matchedHash.getFirst(), matchedHash.getFirst() + m);
				s2 = str2.substring(j, j + m);
				if (s1.equalsIgnoreCase(s2)) {
					commonSubstring = s1;
					break;
				}
				matchedHash.removeFirst();
			}
		}
	}

};
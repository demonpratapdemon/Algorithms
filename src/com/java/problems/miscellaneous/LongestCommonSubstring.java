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

	// Creating hash-table to keep track of index and hash values
	static HashMap<Integer, LinkedList<Integer>> hashTable = new HashMap<Integer, LinkedList<Integer>>();
	// For keeping track of the longest common substring
	static String commonSubstring = "";

	/**
	 * @param args
	 * @throws IOException
	 * 
	 * We are using Rolling Hashing and Binary Search for finding Longest Common Substring
	 * Time Complexity = O(nlogn)
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

	/*
	 * Time Complexity = O(logn) // where n is the length of the smallest string
	 */
	private static void binarySearch(String str1, String str2) {
		// TODO Auto-generated method stub
		// Let str1 be of length n and str2 be of length m.
		// We will apply binary search here.
		// If there is a common substring of length x between str1 and str2, then there
		// definitely exist another substring which is of length less than x.
		// But there may not exist a substring whose length is greater than x.
		int left = 0;
		int right = Math.min(str1.length(), str2.length());
		while (left <= right) {
			int mid = (right + left) / 2;
			if (rollingHash(str1, str2, mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println("Length of the longest common substring = " + (left - 1));
		System.out.println("Longest common substring = " + commonSubstring);
	}

	/*
	 * Time Complexity(in Average Case) = Theta(n)
	 */
	private static boolean rollingHash(String str1, String str2, int m) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int p = 0, t = 0, b = 31; // p = hash value for str2, t = hash value for str1, b = considering base as 31
		int power = 1; // we need this power for subtraction
		int q = (int) (1e9 + 9); // for modulus
		int i = 0;
		for (; i < m; i++) {
			t = (t * b + (str1.charAt(i) - 'a' + 1)) % q;
			p = (p * b + (str2.charAt(i) - 'a' + 1)) % q;
			power = (power * b) % q; // scaling the power for subtraction later
		}
		if (!hashTable.containsKey(t)) { // adding the first hash value to the has table
			LinkedList<Integer> ll = new LinkedList<Integer>();
			ll.addFirst(i - m); // adding the index of the substring to the linked list
			hashTable.put(t, ll); // storing the index of the substring
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
		// All substrings of str1 which are of length m has been hashed in the hash
		// table.
		// Now we need to look for all the substrings of length m in str2 and find the
		// hash value in the hash-table
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
		hashTable.clear(); // clearing the hash-table for computing the next iteration with different
							// length
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

}
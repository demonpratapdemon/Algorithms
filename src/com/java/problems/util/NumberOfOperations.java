/**
 * 
 */
package com.java.problems.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author PRATAP
 *
 */
public class NumberOfOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10000, s = 2;
//		Date date = new Date();
//		System.out.println(TimeUnit.SECONDS.toDays(seconds));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		for (int i = 0; i < n; ++i) {
			for (int k = 0; k < n; ++k) {
				for (int j = 0; j < n / 10; ++j) {
					s = 2 * s + 1;
				}
			}
		}
		LocalDateTime now1 = LocalDateTime.now();
		System.out.println(dtf.format(now1));
		System.out.println(s);

	}

}

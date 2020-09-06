/**
 * 
 */
package com.java.problems.util;

/**
 * @author PRATAP
 *
 */
public class CheckSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,k,n;
		int[] a=new int[100000000]; // 10^8 max size allowed
		n=1000;
		for (i=0;i<n;++i)
			for (j=0;j<n;++j)
				for (k=0;k<n;++k)
					a[i]=2*i*j*k+1;
	}

}

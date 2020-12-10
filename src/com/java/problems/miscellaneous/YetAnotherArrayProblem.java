/**
 * 
 */
package com.java.problems.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class YetAnotherArrayProblem {

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
			ArrayList<Integer> heap = new ArrayList<Integer>();
			for (String in : input) {
				arr[p++] = Integer.parseInt(in);
				heap.add(arr[p - 1]);
			}
			String output = checkOrder(arr, heap);
			System.out.println(output);
		}
	}

	private static String checkOrder(int[] arr, ArrayList<Integer> heap) {
		// TODO Auto-generated method stub
		buildMinHeap(heap);
		int n = heap.size() - 1;
		int front = 0, rear = arr.length - 1;
		int min;
		while (front <= rear) {
			min = heap.get(0);
			if (min == arr[front]) {
				deleteMin(heap, n);
				n--;
				front++;
			} else if (min == arr[rear]) {
				deleteMin(heap, n);
				n--;
				rear--;
			} else {
				break;
			}
		}
		if (front < rear)
			return "NO";
		return "YES";
	}

	private static void deleteMin(ArrayList<Integer> heap, int n) {
		// TODO Auto-generated method stub
		swap(heap, 0, n);
		topDownHeapify(heap, 0, n - 1);
	}

	private static void topDownHeapify(ArrayList<Integer> heap, int i, int n) {
		// TODO Auto-generated method stub
		if (n < 0)
			return;
		int child;
		while (2 * i + 2 <= n) {
			if (heap.get(2 * i + 1) > heap.get(2 * i + 2))
				child = 2 * i + 2;
			else
				child = 2 * i + 1;
			if (heap.get(i) > heap.get(child)) {
				swap(heap, i, child);
				i = child;
			} else
				i = n;
		}
		child = 2 * i + 1; // checking with single child
		if (child <= n && heap.get(i) > heap.get(child)) {
			swap(heap, i, child);
		}
	}

	private static void buildMinHeap(ArrayList<Integer> heap) {
		// TODO Auto-generated method stub
		if (heap.size() == 0)
			return;
		for (int i = 1; i < heap.size(); i++) {
			bottomUpHeapify(heap, i);
		}
	}

	private static void bottomUpHeapify(ArrayList<Integer> heap, int i) {
		// TODO Auto-generated method stub
		int p = (i - 1) / 2;
		while (p >= 0) {
			if (heap.get(p) > heap.get(i)) {
				swap(heap, p, i);
				i = p;
				p = (i - 1) / 2;
			} else {
				break;
			}
		}
	}

	private static void swap(ArrayList<Integer> heap, int p, int i) {
		// TODO Auto-generated method stub
		int temp = heap.get(p);
		heap.set(p, heap.get(i));
		heap.set(i, temp);
	}

}

/**
 * 
 */
package com.java.problems.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.java.problems.util.Utility;

/**
 * @author PRATAP
 *
 */
public class BinaryMinHeap {

	public static int n = 0;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the elements to create Min Heap");
		String[] input = br.readLine().split("\\s+");
		ArrayList<Integer> heap = new ArrayList<Integer>();
		for (String s : input)
			heap.add(Integer.parseInt(s));
		buildHeap(heap);
		n = heap.size() - 1;
		while (true) {
			System.out.println("Enter 1 to insert element into Binary Min Heap");
			System.out.println("Enter 2 to display Min Heap");
			System.out.println("Enter 3 to Delete Min");
			System.out.println("Enter 4 to Decrease Key");
			System.out.println("Enter 5 to increase Key");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1: {
				System.out.println("Enter the element to be inserted : ");
				heap.add(++n, Integer.parseInt(br.readLine()));
				bottomUpHeapify(heap, n);
				break;
			}
			case 2:
				Utility.printNumbers(heap);
				break;
			case 3:
				int deleted = deleteMin(heap, n);
				n--;
				System.out.println("Min element is : " + deleted);
				break;
			case 4:
				System.out.println("Enter the index of the element whose key is to be decrease");
				int index = Integer.parseInt(br.readLine()) - 1;
				System.out.println("Enter the new value");
				int newVal = Integer.parseInt(br.readLine());
				heap.set(index, newVal);
				bottomUpHeapify(heap, index);
				break;
			case 5:
				System.out.println("Enter the index of the element whose key is to be decrease");
				index = Integer.parseInt(br.readLine()) - 1;
				System.out.println("Enter the new value");
				newVal = Integer.parseInt(br.readLine());
				heap.set(index, newVal);
				topDownHeapify(heap, index, n);
				break;
			default:
				System.exit(0);
			}
		}
	}

	public static int deleteMin(ArrayList<Integer> heap, int n2) {
		// TODO Auto-generated method stub
		swap(heap, 0, n2);
		topDownHeapify(heap, 0, n2 - 1);
		if (n2 < 0)
			return Integer.MIN_VALUE;
		return heap.get(n2);
	}

	public static void buildHeap(ArrayList<Integer> heap) {
		// TODO Auto-generated method stub
		if (heap.size() < 1)
			return;
		for (int i = 1; i < heap.size(); i++) {
			bottomUpHeapify(heap, i);
		}
	}

	private static void bottomUpHeapify(ArrayList<Integer> heap, int i) {
		// TODO Auto-generated method stub
		int p = (i - 1) / 2;
		while (p > -1) {
			if (heap.get(p) > heap.get(i)) {
				swap(heap, i, p);
				i = p;
				p = (i - 1) / 2;
			} else {
				p = -1;
			}
		}
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
		child = 2 * i + 1;
		if (child <= n && heap.get(i) > heap.get(child)) {
			swap(heap, i, child);
		}
	}

	private static void swap(ArrayList<Integer> heap, int i, int p) {
		// TODO Auto-generated method stub
		if (p < 0)
			return;
		int temp = heap.get(i);
		heap.set(i, heap.get(p));
		heap.set(p, temp);
	}

}

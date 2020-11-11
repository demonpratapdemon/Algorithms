/**
 * 
 */
package com.java.problems.graphs.shortestpath;

import java.util.ArrayList;

import com.java.problems.entity.GraphNodePriority;
import com.java.problems.entity.GraphNodes;

/**
 * @author PRATAP
 *
 */
public class Dijkstra {

	public static StringBuilder shortestPathUsingDikstra(ArrayList<ArrayList<GraphNodes>> list, int source) {
		// TODO Auto-generated method stub
		if (list.size() <= 0)
			return null;
		ArrayList<GraphNodePriority> heap = new ArrayList<GraphNodePriority>();
		int n = list.size();
		int[] D = new int[n];// to keep track of the scores
		int[] A = new int[n]; // to keep track of the position of the nodes in the heap
		int k = n - 1; // to keep track for min heap
		int[] phi = new int[n]; // this is to keep track of which node discovered the current node
		boolean[] v = new boolean[n]; // this is to keep track whether the node has been visited or not
		for (int i = 0; i < n; i++) { // initialising phase
			phi[i] = -2;
			GraphNodePriority node = new GraphNodePriority(i, Integer.MAX_VALUE);
			D[i] = Integer.MAX_VALUE;
			heap.add(node);
			A[i] = i;
		}
		// initialising the source
		phi[source] = -1;
		heap.set(source, new GraphNodePriority(source, 0)); // updating the priority of the source as 0(decrease key)
		D[source] = 0;
		bottomUpHeapify(heap, A, source);
		GraphNodePriority u;
		StringBuilder shortestPath = new StringBuilder();
		while (k >= 0) {
			u = deleteMin(heap, A, k); // the node which is deleted
			k--; // to keep track of which node to swap with in heap
			v[u.i] = true;
			shortestPath.append(u.i + " ");
			ArrayList<GraphNodes> edges = list.get(u.i); // for all the edges of u
			for (GraphNodes edge : edges) { // for every edges of the node u, repeat this
				if (v[edge.j] == false && D[edge.j] > D[u.i] + edge.weight) {
					heap.set(A[edge.j], new GraphNodePriority(edge.j, D[u.i] + edge.weight));
					D[edge.j] = D[u.i] + edge.weight;
					bottomUpHeapify(heap, A, A[edge.j]);
					phi[edge.j] = u.i;
				}
			}
		}
		return shortestPath;
	}

	public static GraphNodePriority deleteMin(ArrayList<GraphNodePriority> heap, int[] a, int j) {
		// TODO Auto-generated method stub
		GraphNodePriority node = heap.get(0);
		swap(heap, a, 0, j);
		topDownHeapify(heap, a, 0, j - 1);
		if (j < 0)
			return null;
		return node;
	}

	private static void topDownHeapify(ArrayList<GraphNodePriority> heap, int[] a, int i, int n) {
		// TODO Auto-generated method stub
		if (n < 0)
			return;
		int child;
		while (2 * i + 2 <= n) {
			if (heap.get(2 * i + 1).priority > heap.get(2 * i + 2).priority)
				child = 2 * i + 2;
			else
				child = 2 * i + 1;
			if (heap.get(i).priority > heap.get(child).priority) {
				swap(heap, a, i, child);
				i = child;
			} else
				i = n;
		}
		child = 2 * i + 1;
		if (child <= n && heap.get(i).priority > heap.get(child).priority) {
			swap(heap, a, i, child);
		}
	}

	private static void bottomUpHeapify(ArrayList<GraphNodePriority> heap, int[] a, int i) {
		// TODO Auto-generated method stub
		int p = (i - 1) / 2;
		while (p > -1) {
			if (heap.get(p).priority > heap.get(i).priority) {
				swap(heap, a, i, p);
				i = p;
				p = (i - 1) / 2;
			} else {
				p = -1;
			}
		}
	}

	private static void swap(ArrayList<GraphNodePriority> heap, int[] a, int i, int p) {
		// TODO Auto-generated method stub
		if (p < 0)
			return;
		if (a != null) {
			int temp1 = a[heap.get(i).i];
			a[heap.get(i).i] = a[heap.get(p).i];
			a[heap.get(p).i] = temp1;
		}
		GraphNodePriority temp = heap.get(i);
		heap.set(i, heap.get(p));
		heap.set(p, temp);
		
	}

}

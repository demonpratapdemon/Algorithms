/**
 * 
 */
package com.java.problems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.java.problems.entity.GraphNodes;

/**
 * @author PRATAP
 *
 */
public class BFS {

	public static void bfsTraversal(ArrayList<ArrayList<GraphNodes>> list, int source) {
		// TODO Auto-generated method stub
		if (list.size() <= 0)
			return;
		Queue<Integer> queue = new LinkedList<Integer>();
		int n = list.size(); // no of nodes
		boolean[] v = new boolean[n]; // to keep track of visited nodes
		int[] phi = new int[n]; // to keep track which node discovered the current node
		for (int i = 0; i < n; i++) {
			phi[i] = -2;
			v[i] = false;
		}
		queue.add(source);
		phi[source] = -1; // source is not discovered by any node and hence -1
		v[source] = true; // source is visited at the beginning
		int u;
		StringBuilder bfsTree = new StringBuilder("");
		while (!queue.isEmpty()) {
			u = queue.poll(); // dequeue one node at a time
			bfsTree.append(u + " ");
			ArrayList<GraphNodes> edges = list.get(u);
			for (GraphNodes edge : edges) { // for every edges of the node
				if (v[edge.j] == false) {
					queue.add(edge.j);
					phi[edge.j] = u;
					v[edge.j] = true;
				}
			}
		}
		System.out.println(bfsTree);
	}
}

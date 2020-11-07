/**
 * 
 */
package com.java.problems.graphs;

import java.util.ArrayList;
import java.util.Stack;

import com.java.problems.entity.GraphNodes;

/**
 * @author PRATAP
 *
 */
public class DFS {

	public static StringBuilder dfsTraversal(ArrayList<ArrayList<GraphNodes>> list, int source) {
		// TODO Auto-generated method stub
		if (list.size() <= 0)
			return null;
		Stack<Integer> stack = new Stack<Integer>();
		int n = list.size(); // no of nodes
		boolean[] v = new boolean[n]; // to keep track of visited nodes
		int[] phi = new int[n]; // to keep track which node discovered the current node
		for (int i = 0; i < n; i++) {
			phi[i] = -2;
			v[i] = false;
		}
		stack.push(source);
		int u;
		StringBuilder dfsTree = new StringBuilder();
		while (!stack.isEmpty()) {
			u = stack.pop();
			if (v[u] == false) {
				dfsTree.append(u + " ");
				v[u] = true;
				ArrayList<GraphNodes> edges = list.get(u);
				for (GraphNodes edge : edges) { // for every edges of the node
					if (v[edge.j] == false) {
						stack.push(edge.j);
						phi[edge.j] = u;
					}
				}
			}
		}
		return dfsTree;
	}

}

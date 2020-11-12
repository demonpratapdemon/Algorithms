/**
 * 
 */
package com.java.problems.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author PRATAP
 *
 */
class Node {
	int i, j;

	Node(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class ColoringTrees {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nodes_bt = br.readLine().split("\\s+");
		boolean[] bts = new boolean[Integer.parseInt(nodes_bt[0]) + 1];
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i <= Integer.parseInt(nodes_bt[0]); i++) {
			graph.add(new ArrayList<Node>());
		}
		for (int i = 0; i < Integer.parseInt(nodes_bt[0]) - 1; i++) { // taking input of the edges
			String[] u_v = br.readLine().split("\\s+");
			int u = Integer.parseInt(u_v[0]);
			int v = Integer.parseInt(u_v[1]);
			graph.get(u).add(new Node(u, v));
			graph.get(v).add(new Node(v, u));
		}
		String[] input_bts = br.readLine().split("\\s+");
		for (String s : input_bts) {
			bts[Integer.parseInt(s)] = true;
		}
		boolean[] crowdedCitites = new boolean[Integer.parseInt(nodes_bt[0]) + 1];
		boolean[] visited = new boolean[graph.size()];
		int result = 0;
		int src = -1;
		for (int i = 0; i <= Integer.parseInt(nodes_bt[0]); i++) {
			if (bts[i] == true) {
				crowdedCitites[i] = true;
				if (src == -1)
					src = i;
			}
		}
		dfs(graph, bts, crowdedCitites, visited, src);
		for (int i = 0; i < crowdedCitites.length; i++) {
			if (crowdedCitites[i])
				result++;
		}
		System.out.println(result);
	}

	private static boolean dfs(ArrayList<ArrayList<Node>> graph, boolean[] bts, boolean[] crowdedCitites, boolean[] visited,
			int source) {
		// TODO Auto-generated method stub
		visited[source] = true;
		ArrayList<Node> edges = graph.get(source);
		for (Node edge : edges) {
			if (!visited[edge.j]) {
				if(dfs(graph, bts, crowdedCitites, visited, edge.j)) // based on the crowded city status of
																				// the next node
					crowdedCitites[edge.i] = true;
			}
		}
		if (crowdedCitites[source])
			return true;
		return false;
	}

}
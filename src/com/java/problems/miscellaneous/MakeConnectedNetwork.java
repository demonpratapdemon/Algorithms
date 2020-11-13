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
public class MakeConnectedNetwork {
	static class Node {
		int i, j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the no of computers :");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter the no of connections : ");
		int m = Integer.parseInt(br.readLine());
		int[][] connections = new int[m][2];
		System.out.println("Enter the connections : ");
		String[] input;
		for (int i = 0; i < m; i++) {
			input = br.readLine().split("\\s+");
			connections[i][0] = Integer.parseInt(input[0]);
			connections[i][1] = Integer.parseInt(input[1]);
		}
		int steps = makeConnected(n, connections);
		System.out.println(steps);
	}

	private static int makeConnected(int n, int[][] connections) {
		// TODO Auto-generated method stub
		// create a graph with adjacency list representation of the connections
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		int totalEdges = 0;
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Node>());
		}
		for (int i = 0; i < connections.length; i++) {
			int u = connections[i][0];
			int v = connections[i][1];
			graph.get(u).add(new Node(u, v));
			graph.get(v).add(new Node(v, u));
			totalEdges++;
		}

		// need to find the number of components by applying DFS
		int components = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				components++;
				dfs(graph, visited, i);
			}
		}
//		System.out.println("No of components : " + components);

		int redundantEdges = totalEdges - ((n - 1) - (components - 1));
		if (redundantEdges >= components - 1)
			return components - 1;
		return -1;
	}

	private static void dfs(ArrayList<ArrayList<Node>> graph, boolean[] visited, int source) {
		// TODO Auto-generated method stub
		visited[source] = true;
		ArrayList<Node> edgeList = graph.get(source);
		for (Node edge : edgeList) {
			if (!visited[edge.j])
				dfs(graph, visited, edge.j);
		}
	}

}

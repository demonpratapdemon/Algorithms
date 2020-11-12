/**
 * 
 */
package com.java.problems.miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author PRATAP
 *
 */

public class CourseScheduleII {
	static class Node {
		int i, j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int count = 1, c = 1; // count is to keep track of discovery and finish time, c is to keep track of
									// the positions in the array 'l'

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the no of courses :");
		int n = Integer.parseInt(br.readLine());
		String[] inputs;
		System.out.println("Enter the number of prerequisites : ");
		int k = Integer.parseInt(br.readLine());
		int[][] prerequisites = new int[k][2];
		System.out.println("Please enter the prerequisites for each course : ");
		for (int i = 0; i < k; i++) {
			inputs = br.readLine().split("\\s+");
			prerequisites[i][0] = Integer.parseInt(inputs[0]);
			prerequisites[i][1] = Integer.parseInt(inputs[1]);
		}
		int[] order = findOrder(n, prerequisites);
		for (int i = 0; i < order.length; i++) {
			System.out.print(order[i] + " ");
		}
	}

	private static int[] findOrder(int numCourses, int[][] prerequisites) {
		// TODO Auto-generated method stub
		// creating a graph out of the prerequisites
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<Node>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			int u = prerequisites[i][1];
			int v = prerequisites[i][0];
			graph.get(u).add(new Node(u, v));
		}
		// detect cycle in graph - otherwise we can't apply Topological Sorting on the
		// Graph
		if (detectCycle(graph)) {
			return new int[0];
		}
		int f[] = topologicalSort(graph);
		return f;
	}

	private static int[] topologicalSort(ArrayList<ArrayList<Node>> graph) {
		// TODO Auto-generated method stub
		int[] d = new int[graph.size()];
		int[] f = new int[graph.size()];
		boolean[] visited = new boolean[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			d[i] = 0;
			f[i] = 0;
		}
		int[] l = new int[graph.size()];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < graph.size(); i++) {
			if (!visited[i]) {
				dfsTopo(graph, i, l, visited, d, f, stack);
			}
		}
		int p = 0;
		while(!stack.isEmpty()) {
			l[p++] = stack.pop();
		}
		return l;
	}

	private static void dfsTopo(ArrayList<ArrayList<Node>> graph, int source, int[] l, boolean[] visited, int[] d,
			int[] f, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		visited[source] = true;
		ArrayList<Node> edgeList = graph.get(source);
		d[source] = count++;
		for (Node edge : edgeList) {
			if (!visited[edge.j]) {
				dfsTopo(graph, edge.j, l, visited, d, f, stack);
			}
		}
		f[source] = count++;
//		if (c <= graph.size())
//			l[graph.size() - c] = source;
		stack.push(source);
		c++;
	}

	private static boolean detectCycle(ArrayList<ArrayList<Node>> graph) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[graph.size()];
		boolean cycleFlag = false;
		for (int i = 0; i < graph.size(); i++) {
			int check = dfs(graph, visited, i);
			if (check == 1) {
				cycleFlag = true;
				break;
			}
		}
		return cycleFlag;
	}

	private static int dfs(ArrayList<ArrayList<Node>> graph, boolean[] visited, int source) {
		// TODO Auto-generated method stub
		if (visited[source])
			return 1;
		visited[source] = true;
		ArrayList<Node> edgeList = graph.get(source);
		for (Node edge : edgeList) {
			int check = dfs(graph, visited, edge.j);
			if (check == 1)
				return 1;
		}
		visited[source] = false;
		return 0;
	}

}

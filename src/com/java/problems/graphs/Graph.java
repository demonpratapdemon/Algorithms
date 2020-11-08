/**
 * 
 */
package com.java.problems.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.java.problems.entity.GraphNodes;
import com.java.problems.graphs.shortestpath.Dijkstra;

/**
 * @author PRATAP
 *
 */
public class Graph {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the no of nodes : ");
		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<GraphNodes>> list = new ArrayList<ArrayList<GraphNodes>>(n);
		for (int i = 0; i < n; i++)
			list.add(new ArrayList<GraphNodes>()); // creating the nodes in the ArrayList
		System.out.println("Enter the number of edges : ");
		int m = Integer.parseInt(br.readLine());
		System.out.println("Enter the edges in format : source destination weight");
		String[] input;
		for (int i = 0; i < m; i++) {
			input = br.readLine().split("\\s+");
			GraphNodes node = new GraphNodes();
			node.i = Integer.parseInt(input[0]);
			node.j = Integer.parseInt(input[1]);
			node.weight = Integer.parseInt(input[2]);
			list.get(node.i).add(node); // getting the ArrayList of that node and then adding the edges from that node
		}
		while (true) {
			System.out.println("Enter 1 for BFS Traversal");
			System.out.println("Enter 2 for DFS Traversal");
			System.out.println("Enter 3 for finding Shortest Path using Dijkstra's Algorithm");
			System.out.print("Enter your choice : ");
			int choice = Integer.parseInt(br.readLine());
			System.out.println();
			switch (choice) {
			case 1:
				System.out.println("Enter the source vertex : ");
				int source = Integer.parseInt(br.readLine());
				StringBuilder bfsTree = BFS.bfsTraversal(list, source);
				if (bfsTree != null)
					System.out.println("BFS Traversal is : " + bfsTree);
				break;
			case 2:
				System.out.println("Enter the source vertex : ");
				source = Integer.parseInt(br.readLine());
				StringBuilder dfsTree = DFS.dfsTraversal(list, source);
				if (dfsTree != null)
					System.out.println("BFS Traversal is : " + dfsTree);
				break;
			case 3:
				System.out.println("Enter the source vertex : ");
				source = Integer.parseInt(br.readLine());
				StringBuilder shortestPath = Dijkstra.shortestPathUsingDikstra(list, source);
				System.out.println("The shortest path is : " + shortestPath);
				break;
			default:
				System.exit(0);
			}
		}
	}

}

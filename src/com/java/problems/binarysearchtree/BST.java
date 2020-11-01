/**
 * 
 */
package com.java.problems.binarysearchtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.java.problems.entity.BSTNode;

/**
 * @author PRATAP
 *
 */
public class BST {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the nodes of the BST : ");
		String[] input = br.readLine().split("\\s+");
		int[] arr = new int[input.length];
		int k = 0;
		for (String s : input)
			arr[k++] = Integer.parseInt(s);
		Arrays.sort(arr);
		BSTNode root = buildBST(arr, 0, k - 1);
		System.out.println("Enter the nodes A and B to search max and min :");
		String[] nodes = br.readLine().split("\\s+");
		int a = Integer.parseInt(nodes[0]);
		int b = Integer.parseInt(nodes[1]);
		BSTNode lca = findLCA(root, a, b); // this is the node through which the unique path exists between the 2 nodes
		if (lca != null) {
			int max = findMax(lca, b); // maximum exists on the RST of LCA(inclusive)[since b >= a]
			System.out.println("Maximum = " + max);
			int min = findMin(lca, a); // minimum exists on the LST of LCA(inclusive)[since a <= b]
			System.out.println("Minimum = " + min);
		} else {
			System.out.println("No path exist between the given nodes or enter correct order of nodes");
		}
	}

	private static int findMin(BSTNode lca, int a) {
		// TODO Auto-generated method stub
		int min = lca.key;
		// Comparing all the node values from lca to the node containing value 'a'
		while (lca != null && lca.key != a) {
			if (lca.key > a) {
				min = Math.min(lca.key, min);
				lca = lca.left;
			} else {
				min = Math.min(lca.key, min);
				lca = lca.right;
			}
		}
		return Math.min(min, a);// comparing with the node element with which we are searching the path
	}

	private static int findMax(BSTNode lca, int a) {
		// TODO Auto-generated method stub
		int max = lca.key;
		// Comparing all the node values from lca to the node containing value 'a'
		while (lca != null && lca.key != a) {
			if (lca.key > a) {
				max = Math.max(lca.key, max);
				lca = lca.left;
			} else {
				max = Math.max(lca.key, max);
				lca = lca.right;
			}
		}
		return Math.max(max, a);// comparing with the node element with which we are searching the path
	}

	private static BSTNode findLCA(BSTNode root, int a, int b) {
		// TODO Auto-generated method stub
		if (root != null && a > b) // Not a valid range condition since a is greater than b
			return null;
		if (root != null && root.key > b)
			return findLCA(root.left, a, b);
		if (root != null && root.key < a)
			return findLCA(root.right, a, b);
		return root;

	}

	private static BSTNode buildBST(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		// The array is already sorted
		BSTNode node = null;
		if (left <= right) {
			int mid = (left + right) / 2;
			node = new BSTNode(arr[mid]);
			node.left = buildBST(arr, left, mid - 1);
			node.right = buildBST(arr, mid + 1, right);
			if (node.right != null)
				node.right.parent = node;
			if (node.left != null)
				node.left.parent = node;
		}
		return node;
	}

}

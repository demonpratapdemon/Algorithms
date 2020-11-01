/**
 * 
 */
package com.java.problems.entity;

/**
 * @author PRATAP
 *
 */
public class BSTNode {

	public int key;
	public BSTNode left;
	public BSTNode right;
	public BSTNode parent;

	public BSTNode(int key) {
		super();
		this.key = key;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

}

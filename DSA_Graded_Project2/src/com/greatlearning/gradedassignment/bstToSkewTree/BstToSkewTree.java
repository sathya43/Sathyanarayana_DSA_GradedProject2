package com.greatlearning.gradedassignment.bstToSkewTree;

import com.greatlearning.gradedassignment.bstToSkewTree.Bst.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BstToSkewTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = null;	
		int[] arr = {40,60,30,20,10,50,70,1,2};
		
		
		Bst bst = new Bst();
		
		// Create a binary search tree with the given input values of the array.
		for(int i = 0; i<arr.length;i++) {
			if( root == null) {
				root = bst.insert(root, arr[i]);
			}else {
				bst.insertNode_iterative(root,arr[i]);
			}
		}
		
		System.out.println("The post order traversal of given binary search tree");
		bst.printPostorder(root);
		
		/*
		 * Solution approach:
		 * 
		 * 1. The inorder traversal of the given binary search tree will give the ascending/increasing order of nodes required for the right skewed tree
		 * 2. While doing the inorder traversal we push the node into the queue.
		 * 3. All the nodes are pushed into the queue while doing the inorder traversal
		 * 
		 * Now the queue has elements in the increasing order of Nodes.
		 * We traverse the entire queue, taking one node at a time and updating it's left,right nodes such that it forms the right skewed tree. 
		 *
		 * For verification we can print the Post order traversal before and after.
		 * For the right skewed tree the post order traversal should provide values in descending order
		 * 
		 *  Time complexity: O(n)
		 *  Space complexity: O(n)
		 */
		Queue<Node> queue = new LinkedList<>();
		
		bst.inorder(root,queue);
		

		Node newRoot = queue.poll();
		Node curr_node = newRoot;

		while(queue.size() > 0) {
			Node node = queue.peek();
			curr_node.left = null;
			curr_node.right = node;
			curr_node = queue.poll();
		}
		// Ensure to set the pointers of last node of skewed tree to null
		curr_node.left = null;
		curr_node.right = null;

		
	    System.out.println("\nThe post order traversal of right skewed tree");
		bst.printPostorder(newRoot);	


	}

}

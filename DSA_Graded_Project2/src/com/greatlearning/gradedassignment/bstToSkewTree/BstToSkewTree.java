package com.greatlearning.gradedassignment.bstToSkewTree;

import com.greatlearning.gradedassignment.bstToSkewTree.Bst.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BstToSkewTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = null;	
		int[] arr = {40,20,60,10,30,50,70};
		
		
		Bst bst = new Bst();
		
		for(int i = 0; i<arr.length;i++) {
			if( root == null) {
				root = bst.insert(root, arr[i]);
			}else {
				bst.insertNode_iterative(root,arr[i]);
			}
		}
		
		
		Queue<Node> queue = new LinkedList<>();
		
		bst.inorder(root,queue);
		
		Node newRoot = queue.poll();
		newRoot.right = queue.peek();
		Node r = newRoot;

		while(queue.size() > 0) {
			Node node = queue.peek();
			r.left = null;
			r.right = node;
			r = queue.poll();
		}
		
		
		bst.printPostorder(newRoot);	
		
		
	

	}

}

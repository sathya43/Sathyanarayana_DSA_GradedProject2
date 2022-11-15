package com.greatlearning.gradedassignment.bstToSkewTree;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

import com.greatlearning.gradedassignment.bstToSkewTree.Bst.Node;

public class Bst {
	
	
  static class Node{
	  int data;
	  Node left,right;
  }
  
  public Node newNode(int x) {
	  Node newNode = new Node();
	  newNode.data =  x;
	  newNode.left = null;
	  newNode.right = null;
	  return newNode;
  }
 
	// Insert node into bst. Iterative method.
	public Node insertNode_iterative(Node root,int key) {
	   
		Node newNode = this.newNode(key);
        Node x = root;
        Node currParent = null;
        
        while( x != null) {
        	currParent = x;
        	if(key < x.data) {
        		x = x.left;
        	}else if( key > x.data) {
        		x = x.right;
        	}else {
        		System.out.println("Key is already present");
        		return x;
        	}
       }
        
       if( currParent == null) {
    	   return newNode;
       }else if( currParent.data > key) {
    	   currParent.left = newNode;
       }else if( currParent.data < key) {
    	   currParent.right = newNode;
       }
		
		return newNode;
   }
	
	// Insert node into bst. Recursive method.
	public Node insert(Node root,int key) {
		if(root == null) {
			Node newNode = this.newNode(key);
			return newNode;
		}
		if( key < root.data) {
			root.left = insert(root.left,key);
		}
		else{
			root.right = insert(root.right,key);
		}
		return root;
	}
	
	
	public boolean search(Node root,int key) {
		Node node;
		node = searchRecursive(root,key);
		if( node != null) {
			return true;
		}else {
			return false;
		}
	}
	
	// Search for a given node key in BST
	public Node searchRecursive(Node root, int key) {
		if( root == null || root.data == key) {
			return root;
		}else if( key < root.data) {
			return searchRecursive(root.left,key);
		}
	    return searchRecursive(root.right,key);
	}
	
	
	
	public void inorder(Node root,Queue<Node> queue) {
		if(root == null) {
			return;
		}
		inorder(root.left,queue);
	    queue.add(root);
		inorder(root.right,queue);
	}
	
	public void printInorder(Node root) {
		if(root == null) {
			return;
		}
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
	}
	
	
	public void printPostorder(Node root) {
		if(root == null) {
			return;
		}
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");
	}
	
  
  
	
	
	
}

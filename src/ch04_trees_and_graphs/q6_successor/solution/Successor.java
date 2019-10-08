package ch04_trees_and_graphs.q6_successor.solution;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class Successor {

	public static void main(String[] args) {
		BinaryTree<Integer> t = BinaryTree.createBinarySearchTreeWithParent(20);
		t.printDFS();

		listSuccessor(t.root);
	}
	
	private static void listSuccessor(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return;
		}

		listSuccessor(node.left);
		System.out.print("successor of " + node.value + "=");
		BinaryTreeNode<Integer> successor = inorderSuc(node);
		System.out.println(successor != null ? successor.value : null);
		listSuccessor(node.right);
	}

	private static BinaryTreeNode<Integer> inorderSuc(BinaryTreeNode<Integer> n) {
		if (n == null) {
			return null;
		}

		/* Found right children -> return leftmost node of right subtree. */
		if(n.right != null) {
			return leftMostChild(n.right);
		}else {
			BinaryTreeNode<Integer> q = n;
			BinaryTreeNode<Integer> x = q.parent;
			//Go up until we're on left instead of right
			while(x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			
			return x;
		}
	}
	
	private static BinaryTreeNode<Integer> leftMostChild(BinaryTreeNode<Integer> n){
		if(n == null) {
			return null;
		}
		
		while(n.left != null) {
			n = n.left;
		}
		
		return n;
	}
}

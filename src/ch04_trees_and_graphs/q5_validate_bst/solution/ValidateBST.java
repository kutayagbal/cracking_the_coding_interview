package ch04_trees_and_graphs.q5_validate_bst.solution;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class ValidateBST {

	public static void main(String[] args) {
		BinaryTree<Integer> t = BinaryTree.createRandomIntBinaryTree(10, 5);
		t.printDFS();
		System.out.println(checkBST(t));
		t= BinaryTree.createBinarySearchTree(20);
		t.printDFS();
		System.out.println(checkBST(t));
	}

	public static boolean checkBST(BinaryTree<Integer> t) {
		return checkBST(t.root, null, null);
	}
	
	private static boolean checkBST(BinaryTreeNode<Integer> node, Integer min, Integer max) {
		if(node == null) {
			return true;
		}
		
		if((min != null && node.value <= min) || (max != null && node.value > max)) {
			return false;
		}
		
		if(!checkBST(node.left, min, node.value) || !checkBST(node.right, node.value, max)) {
			return false;
		}
		
		return true;
	}
}

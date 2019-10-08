package ch04_trees_and_graphs.q5_validate_bst;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class ValidateBST {

	public static void main(String[] args) {
		BinaryTree<Integer> t = BinaryTree.createRandomIntBinaryTree(10, 5);
		t.printDFS();
		System.out.println(validateBST(t.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		t = BinaryTree.createBinarySearchTree(100);
		t.printDFS();
		System.out.println(validateBST(t.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	private static boolean validateBST(BinaryTreeNode<Integer> node, Integer min, Integer max) {
		if(node == null) {
			return true;
		}
		
		if(node.left != null) {
			Integer left = node.left.value;
			if(left.compareTo(node.value) >= 0 || left.compareTo(min) < 0) {
				return false;
			}
		}
		
		if(node.right != null) {
			Integer right = node.right.value;
			if(right.compareTo(node.value) < 0 || right.compareTo(max) >= 0) {
				return false;
			}
		}
		
		return validateBST(node.left, min, node.value) && validateBST(node.right, node.value, max);
	}

}

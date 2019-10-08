package ch04_trees_and_graphs.q8_first_common_ancestor;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class FirstCommonAncestor {

	public static void main(String[] args) {
		BinaryTree<Integer> t = BinaryTree.createRandomIntBinaryTree(100, 7);
		t.printDFS();
		BinaryTreeNode<Integer> node1 = t.getRandomNode();
		BinaryTreeNode<Integer> node2 = t.getRandomNode();
		
		System.out.println("Node1=" + node1.value);
		System.out.println("Node2=" + node2.value);
		
		BinaryTreeNode<Integer> ancestor = findFirstCommonAncestor(node1, node2);
		System.out.println(ancestor != null ? "ancestor=" + ancestor.value : "no common ancestor.");
	}

	public static BinaryTreeNode<Integer> findFirstCommonAncestor(BinaryTreeNode<Integer> node1,
			BinaryTreeNode<Integer> node2) {
		if (node1 == node2) {
			return node1;
		}

		if (node1 == null || node2 == null) {
			return null;
		}
		
		if(doesSubtreeContainNode(node1, node2)) {
			return node1;
		}
		
		if(doesSubtreeContainNode(node2, node1)) {
			return node2;
		}

		BinaryTreeNode<Integer> parent = node1.parent;
		if(parent == null) {
			return null;
		}
		
		BinaryTreeNode<Integer> sibling = null;
		if (parent.right == node1) {
			sibling = parent.left;
		} else {
			sibling = parent.right;
		}

		while (!doesSubtreeContainNode(sibling, node2)) {
			sibling = parent;
			parent = parent.parent;

			if(parent == null) {
				return null;
			}
			
			if (parent.right == sibling) {
				sibling = parent.left;
			} else {
				sibling = parent.right;
			}
		}

		return parent;
	}

	public static boolean doesSubtreeContainNode(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
		if (root == null) {
			return false;
		}

		if (root == node) {
			return true;
		}

		boolean leftContains = doesSubtreeContainNode(root.left, node);
		if (leftContains)
			return true;

		boolean rightContains = doesSubtreeContainNode(root.right, node);
		if (rightContains)
			return true;

		return false;
	}
}

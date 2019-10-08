package ch04_trees_and_graphs.q8_first_common_ancestor.solution;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class FirstCommonAncestorWithParent {

	public static void main(String[] args) {
		BinaryTree<Integer> t = BinaryTree.createRandomIntBinaryTree(100, 7);
		t.printDFS();
		BinaryTreeNode<Integer> node1 = t.getRandomNode();
		BinaryTreeNode<Integer> node2 = t.getRandomNode();

		System.out.println("Node1=" + node1.value);
		System.out.println("Node2=" + node2.value);

		BinaryTreeNode<Integer> ancestor = commonAncestor(t.root, node1, node2);
		System.out.println(ancestor != null ? "ancestor=" + ancestor.value : "no common ancestor.");
	}

	public static BinaryTreeNode<Integer> commonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1,
			BinaryTreeNode<Integer> node2) {
		/* Check if either node is not in the tree, or if one covers the other. */
		if (!covers(root, node1) || !covers(root, node2)) {
			return null;
		} else if (covers(node1, node2)) {
			return node1;
		} else if (covers(node2, node1)) {
			return node2;
		}

		/* Traverse upwards until you find a node that covers q. */
		BinaryTreeNode<Integer> sibling = getSibling(node1);
		BinaryTreeNode<Integer> parent = node1.parent;
		while (!covers(sibling, node2)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}

		return parent;
	}

	public static boolean covers(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
		if (root == null) {
			return false;
		}

		if (root == node) {
			return true;
		}

		return covers(root.left, node) || covers(root.right, node);
	}

	public static BinaryTreeNode<Integer> getSibling(BinaryTreeNode<Integer> node) {
		if (node == null || node.parent == null) {
			return null;
		}

		return node.parent.left == node ? node.parent.right : node.parent.left;
	}
}

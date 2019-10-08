package ch04_trees_and_graphs.q10_check_subtree.solution;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class CheckSubtree {

	public static void main(String[] args) {
		BinaryTree<Integer> bigTree = BinaryTree.createRandomIntBinaryTree(2, 15);
		bigTree.printDFS();
		BinaryTree<Integer> smallTree = BinaryTree.createRandomIntBinaryTree(2, 3);
		smallTree.printDFS();
		System.out.println(containsTreeWithStringComparison(bigTree.root, smallTree.root));
		System.out.println(containsTree(bigTree.root, smallTree.root));
	}

	private static boolean containsTreeWithStringComparison(BinaryTreeNode<Integer> rootBig,
			BinaryTreeNode<Integer> rootSmall) {
		StringBuilder stringBig = new StringBuilder();
		StringBuilder stringSmall = new StringBuilder();

		getOrderString(rootBig, stringBig);
		getOrderString(rootSmall, stringSmall);

		return stringBig.indexOf(stringSmall.toString()) != -1;
	}

	// O(n + m)
	// O(n + m)
	// using preorder traversal is important.
	private static void getOrderString(BinaryTreeNode<Integer> node, StringBuilder sb) {
		if (node == null) {
			sb.append("X"); // Add null indicator
			return;
		}

		sb.append(node.value + " "); // Add root
		getOrderString(node.left, sb);// Add left
		getOrderString(node.right, sb);// Add right
	}

	private static boolean containsTree(BinaryTreeNode<Integer> rootBig, BinaryTreeNode<Integer> rootSmall) {
		if (rootSmall == null)
			return true; // The empty tree is always a subtree return subTree(tl, t2);

		return subTree(rootBig, rootSmall);
	}

	private static boolean subTree(BinaryTreeNode<Integer> nodeBig, BinaryTreeNode<Integer> nodeSmall) {
		if (nodeBig == null) {
			return false; // big tree empty & subtree still not found
		} else if (nodeBig.value.intValue() == nodeSmall.value.intValue() && matchTree(nodeBig, nodeSmall)) {
			return true;
		}

		return subTree(nodeBig.left, nodeSmall) || subTree(nodeBig.right, nodeSmall);
	}

	// O(n + km) where k is the number of occurrences of T2's root in T1.
	// O(log(n) + log(m))
	private static boolean matchTree(BinaryTreeNode<Integer> nodeBig, BinaryTreeNode<Integer> nodeSmall) {
		if (nodeBig == null && nodeSmall == null) {
			return true; // nothing left in the subtree
		} else if (nodeBig == null || nodeSmall == null) {
			return false; // one of the tree is empty, therefore trees don't match
		} else if (nodeBig.value.intValue() != nodeSmall.value.intValue()) {
			return false; // data doesn't match
		} else {
			return matchTree(nodeBig.left, nodeSmall.left) && matchTree(nodeBig.right, nodeSmall.right);
		}
	}

}

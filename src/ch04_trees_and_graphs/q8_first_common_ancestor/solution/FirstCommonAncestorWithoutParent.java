package ch04_trees_and_graphs.q8_first_common_ancestor.solution;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class FirstCommonAncestorWithoutParent {

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
		Result r = commonAncestorHelper(root, node1, node2);
		if (r.isAncestor) {
			return r.node;
		}

		return null;
	}

	private static Result commonAncestorHelper(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1,
			BinaryTreeNode<Integer> node2) {
		if (root == null) {
			return new Result(null, false);
		}

		if (root == node1 && root == node2) {
			return new Result(root, true);
		}

		Result rx = commonAncestorHelper(root.left, node1, node2);
		if (rx.isAncestor) {
			return rx; // Found common ancestor
		}

		Result ry = commonAncestorHelper(root.right, node1, node2);
		if (ry.isAncestor) {
			return ry; // Found common ancestor
		}

		if (rx.node != null && ry.node != null) {
			return new Result(root, true); // This is the common ancestor
		} else if (root == node1 || root == node2) {
			/*
			 * If we're currently at p or q, and we also found one of those nodes in a
			 * subtree, then this is truly an ancestor and the flag should be true.
			 */
			boolean isAncestor = rx.node != null || ry.node != null;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
	}

	private static class Result {
		public BinaryTreeNode<Integer> node;
		public boolean isAncestor;

		public Result(BinaryTreeNode<Integer> node, boolean isAncestor) {
			this.node = node;
			this.isAncestor = isAncestor;
		}
	}
}

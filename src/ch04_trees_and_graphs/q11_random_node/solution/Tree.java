package ch04_trees_and_graphs.q11_random_node.solution;

import java.util.Random;

public class Tree {
	TreeNode root = null;

	public int size() {
		return root != null ? root.getSize() : 0;
	}

	public TreeNode getRandomNode() {
		if (root == null)
			return null;

		int i = new Random().nextInt(size());
		return root.getIthNode(i);
	}

	public void insertInOrder(int d) {
		if (root == null) {
			root = new TreeNode(d);
		} else {
			root.insertInOrder(d);
		}
	}

	public void print() {
		System.out.println();
		printTree(this.root);
		System.out.println();
	}

	private void printTree(TreeNode node) {
		if (node == null) {
			return;
		}

		if (node.left != null && node.right != null) {
			System.out.println(node.getData() + " => " + node.left.getData() + " , " + node.right.getData());
		} else if (node.right != null) {
			System.out.println(node.getData() + " =>   , " + node.right.getData());
		} else if (node.left != null) {
			System.out.println(node.getData() + " => " + node.left.getData() + " , ");
		} else {
			System.out.println(node.getData() + " =>  ,");
		}

		printTree(node.left);
		printTree(node.right);
	}

	public void delete(int d) {
		root = delete(root, d);
	}

	private TreeNode delete(TreeNode node, int d) {
		if (node == null) {
			return null;
		}

		if (d < node.getData()) {
			node.left = delete(node.left, d);
		} else if (d > node.getData()) {
			node.right = delete(node.right, d);
		} else {
			// node with only one child or no child
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}

			/*
			 * node with two children: Get the in order successor (smallest in the right
			 * subtree)
			 */
			node.setData(minVal(node.right));

			node.right = delete(node.right, node.getData());
		}

		return node;
	}

	private int minVal(TreeNode node) {
		int minVal = node.getData();

		while (node.left != null) {
			minVal = node.left.getData();
			node = node.left;
		}

		return minVal;
	}
}

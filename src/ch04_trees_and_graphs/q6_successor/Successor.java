package ch04_trees_and_graphs.q6_successor;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class Successor {

	public static void main(String[] args) {
		BinaryTree<Integer> t = BinaryTree.createBinarySearchTreeWithParent(20);
		t.printDFS();

		listSuccessor(t.root);
	}

	public static void listSuccessor(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return;
		}

		listSuccessor(node.left);
		System.out.print("successor of " + node.value + "=");
		BinaryTreeNode<Integer> successor = successor(node);
		System.out.println(successor != null ? successor.value : null);
		listSuccessor(node.right);
	}

	public static BinaryTreeNode<Integer> successor(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return null;
		}

		if (node.right != null) {
			BinaryTreeNode<Integer> curr = node.right;
			while (curr.left != null) {
				curr = curr.left;
			}

			return curr;
		} else {
			if (node.parent == null) {
				return null; // last node
			}

			if (node.parent.right == node) {
				BinaryTreeNode<Integer> curr = node.parent;
				while (curr.parent != null && curr.parent.right == curr) {
					curr = curr.parent;
				}

				return curr.parent;
			} else {
				return node.parent;
			}
		}
	}
}

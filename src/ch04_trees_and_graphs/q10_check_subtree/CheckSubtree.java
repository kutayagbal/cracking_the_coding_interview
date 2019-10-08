package ch04_trees_and_graphs.q10_check_subtree;

import java.util.LinkedList;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class CheckSubtree {

	public static void main(String[] args) {
		BinaryTree<Integer> bigTree = BinaryTree.createRandomIntBinaryTree(2, 15);
		bigTree.printDFS();
		BinaryTree<Integer> smallTree = BinaryTree.createRandomIntBinaryTree(2, 3);
		smallTree.printDFS();
		System.out.println(checkSubtreeBFS(bigTree.root, smallTree.root));
	}

	public static boolean checkSubtreeBFS(BinaryTreeNode<Integer> rootBig, BinaryTreeNode<Integer> rootSmall) {
		if (rootBig == null) {
			if (rootSmall == null) {
				return true;
			}

			return false;
		} else if (rootSmall == null) {
			return false;
		}

		LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		rootBig.marked = true;
		queue.add(rootBig);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.remove();

			if (node.value == rootSmall.value) {
				if (checkSubtreeDFS(node, rootSmall)) {
					return true;
				}
			}

			BinaryTreeNode<Integer> left = node.left;

			if (left != null) {
				if (!left.marked) {
					if (left.value == rootSmall.value) {
						if (checkSubtreeDFS(left, rootSmall)) {
							return true;
						}
					}

					left.marked = true;
					queue.add(left);
				}
			}

			BinaryTreeNode<Integer> right = node.right;
			if (right != null) {
				if (!right.marked) {
					if (right.value == rootSmall.value) {
						if (checkSubtreeDFS(right, rootSmall)) {
							return true;
						}
					}

					right.marked = true;
					queue.add(right);
				}
			}
		}

		return false;
	}

	private static boolean checkSubtreeDFS(BinaryTreeNode<Integer> nodeBig, BinaryTreeNode<Integer> nodeSmall) {
		if (nodeBig == null) {
			if (nodeSmall == null) {
				return true;
			}
			return false;
		} else if (nodeSmall == null) {
			return false;
		}

		if (nodeBig.value.intValue() != nodeSmall.value.intValue()) {
			return false;
		}

		return checkSubtreeDFS(nodeBig.left, nodeSmall.left) && checkSubtreeDFS(nodeBig.right, nodeSmall.right);
	}

}

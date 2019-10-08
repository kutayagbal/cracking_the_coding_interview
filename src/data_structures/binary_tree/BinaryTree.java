package data_structures.binary_tree;

import java.util.ArrayList;
import java.util.Random;

public class BinaryTree<E> {
	public BinaryTreeNode<E> root;

	public BinaryTree(BinaryTreeNode<E> root) {
		this.root = root;
	}

	public BinaryTreeNode<E> getRandomNode() {
		ArrayList<BinaryTreeNode<E>> nodeList = new ArrayList<BinaryTreeNode<E>>();
		createNodeList(nodeList, (BinaryTreeNode<E>) root);
		return nodeList.get(new Random().nextInt(nodeList.size()));
	}

	private void createNodeList(ArrayList<BinaryTreeNode<E>> nodeList, BinaryTreeNode<E> root) {
		if (root == null) {
			return;
		}

		nodeList.add(root);
		createNodeList(nodeList, root.left);
		createNodeList(nodeList, root.right);
	}

	public static BinaryTree<Integer> createBinarySearchTree(int valueBound) {
		if (valueBound == 0) {
			return new BinaryTree<>(null);
		}

		Integer[] elements = new Integer[valueBound];
		for (int i = 0; i < valueBound; i++) {
			elements[i] = Integer.valueOf(i);
		}

		return new BinaryTree<Integer>(createBinaryTreeWithOrderedArray(elements, 0, elements.length - 1));
	}

	private static BinaryTreeNode<Integer> createBinaryTreeWithOrderedArray(Integer[] elements, int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(elements[mid]);
		root.left = createBinaryTreeWithOrderedArray(elements, start, mid - 1);
		root.right = createBinaryTreeWithOrderedArray(elements, mid + 1, end);
		return root;
	}

	public static BinaryTree<Integer> createRandomIntBinaryTree(int valueBound, int lengthBound) {
		if (lengthBound == 0) {
			return new BinaryTree<>(null);
		}

		// create root
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(new Random().nextInt(valueBound));
		createRandomIntBinaryTreeNode(root, valueBound, lengthBound, 1); // first level was created

		return new BinaryTree<Integer>(root);
	}

	private static void createRandomIntBinaryTreeNode(BinaryTreeNode<Integer> node, int valueBound, int lengthBound,
			int length) {
		if (length >= lengthBound) { // do not excess lengthBound
			return;
		}

		boolean createLeftBranch = new Random().nextBoolean();
		if (createLeftBranch) {
			node.left = new BinaryTreeNode<Integer>(new Random().nextInt(valueBound));
			node.left.parent = node;
			createRandomIntBinaryTreeNode(node.left, valueBound, lengthBound, length + 1);
		}

		boolean createRightBranch = new Random().nextBoolean();
		if (createRightBranch) {
			node.right = new BinaryTreeNode<Integer>(new Random().nextInt(valueBound));
			node.right.parent = node;
			createRandomIntBinaryTreeNode(node.right, valueBound, lengthBound, length + 1);
		}
	}

	public void printDFS() {
		System.out.println();

		if (root == null) {
			System.out.println("empty tree");
			System.out.println();
			return;
		}

		printDFS(root);
		System.out.println();
	}

	private void printDFS(BinaryTreeNode<E> node) {
		if (node == null) {
			return;
		}

		if (node.left != null && node.right != null) {
			System.out.println(node.value + " -> " + node.left.value + " , " + node.right.value);
		} else {
			if (node.left != null) {
				System.out.println(node.value + " -> " + node.left.value + ", ");
			} else if (node.right != null) {
				System.out.println(node.value + " ->   , " + node.right.value);
			} else {
				System.out.println(node.value + " ->   ,");
			}
		}

		printDFS(node.left);
		printDFS(node.right);
	}

	public static BinaryTree<Integer> createBinarySearchTreeWithParent(int valueBound) {
		if (valueBound == 0) {
			return new BinaryTree<Integer>(null);
		}

		Integer[] elements = new Integer[valueBound];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = Integer.valueOf(i);
		}

		return new BinaryTree<Integer>(createBinaryTreeWithOrderedArrayWithParent(elements, 0, elements.length - 1));
	}

	private static BinaryTreeNode<Integer> createBinaryTreeWithOrderedArrayWithParent(Integer[] elements, int start,
			int end) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(elements[mid]);

		root.left = createBinaryTreeWithOrderedArrayWithParent(elements, start, mid - 1);
		if (root.left != null) {
			root.left.parent = root;
		}

		root.right = createBinaryTreeWithOrderedArrayWithParent(elements, mid + 1, end);
		if (root.right != null) {
			root.right.parent = root;
		}

		return root;
	}

}

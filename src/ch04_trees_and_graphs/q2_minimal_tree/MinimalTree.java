package ch04_trees_and_graphs.q2_minimal_tree;

public class MinimalTree {

	public static void main(String[] args) {
		int[] arr = new int[15];
		for (int i = 0; i < 15; i++) {
			arr[i] = i;
		}

		Node root = minimalTree(0, arr.length - 1, arr);
		printDFS(root);
	}

	private static void printDFS(Node node) {
		if (node == null)
			return;

		if (node.left != null && node.right != null) {
			System.out.println(node.value + "->" + node.left.value + " ," + node.right.value);
		} else {
			if (node.left != null) {
				System.out.println(node.value + "->" + node.left.value + " ,");
			} else if (node.right != null) {
				System.out.println(node.value + "-> ," + +node.right.value);
			}
		}

		printDFS(node.left);
		printDFS(node.right);
	}

	private static Node minimalTree(int leftIndex, int rightIndex, int[] arr) {
		if (leftIndex > rightIndex)
			return null;

		if (leftIndex == rightIndex) {
			return new Node(arr[leftIndex]);
		}

		int midIndex = (leftIndex + rightIndex) / 2;

		Node n = new Node(arr[midIndex]);
		n.left = minimalTree(leftIndex, midIndex - 1, arr);
		n.right = minimalTree(midIndex + 1, rightIndex, arr);

		return n;
	}

	private static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

}

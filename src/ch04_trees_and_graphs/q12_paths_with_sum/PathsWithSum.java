package ch04_trees_and_graphs.q12_paths_with_sum;

import java.util.Random;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class PathsWithSum {

	public static void main(String[] args) {
		BinaryTree<Integer> t = BinaryTree.createRandomIntBinaryTree(2, 10);
		t.printDFS();

		int sum = new Random().nextInt(4);
		System.out.println("path count for sum " + sum + " = " + totalPathsWithSum(t.root, sum));
	}

	// O(n2)
	// O(2log(n)) = O(log(n))
	public static int totalPathsWithSum(BinaryTreeNode<Integer> root, int sum) {
		if (root == null)
			return 0;

		int ownTotal = pathsWithSum(root, 0, sum);

		return ownTotal + totalPathsWithSum(root.left, sum) + totalPathsWithSum(root.right, sum);
	}

	public static int pathsWithSum(BinaryTreeNode<Integer> current, int currentSum, int sum) {
		if (current == null)
			return 0;

		currentSum = currentSum + current.value.intValue();
		int total = 0;
		if (currentSum == sum) {
			total++;
		}

		total += pathsWithSum(current.left, currentSum, sum);
		total += pathsWithSum(current.right, currentSum, sum);

		return total;
	}

	public static class Result {
		int pathCount;

		public Result(int p) {
			pathCount = p;
		}
	}
}

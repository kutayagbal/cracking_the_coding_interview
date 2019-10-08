package ch04_trees_and_graphs.q12_paths_with_sum.solution;

import java.util.HashMap;
import java.util.Random;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class PathsWithSum {

	public static void main(String[] args) {
		BinaryTree<Integer> t = BinaryTree.createRandomIntBinaryTree(2, 10);
		t.printDFS();

		int sum = new Random().nextInt(4);
		System.out.println("path count for sum " + sum + " = " + countPathsWithSum(t.root, sum));
	}

	// O(n)
	// O(log(n))
	public static int countPathsWithSum(BinaryTreeNode<Integer> root, int targetSum) {
		return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}

	public static int countPathsWithSum(BinaryTreeNode<Integer> node, int targetSum, int runningSum,
			HashMap<Integer, Integer> pathCountMap) {
		if (node == null) // base case
			return 0;

		/* Count paths with sum ending at the current node. */
		runningSum += (Integer) node.value;
		int sum = runningSum - targetSum;

		int totalPaths = pathCountMap.getOrDefault(sum, 0);

		/*
		 * If runningSum equals targetSum, then one additional path starts at root. Add
		 * in this path.
		 */
		if (targetSum == runningSum) {
			totalPaths++;
		}

		/* Increment pathCount, recurse, then decrement pathCount. */
		incrementHashTable(pathCountMap, runningSum, 1);
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCountMap);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCountMap);

		/* Decrement pathCount. No need for this path anymore for upper nodes. */
		incrementHashTable(pathCountMap, runningSum, -1);

		return totalPaths;
	}

	private static void incrementHashTable(HashMap<Integer, Integer> pathCountMap, int key, int delta) {
		int newCount = pathCountMap.getOrDefault(key, 0);
		if (newCount == 0) {
			pathCountMap.remove(key);
		} else {
			pathCountMap.put(key, newCount);
		}
	}
}

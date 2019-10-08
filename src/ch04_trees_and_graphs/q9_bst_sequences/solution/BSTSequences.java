package ch04_trees_and_graphs.q9_bst_sequences.solution;

import java.util.ArrayList;
import java.util.LinkedList;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.BinaryTreeNode;

public class BSTSequences {

	public static void main(String[] args) {
		BinaryTree<Integer> bst = BinaryTree.createBinarySearchTree(6);
		bst.printDFS();
		
		ArrayList<LinkedList<Integer>> resultList = allSequences(bst.root);

		System.out.println();
		for (LinkedList<Integer> list : resultList) {
			for (Integer item : list) {
				System.out.print(item + ",");
			}
			System.out.println();
		}
	}

	public static ArrayList<LinkedList<Integer>> allSequences(BinaryTreeNode<Integer> root) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<>();

		if (root == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}

		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(root.value);

		/* Recurse on left and right subtrees. */
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(root.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(root.right);

		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}

		return result;
	}

	/*
	 * Weave lists together in all possible ways. This algorithm works by removing
	 * the head from one list, recursing, and then doing the same thing with the
	 * other list.
	 */
	private static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		/* One list is empty. Add remainder to [a cloned] prefix and store result. */
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		/*
		 * Recurse with head of first added to the prefix. Removing the head will damage
		 * first, so we'll need to put it back where we found it afterwards.
		 */
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);

		/* Do the same thing with second, damaging and then restoring the list. */
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}

}

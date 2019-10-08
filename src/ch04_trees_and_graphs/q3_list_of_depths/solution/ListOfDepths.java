package ch04_trees_and_graphs.q3_list_of_depths.solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import ch04_trees_and_graphs.q2_minimal_tree.solution.Tree;
import ch04_trees_and_graphs.q2_minimal_tree.solution.TreeNode;

public class ListOfDepths {
	/*
	 * DFS and BFS solutions both run in O(N) time, but what about the space
	 * efficiency? At first, we might want to claim that the BFS solution is more
	 * space efficient. In a sense, that'scorrect.The DFS solution uses O(logN)
	 * recursive calls (in a balanced tree), each of which adds a new level to the
	 * stack. The BFS solution, which is iterative, does not require this extra
	 * space. However, both solutions require returning O(N) data. The extra O(logN)
	 * space usage from the recursive DFS implementation is dwarfed by the O(N) data
	 * that must be returned. So while the DFS solution may actually use more data,
	 * they are equally efficient when it comes to 'big O'
	 */
	public static void main(String[] args) {
		Tree t = ch04_trees_and_graphs.q3_list_of_depths.ListOfDepths.createRandomIntBinaryTree(10, 5);
		t.printDFS(t.root);

		printLists(createLevelLinkedListDFS(t.root));
		printLists(createLevelLinkedListBSF(t.root));
	}

	public static void printLists(ArrayList<LinkedList<TreeNode>> list) {
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			LinkedList<TreeNode> l = list.get(i);

			Iterator<TreeNode> it = l.iterator();
			System.out.print("level_" + i + " -> ");
			while (it.hasNext()) {
				System.out.print(it.next().getValue() + " ,");
			}

			System.out.println();
		}
	}

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBSF(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		// visit root
		LinkedList<TreeNode> current = new LinkedList<>();
		if (root != null) {
			current.add(root);
		}

		while (current.size() > 0) {
			result.add(current); // add previous level

			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				// visit the children
				if (parent.left != null) {
					current.add(parent.left);
				}

				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}

		return result;
	}

	private static void createLevelLinkedListDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null) {
			return; // base case
		}

		LinkedList<TreeNode> list = null;

		if (lists.size() == level) { // level not contained in list
			list = new LinkedList<TreeNode>();
			/*
			 * Levels are always traversed in order. So, if this is the first time we've
			 * visited level i, we must have seen levels 0 through i - 1. We can therefore
			 * safely add the level at the end.
			 */
			lists.add(list);
		} else {
			list = lists.get(level);
		}

		list.add(root);

		createLevelLinkedListDFS(root.left, lists, level + 1);
		createLevelLinkedListDFS(root.right, lists, level + 1);
	}

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedListDFS(root, lists, 0);
		return lists;
	}
}

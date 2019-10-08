package ch04_trees_and_graphs.q3_list_of_depths;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import ch04_trees_and_graphs.q2_minimal_tree.solution.Tree;
import ch04_trees_and_graphs.q2_minimal_tree.solution.TreeNode;

public class ListOfDepths {

	private static ArrayList<LinkedList<TreeNode>> listOfDepths = new ArrayList<>();

	public static void main(String[] args) {
		Tree t = createRandomIntBinaryTree(10, 5);
		t.printDFS(t.root);

		listOfDepths(0, t.root);

		System.out.println();
		for (int i = 0; i < listOfDepths.size(); i++) {
			LinkedList<TreeNode> l = listOfDepths.get(i);
			System.out.print("level_" + i + " -> ");
			Iterator<TreeNode> it = l.iterator();
			while (it.hasNext()) {
				System.out.print(it.next().getValue() + " ,");
			}
			System.out.println();
		}
	}

	public static Tree createRandomIntBinaryTree(int valueBound, int heightBound) {
		TreeNode node = new TreeNode(new Random().nextInt(valueBound));
		addRandomIntTreeNode(node, valueBound, 0, heightBound);
		return new Tree(node);
	}

	private static void addRandomIntTreeNode(TreeNode node, int valueBound, int height, int heightBound) {
		if (height > heightBound)
			return;

		boolean addBranch = new Random().nextBoolean();

		if (addBranch) {
			height++;
			node.left = new TreeNode(new Random().nextInt(valueBound));
			addRandomIntTreeNode(node.left, valueBound, height, heightBound);
		}

		addBranch = new Random().nextBoolean();

		if (addBranch) {
			height++;
			node.right = new TreeNode(new Random().nextInt(valueBound));
			addRandomIntTreeNode(node.right, valueBound, height, heightBound);
		}
	}

	private static void listOfDepths(int level, TreeNode node) {
		if (node == null) {
			return;
		}

		if (listOfDepths.size() < level + 1) {
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.add(node);
			listOfDepths.add(list);
		} else {
			listOfDepths.get(level).add(node);
		}

		listOfDepths(level + 1, node.left);
		listOfDepths(level + 1, node.right);
	}
}

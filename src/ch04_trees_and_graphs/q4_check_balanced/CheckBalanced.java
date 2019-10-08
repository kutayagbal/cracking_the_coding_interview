package ch04_trees_and_graphs.q4_check_balanced;

import ch04_trees_and_graphs.q2_minimal_tree.solution.Tree;
import ch04_trees_and_graphs.q2_minimal_tree.solution.TreeNode;
import ch04_trees_and_graphs.q3_list_of_depths.ListOfDepths;

public class CheckBalanced {

	public static void main(String[] args) {
		Tree t = ListOfDepths.createRandomIntBinaryTree(10, 5);
		t.printDFS(t.root);

		int result = checkBalanced(t.root);

		if (result < 0)
			System.out.println(false);
		else
			System.out.println(true);
	}

	public static int checkBalanced(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftHeight = checkBalanced(node.left);

		if (leftHeight < 0) {
			return -1;
		}

		int rightHeight = checkBalanced(node.right);

		if (rightHeight < 0) {
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		return Math.max(leftHeight, rightHeight) + 1;
	}
}

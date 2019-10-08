package ch04_trees_and_graphs.q4_check_balanced.solution;

import ch04_trees_and_graphs.q2_minimal_tree.solution.Tree;
import ch04_trees_and_graphs.q2_minimal_tree.solution.TreeNode;
import ch04_trees_and_graphs.q3_list_of_depths.ListOfDepths;

public class CheckBalanced {

	public static void main(String[] args) {
		Tree t = ListOfDepths.createRandomIntBinaryTree(10, 5);
		t.printDFS(t.root);
		
		System.out.println(isBalanced(t.root));
	}
	
	//O(N)
	//O(H) H is the height of the tree
	private static int checkHeight(TreeNode node) {
		if(node == null)
			return -1;
		
		int leftHeight = checkHeight(node.left);
		if(leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE; // Pass error up
		
		int rightHeight = checkHeight(node.right);
		if(rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE; // Pass error up
		
		int diff = leftHeight - rightHeight;
		
		if(Math.abs(diff) > 1) {
			return Integer.MIN_VALUE; // Found error -> pass it back
		}else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public static boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

}

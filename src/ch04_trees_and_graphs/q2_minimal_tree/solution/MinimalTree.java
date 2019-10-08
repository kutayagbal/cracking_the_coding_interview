package ch04_trees_and_graphs.q2_minimal_tree.solution;

public class MinimalTree {

	public static void main(String[] args) {
		int[] arr = new int[15];
		for (int i = 0; i < 15; i++) {
			arr[i] = i;
		}

		TreeNode root = createMinimalBST(arr, 0, arr.length-1);
		Tree t = new Tree(root);
		t.printDFS(t.root);
	}
	
	private static TreeNode createMinimalBST(int[] arr, int start, int end) {
		if(end < start) {
			return null;
		}
		
		int mid = (start + end) / 2;
		
		TreeNode n = new TreeNode(arr[mid]);
		n.left = createMinimalBST(arr, start, mid-1);
		n.right = createMinimalBST(arr, mid+1, end);
		return n;
	}

}

package ch04_trees_and_graphs.q2_minimal_tree.solution;

public class Tree {
	public TreeNode root;
	
	public Tree(TreeNode root) {
		this.root = root;
	}
	
	public void printDFS(TreeNode node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.getValue() +  "->");
		if(node.left != null && node.right != null) {
			System.out.println(node.left.getValue() +" ," + node.right.getValue());
		}else {
			if(node.left != null) {
				System.out.println(node.left.getValue() + " ,");
			}else if (node.right != null) {
				System.out.println(" ," + node.right.getValue());
			}else {
				System.out.println(" ,");
			}
		}
		
		printDFS(node.left);
		printDFS(node.right);
		
	}
}

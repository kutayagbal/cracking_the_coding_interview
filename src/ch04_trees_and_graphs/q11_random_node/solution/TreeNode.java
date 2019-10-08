package ch04_trees_and_graphs.q11_random_node.solution;

public class TreeNode {
	private int data;
	public TreeNode left;
	public TreeNode right;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}

	public TreeNode getIthNode(int i) {
		int leftSize = left != null ? left.size : 0;
		if (i < leftSize) {
			return left.getIthNode(i);
		} else if (i == leftSize) {
			return this;
		} else {
			/* Skipping over leftSize + 1 nodes, so subtract them. */
			return right.getIthNode(i - (leftSize + 1));
		}
	}

	public void insertInOrder(int d) {
		if (d <= data) {
			if (left != null) {
				left.insertInOrder(d);
			} else {
				left = new TreeNode(d);
			}
		} else {
			if (right != null) {
				right.insertInOrder(d);
			} else {
				right = new TreeNode(d);
			}
		}

		size++;
	}

	public TreeNode find(int d) {
		if (data == d) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else {
			return right != null ? right.find(d) : null;
		}
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getSize() {
		return size;
	}
}

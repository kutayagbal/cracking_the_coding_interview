package ch10_sorting_and_searching.q10_rank_from_stream.solution;

public class RankFromStream {
	static RankNode root;

	public static void main(String... args) {
		int[] arr = { 1, 4, 4, 5, 9, 7, 13, 3 };

		root = new RankNode(5);

		for (int i : arr) {
			root.insert(i);
		}

		print(root);
		System.out.println();

		int k = 1;
		System.out.println("Count of " + k + " or less: " + root.getRank(k));
		k = 3;
		System.out.println("Count of " + k + " or less: " + root.getRank(k));
		k = 4;
		System.out.println("Count of " + k + " or less: " + root.getRank(k));
	}

	private static void print(RankNode node) {
		if (node == null)
			return;

		System.out.print(node.data + " (" + node.leftSize + ") --> ");

		if (node.left != null) {
			System.out.print(node.left.data + " (" + node.left.leftSize + "), ");
		} else {
			System.out.print(" , ");
		}

		if (node.right != null) {
			System.out.print(node.right.data + " (" + node.right.leftSize + "), ");
		}

		System.out.println();

		print(node.left);
		print(node.right);
	}
}

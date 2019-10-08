package ch04_trees_and_graphs.q11_random_node.solution;

import java.util.Random;

public class RandomNode {

	public static void main(String[] args) {
		Tree t = new Tree();

		for (int i = 0; i < 10; i++) {
			int toInsert = new Random().nextInt(30);
			// System.out.println(toInsert + " inserted");
			t.insertInOrder(toInsert);
			// t.print();
		}
		t.print();

		System.out.println("Random node=" + t.getRandomNode().getData());
		System.out.println();

//		for (int i = 0; i < 15; i++) {
//			int toDelete = new Random().nextInt(30);
//			t.delete(toDelete);
//			System.out.println(toDelete + " deleted");
//			t.print();
//		}
	}

}

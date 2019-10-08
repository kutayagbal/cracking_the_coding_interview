package ch02_linked_lists.q2_return_kth_last;

import java.util.Random;

public class ReturnKthLast {

	public static void main(String[] args) {
		Node head = createSingleLinkedListWithRandomInt(10, 100);

		printSingleLinkedList(head);

		Result r = returnKthLastRecursive(head, 3);
		if (r.node != null) {
			System.out.println(r.node.data);
		} else {
			System.out.println("not found.");
		}
		
//		System.out.println(returnKthLast(head, 3));
	}

	private static Result returnKthLastRecursive(Node node, int k) {
		if (node == null) {
			return new Result(null, 1);
		}

		Result result = returnKthLastRecursive(node.next, k);

		if (result.node != null) {
			return result;
		} else if (result.index == k) {
			return new Result(node, k);
		}

		return new Result(null, result.index + 1);
	}

	private static int returnKthLast(Node head, int k) {
		Node n = head;
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}

		if (size > k) {
			n = head;
			for (int i = 0; i < size - k; i++) {
				n = n.next;
			}

			return n.data;
		}

		return -1;
	}

	private static void printSingleLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println();
	}

	private static Node createSingleLinkedListWithRandomInt(int size, int bound) {
		Node head = new Node(new Random().nextInt(bound + 1));

		Node node = head;
		for (int i = 0; i < size; i++) {
			node.next = new Node(new Random().nextInt(bound + 1));
			node = node.next;
		}

		return head;
	}

	private static class Result {
		Node node;
		int index;

		public Result(Node node, int index) {
			this.index = index;
			this.node = node;
		}
	}

	private static class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

}

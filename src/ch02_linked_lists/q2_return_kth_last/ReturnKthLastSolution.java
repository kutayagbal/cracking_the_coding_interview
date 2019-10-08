package ch02_linked_lists.q2_return_kth_last;

import java.util.Random;

public class ReturnKthLastSolution {

	public static void main(String[] args) {
		Node head = createSingleLinkedListWithRandomInt(10, 100);
		printSingleLinkedList(head);
		System.out.println(kthToLastRecursive(head, 3).data);
		System.out.println(kthToLast(head, 3).data);
	}

	// O(n)
	// O(1)
	private static Node kthToLast(Node node, int k) {
		Node p1 = node;
		Node p2 = node;

		// move p1 k nodes into the list.
		for (int i = 0; i < k; i++) {
			if (p1 == null)// out of bounds
				return null;

			p1 = p1.next;
		}

		// move them at the same pace. When p1 hits the end, p2 will be at the right
		// element.
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;

	}

	private static Node kthToLastRecursive(Node node, int k) {
		Index idx = new Index();
		return kthToLastRecursive(node, k, idx);
	}

	// O(n)
	// O(n)
	private static Node kthToLastRecursive(Node node, int k, Index idx) {
		if (node == null) {
			return null;
		}

		Node result = kthToLastRecursive(node.next, k, idx);
		idx.value++;

		if (idx.value == k) {
			return node;
		}

		return result;
	}

	private static class Index {
		int value = 0;
	}

	private static class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}
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
}

package ch02_linked_lists.q3_delete_middle_node;

import java.util.Random;

public class DeleteMiddleNode {
	private static int size = 10;

	public static void main(String[] args) {
		Node head = createSinglyLinkedListWithRandomInt(size, 100);
		Node deleteNode = printLinkedList(head);
		delete(deleteNode);
		printLinkedList(head);
	}

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	// O(n)
	// O(1)
	private static void delete(Node n) {
		Node prev = null;
		
		while (n != null) {
			if (n.next != null) {
				prev = n;
				n.data = n.next.data;
			}else {
				prev.next = null;
			}
			
			if (n != null)
				n = n.next;
		}
	}

	private static Node createSinglyLinkedListWithRandomInt(int size, int bound) {
		Node head = new Node(new Random().nextInt(bound));
		Node node = head;
		for (int i = 1; i < size; i++) {
			node.next = new Node(new Random().nextInt(bound));
			node = node.next;
		}

		return head;
	}

	private static Node printLinkedList(Node node) {
		int randomIndex = new Random().nextInt(size);
		Node n = null;

		int counter = 0;
		while (node != null) {
			System.out.print(node.data + ",");

			if (counter == randomIndex) {
				n = node;
			}

			node = node.next;
			counter++;
		}
		System.out.println();

		System.out.println("Delete " + n.data);

		return n;
	}
}

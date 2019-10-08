package ch02_linked_lists.q4_partition;

import java.util.Random;

public class PartitionSolution {

	public static void main(String[] args) {
		Node head = createSinglyLinkedListWithRandomInt(10, 101);
		printLinkedList(head);
		
		int part = 45;
		System.out.println("Partition " + part);
		
		head = partition(head, part);
		printLinkedList(head);
	}

	//O(n)
	//O(1)
	private static Node partition(Node node, int x) {
		Node head = node;
		Node tail = node;

		while (node != null) {
			Node next = node.next;
			if (node.data < x) {
				// Insert node at head. (put before head)
				node.next = head;
				head = node;
			} else {
				// Insert node at tail. (put after tail)
				tail.next = node;
				tail = node;
			}
			node = next;
		}

		tail.next = null;
		
		// The head has changed, so we need to return it to the user.
		return head;
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

	private static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println();
	}

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}
	}
}

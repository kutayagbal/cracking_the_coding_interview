package data_structures;

import java.util.Random;

public class SinglyLinkedList {
	public Node head;
	
	public SinglyLinkedList(int size, int bound) {
		this.head = createSinglyLinkedListWithRandomInt(size, bound);
	}
	
	public SinglyLinkedList(Node head) {
		this.head = head;
	}
	
	public SinglyLinkedList() {}
	
	public int getLength() {
		Node n = this.head;
		int counter = 0;
		while (n != null) {
			counter++;
			n = n.next;
		}
		
		return counter;
	}
	
	private Node createSinglyLinkedListWithRandomInt(int size, int bound) {
		Node head = new Node(new Random().nextInt(bound));
		Node node = head;

		for (int i = 1; i < size; i++) {
			node.next = new Node(new Random().nextInt(bound));
			node = node.next;
		}

		return head;
	}

	public void printLinkedList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println();
	}

	public static class Node {
		public Object data;
		public Node next;

		public Node(Object data) {
			this.data = data;
		}
	}
}

package ch02_linked_lists.q7_intersection;

import data_structures.SinglyLinkedList;
import data_structures.SinglyLinkedList.Node;

public class Intersection {

	public static void main(String[] args) {
		// create intersecting lists
		SinglyLinkedList list1 = new SinglyLinkedList(10, 10);
		SinglyLinkedList list2 = new SinglyLinkedList(10, 10);

		Node curr1 = list1.head;
		Node curr2 = list2.head;
		for (int i = 0; i < 3; i++) {
			curr1 = curr1.next;
		}

		for (int i = 0; i < 5; i++) {
			curr2 = curr2.next;
		}

		curr1.next = curr2.next;

		System.out.println("intersection = " + curr1.next.data);
		list1.printLinkedList();
		list2.printLinkedList();
		// create intersecting lists

		Node l1Head = reverseList(list1.head);
		SinglyLinkedList list1Reversed = new SinglyLinkedList(l1Head);
		list1Reversed.printLinkedList();
		// System.out.println(intersection(list1.head, list2.head).data);

	}

	/*
	 * WRONG... You need to create new linkedlist nodes to reverse a linked list. If we
	 * create new arraylist we cannot compare references.
	 */
	private static Node reverseList(Node node) {
		Node head = null;
		while (node != null) {
			// insert before head
			Node newNode = new Node(node.data);
			newNode.next = head;
			head = newNode;
			node = node.next;
		}

		return head;
	}

}

package ch02_linked_lists.q5_sum_lists;

import data_structures.SinglyLinkedList;
import data_structures.SinglyLinkedList.Node;

public class SumListsSolution {

	public static void main(String[] args) {
		SinglyLinkedList list1 = new SinglyLinkedList(3, 10);
		list1.printLinkedList();
		SinglyLinkedList list2 = new SinglyLinkedList(4, 10);
		list2.printLinkedList();

		SinglyLinkedList list3 = new SinglyLinkedList(addLists(list1, list2));
		list3.printLinkedList();
	}

	private static Node addLists(SinglyLinkedList list1, SinglyLinkedList list2) {
		int len1 = list1.getLength();
		int len2 = list2.getLength();

		/* Pad the shorter list with zeros - see note (1) */
		if (len1 < len2) {
			list1.head = padList(list1.head, len2 - len1);
		} else {
			list2.head = padList(list2.head, len1 - len2);
		}

		/* Add lists */
		PartialSum sum = addListsHelper(list1.head, list2.head);

		/*
		 * If there was a carry value left over, insert this at the front of the list.
		 * Otherwise, just return the linked list.
		 */
		Node result;
		if (sum.carry == 0) {
			result = sum.sum;
		} else {
			result = insertBefore(sum.sum, sum.carry);
		}

		return result;
	}

	private static Node padList(Node node, int padding) {
		Node head = node;

		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}

		return head;
	}

	private static PartialSum addListsHelper(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}

		/* Add smaller digits recursively */
		PartialSum sum = addListsHelper(node1.next, node2.next);

		/* Add carry to current data */
		int val = (int) node1.data + (int) node2.data + sum.carry;

		/* Insert sum of current digits */
		Node fullResult = insertBefore(sum.sum, val % 10);

		/* Return sum so far, and the carry value */
		sum.sum = fullResult;
		sum.carry = val / 10;
		return sum;
	}

	private static Node insertBefore(Node node, int data) {
		Node newNode = new Node(data);
		if (node != null) {
			newNode.next = node;
		}
		return newNode;
	}

	private static class PartialSum {
		Node sum;
		int carry;
	}

}

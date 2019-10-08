package ch02_linked_lists.q6_palindrome;

import data_structures.SinglyLinkedList;
import data_structures.SinglyLinkedList.Node;

public class Palindrome {

	public static void main(String[] args) {
		SinglyLinkedList list = createListFromString("ababababa");
		list.printLinkedList();
		System.out.println(isPalindrome(list));
		System.out.println(isPalindromeRecursive(list.head, list.head).result);
	}
	
	private static SinglyLinkedList createListFromString(String s) {
		SinglyLinkedList list = new SinglyLinkedList();

		Node head = new Node(s.charAt(0));
		Node node = head;
		for (int i = 1; i < s.length(); i++) {
			node.next = new Node(s.charAt(i));
			node = node.next;
		}

		list.head = head;
		return list;
	}

	// O(n)
	// O(n)
	private static boolean isPalindrome(SinglyLinkedList list) {
		SinglyLinkedList reversed = new SinglyLinkedList();
		Node fast = list.head;
		Node slow = list.head;

		while (fast != null && fast.next != null) {
			// insert before head
			Node newNode = new Node(slow.data);
			newNode.next = reversed.head;
			reversed.head = newNode;

			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) {
			// list has odd number of elements
			slow = slow.next;
		}

		Node curr = reversed.head;
		while (slow != null) {
			if ((char) slow.data != (char) curr.data) {
				return false;
			}

			slow = slow.next;
			curr = curr.next;
		}

		return true;
	}

	// O(n)
	// O(n)
	private static Result isPalindromeRecursive(Node head, Node current) {
		if (head.next == null) {// one element list
			Result r = new Result();
			r.result = true;
			return r;
		}

		if (current.next == null) {// base case. end of the list
			Result r = new Result();
			r.head = head.next;
			if ((char) current.data != (char) head.data) {
				r.result = false;
			}
			return r;
		}

		Result r = isPalindromeRecursive(head, current.next);
		if (r.result != null) {// if result was set, problem was solved.
			return r;
		}

		if (r.head == current) {// one node in the middle
			r.result = true;
			return r;
		}

		if (r.head.next == current) {// two nodes in the middle
			if ((char) r.head.data == (char) current.data) {
				r.result = true;
			} else {
				r.result = false;
			}
			return r;
		} else if (r.head == current.next) {// two element list
			if ((char) r.head.data == (char) current.data) {
				r.result = true;
			} else {
				r.result = false;
			}
			return r;
		}

		if ((char) r.head.data == (char) current.data) {// compare corresponding two elements
			r.head = r.head.next;
		} else {
			r.result = false;
		}

		return r;
	}

	private static class Result {
		Node head;
		Boolean result;
	}
}

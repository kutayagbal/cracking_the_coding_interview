package ch02_linked_lists.q6_palindrome;

import java.util.Stack;

import data_structures.SinglyLinkedList;
import data_structures.SinglyLinkedList.Node;

public class PalindromeSolution {

	public static void main(String[] args) {
		SinglyLinkedList list = createListFromString("abcdcba");
		list.printLinkedList();
		System.out.println(isPalindrome(list.head));

		int length = lengthOfList(list.head);
		System.out.println(isPalindromeRecursive(list.head, length).result);
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

	private static boolean isPalindrome(Node head) {
		Node fast = head;
		Node slow = head;

		Stack<Character> stack = new Stack<>();

		/*
		 * Push elements from first half of linked list onto stack. When fast runner
		 * (which is moving at 2x speed) reaches the end of the linked list, then we
		 * know we're at the middle
		 */

		while (fast != null && fast.next != null) {
			stack.push((char) slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		/* Has odd number of elements, so skip the middle element */
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			char top = stack.pop();

			/* If values are different, then it's not a palindrome */
			if (top != (char) slow.data) {
				return false;
			}

			slow = slow.next;
		}

		return true;
	}

	/*
	 * We pass length-2 as we recurse, one for front half element and one for back
	 * half element. So when length = 0 or 1 we are at the middle of the list
	 */
	
	/*
	 * res always returns the next of the previous res, so it always goes forward to
	 * the end of the list. But we start to return from the middle of the list. So
	 * call stack goes back from the middle.
	 */
	private static Result isPalindromeRecursive(Node node, int length) {
		if (node == null || length <= 0) { // Even number of nodes
			return new Result(node, true);
		} else if (length == 1) { // Odd number of nodes
			return new Result(node.next, true);
		}

		// Recurse on sublist
		Result res = isPalindromeRecursive(node.next, length - 2);

		/*
		 * If child calls are not a palindrome, pass back up a failure.
		 */

		if (!res.result || res.node == null) {
			return res;
		}

		/* Check if matches corresponding node on other side. */
		res.result = ((char) node.data == (char) res.node.data);

		/* Return corresponding node. */
		res.node = res.node.next;

		return res;
	}

	private static int lengthOfList(Node n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}

	private static class Result {
		public Node node;
		public boolean result;

		public Result(Node node, boolean result) {
			this.node = node;
			this.result = result;
		}
	}
}

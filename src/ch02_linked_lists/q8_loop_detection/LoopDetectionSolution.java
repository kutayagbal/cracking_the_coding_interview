package ch02_linked_lists.q8_loop_detection;

import data_structures.SinglyLinkedList;
import data_structures.SinglyLinkedList.Node;

public class LoopDetectionSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList list = LoopDetection.createLoopedLinkedList();

		Node detected = detectLoop(list.head);
		System.out.println("detected=" + (detected != null ? detected.data : "no loop"));
	}

	private static Node detectLoop(Node head) {
		Node slow = head;
		Node fast = head;

		/* Find meeting point. This will be LOOP_SIZE - k steps into the linked list. */
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (slow == fast)// Collision
				break;
		}

		/* Error check - no meeting point, and therefore no loop */
		if (fast == null || fast.next == null)
			return null;

		/*
		 * Move slow to Head. Keep fast at Meeting Point. Each are k steps from the Loop
		 * Start. If they move at the same pace, they must meet at Loop Start.
		 */
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		/* Both now point to the start of the loop. */
		return fast;
	}

}

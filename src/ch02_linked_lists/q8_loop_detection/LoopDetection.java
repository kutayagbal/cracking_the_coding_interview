package ch02_linked_lists.q8_loop_detection;

import data_structures.SinglyLinkedList;
import data_structures.SinglyLinkedList.Node;

public class LoopDetection {

	public static SinglyLinkedList createLoopedLinkedList() {
		SinglyLinkedList list = new SinglyLinkedList(10, 10);
		list.printLinkedList();
		
		Node loopStart = list.head;
		for (int i = 0; i < 2; i++) {
			loopStart = loopStart.next;
		}

		Node curr = list.head;
		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = loopStart;
		System.out.println("Loop start=" + loopStart.data);
		
		return list;
	}

	public static void main(String[] args) {
		SinglyLinkedList list = createLoopedLinkedList();

		Node detected = detectLoop(list.head);

		System.out.println("detected=" + (detected != null ? detected.data : "no loop"));
	}

	private static Node detectLoop(Node head) {
		Node fast = head;
		Node slow = head;

		do {
			if (fast.next == null || slow == null)
				return null;

			fast = fast.next.next;
			slow = slow.next;
		} while (fast != slow);

		while (slow != head) {
			slow = slow.next;
			head = head.next;
		}

		return head;
	}

}

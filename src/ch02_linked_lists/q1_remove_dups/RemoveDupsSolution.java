package ch02_linked_lists.q1_remove_dups;

import java.util.HashSet;
import java.util.Random;

public class RemoveDupsSolution {

	public static void main(String[] args) {
		LinkedListNode head = createSingleLinkedListWithRandomInt(10); 
		printLinkedList(head);
//		deleteDups(head);
		deleteDupsWithoutBuffer(head);
		printLinkedList(head);
	}
	
	public static void printLinkedList(LinkedListNode node) {
		while(node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println();
	}
	
	private static LinkedListNode createSingleLinkedListWithRandomInt(int size) {
		LinkedListNode head = new LinkedListNode(new Random().nextInt(10));
		LinkedListNode node = head;
		
		for(int i=1; i<size; i++) {
			node.next = new LinkedListNode(new Random().nextInt(10));
			node = node.next;
		}
		
		return head;
	}
	
	//O(N)
	//O(N)
	private static void deleteDups(LinkedListNode node) {
		LinkedListNode current = node;
		
		while(current != null) {
			//Remove all future nodes that have the same value.
			LinkedListNode runner = current;
			while(runner.next != null) {
				if(runner.next.data == current.data) {
					runner.next = runner.next.next;
				}else {
					runner = runner.next;
				}
			}
			
			current = current.next;
		}
	}
	//O(Nˆ2 / 2) = O(N)
	//O(1)
	private static void deleteDupsWithoutBuffer(LinkedListNode node) {
		HashSet<Integer> set = new HashSet<>();
		LinkedListNode previous = null;
		
		while(node != null) {
			if(set.contains(node.data)) {
				previous.next = node.next;
			}else {
				set.add(node.data);
				previous = node;
			}
			
			node = node.next;
		}
		
	}


	private static class LinkedListNode{
		LinkedListNode next;
		int data;
		
		public LinkedListNode(int data) {
			this.data = data;
		}
	}
}

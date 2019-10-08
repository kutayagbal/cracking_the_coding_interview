package ch02_linked_lists.q1_remove_dups;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RemoveDups {

	public static void main(String[] args) {
		Node head = createSingleLinkedListWithRandomInt(10);
		printLinkedList(head);
//		removeDups(head);
		removeDupsNoBuffer(head);
		printLinkedList(head);
	}
	
	private static void printLinkedList(Node head) {
		Node node = head;
		
		while(node != null) {
			System.out.print(node.data + ", ");
			node = node.next;
		}
		
		System.out.println();
	}
	
	private static Node createSingleLinkedListWithRandomInt(int size) {
		Node head = new Node(new Random().nextInt(11)); //0-10 inclusive random int
		Node node = head;
		for(int i=0; i<size-1; i++) {
			node.next = new Node(new Random().nextInt(11));
			node = node.next;
		}
		
		return head;
	}
	
	//O(nˆ2 / 2) = O(nˆ2)
	private static void removeDupsNoBuffer(Node node) {
		if (node == null || node.next == null)
			return;
		
		while(node != null) {
			Node runner = node.next;
			Node runnerPrev = node;
			while (runner != null) {
				if (node.data == runner.data) {
					runnerPrev.next = runner.next;
				}else {
					runnerPrev = runner;
				}
				
				runner = runner.next;
			}
			
			node = node.next;
		}
	}
	
	//O(N)
	private static void removeDups(Node head) {
		if (head == null || head.next == null)
			return;
		
		Map map = new HashMap<Integer,Integer>();
		Node node = head;
		Node prev = head;
		
		while(node != null) {
			if (map.get(node.data) != null) {
				prev.next = node.next;
			}else {
				map.put(node.data, 0);
				prev = node;
			}
			
			node = node.next;
		}
	}
	
	private static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
}

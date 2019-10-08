package ch02_linked_lists.q4_partition;

import java.util.Random;

public class Partititon {

	public static void main(String[] args) {
		Node head = createSinglyLinkedListWithRandomInt(10, 100);
		printSingleLinkedList(head);
		
		int part = 45;
		System.out.println("Partition " + part);
		head = partition(head, part);
		printSingleLinkedList(head);
	}
	
	private static Node createSinglyLinkedListWithRandomInt(int size, int bound) {
		Node head = new Node(new Random().nextInt(bound));
		Node node = head;
		for(int i=1; i<size; i++) {
			node.next = new Node(new Random().nextInt(bound));
			node = node.next;
		}
		
		return head;
	}
	
	private static void printSingleLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println();
	}
	
	//O(n)
	//O(1)
	private static Node partition(Node node, int x) {
		Node l1Head = null;
		Node l2Head = null;
		
		Node curr1 = null;
		Node curr2 = null;
		
		while(node != null) {
			if (node.data < x) {
				if(curr1 == null) {
					l1Head = node;
					curr1 = node;
				}else {
					curr1.next = node;
					curr1 = curr1.next;
				}
			}else {
				if(curr2 == null) {
					l2Head = node;
					curr2 = node;
				}else {
					curr2.next = node;
					curr2 = curr2.next;
				}
			}
			
			node = node.next;
		}
		
		curr1.next = l2Head;
		
		return l1Head;
	}
	
	private static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

}

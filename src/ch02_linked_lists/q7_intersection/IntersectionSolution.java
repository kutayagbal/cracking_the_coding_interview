package ch02_linked_lists.q7_intersection;

import data_structures.SinglyLinkedList;
import data_structures.SinglyLinkedList.Node;

public class IntersectionSolution {

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
		
		Node result = intersectionMySolution(list1.head, list2.head);
		System.out.println("result=" + (result !=null ? result.data: null));
		
		Node result2 = intersection(list1.head, list2.head);
		System.out.println("result=" + (result2 !=null ? result2.data: null));

	}
	
	//O(A+B)
	//O(1)
	private static Node intersection(Node node1, Node node2) {
		if(node1 == null || node2 == null) {
			return null;
		}
		
		/* Get tail and sizes. */
		Result result1 = getTailAndSize(node1);
		Result result2 = getTailAndSize(node2);
		
		/* If different tail nodes, then there's no intersection. */
		if(result1.tail != result2.tail) {
			return null;
		}
		
		/* Set pointers to the start of each linked list. */
		Node shorter = result1.size < result2.size ? node1 : node2;
		Node longer = result1.size < result2.size ? node2: node1;
		
		/* Advance the pointer for the longer linked list by difference in lengths. */
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
		/* Move both pointers until you have a collision. */
		while(shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		/* Return either one. */
		return longer;
		
	}
	
	private static Node getKthNode(Node node, int k) {
		while(k>0 && node != null) {
			node = node.next;
			k--;
		}
		
		return node;
	}

	private static Result getTailAndSize(Node node) {
		if(node == null) {
			return null;
		}
		
		int size = 1;
		
		while(node.next != null) {
			size++;
			node = node.next;
		}
		
		return new Result(size, node);
	}

	private static class Result{
		int size;
		Node tail;
		
		public Result(int size, Node tail) {
			this.size = size;
			this.tail = tail;
		}
	}

	private static Node intersectionMySolution(Node head1, Node head2) {
		Node curr1 = head1;
		Node curr2 = head2;

		while(curr1 != null && curr2 != null) {
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		
		Node bigHead = null;
		Node startOfSmall = null;
		int diff = 0;
		if(curr2 != null) {
			bigHead = head2;
			startOfSmall = head1;
			while(curr2 != null) {
				diff++;
				curr2 = curr2.next;
			}
		}else if(curr1 != null) {
			bigHead = head1;
			startOfSmall = head2;
			while(curr1 != null) {
				diff++;
				curr1 = curr1.next;
			}
		}
		
		Node startOfBig = bigHead;
		for(int i=0; i<diff; i++) {
			startOfBig = startOfBig.next;
		}
		
		while(startOfBig != null) {
			if(startOfBig == startOfSmall) {
				return startOfBig;
			}
			startOfSmall = startOfSmall.next;
			startOfBig = startOfBig.next;
		}
		
		return null;
	}
}

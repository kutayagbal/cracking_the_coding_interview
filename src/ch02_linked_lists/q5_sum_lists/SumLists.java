package ch02_linked_lists.q5_sum_lists;

import data_structures.SinglyLinkedList;
import data_structures.SinglyLinkedList.Node;

public class SumLists {

	public static void main(String[] args) {
		SinglyLinkedList list1 = new SinglyLinkedList(5, 10);
		list1.printLinkedList();
		SinglyLinkedList list2 = new SinglyLinkedList(3, 10);
		list2.printLinkedList();
		SinglyLinkedList result = sumLists(list1, list2);
		result.printLinkedList();
	}
	
	//O(max(n,m))
	//O(max(n,m))
	private static SinglyLinkedList sumLists(SinglyLinkedList list1, SinglyLinkedList list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;

		Node curr1 = list1.head;
		Node curr2 = list2.head;
		Node curr3 = null;
		Node resultHead = null;
		
		int extra = 0;
		int total = 0;
		while (curr1 != null && curr2 != null) {
			total = (int) curr1.data + (int) curr2.data + extra;
			
			if(curr3 != null) {
				curr3.next = new SinglyLinkedList.Node(total % 10);
				curr3 = curr3.next;
			}else{
				curr3 = new SinglyLinkedList.Node(total % 10);
				resultHead = curr3;
			}
			
			extra = total / 10;
			
			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		if (curr1 == null) {
			while (curr2 != null) {
				total = (int) curr2.data + extra;
				extra = total / 10;
				curr3.next = new SinglyLinkedList.Node(total % 10);
				curr3 = curr3.next;
				curr2 = curr2.next;
			}
		}
		
		if (curr2 == null) {
			while (curr1 != null) {
				total = (int)curr1.data + extra; 
				extra = total / 10;
				curr3.next = new SinglyLinkedList.Node(total % 10);
				curr3 = curr3.next;
				curr1 = curr1.next;
			}
		}
		
		return new SinglyLinkedList(resultHead);
	}

}

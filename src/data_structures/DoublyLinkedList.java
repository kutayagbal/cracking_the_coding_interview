package data_structures;

public class DoublyLinkedList<E> {
	public DoublyLinkedListNode<E> head;
	public DoublyLinkedListNode<E> tail;
	private int size;

	public DoublyLinkedList(DoublyLinkedListNode<E> head) {
		this.head = head;
		this.tail = this.head;
	}
	
	public int getSize() {
		return this.size;
	}

	public void printLinkedList() {
		DoublyLinkedListNode<E> node = head;
		while (node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println();
	}

	public static class DoublyLinkedListNode<E> {
		public E data;
		public DoublyLinkedListNode<E> next;
		public DoublyLinkedListNode<E> prev;

		public DoublyLinkedListNode(E data) {
			this.data = data;
		}
	}
}

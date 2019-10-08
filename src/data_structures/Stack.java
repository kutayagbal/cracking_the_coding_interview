package data_structures;

import java.util.EmptyStackException;

public class Stack<E> {
	private Node top;
	private int size = 0;
	
	public Stack() {}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return top.value;
	}
	
	public void push(E value) {
		Node node = new Node(value);
		node.below = top;
		top = node;
		size++;
	}
	
	public E pop() {
		if(isEmpty())
			throw new EmptyStackException();
		
		Node node = top;
		top = top.below;
		size--;
		return node.value;
	}
	
	
	public class Node {
		E value;
		private Node below;
		
		public Node(E value){
			this.value = value;
		}
	}
}

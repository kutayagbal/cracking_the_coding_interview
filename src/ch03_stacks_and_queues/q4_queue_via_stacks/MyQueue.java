package ch03_stacks_and_queues.q4_queue_via_stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyQueue<E> {
	private Stack<E> headStack;
	private Stack<E> tailStack;

	private enum stackType {
		HEAD, TAIL
	}

	public MyQueue() {
		this.tailStack = new Stack<>();
		this.headStack = new Stack<>();
	}

	public void add(E value) {
		if (headStack.isEmpty()) {
			tailStack.push(value);
		} else {
			pourTo(stackType.TAIL);
			tailStack.push(value);
		}
	}

	public E remove() {
		if (headStack.isEmpty()) {
			if (tailStack.isEmpty()) {
				throw new EmptyStackException();
			} else {
				pourTo(stackType.HEAD);
				return headStack.pop();
			}
		} else {
			return headStack.pop();
		}
	}
	
	public E peek() {
		if (headStack.isEmpty()) {
			if (tailStack.isEmpty()) {
				throw new EmptyStackException();
			} else {
				pourTo(stackType.HEAD);
				return headStack.peek();
			}
		} else {
			return headStack.peek();
		}
	}

	private void pourTo(stackType type) {
		if (type == stackType.HEAD) {
			while (!tailStack.isEmpty())
				headStack.push(tailStack.pop());
		} else {
			while (!headStack.isEmpty())
				tailStack.push(headStack.pop());
		}
	}

	public boolean isEmpty() {
		return tailStack.isEmpty() && headStack.isEmpty();
	}

	public int size() {
		return tailStack.size() + headStack.size();
	}
	
	public void print() {
		if(headStack.isEmpty()) {
			if(tailStack.isEmpty()) {
				System.out.println("empty queue");
				return;
			}
			
			pourTo(stackType.HEAD);
		}
		
		while(!headStack.isEmpty()) {
			E value = headStack.pop();
			System.out.print(value.toString() + ",");
			tailStack.push(value);
		}
		
		System.out.println();
	}

}

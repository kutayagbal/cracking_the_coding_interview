package ch03_stacks_and_queues.q4_queue_via_stacks.solution;

import java.util.Stack;

public class MyQueue<T> {
	Stack<T> stackNewest, stackOldest;

	public MyQueue() {
		stackNewest = new Stack<>();
		stackOldest = new Stack<>();
	}

	public int size() {
		return stackNewest.size() + stackOldest.size();
	}

	public void add(T value) {
		/* Push onto stackNewest, which always has the newest elements on top */
		stackNewest.push(value);
	}

	/*
	 * Move elements from stackNewest into stackOldest. This is usually done so that
	 * we can do operations on stackOldest.
	 */
	public T remove() {
		shiftStacks(); // Ensure stackOldest has the current elements
		return stackOldest.pop();
	}

	public T peek() {
		shiftStacks(); // Ensure stackOldest has the current elements
		return stackOldest.peek();
	}

	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public void print() {
		shiftStacks();
		if(stackOldest.isEmpty()) {
			System.out.println("empty queue");
			return;
		}
		
		while(!stackOldest.isEmpty()) {
			T value = stackOldest.pop();
			System.out.print(value.toString() + ",");
			stackNewest.push(value);
		}
		
		System.out.println();
	}

}

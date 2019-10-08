package ch03_stacks_and_queues.q3_stack_of_plates.solution;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	
	public Stack getLastStack() {
		if(stacks.size() == 0)
			return null;
		
		return stacks.get(stacks.size() - 1);
	}
	
	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}
	
	public int popAt(int index) {
		return leftShift(index, true);
	}
	
	public int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		
		int removedItem;
		
		if (removeTop)
			removedItem = stack.pop();
		else
			removedItem = stack.removeBottom();
		
		if(stack.isEmpty()) {
			stacks.remove(index);
		}else if(stacks.size() > index + 1){
			int v = leftShift(index+1, false);
			stack.push(v);
		}
		
		return removedItem;
		
	}

	public void push(int v) {
		Stack last = getLastStack();

		if (last != null && !last.isFull()) { // add to last stack
			last.push(v);
		} else { // must create new stack
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		if (last == null)
			throw new EmptyStackException();

		int v = last.pop();
		
		if (last.size == 0)
			stacks.remove(stacks.size() - 1);
		
		return v;
	}
	
	public void print() {
		int numOfStacks = stacks.size();
		if (numOfStacks == 0) {
			System.out.println("empty stack");
		}

		for (int i = 0; i < numOfStacks; i++) {
			Stack stack = stacks.get(i);
			System.out.print("s" + (i + 1) + ":");

			Node curr = stack.top;
			while (curr != null) {
				System.out.print(curr.value + ",");
				curr = curr.below;
			}

			System.out.println();
		}
		
		System.out.println();
	}
}

package ch03_stacks_and_queues.q3_stack_of_plates;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
	private List<Stack<Integer>> stacks;
	private int threshold;

	public SetOfStacks(int threshold) {
		this.threshold = threshold;
		stacks = new ArrayList<>();
	}

	public void push(int value) {
		if (stacks.size() == 0) {
			stacks.add(new Stack<>());
		}

		Stack<Integer> lastStack = stacks.get(stacks.size() - 1);
		if (lastStack.size() == threshold) {
			Stack<Integer> s = new Stack<>();
			s.push(value);
			stacks.add(s);
		} else {
			lastStack.push(value);
		}
	}

	public int pop() {
		int numOfStacks = stacks.size();
		if (numOfStacks == 0) {
			throw new EmptyStackException();
		}

		Stack<Integer> lastStack = stacks.get(numOfStacks - 1);
		int val = lastStack.pop();

		if (lastStack.size() == 0) {
			stacks.remove(numOfStacks - 1);
		}

		return val;
	}

	public int popAt(int stackNum) {
		int numOfStacks = stacks.size();
		if (stackNum > numOfStacks || stackNum < 1) {
			throw new EmptyStackException();
		}

		if (stackNum == numOfStacks) {
			return pop();
		}

		Stack<Integer> stack = stacks.get(stackNum - 1);

		int val = stack.pop();

		shiftStacks(stackNum);

		return val;
	}

	private void shiftStacks(int index) {
		int numOfStacks = stacks.size();

		Stack<Integer> temp = new Stack<>();
		for (int i = index; i < numOfStacks; i++) {
			Stack<Integer> stack = stacks.get(i);
			while (!stack.isEmpty()) {
				temp.push(stack.pop());
			}

			stacks.get(i - 1).push(temp.pop());

			while (!temp.isEmpty()) {
				stack.push(temp.pop());
			}
		}

		if (stacks.get(numOfStacks - 1).size() == 0) {
			stacks.remove(numOfStacks - 1);
		}
	}

	public void print() {
		int numOfStacks = stacks.size();
		if (numOfStacks == 0) {
			System.out.println("empty stack");
		}

		for (int i = 0; i < numOfStacks; i++) {
			Stack<Integer> stack = stacks.get(i);
			Stack<Integer> temp = new Stack<>();
			System.out.print("s" + (i + 1) + ":");

			while (!stack.isEmpty()) {
				int val = stack.pop();
				System.out.print(val + ",");
				temp.push(val);
			}

			while (!temp.isEmpty()) {
				stack.push(temp.pop());
			}

			System.out.println();
		}
		
		System.out.println();
	}

}

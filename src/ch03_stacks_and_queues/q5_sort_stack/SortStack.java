package ch03_stacks_and_queues.q5_sort_stack;

import java.util.Random;
import java.util.Stack;

public class SortStack {
	static int size = 10;
	static int bound = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> s = createRandomIntStack(size, bound);
		printStack(s);
		s = sort(s);
		printStack(s);
	}

	public static void printStack(Stack<Integer> s) {
		Stack<Integer> temp = new Stack<>();
		while (!s.isEmpty()) {
			int val = s.pop();
			System.out.print(val + ",");
			temp.push(val);
		}

		while (!temp.isEmpty()) {
			s.push(temp.pop());
		}

		System.out.println();
	}

	public static Stack<Integer> createRandomIntStack(int size, int bound) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < size; i++) {
			stack.push(new Random().nextInt(bound));
		}

		return stack;
	}

	private static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> temp = new Stack<Integer>();

		temp.push(s.pop());

		while (!s.isEmpty()) {
			int value = s.pop();
			if (value <= temp.peek()) {
				temp.push(value);
			} else {
				putRightPlaceInTemp(value, s, temp);
			}
		}

		return temp;
	}

	private static void putRightPlaceInTemp(int val, Stack<Integer> s, Stack<Integer> temp) {
			s.push(temp.pop());
			int counter = 1;
			
			if(!temp.isEmpty()) {
				while (!temp.isEmpty() && temp.peek() < val) {
					s.push(temp.pop());
					counter++;
				}
			}
			
			temp.push(val);
			
			for (int i = 0; i < counter; i++) {
				temp.push(s.pop());
			}
	}
}

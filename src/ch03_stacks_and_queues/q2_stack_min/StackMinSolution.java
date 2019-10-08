package ch03_stacks_and_queues.q2_stack_min;

import java.util.Random;
import java.util.Stack;

public class StackMinSolution {

	public static void main(String[] args) {
		StackWithMin2 stack = new StackWithMin2();

		for (int i = 0; i < 10; i++) {
			int val = new Random().nextInt(20);
			stack.push(val);
			System.out.print("push="+ val);
			System.out.println(" min=" + stack.min());
		}

		for (int i = 0; i < 10; i++) {
			int val  = stack.pop();
			System.out.print("pop="+ val);
			System.out.println(" min=" + stack.min());
		}
	}

	private static class StackWithMin extends Stack<NodeWithMin> {
		public void push(int value) {
			int newMin = Math.min(value, min());
			super.push(new NodeWithMin(value, newMin));
		}

		public int min() {
			if (this.isEmpty()) {
				return Integer.MAX_VALUE; // Error value
			}

			return this.peek().min;
		}
	}

	private static class NodeWithMin {
		public int value;
		public int min;

		public NodeWithMin(int v, int min) {
			this.value = v;
			this.min = min;
		}
	}

	/*
	 * There's just one issue with above solution: if we have a large stack, we
	 * waste a lot of space by keeping track of the min for every single element. We
	 * can do better with another stack for min values.
	 */

	private static class StackWithMin2 extends Stack<Integer> {
		private static Stack<Integer> s2;

		public StackWithMin2() {
			this.s2 = new Stack<Integer>();
		}

		public void push(int value) {
			if (value < min()) {
				s2.push(value);
			}

			super.push(value);
		}

		public Integer pop() {
			int value = super.pop();
			if (value == min()) { // If two integer is have same value. They reference the same memory location.
				s2.pop();
			}

			return value;
		}

		public int min() {
			if (s2.isEmpty()) {
				return Integer.MAX_VALUE;
			}

			return s2.peek();
		}
	}
}

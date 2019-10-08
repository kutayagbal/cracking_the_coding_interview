package ch03_stacks_and_queues.q1_three_in_one;

public class ThreeInOne {

	public static void main(String[] args) {
		ThreeStack stack = new ThreeStack(10);

		for (int i = 0; i < 30; i++) {
			stack.push(i % 3, i);
		}

		stack.print();
	}

	private static class ThreeStack {
		int numberOfStacks = 3;
		static int stackCapacity;
		static int[] values;
		static int[] sizes;

		public ThreeStack(int stackSize) {
			stackCapacity = stackSize;
			values = new int[stackSize * numberOfStacks];
			sizes = new int[numberOfStacks];
		}

		// push onto stack
		public static void push(int stackNum, int value) {
			/* Check that we have space for the next element */
			if (isFull(stackNum)) {
				System.out.println(stackNum + ". stack is full");
				return;
			}

			/* Increment stack pointer and then update top value. */
			sizes[stackNum]++;
			values[indexOfTop(stackNum)] = value;
		}

		/* Pop item from top stack. */
		public static int pop(int stackNum) {
			if (isEmpty(stackNum)) {
				System.out.println(stackNum + ". stack is empty");
			}

			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex]; // Get top
			values[topIndex] = 0; // Clear
			sizes[stackNum]--; // Shrink
			return value;
		}

		/* Return top element. */
		public int peek(int stackNum) {
			if (isEmpty(stackNum)) {
				System.out.println(stackNum + ". stack is empty");
				return 0;
			}

			return values[indexOfTop(stackNum)];
		}

		/* Return if stack is empty. */
		public static boolean isEmpty(int stackNum) {
			return sizes[stackNum] == 0;
		}

		/* Return if stack is full. */
		public static boolean isFull(int stackNum) {
			return sizes[stackNum] == stackCapacity;
		}

		/* Returns index of the top of the stack. */
		private static int indexOfTop(int stackNum) {
			int offset = stackCapacity * stackNum;
			int size = sizes[stackNum];
			return offset + size - 1;
		}

		public static void print() {
			for (int i = 0; i < values.length; i++) {
				System.out.print(values[i] + ",");
				if ((stackCapacity - 1) == i || 2 * stackCapacity - 1 == i) {
					System.out.println();
				}
			}
		}
	}
}

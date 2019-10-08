package ch03_stacks_and_queues.q5_sort_stack;

import java.util.Stack;

public class SortStackSolution {

	/*
	 * If we were allowed to use unlimited stacks, we could implement a modified
	 * quicksort or mergesort. With the mergesort solution, we would create two
	 * extra stacks and divide the stack into two parts. We would recursively sort
	 * each stack, and then merge them back together in sorted order into the
	 * original stack. Note that this would require the creation of two additional
	 * stacks per level of recursion. With the quicksort solution, we would create
	 * two additional stacks and divide the stack into the two stacks based on a
	 * pivot element. The two stacks would be recursively sorted, and then merged
	 * back together into the original stack. Like the earlier solution, this one
	 * involves creating two additional stacks per level of recursion.
	 */
	
	public static void main(String[] args) {
		Stack<Integer> s = SortStack.createRandomIntStack(10, 10);
		SortStack.printStack(s);
		sort(s);
		SortStack.printStack(s);
	}

	//O(nˆ2)
	//O(n)
	private static void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		
		while(!s.isEmpty()) {
			/* Insert each element in s in sorted order into r. */
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			
			r.push(tmp);
		}
		
		/* Copy the elements from r back into s. */
		while(!r.isEmpty()) {
			s.push(r.pop());
		}
	}
}

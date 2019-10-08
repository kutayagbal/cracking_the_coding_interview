package ch03_stacks_and_queues.q3_stack_of_plates.solution;

public class StackOfPlates {

	public static void main(String[] args) {
		SetOfStacks s = new SetOfStacks(5);
		
		for(int i=0; i< 53; i++) {
			s.push(i);
		}
		
		s.print();
		
		s.pop();
		s.pop();
		s.popAt(3);
		
		s.print();
	}

}

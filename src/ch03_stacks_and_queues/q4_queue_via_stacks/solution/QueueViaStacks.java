package ch03_stacks_and_queues.q4_queue_via_stacks.solution;

public class QueueViaStacks {

	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<>();
		for(int i=0; i< 10; i++) {
			q.add(i);
		}
		
		System.out.println(q.peek());
		
		q.print();
		
		q.remove();
		q.remove();
		
		System.out.println(q.peek());
		
		q.print();

	}

}

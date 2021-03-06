package ch03_stacks_and_queues.q3_stack_of_plates.solution;

public class Stack {
	private int capacity;
	public Node top, bottom;
	public int size = 0;
	
	public Stack(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public void join(Node above, Node below) {
		if(below != null)
			below.above = above;
		
		if(above != null)
			above.below = below;
	}
	
	
	public boolean push(int v) {
		if(size >= capacity)
			return false;
		
		size++;
		
		Node n = new Node(v);
		
		if(size == 1)
			bottom = n;
		
		join(n, top);
		
		top = n;
		
		return true;
	}
	
	public int pop() {
		Node t = top; // t references top's reference
		top = top.below; // top references new place, but t continues to reference to top's old reference place.
		size--;
		return t.value;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		
		if(bottom != null)
			bottom.below = null;
		
		size--;
		return b.value;
	}
	
}

package ch03_stacks_and_queues.q2_stack_min;

import java.util.Random;

public class StackMin {

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		
		for(int i= 0; i<10; i++) {
			stack.push(new Random().nextInt(20));
			System.out.print("min=" + stack.min().data + " stack:");
			stack.print();
		}
		
		for(int i= 0; i<10; i++) {
			stack.pop();
			if(stack.min() != null) {
			System.out.print("min=" + stack.min().data + " stack:");
			stack.print();
			}
		}
	}

	private static class MinStackNode{
		private MinStackNode min;
		private int data;
		private MinStackNode next;
		
		
		public MinStackNode(int data) {
			this.data = data;
		}
	}
	
	private static class MinStack{
		private static MinStackNode top;
		
		//O(1)
		public static void push(int data) {
			MinStackNode node = new MinStackNode(data);
			
			if(top == null) {
				node.min = node;
				top = node;
			}else {
				if (data < top.min.data) {
					node.min = node;
				}else {
					node.min = top.min;
				}
				
				node.next = top;
				top = node;
			}
		}
		
		//O(1)
		public static int pop() {
			if(top == null) {
				System.out.println("empty stack");
				return -1;
			}
			
			int data = top.data;
			
			top = top.next;
			
			return data;
		}
		
		//O(1)
		public static MinStackNode min() {
			if(top== null) {
				return null;
			}
			return top.min;
		}
		
		public static void print() {
			MinStackNode node = top;
			while(node != null) {
				System.out.print(node.data + ",");
				node = node.next;
			}
			
			System.out.println();
		}
	}
}

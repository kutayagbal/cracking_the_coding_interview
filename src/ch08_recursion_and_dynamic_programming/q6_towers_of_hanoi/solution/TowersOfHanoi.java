package ch08_recursion_and_dynamic_programming.q6_towers_of_hanoi.solution;

import java.util.ArrayList;
import java.util.Stack;

public class TowersOfHanoi {

	public static void main(String[] args) {
		int n = 4;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}

		for (int i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}

		towers[0].print();

		towers[0].moveDisks(n, towers[2], towers[1]);

		towers[2].print();
	}

	private static class Tower {
		private int index;
		private Stack<Integer> disks;

		public Tower(int i) {
			index = i;
			disks = new Stack<>();
		}

		public int index() {
			return index;
		}

		public void add(int d) {
			if (!disks.isEmpty() && disks.peek() <= d) {
				System.out.println("Error placing disk " + d);
			} else {
				disks.push(d);
			}
		}

		public void moveToTop(Tower t) {
			int topDisk = disks.pop();
			t.add(topDisk);
		}

		public void moveDisks(int n, Tower destination, Tower buffer) {
			if (n > 0) {
				moveDisks(n - 1, buffer, destination);
				System.out.println("move "+ disks.peek() +" from " + index + " to " + destination.index);
				moveToTop(destination);
				buffer.moveDisks(n - 1, destination, this);
			}
		}

		public void print() {
			System.out.println();
			System.out.println("Tower_" + index);

			ArrayList<Integer> temp = new ArrayList<>();
			int stackSize = disks.size();
			for (int i = 0; i < stackSize; i++) {
				int top = disks.pop();
				System.out.println(top);
				temp.add(top);
			}

			for (int i = temp.size() - 1; i >= 0; i--) {
				disks.push(temp.get(i));
			}

			System.out.println();
		}
	}

}

package ch08_recursion_and_dynamic_programming.q13_stack_of_boxes.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class StackOfBoxes {

	public static void main(String[] args) {
		int n = 20;
		ArrayList<Box> boxes = createRandomBoxes(n);

		System.out.println("Max Height: " + createStack(boxes));
	}

	private static int createStack(ArrayList<Box> boxes) {
		Collections.sort(boxes, new BoxComparator());

		int maxHeight = 0;
		int[] stackMap = new int[boxes.size()];
		for (int i = 0; i < boxes.size(); i++) {
			int height = createStack(boxes, i, stackMap);
			maxHeight = Math.max(maxHeight, height);
		}

		return maxHeight;
	}

	private static int createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap) {
		if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
			return stackMap[bottomIndex];
		}

		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;
		for (int i = bottomIndex + 1; i < boxes.size(); i++) {
			if (boxes.get(i).canBeAbove(bottom)) {
				int height = createStack(boxes, i, stackMap);
				maxHeight = Math.max(height, maxHeight);
			}
		}

		maxHeight += bottom.height;
		stackMap[bottomIndex] = maxHeight;
		return maxHeight;
	}

	private static ArrayList<Box> createRandomBoxes(int n) {
		ArrayList<Box> boxes = new ArrayList<>();
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			boxes.add(new Box(rnd.nextInt(100), rnd.nextInt(100), rnd.nextInt(100)));
		}

		return boxes;
	}

	static class Box implements Comparable<Box> {
		int height;
		int width;
		int depth;

		public Box(int h, int w, int d) {
			height = h;
			width = w;
			depth = d;
		}

		@Override
		public int compareTo(Box b) {
			if (this.height > b.height)
				return 1;
			else if (this.height == b.height)
				return 0;
			else
				return -1;
		}

		public boolean canBeAbove(Box b) {
			return this.width < b.width && this.depth < b.depth;
		}
	}

	static class BoxComparator implements Comparator<Box> {

		@Override
		public int compare(Box x, Box y) {
			return y.height - x.height;
		}

	}

}

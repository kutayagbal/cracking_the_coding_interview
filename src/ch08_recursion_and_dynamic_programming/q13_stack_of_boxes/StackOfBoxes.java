package ch08_recursion_and_dynamic_programming.q13_stack_of_boxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class StackOfBoxes {

	public static void main(String[] args) {
		int n = 20;
		ArrayList<Box> boxes = createRandomBoxes(n);

		System.out.println("Max Height: " + createStack(boxes));
	}

	private static void print(ArrayList<Box> boxes) {
		Box b = null;
		for (int i = 0; i < boxes.size(); i++) {
			b = boxes.get(i);
			System.out.println(i + " ===> h=" + b.height + ", w=" + b.width + ", d=" + b.depth);
		}
		System.out.println();
	}

	private static int createStack(ArrayList<Box> boxes) {
		Collections.sort(boxes);// sorted by height
		Collections.reverse(boxes);// descending order
		print(boxes);

		int maxHeight = 0;
		for (int i = 0; i < boxes.size(); i++) {
			Box below = boxes.get(i);
			int height = below.height;
			System.out.print(i + ", ");
			for (int j = i + 1; j < boxes.size(); j++) {
				if (canBePutOn(below, boxes.get(j))) {
					height += boxes.get(j).height;
					System.out.print(j + ", ");
					below = boxes.get(j);
				}
			}
			System.out.print("==> " + height);
			System.out.println();
			if (height > maxHeight)
				maxHeight = height;
		}

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

	private static boolean canBePutOn(Box below, Box above) {
		return below.depth > above.depth && below.width > above.width;
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
	}
}

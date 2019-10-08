package ch06_math_and_logic_puzzles.q9_poison;

import java.util.ArrayList;
import java.util.Random;

public class Poison {

	public static void main(String[] args) {
		ArrayList<Strip> stripList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			stripList.add(new Strip());
		}

		// drop bottles to strips
		for (int i = 0; i < 1000; i++) {
			int bottleNum = i;
			int digitCounter = 0;

			while (bottleNum != 0) {
				if ((bottleNum & 1) == 1) {
					// drop this bottle to this strip
					stripList.get(digitCounter).bottles.add(bottleNum);
				}

				digitCounter++;
				bottleNum = bottleNum >> 1;
			}
		}

		// set positive randomly
		for (int i = 0; i < stripList.size(); i++) {
			Strip s = stripList.get(i);
			s.isPositive = new Random().nextBoolean();
			if (s.isPositive)
				System.out.println("Strip " + i + " is positive");
		}

		// find poisoned bottle
		int poisonedIndex = 0;
		for (int i = 0; i < stripList.size(); i++) {
			if (stripList.get(i).isPositive) {
				poisonedIndex += Math.pow(2, i);
			}
		}

		System.out.println("bottle " + poisonedIndex + " is poisoned");
	}

	public static class Strip {
		public ArrayList<Integer> bottles = new ArrayList<>();
		public boolean isPositive;
	}
}

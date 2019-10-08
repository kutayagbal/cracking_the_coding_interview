package ch06_math_and_logic_puzzles.q9_poison.solution;

import java.util.ArrayList;
import java.util.Random;

public class Poison {

	public static void main(String[] args) {
		System.out.println(findPoisonedBottle(createRandomOnePoisonedBottles(), createStrips()));
	}

	private static ArrayList<Bottle> createRandomOnePoisonedBottles() {
		ArrayList<Bottle> bottles = new ArrayList<>();
		int poisonIndex = new Random().nextInt(1000);
		System.out.println("Poisoned bottle = " + poisonIndex);
		for (int i = 0; i < 1000; i++) {
			Bottle b = new Bottle(i);
			if (i == poisonIndex) {
				b.setPoisoned(true);
			}
			bottles.add(b);
		}

		return bottles;
	}

	private static ArrayList<TestStrip> createStrips() {
		ArrayList<TestStrip> strips = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			strips.add(new TestStrip(i));
		}

		return strips;
	}

	private static int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
		runTests(bottles, strips);
		ArrayList<Integer> positive = getPositiveOnDay(strips, 7);
		return setBits(positive);
	}

	/* Add bottle contents to test strips */
	private static void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
		for (Bottle bottle : bottles) {
			int id = bottle.getId();
			int bitIndex = 0;
			while (id > 0) {
				if ((id & 1) == 1) {
					strips.get(bitIndex).addDropOnDay(0, bottle);
				}

				bitIndex++;
				id >>= 1;
			}
		}
	}

	/* Get test strips that are positive on a particular day. */
	private static ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> strips, int day) {
		ArrayList<Integer> positive = new ArrayList<>();

		for (TestStrip strip : strips) {
			int id = strip.getId();
			if (strip.isPositiveOnDay(day)) {
				positive.add(id);
			}
		}

		return positive;
	}

	/* Create number by setting bits with indices specified in positive. */
	private static int setBits(ArrayList<Integer> positive) {
		int id = 0;
		for (Integer bitIndex : positive) {
			id |= 1 << bitIndex;
		}

		return id;
	}
}

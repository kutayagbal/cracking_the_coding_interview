package ch06_math_and_logic_puzzles.q9_poison.solution;

import java.util.ArrayList;

public class TestStrip {
	public static int DAYS_FOR_RESULT = 7;
	private ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<>();
	private int id;

	public TestStrip(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	/* Add drop from bottle on specific day. */
	public void addDropOnDay(int day, Bottle bottle) {
		sizeDropsForDay(day);
		ArrayList<Bottle> drops = dropsByDay.get(day);
		drops.add(bottle);
	}

	/* Resize list of days/drops to be large enough. */
	private void sizeDropsForDay(int day) {
		while (dropsByDay.size() <= day) {
			dropsByDay.add(new ArrayList<Bottle>());
		}
	}

	/* Checks for poisoned bottles since before DAYS_FOR_RESULT */
	public boolean isPositiveOnDay(int day) {
		int testDay = day - DAYS_FOR_RESULT;
		if (testDay < 0 || testDay >= dropsByDay.size()) {
			return false;
		}

		for (int d = 0; d <= testDay; d++) {
			ArrayList<Bottle> bottles = dropsByDay.get(d);
			if (hasPoison(bottles)) {
				return true;
			}
		}

		return false;
	}

	private boolean hasPoison(ArrayList<Bottle> bottles) {
		for (Bottle b : bottles) {
			if (b.isPoisoned())
				return true;
		}

		return false;
	}
}

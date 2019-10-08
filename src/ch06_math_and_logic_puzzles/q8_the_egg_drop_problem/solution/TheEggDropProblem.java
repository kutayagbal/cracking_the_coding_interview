package ch06_math_and_logic_puzzles.q8_the_egg_drop_problem.solution;

public class TheEggDropProblem {

	private static int breakingPoint = 25;
	private static int countDrops = 0;

	public static void main(String[] args) {
		System.out.println("floor Count=" + 100);
		System.out.println("breaking point=" + breakingPoint);
		findBreakingPoint(100);
		System.out.println("drop count=" + countDrops);
	}

	private static boolean drop(int floor) {
		countDrops++;
		return floor >= breakingPoint;
	}

	private static int findBreakingPoint(int floors) {
		int interval = 14;
		int previousFloor = 0;
		int egg1 = interval;

		/* Drop egg1 at decreasing intervals. */
		while (!drop(egg1) && egg1 <= floors) {
			interval -= 1;
			previousFloor = egg1;
			egg1 += interval;
		}

		/* Drop egg2 at 1 unit increments. */
		int egg2 = previousFloor + 1;
		while (egg2 < egg1 && egg2 <= floors && !drop(egg2)) {
			egg2 += 1;
		}

		return egg2 > floors ? -1 : egg2;
	}
}

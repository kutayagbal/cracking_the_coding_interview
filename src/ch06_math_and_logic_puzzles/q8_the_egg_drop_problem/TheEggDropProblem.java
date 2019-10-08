package ch06_math_and_logic_puzzles.q8_the_egg_drop_problem;

public class TheEggDropProblem {

	public static void main(String[] args) {
		int floorCount = 100;
		int breakingPoint = 25;
		System.out.println("floor Count=" + floorCount);
		System.out.println("breaking point=" + breakingPoint);
		System.out.println("drop count=" + calculateDropCount(floorCount, breakingPoint));
	}

	private static int calculateDropCount(int floorCount, int breakingPoint) {
		int startFloor = 0;
		for (int i = 0; i < floorCount; i++) {
			if (i * (i + 1) > 2 * floorCount) {
				startFloor = i;
				break;
			}
		}

		int dropCount = 0;
		int currentFloor = startFloor;
		int interval = startFloor;

		dropCount++;// firstDrop

		while (currentFloor < breakingPoint) {
			dropCount++;
			interval--;
			currentFloor += interval;
		}

		currentFloor = currentFloor - interval + 1;
		while (currentFloor < breakingPoint) {
			dropCount++;
			currentFloor++;
		}

		return dropCount + 1;

	}

}

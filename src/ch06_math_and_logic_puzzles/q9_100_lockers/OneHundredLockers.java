package ch06_math_and_logic_puzzles.q9_100_lockers;

public class OneHundredLockers {

	public static void main(String[] args) {

		int openCount = 0;
		for (int i = 2; i <= 100; i++) {
			if (calculateFactorCount(i) % 2 == 0)
				openCount++;
		}

		System.out.println(openCount + 1); //one for first door
	}

	private static int calculateFactorCount(int num) {
		int factorCount = 0;
		for (int i = 2; i <= num; i++) {
			if (num % i == 0)
				factorCount++;
		}

		return factorCount;
	}

}

package ch06_math_and_logic_puzzles.q7_the_apocalypse;

import java.util.Random;

public class TheApocalypse {

	public static void main(String[] args) {
		System.out.println(calculateGenderRate(15000));
	}

	private static double calculateGenderRate(int familyCount) {
		double mailCount = 0;
		double femailCount = 0;

		for (int i = 0; i < familyCount; i++) {
			boolean isFemail = new Random().nextBoolean();
			if (isFemail) {
				femailCount++;
			} else {
				mailCount++;
				while (!isFemail) {
					isFemail = new Random().nextBoolean();
					if (isFemail) {
						femailCount++;
					} else {
						mailCount++;
					}
				}
			}
		}

		return mailCount / femailCount;

	}

}

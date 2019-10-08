package ch06_math_and_logic_puzzles.q7_the_apocalypse.solution;

import java.util.Random;

public class TheApocalypse {

	public static void main(String[] args) {
		System.out.println(runNFamilies(1500));
	}

	private static double runNFamilies(int n) {
		int boys = 0;
		int girls = 0;

		for (int i = 0; i < n; i++) {
			int[] genders = runOneFamily();
			girls += genders[0];
			boys += genders[1];
		}

		return girls / (double) (girls + boys);

	}

	private static int[] runOneFamily() {
		Random random = new Random();
		int boys = 0;
		int girls = 0;

		while (girls == 0) {
			if (random.nextBoolean()) { // girl
				girls += 1;
			} else { // boy
				boys += 1;
			}
		}

		int[] genders = { girls, boys };
		return genders;

	}
}

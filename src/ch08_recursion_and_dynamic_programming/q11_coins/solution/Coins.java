package ch08_recursion_and_dynamic_programming.q11_coins.solution;

public class Coins {

	public static void main(String[] args) {
		System.out.println(makeChange(30));
	}

	private static int makeChange(int n) {
		int[] denoms = { 25, 10, 5, 1 };
		int[][] map = new int[n + 1][denoms.length];// precomputed vals
		return makeChange(n, denoms, 0, map);
	}

	private static int makeChange(int amount, int[] denoms, int index, int[][] map) {
		if (map[amount][index] > 0) {
			return map[amount][index];
		}

		if (index >= denoms.length - 1)
			return 1; // retrieve value

		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			// go to next denom, assuming i coins of denomAmount
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1, map);
		}
		
		map[amount][index] = ways;
		return ways;
	}

}

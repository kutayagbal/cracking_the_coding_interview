package ch08_recursion_and_dynamic_programming.q1_triple_step.solution;

import java.util.Arrays;

public class TripleStep {

	public static void main(String[] args) {
		int totalSteps = 40;
		System.out.println("Total steps=" + totalSteps + " possible ways=" + countWaysMemo(totalSteps));
	}

	public static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}

	public static int countWaysMemo(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countWaysMemo(n, memo);
	}

	private static int countWaysMemo(int n, int[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] != -1) {
			return memo[n];
		} else {
			memo[n] = countWaysMemo(n - 1, memo) + countWaysMemo(n - 2, memo) + countWaysMemo(n - 3, memo);
			return memo[n];
		}
	}
}

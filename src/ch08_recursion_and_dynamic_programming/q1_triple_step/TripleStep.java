package ch08_recursion_and_dynamic_programming.q1_triple_step;

public class TripleStep {

	public static void main(String[] args) {
		int totalSteps = 40;
		System.out.println("Total steps=" + totalSteps + " possible ways=" + jump(totalSteps));
	}

	public static int jump(int remainingSteps) {
		int[] memo = new int[remainingSteps + 1];
		memo[0] = 1;
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		return jump(remainingSteps, memo);
	}

	public static int jump(int remainingSteps, int[] memo) {
		if (memo[remainingSteps] != 0)
			return memo[remainingSteps];

		memo[remainingSteps] = jump(remainingSteps - 1, memo) + jump(remainingSteps - 2, memo)
				+ jump(remainingSteps - 3, memo);

		return memo[remainingSteps];
	}

}

package ch08_recursion_and_dynamic_programming.q14_boolean_evaluation.solution;

import java.util.HashMap;

public class BooleanEvaluation {

	public static void main(String[] args) {
		System.out.println(countEval("0&0&0&1^1|0", true));
		System.out.println(countEvalMemo("0&0&0&1^1|0", true, new HashMap<String, Integer>()));
	}

	private static int countEval(String s, boolean result) {
		if (s.length() == 0)
			return 0;
		if (s.length() == 1)
			return stringToBool(s) == result ? 1 : 0;

		int ways = 0;
		for (int i = 1; i < s.length(); i += 2) {
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());

			/* Evaluate each side for each result */
			int leftTrue = countEval(left, true);
			int leftFalse = countEval(left, false);
			int rightTrue = countEval(right, true);
			int rightFalse = countEval(right, false);

			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

			int totalTrue = 0;
			if (c == '^') {// required: one true and one false
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (c == '&') {// required: both true
				totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {// required: anything but both false
				totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
			}

			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}

		return ways;
	}

	private static int countEvalMemo(String s, boolean result, HashMap<String, Integer> memo) {
		if (s.length() == 0)
			return 0;
		if (s.length() == 1)
			return stringToBool(s) == result ? 1 : 0;

		if (memo.containsKey(result + s))
			return memo.get(result + s);

		int ways = 0;
		for (int i = 1; i < s.length(); i += 2) {
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());

			int leftTrue = countEvalMemo(left, true, memo);
			int leftFalse = countEvalMemo(left, false, memo);
			int rightTrue = countEvalMemo(right, true, memo);
			int rightFalse = countEvalMemo(right, false, memo);

			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

			int totalTrue = 0;
			if (c == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (c == '&') {
				totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {
				totalTrue = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
			}

			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}

//		System.out.println(s + " = " + result);
		memo.put(result + s, ways);

		return ways;
	}

	private static boolean stringToBool(String c) {
		return c.equals("1") ? true : false;
	}

}

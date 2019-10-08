package ch08_recursion_and_dynamic_programming.q7_permutations_without_dups.solution;

import java.util.ArrayList;

public class PermutationsWithoutDups {

	public static void main(String[] args) {
		String s = "abc";
		ArrayList<String> perm = getPerms(s);

		for (String str : perm) {
			System.out.println(str);
		}
	}

	private static ArrayList<String> getPerms(String remainder) {
		int len = remainder.length();
		ArrayList<String> result = new ArrayList<>();

		/* Base Case */
		if (len == 0) {
			result.add(""); // Be sure to return empty string!
			return result;
		}

		for (int i = 0; i < remainder.length(); i++) {
			/* Remove char i and find permutations of remaining chars. */
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			ArrayList<String> partials = getPerms(before + after);

			/* Prepend char i to each permutation. */
			for (String s : partials) {
				result.add(remainder.charAt(i) + s);
			}
		}

		return result;
	}
}

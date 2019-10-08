package ch08_recursion_and_dynamic_programming.q7_permutations_without_dups;

import java.util.ArrayList;

public class PermutationsWithoutDups {

	public static void main(String[] args) {
		String s = "abc";
		ArrayList<String> perm = permutation(s);

		for (String str : perm) {
			System.out.println(str);
		}
	}

	private static ArrayList<String> permutation(String s) {
		ArrayList<String> result = new ArrayList<>();
		if (s.length() == 2) {
			result.add(String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(1)));
			result.add(String.valueOf(s.charAt(1)) + String.valueOf(s.charAt(0)));
			return result;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			String charExcludedString = null;
			if (i + 1 < s.length())
				charExcludedString = s.substring(0, i) + s.substring(i + 1, s.length());
			else
				charExcludedString = s.substring(0, i);

			ArrayList<String> partialResult = permutation(charExcludedString);
			for (int j = 0; j < partialResult.size(); j++) {
				result.add(String.valueOf(c) + partialResult.get(j));
			}
		}

		return result;
	}

}

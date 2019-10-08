package ch08_recursion_and_dynamic_programming.q8_permutations_with_duplicates;

import java.util.ArrayList;
import java.util.HashSet;

public class PermutationsWithDuplicates {

	public static void main(String[] args) {
		String s = "dddaasda";
		ArrayList<String> result = perm(s);

		System.out.println(result.size());
		for (String str : result) {
			System.out.println(str);
		}
	}

	public static ArrayList<String> perm(String s) {
		ArrayList<String> result = new ArrayList<>();
		if (s.length() == 2) {
			char ch0 = s.charAt(0);
			char ch1 = s.charAt(1);
			if (ch0 == ch1) {
				result.add(String.valueOf(ch0) + String.valueOf(ch1));
				return result;
			} else {
				result.add(String.valueOf(ch0) + String.valueOf(ch1));
				result.add(String.valueOf(ch1) + String.valueOf(ch0));
			}
		}

		HashSet<Character> processedChars = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (processedChars.contains(c)) {
				continue;
			} else {
				processedChars.add(c);
			}

			String pref = s.substring(0, i);
			String suff = "";

			if (i + 1 < s.length())
				suff = s.substring(i + 1);

			ArrayList<String> partialPerm = perm(pref + suff);

			for (String partial : partialPerm) {
				result.add(String.valueOf(c) + partial);
			}
		}

		return result;
	}

}

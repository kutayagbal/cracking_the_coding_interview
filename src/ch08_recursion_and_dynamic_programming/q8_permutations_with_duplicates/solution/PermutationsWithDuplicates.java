package ch08_recursion_and_dynamic_programming.q8_permutations_with_duplicates.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PermutationsWithDuplicates {

	public static void main(String[] args) {
		String s = "dddaasda";
		ArrayList<String> result = printPerms(s);

		System.out.println(result.size());
		for (String str : result) {
			System.out.println(str);
		}
	}

	private static ArrayList<String> printPerms(String s) {
		ArrayList<String> result = new ArrayList<>();
		Map<Character, Integer> map = buildFreqTable(s);
		printPerms(map, "", s.length(), result);
		return result;
	}

	private static Map<Character, Integer> buildFreqTable(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}

		return map;
	}

	private static void printPerms(Map<Character, Integer> map, String prefix, int remaining,
			ArrayList<String> result) {
		/* Base case. Permutation has been completed. */
		if (remaining == 0) {
			result.add(prefix);
			return;
		}

		/* Try remaining letters for next char, and generate remaining permutations. */
		for (Character c : map.keySet()) {
			int count = map.get(c);

			if (count > 0) {
				map.put(c, count - 1);
				printPerms(map, prefix + c, remaining - 1, result);
				map.put(c, count);
			}
		}
	}

}

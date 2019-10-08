package ch01_arrays_and_strings.q2_check_permutation;

import java.util.Arrays;

public class CheckPermutationSolution {

	public static void main(String[] args) {
		System.out.println(checkPermutation("awsdfgh", "gfsahxd"));
	}

	// time comp = O(n + m) space comp = O(1)
	private static boolean checkPermutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] letters = new int[128]; // Assumption

		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			letters[c]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;

			if (letters[c] < 0) {//this check is sufficient because if one element remains positive, another element will be negative for same size strings. 
				return false;
			}
		}
		
		return true;
	}
	
	//O(2.n.log(n)) = O(n.log(n))
	//Space O(n/2) = O(n)
	@SuppressWarnings("unused")
	private static boolean checkPermBySort(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		return sort(s).equals(sort(t));
	}
	
	private static String sort(String s) {
		char[] s_array = s.toCharArray();
		Arrays.sort(s_array);
		return s_array.toString();
	}
}

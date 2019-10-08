package ch01_arrays_and_strings.q4_palindrome_permutation;

public class PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(isPalindrome("Tact Coa"));
	}
	
	//O(n + n) = O(n)
	//O(n)
	private static boolean isPalindrome(String s) {
		int[] charset = new int[127];
		
		String lowercase_str = s.toLowerCase();
		
		int oddCharNum = 0;
		for(char c : lowercase_str.toCharArray()) {
			if (c == ' ') {
				continue;
			}
			
			int ascii = (int)c;
			charset[ascii] += 1;
			
			if (charset[ascii] % 2 != 0){
				oddCharNum += 1;
			}else {
				oddCharNum -= 1;
			}
		}
		
		if (oddCharNum > 1){
			return false;
		}else {
			return true;
		}
	}
}

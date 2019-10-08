package ch01_arrays_and_strings.q2_check_permutation;

public class CheckPermutation {

	public static void main(String[] args) {
		System.out.println(checkPermutation("asdfgh","gfsahd"));
	}

	//time comp = O(n + m) space comp = O(1)
	private static boolean checkPermutation(String str1, String str2) {
		if (str1 == null || str1.length() == 0){
			if(str2 == null || str2.length() == 0) {
				return true;
			}else {
				return false;
			}
		}else {
			if(str2 == null || str2.length() == 0){
				return false;
			}
		}
		
		if (str1.length() != str2.length())
			return false;
		
		int[] charset = new int[128];
		
		for(int i=0; i<str1.length(); i++) {
			int ascii = (int) str1.charAt(i);
			charset[ascii] += 1;
		}
		
		for(int i=0; i<str2.length(); i++) {
			int ascii = (int) str2.charAt(i);
			charset[ascii] -= 1;
		}
		
		for(int val : charset) {
			if(val != 0) {
				return false;
			}
		}
		
		return true;
	}

	
}

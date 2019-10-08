package ch01_arrays_and_strings.q5_one_away;

public class OneAway {

	public static void main(String[] args) {
		System.out.println(checkOneWay("pale","bae"));
	}

	private static boolean checkOneWay(String str1, String str2) {
		if (str1.length() == str2.length()) {
			return checkDiffOneChar(str1, str2);
		}else {
			if (str1.length() == str2.length() + 1){
				return checkDiffOneBig(str1, str2);
			}else if (str2.length() == str1.length() + 1){
				return checkDiffOneBig(str2, str1);
			}
		}
		
		return false;
	}

	//O(n)
	//O(1)
	private static boolean checkDiffOneBig(String str1, String str2) {
		boolean found = false;
		for(int i=0; i<str1.length(); i++) {
			if (found) {
				if(str1.charAt(i) != str2.charAt(i-1)) {
					return false;
				}
			}else {
				if(i == str2.length()) {
					found = true;
				}else {
					if(str1.charAt(i) != str2.charAt(i)) {
						found = true;
					}
				}
			}
		}
		
		return true;
	}

	//O(n)
	//O(1)
	private static boolean checkDiffOneChar(String str1, String str2) {
		boolean found = false;
		for(int i=0; i<str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				if (found) {
					return false;
				}
				
				found = true;
			}
		}
		
		return true;
	}
}

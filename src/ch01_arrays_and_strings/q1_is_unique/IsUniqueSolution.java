package ch01_arrays_and_strings.q1_is_unique;

public class IsUniqueSolution {

	public static void main(String[] args) {
		System.out.println(isUniqueChars("qwertyuioasdfghjkl"));
	}

	public static boolean isUniqueChars(String str) {
		if (str.length() > 128)
			return false;
		
		boolean[] char_set = new boolean[128];
		
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {// Already found this char in string
				return false;
			}
			char_set[val] = true;
		}
		
		return true;
	}
	
	//boolean 1 byte bit vector 1 bit. 8 times space efficient
	public static boolean isUniqueCharsBitVector(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}

			checker |= (1 << val);
		}
		return true;
	}
}

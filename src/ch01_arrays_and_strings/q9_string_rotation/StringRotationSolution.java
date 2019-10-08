package ch01_arrays_and_strings.q9_string_rotation;

public class StringRotationSolution {

	public static void main(String[] args) {
		System.out.println(isRotation("watwatwatwitwat", "watwatwitwatwat"));
	}

	//O(n.m) because of isSubstring method
	private static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		// Check that sl and s2 are equal length and not empty
		if(len == s2.length() && len > 0) {
			//Concatenate s1 and s1 within new buffer
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		
		return false;
	}
	
	//O(n.m)
	private static boolean isSubstring(String s1, String s2) {
		return s1.indexOf(s2) != -1;
	}

}

package ch01_arrays_and_strings.q6_string_compression;

public class StringCompressionSolution {

	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
	}

	private static String compress(String s) {
		int finalLength = countCompression(s);
		
		if(finalLength >= s.length()) {
			return s;
		}
		
		StringBuilder compressed = new StringBuilder(finalLength);
		int countConsecutive = 0;
		
		for(int i=0; i<s.length(); i++) {
			countConsecutive++;
			
			if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
				compressed.append(s.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		
		return compressed.toString();
	}

	private static int countCompression(String s) {
		int compressedLength = 0;
		int countConsecutive = 0;
		
		for(int i=0; i<s.length(); i++) {
			countConsecutive++;
			
			if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		
		return compressedLength;
	}
}

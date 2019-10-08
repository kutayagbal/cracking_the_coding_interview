package ch01_arrays_and_strings.q6_string_compression;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress("aabcccccaaa"));
	}

	//O(n)
	//O(n)
	private static String compress(String str) {
		if (str == null || str.length() < 3) {
			return str;
		}
		
		StringBuffer buf = new StringBuffer();
		char current = str.charAt(0);
		int count = 1;
		for(int i = 1; i<str.length(); i++) {
			if (str.charAt(i) == current) {
				count++;
			}else {
				buf.append(current);
				buf.append(count);
				current = str.charAt(i);
				count = 1;
			}
		}
		
		buf.append(current);
		buf.append(count);
		
		String compressed = buf.toString();
		if (str.length() <= compressed.length()) {
			return str;
		}
		
		return compressed;
	}

}

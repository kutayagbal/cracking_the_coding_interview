package ch01_arrays_and_strings.q3_urlify;

public class URLify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(urlify("Mr John Smith    "));
	}

	//T = O(n)
	//S = O(n)	
	private static String urlify(String s) {
		if (s == null || s.length() == 0)
			return "empty";

		char[] s_arr = s.toCharArray();

		StringBuffer buf = new StringBuffer();
		boolean wasBlank = false;
		for (char c : s_arr) {
			if (c == ' ') {
				wasBlank = true;
				continue;
			} else {
				if (wasBlank) {
					wasBlank = false;
					buf.append("%20");
					buf.append(c);
				}else {
					buf.append(c);
				}
			}
		}

		return buf.toString();
	}
}

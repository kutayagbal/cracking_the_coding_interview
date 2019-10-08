package ch01_arrays_and_strings.q1_is_unique;

public class IsUnique {
	static String s = "qwertyuiopasdfghjkl;zxcvbnm,.";

	//(n-1) + (n-2) + (n-3) + ... + 1 = k.(k+1) / 2 = (n-1)(n-1+1)/2 = n(n-1)/2 => O(nˆ2)
	//O(1) space
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		if (s == null || s.length() == 0 ) {
			System.out.println("empty");
			return;
		}
		
		for(int i=0; i < s.length(); i++) {
			Character c = s.charAt(i);
			
			for(int j=i + 1; j<s.length(); j++) {
				if (c.equals(s.charAt(j))) {
					System.out.println("not unique");
					return;
				}
			}
		}
		
		System.out.println("all unique");
		System.out.println("O(nˆ2) = " + (System.currentTimeMillis() - start));
	}
	
	//O(n) with O(1) space
	public static void main2(String[] args) {
		long start = System.currentTimeMillis();
		if(s == null || s.length() == 0) {
			System.out.println("empty");
			return;
		}
		
		int[] chars = new int[128];//ascii codes 0 - 127
		
		for(int i=0; i<s.length(); i++) {
			int asciiCode =(int) s.charAt(i); //***cast char to int to get ascii code
			
			if (chars[asciiCode] == 1) {
				System.out.println("not unique");
				return;
			}else {
				chars[asciiCode] = 1;
			}
		}
		
		System.out.println("all unique");
		System.out.println("O(n) = " + (System.currentTimeMillis() - start));
	}
}

package ch05_bit_manipulation.q6_conversion;

public class Conversion {

	public static void main(String[] args) {
		System.out.println(howMayFlipToConvert(15, 29));
	}

	private static int howMayFlipToConvert(int a, int b) {
		int c = a ^ b;
		
		int counter = 0;
		while(c != 0) {
			if((c & 1) == 1)
				counter++;
			
			c = c >> 1;
		}
		
		return counter;
	}

}

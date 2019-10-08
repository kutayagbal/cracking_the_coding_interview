package ch05_bit_manipulation.q6_conversion.solution;

public class Conversion {

	public static void main(String[] args) {
		System.out.println(bitSwapRequired(15, 29));
	}

	/*
	 * Rather than simply shifting c repeatedly while checking the least significant
	 * bit, we can continuously flip the least significant bit and count how long it
	 * takes c to reach 0. The operation c = c & (c - 1) will clear the least
	 * significant bit in c.
	 */
	private static int bitSwapRequired(int a, int b) {
		int count = 0;

		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}

		return count;
	}
}

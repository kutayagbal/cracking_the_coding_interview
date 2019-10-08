package ch05_bit_manipulation.q4_next_number.solution;

public class NextNumber {

	public static void main(String[] args) {
		int num = 13961;// 13955, 13962
		System.out.println(num);
		System.out.println(getNext(num));
		System.out.println(getPrev(num));
	}

	private static int getNext(int n) {
		/* Compute c0 and c1 */
		int c = n;
		int c0 = 0;
		int c1 = 0;

		while (((c & 1) == 0) && c != 0) {
			// count rightmost zeros
			c0++;
			c >>= 1;
		}

		while ((c & 1) == 1) {
			c1++; // count ones after rightmost zeros
			c >>= 1;
		}

		/*
		 * Error: if n == 11..1100...00, then there is no bigger number with the same
		 * number of 1s.
		 */
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}

		int p = c0 + c1; // position of rightmost non-trailing zero

		n |= (1 << p); // Flip rightmost non-trailing zero

		n &= ~((1 << p) - 1); // Clear all bits to the right of p
		
		n |= (1 << (c1 - 1)) - 1; // Insert (cl-1) ones on the right.

		return n;
	}
	
	private static int getPrev(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		while ((c & 1) == 1) {
			c1++; // count rightmost ones
			c >>= 1;
		}
		
		if(c == 0)
			return -1;
		
		while (((c & 1) == 0) && c != 0) {
			// count zeros after rightmost ones
			c0++;
			c >>= 1;
		}
		
		int p = c0 + c1; // position of rightmost non-trailing ones

		n &= ((~0) << (p + 1)); //clears from bit p onwards
		
		int mask = (1 << (c1 + 1)) - 1; //sequence of (c1 + 1) ones
		
		n |= mask << (c0 - 1);
		
		return n;
	}

}

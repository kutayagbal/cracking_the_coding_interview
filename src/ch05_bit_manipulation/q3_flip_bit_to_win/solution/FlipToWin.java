package ch05_bit_manipulation.q3_flip_bit_to_win.solution;

public class FlipToWin {

	public static void main(String[] args) {
		int num = 177895;
		System.out.println(flipBits(num));
	}

	public static int flipBits(int a) {
		/* If all ls, this is already the longest sequence. */
		if (~a == 0)
			return Integer.BYTES * 8;

		int currentLenght = 0;
		int previousLength = 0;
		int maxLength = 1; // We can always have a sequence of at least one 1

		while (a != 0) {
			if ((a & 1) == 1) { // Current bit is a 1
				currentLenght++;
			} else if ((a & 1) == 0) { // Current bit is a 0
				/* Update to 0 (if next bit is 0) or currentlength (if next bit is 1). */
				previousLength = (a & 2) == 0 ? 0 : currentLenght;
				currentLenght = 0;
			}

			maxLength = Math.max(maxLength, previousLength + currentLenght + 1);
			a >>>= 1;
		}

		return maxLength;
	}
}

package ch05_bit_manipulation.q3_flip_bit_to_win;

public class FlipBitToWin {

	public static void main(String[] args) {
		int num = 177895;
		System.out.println(findMaxSequence(num));
	}

	// O(n)
	// O(1)
	public static int findMaxSequence(int num) {
		num = Math.abs(num);

		if (num == 0)
			return 1;

		int max = 0;
		int curr = 0;
		boolean isPrevZero = false;
		while (num > 0) {
			int digit = num % 2;

			if (digit == 0) {
				if (isPrevZero) {
					max = Math.max(max, curr);
					curr = 0;
					isPrevZero = false;
				} else {
					isPrevZero = true;
				}
			} else {
				curr++;
			}

			num = num >> 1;
		}

		return max + 1;
	}

}

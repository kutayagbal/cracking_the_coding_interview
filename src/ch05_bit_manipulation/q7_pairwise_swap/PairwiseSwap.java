package ch05_bit_manipulation.q7_pairwise_swap;

public class PairwiseSwap {

	public static void main(String[] args) {
		System.out.println(swapEvenOdd(8));
	}

	private static int swapEvenOdd(int num) {
		int index = 0;

		int result = 0;
		int curr = 0;
		int prev = 0;

		while (num != 0) {
			curr = num & 1;
			if (index % 2 == 1) {
				result += prev * Math.pow(2, index); // for prev to current
				result += curr * Math.pow(2, index - 1); // for current to prev
			}

			prev = curr;

			num = num >> 1;
			index++;
		}

		if (index % 2 == 1) {//unswapped first digit
			result += prev * Math.pow(2, index); // for prev to current
		}

		return result;
	}
}

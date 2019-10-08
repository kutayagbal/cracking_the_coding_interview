package ch05_bit_manipulation.q7_pairwise_swap.solution;

public class PairwiseSwap {

	public static void main(String[] args) {
		System.out.println(swapOddEvenBits(5));
	}

	/*
	 * We can approach this as operating on the odd bits first, and then the even
	 * bits. Can we take a number n and move the odd bits over by 1? Sure. We can
	 * mask all odd bits with 10101010 in binary (which is 0xAA), then shift them
	 * right by 1 to put them in the even spots. For the even bits, we do an
	 * equivalent operation. Finally, we merge these two values.
	 */
	private static int swapOddEvenBits(int x) {
		/*
		 * Note that we use the logical right shift, instead of the arithmetic right
		 * shift. This is because we want the sign bit to be filled with a zero.
		 */
		return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
	}

}

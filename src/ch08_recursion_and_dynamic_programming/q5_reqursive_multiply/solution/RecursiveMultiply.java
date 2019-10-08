package ch08_recursion_and_dynamic_programming.q5_reqursive_multiply.solution;

public class RecursiveMultiply {

	public static void main(String[] args) {
		System.out.println(minProductWithCache(17, 23));
		System.out.println(minProduct(17, 23));
	}

	public static int minProduct(int a, int b) {
		int bigger = a > b ? a : b;
		int smaller = a > b ? b : a;

		return minProductHelper(smaller, bigger);
	}

	// O(log(s)) s=smaller
	private static int minProductHelper(int smaller, int bigger) {
		if (smaller == 0)
			return 0;
		else if (smaller == 1)
			return bigger;

		int s = smaller >> 1; // Divide by 2
		int halfProd = minProductHelper(s, bigger);

		if (smaller % 2 == 0) {
			return halfProd + halfProd;
		} else {
			return halfProd + halfProd + bigger;
		}

	}

	public static int minProductWithCache(int a, int b) {
		int bigger = a > b ? a : b;
		int smaller = a > b ? b : a;

		int[] memo = new int[smaller + 1];
		return minProductWithCache(smaller, bigger, memo);
	}

	private static int minProductWithCache(int smaller, int bigger, int[] memo) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		} else if (memo[smaller] > 0) {
			return memo[smaller];
		}

		/* Compute half. If uneven, compute other half. If even, double it. */
		int s = smaller >> 1; // Divide by 2
		int side1 = minProductWithCache(s, bigger, memo);

		int side2 = side1;
		if (smaller % 2 == 1) {
			side2 = minProductWithCache(smaller - s, bigger, memo);
		}

		/* Sum and cache */
		memo[smaller] = side1 + side2;
		return memo[smaller];
	}

}

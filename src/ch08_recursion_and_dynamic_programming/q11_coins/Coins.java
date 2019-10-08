package ch08_recursion_and_dynamic_programming.q11_coins;

public class Coins {

	public static void main(String[] args) {
		System.out.println(howManyWays(30));
	}

	// wrong
	private static int howManyWays(int n) {
		if (n < 5) {
			return 1;
		} else if (n >= 5 && n < 10) {
			return 2;
		} else if (n >= 10 && n < 25) {
			int countOf10s = n / 10;
			int remainder = n % 10;
			return countOf10s * (howManyWays(5) + howManyWays(5)) + howManyWays(remainder) + 1;
		} else {
			int countOf25s = n / 25;
			int remainder = n % 25;
			return countOf25s * (howManyWays(10) + howManyWays(10) + howManyWays(5)) + howManyWays(remainder) + 1;
		}
	}

}

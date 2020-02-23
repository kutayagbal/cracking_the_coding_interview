package ch13_java.q7_lambda_expressions.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

	public static void main(String[] args) {
		List<Country> arr = new ArrayList<>();
		Country c;
		for (int i = 0; i < 10; i++) {
			if (i % 3 == 0)
				c = new Country("America", i);
			else
				c = new Country("Europe", i);
			arr.add(c);
		}

		System.out.println(totalPop(arr, "America"));
		System.out.println(totPopWithStream(arr, "America"));
		System.out.println(totalPop(arr, "Europe"));
		System.out.println(totPopWithStream(arr, "Europe"));
	}

	public static int totalPop(List<Country> countries, String continent) {
		/*
		 * First, we use filter to get a list of the countries in the specified
		 * continent.
		 */
		Stream<Country> americas = countries.stream().filter(country -> {
			return country.getContinent().equals(continent);
		});

		/* Second, we convert this into a list of populations using map */
		Stream<Integer> populations = americas.map(c -> c.getPop());

		/* Third and finally, we compute the sum using reduce */
		int population = populations.reduce(0, (a, b) -> a + b);

		return population;
	}

	/*
	 * We can actually remove filter entirely. We can map the wrong countries
	 * populations to zero
	 */
	public static int totPopWithStream(List<Country> countries, String continent) {
		Stream<Integer> populations = countries.stream().map(c -> c.getContinent().equals(continent) ? c.getPop() : 0);
		return populations.reduce(0, (a, b) -> a + b);
	}

}

class Country {
	String continent;
	int population;

	public Country(String c, int p) {
		continent = c;
		population = p;
	}

	String getContinent() {
		return continent;
	}

	int getPop() {
		return population;
	}
}
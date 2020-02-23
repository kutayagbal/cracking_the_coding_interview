package ch13_java.q7_lambda_expressions;

import java.util.ArrayList;
import java.util.List;

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
		int tot = 0;

		for (Country c : countries) {
			if (continent.equals(c.getContinent()))
				tot += c.getPop();
		}

		return tot;
	}

	public static int totPopWithStream(List<Country> countries, String continent) {
		return countries.stream().filter(c -> c.getContinent().equals(continent)).mapToInt(c -> c.getPop()).sum();
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

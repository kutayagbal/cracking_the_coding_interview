package ch13_java.q8_lambda_random.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		List<Integer> subset = getRandomSubset(list);

		subset.stream().forEach(e -> System.out.print(e + ", "));
	}

	static List<Integer> getRandomSubset(List<Integer> list) {
		Random random = new Random();
		List<Integer> subset = list.stream().filter(e -> {
			return random.nextBoolean(); // flip coin
		}).collect(Collectors.toList());

		return subset;
	}

	static List<Integer> getRandomSubsetWithPredicate(List<Integer> list) {
		Random random = new Random();
		Predicate<Object> flipCoin = o -> {
			return random.nextBoolean();
		};

		List<Integer> subset = list.stream().filter(flipCoin).collect(Collectors.toList());
		return subset;
	}

}

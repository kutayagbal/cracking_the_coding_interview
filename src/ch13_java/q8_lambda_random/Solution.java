package ch13_java.q8_lambda_random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		List<Integer> randomSubset = getRandomSet(list);
		randomSubset.forEach(e -> System.out.print(e + ", "));
	}

	public static List<Integer> getRandomSet(List<Integer> list) {
		List<List<Integer>> subsets = getSubsetLists(list);
		int index = new Random().nextInt(subsets.size());
		return subsets.get(index);
	}

	public static List<List<Integer>> getSubsetLists(List<Integer> list) {
		List<List<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<>()); // empty subset

		List<List<Integer>> newSubsets;
		for (Integer x : list) {
			newSubsets = new ArrayList<>();
			newSubsets.addAll(subsets); // add all till now

			List<Integer> newSubset;
			for (List<Integer> subset : subsets) {
				newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(x);
				newSubsets.add(newSubset);
			}

			subsets = newSubsets;
		}

		return subsets;
	}
}

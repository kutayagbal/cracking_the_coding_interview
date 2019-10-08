package ch08_recursion_and_dynamic_programming.q4_power_set.solution;

import java.util.ArrayList;

public class PowerSet {

	public static void main(String[] args) {
		ArrayList<Integer> elements = new ArrayList<>();
		elements.add(1);
		elements.add(2);
		elements.add(3);
		elements.add(4);

		ArrayList<ArrayList<Integer>> subSets = getSubsets(elements, 0);

		for (ArrayList<Integer> subSet : subSets) {
			System.out.print("(");
			for (Integer subSetElem : subSet) {
				System.out.print(subSetElem + ",");
			}
			System.out.print("), ");
		}

		System.out.println();
		subSets = getSubsets2(elements);

		for (ArrayList<Integer> subSet : subSets) {
			System.out.print("(");
			for (Integer subSetElem : subSet) {
				System.out.print(subSetElem + ",");
			}
			System.out.print("), ");
		}
	}

	// O(n.2^n)
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubSets;

		if (set.size() == index) {// Base case - add empty set
			allSubSets = new ArrayList<>();
			allSubSets.add(new ArrayList<>()); // Empty set
		} else {
			allSubSets = getSubsets(set, index + 1);

			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<>();
			for (ArrayList<Integer> subSet : allSubSets) {
				ArrayList<Integer> newSubSet = new ArrayList<>();
				newSubSet.addAll(subSet);
				newSubSet.add(item);
				moreSubSets.add(newSubSet);
			}

			allSubSets.addAll(moreSubSets);
		}

		return allSubSets;
	}

	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<>();
		int max = 1 << set.size(); // Compute 2^n
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subSet = convertIntToSet(k, set);
			allSubSets.add(subSet);
		}

		return allSubSets;
	}

	public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subSet = new ArrayList<>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subSet.add(set.get(index));
			}

			index++;
		}

		return subSet;
	}

}

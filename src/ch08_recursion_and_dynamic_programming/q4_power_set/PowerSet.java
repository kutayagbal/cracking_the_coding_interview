package ch08_recursion_and_dynamic_programming.q4_power_set;

import java.util.ArrayList;

public class PowerSet {

	public static void main(String[] args) {
		ArrayList<Integer> elements = new ArrayList<>();
		elements.add(1);
		elements.add(2);
		elements.add(3);
		elements.add(4);

		ArrayList<ArrayList<Integer>> subSets = new ArrayList<>();
		getAllSubSets(elements, subSets);

		for (ArrayList<Integer> subSet : subSets) {
			System.out.print("(");
			for (Integer subSetElem : subSet) {
				System.out.print(subSetElem + ",");
			}
			System.out.print("), ");
		}
	}

	private static void getAllSubSets(ArrayList<Integer> initialSet, ArrayList<ArrayList<Integer>> result) {
		for (int elem : initialSet) {
			result.addAll(getSubSetsForElement(elem, (ArrayList<ArrayList<Integer>>) result.clone()));
		}
	}

	private static ArrayList<ArrayList<Integer>> getSubSetsForElement(int elem,
			ArrayList<ArrayList<Integer>> prevElemSets) {
		ArrayList<ArrayList<Integer>> addtionalSets = new ArrayList<>();

		for (ArrayList<Integer> prevElem : prevElemSets) {
			ArrayList<Integer> additional = new ArrayList<>();
			additional.addAll(prevElem);
			additional.add(elem);
			addtionalSets.add(additional);
		}

		if (addtionalSets.size() == 0) {
			addtionalSets.add(new ArrayList<>());
			ArrayList<Integer> list = new ArrayList<>();
			list.add(elem);
			addtionalSets.add(list);
		}

		return addtionalSets;
	}

}

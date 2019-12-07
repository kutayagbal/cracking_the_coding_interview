package ch10_sorting_and_searching.q4_sorted_search_no_size.solution;

import java.util.Arrays;
import java.util.List;

public class SortedSearchNoSize {

	public static void main(String[] args) {
		Integer[] arr = { 1, 3, 4, 7, 7, 9, 12, 19 };
		List<Integer> listy = Arrays.asList(arr);

		int x = 18;
		System.out.println(search(listy, x));
	}

	private static int search(List<Integer> listy, int value) {
		int index = 1;
		int elem = 0;

		while (elem != -1 && elem < value) {
			try {
				System.out.println("looking: " + index);
				elem = listy.get(index);
				index *= 2;
			} catch (Exception e) {
				elem = -1;
			}
		}

		return binarySearch(listy, value, index / 2, index);
	}

	private static int binarySearch(List<Integer> listy, int value, int low, int high) {
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			int middle;
			try {
				middle = listy.get(mid);
			} catch (Exception e) {
				middle = -1;
			}

			if (middle > value || middle == -1) {
				high = mid - 1;
			} else if (middle < value) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}

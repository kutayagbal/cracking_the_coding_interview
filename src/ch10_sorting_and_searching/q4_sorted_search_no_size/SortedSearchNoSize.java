package ch10_sorting_and_searching.q4_sorted_search_no_size;

import java.util.Arrays;
import java.util.List;

public class SortedSearchNoSize {

	public static void main(String[] args) {
		Integer[] arr = { 1, 3, 4, 7, 7, 9, 12, 19 };

		List<Integer> listy = Arrays.asList(arr);

		int x = 18;
		int length = findLength(listy, x);

		System.out.println(binarySearch(listy, 0, length - 1, x));
	}

	private static int binarySearch(List<Integer> listy, int left, int right, int x) {
		if (left > right)
			return -1;

		int mid = (left + right) / 2;

		if (listy.get(mid) < x) {
			return binarySearch(listy, mid + 1, right, x);
		} else if (listy.get(mid) > x) {
			return binarySearch(listy, left, mid - 1, x);
		} else {
			return mid;
		}
	}

	private static int findLength(List<Integer> listy, int x) {
		int jump = 1;
		int index = 0;
		int length = -1;
		boolean isExeeded = false;

		while (length < 0) {
			if (jump < 1)
				length = index + 1;

			try {
				isExeeded = false;
				System.out.println("index: " + index + ", jump: " + jump + ", looking: " + (index + jump));
				listy.get(index + jump);
			} catch (Exception e) {
				isExeeded = true;
			}

			if (isExeeded) {
				jump /= 2;
			} else {
				index = index + jump;
				jump *= 2;
			}
		}

		return length;
	}

}

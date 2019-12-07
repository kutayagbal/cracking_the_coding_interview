package ch10_sorting_and_searching.q5_sparse_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class SparseSearch {

	public static void main(String[] args) {
		String s = "ab";

		String[] strs = createRandomSortedStrArr(20, 6);

		Stream.of(strs).forEach(e -> System.out.print(e + ","));
		System.out.println();

		System.out.println(search(strs, s));

	}

	private static int search(String[] arr, String s) {
		return binarySearch(arr, s, 0, arr.length - 1);
	}

	private static int binarySearch(String[] arr, String s, int left, int right) {
		if (left > right)
			return -1;

		int mid = (left + right) / 2;

		while (mid > 0 && arr[mid].equals("")) {
			mid--;
		}

		if (mid < left) {
			return -1;
		}

		String str = arr[mid];

		if (s.compareTo(str) > 0) {
			while (mid < right && arr[mid].equals("")) {
				mid++;
			}

			if (mid > right)
				return -1;

			return binarySearch(arr, s, mid + 1, right);
		} else if (s.compareTo(str) < 0) {
			return binarySearch(arr, s, left, mid - 1);
		} else {
			return mid;
		}
	}

	private static String[] createRandomSortedStrArr(int arrSize, int strSize) {
		List<String> list = new ArrayList<>();
		StringBuffer buf = null;
		for (int i = 0; i < arrSize; i++) {
			int size = new Random().nextInt(strSize - 1) + 1;

			buf = new StringBuffer();
			for (int j = 0; j < size; j++) {
				if (new Random().nextBoolean()) {
					buf.append('a');
				} else {
					buf.append('b');
				}
			}

			list.add(buf.toString());
		}

		Collections.sort(list);

		for (int i = 0; i < arrSize; i++) {
			int blankSize = new Random().nextInt(strSize);

			for (int j = 0; j < blankSize; j++)
				list.add(i + 1, "");

			i += blankSize;
		}

		return list.toArray(new String[list.size()]);
	}

}

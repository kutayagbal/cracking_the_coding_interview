package ch10_sorting_and_searching.q5_sparse_search.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class SparseSearch {

	public static void main(String[] args) {
		String str = "abb";

		String[] strings = createRandomSortedStrArr(20, 6);

		Stream.of(strings).forEach(e -> System.out.print(e + ","));
		System.out.println();

		System.out.println(search(strings, str));
	}

	private static int search(String[] strings, String str) {
		if (strings == null || str == null || str.isEmpty())
			return -1;

		return search(strings, str, 0, strings.length - 1);
	}

	private static int search(String[] strings, String str, int first, int last) {
		if (first > last)
			return -1;

		// Move mid to the middle
		int mid = (first + last) / 2;

		// If mid is empty, find closest nonempty string
		if (strings[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;

			while (true) {
				if (left < first && right > last) {
					return -1;
				} else if (right <= last && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= first && !strings[left].isEmpty()) {
					mid = left;
					break;
				}

				left--;
				right++;
			}
		}

		// Check for string, and recurse if necessary
		if (str.equals(strings[mid])) { // Found it
			return mid;
		} else if (str.compareTo(strings[mid]) < 0) { // Search left
			return search(strings, str, first, mid - 1);
		} else { // Search right
			return search(strings, str, mid + 1, last);
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

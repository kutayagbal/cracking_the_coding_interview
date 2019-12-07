package ch10_sorting_and_searching.q2_group_anagrams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] arr = createRandomStringArray(20, 10);
		Stream.of(arr).forEach(e -> System.out.print(e + ", "));

		groupAnagrams(arr);

		System.out.println();
		Stream.of(arr).forEach(e -> System.out.print(e + ", "));
	}

	public static void groupAnagrams(String[] arr) {
		Arrays.sort(arr, new AnagramComparator());
	}

	private static String[] createRandomStringArray(int arrSize, int maxStrSize) {
		String[] arr = new String[arrSize];
		for (int i = 0; i < arrSize; i++) {
			int strSize = new Random().nextInt(maxStrSize - 1) + 1;

			StringBuffer buf = new StringBuffer();
			for (int j = 0; j < strSize; j++) {
				boolean b = new Random().nextBoolean();
				if (b) {
					buf.append('a');
				} else {
					buf.append('b');
				}
			}

			arr[i] = buf.toString();
		}

		return arr;
	}

}

class AnagramComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		char[] arr1 = o1.toCharArray();
		Arrays.sort(arr1);
		String s1 = new String(arr1);

		char[] arr2 = o2.toCharArray();
		Arrays.sort(arr2);
		String s2 = new String(arr2);

		return s1.compareTo(s2);
	}

}

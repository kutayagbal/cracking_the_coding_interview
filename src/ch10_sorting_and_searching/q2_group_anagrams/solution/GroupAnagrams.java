package ch10_sorting_and_searching.q2_group_anagrams.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import data_structures.HashMapList;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] arr = createRandomStringArray(20, 10);
		Stream.of(arr).forEach(e -> System.out.print(e + ", "));

		groupAnagrams(arr);

		System.out.println();
		Stream.of(arr).forEach(e -> System.out.print(e + ", "));
	}

	private static void groupAnagrams(String[] arr) {
		HashMapList<String, String> mapList = new HashMapList<>();

		// Group words by anagram
		for (String s : arr) {
			String key = sortChars(s);
			mapList.put(key, s);
		}

		// Convert hashmap to array
		int index = 0;
		for (String key : mapList.keySet()) {
			ArrayList<String> list = mapList.get(key);

			for (String s : list) {
				arr[index] = s;
				index++;
			}
		}

	}

	private static String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
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
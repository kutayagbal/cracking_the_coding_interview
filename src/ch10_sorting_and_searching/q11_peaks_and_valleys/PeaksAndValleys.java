package ch10_sorting_and_searching.q11_peaks_and_valleys;

import java.util.Arrays;

public class PeaksAndValleys {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 3, 7, 5, 1, 6, 0, 3, 9 };
		Arrays.stream(peaksAndValleys(arr)).forEach(i -> System.out.print(i + ", "));
	}

	static int[] peaksAndValleys(int[] arr) {
		Arrays.sort(arr);

		int[] res = new int[arr.length];
		int startIndex = 0;
		int index = 0;
		int endIndex = arr.length - 1;

		while (startIndex <= endIndex) {
			if (index % 2 == 0) {
				res[index] = arr[startIndex];
				startIndex++;
			} else {
				res[index] = arr[endIndex];
				endIndex--;
			}

			index++;
		}

		return res;
	}
}

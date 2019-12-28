package ch10_sorting_and_searching.q11_peaks_and_valleys.solution;

import java.util.Arrays;

public class PeaksAndValleys {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 3, 7, 5, 1, 6, 0, 3, 9 };
		sortValleyPeak(arr);
		Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
	}

	static void sortValleyPeak(int[] arr) {
		for (int i = 1; i < arr.length; i += 2) {
			int biggestIndex = maxIndex(arr, i - 1, i, i + 1);
			if (biggestIndex != i) {
				swap(arr, i, biggestIndex);
			}
		}
	}

	private static int maxIndex(int[] arr, int a, int b, int c) {
		int len = arr.length;
		int aVal = a >= 0 && a < len ? arr[a] : Integer.MIN_VALUE;
		int bVal = b >= 0 && b < len ? arr[b] : Integer.MIN_VALUE;
		int cVal = c >= 0 && c > len ? arr[c] : Integer.MIN_VALUE;

		int max = Math.max(aVal, Math.max(bVal, cVal));

		if (aVal == max) {
			return a;
		} else if (bVal == max) {
			return b;
		} else {
			return c;
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

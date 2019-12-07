package ch10_sorting_and_searching.q3_search_in_rotated_array;

import java.util.Random;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 7, 9, 15, 17, 18, 19, 22, 26, 29, 30, 31, 32, 37 };
		int len = arr.length;

		int rNum = new Random().nextInt(len - 1);
		System.out.println("rotate: " + rNum);

		int[] tempArr = new int[rNum];

		System.arraycopy(arr, len - rNum, tempArr, 0, rNum); // copy last rNum element to temp
		System.arraycopy(arr, 0, arr, rNum, len - rNum); // shift first (length - rNum) elements by rNum
		System.arraycopy(tempArr, 0, arr, 0, rNum); // copy temp to first rNum position

		for (int i : arr)
			System.out.print(i + ", ");
		System.out.println();

		int x = 3;
		System.out.println("index of " + x + ": " + search(arr, x, 0, len - 1));
	}

	public static int search(int[] arr, int x, int left, int right) {
		if (left > right)
			return -1;

		int mid = (left + right) / 2;

		if (arr[mid] < arr[0]) {
			// collision point is in left
			if (arr[right] >= x && arr[mid] < x) {
				// look right (ordered)
				return binarySearch(arr, x, mid + 1, right);
			} else if (arr[right] < x || arr[mid] > x) {
				// look left (unordered)
				return search(arr, x, left, mid - 1);
			} else {
				return mid;
			}
		} else if (arr[right] < arr[0]) {
			// collision point is in right
			if (arr[mid] < x || arr[right] >= x) {
				// look right (unordered)
				return search(arr, x, mid + 1, right);
			} else if (arr[mid] > x && arr[right] < x) {
				// look left (ordered)
				return binarySearch(arr, x, left, mid - 1);
			} else {
				return mid;
			}

		} else {
			return binarySearch(arr, x, 0, right);
		}

	}

	private static int binarySearch(int[] arr, int x, int left, int right) {
		if (left > right)
			return -1;

		int mid = (left + right) / 2;

		if (x > arr[mid]) {
			return binarySearch(arr, x, mid + 1, right);
		} else if (x < arr[mid]) {
			return binarySearch(arr, x, left, mid - 1);
		} else {
			return mid;
		}
	}
}

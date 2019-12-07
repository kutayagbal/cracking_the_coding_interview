package ch10_sorting_and_searching.q3_search_in_rotated_array.solution;

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
		System.out.println("index of " + x + ": " + search(arr, 0, len - 1, x));
	}

	private static int search(int[] a, int left, int right, int x) {
		int mid = (left + right) / 2;

		if (x == a[mid]) { // Found element
			return mid;
		}

		if (left > right) {
			return -1;
		}

		/*
		 * Either the left or right half must be normally ordered. Find out which side
		 * is normally ordered, and then use the normally ordered half to figure out
		 * which side to search to find x.
		 */
		if (a[left] < a[mid]) { // Left is normally ordered
			if (a[left] <= x && a[mid] > x) {
				return search(a, left, mid - 1, x); // Search left
			} else {
				return search(a, mid + 1, right, x); // Search right
			}
		} else if (a[mid] < a[left]) { // Right is normally ordered
			if (x > a[mid] && x <= a[right]) {
				return search(a, mid + 1, right, x); // Search right
			} else {
				return search(a, left, mid - 1, x); // Search left
			}
		} else if (a[left] == a[mid]) { // Left or right half all repeats
			if (a[mid] != a[right]) { // If right is different, search it
				return search(a, mid + 1, right, x);
			} else { // Else, we have to search both halves
				int result = search(a, left, mid - 1, x); // Search left

				if (result == -1) {
					return search(a, mid + 1, right, x); // Search right
				} else {
					return result;
				}
			}
		}

		return -1;
	}

}

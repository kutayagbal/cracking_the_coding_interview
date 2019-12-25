package ch10_sorting_and_searching.q9_sorted_matrix_search;

public class SortedMatrixSearch {

	public static void main(String[] args) {
		int k = 11;
		
		int[][] matrix = { { 1, 4, 7, 10, 13 }, { 2, 4, 8, 10, 14 }, { 2, 5, 9, 11, 17 }, { 5, 7, 11, 15, 20 },
				{ 8, 8, 12, 16, 21 } };
		print(matrix);

		int maxCol = findMaxIndex(matrix[0], 0, matrix[0].length - 1, k) - 1;

		Result res = find(k, matrix, maxCol);
		if (res == null) {
			System.out.println(k + " not found ");
		} else {
			System.out.println(k + " found => row: " + res.row + " column: " + res.col);
		}
	}

	public static Result find(int k, int[][] m, int colLen) {
		int colIndex = -1;
		for (int i = 0; i < m.length; i++) {
			colIndex = binary(m[i], 0, colLen, k);

			if (colIndex >= 0)
				return new Result(i, colIndex);
		}

		return null;
	}

	public static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public static int findMaxIndex(int[] arr, int left, int right, int k) {
		if (left > right)
			return right;

		int mid = (left + right) / 2;

		if (k > mid) {
			return findMaxIndex(arr, mid + 1, right, k);
		} else if (k < mid) {
			return findMaxIndex(arr, left, mid - 1, k);
		}

		return right;
	}

	public static int binary(int[] arr, int left, int right, int k) {
		if (left > right) {
			return -1;
		}

		int midIndex = (left + right) / 2;

		int midElem = arr[midIndex];

		if (k < midElem) {
			return binary(arr, left, midIndex - 1, k);
		} else if (k > midElem) {
			return binary(arr, midIndex + 1, right, k);
		} else {
			return midIndex;
		}
	}
}

class Result {
	int row;
	int col;

	public Result(int r, int c) {
		row = r;
		col = c;
	}
}

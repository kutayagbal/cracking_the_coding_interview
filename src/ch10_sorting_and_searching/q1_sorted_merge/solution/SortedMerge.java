package ch10_sorting_and_searching.q1_sorted_merge.solution;

public class SortedMerge {

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 5, 8, 10, 0, 0, 0};
		int[] b = { 7, 9, 11 };

		sortedMerge(a, b, a.length - b.length, b.length);

		for (int i : a)
			System.out.print(i + ", ");
	}

	private static void sortedMerge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1; // Index of last element in array a
		int indexB = lastB - 1; // Index of last element in array b
		int indexMerged = a.length - 1; // End of merged array

		// Merge a and b, starting from the last element in each
		while (indexB >= 0) {
			// End of a > than end of b
			if (indexA >= 0 && a[indexA] > b[indexB]) {
				a[indexMerged] = a[indexA];
				indexA--;
			} else {
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--;
		}
	}
}

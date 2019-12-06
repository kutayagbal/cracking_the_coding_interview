package ch10_sorting_and_searching.q1_sorted_merge;

public class SortedMerge {

	public static void main(String[] args) {
		int[] a = { 2, 4, 5, 8, 9, 10, 0, 0, 0, 0, 0};
		int[] b = { 1, 3, 6, 7, 11 };

		sortedMerge(a, b);

		for (int i : a)
			System.out.print(i + ", ");
	}

	private static void sortedMerge(int[] a, int[] b) {
		int aLen = a.length;
		int bLen = b.length;
		int index = aLen - 1;
		int aIndex = aLen - bLen - 1;
		int bIndex = bLen - 1;

		while (bIndex >= 0 && aIndex >= 0) {
			if (a[aIndex] > b[bIndex]) {
				a[index] = a[aIndex];
				aIndex--;
			} else {
				a[index] = b[bIndex];
				bIndex--;
			}

			index--;
		}

		if (aIndex < 0) {
			while (bIndex >= 0) {
				a[index] = b[bIndex];
				index--;
				bIndex--;
			}
		}
	}
}

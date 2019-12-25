package ch10_sorting_and_searching.q8_find_duplicates.solution;

public class FindDuplicates {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 11, 2, 1, 5, 9, 31999, 24, 43, 682, 2, 43, 524, 11, 3, 56, 9, 7, 6, 524, 31999 };

		BitSet bs = new BitSet(32000);

		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			int num0 = num - 1; // bitset starts at 0, numbers start at 1
			if (bs.get(num0)) {
				System.out.println(num);
			} else {
				bs.set(num0);
			}

		}

	}

}

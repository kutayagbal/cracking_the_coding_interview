package ch08_recursion_and_dynamic_programming.q3_magic_index.solution;

public class MagicIndex {

	public static void main(String[] args) {
		int[] distinctArray = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
		System.out.println(magicDistinct(distinctArray));

		int[] notDistinctArray = { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
		System.out.println(magicNotDistinct(notDistinctArray));
	}

	public static int magicDistinct(int[] array) {
		return magicDistinct(array, 0, array.length - 1);
	}

	private static int magicDistinct(int[] array, int start, int end) {
		if (end < start)
			return -1;

		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];

		if (midValue == midIndex) {
			return midValue;
		} else if (midValue > midIndex) {
			return magicDistinct(array, start, midIndex - 1);
		} else {
			return magicDistinct(array, midIndex + 1, end);
		}
	}

	public static int magicNotDistinct(int[] array) {
		return magicNotDistinct(array, 0, array.length - 1);
	}

	/*
	 * When we see that A[mid] < mid, we cannot conclude which side the magic index
	 * is on. It could be on the right side, as before. Or, it could be on the left
	 * side (as it, in fact, is). Could it be anywhere on the left side? Not
	 * exactly. Since A[5] = 3, we know that A[4] couldn't be a magic index. A[4]
	 * would need to be 4 to be the magic index, but A[4] must be less than or equal
	 * to A[5]. In fact, when we see that A[5] = 3, we'll need to recursively
	 * search the right side as before. But, to search the left side, we can skip a
	 * bunch of elements and only recursively search elements A[0] through A[3].
	 * A[3] is the first element that could be a magic index. The general pattern is
	 * that we compare midIndex and midValue for equality first. Then, if they are
	 * not equal, we recursively search the left and right sides as follows: 
	 * • Left side: search indices start through Math.min(midIndex - 1, midValue). 
	 * • Right side: search indices Math.max(midIndex + 1, midValue) through end.
	 */
	private static int magicNotDistinct(int[] array, int start, int end) {
		if (end < start)
			return -1;

		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];

		if (midIndex == midValue) {
			return midIndex;
		}

		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicNotDistinct(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}

		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicNotDistinct(array, rightIndex, end);

		return right;

	}
}

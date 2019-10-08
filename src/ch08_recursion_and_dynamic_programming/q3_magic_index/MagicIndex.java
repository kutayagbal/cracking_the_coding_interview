package ch08_recursion_and_dynamic_programming.q3_magic_index;

public class MagicIndex {

	public static void main(String[] args) {
		int[] arr = { -4,-3,-2,-1,0,5,7,9,10,11 };
		System.out.println(getMagicIndex(arr));
	}

	public static int getMagicIndex(int[] arr) {
		if (arr == null || arr.length == 0)
			return -1;

		boolean isAscending = false;
		if (arr.length > 1) {
			if (arr[1] > arr[0])
				isAscending = true;
		} else {
			if (arr[0] == 0)
				return 0;
			else
				return -1;
		}

		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if (isAscending) {
				if (val > i) {
					return -1;
				} else if (val == i) {
					return val;
				}
			} else {
				if (i > val) {
					return -1;
				} else if (val == i) {
					return val;
				}
			}
		}

		return -1;
	}

}

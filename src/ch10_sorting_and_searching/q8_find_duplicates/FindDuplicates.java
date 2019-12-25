package ch10_sorting_and_searching.q8_find_duplicates;

public class FindDuplicates {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 11, 2, 1, 5, 9, 31999, 24, 43, 682, 2, 43, 524, 11, 3, 56, 9, 7, 6, 524, 31999 };

		byte[] bitVector = new byte[4000]; // 0 to 31999

		for (int i : arr) {
			int rem = i % 8;
			int index = i / 8;
			byte b = bitVector[index];
			int mask = 1 << (8 - rem);

			if ((b & mask) != 0) {
				System.out.println(i);
			} else {
				bitVector[index] = (byte) (b | mask);
			}
		}
	}
}

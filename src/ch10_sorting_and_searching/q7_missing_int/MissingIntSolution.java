package ch10_sorting_and_searching.q7_missing_int;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingIntSolution {

	public static void main(String[] args) {
		findMissingInt();
	}

	public static void findMissingInt() {
		long numberOfInts = ((long) Integer.MAX_VALUE) + 1; // Nearly 2 billion because 1 bit is sign bit (2ˆ31 - 1)
		byte[] bitField = new byte[(int) (numberOfInts / 8)]; // Array holds bytes, so we need to divide bit count by 8

		String fileName = ".../ints.txt";

		Scanner in = null;
		try {
			in = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (in.hasNext()) {
			int n = in.nextInt();

			/*
			 * Finds the corresponding number in the bitfield by using the OR operator to
			 * set the nth bit of a byte (e.g., 10 would correspond to the 2nd bit of index
			 * 2 in the byte array).
			 */

			bitField[n / 8] |= 1 << (n % 8);
		}

		for (int i = 0; i < bitField.length; i++) {
			for (int j = 0; j < 8; j++) {
				/*
				 * Retrieves the individual bits of each byte. When 0 bit is found, print the
				 * corresponding value.
				 */
				if ((bitField[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j);
					return;
				}
			}
		}
	}

}

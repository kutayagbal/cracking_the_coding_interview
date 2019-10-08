package ch05_bit_manipulation.q4_next_number;

public class NextNumber {

	public static void main(String[] args) {
		int num = 13961;// 13955, 13962

		int smallest = getSmallestNext(num);
		int largest = getLargestNext(num);
		System.out.println(num);
		System.out.println(smallest);
		System.out.println(largest);
		
		System.out.println();
		
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(smallest));
		System.out.println(Integer.toBinaryString(largest));
	}

	private static int getSmallestNext(int num) {
		int curr = num;

		int counter = 0;
		int rightMostZeroIndex = 0;
		int rightMostOneIndex = 0;
		boolean isRightMostZeroFound = false;
		while (curr != 0) {

			if ((curr & 1) == 0) {
				if (!isRightMostZeroFound) {
					// rightmost zero found at 0 based index
					rightMostZeroIndex = counter;
					isRightMostZeroFound = true;
				}
			} else if (isRightMostZeroFound) {
				// rightmost one after rightmost zero
				rightMostOneIndex = counter;
				break;
			}

			curr = curr >> 1;
			counter++;
		}

		return clearAtIndex(setAtIndex(num, rightMostZeroIndex), rightMostOneIndex);
	}

	private static int clearAtIndex(int num, int index) {
		int mask = ~(1 << index); // 11111011111
		return num & mask;
	}

	private static int setAtIndex(int num, int index) {
		int mask = 1 << index; // 00000100000
		return num | mask;
	}

	private static int getLargestNext(int num) {
		int curr = num;

		boolean isOneFound = false;
		int indexOfOne = 0;
		int counter = 0;
		while (curr != 0) {
			if ((curr & 1) == 1 && !isOneFound) {
				if ((curr & 2) == 0) {
					isOneFound = true;
					indexOfOne = counter;
				}
			} else if (isOneFound) {
				break;
			}

			curr = curr >> 1;
			counter++;

		}

		return clearAtIndex(setAtIndex(num, indexOfOne + 1), indexOfOne);
	}
}

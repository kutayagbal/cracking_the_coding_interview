package ch05_bit_manipulation.q2_binary_to_string.solution;

public class BinaryToString {

	public static void main(String[] args) {
		double num = 0.625;
		System.out.println(num + " in binary = " + printBinary(num));
	}

	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}

		StringBuilder binary = new StringBuilder();
		binary.append(".");

		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() >= 32) {
				return "ERROR";
			}

			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}

		return binary.toString();
	}
}

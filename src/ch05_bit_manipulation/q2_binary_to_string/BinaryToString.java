package ch05_bit_manipulation.q2_binary_to_string;

public class BinaryToString {

	public static void main(String[] args) {
		double number = 0.10;

		int counter = 0;
		StringBuffer result = new StringBuffer("0.");
		while (counter <= 32) {
			double multiplication = number * 2;
			if (multiplication == 0)
				break;

			int wholePart = (int) multiplication;
			result.append(wholePart);
			if (wholePart == 1)
				number = multiplication - 1;
			else
				number = multiplication;

			counter++;
		}

		if (counter == 33)
			System.out.println("ERROR");
		else
			System.out.println(result.toString());

	}

}

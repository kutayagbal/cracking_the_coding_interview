package ch08_recursion_and_dynamic_programming.q9_parens.solution;

import java.util.ArrayList;

public class Parens {

	public static void main(String[] args) {
		ArrayList<String> resultList = generateParens(3);

		System.out.println(resultList.size());
		for (String s : resultList) {
			System.out.println(s);
		}
	}

	private static ArrayList<String> generateParens(int count) {
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<>();
		addParen(list, count, count, str, 0);
		return list;

	}

	// invalid state is important. it tries to open a prenthesis but if invalid it
	// returns, puts a closed parenthesis instead at same index.
	/*
	 * Because we insert left and right parentheses at each index in the string, and
	 * we never repeat an index, each string is guaranteed to be unique.
	 */
	private static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
		if (leftRem < 0 || rightRem < leftRem)
			return; // invalid state

		if (leftRem == 0 && rightRem == 0) {
			/* Out of left and right parentheses */
			list.add(String.copyValueOf(str));
		} else {
			str[index] = '('; // Add left and recurse
			addParen(list, leftRem - 1, rightRem, str, index + 1);

			str[index] = ')';// Add right and recurse
			addParen(list, leftRem, rightRem - 1, str, index + 1);
		}
	}

}

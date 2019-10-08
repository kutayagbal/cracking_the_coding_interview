package ch08_recursion_and_dynamic_programming.q9_parens;

import java.util.ArrayList;

public class Parens {

	public static void main(String[] args) {
		ArrayList<String> resultList = printParen(6);

		System.out.println(resultList.size());
		for (String s : resultList) {
			System.out.println(s);
		}
	}

	//wrong
	public static ArrayList<String> printParen(int n) {
		if (n == 1) {
			ArrayList<String> resultList = new ArrayList<>();
			resultList.add("()");
			return resultList;
		}

		ArrayList<String> partialList = printParen(n - 1);

		ArrayList<String> resultList = new ArrayList<>();
		for (String s : partialList) {
			int openCounter = 0;
			int closeCounter = 0;
			boolean isOpenClose = true;
			for (char c : s.toCharArray()) {
				if (c == ')') {
					closeCounter++;
					openCounter--;
				} else {
					openCounter++;
					closeCounter--;
				}

				if (openCounter > 1 || closeCounter > 1) {
					isOpenClose = false;
					break;
				}
			}

			resultList.add("(" + s + ")");
			resultList.add("()" + s);

			if (!isOpenClose) {
				resultList.add(s + "()");
			}
		}

		return resultList;

	}

}

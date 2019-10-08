package ch08_recursion_and_dynamic_programming.q12_eight_queens;

public class EightQueens {

	public static void main(String[] args) {
		int[] columns = { -1, -1, -1, -1, -1, -1, -1, -1 };
		System.out.println(putQueen(0, columns));
	}

	private static int putQueen(int queenIndex, int[] columns) {
		if (queenIndex == 8)
			return 1;

		int ways = 0;
		for (int i = 0; i < columns.length; i++) {
			if (isValidToPutToColumn(queenIndex, columns, i)) {
				columns[i] = queenIndex;
				ways += putQueen(queenIndex + 1, columns);
				columns[i] = -1;
			}
		}

		return ways;
	}

	private static boolean isValidToPutToColumn(int queenIndex, int[] columns, int col) {
		if (columns[col] != -1)
			return false;

		for (int i = 0; i < columns.length; i++) {
			if (col - i >= 0) {
				int qIndex = columns[col - i];

				if (qIndex > -1 && (qIndex == queenIndex + i || qIndex == queenIndex - i))
					return false;
			}

			if (col + i < columns.length) {
				int qIndex = columns[col + i];

				if (qIndex > -1 && (qIndex == queenIndex + i || qIndex == queenIndex - i))
					return false;
			}
		}

		return true;
	}
}

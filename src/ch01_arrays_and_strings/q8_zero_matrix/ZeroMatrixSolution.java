package ch01_arrays_and_strings.q8_zero_matrix;

public class ZeroMatrixSolution {
	private static int[][] matrix = { { 0, 1, 1, 1, 1 }, { 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1 },
			{ 1, 1, 1, 1, 1 } };

	public static void main(String[] args) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ,");
			}
			System.out.println();
		}
		System.out.println();

		setZeros(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ,");
			}
			System.out.println();
		}
	}

	private static void setZeros(int[][] m) {
		boolean rowHasZero = false;
		boolean colHasZero = false;

		// check if the first row has zero
		for (int i = 0; i < m[0].length; i++) {
			if (m[0][i] == 0) {
				rowHasZero = true;
				break;
			}
		}

		// check if the first column has zero
		for (int i = 0; i < m.length; i++) {
			if (m[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}

		// check for the zeros in the rest of the array
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				if (m[i][j] == 0) {
					m[0][j] = 0;
					m[i][0] = 0;
				}
			}
		}

		// nullify rows
		for (int i = 1; i < m.length; i++) {
			if (m[i][0] == 0) {
				nullifyRow(m, i);
			}
		}

		// nullify columns
		for (int i = 1; i < m[0].length; i++) {
			if (m[0][i] == 0) {
				nullifyCol(m, i);
			}
		}

		if (rowHasZero) {
			nullifyRow(m, 0);
		}

		if (colHasZero) {
			nullifyCol(m, 0);
		}

	}

	private static void nullifyCol(int[][] m, int col) {
		for (int i = 0; i < m.length; i++) {
			m[i][col] = 0;
		}
	}

	private static void nullifyRow(int[][] m, int row) {
		for (int i = 0; i < m[0].length; i++) {
			m[row][i] = 0;
		}
	}
}

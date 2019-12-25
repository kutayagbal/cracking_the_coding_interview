package ch10_sorting_and_searching.q9_sorted_matrix_search.solution;

public class SortedMatrixSearch {

	public static void main(String[] args) {
		int[][] m = { { 1, 4, 7, 10, 13 }, { 2, 4, 8, 10, 14 }, { 2, 5, 9, 11, 17 }, { 5, 7, 11, 15, 20 },
				{ 8, 8, 12, 16, 21 } };

		int x = 14;

		Coordinate c = findElement(m, x);

		if (c != null)
			System.out.println(x + " found at row: " + c.row + " col: " + c.col);
		else
			System.out.println(x + " not found.");
	}

	static Coordinate findElement(int[][] matrix, int x) {
		Coordinate origin = new Coordinate(0, 0);
		Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
		return findElement(matrix, origin, dest, x);
	}

	static Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x) {
		if (!origin.inBounds(matrix) || !dest.inBounds(matrix))
			return null;

		if (matrix[origin.row][origin.col] == x) {
			return origin;
		} else if (!origin.isBefore(dest)) {
			return null;
		}

		/*
		 * Set start to the start of diagonal and end to end of the diagonal. Since the
		 * grid may not be square, the end of the diagonal may not equal destination.
		 */
		Coordinate start = origin.clone();
		int diagDist = Math.min((dest.row - origin.row), (dest.col - origin.col));

		Coordinate end = new Coordinate(start.row + diagDist, start.col + diagDist);
		Coordinate p = new Coordinate(0, 0);

		// Do binary search on the diagonal, looking for the first element > x
		while (start.isBefore(end)) {
			p.setToAvarage(start, end);
			if (x > matrix[p.row][p.col]) {
				start.row = p.row + 1;
				start.col = p.col + 1;
			} else {
				end.row = p.row - 1;
				end.col = p.col - 1;
			}
		}

		// Split the grid into quadrants. Search the bottom left and top right
		return partitionAndSearch(matrix, origin, dest, start, x);
	}

	private static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot,
			int x) {
		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.col);
		Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.col - 1);
		Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.col);
		Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.col);

		Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, x);

		if (lowerLeft == null) {
			return findElement(matrix, upperRightOrigin, upperRightDest, x);
		}

		return lowerLeft;
	}

}

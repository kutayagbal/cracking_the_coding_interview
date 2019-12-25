package ch10_sorting_and_searching.q9_sorted_matrix_search.solution;

public class Coordinate implements Cloneable {
	int row;
	int col;

	public Coordinate(int r, int c) {
		row = r;
		col = c;
	}

	public boolean inBounds(int[][] matrix) {
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
	}

	public boolean isBefore(Coordinate p) {
		return row <= p.row && col <= p.col;
	}

	@Override
	public Coordinate clone() {
		return new Coordinate(row, col);
	}

	public void setToAvarage(Coordinate min, Coordinate max) {
		row = (min.row + max.row) / 2;
		col = (min.col + max.col) / 2;
	}

}

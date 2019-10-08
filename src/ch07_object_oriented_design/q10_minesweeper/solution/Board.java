package ch07_object_oriented_design.q10_minesweeper.solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Board {
	private int nRows;
	private int nColumns;
	private int nBombs = 0;
	private Cell[][] cells;
	private Cell[] bombs;
	private int numUnexposedRemaining;

	public Board(int r, int c, int b) {
		nRows = r;
		nColumns = c;
		nBombs = b;

		initializeBoard();
	}

	private void initializeBoard() {
		int row = 0;
		for (int i = 0; i < nBombs; i++) { // put bombs at first n cells
			row = i / nColumns;
			int col = i % nColumns;

			Cell bomb = new Cell(row, col);
			cells[row][col] = bomb;
			bombs[i] = bomb;
		}

		shuffleBoard(); // shuffle bombs through the board
		setNumberedCells(); // set numbers around bombs
	}

	private void shuffleBoard() {
		int nCells = nRows * nColumns;

		Random rand = new Random();

		for (int index1 = 0; index1 < nCells; index1++) {
			int index2 = index1 + rand.nextInt(nCells - index1);

			if (index1 != index2) {
				/* get the cell at index1 */
				int row1 = index1 / nColumns;
				int col1 = index1 % nColumns;
				Cell cell1 = cells[row1][col1];

				/* get the cell at index2 */
				int row2 = index2 / nColumns;
				int col2 = index2 % nColumns;
				Cell cell2 = cells[row2][col2];

				/* swap */
				cells[row1][col1] = cell2;
				cell2.setRow(row1);
				cell2.setCol(col1);
				cells[row2][col2] = cell1;
				cell1.setRow(row2);
				cell1.setCol(col2);
			}
		}
	}

	/*
	 * Set the cells around the bombs to the right number. Although the bombs have
	 * been shuffled, the reference in the bombs array is still to same object.
	 */
	private void setNumberedCells() {
		int[][] deltas = { // Offsets of 8 surrounding cells
				{ -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		for (Cell bomb : bombs) {
			int row = bomb.getRow();
			int col = bomb.getCol();

			for (int[] delta : deltas) {
				int r = row + delta[0];
				int c = col + delta[1];
				if (inBounds(r, c)) {
					cells[r][c].incrementNumber();
				}
			}
		}
	}

	public void expandBlank(Cell cell) {
		int[][] deltas = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		Queue<Cell> toExplore = new LinkedList<>();
		toExplore.add(cell);

		while (!toExplore.isEmpty()) {
			Cell current = toExplore.remove();

			for (int i = 0; i < deltas.length; i++) {
				int r = current.getRow() + deltas[i][0];
				int c = current.getCol() + deltas[i][1];

				if (inBounds(r, c)) {
					Cell neighbor = cells[r][c];
					if (flipCell(neighbor) && neighbor.isBlank()) {
						toExplore.add(neighbor);
					}
				}
			}
		}
	}

	private boolean inBounds(int r, int c) {
		return r < nRows && c < nColumns && r > 0 && c > 0;
	}

	private boolean flipCell(Cell cell) {
		return false;
	}

	public UserPlayResult playFlip(UserPlay play) {
		return null;
	}

	public int getNumRemaining() {
		return numUnexposedRemaining;
	}

	public class UserPlay {
		private int row;
		private int column;
		private boolean isGuess;
		/* constructor, getters, setters. */
	}

	public class UserPlayResult {
		private boolean successful;
		private Game.GameState resultingState;
		/* constructor, getters, setters. */
	}
}

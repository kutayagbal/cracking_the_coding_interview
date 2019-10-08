package ch07_object_oriented_design.q10_minesweeper.solution;

public class Cell {
	private int row;
	private int col;
	private boolean isBomb;
	private int number;
	private boolean isExposed = false;
	private boolean isGuess = false;

	public Cell(int r, int c) {
	}

	/* Getters and setters for above variables. */

	public boolean flip() {
		isExposed = true;
		return !isBomb;
	}

	public boolean toggleGuess() {
		if (!isExposed) {
			isGuess = !isGuess;
		}
		return isGuess;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean isBomb() {
		return isBomb;
	}

	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isExposed() {
		return isExposed;
	}

	public void setExposed(boolean isExposed) {
		this.isExposed = isExposed;
	}

	public boolean isGuess() {
		return isGuess;
	}

	public void setGuess(boolean isGuess) {
		this.isGuess = isGuess;
	}

	public void incrementNumber() {
		number++;
	}

	public boolean isBlank() {
		return !isBomb && number == 0;
	}

}

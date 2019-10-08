package ch07_object_oriented_design.q10_minesweeper;

public class Piece {
	private boolean flagged;
	private boolean uncovered;
	private PieceType type;
	private int value;

	public Piece(PieceType type, int value) {
		this.type = type;
		this.value = value;
		this.uncovered = false;
		this.flagged = false;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

	public boolean isUncovered() {
		return uncovered;
	}

	public void setUncovered(boolean uncovered) {
		this.uncovered = uncovered;
	}

	public PieceType getType() {
		return type;
	}

	public void setType(PieceType type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}

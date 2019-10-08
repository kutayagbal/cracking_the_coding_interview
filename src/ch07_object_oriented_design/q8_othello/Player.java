package ch07_object_oriented_design.q8_othello;

public class Player {
	private int pieceCount = 0;
	private Color color;

	public Player(Color color) {
		super();
		this.color = color;
	}

	public int getPieceCount() {
		return pieceCount;
	}

	public void setPieceCount(int pieceCount) {
		this.pieceCount = pieceCount;
	}

	public Color getColor() {
		return color;
	}

}

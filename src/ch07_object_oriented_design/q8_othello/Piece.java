package ch07_object_oriented_design.q8_othello;

public class Piece {
	private Color color;

	public Piece(Color color) {
		super();
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void flip() {
		color = color.opposite();
	}

}

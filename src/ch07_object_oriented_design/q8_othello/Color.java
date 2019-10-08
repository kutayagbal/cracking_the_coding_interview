package ch07_object_oriented_design.q8_othello;

public enum Color {
	White, Black;

	public Color opposite() {
		return this == White ? Black : White;
	}
}

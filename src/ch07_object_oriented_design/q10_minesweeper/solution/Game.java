package ch07_object_oriented_design.q10_minesweeper.solution;

public class Game {
	public enum GameState {
		WON, LOST, RUNNING
	}

	private Board board;
	private int rows;
	private int columns;
	private int bombs;
	private GameState state;

	public Game(int r, int c, int b) {
	}

	public boolean initialize() {
		return false;
	}

	public boolean start() {
		return false;
	}

	private boolean playGame() {// Loops until game is over.
		return false;
	}
}

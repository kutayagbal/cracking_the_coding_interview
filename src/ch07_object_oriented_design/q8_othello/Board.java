package ch07_object_oriented_design.q8_othello;

import java.util.Random;

public class Board {
	private final int MIN_BOARD_SIZE = 4;
	private Player p1;
	private Player p2;
	private Color turn;
	private Piece[][] board;

	public Board(int n) {
		p1 = new Player(Color.White);
		p1.setPieceCount(2);
		p2 = new Player(Color.Black);
		p2.setPieceCount(2);

		if (n < MIN_BOARD_SIZE) {
			n = MIN_BOARD_SIZE; // min board size
		}

		if (n % 2 != 0) {
			n++;// board should be even to initial state
		}

		board = new Piece[n][n];
		board[n / 2 - 1][n / 2 - 1] = new Piece(Color.White);
		board[n / 2 - 1][n / 2] = new Piece(Color.Black);
		board[n / 2][n / 2 - 1] = new Piece(Color.Black);
		board[n / 2][n / 2] = new Piece(Color.White);

		setTurn(new Random().nextBoolean() ? Color.White : Color.Black);
	}

	public void setTurn(Color turn) {
		this.turn = turn;
		System.out.println(turn.name() + "'s turn:");
	}

	public void putPiece(int row, int col) {

		if (!isValidMove(row, col)) {
			System.out.println("row=" + row + " col=" + col + " is not valid");
			return;
		}

		Piece p = new Piece(turn);
		board[row][col] = p;

		if (isThereValidMove()) {
			System.out.println("winner is" + (p1.getPieceCount() > p2.getPieceCount() ? p1.getColor() : p2.getColor()));
		} else {
			setTurn(turn.opposite());
		}
	}

	public void flip(int row, int col) {
		board[row][col].flip();

		if (p1.getColor() == turn) {
			p1.setPieceCount(p1.getPieceCount() + 1);
		} else {
			p2.setPieceCount(p2.getPieceCount() + 1);
		}

		int boardSize = board[0].length;

		Piece up = row > 0 ? board[row - 1][col] : null;
		Piece down = row < boardSize ? board[row + 1][col] : null;
		Piece left = col > 0 ? board[row][col - 1] : null;
		Piece right = col < boardSize ? board[row - 1][col + 1] : null;

		if (up != null && up.getColor() == turn.opposite()) {
			// check up's up
			// if ok call flip
		}

		if (down != null && down.getColor() == turn.opposite()) {
			// check down's down
			// if ok call flip
		}

		if (left != null && left.getColor() == turn.opposite()) {
			// check left's left
			// if ok call flip
		}

		if (right != null && right.getColor() == turn.opposite()) {
			// check right's right
			// if ok call flip
		}
	}

	private boolean isValidMove(int row, int col) {
		boolean isValid = false;

		if (board[row][col] == null) {
			int boardSize = board[0].length;

			Piece up = row > 0 ? board[row - 1][col] : null;
			Piece down = row < boardSize ? board[row + 1][col] : null;
			Piece left = col > 0 ? board[row][col - 1] : null;
			Piece right = col < boardSize ? board[row - 1][col + 1] : null;

			if (up != null && up.getColor() == turn.opposite()) {
				// check up's up
				// if ok call flip, isValid = true
			}

			if (down != null && down.getColor() == turn.opposite()) {
				// check down's down
				// if ok call flip, isValid = true
			}

			if (left != null && left.getColor() == turn.opposite()) {
				// check left's left
				// if ok call flip, isValid = true
			}

			if (right != null && right.getColor() == turn.opposite()) {
				// check right's right
				// if ok call flip, isValid = true
			}
		}

		return isValid;
	}

	private boolean isThereValidMove() {

		// check if turn.opposite can flip min 1;
		return true;
	}

}

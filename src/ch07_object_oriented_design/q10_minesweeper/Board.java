package ch07_object_oriented_design.q10_minesweeper;

public class Board {
	private Piece[][] grid = null;
	private int N = 0;
	private int coveredNonBombCount = 0;

	public Board(int boardSize, int bombCount) {
		N = boardSize;
		grid = new Piece[N][N];
		coveredNonBombCount = N * N - bombCount;
		fillWithBombs(bombCount);
	}

	private void fillWithBombs(int bombCount) {
		// TODO put bombs randomly
	}

	public void uncover(int row, int col) {
		Piece p = grid[row][col];
		if (p.isFlagged()) {
			p.setFlagged(false);
		} else {
			if (!p.isUncovered()) {
				if (p.getType() == PieceType.BOMB) {
					System.out.println("BOOOOOM!!!");
					uncoverAll();
				} else if (p.getType() == PieceType.NUMBER) {
					coveredNonBombCount--;
					p.setUncovered(true);
				} else if (p.getType() == PieceType.EMPTY) {
					uncoverWithAdjacent(row, col);
				}
			}
		}

		if (isWin()) {
			uncoverAll();
			System.out.println("Congratulations....");
		}
	}

	private void uncoverWithAdjacent(int row, int col) {
		Piece p = grid[row][col];

		if (p.getType() != PieceType.BOMB) {
			coveredNonBombCount--;
			p.setUncovered(true);
		} else {
			return;
		}

		if (row - 1 >= 0) {
			uncoverWithAdjacent(row - 1, col);// up

			if (col - 1 >= 0)
				uncoverWithAdjacent(row - 1, col - 1);// up left

			if (col + 1 < N)
				uncoverWithAdjacent(row - 1, col + 1);// up right
		}

		if (row + 1 < N) {
			uncoverWithAdjacent(row + 1, col);// down

			if (col - 1 >= 0)
				uncoverWithAdjacent(row + 1, col - 1);// dow left

			if (col + 1 < N)
				uncoverWithAdjacent(row + 1, col + 1);// down right
		}

		if (col - 1 >= 0)
			uncoverWithAdjacent(row, col - 1);// left

		if (col + 1 < N)
			uncoverWithAdjacent(row, col + 1);// right
	}

	public void flag(int row, int col) {
		grid[row][col].setFlagged(true);
	}

	private void uncoverAll() {
		for (Piece[] row : grid) {
			for (Piece p : row) {
				p.setUncovered(true);
			}
		}
	}

	private boolean isWin() {
		return coveredNonBombCount == 0;
	}
}

package ch08_recursion_and_dynamic_programming.q10_paint_fill;

import java.util.Random;

public class PaintFill {
	private static int rowNum = 10;
	private static int colNum = 20;

	public static void main(String[] args) {
		char[][] screen = initScreen(rowNum, colNum);
		print(screen);
		System.out.println();

		paintFill(screen, 6, 11, 'S');
		print(screen);
	}

	private static void print(char[][] screen) {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				System.out.print(screen[i][j]);
			}
			System.out.println();
		}
	}

	private static char[][] initScreen(int rowCount, int colCount) {
		char[][] screen = new char[rowCount][colCount];
		Random rand = new Random();
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				int rnd = rand.nextInt(2);
				if (rnd == 0) {
					screen[i][j] = ' ';
				} else {
					screen[i][j] = 'X';
				}
			}
		}

		return screen;
	}

	private static void paintFill(char[][] screen, int row, int col, char color) {
		if (color == 'S') {
			color = screen[row][col];
			screen[row][col] = 'S';
		} else {
			screen[row][col] = '0';
		}

		if (isInTheScreen(row + 1, col)) {// down
			if (screen[row + 1][col] == color) {
				paintFill(screen, row + 1, col, color);
			}
		}

		if (isInTheScreen(row - 1, col)) {// up
			if (screen[row - 1][col] == color) {
				paintFill(screen, row - 1, col, color);
			}
		}

		if (isInTheScreen(row, col + 1)) {// right
			if (screen[row][col + 1] == color) {
				paintFill(screen, row, col + 1, color);
			}
		}

		if (isInTheScreen(row, col - 1)) {// left
			if (screen[row][col - 1] == color) {
				paintFill(screen, row, col - 1, color);
			}
		}
	}

	private static boolean isInTheScreen(int row, int col) {
		return row >= 0 && col >= 0 && row < rowNum && col < colNum;
	}
}

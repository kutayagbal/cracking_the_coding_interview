package ch08_recursion_and_dynamic_programming.q10_paint_fill.solution;

import java.util.Random;

public class PaintFill {
	private static enum Color {
		Black, White, Red
	}

	private static int rowNum = 10;
	private static int colNum = 20;

	public static void main(String[] args) {
		Color[][] screen = initScreen(rowNum, colNum);
		print(screen);
		System.out.println();

		paintFill(screen, 6, 11, Color.Red);
		print(screen);
	}

	private static void print(Color[][] screen) {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				switch (screen[i][j]) {
				case Black:
					System.out.print('B');
					break;
				case White:
					System.out.print('W');
					break;
				case Red:
					System.out.print('R');
					break;
				default:
					break;
				}
			}
			System.out.println();
		}
	}

	private static Color[][] initScreen(int rowCount, int colCount) {
		Color[][] screen = new Color[rowCount][colCount];
		Random rand = new Random();
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				int rnd = rand.nextInt(3);
				switch (rnd) {
				case 0:
					screen[i][j] = Color.Black;
					break;
				case 1:
					screen[i][j] = Color.White;
					break;
				case 2:
					screen[i][j] = Color.Red;
					break;
				default:
					break;
				}
			}
		}

		return screen;
	}

	public static boolean paintFill(Color[][] screen, int r, int c, Color nColor) {
		if (screen[r][c] == nColor)
			return false;

		return paintFill(screen, r, c, screen[r][c], nColor);
	}

	private static boolean paintFill(Color[][] screen, int r, int c, Color oColor, Color nColor) {
		if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length)
			return false;

		if (screen[r][c] == oColor) {
			screen[r][c] = nColor;
			paintFill(screen, r - 1, c, oColor, nColor); // up
			paintFill(screen, r + 1, c, oColor, nColor); // down
			paintFill(screen, r, c + 1, oColor, nColor); // right
			paintFill(screen, r, c - 1, oColor, nColor); // left
		}

		return true;
	}
}

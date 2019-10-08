package ch08_recursion_and_dynamic_programming.q2_robot_in_a_grid;

import java.util.Random;

public class RobotInAGrid {
	private static int r = 5;
	private static int c = 5;
	private static int[][] grid;

	public static void main(String[] args) {
		initGrid();

		StringBuffer path = new StringBuffer();
		if (findPath(r - 1, 0, path))
			System.out.println("Way=" + path.toString());
		else
			System.out.println("No way");
	}

	public static void initGrid() {
		grid = new int[r][c];
		for (int i = r - 1; i >= 0; i--) {
			for (int j = 0; j < c; j++) {
				if ((i != r-1 || j != 0) && (i != 0 || j != c - 1)) {
					int rand = new Random().nextInt(4);
					grid[i][j] = rand == 2 || rand == 3 ? 0 : rand;
					System.out.print(grid[i][j] + " , ");
				} else {
					grid[i][j] = 0;
					System.out.print(grid[i][j] + " , ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean findPath(int row, int col, StringBuffer path) {
		if (row == 0 && col == c - 1) {
			return true;
		}

		if (row > 0 && grid[row - 1][col] != 1) {
			if (findPath(row - 1, col, path)) {
				path.append("D");
				return true;
			}
		}

		if (col < c - 1 && grid[row][col + 1] != 1) {
			if (findPath(row, col + 1, path)) {
				path.append("R");
				return true;
			}
		}

		return false;

	}

}

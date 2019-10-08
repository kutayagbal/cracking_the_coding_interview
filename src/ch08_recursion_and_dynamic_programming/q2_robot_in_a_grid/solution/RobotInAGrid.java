package ch08_recursion_and_dynamic_programming.q2_robot_in_a_grid.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RobotInAGrid {
	private static int r = 5;
	private static int c = 5;

	public static void main(String[] args) {
		boolean[][] maze = initMaze();
		ArrayList<Point> path = getPath(maze);

		if (path != null) {
			for (Point p : path) {
				System.out.println(p.row + "," + p.col);
			}
		} else {
			System.out.println("No way");
		}

		System.out.println();

		ArrayList<Point> pathDynamic = getPathDynamic(maze);

		if (path != null) {
			for (Point p : pathDynamic) {
				System.out.println(p.row + "," + p.col);
			}
		} else {
			System.out.println("No way");
		}
	}

	public static boolean[][] initMaze() {
		boolean[][] maze = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if ((i == 0 && j == 0) || (i == r - 1 && j == c - 1)) {
					maze[i][j] = true;
					System.out.print(true + " , ");
					// System.out.print(i + "," + j + " , ");
				} else {
					boolean rand = new Random().nextBoolean();
					if (!rand)
						rand = new Random().nextBoolean();

					maze[i][j] = rand;
					System.out.print(rand + " , ");
					// System.out.print(i + "," + j + " , ");
				}
			}
			System.out.println();
		}
		System.out.println();

		return maze;
	}

	public static ArrayList<Point> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0)
			return null;

		ArrayList<Point> path = new ArrayList<>();

		if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
			return path;
		}

		return null;

	}

	// O(2^(r+c))
	private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		/* If out of bounds or not available, return. */
		if (col < 0 || row < 0 || !maze[row][col])
			return false;

		boolean isAtOrigin = (row == 0) && (col == 0);

		/* If there's a path from the start to here, add my location. */
		if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}

		return false;
	}

	public static ArrayList<Point> getPathDynamic(boolean[][] maze) {
		if (maze == null || maze.length == 0)
			return null;

		ArrayList<Point> path = new ArrayList<>();
		Set<Point> failedPoints = new HashSet<>();

		if (getPathDynamic(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
			return path;
		}

		return null;

	}

	// O(rc)
	private static boolean getPathDynamic(boolean[][] maze, int row, int col, ArrayList<Point> path,
			Set<Point> failedPoints) {
		/* If out of bounds or not available, return. */
		if (col < 0 || row < 0 || !maze[row][col])
			return false;

		/* If we've already visited this cell, return. */
		Point p = new Point(row, col);
		if (failedPoints.contains(p))
			return false;

		boolean isAtOrigin = (row == 0) && (col == 0);

		/* If there's a path from start to my current location, add my location. */
		if (isAtOrigin || getPathDynamic(maze, row - 1, col, path, failedPoints)
				|| getPathDynamic(maze, row, col - 1, path, failedPoints)) {
			path.add(p);
			return true;
		}

		failedPoints.add(p); // Cache result
		return false;
	}

	public static class Point {
		int row;
		int col;

		public Point(int r, int c) {
			row = r;
			col = c;
		}
	}

}

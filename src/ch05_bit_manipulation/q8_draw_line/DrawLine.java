package ch05_bit_manipulation.q8_draw_line;

import java.util.Random;

public class DrawLine {

	//Wrong
	public static void main(String[] args) {
		int w = 10;
		byte[] screen = createRandomScreen(w);
		printScreen(screen, w);
		int height = screen.length / w;
		int y =new Random().nextInt(height);
		System.out.println("\ny=" + y + "\n");
		drawLine(screen, w, 2, 6, y);
		printScreen(screen, w);
	}

	private static void drawLine(byte[] screen, int w, int a1, int a2, int y) {
		int startOfLine = (y - 1) * w + Math.min(a1, a2);
		int distToEndOfLine = Math.abs(a1 - a2);
		int index = startOfLine;
		for (int i = 0; i < distToEndOfLine + 1; i++) {
			screen[index + i] = (byte) 255;
		}
	}

	public static byte[] createRandomScreen(int w) {
		int y = new Random().nextInt(20);
		int arraySize = w * y;
		byte[] result = new byte[arraySize];
		new Random().nextBytes(result);
		return result;
	}

	public static void printScreen(byte[] screen, int w) {
		System.out.println();
		System.out.println();
		for (int i = 0; i < screen.length; i++) {
			System.out.print(screen[i] + ", ");

			if (i % w == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
	}

}

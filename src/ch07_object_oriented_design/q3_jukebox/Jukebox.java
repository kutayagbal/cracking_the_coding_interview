package ch07_object_oriented_design.q3_jukebox;

public class Jukebox {
	private Screen screen;
	private Player player;

	public Jukebox() {
		screen = Screen.getInstance();
		player = Player.getInstance();
		screen.displayMainScreen();
	}
}

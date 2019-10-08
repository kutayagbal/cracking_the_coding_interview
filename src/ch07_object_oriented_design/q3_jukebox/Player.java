package ch07_object_oriented_design.q3_jukebox;

import java.util.LinkedList;

public class Player {
	private static Player _instance;

	private Song currentSong = null;

	private LinkedList<Song> songQueue;

	private Player() {
		this.songQueue = new LinkedList<>();
	}

	public static Player getInstance() {
		if (_instance == null) {
			_instance = new Player();
		}

		return _instance;
	}

	public void startPlaying() {
		while (songQueue.isEmpty()) {
			currentSong = songQueue.removeFirst();
			play(currentSong);
		}

		currentSong = null;
		Screen.getInstance().clearScreen();
	}

	private void play(Song currentSong) {
		Screen.getInstance().displaySong(currentSong);
	}

	public void addToQueue(Song song) {
		songQueue.add(song);
		if (currentSong == null) {
			startPlaying();
		}
	}
}

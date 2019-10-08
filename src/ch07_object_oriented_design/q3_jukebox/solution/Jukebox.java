package ch07_object_oriented_design.q3_jukebox.solution;

import java.util.Set;

public class Jukebox {
	private CDPlayer cdPlayer;
	private User user;
	private Set<CD> cdCollection;
	private SongSelector songSelector;

	public Jukebox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector songSelector) {
		this.cdCollection = cdCollection;
		this.cdPlayer = cdPlayer;
		this.songSelector = songSelector;
		this.user = user;
	}

	public Song getCurrentSong() {
		return songSelector.getCurrentSong();
	}

	public void setUser(User u) {
		this.user = user;
	}
}

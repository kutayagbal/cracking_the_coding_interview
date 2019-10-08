package ch07_object_oriented_design.q3_jukebox.solution;

public class CDPlayer {
	private CD cd;
	private Playlist playlist;

	/* Constructors */
	public CDPlayer(CD cd, Playlist playlist) {
		this.cd = cd;
		this.playlist = playlist;
	}

	public CDPlayer(CD cd) {
		this.cd = cd;
	}

	public CDPlayer(Playlist playlist) {
		this.playlist = playlist;
	}

	public void playSong(Song song) {

	}

	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	/* getters setters */

}

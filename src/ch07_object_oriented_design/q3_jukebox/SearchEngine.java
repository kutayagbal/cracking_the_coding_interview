package ch07_object_oriented_design.q3_jukebox;

import java.util.ArrayList;

public class SearchEngine {
	private ArrayList<Song> searchResults = new ArrayList<>();

	public ArrayList<Song> search(String keyword) {
		// connect to database and retrieve result song list.
		this.searchResults = new ArrayList<>();
		return searchResults;
	}

	public Song selectSong(int index) {
		return searchResults.get(index);
	}
}

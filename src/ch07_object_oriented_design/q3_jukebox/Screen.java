package ch07_object_oriented_design.q3_jukebox;

import java.util.ArrayList;

public class Screen {
	private static Screen _instance;

	public static Screen getInstance() {
		if (_instance == null) {
			_instance = new Screen();
		}
		
		return _instance;
	}

	private SearchEngine engine = new SearchEngine();

	public void displaySong(Song song) {
		// display song information
	}

	public void clearScreen() {
		// clear song information
	}

	public void search(String keyword) {
		displaySearchResults(engine.search(keyword));
	}

	public void selectSong(int songIndex) {
		Player.getInstance().addToQueue(engine.selectSong(songIndex));
	}

	private void displaySearchResults(ArrayList<Song> search) {
		// display song list of search result
	}

	public void displayMainScreen() {
		//empty screen with search
	}

}

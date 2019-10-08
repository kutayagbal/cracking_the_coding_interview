package ch07_object_oriented_design.q1_deck_of_cards;

import java.util.ArrayList;

public class Round {
	private ArrayList<Player> winners;
	private boolean isEnded;

	public Round() {
		winners = new ArrayList<>();
	}

	public ArrayList<Player> getWinners() {
		return winners;
	}

	public void setWinners(ArrayList<Player> winners) {
		this.winners = winners;
	}

	public boolean isEnded() {
		return isEnded;
	}

	public void setEnded(boolean isEnded) {
		this.isEnded = isEnded;
	}

}

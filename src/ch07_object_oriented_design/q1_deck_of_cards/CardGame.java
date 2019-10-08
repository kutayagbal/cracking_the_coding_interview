package ch07_object_oriented_design.q1_deck_of_cards;

import java.util.ArrayList;

public abstract class CardGame {
	private ArrayList<Player> players;
	private ArrayList<Round> rounds;
	
	public CardGame() {
		this.players = new ArrayList<>();
		this.rounds = new ArrayList<>();
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public ArrayList<Round> getRounds() {
		return rounds;
	}
	public void setRounds(ArrayList<Round> rounds) {
		this.rounds = rounds;
	}
	
	
	
}

package ch07_object_oriented_design.q1_deck_of_cards;

import java.util.ArrayList;

public class Player {
	private String name;
	private int score;
	private ArrayList<Card> hand;
	private boolean wantsCard;

	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public boolean isWantsCard() {
		return wantsCard;
	}

	public void setWantsCard(boolean wantsCard) {
		this.wantsCard = wantsCard;
	}

	
}

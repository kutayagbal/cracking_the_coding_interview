package ch07_object_oriented_design.q1_deck_of_cards;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards = null;
	private int endIndexOfDeck;

	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void shuffle() {
		Card temp = null;
		for (int i = 0; i < cards.size(); i++) {
			int firstIndex = new Random().nextInt(52);
			int secondIndex = new Random().nextInt(52);

			temp = cards.get(firstIndex);
			cards.set(firstIndex, cards.get(secondIndex));
			cards.set(secondIndex, temp);
		}
	}

	public ArrayList<Card> giveCard(int cardNum) {
		ArrayList<Card> givenCards = null;
		if (endIndexOfDeck - cardNum >= 0) {
			givenCards = new ArrayList<>();
			for (int i = endIndexOfDeck - 1; i >= 0; i--) {
				givenCards.add(cards.get(i));
			}

			endIndexOfDeck -= cardNum;
		}

		return givenCards;
	}

	public int getEndIndexOfDeck() {
		return endIndexOfDeck;
	}

	public void setEndIndexOfDeck(int endIndexOfDeck) {
		this.endIndexOfDeck = endIndexOfDeck;
	}

}

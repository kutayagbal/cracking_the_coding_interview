package ch07_object_oriented_design.q1_deck_of_cards.solution;

import java.util.ArrayList;

public class Deck<T extends Card> {
	private ArrayList<T> cards; // all cards, dealt or not
	private int dealtIndex = 0; // marks first undealt card

	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		cards = deckOfCards;
	}

	public void suffle() {

	}

	public int remainingCards() {
		return cards.size() - dealtIndex;
	}

	public T[] dealHand(int number) {
		T[] hand = (T[]) new BlackJackCard[number];

		for (int i = 0; i < number; i++) {
			hand[i] = cards.get(dealtIndex + i);
		}

		dealtIndex += number;

		return hand;
	}

	public T dealCard() {
		dealtIndex++;
		return cards.get(dealtIndex - 1);
	}
}

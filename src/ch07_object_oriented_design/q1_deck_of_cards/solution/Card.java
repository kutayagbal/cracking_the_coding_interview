package ch07_object_oriented_design.q1_deck_of_cards.solution;

public abstract class Card {
	private boolean available = true;

	protected int faceValue;
	protected Suit suit;

	/*
	 * number or face that's on card - a number 2 through 10, or 11 for Jack, 12 for
	 * Queen, 13 for King, or 1 for Ace
	 */

	public Card(int c, Suit s) {
		faceValue = c;
		suit = s;
	}

	public abstract int value();

	public Suit suit() {
		return suit;
	}

	/* Checks if the card is available to be given out to someone */
	public boolean isAvailable() {
		return available;
	}

	public void markAvailable() {
		available = true;
	}

	public void markUnavailable() {
		available = false;
	}

}

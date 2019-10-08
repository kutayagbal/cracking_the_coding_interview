package ch07_object_oriented_design.q1_deck_of_cards;

public class PlayingCard extends Card {
	public enum PlayingCardType {
		Clubs, Spades, Hearts, Diamonds
	}

	private int value;
	private PlayingCardType type;

	public PlayingCardType getType() {
		return type;
	}

	public void setType(PlayingCardType type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

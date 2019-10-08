package ch07_object_oriented_design.q1_deck_of_cards.solution;

public class BlackJackCard extends Card {
	public BlackJackCard(int c, Suit s) {
		super(c, s);
	}

	public int value() {
		if (isAce()) {
			return 1;
		} else if (faceValue >= 11 && faceValue <= 13) {
			return 10;
		}

		return faceValue;
	}

	public boolean isAce() {
		return faceValue == 1;
	}

	public int minValue() {
		if (isAce()) {
			return 1;
		} else {
			return value();
		}
	}

	public int maxValue() {
		if (isAce()) {
			return 11;
		} else {
			return value();
		}
	}

	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}
}

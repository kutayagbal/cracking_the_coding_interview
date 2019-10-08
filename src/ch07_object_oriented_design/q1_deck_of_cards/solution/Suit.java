package ch07_object_oriented_design.q1_deck_of_cards.solution;

public enum Suit {
	Club(0), Diamond(1), Heart(2), Spade(3);
	
	private int value;

	private Suit(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

	public static Suit getSuitFromValue(int v) {
		if (v == 0) {
			return Club;
		} else if (v == 1) {
			return Diamond;
		} else if (v == 2) {
			return Heart;
		} else if (v == 3) {
			return Spade;
		}

		return null;
	}

}

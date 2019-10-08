package ch07_object_oriented_design.q1_deck_of_cards;

import ch07_object_oriented_design.q1_deck_of_cards.Card.CardType;
import ch07_object_oriented_design.q1_deck_of_cards.PlayingCard.PlayingCardType;

public class DeckFactory {
	public static Deck createDeck(CardType type) {
		if (type == CardType.PlayingCard) {
			return createPlayingCardDeck();
		} else if (type == CardType.Monopoly) {
			return createMonopolyDeck();
		} else if (type == CardType.Monopoly) {
			return createTabuDeck();
		} else {
			return null;
		}
	}

	private static Deck createTabuDeck() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Deck createMonopolyDeck() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Deck createPlayingCardDeck() {
		Deck deck = new Deck();
		PlayingCard card = new PlayingCard();
		for (int i = 0; i < 52; i++) {
			card.setValue((i % 13) + 1);

			if (i < 13) {
				card.setType(PlayingCardType.Clubs);
			} else if (i < 26) {
				card.setType(PlayingCardType.Spades);
			} else if (i < 39) {
				card.setType(PlayingCardType.Hearts);
			} else if (i < 52) {
				card.setType(PlayingCardType.Diamonds);
			}
			
			deck.getCards().add(card);
		}
		
		return deck;
	}

}

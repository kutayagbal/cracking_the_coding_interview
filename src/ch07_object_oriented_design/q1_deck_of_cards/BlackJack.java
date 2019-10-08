package ch07_object_oriented_design.q1_deck_of_cards;

import java.util.ArrayList;

import ch07_object_oriented_design.q1_deck_of_cards.Card.CardType;

public class BlackJack extends CardGame {
	private Deck deck;

	public BlackJack() {
		this.deck = DeckFactory.createDeck(CardType.PlayingCard);
		this.deck.setEndIndexOfDeck(deck.getCards().size());
	}

	public boolean addPlayer(Player p) {
		if (this.getRounds().get(this.getRounds().size() - 1).isEnded()) {
			this.getPlayers().add(p);
			return true;
		}

		return false;
	}

	public boolean removePlayer(Player p) {
		if (this.getRounds().get(this.getRounds().size() - 1).isEnded()) {
			this.getPlayers().remove(p);
			return true;
		}

		return false;
	}

	public void deal(int cardNum) {
		for (Player p : this.getPlayers()) {
			p.setHand(deck.giveCard(cardNum));
		}
	}

	public void playRound() {
		Round round = new Round();
		round.setEnded(false);
		this.getRounds().add(round);
		deal(2);

		Player p = null;
		boolean isWanted = true;
		while (isWanted) {
			isWanted = false;
			for (int i = 0; i < this.getPlayers().size(); i++) {
				p = getPlayers().get(i);

				if (p.isWantsCard()) {
					p.getHand().add(deck.giveCard(1).get(0));
					isWanted = true;
				}
			}
		}

		round.setWinners(findWinners());
		round.setEnded(true);
		this.getRounds().add(round);
	}

	// Wrong
	public ArrayList<Player> findWinners() {
		ArrayList<Player> winners = new ArrayList<>();
		int closestVal = 0;
		for (Player p : this.getPlayers()) {
			int totalValue = 0;
			for (Card c : p.getHand()) {
				int val = ((PlayingCard) c).getValue();
				if (val == 1) {
					if (totalValue + 11 > 21) {
						totalValue += 1;
					} else {
						totalValue += 11;
					}
				} else {
					totalValue += val;
				}

				if (totalValue < 21 & totalValue >= closestVal) {
					winners.add(p);
				}
			}
		}

		return winners;
	}

}

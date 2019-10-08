package ch07_object_oriented_design.q1_deck_of_cards.solution;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard> {
	/*
	 * There are multiple possible scores for a blackjack hand, since aces have
	 * multiple values. Return the highest possible score that's under 21, or the
	 * lowest score that's over.
	 */

	public int score() {
		ArrayList<Integer> scores = possibleScores();

		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;

		for (int score : scores) {
			if (score > 21 && score < minOver) {
				minOver = score;
			} else if (score <= 21 && score > maxUnder) {
				maxUnder = score;
			}
		}

		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}

	/*
	 * return a list of all possible scores this hand could have (evaluating each
	 * ace as both 1 and 11
	 */
	public ArrayList<Integer> possibleScores() {
		ArrayList<Integer> scores = new ArrayList<>();
		for (BlackJackCard c : cards) {
			if (c.isAce()) {
				int minValue = c.minValue();
				int maxValue = c.minValue();

				ArrayList<Integer> newScores = new ArrayList<>();
				for (Integer s : scores) {
					newScores.add(s + minValue);
					newScores.add(s + maxValue);
				}
				scores = newScores;
			} else {
				for (Integer s : scores) {
					s += c.value();
				}
			}
		}

		return scores;
	}

	public boolean busted() {
		return score() > 21;
	}

	public boolean is21() {
		return score() == 21;
	}
}

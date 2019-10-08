package ch07_object_oriented_design.q1_deck_of_cards;

import java.util.ArrayList;

public class PlayBlackjack {

	public static void main(String[] args) {
		Player p1 = new Player("Kutay");
		Player p2 = new Player("Ali");
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		BlackJack bj = new BlackJack();
		bj.setPlayers(players);
		bj.playRound();
		
		Round r = bj.getRounds().get(bj.getRounds().size() - 1);
		System.out.println(r.getWinners().get(0));
	}

}

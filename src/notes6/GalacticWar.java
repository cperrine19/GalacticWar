package notes6;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class GalacticWar {
	private List<String> members = List.of("Austin", "Chelsea", "Dalton", "DanielTeh", "DanielTondra", 
			"Darrin", "Dustin", "Henry", "James", "Jordan", "Stephanie", 
			"Khou", "Kolby", "Logan", "Matt", "Michaeline", "Misty", "Pierce");

	private Random random = new Random();

	public static void main(String[] args) {
		new GalacticWar().run();
	}

	private void run() {
		List<String> names = new LinkedList<>(members);
		Player player1 = findPlayer(names);
		Player player2 = findPlayer(names);
		System.out.println(player1.getName() + " is playing " + player2.getName());

		Deck deck = new Deck();
		deck.shuffle();

		deal(deck, player1, player2);
		play(player1, player2);
		declareWinner(player1, player2);

	}

	private void declareWinner(Player player1, Player player2) {
		if (player1.getScore() > player2.getScore()) {
			printWinner(player1, player2);
		} else if (player2.getScore() > player1.getScore()) {
			printWinner(player2, player1);
		} else {
			printTie(player2, player2);
		}
	}

	private void printTie(Player player1, Player player2) {
		System.out.println(player1 + " and " + player2 + " tied with a score of " + player1.getScore());
	}

	private void printWinner(Player winner, Player loser) {
		System.out.println(winner.getName() + " is the glorious winner with a score of " + winner.getScore() + " and "
				+ loser.getName() + " is the miserable loser with a score of " + loser.getScore());
		;
	}

	private void play(Player player1, Player player2) {
		int numTurns = player1.getHand().size();
		for(int turn = 0; turn < numTurns; turn++) {
			Card card1 = player1.flip();
			Card card2 = player2.flip();
			if(card1.getRank() > card2.getRank()) {
			player1.incrementScore();
		} else if ( card2.getRank() > card1.getRank()); {
			player2.incrementScore();
			}
		}
		}
	

	private void deal(Deck deck, Player player1, Player player2) {
		int size = deck.size();

		for (int index = 0; index < size; index++) {
			if (index % 2 == 0) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}
	}

	private Player findPlayer(List<String> names) {
		int pos = random.nextInt(names.size());
		String playerName = names.remove(pos);
		return new Player(playerName);
	}
}

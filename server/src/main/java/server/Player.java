package server;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> handcards;
	private String playername;
	private int playernum;

	public Player(String playername) {
		this.playername = playername;
	}

	public void sethandcards(ArrayList<Card> handcard) {
		handcards = handcard;
	}
	public ArrayList<Card> gethandcards(){
		return handcards;
	}
	public ArrayList<Card> drawCard(Card card) {

		handcards.add(card);
		handcards = Rules.sorthandcard(handcards);
		return handcards;
	}

	public void ShowCards() {
		for (int i = 0; i < handcards.size(); i++) {
			System.out.print((i + 1) + ":" + handcards.get(i));
		}
		System.out.println(" ");
	}

	public Card playCard(int a) {
		Card deleted = handcards.remove(a - 1);
		return deleted;
	}
}

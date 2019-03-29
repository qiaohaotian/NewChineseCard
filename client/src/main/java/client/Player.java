package client;

import java.util.ArrayList;


public class Player {
	private ArrayList<Card> handcards;
	private int playernum;
	public void sethandcards(ArrayList<Card> handcard) {
		handcards = handcard;
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
	public ArrayList<Card> getHandcards(){
		return handcards;
	}
}

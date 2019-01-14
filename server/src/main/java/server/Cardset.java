package server;

import java.util.ArrayList;
import java.util.Random;
import server.Card;

public class Cardset {
	private ArrayList<Card> cardsPile = new ArrayList<Card>();
	private ArrayList<Card> discardPile = new ArrayList<Card>();
	static String[] NUMBER1 = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	static String[] COLOR1 = new String[] { "条", "饼", "万" };
	static String[] NUMBER2 = new String[] { "东", "西", "南", "北" };
	static String[] COLOR2 = new String[] { "风" };
	static String[] COLOR3 = new String[] { "色" };
	static String[] NUMBER3 = new String[] { "红", "绿", "白" };

	public void create() {
		for (int i = 0; i < 3; i++) {
			addBaseCards();
			addFJCards();
			addCards();
		}
	}

	public Card randomCard() {
		int n = new Random().nextInt(cardsPile.size());
		return cardsPile.remove(n);
	}

	private void addBaseCards() {
		for (int i = 0; i < NUMBER1.length; i++) {
			for (int j = 0; j < COLOR1.length; j++) {
				Card card = new Card(NUMBER1[i], COLOR1[j], i);
				cardsPile.add(card);
			}
		}
	}

	private void addFJCards() {
		for (int i = 0; i < NUMBER2.length; i++) {
			Card card = new Card(NUMBER2[i], COLOR2[0], i);
			cardsPile.add(card);
		}
	}

	private void addCards() {
		for (int i = 0; i < NUMBER3.length; i++) {
			Card card = new Card(NUMBER3[i], COLOR3[0], i);
			cardsPile.add(card);
		}
	}
	public void gether(Card card){
		discardPile.add(card);
	}
	public ArrayList<Card> firstDraw(){
		ArrayList<Card> handcards= new ArrayList<Card>();
		int a = cardsPile.size();
		for(int i=0;i<13;i++){
			int n = new Random().nextInt(a-i) ;
			handcards.add(cardsPile.remove(n));
		}
		handcards=Rules.sorthandcard(handcards);
		return handcards;
	}
	public boolean empty() {
		return cardsPile.size()==0;
	}
	public int getsize(){
		return cardsPile.size();
	}
}

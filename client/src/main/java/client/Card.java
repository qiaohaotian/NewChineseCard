package client;

public class Card {
	private String color;
	private String number;
	private int no;

	public Card(String number, String color, int no) {
		this.color = color;
		this.number = number;
		this.no = no;
	}

	public String getColor() {
		return color;
	}

	public String getNumber() {
		return number;
	}

	public int getNo() {
		return no;
	}

	public boolean equal(Card other) {
		return this.color.equals(other.getColor()) && this.number.equals(other.getNumber());
	}

	public boolean biggerthan(Card other) {
		return this.no > other.getNo();
	}

	@Override
	public String toString() {
		return number + color + " ";
	}

	public String transform() {
		return number + " " + color + " " + String.format("%d", no) + " ";
	}
}

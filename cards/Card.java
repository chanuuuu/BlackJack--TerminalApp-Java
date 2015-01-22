package cards;
public class Card {
	private Suit suit;
	private Rank rank;
	private boolean available;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		available = true;
	}
	
	public int getValue() {
		return rank.getValue();
	}
	
	public String toString() {
		return rank.toString()+" of "+suit.toString();
	}
	
	public boolean getAvailability() {
		return available;
	}

	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public void setAvailability(boolean b) {
		// TODO Auto-generated method stub
		available = b;
	}
}

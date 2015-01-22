package cards;
import java.util.ArrayList;


public class Hand {
	private ArrayList<Card> cards;
	
	public Hand(Card cardOne, Card cardTwo) {
		cards = new ArrayList<Card>();
		cards.add(cardOne);
		cards.add(cardTwo);
	}
	
	public int addCard(Card card) {
		cards.add(card);
		return getValue();
	}
	
	/**
	 * 
	 * @return the value of your hand. it may return a value more than 21 
	 * and leave it to the client to handle appropriate behaviour. 
	 * Value of a hand is computed using values of each {@link Card} that it contains,
	 * which is computed in {@link Card#getValue()}
	 */
	public int getValue() {
		int aceCount = 0, restTotal = 0;
		for(Card c : cards)
			if(c.getValue()==1)
				aceCount++;
			else
				restTotal+=c.getValue();
		if(aceCount>0 && restTotal<=11-aceCount)
		{
			aceCount--;
			restTotal+=11;
		}

		return restTotal+aceCount;
	}	
	
	public String toString() {
		String s = "";
		for(int i=0; i<cards.size()-1; i++)
			s+=cards.get(i)+", ";
		return s+cards.get(cards.size()-1) + " ("+ getValue()+")";
	}
}

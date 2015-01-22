package cards;
public class Deck {
	private Card card[][];
	private final int shuffleTime = 10;
	
	public Deck() {
		card = new Card[4][13];
		for(int i=0; i<4; i++)
			for(int j=0;j<13;j++)
				card[i][j] = new Card(new Suit(i+1), new Rank(j+1));
	}
	
	public void shuffle() {
		int randomSuit1, randomRank1;
		int randomSuit2, randomRank2;

		for(int i=0; i<1000; i++) {
			randomSuit1 = (int) (Math.random()*4);
			randomRank1 = (int) (Math.random()*13);
			randomSuit2 = (int) (Math.random()*4);
			randomRank2 = (int) (Math.random()*13);
			Card temp = card[randomSuit1][randomRank1];
			card[randomSuit1][randomRank1] = card[randomSuit2][randomRank2];
			card[randomSuit2][randomRank2] = temp;
		}
	}

	public Card getRandomCard() {
		int randomSuit, randomRank;
		do {
			randomSuit = (int) (Math.random()*4);
			randomRank = (int) (Math.random()*13);
		} while(card[randomSuit][randomRank].getAvailability()==false);
		card[randomSuit][randomRank].setAvailability(false);
		
		return card[randomSuit][randomRank];
	}
	
	public void reset() {
		for(int i=0; i<4; i++)
			for(int j=0;j<13;j++)
				card[i][j].setAvailability(true);
	}
}

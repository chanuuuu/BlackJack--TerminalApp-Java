package players;

import java.util.Scanner;

import cards.Card;
import cards.Hand;


public class Player implements Comparable<Player> {
	private Hand hand;
	private int balance;

	public Player() {
	}

	public Player(int balance, boolean house) {
		setBalance(balance);
	}

	public void getHand(Hand hand) {
		this.hand = hand;
	}

	public boolean bust() {
		return hand.getValue()>21;
	}

	public int getHandTotal() {
		return hand.getValue();
	}

	public int getCard(Card card) {
		return hand.addCard(card);
	}

	public boolean takeAnotherCard() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Get another card? ");
		String choice = scanner.next();
		if(choice.substring(0,1).equalsIgnoreCase("y"))
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(Player other) {
		// TODO Auto-generated method stub
		if(getHandTotal() > other.getHandTotal())
			return 1;
		if(getHandTotal() < other.getHandTotal())
			return -1;
		return 0;
	}

	public int getBalance() {
		return balance;
	}

	public void debit(int amount) {
		// TODO Auto-generated method stub
		this.balance-=amount;
	}

	public void credit(int amount) {
		this.balance+=amount;
	}

	public void dealHand(Hand hand) {
		this.hand = hand;
	}

	public Hand getHand() {
		return hand;
	}

	public void setBalance(int balance) {
		if(balance > 0) {
			this.balance = balance;
		}
	}

	public boolean isBlackJack() {
		// TODO Auto-generated method stub
		return hand.getValue()==21;
	}

}

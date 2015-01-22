package players;

import java.util.Scanner;

import cards.Deck;
import cards.Hand;

public class Game {
	private Player player;
	private Player house;
	private Deck deck;
	private final int minAmount = 100, maxAmount = 100000;
	private final int minBet = 10;
	private int currentBet;
	
	public Game() {
		deck = new Deck();
		player = new Player();
		house = new House();
		buyChips();
	}
	
	public boolean newRound() {
		deck.reset();

		while(player.getBalance() < minAmount)
			buyChips();
	
		boolean playOn = takeBet();
		
		if(playOn == false)
			return false;
	
		
		player.debit(currentBet);
		house.debit(currentBet);
		
		System.out.println("Player");
		System.out.println("_____________________________________________");
		
		
		player.dealHand(new Hand(deck.getRandomCard(), deck.getRandomCard()));
		
		System.out.println(player.getHand());

		while(!player.isBlackJack() && !player.bust() && player.takeAnotherCard())
		{
			player.getCard(deck.getRandomCard());
			System.out.println(player.getHand());
		}
		
		if(player.isBlackJack()) {
			System.out.println(player.getHand());
			displayResult(0);
		}
		else if(player.bust()) {
			System.out.println(player.getHand());
			displayResult(1);
		}
		else {
			System.out.println("House");
			System.out.println("_____________________________________________");
			house.dealHand(new Hand(deck.getRandomCard(), deck.getRandomCard()));
			System.out.println(house.getHand());

			while(!house.bust() && house.takeAnotherCard()) {
				house.getCard(deck.getRandomCard());
				System.out.println(house.getHand());
			}
		
			if(house.bust()) {
				System.out.println(house.getHand());
				displayResult(2);
			}
			else {
				displayResult(3);
			}
		}
		return true;
	}
		
	public void buyChips() {
		Scanner scanner = new Scanner(System.in);		
		int amount = 0;
		do {
			System.out.print("Current balance "+player.getBalance()+", how many chips do you want to buy (in $s)? ");
			while(!scanner.hasNextInt()) {
				scanner.next();
			}
			
			amount = scanner.nextInt();
			player.setBalance(player.getBalance()+amount);
		} while(player.getBalance() < minAmount || player.getBalance() > maxAmount);	
	}
	
	public boolean takeBet() {
		Scanner scanner = new Scanner(System.in);		
		do {
			System.out.print("Enter betting amount in $s for this round (0 to exit): ");
			int bet = scanner.nextInt();
			if(bet==0)
				return false;
			while(bet>player.getBalance())	
			{
				System.out.println("Oops, not enough chips, need "+(bet-player.getBalance())+" more");
				System.out.print("Buy more (buy) or change bet (change)? ");
				String choice = scanner.next();
				if(choice.equalsIgnoreCase("buy"))
					while(bet>player.getBalance())
					{
						buyChips();
						if(bet > player.getBalance())
							System.out.println("Oops, not enough chips, need "+(bet-player.getBalance())+" more");
					}
				else
					bet = -1;
			}
			currentBet = bet;
		} while(currentBet < minBet);
		return true;
	}
	
	public void displayResult(int code) {
		System.out.println("_____________________________________________");
		switch(code) {
			case 0: player.credit(2*currentBet);
					System.out.println("$$$$$ BLACKJACK $$$$$\nAmount won in round: "+currentBet);
					System.out.println("Remaining balance: "+player.getBalance());
					break;
			case 1: System.out.println("Amount lost in round: "+currentBet);
					System.out.println("Player bust, house wins :-(");
					System.out.println("Remaining balance: "+player.getBalance());
					break;
			case 2: player.credit(2*currentBet);
					System.out.println("Amount won in round: "+currentBet);
					System.out.println("House bust, you win :-)");
					System.out.println("Remaining balance: "+player.getBalance());
					break;
			case 3: if(player.compareTo(house) == 1) {
						player.credit(2*currentBet);
						System.out.println("Amount won in round: "+currentBet);
						System.out.println("Player wins "+player.getHandTotal()+" : "+house.getHandTotal());		
					}
					else if(player.compareTo(house) == -1) {
						System.out.println("Amount lost in round: "+currentBet);
						System.out.println("House wins "+house.getHandTotal()+" : "+player.getHandTotal());		
					}
					else {
						player.credit(currentBet);
						System.out.println("Tie "+house.getHandTotal()+" : "+player.getHandTotal());		
					}
					System.out.println("Remaining balance: "+player.getBalance());
		}
	}
}

package testDrive;
import players.Game;

/**
 * 
 * @author Chanikya Mandapathi
 * Blackjack application
 * Version 3.5.1
 * Dated: 11th August, 2012
 */

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		while(game.newRound()) {
		}
	}
}

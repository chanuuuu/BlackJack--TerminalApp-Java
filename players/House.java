package players;

public class House extends Player{
	public boolean takeAnotherCard() {
		if(getHandTotal()<=17)
			return true;
		else 
			return false;
	}
}

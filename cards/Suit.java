package cards;
public class Suit {
		private int value;
		
		public Suit(int value) {
			if(value<1)
				value = 1;
			if(value>4)
				value=4;
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		public String toString() {
			switch(value) {
				case 1: return "Clubs";
				case 2: return "Diamonds";
				case 3: return "Hearts";
				case 4: return "Spades";
			}
			return "Ouchy";
		}
}
package cards;
public class Rank {
		private int value;
		private int number;
		
		public Rank(int number) {
			if(number <1)
				number = 1;
			if(number > 13)
				number = 13;
			this.number = number;
			value = number;
			if(value<1)
				value = 1;
			if(value>10)
				value=10;
		}
		
		public int getValue() {
			return value;
		}
		
		public String toString() {
			switch(number) {
				case 1:  return "Ace"; 
				case 11: return "Jack"; 
				case 12: return "Queen"; 
				case 13: return "King"; 
				default: return ""+value;
			}
		}
}
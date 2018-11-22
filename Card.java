
public class Card {

	private Suit suit; 
	private int rank;

	/**
	 * @param s suit
	 * @param r rank
	 */
	
	public enum Suit{              // 用enum存放 Clubs,Diamonds,Hearts,Spades
		Clubs,Diamonds,Hearts,Spades
		}
	
	public Card(Suit s, int r) {    //把s的型態改為Suit
		suit = s;
		rank = r;
	}
	
	public void printCard() {		
		String su = "";
		String rk = "";

		
		switch (suit) {          //用switch判斷suit是哪一個並列出來
		case Clubs:
			System.out.println("Clubs Card");
			break;
			
		case Diamonds:
			System.out.println("Diamonds Card");
			break;
			
		case Hearts:
			System.out.println("Hearts Card");
			break;
			
		case Spades:
			System.out.println("Spades Card");
			break;
		}


		switch (rank) {
		case 1:
			rk = "Ace";
			break;
		case 2:
			rk = "Two";
			break;
		case 3:
			rk = "Three";
			break;
		case 4:
			rk = "Four";
			break;
		case 5:
			rk = "Five";
			break;
		case 6:
			rk = "Six";
			break;
		case 7:
			rk = "Seven";
			break;
		case 8:
			rk = "Eight";
			break;
		case 9:
			rk = "Nine";
			break;
		case 10:
			rk = "Ten";
			break;
		case 11:
			rk = "Jack";
			break;
		case 12:
			rk = "Queen";
			break;
		case 13:
			rk = "King";
			break;
		}
		System.out.println(suit + "," + rank + " as " + su + " " + rk);
	}

	public Suit getSuit() {  //因型態改變故原本int改成Suit
		return suit;
	}

	public int getRank() {
		return rank;
	}
}

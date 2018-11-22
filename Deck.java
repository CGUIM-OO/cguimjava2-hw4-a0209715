import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	public ArrayList<Card> usedCard = new ArrayList<Card>(); //初始化usedCard
	private ArrayList<Card> openCard = new ArrayList<Card>();//初始化openCard
	
	public int nUsed = 0;

	public Deck(int nDeck) {
		
		cards = new ArrayList<Card>();
		
		for (int i = 1; i <= nDeck; i++) {
			for (Card.Suit s : Card.Suit.values()) {
				for (int m = 1; m <= 13; m++) {
					Card card = new Card(s, m);
					cards.add(card);
				}
			}
		}
		shuffle();  //讓程式每跑一次就洗一次牌
	}
	
	public void printDeck() {
		
		for(int l = 0; l < cards.size(); l++) {
			Card takecard = cards.get(l);
			takecard.printCard();
		}		
	}
	
	public ArrayList<Card> getAllCards() {
		
		return cards;
	}
	
	public void shuffle() {		
		
		Random rnd = new Random();
		
		cards.addAll(openCard);     //把用過的牌放回 cards中
		openCard.clear();           //重置openCard
		nUsed = 0;
		
		for(int i = 0; i < cards.size(); i++) { //用cards.size決定要跑幾圈
			int a = rnd.nextInt(cards.size());  //用a存放亂數的值，並隨機找一個位子交換
			Card b = cards.get(a);              //取一個變數存放亂數位置中的值
			cards.set(a,cards.get(i));          //用此亂數位置的值放入第i位置的值
			cards.set(i,b);                     //第i位置的值放入存於a的值
		}
	}
	
	public Card getOneCard (boolean isOpened){		
		
		if(cards.size() == 0 ) {     //當cards裡面沒牌時，用shuffle()洗牌
			shuffle();
		}
		
		Card value = cards.get(0);   //設一個變數存放第一張牌的值
		usedCard.add(cards.get(0));  //把第一張牌的值放入usedCard
		cards.remove(0);             //把第一張牌的值移除  
		nUsed ++;                    //nUsed+1
		
		return value;                //回傳value
	}
	
	public ArrayList<Card> getOpenedCard(){//回傳此副牌中所有打開過的牌
		
		return openCard;	
	}
}

import java.util.ArrayList;

public class Player {
	
	private String name;
	 private int chips;//玩家有的籌碼
	 private int bet;//玩家此局下注籌碼
	 private ArrayList<Card> oneRoundCard = new ArrayList<Card>();

	public Player(String name, int chips) {
		
		this.name = name;   //指定name為this.name
		this.chips = chips; //指定chips為this.chips
		
	}
	
	 public String getName() { 
		 
		return name;  //回傳name
	 }
	
	 public int makeBet() {
		 
		 if(chips == 0) {//用if判斷還有沒有錢，如果chips=0(沒錢)，則把bet設為0，讓玩家不能下注
				bet = 0; 
			}
			bet = 1;     //基本下注一次1元
			return bet;  //回傳bet
	 }
	 
	 public void setOneRoundCard(ArrayList<Card> cards) {
		 
		 oneRoundCard=cards; //此牌局所得到的卡
	 }
	 
	 public boolean hitMe() {
		 
		int value = 0;                               //用value存現在卡牌點數
		for(int i = 0;i < oneRoundCard.size();i++ ) {//用for迴圈，存oneRoundCard的值到value裡
			Card oRC = oneRoundCard.get(i);
			value = value + oRC.getRank();
		}
		
	     if(value <17) { //點數小於17繼續要牌
	    	 return true;
	     }
	     
		 return false;  //點數大於等於17停止要牌
	 }
	 
	 
	 public int getTotalValue() {//同hitMe概念
		
		 int TotalValue = 0;
		 for(int i = 0; i < oneRoundCard.size(); i++) {
				Card oPRC = oneRoundCard.get(i);
				TotalValue = TotalValue + oPRC.getRank();
			}
		
		 return TotalValue;
	 }
	 
	 public int getCurrentChips() {//回傳玩家現有籌碼
		
		 return chips;
	 }
	 
	 public void increaseChips (int diff) {//籌碼變動
		 
		 chips=diff;
	 }
	 
	 public void sayHello() {
		 System.out.println("Hello, I am " + name + ".");
		 System.out.println("I have " + chips + " chips.");
	 }
}

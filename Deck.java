import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	public ArrayList<Card> usedCard = new ArrayList<Card>(); //��l��usedCard
	private ArrayList<Card> openCard = new ArrayList<Card>();//��l��openCard
	
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
		shuffle();  //���{���C�]�@���N�~�@���P
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
		
		cards.addAll(openCard);     //��ιL���P��^ cards��
		openCard.clear();           //���mopenCard
		nUsed = 0;
		
		for(int i = 0; i < cards.size(); i++) { //��cards.size�M�w�n�]�X��
			int a = rnd.nextInt(cards.size());  //��a�s��üƪ��ȡA���H����@�Ӧ�l�洫
			Card b = cards.get(a);              //���@���ܼƦs��üƦ�m������
			cards.set(a,cards.get(i));          //�Φ��üƦ�m���ȩ�J��i��m����
			cards.set(i,b);                     //��i��m���ȩ�J�s��a����
		}
	}
	
	public Card getOneCard (boolean isOpened){		
		
		if(cards.size() == 0 ) {     //��cards�̭��S�P�ɡA��shuffle()�~�P
			shuffle();
		}
		
		Card value = cards.get(0);   //�]�@���ܼƦs��Ĥ@�i�P����
		usedCard.add(cards.get(0));  //��Ĥ@�i�P���ȩ�JusedCard
		cards.remove(0);             //��Ĥ@�i�P���Ȳ���  
		nUsed ++;                    //nUsed+1
		
		return value;                //�^��value
	}
	
	public ArrayList<Card> getOpenedCard(){//�^�Ǧ��ƵP���Ҧ����}�L���P
		
		return openCard;	
	}
}

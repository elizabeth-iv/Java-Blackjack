import java.util.ArrayList;


public class Deck {

    ArrayList<Card> deck = new ArrayList<>();
    String[] cardValues = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    String[] cardSuits = new String[] {"Clubs", "Spades", "Diamonds", "Hearts"};
    ArrayList<Card> tDeck = new ArrayList<>();

    public Deck() {
        for(int i = 0; i < 4; i++) {
            for(int x = 0; x < 13; x++) {
                deck.add(new Card(cardSuits[i],cardValues[x]));
            }

        }
    }

    public void shuffle() {
        Integer makeRandom;
        for(int x = 0; x < 52; x++ ) {
            tDeck.add(deck.get(x));
        }
        for(int i = 0; i < 52; i++) {
            makeRandom = (int)(Math.random()*tDeck.size());
            deck.set(i , tDeck.get(makeRandom));
        }
    }

    public Card draw() {
        int drawACard = (int)(Math.random()*deck.size()-1);
        Card card = deck.get(drawACard);
        deck.remove(drawACard);
        return card;
    }
}
public class Card {
    String cardSuit;
    String cardValue;

    public Card(String cardSuit, String cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public Integer cardValue() {
        if (cardValue.equals("King") || cardValue.equals("Queen") || cardValue.equals("Jack")) {
            cardValue = "10";
        } else if (cardValue.equals("Ace")) {
            cardValue = "11";
        }
        return Integer.parseInt(cardValue);
    }

    public String toString() {
        return cardValue + " of " + cardSuit;
    }
}


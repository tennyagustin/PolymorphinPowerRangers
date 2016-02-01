/**
 * Created by simonhamermesh on 2/1/16.
 */
class Deck {
    static final int numberOfCards = 52;// a full deck has 52 cards unique
    Card[] masterDeck = new Card[numberOfCards];

    Deck() {
        // generating a valid set of 52 cards
        int i = 0;
        for (CardRank r : CardRank.values()) {
            for (CardSuit s : CardSuit.values()) {
                masterDeck[i] = new Card(r, s);
                masterDeck[i++].seqNo = i;
            }
        }
    }

    public void shuffle() {
        Card tempCard;
        int x = 0;
        for (int i = 0; i < numberOfCards; i++) {
            x = (int) (Math.random() * numberOfCards);
            tempCard = masterDeck[i];
            masterDeck[i] = masterDeck[x];
            masterDeck[x] = tempCard;
        }
    }

    public void printDeck() {
        System.out.println();
        for (Card c : masterDeck) {
            System.out.println(c.seqNo + " " + c.rank + " " + c.suit);
        }
    }
}
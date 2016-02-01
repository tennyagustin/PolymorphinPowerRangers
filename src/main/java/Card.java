/**
 * Created by simonhamermesh on 2/1/16.
 */
enum CardRank {
    Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
};

enum CardSuit {
    Diamond, Heart, Club, Spade
};

class Card {
    // a card must have a rank and suit.
    CardRank rank;
    CardSuit suit;
    int seqNo;
    boolean drawn = false;

    Card(CardRank r, CardSuit s) {
        // a card can only be constructed only with a valid rank and a valid
        // suit.
        this.rank = r;
        this.suit = s;
    }

    int compareTo(Card c) {
        int compResult = -9999;
        if (this.rank.ordinal() == c.rank.ordinal()) {
            compResult = 0;
        } else if (this.rank.ordinal() < c.rank.ordinal()) {
            compResult = -1;
        } else if (this.rank.ordinal() > c.rank.ordinal()) {
            compResult = 1;
        }
        return compResult;
    }

    void printCard() {
        System.out.print(" " + seqNo + " " + rank + " " + suit + " " + drawn + " ");
    }
}
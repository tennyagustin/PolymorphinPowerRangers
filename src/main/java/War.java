/**
 * Created by rogi on 1/29/16.
 */

    enum CardRank {
        Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
    };

    enum CardSuit {
        Spade, Heart, Dimond, Clubs
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

        int compareTo(Card c)
        {
            int compResult = -9999;
            if (this.rank.ordinal() == c.rank.ordinal()) {
                compResult = 0;
            } else if (this.rank.ordinal() < c.rank.ordinal()) {
                compResult = -1;
            } else if (this.rank.ordinal() > c.rank.ordinal()) {
                compResult = 1;
            }
            return compResult ;
        }
    }

    class Deck {
        static final int numberOfCards = 52;// a full deck has 52 cards unique
        Card[] cards = new Card[numberOfCards];

        Deck() {
            // generating a valid set of 52 cards
            int i = 0;
            for (CardRank r : CardRank.values()) {
                for (CardSuit s : CardSuit.values()) {
                    cards[i] = new Card(r, s);
                    cards[i++].seqNo = i;
                }
            }
        }

        public void shuffle() {
            Card tempCard;
            int x = 0;
            for (int i = 0; i < numberOfCards; i++) {
                x = (int) (Math.random() * numberOfCards);
                tempCard = cards[i];
                cards[i] = cards[x];
                cards[x] = tempCard;
            }
        }

        public void printDeck() {
            System.out.println();
            for (Card c : cards) {
                System.out.println(c.seqNo + " " + c.rank + " " + c.suit);
            }
        }
    }

    class WarPlayer extends Player {
        Card[] hand = new Card[Deck.numberOfCards];
    }

public class War extends Game implements CardGame {
        Deck d = new Deck();
        int initalHandSize;

        War(String gameName, Player player) {
            this.gameType = gameName;
            gamePlayers.add(player);
            gamePlayers.add(new WarPlayer());
            initalHandSize = d.numberOfCards / gamePlayers.size();
        }

        public void dealCards() {
            d.shuffle();

            int i = 0;
            // deal to player 1
            for (i = 0; i < initalHandSize; i++) {
                ((WarPlayer) gamePlayers.get(0)).hand[i] = d.cards[i];
                ((WarPlayer) gamePlayers.get(0)).cards[i] = d.cards[i].seqNo;
            }

            // deal to player 2
            int j = 0;
            for (i = initalHandSize; i < d.numberOfCards; i++) {
                ((WarPlayer) gamePlayers.get(1)).hand[j] = d.cards[i];
                ((WarPlayer) gamePlayers.get(1)).cards[j++] = d.cards[i].seqNo;
            }

            for (i = 0; i < initalHandSize; i++) {
                System.out.println(
                        ((WarPlayer) gamePlayers.get(0)).name + " " +
                                ((WarPlayer) gamePlayers.get(0)).cards[i] + " " +
                                ((WarPlayer) gamePlayers.get(0)).hand[i].seqNo + " " +
                                ((WarPlayer) gamePlayers.get(0)).hand[i].rank + " " +
                                ((WarPlayer) gamePlayers.get(0)).hand[i].suit
                );
            }

            for (i = 0; i < initalHandSize; i++) {
                System.out.println(
                        ((WarPlayer) gamePlayers.get(1)).name + " " +
                                ((WarPlayer) gamePlayers.get(1)).cards[i] + " " +
                                ((WarPlayer) gamePlayers.get(1)).hand[i].seqNo + " " +
                                ((WarPlayer) gamePlayers.get(1)).hand[i].rank + " " +
                                ((WarPlayer) gamePlayers.get(1)).hand[i].suit

                );
            }
        }

        public int drawCard() {
            if (((WarPlayer) gamePlayers.get(0)).hand[0] != null) {
                ((WarPlayer) gamePlayers.get(0)).hand[0].drawn = true;
            } else {
                return 2; //player 2 won
            }


            if (((WarPlayer) gamePlayers.get(1)).hand[0] != null) {
                ((WarPlayer) gamePlayers.get(1)).hand[0].drawn = true;
            } else {
                return 1; //player 1 won
            }

            return 0;  //game still on
        }

        public void adjustHands() {
            WarPlayer Player1 = ((WarPlayer) gamePlayers.get(0));
            WarPlayer Player2 = ((WarPlayer) gamePlayers.get(1));

            Card p1card0 = Player1.hand[0];
            Card p2card0 = Player2.hand[0];
            p1card0.drawn = false;
            p2card0.drawn = false;

            int i1, i2;
            for (i1 = 1; i1 < d.numberOfCards; i1++) {
                if (Player1.hand[i1] != null) {
                    Player1.hand[i1 - 1] = Player1.hand[i1];
                } else {
                    Player1.hand[i1 - 1] = null;
                    break;
                }
            }

            for (i2 = 1; i2 < d.numberOfCards; i2++) {
                if (Player1.hand[i2] != null) {
                    Player2.hand[i2 - 1] = Player2.hand[i2];
                } else {
                    Player1.hand[i2 - 1] = null;
                    break;
                }
            }

            if (p1card0.compareTo(p2card0) == -1) {
                Player2.hand[i2++] = p2card0;
                Player2.hand[i2] = p1card0;
            }
            if (p1card0.compareTo(p2card0) == 1) {
                Player1.hand[i1++] = p1card0;
                Player1.hand[i1] = p2card0;
            }

            if (p1card0.compareTo(p2card0) == 0) {  // call gotoWar()
                Player1.hand[i1++] = p1card0;
                Player1.hand[i1] = p2card0;
            }
        }

        public int compareDrawnCards() {
            return ((WarPlayer) gamePlayers.get(0)).hand[0].compareTo(((WarPlayer) gamePlayers.get(1)).hand[0]);
        }


        //---------------------------------
        //public int gotoWar(){}

        public int checkResult() {
            return 0;
        }

        public String cardTransposer(int[] playersHand) {
            return "";
        }
    //}

       public static void main(String[] args) {

            Player p = new WarPlayer();
            War w = new War("WarGame", p);
            w.dealCards();

            int Drawcount = 1;
            System.out.println("Draw " + Drawcount++);
            int i = w.drawCard();
            while (i == 0) {
                w.adjustHands();
                System.out.println("Draw " + Drawcount++);
                i = w.drawCard();
            }
            System.out.println("Player " + i + " won!");

            //w.checkResult();

/*        Deck d = new Deck();
        d.printDeck();
        d.shuffle();
        d.printDeck();
*/    }
    }
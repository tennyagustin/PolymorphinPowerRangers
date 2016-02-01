import java.util.ArrayList;

/**
 * Created by rogi on 1/29/16.
 */

public class War extends Game implements CardGame {
    //-----------main()---------------------------
    public static void main(String[] args) {

        Player p = new Player();
        War w = new War("WarGame", p);



        w.dealCards();
        int drawcount = 1;
        System.out.println("Draw " + drawcount++);
        int i = w.drawCard();
        while (i == 0) {
            w.adjustHands();
            System.out.println("Draw " + drawcount++);
            i = w.drawCard();
        }
        System.out.println("Player " + i + " won!");

        //w.checkResult();

/*        Deck d = new Deck();
        d.printDeck();
        d.shuffle();
        d.printDeck();
*/
    }

    //----------main() ends-----------------------



    Deck d = new Deck();
    int initialHandSize=26;
    Card p1card0;
    Card p2card0;
    int p1lastCardPosition = 0;
    int p2lastCardPosition = 0;
    Player Player1;
    Player Player2;

    /*****  CONSTRUCTOR *****/
    War(String gameName, Player player) {
        System.out.println("Welcome to the War game!");
        this.gameType = gameName;
        gamePlayers.set(0,player);

        Player p = new Player();
        p.name = "Computer";

        gamePlayers.add(p);
        //initialHandSize = d.numberOfCards / gamePlayers.size();

        Player1 = (gamePlayers.get(0));
        Player2 = (gamePlayers.get(1));

        p1card0 = Player1.hand[0];
        p2card0 = Player2.hand[0];

        playWar();
    }
    /*****    END OF CONSTRUCTOR ******/


    private void playWar(){
        dealCards();
        int drawcount = 1;
        System.out.println("Draw " + drawcount++);
        int i = checkForWinner();
        while (i == 0) {
            display();
            adjustHands();
            System.out.println("Draw " + drawcount++);
            i = checkForWinner();
        }
        System.out.println("Player " + i + " won!");
    }

    public void dealCards() {
        d.shuffle();
        int j = 0;
        for(int i = 0; i<gamePlayers.size(); i++ ) {

            for (; j < initialHandSize; j++) {
                (gamePlayers.get(i)).hand[j] = d.masterDeck[j];
                (gamePlayers.get(i)).cards[j] = d.masterDeck[j].seqNo;
                System.out.println((gamePlayers.get(i)).name + " " +
                        (gamePlayers.get(i)).cards[j] + " " +
                        (gamePlayers.get(i)).hand[j].seqNo + " " +
                        (gamePlayers.get(i)).hand[j].rank + " " +
                        (gamePlayers.get(i)).hand[j].suit);
            }
        }
    }

    public int checkForWinner() {

        if ((gamePlayers.get(0)).hand[0] != null) {
            (gamePlayers.get(0)).hand[0].drawn = true;
            System.out.print(( gamePlayers.get(0)).name);
            gamePlayers.get(0).hand[0].printCard();
        } else {
            return 2; //player 2 won
        }


        if ((gamePlayers.get(1)).hand[0] != null) {
            (gamePlayers.get(1)).hand[0].drawn = true;
            System.out.print(( gamePlayers.get(1)).name);
            (gamePlayers.get(1)).hand[0].printCard();
        } else {
            return 1; //player 1 won
        }

        return 0;  //game still on
    }

    public void adjustHands() {

        p1card0.drawn = false;
        p2card0.drawn = false;


        for(int i = 0; i<gamePlayers.size();i++ ) {

            for (int j = 1; j < d.numberOfCards; j++) {
                if (gamePlayers.get(i).hand[j] != null) {
                    gamePlayers.get(i).hand[j - 1] = Player1.hand[j];
                } else {
                    gamePlayers.get(i).hand[--j] = null;
                    if(i == 0){p1lastCardPosition = j;}else{p2lastCardPosition =j;}
                    break;
                }
            }
        }

        compareDrawnCards();
    }

    public void compareDrawnCards() {

        if (p1card0.compareTo(p2card0) == -1) {
            Player2.hand[p2lastCardPosition ++] = p2card0;
            Player2.hand[p2lastCardPosition] = p1card0;
        }
        if (p1card0.compareTo(p2card0) == 1) {
            Player1.hand[p1lastCardPosition++] = p1card0;
            Player1.hand[p1lastCardPosition] = p2card0;
        }

        if (p1card0.compareTo(p2card0) == 0) {  // call gotoWar()
            Player1.hand[p1lastCardPosition++] = p1card0;
            Player1.hand[p1lastCardPosition] = p2card0;
        }

    }

    public int checkResult() {
        return 0;
    }
    public void display(){
        int[] displayIntArrayP1Card = new int[1];
        int[] displayIntArrayP2Card = new int[1];
        displayIntArrayP1Card[0] = p1card0.seqNo;
        displayIntArrayP2Card[0] = p2card0.seqNo;
        System.out.println("PLAYER 1 CARD:"+"\n");
        System.out.println(cardTransposer(displayIntArrayP1Card));
        System.out.println("PLAYER 2 CARD:"+"\n");
        System.out.println(cardTransposer(displayIntArrayP2Card));
    }
    public String cardTransposer(int[] x) {
        return CardsToString.magic(CardsToString.convertArrayTOArrayList(x)) ;
    }
    public String cardTransposer(ArrayList<Integer>x ){
        return null;
    }

    public int drawCard() {
        return 0;
    }
}

//------------------------------------------------
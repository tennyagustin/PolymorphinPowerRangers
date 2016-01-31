import java.util.ArrayList;

/**
 * Created by rogi on 1/29/16.
 */


public class BlackJack extends Game implements CardGame {

    /*** FIELD ***/
    private int dealersTopCardStorage; //Holds dealers card while card back is inserted for display purposes.
    private ArrayList<Integer> bjDeck = new ArrayList<Integer>(); //Will be the deck that is used by the game. Setup fills this with deck implemented from CardGame.
    private ArrayList<Integer> blankHandSpacer = new ArrayList<Integer>(){{add(0,53);add(1,53);}};//Makes a "two card hand" of blank spaces for display purposes.
    int bjInput=0; //To store scanner input in various methods.
    private Player sucker; //Used to refer to spot 0 in gamePlayers<> once User is assigned to this spot.
    private Player dealer; //Used to refer to spot 1 in gamePlayers<> once Player is assigned to this spot. Dealer is assumed to be spot 1.
    /*** END OF FIELD ***/

    BlackJack(String gameName, Player user){ //Constructor.

        setupGame(gameName,user);
    }

    /*** Assign gametype its name. Prompt user to enter number of other players. Initialize gamePlayers<> that was declared in parent class Game.
     Add User to spot 0, assign it reference sucker. Add new Players to gamePlayers<>, at least 2, one will be dealer. Assign dealer reference to
     gamePlayers.get(1) Player object.  Deal BlackJack.  ***/
    protected void setupGame(String gameName, Player user){

        this.gameType = gameName;

        do{ System.out.println("Welcome to BlackJack. We are looking forward to taking your money " +
                "Table costs 20 per game" +
                "\n" + "\n"+ "How many other players at your table? (Between 1-3)");
            bjInput = scanner.nextInt();}
        while (!(bjInput>0 && bjInput<4));

        this.gamePlayers = new ArrayList<Player>(bjInput + 2);



        this.gamePlayers.add(0,user);
        sucker = gamePlayers.get(0);

        for (int i = 1; i<bjInput+1;i++){
            this.gamePlayers.add(i, new Player());
        }

        dealer = gamePlayers.get(1);

        dealBlackJack();

    }
    /***  BlackJack hand starts with two cards. At beginning of every game of BlackJack, bjDeck is reestablished from "master" deck implemented from CardGame
     interface.  For each card in a hand(2), add "cards" from drawCard() to each Player's cards<>. This mimics dealing around a table. Check to see if dealer wins.
     Check to see if sucker wins.  ***/
    private void dealBlackJack() {

        int bjHand = 2;
        for(int i = 0; i<deck.length; i++){
            this.bjDeck.add(i,deck[i]);
        }

        for (int h = 0; h < bjHand; h++) {
            for (int i = 0; i < gamePlayers.size(); i++) {
                gamePlayers.get(i).cards.add(h, drawCard());
            }
        }

        if(checkForBlackJack(dealer)){
            lose();
        }
        if(checkForBlackJack(sucker)){
            win();
        }

        obscureDealersHand();
        display();
        hitOrStay();
    }

    /*** Store dealers first card for future. Set back of card in spot for display purposes. ***/
    private void obscureDealersHand(){
        dealersTopCardStorage = dealer.cards.get(0);
        dealer.cards.set(0,52);
    }

    /*** Set dealers card from storage back in hand. ***/
    private void renewDealersHand(){
        dealer.cards.set(0,dealersTopCardStorage);
    }

    /*** Clear screen with multiple newlines.  Label and display dealer's hand. Label and display sucker's hand. Label and display remaining gamePlayers' hands,
     separated by blankHandSpacer, all on same line.***/
    @Override
    protected void display() {
        System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
        System.out.println("DEALERS HAND");
        System.out.println(cardTransposer(dealer.cards));
        System.out.println("YOUR HAND");
        System.out.println(cardTransposer(sucker.cards));

        System.out.println("\n"+"\n");

        System.out.println("OTHER PLAYERS HANDS");
        for(int i=2; i<gamePlayers.size();i++){
            System.out.print(cardTransposer(gamePlayers.get(i).cards));
            System.out.print(cardTransposer(blankHandSpacer));
        }

    }

    /*** Receive a hand as argument. This will come from a Player object's cardHand<int>. Call "magic", return magic string to Display method. ***/
    public String cardTransposer(ArrayList<Integer> playersHand){
        return CardsToString.magic(playersHand);
    }

    /*** Request HIT or STAY. If STAY: add card to sucker's hand. Check for bust. Else display again and request HIT or STAY.
    If STAY: run BlackJack AI. When complete, display results. Check to see if sucker beat the dealer. ***/
    private void hitOrStay(){
        do{System.out.println("Would you like to hit or stay?" +
                "\n" + "Enter 1 to HIT; Enter 2 to STAY.");
            bjInput = scanner.nextInt();}
        while (!(bjInput>0 && bjInput<2));

        if(bjInput == 1){

            sucker.cards.add(drawCard());
            if(checkForBust(sucker)){
                lose();
            }
            display();
            hitOrStay();

        } else {
           runBlackJackAI();
           display();
           if(checkForBeatDealer(sucker)){win();}else{lose();}
        }
    }

    /*** BLACK JACK AI: Starting with the first non-dealer Player, while their hand tally is less than 14, they will "HIT". It is irrelevant
    for now whether they Bust as long as they cease to HIT. dealer's hand will be renewed with original card. While dealer's hand tally is less than 16, dealer
    will "HIT". Check if dealer busts. ***/
    private void runBlackJackAI(){

        for(int i = 2;i<gamePlayers.size();i++){
            while(tallyHand(gamePlayers.get(i).cards)<14)
                {gamePlayers.get(i).cards.add(drawCard());}
        }

        renewDealersHand();
        while(tallyHand(dealer.cards)<17)
            {dealer.cards.add(drawCard());}
        if(checkForBust(dealer)){win();}
    }

    /*** BASIC FOR NOW: THIS CASINO DOES NOT COUNT AN ACE AS A 1 or 11, ONLY 11***/
    /*** A Player object's cardHand<int> will be passed as argument. Hand tally starts at 0. Card value is determined by its value 0-51. Hand is tallied. ***/
    private int tallyHand(ArrayList<Integer> hand){
        int tallyHand=0;

        for(int card: hand){

            card = ((card%13)+2);
            if(card>10 && card<14){card = 10;}
            if(card>13){card = 11;}

            tallyHand+=card;
        }

        return tallyHand;
    }

    private boolean checkForBlackJack(Player x) {

        return (tallyHand(x.cards)==21);
    }

    private boolean checkForBeatDealer(Player x){

        return (tallyHand(x.cards) > tallyHand(dealer.cards));
    }

    private boolean checkForBust(Player x){

        return (tallyHand(x.cards)>21);
    }

    private void win(){
        display();

        do{System.out.println("Press Enter to continue");
        }while(!scanner.nextLine().equals(""));

        /*** WALLET ADDITION GOES HERE***/
        // for example: gamePlayers.get(0).wallet += 20;

        promptGameChange();
    }

    private void lose(){
        display();

        do{System.out.println("Press Enter to continue");
        }while(!scanner.nextLine().equals(""));

        /*** WALLET DEDUCTION GOES HERE***/
        // for example: gamePlayers.get(0).wallet -= 20;

        promptGameChange();
    }

    public int drawCard(){
        return 0;
    }

    public int checkResult(){
        return 0;
    }
}


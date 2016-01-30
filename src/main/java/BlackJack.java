/**
 * Created by rogi on 1/29/16.
 */
public class BlackJack extends Game implements CardGame {



 int drawCard(){
  return 0;
 };

 int checkResult(){
  return 0;
 };

 String cardTransposer(int[] playersHand){

     return null;
 };

 private void hitOrStay(){


    }

    private int tallyHand(){

        return 0;
    }

    private boolean checkForBlackJack(int handsValueBJ)
    {

    return false;
    }

    private boolean checkForBeatDealer(int dealerHand){

      return false;
    }

    private boolean checkForBust(int handValue){

      return false;

    }

    BlackJack(String gameName, Player player){

        gameType = gameName;
        System.out.println("Welcome to BlackJack. We are looking forward to taking your money " +
                "and pretending to be your friend"+ "\n" + "\n"+ "How many players at your table?");




        this.setupGame(gameName,player);




    }


    private void setupGame(String gameName, Player player){

        gameType = gameName;

        System.out.println("Welcome to BlackJack. We are looking forward to taking your money and pretending to be your friend");

        gamePlayers[0] = player;
        gamePlayers[1] = new Player();
    }

    //BlackJack(String Player){

    //}

}

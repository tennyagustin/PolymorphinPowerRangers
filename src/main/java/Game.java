import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by rogi on 1/29/16.
 */
public class Game {

    protected Scanner scanner = new Scanner(System.in);

    protected String gameType;

    protected ArrayList<Player> gamePlayers = new ArrayList<Player>(5);

    protected Random rand;




    protected void display(){


    }

    protected void setupGame(){


    }

    protected boolean promptGameChange(){

        System.out.println("Would you like to play another game? Enter yes, no or maybe to check" +
                " your wallet balance.");

        String userChoice = scanner.nextLine();

        if(userChoice == "yes"){
            Casino.offerGame(gamePlayers.get(0));
            return true;
        }
        else if(userChoice == "no"){
            System.out.println("OK, thanks for the money, chump!");
            return false;
        }
        else if(userChoice == "maybe"){
            checkWallet();
            System.out.println("Hit any key to return: ");
            String cheatingIsGood = scanner.nextLine();
            if(cheatingIsGood != "polymorphinpowerup"){
               promptGameChange();
            } else if(cheatingIsGood == "polymorphinpowerup"){
                System.out.println("Secret TapMAC Accessed. Enter an amount: ");
                String slushFunds = scanner.nextLine();
                int illicitFunds = Integer.parseInt(slushFunds);
                ((User)gamePlayers.get(0)).tapMAC(illicitFunds);
                checkWallet();
               promptGameChange();

            }

        }
    return false;
    }

    protected void checkWallet(){
        System.out.println("Your balance is: " + ((User)gamePlayers.get(0)).getWalletBalance());

    }


}

import java.util.Scanner;

/**
 * Created by rogi on 1/29/16.
 */
public class Casino {

    public static void main(String[] args){
        Scanner userName = new Scanner(System.in);
        User me = new User();
        System.out.println("Please enter your name:");
        me.name = userName.nextLine(); //this 'me.name' comes from player class

        Casino.offerGame(me);
    }

    public static void offerGame(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.name + " what game would you like to play? You can pick from BlackJack, War" +
                " and an awesome RPG as well!");
        String gameChoice = scanner.nextLine();
        Casino.startGame(gameChoice, player);

    }

    public static void startGame(String gameChoice, Player player){


        switch(gameChoice.toUpperCase()){

            case "WAR":
                new War(gameChoice, player);
                break;
            case "BLACKJACK":
                new BlackJack(gameChoice, player);
                break;
            case "RPG":
                new RPG(gameChoice, player);
                break;
            default:
                Scanner rePrompt = new Scanner(System.in);
                System.out.println("We don't have that game, please pick from War, BlackJack or RPG");
                String gameChoiceReprompt = rePrompt.nextLine();
                Casino.startGame(gameChoiceReprompt, player);
        }


    }
}

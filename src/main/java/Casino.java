/**
 * Created by rogi on 1/29/16.
 */
public class Casino {

    public static void main(String[] args){
        User me = new User();
        String name = me.name; //this 'me.name' comes from player class
        BlackJack bj = new BlackJack("blackjack", me);
    }

    public static void offerGame(){

    }

    public static void startGame(String name, Player player){

    }
}

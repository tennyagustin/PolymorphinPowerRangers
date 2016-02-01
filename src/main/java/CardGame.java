import java.util.ArrayList;

/**
 * Created by rogi on 1/29/16.
 */
public interface CardGame {

    int[] deck = new int[54]; //one for the blank space and one for back

    int drawCard();

    int checkResult();

    String cardTransposer(ArrayList<Integer> playersHand);

}

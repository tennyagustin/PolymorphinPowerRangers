import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by simonhamermesh on 1/31/16.
 */
public class CardsToString {

    public static int[] convertArrayListTOArray(ArrayList<Integer> x){

        /*** Takes an ArrayList and manually enters it into a regular Array for use in magic ***/

        int[] converterArray = new int[x.size()];

        for(int i=0; i<x.size();i++ ){

            converterArray[i] = x.get(i);
        }
        return converterArray;
    }

    public static String magic(ArrayList<Integer> x) {

        /*** Method takes and ArrayList of Integers, immediately makes into a regular Array by calling
         convertArrayListTOArray and setting the result equal to int[]cardHand to be used in magic ***/

        int[] cardHand = convertArrayListTOArray(x);

        int ASCIIartLength = 9;


        /*** Make a String Array big enough to hold every line of every card in the hand.
         THIS ALL OPERATES ON THE ASSUMPTION EACH ASCII ART IS IDENTICAL IN LENGTH ******/
        String[] bigHolder = new String[(ASCIIartLength * cardHand.length)];


        /*** For each card in hand, initialize a String Array to hold each line split by the newline character.
         Place it in the big holder. Item to be split is determined by outerloop counter "i" which tracks index in cardHand.
         Big holder spot is determined by outerloop counter "i" that tracks which card is currently spliced (ie 0 for
         the first card, 1 for the second card) AND innerloop counter "j" which keeps track of which line of the ASCII art
         is being spliced. Big holder will result in all lines of all cards laid out in order by Card;then Line. ***/

        for(int i = 0; i<cardHand.length; i++){

            String[] smallHolder = hm.get(cardHand[i]).split("\\n");

            for(int j = 0; j<smallHolder.length; j++){

                bigHolder[(ASCIIartLength*i)+j] = smallHolder[j];
            }
        }
        /*** Make a StringBuilder to reattach all line segments into one continuous String ***/
        StringBuilder stringBuilder = new StringBuilder();


        /*** Cycle through bigHolder once for each line of ASCII art ***/

        for(int h = 0; h<ASCIIartLength; h++){

            /*** For each line of ASCII art, pick the component of the card belonging to that line, Append it to
             stringBuilder, after each component is added, append a newline character.
             For example: The top line of the first card is at bigHolder[0], the top line of the second
             card is at bigHolder[9].  For first line of art, item selected to append will be h = 0, i = once for each card.
             First time around inner loop item selected to append will be located in bigHolder at a multiple of 9 (ASCII
             art length * i). Second time around it will be selected from 9 + 1("h" the second loop, "h" = 2 loop 3 thus
             multiples of 9+2, etc.) Inner loop continues one past number of cards to add a newline character to start
             next line. ***/

            for(int i = 0; i<cardHand.length+1; i++){

                if(i<cardHand.length){

                    stringBuilder.append(bigHolder[(ASCIIartLength*i)+h]);}

                else{stringBuilder.append("\n");}

            }

        }
        return stringBuilder.toString(); //Returns final product string
    }


    static HashMap<Integer, String> hm = new HashMap<Integer, String>();

    {
        hm.put(0, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    2    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(1, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    3    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(2, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    4    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(3, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    5    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(4, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    6    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(5, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    7    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(6, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    8    |\n" +
                "  ~~~~~~~~~ \n");
        hm.put(7, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    9    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(8, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    10   |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(9, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    J    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(10, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    Q    |\n" +
                "  ~~~~~~~~~ \n");
        hm.put(11, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    K    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(12, "  _________ \n" +
                " |         |\n" +
                " |    /|   |\n" +
                " |   / |   |\n" +
                " |   | /   |\n" +
                " |   |/    |\n" +
                " |         |\n" +
                " |    A    |\n" +
                "  ~~~~~~~~~ \n");


        hm.put(13, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    2    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(14, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    3    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(15, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    4    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(16, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    5    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(17, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    6    |\n" +
                "  ~~~~~~~~~ \n");


        hm.put(18, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    7    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(19, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    8    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(20, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    9    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(21, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    10   |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(22, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    J    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(23, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    Q    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(24, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    K    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(25, "  _________ \n" +
                " |         |\n" +
                " |    _    |\n" +
                " |  _( )_  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    A    |\n" +
                "  ~~~~~~~~~ \n");


        hm.put(26, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    2    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(27, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    3    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(28, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    4    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(29, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    5    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(30, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    6    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(31, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    7    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(32, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    8    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(33, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    9    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(34, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    10   |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(35, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    J    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(36, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    Q    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(37, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    K    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(38, "  _________ \n" +
                " |         |\n" +
                " |  ** **  |\n" +
                " | *  *  * |\n" +
                " |  *   *  |\n" +
                " |   * *   |\n" +
                " |    *    |\n" +
                " |    A    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(39, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    2    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(40, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    3    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(41, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    4    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(42, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    5    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(43, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    6    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(44, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    7    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(45, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    8    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(46, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    9    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(47, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    10   |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(48, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    J    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(49, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    Q    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(50, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    K    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(51, "  _________ \n" +
                " |         |\n" +
                " |    ^    |\n" +
                " |  .* *.  |\n" +
                " | (__ __) |\n" +
                " |    I    |\n" +
                " |         |\n" +
                " |    A    |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(52, "  _________ \n" +
                " |         |\n" +
                " |  POLY   |\n" +
                " | MORPHIN |\n" +
                " |         |\n" +
                " |  POWER  |\n" +
                " | RANGERS |\n" +
                " |         |\n" +
                "  ~~~~~~~~~ \n");

        hm.put(53, "            \n" +
                " |         |\n" +
                " |         |\n" +
                " |         |\n" +
                " |         |\n" +
                " |         |\n" +
                " |         |\n" +
                " |         |\n" +
                "            \n");
    }
}





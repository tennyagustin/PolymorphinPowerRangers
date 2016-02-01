import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by rogi on 1/30/16.
 */
public class GameSpec {

    Game testGame = new Game();
    User user1 = new User();


    @Before
    public void setUp() {
        //System.out.println(user1.getWalletBalance());
        testGame.gamePlayers.add(user1);


    }

    @Test
    public void testForPromptGameChange() {
        ByteArrayInputStream in = new ByteArrayInputStream("maybe\n1000\nyes".getBytes());


        System.setIn(in);


        testGame.promptGameChange();


    }

    @Test
    public void testSetGetWalletBalance() {
        int x = 1000;
        user1.setWalletBalance(1000);
        assertEquals("fails if setter doesn't change the wallet balance", x, user1.getWalletBalance());

    }

    @Test
    public void testTapMAC() {
        int x = 2000;
        user1.setWalletBalance(1000);
        user1.tapMAC(1000);

        assertEquals("fails if tapMAC method doesn't add the funds to the wallet", x, user1.getWalletBalance());


    }


}

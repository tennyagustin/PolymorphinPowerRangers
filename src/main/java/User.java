/**
 * Created by rogi on 1/29/16.
 */
public class User extends Player {
    private String myGame;
    private int wallet = 500;


    protected void tapMAC(int cashMoney) {
        wallet += cashMoney;

    }

    public void setWalletBalance(int cash) {
        this.wallet = cash;
    }

    public int getWalletBalance() {
        return this.wallet;
    }
}

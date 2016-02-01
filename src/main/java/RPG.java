import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Tenny on 1/30/16.
 */

enum spellTypes{
    FIRE, WATER, DEFEND, ELECTRIC
}

public class RPG extends Game {

    private static int[] healthPointArray = new int[2];
    private int currentSpell;

    boolean gameOver = false;
    boolean defending = false;

    ArrayList<Object> yourSpellbook;
    ArrayList<Object> opponentSpellbook;

    int yourHealthPoints = healthPointArray[0];
    int opponentHealthPoints = healthPointArray[1];

    spellTypes[] allSpells = {spellTypes.FIRE, spellTypes.WATER, spellTypes.DEFEND, spellTypes.ELECTRIC};
    int[] spellAccuracy = {50, 100, 100, 25};
    int[] spellDamage = {10, 5, 0, 15};

    RPG(String name, Player player) {

        gameType = name;

        gamePlayers[0] = player;
        gamePlayers[1] = new Player();

    }

    protected void setupGame() {

        int yourHealthPoints = 30;
        int opponentHealthPoints = 30;

        Random rand = new Random();


    public static void main(String[] args) {
        RPG myRPG = new RPG();
        myRPG.mainMenu();

    }

    public RPG() {

        yourSpellbook = new ArrayList<Object>();
        opponentSpellbook = new ArrayList<Object>();

        yourSpellbook.add(spellTypes.DEFEND);
        yourSpellbook.add(spellTypes.WATER);
        yourSpellbook.add(spellTypes.FIRE);
        yourSpellbook.add(spellTypes.ELECTRIC);

        opponentSpellbook.add(spellTypes.DEFEND);
        opponentSpellbook.add(spellTypes.WATER);
        opponentSpellbook.add(spellTypes.FIRE);
        opponentSpellbook.add(spellTypes.ELECTRIC);

    }

    private void mainMenu() {

        //while (!gameOver) {

        System.out.println("Choose an action: ATTACK, STATUS, SHOP, RUN?");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toUpperCase();

        if (input.equals("ATTACK")) {
            attack();
        } else if (input.equals("STATUS")) {
            display();
        } else if (input.equals("SHOP")) {
            getSpell();
        } else if (input.equals("RUN")) {
            System.out.println("Start prompt method.");
        }


    }

    private void attack() {

        System.out.println("Choose your attack.");
        Scanner scan = new Scanner(System.in);
        String currentSpell = scan.nextLine().toUpperCase();

        int damage = 0;
        int accuracy = 0;

        String successMessage = "";
        String failMessage = "";

        /*spellTypes spell = null;

        if (currentSpell.equals("WATER")) {
            spell = spellTypes.WATER;
        } else if (currentSpell.equals("FIRE")) {
            spell = spellTypes.FIRE;
        } else if (currentSpell.equals("ELECTRIC")) {
            spell = spellTypes.ELECTRIC;
        } else if (currentSpell.equals("DEFEND")) {
            spell = spellTypes.DEFEND;
        } else {
            // invalid input
            System.out.println("You can't do that shit.");
            //TODO: break
        }*/

        // user attack
            if (currentSpell.equals("WATER") && yourSpellbook.contains(spellTypes.WATER)) {
                yourSpellbook.remove(spellTypes.WATER);
                System.out.println("You cast a water spell.");
                damage = spellDamage[spellTypes.WATER.ordinal()];
                accuracy = spellAccuracy[spellTypes.WATER.ordinal()];
                successMessage = "You spell soaks your opponent's socks. Argh! Everyone hates wet socks!";
                failMessage = "How did you fail?";

            } else if (currentSpell.equals("FIRE") && yourSpellbook.contains(spellTypes.FIRE)) {
                yourSpellbook.remove(spellTypes.FIRE);
                System.out.println("You cast a fire spell.");
                damage = 10;
                accuracy = 50;
                successMessage = "You say, 'I've seen better spells at a dyslexic spelling bee!' Oooh, burn!";
                failMessage = "Your opponent puts up a bread shield. Yum! Toast!";

            } else if (currentSpell.equals("ELECTRIC") && yourSpellbook.contains(spellTypes.ELECTRIC)) {
                yourSpellbook.remove(spellTypes.ELECTRIC);
                System.out.println("You cast an electric spell.");
                damage = 15;
                accuracy = 25;
                successMessage = "You elec-trick your opponent into line dancing. When striking a disco pose, they're struck by lightning!";
                failMessage = "Your opponent electric slides out of the way!";

            } else if (currentSpell.equals("DEFEND") && yourSpellbook.contains(spellTypes.DEFEND)) {
                System.out.println("You defend.");
                defending = true;
                System.out.println("Why do we have to fight? You peacefully protest.");
            } else {
                System.out.println("You can't do that shit.");
            }


        if (!defending) {

            // check if attack succeeds
            if (rand.nextInt(100) < accuracy) {
                System.out.println(successMessage);
                opponentHealthPoints -= damage;
            } else {
                System.out.println(failMessage);
            }

            // print opponent health
            System.out.println("Your opponent now has " + opponentHealthPoints + " HP.");

            // enemy attack


        } else {
            defending = false;
        }


    }



    private void getSpell() {
        int spell;

        spell = rand.nextInt(4);
        yourSpellbook.add(allSpells[spell]);

        spell = rand.nextInt(4);
        opponentSpellbook.add(allSpells[spell]);

    }

    private void display() {
        System.out.println(yourSpellbook);
        System.out.println(opponentSpellbook);

        System.out.println("Your HP: " + yourHealthPoints);
        System.out.println("Opponent HP: " + opponentHealthPoints);
        mainMenu();
    }
}

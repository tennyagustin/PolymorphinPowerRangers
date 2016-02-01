import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by michaelbathon on 1/31/16.
 */

enum spellTypes{
    FIRE(10,50), WATER(5,100), DEFEND(0,100), ELECTRIC(15, 25);

    int damage;
    int accuracy;

    spellTypes(int dmg, int acc){
        this.damage = dmg;
        this.accuracy = acc;
    }
}

public class RPG extends Game {

    private static int[] healthPointArray = new int[2];
    private int currentSpell;

    boolean gameOver = false;
    boolean defending = false;

    ArrayList<spellTypes> yourSpellbook = new ArrayList<spellTypes>();
    ArrayList<spellTypes> opponentSpellbook = new ArrayList<spellTypes>();


    int yourHealthPoints = 30;
    int opponentHealthPoints = 30;

    Random rand = new Random();





    spellTypes[] allSpells = {spellTypes.FIRE, spellTypes.WATER, spellTypes.DEFEND, spellTypes.ELECTRIC};
    int[] spellAccuracy = {50, 100, 100, 25};
    int[] spellDamage = {10, 5, 0, 15};

    RPG(String name, Player player) {

        gameType = name;
        setupGame(player);


    }

    protected void setupGame(Player player) {

        gamePlayers.add(player);
        gamePlayers.add(new Player());

      /*  int yourHealthPoints = 30;
        int opponentHealthPoints = 30;

        Random rand = new Random();

        yourSpellbook = new ArrayList<spellTypes>();
        opponentSpellbook = new ArrayList<spellTypes>(); */

        yourSpellbook.add(spellTypes.DEFEND);
        yourSpellbook.add(spellTypes.WATER);
        yourSpellbook.add(spellTypes.FIRE);
        yourSpellbook.add(spellTypes.ELECTRIC);

        opponentSpellbook.add(spellTypes.DEFEND);
        opponentSpellbook.add(spellTypes.WATER);
        opponentSpellbook.add(spellTypes.FIRE);
        opponentSpellbook.add(spellTypes.ELECTRIC);
        mainMenu();
    }

  /* public TennyRPG() {

        yourSpellbook = new ArrayList<spellTypes>();
        opponentSpellbook = new ArrayList<spellTypes>();

        yourSpellbook.add(spellTypes.DEFEND);
        yourSpellbook.add(spellTypes.WATER);
        yourSpellbook.add(spellTypes.FIRE);
        yourSpellbook.add(spellTypes.ELECTRIC);

        opponentSpellbook.add(spellTypes.DEFEND);
        opponentSpellbook.add(spellTypes.WATER);
        opponentSpellbook.add(spellTypes.FIRE);
        opponentSpellbook.add(spellTypes.ELECTRIC);

    } */

    private void mainMenu() {

        checkHealth();

        if (!gameOver) {

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
                promptGameChange();
            }


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
            failMessage = "'WAT-ER you doing? You messed up your Water spell.";

        } else if (currentSpell.equals("FIRE") && yourSpellbook.contains(spellTypes.FIRE)) {
            yourSpellbook.remove(spellTypes.FIRE);
            System.out.println("You cast a fire spell.");
            damage = 10;
            accuracy = 50;
            successMessage = "'You're toast!' you say. Your puns hurt.";
            failMessage = "Your attack missed. Ooh, burn!";

        } else if (currentSpell.equals("ELECTRIC") && yourSpellbook.contains(spellTypes.ELECTRIC)) {
            yourSpellbook.remove(spellTypes.ELECTRIC);
            System.out.println("You cast an electric spell.");
            damage = 15;
            accuracy = 25;
            successMessage = "You elec-trick your opponent into line dancing. When striking a disco pose, they're struck by lightning!";
            failMessage = "Your opponent electric slides out of the way!";

        } else if (currentSpell.equals("DEFEND") && yourSpellbook.contains(spellTypes.DEFEND)) {
            System.out.println("You defend.");
            System.out.println("Why do we have to fight? You peacefully protest.");
            yourSpellbook.remove(spellTypes.DEFEND);
            defending = true;
            display();

        } else {
            System.out.println("You can't do that shit.");
            mainMenu();
        }


        if (!defending) {
            int hitChance = (int)(Math.random() * 100);
            int enemyHitChance = (int)(Math.random() * 100);

            spellTypes opAttack = opponentSpellbook.get(0);
            spellTypes opponentsAttackSelection = opponentSpellbook.get((rand.nextInt(opponentSpellbook.size())));
            if (opponentsAttackSelection != null) {
                opAttack = opponentsAttackSelection;
                opponentSpellbook.remove(opponentsAttackSelection);
            } else {
                while (opponentsAttackSelection == null) {
                    opponentsAttackSelection = opponentSpellbook.get(rand.nextInt(opponentSpellbook.size()));
                    opAttack = opponentsAttackSelection;
                    opponentSpellbook.remove(opponentsAttackSelection);
                }

            }

            if (enemyHitChance < opAttack.accuracy) {
                System.out.println("Your enemy casts a spell back!");
                yourHealthPoints -= opAttack.damage;
                System.out.println("You now have " + yourHealthPoints + " HP.");
            } else {
                System.out.println("Your enemy's spell misses!");
                System.out.println("You now have " + yourHealthPoints + " HP.");
            }

            // check if attack succeeds
            if ( hitChance < accuracy && opAttack != spellTypes.DEFEND) {
                System.out.println(successMessage);
                opponentHealthPoints -= damage;
            } else {
                System.out.println(failMessage);
            }

            // print opponent health
            System.out.println("Your opponent now has " + opponentHealthPoints + " HP.");

            // enemy attack

            display();
        }
        else {
            defending = false;
        }


    }

    private void checkHealth(){
        if(yourHealthPoints > 0 && opponentHealthPoints <= 0){
            System.out.println("You've slain that dastardly fiend! You won 1000 coins.");
            ((User)gamePlayers.get(0)).tapMAC(1000);
            checkWallet();
            gameOver = true;
            promptGameChange();
        }
        else if(yourHealthPoints <= 0 && opponentHealthPoints > 0){
            System.out.println("You lost, what a tragedy! You lost 500 coins.");
            ((User)gamePlayers.get(0)).tapMAC(-500);
            checkWallet();
            gameOver = true;
            promptGameChange();
        }

    }



    private void getSpell() {
        int spell;

        System.out.println("You went to the Spell Shop and bought new swag for you and your enemy. Spread the love!");
        ((User)gamePlayers.get(0)).tapMAC(-10);
        checkWallet();

        spell = rand.nextInt(4);
        yourSpellbook.add(allSpells[spell]);

        spell = rand.nextInt(4);
        opponentSpellbook.add(allSpells[spell]);
        display();
    }

    protected void display() {
        System.out.println(yourSpellbook);
        System.out.println(opponentSpellbook);

        System.out.println("Your HP: " + yourHealthPoints);
        System.out.println("Opponent HP: " + opponentHealthPoints);
        mainMenu();
    }
}
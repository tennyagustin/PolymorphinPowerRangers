/*
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tenny on 1/30/16.
 *



enum Spell {

DEFEND(0, 100), WATER(5, 100), FIRE(10, 50), ELECTRIC(15, 25);

int damageOutput;
int accuracy;

Spell(int damageOutput, int accuracy) {
this.damageOutput = damageOutput;
this.accuracy = accuracy;

}

}

//START OF RPG
public class RPG extends Game {
    
    Spell yourSpell;
    Spell opponentSpell;
    ArrayList<Integer> Spells = new ArrayList<Integer>();
    
    private static int[] healthPointArray = new int[2];
    private Player hero;
    private Player enemy;
    private int currentSpell;
    
    private boolean defending;
    //private boolean gameOver;
    
    int playerStartHealth = healthPointArray[0];
    int opponentStartHealth = healthPointArray[1];
    
    RPG(String name, Player player) {
        
        setupGame(name, player);
        
    }
    
    protected void setupGame(String name, Player hero) {
        
        this.gameType = name;
        
        this.gamePlayers = new ArrayList<Player>(2);
        
        this.gamePlayers.add(0, hero);
        hero = gamePlayers.get(0);
        
        hero.cards.set(0, Spell.DEFEND.ordinal());
        hero.cards.set(1, Spell.WATER.ordinal());
        hero.cards.set(2, Spell.FIRE.ordinal());
        hero.cards.set(3, Spell.ELECTRIC.ordinal());
        
        this.gamePlayers.add(1, enemy);
        
        enemy = gamePlayers.get(1);
        
        enemy.cards.set(0, Spell.DEFEND.ordinal());
        enemy.cards.set(1, Spell.WATER.ordinal());
        enemy.cards.set(2, Spell.FIRE.ordinal());
        enemy.cards.set(3, Spell.ELECTRIC.ordinal());
        
        System.out.println("Welcome to RPG");
        healthPointArray[0] = 30;
        healthPointArray[1] = 30;
        
        mainMenu();
        
    }
    private void mainMenu() {
        
        System.out.println("Choose an action: ATTACK, STATUS, SHOP, RUN?");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toUpperCase();
        
        if (input.equals("ATTACK")) {
            fight();
        } else if (input.equals("STATUS")) {
            display();
        } else if (input.equals("SHOP")) {
            getSpell();
        } else if (input.equals("RUN")) {
            promptGameChange();
        }
    }
    
    private void fight() {
        //pick a spell first; have logic to see if it's a valid spell
        //maybe use display to display current spells
        //indexOf and find first instance of something to check for available spell
        //replace
        //.get to get the spell in whatever index position
        
        int opponentAttackSelection = enemy.cards.get(rand.nextInt(enemy.cards.size()));
        if (rand.nextInt(100) < opponentSpell.accuracy) {
            playerStartHealth -= opponentSpell.damageOutput;
            enemy.cards.remove(opponentAttackSelection);
        }
        chooseSpell();
        compareSpell();
        display();
    }
    private int chooseSpell() {
        String heroChoice = scanner.nextLine();
        int currentSpell;
        //iterate through every item of hero's spells
        for (currentSpell = 0; currentSpell < hero.cards.size() - 1; currentSpell++) {
            return currentSpell;
        }
        //changes input to ordinal number of array
        if (heroChoice.equals(Spell.DEFEND.toString())) {
            currentSpell = Spell.DEFEND.ordinal();
        } else if (heroChoice.equals(Spell.WATER.toString())) {
            currentSpell = Spell.WATER.ordinal();
        } else if (heroChoice.equals(Spell.FIRE.toString())) {
            currentSpell = Spell.FIRE.ordinal();
        } else if (heroChoice.equals(Spell.ELECTRIC.toString())) {
            currentSpell = Spell.ELECTRIC.ordinal();
        } else {
            mainMenu();
        }
        //player choose spell
        while (!defending) {
            if (hero.cards.contains(currentSpell)) {
                if (rand.nextInt(100) < yourSpell.accuracy) {
                    opponentStartHealth -= yourSpell.damageOutput;
                    hero.cards.remove(currentSpell);
                }
            } else {
                System.out.println("You can't do that shit.");
            }
            while (defending) {
                if (hero.cards.contains(currentSpell) && heroChoice.equals("DEFEND")) {
                    opponentSpell.damageOutput = 0;
                    hero.cards.remove(currentSpell);
                } else if ()  //if enemy defends
                    }
        }
    }
    private void display(int yourCurrentHealth, int opponentCurrentHealth) {
        playerStartHealth = yourCurrentHealth;
        opponentStartHealth = opponentCurrentHealth;
        System.out.println("Your current health is: " + yourCurrentHealth);
        System.out.println("Your current opponent's health is " + opponentCurrentHealth);
        System.out.println("Your spells: " + hero.cards.toString() + "Opponent spells: " + enemy.cards.toString());
    }
    private void getSpell() {
        ;
        //new spell = random number  1-4
        //.add
        //pick random enum
        //example:  return Spell.values()[(int) (Math.random() * Color.values().length)];
        //append to spell arraylist
        //.ordinal for built-in arrayList
        //wallet interaction
    }
}
*/
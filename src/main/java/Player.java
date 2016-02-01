import java.util.Scanner;

/**
 * Created by rogi on 1/29/16.
 */
public class Player {
 protected int[] cards;
 protected Scanner scanner; // = new Scanner(System.in);
 protected String name; // = scanner.nextLine(); // this name goes to Casino

 Player() {
  cards = new int[52];
  System.out.println("Enter Players Name:");
  scanner = new Scanner(System.in);
  this.name = scanner.nextLine();
 }
}

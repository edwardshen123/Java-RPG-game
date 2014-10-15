import java.util.Scanner;

//Class for encounters
public class Encounter {
    //Game Clock
    private int tick = 0;

    //Slime Encounter
    public void slimeEncounter(Novice user) {
	System.out.println("You have encountered a slime");
	Slime slime = new Slime();
	Scanner user_input = new Scanner(System.in);
	while (true) {
	    //User Input Loop
	    while (true) {
		System.out.print("Input next move: ");
		if (user_input.next().equals("attack")) {
		    //User Attack
		    System.out.println("You have attacked the slime for " + user.attack(slime, 0) + " damage");
		    break;
		} else {
		    System.out.println("That is not a valid move");
		}
	    }
	    //User Victory
	    if (slime.isDead()) {
		System.out.println("You have vanquished the slime");
		System.out.println("You gained " + slime.getPExp() + " experience and " + slime.getGold() + " gold!");
		user.gainExp(slime.getPExp());
		user.gainGold(slime.getGold());
		break;
	    }
	    //Slime Attack
	    System.out.println("Slime has attacked you for " + slime.attack(user, 0) + " damage");
	    //Slime Victory
	    if (user.isDead()) {
		System.out.println("You have been vanquished by the slime");
		System.out.println("Game Over");
		break;
	    }
	    tick++;
	}
    }
}

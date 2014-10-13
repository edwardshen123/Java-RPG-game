import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
	Scanner user_input = new Scanner(System.in);

	//Introduction
        System.out.println("Welcome to Stuyablo");
	System.out.println("You are the next challenger to take on this dungeon");
	System.out.println("Before you begin your journey, I need to get your name. It is for corpse idenification purposes.");
	System.out.print("Please write your name here: ");
	Novice bUser = new Novice(user_input.next());
	System.out.println("Please go through the second door to the right, " + bUser);

	//Encounter
	Encounter slimeFight = new Encounter();
	slimeFight.slimeEncounter(bUser);
    }
}

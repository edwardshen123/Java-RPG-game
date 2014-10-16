import java.util.Scanner;
import java.lang.*;

public class Jiablo {
    public static void main(String[] args) throws InterruptedException {
	Scanner user_input = new Scanner(System.in);
	int sleepValue = 1000;

	//Introduction
        System.out.println("Welcome to Stuyablo");
	Thread.sleep(sleepValue);
	System.out.println("You are the next challenger to take on this dungeon");
	Thread.sleep(sleepValue);
	System.out.println("Before you begin your journey, I need to get your name. It is for corpse idenification purposes.");
	Thread.sleep(sleepValue);
	System.out.print("Please write your name here: ");
	//Wait for user to input name
	Novice bUser = new Novice(user_input.next());
	System.out.println("Please go through the second door to the right, " + bUser);
	Thread.sleep(sleepValue);

	//Encounter
	//Create encounter instance
	Encounter slimeFight = new Encounter();
	//Use slime encounter method
	slimeFight.slimeEncounter(bUser);
    }
}

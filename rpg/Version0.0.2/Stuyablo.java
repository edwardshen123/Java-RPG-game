import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Stuyablo {

    public Boolean run(PC[] playerList, NPC[] mobs) {
	return (self.getAgility() > other.getAgility());
    }
    public void printOptions(String[] actionPossible) {
	for (int counter = 0; counter < actionPossible.length; counter++) {
	    System.out.print(actionPossible[counter] + " || ");
	}
	System.out.print("\n");
    }
    public void Encounter(PC[] playerList, Scanner user_input, int mobCount) {
	NPC[] Mobs = new NPC[mobCount];
	for (int c = 0; c < mobCount; c++) {
	    Random randInt = new Random();
	    String[] mobList = {"zombie");
	    Mobs[c] = mobList[randInt.nextInt(mobList.length)];
	}
	int[] playerExp = {0, 0, 0, 0};
	while (true) {
	    for (int p = 0; p < 4; p++) {
		Skills playerSkills = new Skills(playerList[p]);
		System.out.println("It's " + playerList[p] + "\'s turn");
		String[] skillsList = playerSkills.getSkillsList();
		for (int s = 1; s < skillsList.length + 1; s++) {
		    System.out.print(skillsList[s - 1]);
		    System.out.print(" || ");
		    if (s%5 == 0) {
			System.out.println();
		    }
		}
		System.out.print("Enter a move: ");
		skill = "";
		skillInput(skill, skillsList, user_input);
		if (skill.equals("wildSwing")) {
		    playerSkills.wildSwing(playerList[p], zombie);
		    if (Mobs.getHealth() <= 0.0) {
			playerExp[p] = zombie.getKillExp();
		    }
		}
	    }
	    if (Mobs.getHealth() <= 0.0) {
		break;
	    }
	}
	if 
	for (int e = 0; e < 4; e++) {
	    playerList[e].setExp(playerList[e].getExp() + playerExp[e]);
	    System.out.println(playerList[e] + " gained " + playerExp[e] + " experiences");
	}
    }
    public void raceOptions() {
	String[] Races = {"Human", "Elf", "Giant", "Half-Elf"};
	for (int counter = 0; counter < Races.length; counter++) {
	    System.out.print(Races[counter] + " || ");
	}
	System.out.print("\n");
    }
    public void userMovement(String move, String[] moveOptions, World world) {
	if (Arrays.asList(moveOptions).contains(move)) {
	    if (move.equals("Exit Area")) {
		    System.out.println("Areas: ");
		}
	} else {
	    System.out.println("No Such Move");
		}
    }
    public void skillInput(String skill, String[] skillList, Scanner user_input) {
	skill = user_input.next();
	while (!Arrays.asList(skillList).contains(skill)) {
	    System.out.print("You have entered an invalid skill. Please enter another skill: ");
	    skill = user_input.next();
	}
    }
    public void raceInput(String race, Scanner user_input) {
	String[] Races = {"Human", "Elf", "Giant", "Half-Elf"};
	race = user_input.next();
	while (!Arrays.asList(Races).contains(race)) {
	    System.out.print("You have entered an invalid race. Please enter another race: ");
	    race = user_input.next();
	}
    }
    public void AI(NPC mob) {
	Skills npcSkills = new Skills(mob.toString());
    }

    public static void main(String[] args) {

	System.out.flush();

	Stuyablo controller = new Stuyablo();
	
	Scanner user_input = new Scanner(System.in);

	System.out.println("Welcome to the land of Stuylandia, travelers");
	System.out.println("Can I get your names?");

	System.out.print("Enter the warrior's name: ");
	String wName = user_input.next();
	controller.raceOptions();
	System.out.print("Enter the warrior's race: ");
	String wRace = "";
	controller.raceInput(wRace, user_input);
	PC warrior = new PC(wName, wRace, "Warrior");
	
        System.out.print("Enter the mage's name: ");
	String mName = user_input.next();
	controller.raceOptions();
	System.out.print("Enter the mage's race: ");
	String mRace = "";
	controller.raceInput(mRace, user_input);
	PC mage = new PC(mName, mRace, "Mage");

	System.out.print("Enter the rogue's name: ");
	String rName = user_input.next();
	controller.raceOptions();
	System.out.print("Enter the mage's race: ");
	String rRace = "";
	controller.raceInput(rRace, user_input);
	PC rogue = new PC(rName, rRace, "Rogue");
	
	System.out.print("Enter the priest's name: ");
	String pName = user_input.next();
	controller.raceOptions();
	System.out.print("Enter the priest's race: ");
	String pRace = "";
	controller.raceInput(pRace, user_input);
	PC priest = new PC(pName, pRace, "Priest");

	System.out.println(warrior + ", " + mage + ", " + rogue + ", " + priest + ". You are all now registered as official adventurers. Good Luck");
	
	World Stuy = new World();

	System.out.println("The four adventurers enter the town of " + Stuy.getLocation());

	String[] actions = Stuy.actionOptions();
	controller.printOptions(actions);
	controller.userMovement(user_input.next(), actions, Stuy);
    }

}

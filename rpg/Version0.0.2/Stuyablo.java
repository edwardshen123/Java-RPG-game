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
    public boolean deathChecker(NPC[] Mobs) {
	int length = Mobs.length;
	int healthSum = 0;
	for (int c = 0; c < length; c++) {
	    healthSum+=Mobs[c].getHealth();
	}
	return (healthSum <= 0);
    }
    public boolean deathChecker(PC[] Players) {
	int length = Players.length;
	int healthSum = 0;
	for (int c = 0; c < length; c++) {
	    healthSum+=Players[c].getHealth();
	}
	return (healthSum <= 0);
    }
    public void expAdder(PC[] playerList, int[] playerExp) {
	for (int p = 0; p < playerList.length; p++) {
	    playerList[p].setExp(playerList[p].getExp() + playerExp[p]);
	    System.out.println(playerList[p] + " gained " + playerExp[p] + " experience!");
	}
    }
    public void Encounter(PC[] playerList, Scanner user_input, int mobCount) {
	NPC[] Mobs = new NPC[mobCount];
	int[] mobsHealth = new int[mobCount];
	String[] attackSkills = {"wildSwing"};
	for (int c = 0; c < mobCount; c++) {
	    Random randInt = new Random();
	    String[] mobList = {"zombie");
	    int mobSelector = randInt.nextInt(mobList.length);
	    Mobs[c] = mobList[mobSelector];
	    
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
		String skill = "";
		skillInput(skill, skillsList, user_input);
		if (Arrays.asList(attackSkills).contains(skill)) {
		    if (skill.equals("wildSwing")) {
			playerSkills.wildSwing(playerList[p], Mobs);
		    }
		    if (Mobs.isDead()) {
		        playerExp[p] = Mobs.getKillExp();
		    }
		} else {
		    if (skill.equals("run")) {
		    }
		}
	    }
	    if (deathChecker(Mobs)) {
		System.out.println("Your Party Won!");
		expAdder(playerList, playerExp);
		break;
	    }
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
	    if (move.equals()) {
	    }
	    if (move.equals()) {
	    }
	    if (move.equals()) {
	    }
	    if (move.equals()) {
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
    public void intro(PC[] playerList, Stuyablo controller, Scanner user_input) {
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

	controller.flush();

	System.out.println(warrior + ", " + mage + ", " + rogue + ", " + priest + ". You are all now registered as official adventurers. Good Luck");
    }
    public void flush() {
    }
    public static void main(String[] args) {
	Stuyablo controller = new Stuyablo();

	controller.flush();
	
	Scanner user_input = new Scanner(System.in);

	PC[] playerList = new PC[4];
	controller.intro(PC[] playerList, Stuyablo controller ,Scanner user_input);
	
	World Stuy = new World();

	System.out.println("The four adventurers enter the town of " + Stuy.getLocation());

	String[] actions = Stuy.actionOptions();
	controller.printOptions(actions);
	controller.userMovement(user_input.next(), actions, Stuy);
    }

}

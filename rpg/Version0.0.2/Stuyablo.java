import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Stuyablo {

    //User combat run chance checker
    public Boolean run(PC[] playerList, NPC[] mobs) {
	double playerAgility = 0;
	for (int p = 0; p < playerList.length; p++) {
	    playerAgility += playerList[p].getAgility();
	}
	double avgPlayerAgility = playerAgility/playerList.length;
	double npcAgility = 0;
	for (int m = 0; m < mobs.length; m++) {
	    npcAgility += mobs[m].getAgility();
	}
	double avgNPCAgility = npcAgility/mobs.length;
	return (avgPlayerAgility > avgNPCAgility);
    }

    //Print options an user has
    public void printOptions(String[] options) {
	for (int counter = 0; counter < options.length; counter++) {
	    System.out.print(options[counter] + " || ");
	}
	System.out.print("\n");
    }

    //Checks if all Mobs are dead
    public boolean deathChecker(NPC[] Mobs) {
	int length = Mobs.length;
	int healthSum = 0;
	for (int c = 0; c < length; c++) {
	    healthSum+=Mobs[c].getHealth();
	}
	return (healthSum <= 0);
    }

    //Checks if all players are dead
    public boolean deathChecker(PC[] Players) {
	int length = Players.length;
	int healthSum = 0;
	for (int c = 0; c < length; c++) {
	    healthSum+=Players[c].getHealth();
	}
	return (healthSum <= 0);
    }

    //Add up the Exp after battle
    public void expAdder(PC[] playerList, int[] playerExp) {
	for (int p = 0; p < playerList.length; p++) {
	    playerList[p].setExp(playerList[p].getExp() + playerExp[p]);
	    System.out.println(playerList[p] + " gained " + playerExp[p] + " experience!");
	}
    }

    //Combat Encounter Method
    public void Encounter(PC[] playerList, Scanner user_input, int mobCount) {
	NPC[] Mobs = new NPC[mobCount];
	int[] mobsHealth = new int[mobCount];
	String[] attackSkills = {"wildSwing"};
	int[] playerExp = {0, 0, 0, 0};
	for (int c = 0; c < mobCount; c++) {
	    Random randInt = new Random();
	    String[] mobList = {"zombie"};
	    int mobSelector = randInt.nextInt(mobList.length);
	    Mobs[c] = new NPC(mobList[mobSelector]);
	    
	}
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
		Input(skill, skillsList, user_input, "skill");
		if (Arrays.asList(attackSkills).contains(skill)) {
		    if (skill.equals("wildSwing")) {
			playerSkills.wildSwing(playerList[p], Mobs[p]);
		    }
		    if (Mobs[p].isDead()) {
		        playerExp[p] = Mobs[p].getKillExp();
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
	    AI(Mobs, playerList);
	}
    }

    //Movement In Town, Plains and Dungeon Method
    public void userMovement(String move, String[] moveOptions, World world) {
	if (Arrays.asList(moveOptions).contains(move)) {
	    if (move.equals("Area")) {
		System.out.println("Areas: ");
		printOptions(world.getNextLocations());
		
	    }
	    if (move.equals("Changing Room")) {
	    }
	    if (move.equals("Locker")) {
	    }
	    if (move.equals("Nurse\'s Office")) {
	    }
	    if (move.equals("Battle")) {
	    }
	    if (move.equals("Search")) {
	    }
	    if (move.equals("Camp")) {
	    }
	} else {
	    System.out.println("No Such Move");
	}
    }

    //User Input checker
    public void Input(String input, String[] inputList, Scanner user_input, String inputType) {
	input = user_input.next();
	while (!Arrays.asList(inputList).contains(input)) {
	    if (inputType.equals("skill")) {
		System.out.print("You have entered an invalid skill. Please enter another skill: ");
	    }
	    if (inputType.equals("map")) {
		System.out.print("You have entered an invalid location. Please enter another location: ");
	    }
	    if (inputType.equals("race")) {
		System.out.print("You have entered an invalid race. Please enter another race: ");
	    }
	    input = user_input.next();
	}
    }

    //AI for mobs
    public void AI(NPC[] mob, PC[] players) {
	for (int n = 0; n < mob.length; n++) {
	    Skills npcSkills = new Skills(mob[n]);
	    String[] npcSkillsList = npcSkills.getSkillsList();
	    
	}
    }

    //Introduction Screen Method
    public void intro(PC[] playerList, Scanner user_input) {
	String[] raceList = {"Human", "Elf", "Giant", "Half-Elf"};
	
	System.out.println("Welcome to the land of Stuylandia, travelers");
	System.out.println("Can I get your names?");

	System.out.print("Enter the warrior's name: ");
	String wName = user_input.next();
        printOptions(raceList);
	System.out.print("Enter the warrior's race: ");
	String wRace = "";
        Input(wRace, raceList, user_input, "race");
	PC warrior = new PC(wName, wRace, "Warrior");
	
        System.out.print("Enter the mage's name: ");
	String mName = user_input.next();
        printOptions(raceList);
	System.out.print("Enter the mage's race: ");
	String mRace = "";
        Input(mRace, raceList, user_input, "race");
	PC mage = new PC(mName, mRace, "Mage");

	System.out.print("Enter the rogue's name: ");
	String rName = user_input.next();
        printOptions(raceList);
	System.out.print("Enter the mage's race: ");
	String rRace = "";
        Input(rRace, raceList, user_input, "race");
	PC rogue = new PC(rName, rRace, "Rogue");
	
	System.out.print("Enter the priest's name: ");
	String pName = user_input.next();
        printOptions(raceList);
	System.out.print("Enter the priest's race: ");
	String pRace = "";
        Input(pRace, raceList, user_input, "race");
	PC priest = new PC(pName, pRace, "Priest");

	playerList[0] = warrior;
	playerList[1] = mage;
	playerList[2] = rogue;
	playerList[3] = priest;

	flush();

	System.out.println(warrior + ", " + mage + ", " + rogue + ", " + priest + ". You are all now registered as official adventurers. Good Luck");
    }

    //Method to flush the screen
    public void flush() {
	//Gets os name
	String os = System.getProperty("os.name");
	//Checks if system is Windows
	try {
	    if (System.getProperty("os.name").startsWith("Windows")) {
		String[] clear = {"cmd", "/c", "cls"};
		Runtime.getRuntime().exec(clear);
	    } else {
		System.out.println("\033[2J");
	    }
	} catch (Exception e) {
	    System.out.println("Nope");
	}
    }

    public static void main(String[] args) {
	//Controller variable for accessing methods of Stuyablo
	Stuyablo controller = new Stuyablo();

	controller.flush();
	
	//User input variable
	Scanner user_input = new Scanner(System.in);
	PC[] playerList = new PC[4];

	controller.intro(playerList, user_input);
	
	World Stuy = new World();

	System.out.println("The four adventurers enter the town of " + Stuy.getLocation());

	String[] options = Stuy.actionOptions();
	controller.printOptions(options);
	controller.userMovement(user_input.next(), options, Stuy);
    }

}

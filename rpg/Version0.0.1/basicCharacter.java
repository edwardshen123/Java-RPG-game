import java.util.Random;

public class basicCharacter {

    //instance variables (character stats)
    private String characterName;
    private int maxHealth = 10;
    private int health = 10;
    private int level = 0;
    private int gold = 0;
    private int experience = 0;
    private int baseAttk = 5;
    private int levelExperience = 10;
    private int defense = 5;
    private int agility = 5;
    private int strength = 5;
    private int intelligence = 5;
    private int precision = 5;

    //For mobs only
    private int provideExperience = 0;

    //random instance object
    private Random randInt = new Random();


    
    //constructors

    //base constructor
    public basicCharacter() {
	characterName = "guest";
    }

    //initial constructor
    public basicCharacter(String initName) {
	characterName = initName;
    }

    //Promotion constructor
    public basicCharacter(String initName, int[] userStat) {
	characterName = initName;
	level = userStat[0];
	levelExperience = userStat[1];
	health = userStat[2];
	maxHealth = userStat[3];
	gold = userStat[4];
	baseAttk = userStat[5];
	strength = userStat[6];
	defense = userStat[7];
	intelligence = userStat[8];
	agility = userStat[9];
	precision = userStat[10];
    }

    //Mob or GM constructor
    public basicCharacter(String initName, int initLevel, int initGold, int initAttk, int initHealth, int initIntelligence, int initStrength, int initAgility, int initDefense, int initPrecision, int initMaxHealth, int initPExperience) {
	characterName = initName;
	level = initLevel;
	gold = initGold;
	baseAttk = initAttk;
	health = initHealth;
	levelExperience = levelExperience *(int)Math.pow(2, initLevel);
	agility = initAgility;
	intelligence = initIntelligence;
	strength = initStrength;
	defense = initDefense;
	precision = initPrecision;
	maxHealth = initMaxHealth;
	provideExperience = initPExperience;
    }



    //methods

    //set methods
    public void setStat(int[] stats) {
	level = stats[0];
	levelExperience = stats[1];
	health = stats[2];
	maxHealth = stats[3];
	gold = stats[4];
	baseAttk = stats[5];
	strength = stats[6];
	defense = stats[7];
	intelligence = stats[8];
	agility = stats[9];
	precision = stats[10];
    }

    //get methods
    public int getGold() {
	return gold;
    }
    public int getExp() {
	return experience;
    }
    public int getHealth() {
	return health;
    }
    public int getLevel() {
	return level;
    }
    public int getPExp() {
	return provideExperience;
    }
    public int[] getStat() {
	int[] statArray = {level, levelExperience, health, maxHealth, gold, baseAttk, strength, defense, intelligence, agility, precision};
	return statArray;
    }

    //Modifier methods
    public void buffHealth(int buff) {
	health+=buff;
    }
    public void gainExp(int gExp) {
	experience += gExp;
    }
    public void gainGold(int gGold) {
	gold += gGold;
    }
    public void levelUp() {
	if (experience >= levelExperience) {
	    level++;
	    experience = 0;
	    maxHealth+= level * maxHealth;
	    levelExperience = levelExperience * (int)Math.pow(2, level);
	}
    }

    //Action methods (Skills)
    public int attack(basicCharacter other, int modifier) {
	int multiplier = randInt.nextInt(3);
	other.health -= (baseAttk + strength) * multiplier + modifier;
	return (baseAttk + strength) * multiplier + modifier;
    }

    //Qualifier methods
    public boolean isDead() {
	return (health <= 0);
    }

    //toString
    public String toString() {
	return characterName;
    }

}

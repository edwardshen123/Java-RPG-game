public abstract class Entity {

    //Entity Characteristics
    private String Name;
    private String Race;
    private boolean isDead;
    //Entity Counters
    private int[] coolDown = {0, 0, 0, 0};
    //Entity Stats
    private int Level;
    private double Health;
    private double maxHealth;
    private double Strength;
    private double Defense;
    private double Agility;
    private double Intelligence;
    private double Precision;
    
    //Constructs an entity with a name and a type of either playerCharacter or nonplayerCharacter
    public Entity(String givenName, String givenRace) {
	this(givenName, givenRace, false, 1, new double[] {100.0, 100.0, 2.0, 2.0, 2.0, 2.0, 2.0});
    }
    public Entity(String givenName, String givenRace, int givenLevel) {
	this(givenName, givenRace, false, givenLevel, new double[] {100.0, 100.0, 2.0, 2.0, 2.0, 2.0, 2.0});
    }
    public Entity(String givenName, String givenRace, boolean givenIsDead, int givenLevel, double[] givenStats) {
	Name = givenName;
	Race = givenRace;
	isDead = givenIsDead;
	Level = givenLevel;
	Health = givenStats[0];
	maxHealth = givenStats[1];
	Strength = givenStats[2];
	Defense = givenStats[3];
	Agility = givenStats[4];
	Intelligence = givenStats[5];
	Precision = givenStats[6];
    }

    //Setters and Getters
    public double[] getStats() {
	double[] stats = {Health, maxHealth, Strength, Defense, Agility, Intelligence, Precision};
	return stats;
    }
    public void setStats(double[] givenStats) {
	Health = givenStats[0];
	maxHealth = givenStats[1];
	Strength = givenStats[2];
	Defense = givenStats[3];
	Agility = givenStats[4];
	Intelligence = givenStats[5];
	Precision = givenStats[6];
    }
    public String getRace() {
	return Race;
    }
    public boolean isDead() {
	return isDead;
    }
    public int[] getCoolDown() {
	return coolDown;
    }
    public void setCoolDown(int location, int value) {
	coolDown[location] = value;
    }
    public int getLevel() {
	return Level;
    }
    public void setLevel(int newLevel) {
	Level = newLevel;
    }
    public double getHealth() {
	return Health;
    }
    public void setHealth(double newHealth) {
	Health = newHealth;
	if (Health <= 0.0) {
	    isDead = true;
	}
    }
    public double getMaxHealth() {
	return maxHealth;
    }
    public double getStrength() {
	return Strength;
    }
    public double getDefense() {
	return Defense;
    }
    public double getAgility() {
	return Agility;
    }
    public double getIntelligence() {
	return Intelligence;
    }
    public double getPrecision() {
	return Precision;
    }

    //toString
    public String toString() {
	return Name;
    }
}

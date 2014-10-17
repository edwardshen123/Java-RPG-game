public class Entity {

    //Entity name
    private String Name;
    //Entity type classification (player or non-player)
    private String Type;
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
    public Entity(String givenName, String givenType) {
	this(givenName, givenType, 1, {100.0, 100.0, 2.0, 2.0, 2.0, 2.0, 2.0});
    }
    public Entity(String givenName, String givenType, int givenLevel) {
	this(givenName, givenType, givenLevel, {100.0, 100.0, 2.0, 2.0, 2.0, 2.0, 2.0});
    }
    public Entity(String givenName, String givenType, int givenLevel, double[] givenStats) {
	name = givenName;
	type = givenType;
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
	double [] stats = {Health, maxHealth, Strength, Defense, Agility, Intelligence, Precision};
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
    }
    public void getMaxHealth() {
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

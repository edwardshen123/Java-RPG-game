public class Entity {

    //Entity name
    private String Name;
    //Entity type classification (player or non-player)
    private String Type;
    //Entity Stats
    private int Level;
    private double Health;
    private double Strength;
    private double Defense;
    private double Agility;
    private double Intelligence;
    private double Precision;
    
    //Constructs an entity with a name and a type of either playerCharacter or nonplayerCharacter
    public Entity(String givenName, String givenType) {
	this(givenName, givenType, 1, {100.0, 2.0, 2.0, 2.0, 2.0, 2.0});
    }
    public Entity(String givenName, String givenType, int givenLevel, double[] givenStats) {
	name = givenName;
	type = givenType;
	Level = givenLevel;
	Health = givenStats[0];
	Strength = givenStats[1];
	Defense = givenStats[2];
	Agility = givenStats[3];
	Intelligence = givenStats[4];
	Precision = givenStats[5];
    }

    //Common Methods
    public double critical() {
	Random randDouble = new Random();
	double criticalMultiplier = (Precision / 100.0) + (randDouble.nextDouble(.99) + .02);
	return criticalMultiplier;
    }
    //Skills
    public String wildSwing(Entity other) {
	double damage = 5.0 + (Strength * 1.5);
	double totalDamage = damage * (1.0 + criticalMultiplier);
	other.Health -= totalDamage;
	return (this + " took a wild swing at " other + " for " + totalDamage + "damage");
    }
}

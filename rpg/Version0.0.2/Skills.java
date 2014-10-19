import java.util.Random;

public class Skills {

    private int Level;
    private String Race;
    private String Job;
    
    public Skills(int givenLevel, String givenRace, String givenJob) {
	Level = givenLevel;
	Race = givenRace;
	Job = givenJob;
    }


    //Common Methods
    public double criticalCalculator(Entity self) {
	Random randDouble = new Random();
	double criticalMultiplier = (self.getPrecision() / 100.0) + randDouble.nextDouble();
	return criticalMultiplier;
    }
    public void heal(Entity entity, double healing) {
	double healedHP = entity.getHealth() + healing;
	if (healedHP < entity.getMaxHealth()) {
	    entity.setHealth(healedHP);
	} else {
	    entity.setHealth(entity.getMaxHealth());
	}
    }

    //Skills
    public String wildSwing(Entity self, Entity other) {
	double damage = 5.0 + (self.getStrength() * 1.5);
	double totalDamage = damage * (1.0 + criticalCalculator(self));
	other.setHealth(other.getHealth() - totalDamage);
	return (self + " took a wild swing at " + other + " for " + totalDamage + "damage");
    }
    public Boolean run(Entity self, Entity other) {
	return (self.getAgility() > other.getAgility());
    }

    //Getters and Setters
    public String getSkillsList() {
	return "";
    }
}

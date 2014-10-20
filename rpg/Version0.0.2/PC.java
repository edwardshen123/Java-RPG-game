public class PC extends Entity {

    private int Exp;

    //Job Variables
    private String Job;
    private int Stamina;
    private int Mana;
    private boolean isStealth;
    private int stealthTimer;
    private int Faith;
    
    //Boost Variables
    private double healthPassiveBoost;
    private double strengthPassiveBoost;
    private double defensePassiveBoost;
    private double agilityPassiveBoost;
    private double intelligencePassiveBoost;
    private double precisionPassiveBoost;
    private double healthActiveBoost;
    private double strengthActiveBoost;
    private double defenseActiveBoost;
    private double agilityActiveBoost;
    private double intelligenceActiveBoost;
    private double precisionActiveBoost;

    public PC(String givenName, String givenRace, String givenJob) {
	super(givenName, givenRace);
	Job = givenJob;
    }

    public int getExp() {
	return Exp;
    }
    public String getJob() {
	return Job;
    }
    public int[] getEnergyValues() {
	int[] energies = {Stamina, Mana, stealthTimer, Faith};
	return energies;
    }
    public boolean isStealth() {
	return isStealth;
    }
    public double[] getPassiveBoosts() {
	double[] passives = {healthPassiveBoost, strengthPassiveBoost, defensePassiveBoost, agilityPassiveBoost, intelligencePassiveBoost, precisionPassiveBoost};
	return passives;
    }
    public double[] getActiveBoosts() {
	double[] actives = {healthActiveBoost, strengthActiveBoost, defenseActiveBoost, agilityActiveBoost, intelligenceActiveBoost, precisionActiveBoost};
	return actives;
    }
}
